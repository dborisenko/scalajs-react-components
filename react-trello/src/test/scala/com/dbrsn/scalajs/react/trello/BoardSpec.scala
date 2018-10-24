package com.dbrsn.scalajs.react.trello

import java.util.UUID

import com.dbrsn.scalajs.react.trello.BaseData.baseData
import com.dbrsn.scalajs.react.trello.data._
import japgolly.scalajs.react.test._
import japgolly.scalajs.react.{Callback, ScalaComponent}
import org.specs2.mutable.Specification

import scala.scalajs.js

class BoardSpec extends Specification {

  "Basic Functions" >> {
    "Full Board example" >> {
      val token = UUID.randomUUID().toString
      val rendered = ReactTestUtils.renderIntoDocument(
        Board(data = baseData(token))()
      )
      rendered.outerHtmlScrubbed() must contain(token)
    }
  }

  "Advanced Features" >> {
    "Async Load data" >> {
      case class State(boardData: Data[js.Object])

      val token = UUID.randomUUID().toString
      val component = ScalaComponent
        .builder[Unit]("AsyncBoard")
        .initialState(State(Data()))
        .render_S(s => Board(data = s.boardData)().vdomElement)
        .componentWillMount(_.modState(_ => State(baseData(token))))
        .build

      val rendered = ReactTestUtils.renderIntoDocument(
        component()
      )
      rendered.outerHtmlScrubbed() must contain(token)
    }

    "Board Styling" >> {
      val token = UUID.randomUUID().toString
      val rendered = ReactTestUtils.renderIntoDocument(
        Board(
          data = baseData(token),
          style = BaseStyle.boardStyle,
          className = BaseStyle.boardContainer.className.value
        )()
      )
      rendered.outerHtmlScrubbed() must contain(token)
    }

    "Collapsible Lanes" >> {
      val token = UUID.randomUUID().toString

      def shouldReceiveNewData(nextData: Data[js.Object]): Callback =
        Callback.log("data has changed") >> Callback.log(s"next data: $nextData")

      val rendered = ReactTestUtils.renderIntoDocument(
        Board(
          data = baseData(token),
          draggable = true,
          collapsibleLanes = true,
          onDataChange = shouldReceiveNewData _
        )()
      )
      rendered.outerHtmlScrubbed() must contain(token)
    }
  }
}
