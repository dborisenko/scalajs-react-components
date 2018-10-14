package com.dbrsn.scalajs.react.beautifuldnd

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.vdom.VdomNode
import japgolly.scalajs.react.{Callback, Children, JsComponent}

import scala.scalajs.js

final case class DndDragDropContext(
  onDragEnd: DropResult => Callback,
  onBeforeDragStart: js.UndefOr[DragStart => Callback] = js.undefined,
  onDragStart: js.UndefOr[DragStart => Callback] = js.undefined,
  onDragUpdate: js.UndefOr[DragUpdate => Callback] = js.undefined
) {

  /**
    * @param children Primary content.
    */
  def apply(children: VdomNode*): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[DndDragDropContext](this)
    val f = JsComponent[js.Object, Children.Varargs, Null](BeautifulDnd.DragDropContext)
    f(props)(children: _*)
  }
}
