package com.dbrsn.scalajs.react.semanticui

import java.util.UUID

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.test._
import japgolly.scalajs.react.vdom.VdomElement
import org.specs2.matcher.MatchResult
import org.specs2.matcher.MustMatchers._

import scala.language.existentials

object SuiSpec {
  private def testPhrase(token: String): String =
    s"Lorem ipsum dolor sit amet, $token consectetuer adipiscing elit."

  private final val StateFullComponent = ScalaComponent
    .builder[VdomElement]("StateFullComponent")
    .initialState(42)
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
  def statefulWrapper(element: VdomElement): Unmounted[VdomElement, Int, Unit] =
    StateFullComponent(element)

  def testTextAndClick(unmounted: (String, Callback) => VdomElement): MatchResult[Any] = {
    val token: String = UUID.randomUUID().toString
    val clicked = ReactTestVar(false)
    val rendered = ReactTestUtils.renderIntoDocument(
      unmounted(testPhrase(token), clicked.setStateFn(true))
    )
    val element = ReactTestUtils.findRenderedDOMComponentWithTag(rendered, "button")
    Simulate.click(element.getDOMNode.asElement)
    (rendered.outerHtmlScrubbed() must contain(token)) and (clicked.value() must_=== true)
  }

  def testTextW(unmounted: String => VdomElement): MatchResult[String] = {
    val token: String = UUID.randomUUID().toString
    val rendered = ReactTestUtils.renderIntoDocument(
      statefulWrapper(unmounted(testPhrase(token)))
    )
    rendered.outerHtmlScrubbed() must contain(token)
  }

  def testExistenceW(unmounted: => VdomElement): MatchResult[String] = {
    val rendered = ReactTestUtils.renderIntoDocument(
      statefulWrapper(unmounted)
    )
    rendered.outerHtmlScrubbed() must not be empty
  }

}
