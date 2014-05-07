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

object TestFlightAttendant {
  def apply() = new FlightAttendant with AttendantResponsiveness {
    val maxResponseTimeMS = 1
  }
}

class FlightAttendantSpec extends TestKit(ActorSystem("EventSourceSpec"))
  with ImplicitSender
  with WordSpecLike
  with Matchers {
  import FlightAttendant._

  "FlightAttendant" should {
    "get drink when asked" in {
      val attendant = TestActorRef(Props(TestFlightAttendant()))
      attendant ! GetDrink("Soda")
      expectMsg(Drink("Soda"))
    }
  }

}