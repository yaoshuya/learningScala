package basic

import java.io.PrintWriter

object IoDemo extends App {
  val filepath = "/tmp/test.txt"
  writeDemo(filepath)
  scala.io.Source.fromFile(filepath).getLines().foreach { 
    println
  }
  
  def writeDemo(filepath:String)
  {
    val writer = new PrintWriter(filepath)
    writer.write("hello scala, hello world \n")
    writer.write("hello feifei, hello huahua \n")
    writer.close()
  }
}