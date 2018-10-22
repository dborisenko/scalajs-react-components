package com.dbrsn.scalajs.react.trello

import com.dbrsn.scalajs.react.trello.data.Tag.@@
import scalacss.internal.StyleS

import scala.scalajs.js

package object data {
  type RawAction = js.Object
  type RawStyle = js.Any

  object RawStyle {
    def empty: RawStyle = new js.Object()
  }

  type BoardId = String @@ BoardId.Tag
  type CardId = String @@ CardId.Tag
  type LaneId = String @@ LaneId.Tag

  type SourceLaneId = LaneId
  type TargetLaneId = LaneId

  final def styleS2JsAny(style: StyleS): js.Any = {
    val result = js.Dictionary.empty[String]
    style.data.values.flatMap(_.avIterator).foreach { property =>
      // Map CSS property name to react style naming convention.
      // For example: padding-top => paddingTop
      val propertyName = property.attr.id.split("-") match {
        case Array(head, other @ _*) => head + other.map(_.capitalize).mkString
      }
      result(propertyName) = property.value
    }
    result
  }

  implicit class StyleSOps(val style: StyleS) extends AnyVal {
    def toJsAny: js.Any = styleS2JsAny(style)
  }
}
