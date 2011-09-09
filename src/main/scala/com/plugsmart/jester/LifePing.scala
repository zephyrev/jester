package com.plugsmart.jester

import akka.actor.{FSM, Actor}
import akka.event.EventHandler


sealed trait ActiveState

case object ActivePing extends ActiveState

case object InactivePing extends ActiveState

case object Activate

case object Inactivate

class LifePing extends Actor with FSM[ActiveState, Unit] {

  import FSM._

  startWith(InactivePing, Unit)

  when(InactivePing) {
    case Ev(Activate) =>
      EventHandler.info(this, "transition to active ping")
      goto(ActivePing)
  }

  when(ActivePing) {
    case Ev(Inactivate) =>
      EventHandler.info(this, "transsition to inactive")
      goto(ActivePing)
  }

  initialize // this checks validity of the initial state and sets up timeout if needed

}