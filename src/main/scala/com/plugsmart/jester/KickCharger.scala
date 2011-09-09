package com.plugsmart.jester

import akka.actor.{Actor, ActorRef}

object KickCharger extends App {

  val charger: ActorRef = Actor.actorOf[SimpleCharger].start

  println( "Registered Chargers: " + Actor.registry.actors + "\n\n" )

  println("Charger>> plug in")
  charger !! Plugin

  println("Charger>> charge")
  charger !! Charge

  println("Charger>> plug out")
  charger !! Plugout

  println("Charger>> switch off")
  charger !! Deenergize

  Thread.sleep(10)
  Actor.registry.shutdownAll()
}