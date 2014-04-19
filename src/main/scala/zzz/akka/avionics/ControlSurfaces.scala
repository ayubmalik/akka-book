package zzz.akka.avionics

import akka.actor.{ Actor, ActorLogging, ActorSystem, Props }
import scala.concurrent.duration._
import akka.actor.ActorRef

object ControlSurfaces {
  case class StickBack(amount: Float)
  case class StickForward(amount: Float)
}
class ControlSurfaces(altimeter: ActorRef) extends Actor {
  import Altimeter._
  import ControlSurfaces._

  def receive = {

    case StickBack(amount) =>
      altimeter ! RateChange(amount)

    case StickForward(amount) =>
      altimeter ! RateChange(-1 * amount)
  }

}