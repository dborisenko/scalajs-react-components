package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.DefaultPortModel
import japgolly.scalajs.react.component.Js.Unmounted
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js

object StormDefaultPortLabel {

  @js.native
  trait Props extends js.Object {
    var model: DefaultPortModel
    var key: String

    @inline def render: JsComponent.Unmounted[js.Object, js.Object] = apply(this)
  }

  object Props {
    def apply(model: DefaultPortModel, key: String): Props =
      js.Dynamic.literal(model = model, key = key).asInstanceOf[Props]
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
