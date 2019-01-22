package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.BaseListener
import japgolly.scalajs.react.Callback

import scala.scalajs.js

trait SelectionData extends js.Object {
  def isSelected: Boolean
}

trait SelectionListener extends js.Object {
  val selectionChanged: js.Function1[SelectionData, Unit]
}

object SelectionListener {
  def apply(onSelectionChanged: SelectionData => Callback): BaseListener =
    js.use(new SelectionListener {
        val selectionChanged: js.Function1[SelectionData, Unit] = onSelectionChanged(_).runNow()
      })
      .as[BaseListener]
}
