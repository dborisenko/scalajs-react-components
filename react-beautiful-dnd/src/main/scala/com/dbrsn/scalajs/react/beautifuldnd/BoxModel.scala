package com.dbrsn.scalajs.react.beautifuldnd

import scala.scalajs.js

@js.native
trait Position extends js.Object {
  def x: Int = js.native
  def y: Int = js.native
}

@js.native
trait Rect extends js.Object {
  def top: Int = js.native
  def right: Int = js.native
  def bottom: Int = js.native
  def left: Int = js.native
  def width: Int = js.native
  def height: Int = js.native
  // DOMRect
  def x: Int = js.native
  def y: Int = js.native
  // Rect
  def center: Position = js.native
}

@js.native
trait Spacing extends js.Object {
  def top: Int = js.native
  def right: Int = js.native
  def bottom: Int = js.native
  def left: Int = js.native
}

@js.native
trait BoxModel extends js.Object {
  // content + padding + border + margin
  def marginBox: Rect = js.native
  // content + padding + border
  def borderBox: Rect = js.native
  // content + padding
  def paddingBox: Rect = js.native
  // content
  def contentBox: Rect = js.native
  // for your own consumption
  def border: Spacing = js.native
  def padding: Spacing = js.native
  def margin: Spacing = js.native
}
