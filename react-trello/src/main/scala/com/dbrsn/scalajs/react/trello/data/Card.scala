package com.dbrsn.scalajs.react.trello.data

import scalacss.internal.StyleS

import scala.scalajs.js

final class Card[Metadata](
  val id: CardId,
  val title: String,
  val label: String,
  val description: String,
  val cardStyle: RawStyle,
  val metadata: Option[Metadata]
) extends js.Object

object Card {
  def apply[Metadata](
    id: CardId,
    title: String,
    label: String,
    description: String,
    cardStyle: StyleS = StyleS.empty,
    metadata: Option[Metadata] = None
  ): Card[Metadata] = new Card[Metadata](id, title, label, description, cardStyle.toJsAny, metadata)
}
