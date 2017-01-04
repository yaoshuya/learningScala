package quickscala.ch6

///  JAVA/C++  我们通常会遇到既有静态方法同时又有实例方法的类，在SCALA 中 
///  我们可以使用类和同名的伴生类来达到这样的目的， 它们必须放置在同一个源文件中
class Account {
  val id = Account.newUniqueNumber()
  private var balance=0.0
  def deposit(amount :Double) : Account = { balance += amount; this}
  
  def Balance = { balance }
}

object Account {
  private var lastNumber = 0
  private def newUniqueNumber() = { lastNumber +=1; lastNumber }
  
  def apply() : Account ={
    new Account()
  }
  
  def apply(initialBalance:Double):Account ={
    new Account().deposit(initialBalance)
  }
}