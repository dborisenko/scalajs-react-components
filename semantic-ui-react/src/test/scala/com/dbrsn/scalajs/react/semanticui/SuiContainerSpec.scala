package com.dbrsn.scalajs.react.semanticui

import com.dbrsn.scalajs.react.semanticui.SuiSpec._
import japgolly.scalajs.react.vdom.Implicits._
import japgolly.scalajs.react.vdom.html_<^.{< => tg}
import org.specs2.mutable.Specification

class SuiContainerSpec extends Specification {
  "TYPES" >> {
    "Container: A standard container." >>
      testTextW(txt => SuiContainer()(tg.p(txt)))
    "Text Container: A container can reduce its maximum width to more naturally accommodate a single column of text." >>
      testTextW(txt => SuiContainer(text = true)(SuiHeader(as = "h2")("Header"), tg.p(txt)))
  }
  "VARIATIONS" >> {
    "Text Alignment: A container can specify its text alignment." >> {
      testTextW(SuiContainer(textAlign = SuiTextAlignment.left)(_)) and
        testTextW(SuiContainer(textAlign = SuiTextAlignment.center)(_)) and
        testTextW(SuiContainer(textAlign = SuiTextAlignment.right)(_)) and
        testTextW(SuiContainer(textAlign = SuiTextAlignment.justified)(tg.b("Justified"), SuiDivider()(), _))
    }
    "Fluid: A fluid container has no maximum width." >>
      testTextW(txt => SuiContainer(fluid = true)(SuiHeader(as = "h2")("Header"), tg.p(txt)))
  }
}
