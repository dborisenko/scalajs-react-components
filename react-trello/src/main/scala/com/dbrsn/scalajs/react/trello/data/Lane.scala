package com.dbrsn.scalajs.react.trello.data

import scalacss.internal.StyleS

import scala.scalajs.js
import scala.scalajs.js.UndefOr

@js.native
trait Lane[Metadata] extends js.Object {
  def id: LaneId = js.native
  def title: String = js.native
  def label: String = js.native
  def style: UndefOr[RawStyle] = js.native
  def cards: js.Array[Card[Metadata]] = js.native
  def droppable: Boolean = js.native
}

object Lane {
  def apply[Metadata](
    id: LaneId,
    title: String,
    label: String = "",
    style: UndefOr[RawStyle] = js.undefined,
    droppable: Boolean = true
  )(
    cards: Card[Metadata]*
  ): Lane[Metadata] =
    js.Dynamic
      .literal(
        id = id,
        title = title,
        label = label,
        style = style,
        droppable = droppable
      )
      .asInstanceOf[Lane[Metadata]]

  def styled[Metadata](
    id: LaneId,
    title: String,
    label: String = "",
    style: UndefOr[StyleS] = js.undefined,
    droppable: Boolean = true
  )(
    cards: Card[Metadata]*
  ): Lane[Metadata] =
    apply(
      id = id,
      title = title,
      label = label,
      style = style.map(_.toJsAny),
      droppable = droppable
    )(cards: _*)
}
