package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.{BaseAction, DiagramEngine}
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js
import scala.scalajs.js.{undefined, UndefOr}

final case class DiagramWidget(
  diagramEngine: DiagramEngine,
  allowLooseLinks: UndefOr[Boolean] = undefined,
  allowCanvasTranslation: UndefOr[Boolean] = undefined,
  allowCanvasZoom: UndefOr[Boolean] = undefined,
  inverseZoom: UndefOr[Boolean] = undefined,
  maxNumberPointsPerLink: UndefOr[Int] = undefined,
  smartRouting: UndefOr[Boolean] = undefined,
  actionStartedFiring: UndefOr[BaseAction => Boolean] = undefined,
  actionStillFiring: UndefOr[BaseAction => Unit] = undefined,
  actionStoppedFiring: UndefOr[BaseAction => Unit] = undefined,
  deleteKeys: UndefOr[js.Array[Int]] = undefined,
  className: UndefOr[String] = undefined,
  key: UndefOr[String] = undefined,
  extraProps: UndefOr[js.Object] = undefined
) {
  def apply(): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {
    val props = JSMacro[DiagramWidget](this)
    val f = JsComponent[js.Object, Children.None, Null](StormReactDiagrams.DiagramWidget)
    f(props)
  }
}
