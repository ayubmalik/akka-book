package zzz.akka.avionics

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

import Altimeter._

object AltimeterMain {
  val system = ActorSystem("altms")
  val actor = system.actorOf(Props[Altimeter], "altm")

  def main(args: Array[String]) {
    actor ! RateChange(0.5f)
    actor ! RateChange(0.55f)
    actor ! RateChange(0.555f)
    system.shutdown
  }

}