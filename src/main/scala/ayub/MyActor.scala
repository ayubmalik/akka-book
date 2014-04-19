package ayub

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorLogging
import akka.actor.ActorLogging
import java.util.logging.Logger

case class Message(msg: String)

class MyActor extends Actor with ActorLogging {

  def receive = {
    case Message(m) => log.info(s"got message {}", m)
  }
}

object MyActorMain {
  val log = Logger.getLogger("main")
  val system = ActorSystem("myActor")

  val actor = system.actorOf(Props[MyActor], "myActor")

  def main(args: Array[String]) {
    actor ! "hello"
    actor ! Message("poo")
    actor ! Message("hoo")
    actor ! Message("boo")
    system.shutdown
    
    
  }

}