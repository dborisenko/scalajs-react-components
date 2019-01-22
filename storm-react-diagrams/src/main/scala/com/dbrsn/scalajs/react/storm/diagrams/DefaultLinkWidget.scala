package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.{DefaultLinkModel, DiagramEngine, PointModel}
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.{Children, JsComponent}
import org.scalajs.dom.MouseEvent

import scala.scalajs.js
import scala.scalajs.js.{undefined, UndefOr}

final case class DefaultLinkWidget(
  link: DefaultLinkModel,
  diagramEngine: DiagramEngine,
  color: UndefOr[String] = undefined,
  width: UndefOr[Int] = undefined,
  smooth: UndefOr[Boolean] = undefined,
  pointAdded: UndefOr[(PointModel, MouseEvent) => Any] = undefined,
  className: UndefOr[String] = undefined,
  key: js.UndefOr[String] = undefined
) {
  def apply(): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[DefaultLinkWidget](this)
    val f = JsComponent[js.Object, Children.None, Null](StormReactDiagrams.DefaultLinkWidget)
    f(props)
  }
}
