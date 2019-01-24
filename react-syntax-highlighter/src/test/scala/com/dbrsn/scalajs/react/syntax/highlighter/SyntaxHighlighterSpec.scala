package com.dbrsn.scalajs.react.syntax.highlighter

import japgolly.scalajs.react.test._
import japgolly.scalajs.react.vdom.html_<^._
import org.specs2.mutable.Specification

class SyntaxHighlighterSpec extends Specification {
  "SyntaxHighlighter should render code properly" >> {
    val rendered = ReactTestUtils.renderIntoDocument(
      statefulWrapper(
        SyntaxHighlighter(HljsLanguage.javascript, style = HljsStyle.docco)("(num) => num + 112571")
      )
    )
    val text = rendered.outerHtmlScrubbed()
    text must contain("112571")
  }
}
