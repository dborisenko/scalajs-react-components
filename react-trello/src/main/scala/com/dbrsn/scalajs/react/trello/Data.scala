package com.dbrsn.scalajs.react.trello

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

final class Card(
  val id: CardId,
  val title: String,
  val label: String,
  val description: String,
  val cardStyle: RawStyle,
  val metadata: Option[Metadata]
) extends js.Object

object Card {
  def apply(
    id: CardId,
    title: String,
    label: String,
    description: String,
    cardStyle: RawStyle,
    metadata: Option[Metadata] = None
  ): Card = new Card(id, title, label, description, cardStyle, metadata)
}

final class Data(
  val lanes: js.Array[Lane]
) extends js.Object

object Data {
  def apply(lanes: js.Array[Lane] = js.Array()): Data = new Data(lanes)
}
