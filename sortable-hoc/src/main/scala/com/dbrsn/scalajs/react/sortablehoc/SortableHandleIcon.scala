package com.dbrsn.scalajs.react.sortablehoc

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Js.Unmounted
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

/**
  * An icon to be used as handle for reordering lists or tables
  */
object SortableHandleIcon {

  import japgolly.scalajs.react.vdom.SvgAttrs._
  import japgolly.scalajs.react.vdom.SvgTags._

  final val HandleClassName: String = "react-sortable-handle"
  final val DefaultColor: String = "#A0A0A0"
  final val DefaultHeight: Int = 15

  final case class Props(
    handleClassName: String = HandleClassName,
    color: String = DefaultColor,
    height: Int = DefaultHeight
  )

  // scalastyle:off line.size.limit
  private val handleGrip = ScalaComponent
    .builder[Props]("HandleGrip")
    .render_P { p =>
      svg(
        ^.className := p.handleClassName,
        viewBox := "0 0 24 24",
        fill := p.color,
        height := p.height,
        path(
          d := "M9,8c1.1,0,2-0.9,2-2s-0.9-2-2-2S7,4.9,7,6S7.9,8,9,8z M9,10c-1.1,0-2,0.9-2,2s0.9,2,2,2s2-0.9,2-2S10.1,10,9,10z M9,16c-1.1,0-2,0.9-2,2s0.9,2,2,2s2-0.9,2-2S10.1,16,9,16z"
        ),
        path(
          d := "M15,8c1.1,0,2-0.9,2-2s-0.9-2-2-2s-2,0.9-2,2S13.9,8,15,8z M15,10c-1.1,0-2,0.9-2,2s0.9,2,2,2s2-0.9,2-2S16.1,10,15,10z M15,16c-1.1,0-2,0.9-2,2s0.9,2,2,2s2-0.9,2-2S16.1,16,15,16z"
        )
      )
    }
    .build
  // scalastyle:on line.size.limit

  def handleWithProps(props: Props): Unmounted[js.Object, Null] = SortableHandle(handleGrip)(props)

  val handle: Unmounted[js.Object, Null] = handleWithProps(Props())

}
