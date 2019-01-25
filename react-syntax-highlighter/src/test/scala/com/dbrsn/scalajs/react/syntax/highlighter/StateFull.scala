package com.dbrsn.scalajs.react.syntax.highlighter
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.VdomElement

object StateFull {
  private val StateFullComponent = ScalaComponent
    .builder[VdomElement]("StateFullComponent")
    .initialState("Hello, world!")
    .render_P(identity)
    .build

  /**
    * Due to this feature of react test:
    * > Render a ReactElement into the DOM in the supplied container and return a reference to the component
    * > (or returns null for stateless components).
    * We always need to have stateful component, otherwise we have raw element equals to `null` after rendering.
    *
    * @see https://github.com/facebook/react/issues/5455
    */
  def statefulWrapper(element: VdomElement): Unmounted[VdomElement, String, Unit] =
    StateFullComponent(element)
}
