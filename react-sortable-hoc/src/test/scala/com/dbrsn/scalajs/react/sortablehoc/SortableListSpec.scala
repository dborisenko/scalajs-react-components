package com.dbrsn.scalajs.react.sortablehoc

import java.util.UUID

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Generic.ComponentRaw
import japgolly.scalajs.react.test._
import japgolly.scalajs.react.vdom.Implicits._
import japgolly.scalajs.react.vdom.html_<^.<.div
import org.specs2.mutable.Specification

class SortableListSpec extends Specification {

  case class Model(text: String)
  case class Props(model: Model)

  private val testComponent = ScalaComponent
    .builder[Props]("TestComponent")
    .render_P(p => div(p.model.text))
    .build

  "Sortable list must be rendered" >> {
    val text1 = UUID.randomUUID().toString
    val text2 = UUID.randomUUID().toString
    val raw: ComponentRaw#Raw = testComponent.raw
    val rendered = ReactTestUtils.renderIntoDocument(
      SortableList[Model, Props]
        .Props(
          listToDisplay = List(Model(text1), Model(text2)),
          sortableContainerProps = SortableContainer.Props(),
          externalProps = Props,
          itemComponent = raw
        )
        .render
    )
    val text = rendered.outerHtmlScrubbed()
    (text must contain(text1)) and (text must contain(text2))
  }
}
