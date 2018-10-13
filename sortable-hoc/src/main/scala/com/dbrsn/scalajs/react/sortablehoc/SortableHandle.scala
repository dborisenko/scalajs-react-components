package com.dbrsn.scalajs.react.sortablehoc

import japgolly.scalajs.react._

import scala.language.higherKinds
import scala.scalajs.js

/**
  * Wrap the SortableHOC.SortableHandle
  */
object SortableHandle {

  /**
    * @param wrappedComponent The wrapped component itself
    * @tparam P The type of Props of the wrapped component
    * @return A component wrapping the wrapped component
    */
  def apply[P, CT[_, _]](wrappedComponent: GenericComponent[P, CT, _]): P => JsComponent.Unmounted[js.Object, Null] = {
    wrappedProps =>
      {
        val reactElement = SortableHOC.SortableHandle(wrappedComponent.raw)
        val component = JsComponent[js.Object, Children.None, Null](reactElement)
        val mergedProps = js.Dynamic.literal()
        mergedProps.updateDynamic("a")(wrappedProps.asInstanceOf[js.Any])
        component(mergedProps.asInstanceOf[js.Object])
      }
  }
}
