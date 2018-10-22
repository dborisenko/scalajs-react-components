package com.dbrsn.scalajs.react.trello.data

import scalacss.internal.StyleS

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

final class Lane[Metadata](
  val id: LaneId,
  val title: String,
  val label: String,
  val style: RawStyle,
  val cards: js.Array[Card[Metadata]],
  val droppable: Boolean
) extends js.Object

object Lane {
  def apply[Metadata](
    id: LaneId,
    title: String,
    label: String,
    style: StyleS = StyleS.empty,
    droppable: Boolean = true
  )(
    cards: Card[Metadata]*
  ): Lane[Metadata] = new Lane[Metadata](id, title, label, style.toJsAny, cards.toJSArray, droppable)
}
