package com.dbrsn.scalajs.react.beautifuldnd

import japgolly.scalajs.react.Callback
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.{DragEvent, KeyboardEvent, MouseEvent, TouchEvent}

import scala.scalajs.js

@js.native
trait DraggableStateSnapshot extends js.Object {
  def isDragging: Boolean = js.native
  def isDropAnimating: Boolean = js.native
  def draggingOver: js.UndefOr[DroppableId] = js.native
}

@js.native
trait DraggableProps extends js.Object {
  //  def style: js.UndefOr[DraggableStyle] = js.native
  def `data-react-beautiful-dnd-draggable`: String = js.native
}

@js.native
trait DragHandleProps extends js.Object {
  // If a consumer is using a portal then the item will loose focus
  // when moving to the portal. This breaks keyboard dragging.
  // To get around this we manually apply focus if needed when mounting
  def onFocus: () => Callback = js.native
  def onBlur: () => Callback = js.native

  // Used to initiate dragging
  def onMouseDown: MouseEvent => Callback = js.native
  def onKeyDown: KeyboardEvent => Callback = js.native
  def onTouchStart: TouchEvent => Callback = js.native

  // Control styling from style marshal
  def `data-react-beautiful-dnd-drag-handle`: String = js.native

  // Aria role (nicer screen reader text)
  def `aria-roledescription`: String = js.native

  // Allow tabbing to this element
  def tabIndex: Int = js.native

  // Stop html5 drag and drop
  def draggable: Boolean = js.native
  def onDragStart: DragEvent => Callback = js.native
}

@js.native
trait DraggableProvided extends js.Object {
  def draggableProps: DraggableProps = js.native
  def dragHandleProps: DragHandleProps = js.native
  def innerRef: js.UndefOr[HTMLElement] => Callback = js.native
}

@js.native
trait DraggableDescriptor extends js.Object {
  def id: DraggableId = js.native
  def index: Int = js.native
  // Inherited from Droppable
  def droppableId: DroppableId = js.native
  // This is technically redundant but it avoids
  // needing to look up a parent droppable just to get its type
  def `type`: TypeId = js.native
}

@js.native
trait Placeholder extends js.Object {
  def client: BoxModel = js.native
  def tagName: String = js.native
  def display: String = js.native
}

@js.native
trait DraggableDimension extends js.Object {
  def descriptor: DraggableDescriptor = js.native
  // the placeholder for the draggable
  def placeholder: Placeholder = js.native
  // relative to the viewport when the drag started
  def client: BoxModel = js.native
  // relative to the whole page
  def page: BoxModel = js.native
}
