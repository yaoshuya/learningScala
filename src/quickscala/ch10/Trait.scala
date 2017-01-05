package quickscala.ch10

//特质可以同时拥有抽象方法和具体的方法
//类似于JAVA中的接口的功能

 
trait logger{
  def log(msg:String) //this is a abstract method
  
}

trait  TimestampLogger extends logger {
 abstract override def log(msg:String){  // you must add abstract before the override keyword, because logger's log is abstract
    super.log(new java.util.Date() + " " + msg)
  }
}

//自身类型 this:Type => 如果特质以这样的代码开始定义时，它就是自身类型，它只能被混入TYPE类型的类
trait LoggerException extends logger {
  this:Exception =>
    def log() {log(getMessage())}
}

trait LoggerException2 extends logger{
  this: {def getMessage():String } =>
    def log() { log(getMessage())}
}

class ConsoleLogger extends logger {
  def log(msg:String) { println(msg) } // not need override 重写抽象方法时不需要加override
  
}

