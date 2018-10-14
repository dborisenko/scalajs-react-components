package com.dbrsn.scalajs.react.beautifuldnd

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import japgolly.scalajs.react.{Children, JsComponent}
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.raw.React.Node

import scala.scalajs.js

final case class DndDroppable(
  children: (DroppableProvided, DroppableStateSnapshot) => js.UndefOr[Node],
  droppableId: DroppableId,
  `type`: TypeId,
  isDropDisabled: Boolean,
  direction: Direction,
  ignoreContainerClipping: Boolean,
) {
  def apply(): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[DndDroppable](this)
    val f = JsComponent[js.Object, Children.None, Null](BeautifulDnd.Droppable)
    f(props)
  }
}
