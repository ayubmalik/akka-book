package zzz.akka.avionics

import org.scalatest.BeforeAndAfterAll
import org.scalatest.Finders
import org.scalatest.Matchers
import org.scalatest.WordSpecLike
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.testkit.TestKit
import akka.testkit.TestProbe
import akka.testkit.TestActorRef
import akka.testkit.TestActor
import akka.testkit.ImplicitSender
import com.typesafe.config.ConfigFactory

object TestFlightAttendant {
  def apply() = new FlightAttendant with AttendantResponsiveness {
    val maxResponseTimeMS = 1
  }
}

class FlightAttendantSpec extends TestKit(ActorSystem("EventSourceSpec", ConfigFactory.parseString("akka.scheduler.tick-duration=10ms")))
  with ImplicitSender
  with WordSpecLike
  with Matchers {
  import FlightAttendant._

  "FlightAttendant" should {
    "get drink when asked" in {
      val attendant = TestActorRef(Props(TestFlightAttendant()))
      val start = System.currentTimeMillis
      attendant ! GetDrink("Soda")
      expectMsg(Drink("Soda"))
      val end = System.currentTimeMillis - start
      println(s"took $end ms")
    }
  }

}