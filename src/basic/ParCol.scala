package basic

import scala.collection.parallel.immutable.ParVector

object ParCol extends App {
  val v = Vector.range(1,20,2)
  v.foreach(print)
  v.par.foreach(print)
  val v2 =ParVector.range(1,20)
  v2.foreach(print)
 
  
}