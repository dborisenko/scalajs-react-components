package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.{DefaultNodeModel, DiagramEngine}
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js
import scala.scalajs.js.{undefined, UndefOr}

final case class DefaultNodeWidget(
  node: DefaultNodeModel,
  diagramEngine: DiagramEngine,
  className: UndefOr[String] = undefined,
  key: UndefOr[String] = undefined,
  extraProps: UndefOr[js.Object] = undefined
) {
  def apply(): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[DefaultNodeWidget](this)
    val f = JsComponent[js.Object, Children.None, Null](StormReactDiagrams.DefaultNodeWidget)
    f(props)
  }
}
