package com.dbrsn.scalajs.react.trello.data

import scala.scalajs.js

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
