package com.dbrsn.scalajs.react.markdown

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.test.{ReactTestUtils, _}
import japgolly.scalajs.react.vdom.VdomElement
import org.specs2.mutable.Specification

class ReactMarkdownSpec extends Specification {

  private val StateFullComponent = ScalaComponent
    .builder[VdomElement]("StateFullComponent")
    .initialState("Hello, world!")
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
  def statefulWrapper(element: VdomElement): Unmounted[VdomElement, String, Unit] =
    StateFullComponent(element)

  "ReactMarkdown should render from source" >> {
    val rendered = ReactTestUtils.renderIntoDocument(
      statefulWrapper(
        ReactMarkdown(source = "# This is a header\n\nAnd this is a paragraph")().vdomElement
      )
    )
    val text = rendered.outerHtmlScrubbed()
    println(text)
    text must contain("This is a header")
  }
}
