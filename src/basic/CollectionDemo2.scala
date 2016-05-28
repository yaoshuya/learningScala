package basic

import scala.collection.mutable.ArrayBuffer

object CollectionDemo2 extends App {
  
  val intArray = new ArrayBuffer[Int]()
  import scala.util.Random
  for(i  <- 1 to 10)
    intArray += i
  println(intArray)
  
  println(intArray.slice(0, 5))
  println(intArray.slice(5,10))
  
   import scala.sys.process._
    //  "cat /tmp/test.txt" !;
    "echo abc yaoxiaohua yaoshuya everything is ok ok ok ok is yaoxiaohua abc" #> new java.io.File("/tmp/test.txt") !
    //  ;"cat /tmp/test.txt" !
    
    val wordFreq = new  scala.collection.mutable.HashMap[String,Int]()
    val in = new java.util.Scanner(new java.io.File("/tmp/test.txt"))
    while(in.hasNext()) 
    {
      val x = in.next
      //println(x);
     wordFreq(x) = wordFreq.getOrElse(x ,0) + 1
    }
    in.close()
    
    println(wordFreq)
    
 
}