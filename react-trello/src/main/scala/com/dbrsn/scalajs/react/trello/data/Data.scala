package com.dbrsn.scalajs.react.trello.data

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

@js.native
trait Data[Metadata] extends js.Object {
  def lanes: js.Array[Lane[Metadata]] = js.native
}

object Data {
  def apply[Metadata](lanes: Lane[Metadata]*): Data[Metadata] =
    js.Dynamic.literal(lanes = lanes.toJSArray).asInstanceOf[Data[Metadata]]
}
