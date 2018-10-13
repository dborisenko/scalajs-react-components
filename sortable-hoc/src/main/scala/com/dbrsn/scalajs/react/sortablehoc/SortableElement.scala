package com.dbrsn.scalajs.react.sortablehoc

import japgolly.scalajs.react.component.Generic.ComponentRaw
import japgolly.scalajs.react.{Children, JsComponent}

import scala.language.higherKinds
import scala.scalajs.js

/**
  * A facade to SortableElement of https://github.com/clauderic/react-sortable-hoc
  */
object SortableElement {

  @js.native
  trait Props extends js.Object {
    def index: Int = js.native
    def collection: Int = js.native
    def disabled: Boolean = js.native
  }

  object Props {
    def apply(
      index: Int,
      collection: Int = 0,
      disabled: Boolean = false
    ): Props =
      js.Dynamic.literal(index = index, collection = collection, disabled = disabled).asInstanceOf[Props]
  }

  /**
    * @param wrappedComponent The wrapped component itself
    * @tparam P The type of Props of the wrapped component
    * @return A component wrapping the wrapped component...
    */
  def apply[P, CT[_, _]](wrappedComponent: ComponentRaw#Raw): Props => P => JsComponent.Unmounted[js.Object, Null] = {
    props => wrappedProps =>
      {
        val reactElement = SortableHOC.SortableElement(wrappedComponent)
        val component = JsComponent[js.Object, Children.None, Null](reactElement)
        val mergedProps = js.Dynamic.literal()
        mergedProps.updateDynamic("index")(props.index)
        mergedProps.updateDynamic("collection")(props.collection)
        mergedProps.updateDynamic("disabled")(props.disabled)
        mergedProps.updateDynamic("a")(wrappedProps.asInstanceOf[js.Any])
        component(mergedProps.asInstanceOf[js.Object])
      }
  }
}
