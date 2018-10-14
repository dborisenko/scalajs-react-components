package com.dbrsn.scalajs.react.beautifuldnd
import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.raw.React.Node
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js

@js.native
trait DroppableProps extends js.Object {
  def `data-react-beautiful-dnd-droppable`: String
}

@js.native
trait DroppableProvided extends js.Object {
  def innerRef: js.UndefOr[HTMLElement] => Callback = js.native
  def placeholder: js.UndefOr[Node] = js.native
  def droppableProps: DroppableProps = js.native
}

@js.native
trait DroppableStateSnapshot extends js.Object {
  def isDraggingOver: Boolean = js.native
  def draggingOverWith: js.UndefOr[DraggableId] = js.native
}

final case class Direction private (value: String) extends AnyVal

object Direction {
  val horizontal: Direction = Direction("horizontal")
  val vertical: Direction = Direction("vertical")
}
