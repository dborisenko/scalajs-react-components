package com.dbrsn.scalajs.react.storm.diagrams

import java.util.UUID

import com.dbrsn.scalajs.react.storm.diagrams.StormReactDiagrams.{DefaultNodeModel, DiagramEngine, DiagramModel}
import japgolly.scalajs.react.test._
import org.specs2.mutable.Specification

class StormReactDiagramWidgetSpec extends Specification {
  "StormReactDiagramWidget should render nodes" >> {
    val text1 = UUID.randomUUID().toString
    val text2 = UUID.randomUUID().toString
    val text3 = UUID.randomUUID().toString
    val text4 = UUID.randomUUID().toString
    val text5 = UUID.randomUUID().toString

    val (pos1x, pos1y) = (100.0, 100.0)
    val (pos2x, pos2y) = (400.0, 100.0)

    // 1) setup the diagram engine
    val engine = new DiagramEngine()
    engine.installDefaultFactories()

    // 2) setup the diagram model
    val model = new DiagramModel()

    // 3) create a default node
    val node1 = new DefaultNodeModel(s"Node $text1 1", "rgb(0,192,255)")
    val port1 = node1.addOutPort(s"Out $text2")
    node1.setPosition(pos1x, pos1y)

    // 4) create another default node
    val node2 = new DefaultNodeModel(s"Node $text3 2", "rgb(192,255,0)")
    val port2 = node2.addInPort(s"In $text4")
    node2.setPosition(pos2x, pos2y)

    // 5) link the ports
    val link1 = port1.link(port2)

    // 6) add the models to the root graph
    model.addAll(node1, node2, link1)

    // 7) load model into engine
    engine.setDiagramModel(model)

    val rendered = ReactTestUtils.renderIntoDocument(
      StormReactDiagramWidget.Props(diagramEngine = engine, className = text5).render
    )
    val text = rendered.outerHtmlScrubbed()
    (text must contain(text1)) and (text must contain(text2)) and (text must contain(text3)) and
      (text must contain(text4)) and (text must contain(text5))
  }
}
