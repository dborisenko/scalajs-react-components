package com.dbrsn.scalajs.react.semanticui

import com.dbrsn.scalajs.react.semanticui.SuiSpec._
import japgolly.scalajs.react.vdom.Implicits._
import org.specs2.mutable.Specification

class SuiFlagSpec extends Specification {
  "TYPES" >> {
    "Flag: A flag can use the two digit country code, the full name, or a common alias." >> testExistenceW {
      SuiSegment()(
        SuiFlag(name = "ae")(),
        SuiFlag(name = "france")(),
        SuiFlag(name = "myanmar")()
      )
    }
  }
}
