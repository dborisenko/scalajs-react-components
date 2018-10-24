package com.dbrsn.scalajs.react.trello

import java.util.UUID

import com.dbrsn.scalajs.react.trello.data._
import japgolly.scalajs.react.test._
import org.specs2.mutable.Specification
import scalacss.DevDefaults._

import scala.scalajs.js

class BoardSpec extends Specification {

  private object Style extends StyleSheet.Inline {
    import dsl._
    val laneStyle: RawAction = style(width(280.px)).style.toJsAny
  }
  import Style.laneStyle

  // scalastyle:off method.length
  private def baseData(token: String): Data[js.Object] = Data(
    Lane(id = LaneId("PLANNED"), title = "Planned Tasks", label = "20/70", style = laneStyle)(
      Card(
        id = CardId("Milk"),
        title = "Buy milk",
        label = "15 mins",
        description = "2 Gallons of milk at the Deli store"
      ),
      Card(
        id = CardId("Plan2"),
        title = "Dispose Garbage",
        label = "10 mins",
        description = "Sort out recyclable and waste as needed"
      ),
      Card(id = CardId("Plan3"), title = "Write Blog", label = "30 mins", description = "Can AI make memes?"),
      Card(id = CardId("Plan4"), title = "Pay Rent", label = "5 mins", description = "Transfer to bank account")
    ),
    Lane(id = LaneId("WIP"), title = "Work In Progress", label = "10/20", style = laneStyle)(
      Card(
        id = CardId("Wip1"),
        title = "Clean House",
        label = "30 mins",
        description = "Soap wash and polish floor. Polish windows and doors. Scrap all broken glasses"
      )
    ),
    Lane(id = LaneId("BLOCKED"), title = "Blocked", label = "0/0", style = laneStyle)(),
    Lane(id = LaneId("COMPLETED"), title = s"Completed $token", label = "2/5", style = laneStyle)(
      Card(
        id = CardId("Completed1"),
        title = "Practice Meditation",
        label = "15 mins",
        description = "Use Headspace app"
      ),
      Card(
        id = CardId("Completed2"),
        title = "Maintain Daily Journal",
        label = "15 mins",
        description = "Use Spreadsheet for now"
      )
    ),
    Lane(id = LaneId("REPEAT"), title = "Repeat", label = "1/1", style = laneStyle)(
      Card(id = CardId("Repeat1"), title = "Morning Jog", label = "30 mins", description = "Track using fitbit")
    ),
    Lane(id = LaneId("ARCHIVED"), title = "Archived", label = "1/1", style = laneStyle)(
      Card(id = CardId("Archived1"), title = "Go Trekking", label = "300 mins", description = "Completed 10km on cycle")
    ),
    Lane(id = LaneId("ARCHIVED2"), title = "Archived2", label = "1/1", style = laneStyle)(
      Card(id = CardId("Archived2"), title = "Go Jogging", label = "300 mins", description = "Completed 10km on cycle")
    ),
    Lane(id = LaneId("ARCHIVED3"), title = "Archived3", label = "1/1", style = laneStyle)(
      Card(id = CardId("Archived3"), title = "Go Cycling", label = "300 mins", description = "Completed 10km on cycle")
    )
  )
  // scalastyle:on method.length

  "Full Board example" >> {
    val token = UUID.randomUUID().toString
    val rendered = ReactTestUtils.renderIntoDocument(
      Board(data = baseData(token))()
    )
    val text = rendered.outerHtmlScrubbed()
    text must contain(token)
  }
}
