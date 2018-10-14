package com.dbrsn.scalajs.react.beautifuldnd

import scala.scalajs.js

@js.native
trait DragStart extends js.Object {
  def draggableId: DraggableId = js.native
  def `type`: TypeId = js.native
  def source: DraggableLocation = js.native
}

@js.native
trait DragUpdate extends js.Object {
  def draggableId: DraggableId = js.native
  def `type`: TypeId = js.native
  def source: DraggableLocation = js.native
  def destination: DraggableLocation = js.native
}

@js.native
trait DropResult extends js.Object {
  def draggableId: DraggableId = js.native
  def `type`: TypeId = js.native
  def source: DraggableLocation = js.native
  def destination: DraggableLocation = js.native
  def reason: DropReason = js.native
}

@js.native
trait DraggableLocation extends js.Object {
  def droppableId: DroppableId = js.native
  def index: Int = js.native
}

final case class DropReason private (value: String) extends AnyVal

object DropReason {
  val drop: DropReason = DropReason("DROP")
  val cancel: DropReason = DropReason("CANCEL")
}
