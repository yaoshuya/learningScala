package quickscala.ch2$5

object CommonDS extends App {
  
  val s = Array("hello","world")
  println(s(0))
  
  s(0)="abc"
  println(s(0))
  
  val a1 = new Array[String](10)
  a1.foreach(println) //implicit convert to ArrayOPs
  a1(0)="abc"
  a1(2)="xyz"
  
  println( a1 ++: "abc") //Vector(abc, null, xyz, null, null, null, null, null, null, null, a, b, c)
   
  println(a1.mkString(","))

  
  val m1 = Map("a"->0, "b"->1)
   
  m1.foreach(println)  
  val m2 =  scala.collection.mutable.Map("a"->0,"b"->1)
  m2("a")=2
  
  println(m2.getOrElse("c", 0))
  m2 += ("d"->3)
  m2 ++= Map("e"->4)
  println(m2)
   
  val a2 = (1 to 10).toArray
  println(a2.sum)
  println(a2.foldLeft(100)(_-_))
  println(a2.foldRight(1)(_*_))
  
  
}