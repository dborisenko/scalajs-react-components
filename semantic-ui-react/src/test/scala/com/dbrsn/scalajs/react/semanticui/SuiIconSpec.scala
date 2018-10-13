package com.dbrsn.scalajs.react.semanticui

import com.dbrsn.scalajs.react.semanticui.SuiSpec._
import japgolly.scalajs.react.vdom.Implicits._
import japgolly.scalajs.react.vdom.html_<^.{< => tg}
import org.specs2.mutable.Specification

class SuiIconSpec extends Specification {
  "STATES" >> {
    "Disabled: An icon can show that it is disabled." >>
      testExistenceW(SuiIcon(disabled = true, name = SuiIconType("users"))())
    "Loading: An icon can be used as a simple loader." >> testExistenceW(
      tg.div(
        SuiIcon(loading = true, name = SuiIconType("spinner"))(),
        SuiIcon(loading = true, name = SuiIconType("certificate"))(),
        SuiIcon(loading = true, name = SuiIconType("asterisk"))()
      )
    )
  }
}
