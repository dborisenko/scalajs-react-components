package com.dbrsn.scalajs.react.syntax.highlighter

import japgolly.scalajs.react.test._
import japgolly.scalajs.react.vdom.html_<^._
import org.specs2.mutable.Specification

class PrismSyntaxHighlighterSpec extends Specification {
  "PrismSyntaxHighlighter should render code properly" >> {
    val rendered = ReactTestUtils.renderIntoDocument(
      statefulWrapper(
        PrismSyntaxHighlighter(PrismLanguage.javascript, style = PrismStyle.dark)("(num) => num + 1")
      )
    )
    val text = rendered.outerHtmlScrubbed()
    text must contain("(num) =&gt; num +")
  }
}
