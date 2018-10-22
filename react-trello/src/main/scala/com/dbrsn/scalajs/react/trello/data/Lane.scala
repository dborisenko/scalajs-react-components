package com.dbrsn.scalajs.react.trello.data

import scalacss.internal.StyleS

import scala.scalajs.js

final class Lane(
  val id: LaneId,
  val title: String,
  val label: String,
  val style: RawStyle,
  val cards: js.Array[Card],
  val droppable: Boolean
) extends js.Object

object Lane {
  def apply(
    id: LaneId,
    title: String,
    label: String,
    style: StyleS = StyleS.empty,
    cards: js.Array[Card] = js.Array(),
    droppable: Boolean = true
  ): Lane = new Lane(id, title, label, style.toJsAny, cards, droppable)
}
