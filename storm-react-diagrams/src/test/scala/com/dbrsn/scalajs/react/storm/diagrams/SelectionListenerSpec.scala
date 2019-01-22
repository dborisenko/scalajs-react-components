package com.dbrsn.scalajs.react.storm.diagrams

import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.DefaultNodeModel
import japgolly.scalajs.react.Callback
import org.specs2.mutable.Specification

class SelectionListenerSpec extends Specification {
  "Model should be possible to select" >> {
    var isSelected = false

    val node = new DefaultNodeModel(s"Node 1", "rgb(0,192,255)")
    node.addListener(
      SelectionListener(
        (data: SelectionData) =>
          Callback {
            isSelected = data.isSelected
        }
      )
    )
    node.setSelected()

    isSelected must beTrue
  }
}
