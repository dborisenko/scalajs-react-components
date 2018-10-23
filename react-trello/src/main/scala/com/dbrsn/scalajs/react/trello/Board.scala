package com.dbrsn.scalajs.react.trello

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import com.dbrsn.scalajs.react.trello.data._
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.{Callback, Children, JsComponent}
import scalacss.internal.StyleS

import scala.scalajs.js

final case class Board[Metadata](
  id: js.UndefOr[BoardId] = js.undefined,
  actions: js.UndefOr[RawAction] = js.undefined,
  data: Data[Metadata],
  reducerData: js.UndefOr[Data[Metadata]] = js.undefined,
  onDataChange: js.UndefOr[Data[Metadata] => Callback] = js.undefined,
  eventBusHandle: js.UndefOr[js.Any => Callback] = js.undefined,
  onLaneScroll: js.UndefOr[(Int, LaneId) => Callback] = js.undefined,
  onCardClick: js.UndefOr[(CardId, Metadata, LaneId) => Callback] = js.undefined,
  onCardDelete: js.UndefOr[(CardId, LaneId) => Callback] = js.undefined,
  onCardAdd: js.UndefOr[(Card[Metadata], LaneId) => Callback] = js.undefined,
  addCardLink: js.UndefOr[Element] = js.undefined,
  onLaneClick: js.UndefOr[LaneId => Callback] = js.undefined,
  laneSortFunction: js.UndefOr[(Card[Metadata], Card[Metadata]) => Callback] = js.undefined,
  draggable: js.UndefOr[Boolean] = js.undefined,
  collapsibleLanes: js.UndefOr[Boolean] = js.undefined,
  editable: js.UndefOr[Boolean] = js.undefined,
  hideCardDeleteIcon: js.UndefOr[Boolean] = js.undefined,
  handleDragStart: js.UndefOr[(CardId, LaneId) => Callback] = js.undefined,
  handleDragEnd: js.UndefOr[(CardId, SourceLaneId, TargetLaneId, Int) => Callback] = js.undefined,
  handleLaneDragStart: js.UndefOr[LaneId => Callback] = js.undefined,
  handleLaneDragEnd: js.UndefOr[(LaneId, Int) => Callback] = js.undefined,
  customCardLayout: js.UndefOr[Boolean] = js.undefined,
  customLaneHeader: js.UndefOr[Element] = js.undefined,
  style: js.UndefOr[RawStyle] = js.undefined,
  tagStyle: js.UndefOr[RawStyle] = js.undefined,
  laneDraggable: js.UndefOr[Boolean] = js.undefined,
  cardDraggable: js.UndefOr[Boolean] = js.undefined,
  cardDragClass: js.UndefOr[String] = js.undefined,
  laneDragClass: js.UndefOr[String] = js.undefined,
  addLaneTitle: js.UndefOr[String] = js.undefined,
  addCardTitle: js.UndefOr[String] = js.undefined,
  newLaneTemplate: js.UndefOr[Element] = js.undefined
) {

  def withStyle(style: StyleS): Board[Metadata] = copy(style = style.toJsAny)
  def withTagStyle(style: StyleS): Board[Metadata] = copy(tagStyle = style.toJsAny)

  def apply(): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[Board[Metadata]](this)
    val f = JsComponent[js.Object, Children.None, Null](ReactTrello.Board)
    f(props)
  }
}
