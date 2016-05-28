package basic

import scala.collection.parallel.immutable.ParVector

object CollectionDemo extends App {
   val iseq = IndexedSeq(1,2,3,4,5)
   println(iseq(1))
   val seq = Seq(1,2,3)
   println(seq(0))
   
   var map = Map[String,String]()
   map = Map[String,String]("abc" -> "ABC")
   
   val m2 = Map((1,"first"),(2,"second"),(3,"third"))
   m2.foreach(println)
   
   val l = List(1, 2, 3, 4, 5).view.map( _ + 1)
   println(l)
   println(l.head)
   val l2 =List(1,2,3,4,5).map(_+1)
   println(l2)
   
   val l3 = List("zero", "one", "two", "three", "four",
    "five").zip(Stream.from(0))
    println(l3)
    
   def fib(n : Int) :Int  = n match {
     case 0 => 0
     case 1 => 1
     case n => fib(n-1) + fib(n-2)
  }
   
   for(i<-Range(1,10))
     println(fib(i))
     
   ParVector(10, 20, 30, 40, 50, 60, 70, 80, 90).foldLeft(0) {
     (a,x) =>
      println(Thread.currentThread.getName); a + x }

     var imhm = new  scala.collection.immutable.HashMap[Int,String]
     
}

