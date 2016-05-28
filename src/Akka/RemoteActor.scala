package Akka

import akka.actor.{Actor,ActorSystem,Props}

 case class Message(message:String)

 case class Command(cmd :String)
 object HelloRemote extends App {  
      val system = ActorSystem("HelloRemoteSystem")  
      val remoteActor = system.actorOf(Props[RemoteActor], name = "RemoteActor")  
      println(s"the path of the remoteActor is ${remoteActor.path}")
      remoteActor ! Message("The RemoteActor is alive")  
    }  
      
    class RemoteActor extends Actor {  
      def receive = {  
        case Message(msg) =>  
          println(s"RemoteActor received message '$msg'")
          sender ! Message("Hello from the RemoteActor")
          
        case _ =>  
          println("RemoteActor got something unexpected.")  
      }  
    }  
    
      