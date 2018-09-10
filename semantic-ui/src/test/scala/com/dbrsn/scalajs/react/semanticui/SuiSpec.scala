package com.dbrsn.scalajs.react.semanticui

import japgolly.scalajs.react.test._
import japgolly.scalajs.react._
import org.specs2.mutable.Specification

import scala.language.existentials

class SuiSpec extends Specification {
  "SuiButton should work" >> {
    val clicked = ReactTestVar(false)
    val rendered = ReactTestUtils.renderIntoDocument(
      SuiButton(
        label = "Test Button",
        onSubmit = (_: ReactEventFromInput) => clicked.setStateFn(true)
      )())
    val element = ReactTestUtils.findRenderedDOMComponentWithTag(rendered, "button")
    Simulate.submit(element.getDOMNode.asElement)
    (rendered.outerHtmlScrubbed() must contain("Test Button")) and (clicked.value() must_=== true)
  }
}
