package com.dbrsn.scalajs.react.beautifuldnd

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js

final case class DndDraggable(
  isDragging: Boolean = false,
  /** whether or not a drag movement should be animated used for dropping and keyboard dragging */
  shouldAnimateDragMovement: Boolean = false,
  /**
    * when an item is being displaced by a dragging item, we need to know if that movement should be animated
    * This is set to true by default so that as soon as Draggable
    * needs to be displaced it can without needing to change this flag
    */
  shouldAnimateDisplacement: Boolean = true,
  isDropAnimating: Boolean = false,
  offset: Position,
  /** only provided when dragging **/
  dimension: js.UndefOr[DraggableDimension] = js.undefined,
  draggingOver: js.UndefOr[DroppableId] = js.undefined,
  draggableId: DraggableId,
  children: (DraggableProvided, DraggableStateSnapshot) => js.UndefOr[Node] = (_, _) => js.undefined,
  index: Int,
  isDragDisabled: Boolean = false,
  disableInteractiveElementBlocking: Boolean = false
) {
  def apply(): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[DndDraggable](this)
    val f = JsComponent[js.Object, Children.None, Null](BeautifulDnd.DragDropContext)
    f(props)
  }
}
