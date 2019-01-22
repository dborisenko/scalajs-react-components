package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.PortModel
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js

object StormDefaultPortLabel {

  @js.native
  trait Props extends js.Object {
    def model: PortModel
    def key: String
  }

  object Props {
    def apply(model: PortModel, key: String): Props =
      js.Dynamic.literal(model = model, key = key).asInstanceOf[Props]
  }

  implicit class PropsOps(val props: Props) extends AnyVal {
    @inline def render: JsComponent.Unmounted[js.Object, js.Object] = apply(props)
  }

  def apply(props: Props): JsComponent.Unmounted[js.Object, js.Object] = {
    val reactElement = StormReactDiagrams.DefaultPortLabel
    val component = JsComponent[js.Object, Children.None, js.Object](reactElement)
    val mergedProps = js.Dynamic.literal()
    mergedProps.updateDynamic("model")(props.model)
    mergedProps.updateDynamic("key")(props.key)
    component(mergedProps.asInstanceOf[js.Object])
  }
}
