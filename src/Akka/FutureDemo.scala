package Akka

import scala.concurrent.{Await,Future}
import scala.concurrent.duration._
//the following simply import the thread pool 
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success,Failure}

object FutureDemo extends App {

  def fib(n:Int) : Int =
  {
    n match{
    case 0 => 1
    case 1 => 1
    case _ => fib(n-1) + fib(n-2)
    }
  }
  
  implicit val basetime = System.currentTimeMillis()
  
  val f = Future {   
    //Thread.sleep(500)
    fib(20)
  }
  
  val res = Await.result(f, 100 second)
  println(res)
  
   f.onComplete {
    case Success(value) => println(s"Got the callback, meaning = $value")
    case Failure(e) => e.printStackTrace
    }
   
  
  Thread.sleep(1000)
  
}
