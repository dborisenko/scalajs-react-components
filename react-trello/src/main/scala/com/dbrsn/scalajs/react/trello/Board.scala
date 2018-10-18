package com.dbrsn.scalajs.react.trello

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.raw.React.{Element, Node}
import japgolly.scalajs.react.vdom.VdomNode
import japgolly.scalajs.react.{Callback, Children, JsComponent}

import scala.scalajs.js

final case class Board(
  id: js.UndefOr[String] = js.undefined,
  actions: js.UndefOr[Action] = js.undefined,
  data: Data,
  reducerData: js.UndefOr[Data] = js.undefined,
  onDataChange: js.UndefOr[() => Callback] = js.undefined,
  eventBusHandle: js.UndefOr[() => Callback] = js.undefined,
  onLaneScroll: js.UndefOr[() => Callback] = js.undefined,
  onCardClick: js.UndefOr[() => Callback] = js.undefined,
  onCardDelete: js.UndefOr[() => Callback] = js.undefined,
  onCardAdd: js.UndefOr[() => Callback] = js.undefined,
  addCardLink: js.UndefOr[Node] = js.undefined,
  onLaneClick: js.UndefOr[() => Callback] = js.undefined,
  laneSortFunction: js.UndefOr[() => Callback] = js.undefined,
  draggable: js.UndefOr[Boolean] = js.undefined,
  collapsibleLanes: js.UndefOr[Boolean] = js.undefined,
  editable: js.UndefOr[Boolean] = js.undefined,
  hideCardDeleteIcon: js.UndefOr[Boolean] = js.undefined,
  handleDragStart: js.UndefOr[() => Callback] = js.undefined,
  handleDragEnd: js.UndefOr[() => Callback] = js.undefined,
  handleLaneDragStart: js.UndefOr[() => Callback] = js.undefined,
  handleLaneDragEnd: js.UndefOr[() => Callback] = js.undefined,
  customCardLayout: js.UndefOr[Boolean] = js.undefined,
  customLaneHeader: js.UndefOr[Element] = js.undefined,
  style: js.UndefOr[Style] = js.undefined,
  tagStyle: js.UndefOr[Style] = js.undefined,
  laneDraggable: js.UndefOr[Boolean] = js.undefined,
  cardDraggable: js.UndefOr[Boolean] = js.undefined,
  cardDragClass: js.UndefOr[String] = js.undefined,
  laneDragClass: js.UndefOr[String] = js.undefined,
  addLaneTitle: js.UndefOr[String] = js.undefined,
  addCardTitle: js.UndefOr[String] = js.undefined,
  newLaneTemplate: js.UndefOr[Node] = js.undefined
) {
  def apply(children: VdomNode*): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[Board](this)
    val f = JsComponent[js.Object, Children.Varargs, Null](ReactTrello.Board)
    f(props)(children: _*)
  }
}
