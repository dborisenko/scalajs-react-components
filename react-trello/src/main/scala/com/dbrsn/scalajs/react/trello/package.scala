package com.dbrsn.scalajs.react

import scalacss.internal.StyleS

import scala.scalajs.js

package object trello {
  type RawAction = js.Object
  type RawStyle = js.Any

  object RawStyle {
    def empty: RawStyle = new js.Object()
  }

  type BoardId = String
  type CardId = String
  type LaneId = String

  type SourceLaneId = LaneId
  type TargetLaneId = LaneId

  type Tag = js.Object
  type Metadata = js.Object

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
