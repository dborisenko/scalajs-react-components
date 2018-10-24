package com.dbrsn.scalajs.react.trello.data

import scalacss.internal.StyleS

import scala.scalajs.js
import scala.scalajs.js.UndefOr

@js.native
trait Card[Metadata] extends js.Object {
  def id: CardId = js.native
  def title: String = js.native
  def label: String = js.native
  def description: String = js.native
  def cardStyle: UndefOr[RawStyle] = js.native
  def metadata: UndefOr[Metadata] = js.native
}

object Card {
  def apply[Metadata <: js.Any](
    id: CardId,
    title: String,
    label: String = "",
    description: String = "",
    cardStyle: UndefOr[RawStyle] = js.undefined,
    metadata: UndefOr[Metadata] = js.undefined
  ): Card[Metadata] =
    js.Dynamic
      .literal(
        id = id,
        title = title,
        label = label,
        description = description,
        cardStyle = cardStyle,
        metadata = metadata
      )
      .asInstanceOf[Card[Metadata]]

  def styled[Metadata <: js.Any](
    id: CardId,
    title: String,
    label: String = "",
    description: String = "",
    cardStyle: UndefOr[StyleS],
    metadata: UndefOr[Metadata] = js.undefined
  ): Card[Metadata] = apply[Metadata](
    id = id,
    title = title,
    label = label,
    description = description,
    cardStyle = cardStyle.map(_.toJsAny),
    metadata = metadata
  )
}
