package zzz.akka.avionics

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.Props
import akka.actor.actorRef2Scala

object Plane {
  case object GiveMeControl
}

class Plane extends Actor with ActorLogging {
  import Altimeter._
  import Plane._
  import EventSource._

  val altimeter = context.actorOf(Props[Altimeter], "Altimeter")
  val controls = context.actorOf(Props(new ControlSurfaces(altimeter)), "ControlSurfaces")

  override def preStart = {
    altimeter ! RegisterListener(self)
  }

  def receive = {
    case Plane.GiveMeControl =>
      log.info("plane giving control")
      sender ! controls
    case AltitudeUpdate(altitude) =>
      log.info(s"plane altitude is $altitude")
  }
}