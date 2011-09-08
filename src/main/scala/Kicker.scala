package com.plugsmart.jester

import akka.actor.{ActorRef, Actor}

object Kicker extends App {

  val charger: ActorRef = Actor.actorOf[SimpleCharger].start
  charger ! "1"

  Thread.sleep(10)
}