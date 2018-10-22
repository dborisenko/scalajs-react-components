package com.dbrsn.scalajs.react.trello.data

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

final class Data[Metadata](
  val lanes: js.Array[Lane[Metadata]]
) extends js.Object

object Data {
  def apply[Metadata](lanes: Lane[Metadata]*): Data[Metadata] = new Data[Metadata](lanes.toJSArray)
}
