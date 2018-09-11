package com.dbrsn.scalajs.react.semanticui

import java.util.UUID

import com.dbrsn.scalajs.react.semanticui.SuiSpec._
import japgolly.scalajs.react.test._
import japgolly.scalajs.react.vdom.Implicits._
import japgolly.scalajs.react.vdom.html_<^.{< => tg}
import org.specs2.matcher.MatchResult
import org.specs2.mutable.Specification

class SuiContainerSpec extends Specification {
  private def testText[M](unmounted: String => UnmountedDef): MatchResult[String] = {
    val token: String = UUID.randomUUID().toString
    val rendered = ReactTestUtils.renderIntoDocument(
      unmounted(testPhrase(token))
    )
    rendered.outerHtmlScrubbed() must contain(token)
  }

  "TYPES" >> {
    "Container: A standard container." >> {
      testText(txt => SuiContainer()(tg.p(txt)))
    }
    "Text Container: A container can reduce its maximum width to more naturally accommodate a single column of text." >> {
      testText(txt => SuiContainer(text = true)(SuiHeader(as = "h2")("Header"), tg.p(txt)))
    }
  }
  "VARIATIONS" >> {
    "Text Alignment: A container can specify its text alignment." >> {
      testText(SuiContainer(textAlign = SuiTextAlignment.left)(_)) and
        testText(SuiContainer(textAlign = SuiTextAlignment.center)(_)) and
        testText(SuiContainer(textAlign = SuiTextAlignment.right)(_)) and
        testText(SuiContainer(textAlign = SuiTextAlignment.justified)(tg.b("Justified"), SuiDivider()(), _))
    }
    "Fluid: A fluid container has no maximum width." >> {
      testText(txt => SuiContainer(fluid = true)(SuiHeader(as = "h2")("Header"), tg.p(txt)))
    }
  }
}
