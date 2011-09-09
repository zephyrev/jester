package com.plugsmart.jester

/**
 * Created by IntelliJ IDEA.
 * User: johan
 * Date: 9/9/11
 * Time: 7:07 AM
 * To change this template use File | Settings | File Templates.
 */

class KickCharger {

}

package com.plugsmart.jester

import akka.actor.{ActorRef, Actor}

object Kicker extends App {

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