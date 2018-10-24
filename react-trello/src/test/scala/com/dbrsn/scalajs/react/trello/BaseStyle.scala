package com.dbrsn.scalajs.react.trello

import com.dbrsn.scalajs.react.trello.data._
import scalacss.DevDefaults._

object BaseStyle extends StyleSheet.Inline {
  import dsl._
  val laneStyle: RawStyle = style(width(280.px)).style.toJsAny

  val boardContainer: StyleA = style("boardContainer")(backgroundColor.blue)

  val boardStyle: RawStyle = style(
    padding(30.px, 20.px),
    fontFamily :=! "Verdana"
  ).style.toJsAny
}
