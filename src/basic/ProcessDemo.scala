package basic
import scala.sys.process._

class ProcessDemo {
  
  def executeCmd(cmd:String):String = {
      try{ 
       if(cmd.contains("#|")) {

          val cmds = cmd.split("#\\|")
          
          cmds.length match {
            case 2 => 
                cmds(0).trim  #| cmds(1).trim !!
            case 3 => 
                cmds(0).trim  #| cmds(1).trim  #| cmds(2).trim !!
            case 4 =>
                 cmds(0).trim #| cmds(1).trim #| cmds(2).trim #| cmds(3).trim !! 
            case _ => "not support now more suppport 3 #| "
          }
           
       }
          else  cmd.!!
      }catch{ case ex:Exception => ex.getMessage }
  }
  
}

object ProcessDemo extends App {
  println("hello scala.sys.process")
  println("run short cut is shift alt x s")
  
  val pdemo = new ProcessDemo()
   
  
  ;"echo you can do everything better than you think " ! 
  ;"ls ." !
  
  var go = true;
  while(go)
  {
    val cmd = Console.readLine()
    if(cmd.equals("stop")) go = false
    else
    println(pdemo.executeCmd(cmd))
  }
   
}