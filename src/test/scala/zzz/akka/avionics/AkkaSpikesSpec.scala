package zzz.akka.avionics

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.future

import org.scalatest.BeforeAndAfterAll
import org.scalatest.Finders
import org.scalatest.WordSpecLike

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import akka.testkit.TestKit
import akka.testkit.TestLatch
import akka.testkit.TestProbe

class MyActor extends Actor with ActorLogging {
  def receive = {
    case msg @ _ =>
      log.info("Got msg: " + msg)
      sender ! "hello"
  }
}

class AkkaSpikesSpec extends TestKit(ActorSystem("FirstSpec"))
  with WordSpecLike
  with BeforeAndAfterAll {

  override def afterAll() = system.shutdown

  "Get " should {
    
    "path info for user guardian" in {
       val a1 = system.actorOf(Props[MyActor])
       println(a1.path)
       println(a1.path.elements)
       println(a1.path.name)
    }

  }
}