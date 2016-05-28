package Akka

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorSystem

class SimpleActor  extends Actor {
  def receive: Actor.Receive = {
    case "hello" => println("hello back!")
    case _ => println("aha")
  }
}

class SimpleActor2(name : String) extends Actor {

  def receive: PartialFunction[Any, Unit] = {
    case "hello" => println(s"hello from $name")
    case x:Any => println(s"$x from $name ")
  }
  
}

object Main extends App
{
  // ActorSystem is a heavy object: create only one per application
  val system = ActorSystem("SimpleAkka")
  //create and start the actor
  val helloactor = system.actorOf(Props[SimpleActor],name = "hello")
  
  helloactor ! "hello"
  helloactor ! "test"
  
  val ha2 = system.actorOf(Props(new SimpleActor2("abc")), name = "hello2")
   ha2 ! "hello"
   ha2 ! "where are you from ?"
   ha2 ! "I missing you, baby!"
  
  system.shutdown
}
