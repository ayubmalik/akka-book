package zzz.akka.avionics

import akka.actor.ActorSystem
import akka.testkit.TestKit
import org.scalatest.FunSuite
import akka.actor.Actor
import org.scalatest.BeforeAndAfterAll
import org.scalatest.WordSpec
import org.scalatest.WordSpecLike
import akka.testkit.TestProbe
import akka.actor.Props
import akka.actor.ActorLogging

class FirstActor extends Actor with ActorLogging {
  def receive = {
    case msg @ _ =>
      log.info("Got msg: " + msg)
      sender ! "hello"
  }
}

class Spike {
  println("spike init")
  def hello() = println("hello")
}

class FirstTestSpec extends TestKit(ActorSystem("FirstTest"))
  with WordSpecLike
  with BeforeAndAfterAll {

  override def afterAll() = system.shutdown

  "actor" should {

    "reply with hello" in {

      val probe = TestProbe()
      val first = system.actorOf(Props[FirstActor])
      probe.send(first, "ping")
      probe.expectMsg("hello")

    }
    
     "example " in new Spike {
    	hello
        hello
    }

    "example 1" in new Spike {
    	hello
    	override def hello = println("meh")
        hello
    }

  }

}