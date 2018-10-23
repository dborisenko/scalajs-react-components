package com.dbrsn.scalajs.react.trello.data

import scalacss.internal.StyleS

import scala.scalajs.js
import scala.scalajs.js.UndefOr

final class Card[Metadata](
  val id: CardId,
  val title: String,
  val label: String,
  val description: String,
  val cardStyle: UndefOr[RawStyle],
  val metadata: UndefOr[Metadata]
) extends js.Object

object Card {
  def apply[Metadata](
    id: CardId,
    title: String,
    label: String = "",
    description: String = "",
    cardStyle: UndefOr[StyleS] = js.undefined,
    metadata: UndefOr[Metadata] = js.undefined
  ): Card[Metadata] = new Card[Metadata](id, title, label, description, cardStyle.map(_.toJsAny), metadata)
}
