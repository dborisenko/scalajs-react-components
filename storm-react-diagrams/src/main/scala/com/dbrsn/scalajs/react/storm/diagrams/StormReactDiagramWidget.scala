package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.DiagramEngine
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js

object StormReactDiagramWidget {

  @js.native
  trait Props extends js.Object {
    def diagramEngine: DiagramEngine = js.native
    def className: js.UndefOr[String] = js.native
  }

  object Props {
    def apply(diagramEngine: DiagramEngine, className: js.UndefOr[String] = js.undefined): Props =
      js.Dynamic.literal(diagramEngine = diagramEngine, className = className).asInstanceOf[Props]
  }

  implicit class PropsOps(val props: Props) extends AnyVal {
    @inline def render: JsComponent.Unmounted[js.Object, js.Object] = apply(props)
  }

  def apply(props: Props): JsComponent.Unmounted[js.Object, js.Object] = {
    val reactElement = StormReactDiagrams.DiagramWidget
    val component = JsComponent[js.Object, Children.None, js.Object](reactElement)
    val mergedProps = js.Dynamic.literal()
    mergedProps.updateDynamic("diagramEngine")(props.diagramEngine)
    component(mergedProps.asInstanceOf[js.Object])
  }
}
