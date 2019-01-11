package com.dbrsn.scalajs.react.storm.diagrams

import japgolly.scalajs.react.raw.React.Element

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("storm-react-diagrams", JSImport.Namespace)
object StormReactDiagrams extends js.Object {
  // scalastyle:off method.name
  def DiagramWidget: Element = js.native
  def DefaultPortLabel: Element = js.native
  // scalastyle:on method.name

  @js.native
  trait BaseEntity extends js.Object {
    def getID(): String = js.native

    def isLocked(): Boolean = js.native

    def setLocked(locked: Boolean): Unit = js.native
  }

  @js.native
  trait BaseModel extends BaseEntity

  @js.native
  class DiagramModel extends BaseEntity {
    def addNode(node: NodeModel): NodeModel = js.native

    def addLink(link: LinkModel): LinkModel = js.native

    def setGridSize(size: Double): Unit = js.native

    def getGridPosition(pos: Double): Double = js.native

    def setZoomLevel(zoom: Double): Unit = js.native

    def getZoomLevel(): Double = js.native

    def addAll(models: BaseModel*): js.Array[BaseModel] = js.native
  }

  @js.native
  class LinkModel extends BaseModel {
    def setSourcePort(port: PortModel): Unit = js.native

    def setTargetPort(port: PortModel): Unit = js.native
  }

  @js.native
  trait PortModel extends BaseModel

  @js.native
  class DefaultPortModel(isInput: Boolean, name: String, label: String) extends PortModel {
    def link(port: PortModel): LinkModel = js.native
  }

  @js.native
  trait NodeModel extends BaseModel {
    def addPort(port: PortModel): PortModel = js.native

    def setPosition(x: Double, y: Double): Unit = js.native
  }

  @js.native
  class DefaultNodeModel(val name: String, val color: String) extends NodeModel {
    def getInPorts(): js.Array[DefaultPortModel] = js.native

    def getOutPorts(): js.Array[DefaultPortModel] = js.native

    def addOutPort(label: String): DefaultPortModel = js.native

    def addInPort(label: String): DefaultPortModel = js.native
  }

  @js.native
  trait NodeWidgetFactory[T <: NodeModel] extends js.Object {
    def generateReactWidget(diagramEngine: DiagramEngine, node: T): Element = js.native
  }

  @js.native
  trait LinkWidgetFactory[T <: LinkModel] extends js.Object {
    def generateReactWidget(diagramEngine: DiagramEngine, link: T): Element = js.native
  }

  @js.native
  class DiagramEngine extends BaseEntity {
    def registerNodeFactory[T <: NodeModel](factory: NodeWidgetFactory[T]): Unit = js.native

    def registerLinkFactory[T <: LinkModel](factory: LinkWidgetFactory[T]): Unit = js.native

    def setDiagramModel(model: DiagramModel): Unit = js.native

    def installDefaultFactories(): Unit = js.native
  }

  @js.native
  class DefaultNodeFactory extends NodeWidgetFactory[NodeModel]

  @js.native
  class DefaultLinkFactory extends LinkWidgetFactory[LinkModel]

}
