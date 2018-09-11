package com.dbrsn.scalajs.react.semanticui
import japgolly.scalajs.react.component.Js
import japgolly.scalajs.react.component.Js.{MountedWithRawType, RawMounted}

import scala.scalajs.js

object SuiSpec {
  private[semanticui] type UnmountedDef =
    Js.UnmountedSimple[js.Object, MountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]]]

  private[semanticui] def testPhrase(token: String): String =
    s"Lorem ipsum dolor sit amet, $token consectetuer adipiscing elit."

}
