package com.dbrsn.scalajs.react.semanticui

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.component.Js
import japgolly.scalajs.react.component.Js.{MountedWithRawType, RawMounted}
import japgolly.scalajs.react.component.Scala.Unmounted

import scala.scalajs.js

object SuiSpec {
  private[semanticui] type UnmountedDef =
    Js.UnmountedSimple[js.Object, MountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]]]

  private[semanticui] def testPhrase(token: String): String =
    s"Lorem ipsum dolor sit amet, $token consectetuer adipiscing elit."

  private final val StateFullComponent = ScalaComponent
    .builder[UnmountedDef]("StateFullComponent")
    .initialState(42)
    .render_P(_.vdomElement)
    .build

  /**
    * Due to this feature of react test:
    * > Render a ReactElement into the DOM in the supplied container and return a reference to the component
    * > (or returns null for stateless components).
    * We always need to have stateful component, otherwise we have raw element equals to `null` after rendering.
    *
    * @see https://github.com/facebook/react/issues/5455
    */
  def statefulWrapper(element: UnmountedDef): Unmounted[UnmountedDef, Int, Unit] = StateFullComponent(element)
}
