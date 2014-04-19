package zzz.akka.avionics

import scala.concurrent.duration._

object Altimeter {

  case class RateChange(amount: Float)

}