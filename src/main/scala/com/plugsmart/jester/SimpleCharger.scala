package com.plugsmart.jester


import akka.actor.{Actor, FSM}
import akka.event.EventHandler
import akka.util.duration._

case object Plugin
case object Plugout
case object Charge
case object Deenergize

sealed trait ChargerState
case object Idle extends ChargerState
case object Plugged extends ChargerState
case object Charging extends ChargerState

class SimpleCharger extends Actor with FSM[ChargerState, Unit] {

  import FSM._

  startWith(Idle, Unit)

  when( Idle ) {
    case Ev(Plugin) =>
      EventHandler.info(this, "Go to Plugged")
      goto( Charging )
    case Ev( Deenergize ) =>
      EventHandler.info(this, "Go to Plugged")
      stop
  }

  when( Plugged ) {
    case Ev( Charge ) =>
      EventHandler.info(this, "Moving to Charging")
      goto( Charging )
  }

  when( Charging ) {
    case Ev( Plugout ) =>
      EventHandler.info(this, "EV unpluged end session")
      goto( Idle )
  }

  initialize // this checks validity of the initial state and sets up timeout if needed
  println("Simple Charger Initialized")
}