package quickscala.ch6

object driver extends App {
  
  println("chapter 6 is coming")
  
  val t = 1
  
  t match {
    case 0 => //for compobj demo
      {
        val a1 = new Account()
        println(a1.id)
        a1.deposit(100)
        println(a1.Balance)
        
        val a2 = Account(10)
        println(a2.id)
        println(a2.Balance)
        
        println(args.length)
      }
    case 1 => //for enumeration demo
      {
         println(TrafficLightColor.Green)
         println(TrafficLightColor.Green.id)
         println(TrafficLightColor.Green.toString())
         
      }
    case _ =>
      println("go")
      
  }
  
  
}