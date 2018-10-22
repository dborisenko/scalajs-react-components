package com.dbrsn.scalajs.react.trello.data

import scala.scalajs.js

final class Data(
  val lanes: js.Array[Lane]
) extends js.Object

object Data {
  def apply(lanes: js.Array[Lane] = js.Array()): Data = new Data(lanes)
}
