package basic

import scala.beans.BeanProperty

class Person{
  //scala类对每一个字段才附生成get set方法 如foo 会生成foo(get) foo_(get)
  //对于不指定val,var的字段，默认是私有的，类本身是公开的
  
  println("the current thread is initiallize a Person instance")
  @BeanProperty var name:String = _
  @BeanProperty var age :Int    = _
  
  def this(_name:String) 
  { 
    this()
    this.name = _name 
  }
  def this(_name:String,_age :Int)
  {
    this()
    this.name = _name
    this.age  = _age
  }
  
  override def toString() :String = {
    "Person name:" + this.name + " age:" + this.age
  }
}


object ClassDemo extends App {
  val p  = new Person("studentyao",30)
  val p2 = new Person
  p2.setAge(20)
  p2.setName("studentzhang")
  val p3 = new Person("studentwang")
  println(p)
  println(p2)
  println(p3)
  
  
}








