package Akka

import akka.actor.{Actor,ActorSystem,Props,ActorRef}
 
//这个世界上最危险的,不是那些邪恶的人,而是那些无动于衷的人.--爱因斯坦

case class TaskMessage(val messageType:Int,val message:Any)
case class MapTaskMessage(val reducer:ActorRef, val message:Any)

class MapTask extends Actor {
  
  def receive: PartialFunction[Any, Unit] = {
    case mtm:MapTaskMessage => {
       val res = mtm.message.asInstanceOf[List[Int]].sum
       println(s"${Thread.currentThread().getName} finished map task ! sum is: $res")
       mtm.reducer ! TaskMessage(2,res)
       context.stop(self)
    }
    case any => println("do nothing !")
  }
}

class ReduceTask extends Actor {
  var  taskNum  = 0
  var  _taskNum = 0
  var  sum      = 0 
  var  length   = 0
  
   def receive: PartialFunction[Any, Unit] = {
      case tm:TaskMessage =>
        {
           tm.messageType match {
           case 1 =>
            taskNum = tm.message.toString().toInt
            println(s"task number for reduce task is $taskNum")
           case 2 =>
           { 
             sum += tm.message.toString().toInt
            _taskNum += 1 
            if (taskNum == _taskNum) println(s"the average value is ${sum*1.0/length}")
          }
           case 3 =>
             {
               length = tm.message.toString().toInt
               println(s"the number of array is $length")
             }
        }
           }
      case any   => println("nothing not handle")
    }
  }
  object MapReduceTask  extends App { 
    
   import scala.util.Random
   var intArray  = Vector.range(1,100).par.map { x => Random.nextInt(100) }.toList
   
   //println(s"Total: $intArray" )
   val l = intArray.filter { x => x%3 == 0 }
   val m = intArray.filter { x => x%3 == 1 }
   val r = intArray.filter { x => x%3 == 2 }
   
    val system = ActorSystem("MapReduceTaskDemo") 
    
    val mapTask1 = system.actorOf(Props[MapTask],name="maptask1")
    val mapTask2 = system.actorOf(Props[MapTask],name="maptask2")
    val mapTask3 = system.actorOf(Props[MapTask],name="maptask3")
    
    val reduceTask =  system.actorOf(Props[ReduceTask],name="reducetask")
    reduceTask ! TaskMessage(3,intArray.length)  
    reduceTask ! TaskMessage(1,3)
  
    
    mapTask1 ! MapTaskMessage(reduceTask,l)
    mapTask2 ! MapTaskMessage(reduceTask,m)
    mapTask3 ! MapTaskMessage(reduceTask,r)
   
  system.shutdown()
  
}