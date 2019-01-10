package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.DiagramEngine
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js

object StormReactDiagramWidget {

  @js.native
  trait Props extends js.Object {
    var diagramEngine: DiagramEngine = js.native

    @inline def render: JsComponent.Unmounted[js.Object, js.Object] = apply(this)
  }

  object Props {
    def apply(diagramEngine: DiagramEngine): Props =
      js.Dynamic.literal(diagramEngine = diagramEngine).asInstanceOf[Props]
  }

  def apply(props: Props): JsComponent.Unmounted[js.Object, js.Object] = {
    val reactElement = StormReactDiagrams.DiagramWidget
    val component = JsComponent[js.Object, Children.None, js.Object](reactElement)
    val mergedProps = js.Dynamic.literal()
    mergedProps.updateDynamic("diagramEngine")(props.diagramEngine)
    component(mergedProps.asInstanceOf[js.Object])
  }
}
