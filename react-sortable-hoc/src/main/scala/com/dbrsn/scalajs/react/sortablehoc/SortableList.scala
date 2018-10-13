package com.dbrsn.scalajs.react.sortablehoc

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Generic.ComponentRaw
import japgolly.scalajs.react.component.Js.Unmounted
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

/**
  * A convenience interface around SortableHOC where you can just supply your list that you want to display
  */
class SortableList[Element, ExternalProps] {

  case class Props(
    listToDisplay: List[Element],
    sortableContainerProps: SortableContainer.Props,
    externalProps: Element => ExternalProps,
    componentToDisplay: ComponentRaw#Raw,
    itemRenderer: Seq[TagMod] => TagMod = tags => <.li(tags: _*),
    listRenderer: Seq[TagMod] => VdomElement = list => <.ul(list: _*),
    handle: Unmounted[js.Object, Null] = SortableHandleIcon.handle
  )

  private def render(props: Props): VdomElement = {
    val list: Seq[TagMod] = props.listToDisplay.zipWithIndex.map {
      case (value, index) =>
        val item = SortableElement(props.componentToDisplay)(SortableElement.Props(index = index))(
          props.externalProps(value)
        )()
        props.itemRenderer(Seq(props.handle, item))
    }
    props.listRenderer(list)
  }

  private val component = ScalaComponent
    .builder[Props]("SortableList")
    .render_P(render)
    .build

  def apply(props: Props): Unmounted[js.Object, Null] =
    SortableContainer(component)(props.sortableContainerProps)(props)
}
