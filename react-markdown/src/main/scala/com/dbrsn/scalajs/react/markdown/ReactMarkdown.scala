package com.dbrsn.scalajs.react.markdown

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js
import scala.scalajs.js.{|, undefined, Array, Function, UndefOr}

final case class ReactMarkdown(
  source: String,
  className: UndefOr[String] = undefined,
  sourcePos: UndefOr[Boolean] = undefined,
  rawSourcePos: UndefOr[Boolean] = undefined,
  escapeHtml: UndefOr[Boolean] = undefined,
  skipHtml: UndefOr[Boolean] = undefined,
  allowNode: UndefOr[Function] = undefined,
  transformLinkUri: UndefOr[Function | Boolean] = undefined,
  linkTarget: UndefOr[Function | String] = undefined,
  transformImageUri: UndefOr[Function] = undefined,
  astPlugins: UndefOr[Array[Function]] = undefined,
  unwrapDisallowed: UndefOr[Boolean] = undefined
) {
  def apply(): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[ReactMarkdown](this)
    val f = JsComponent[js.Object, Children.None, Null](ReactMarkdownRaw.ReactMarkdown)
    f(props)
  }
}
