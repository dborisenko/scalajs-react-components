package com.dbrsn.scalajs.react.storm.diagrams

import japgolly.scalajs.react.raw.React.Element

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

// scalastyle:off number.of.methods
@js.native
@JSImport("storm-react-diagrams", JSImport.Namespace)
object StormReactDiagrams extends js.Object {
  // scalastyle:off method.name
  private[diagrams] def DiagramWidget: Element = js.native
  private[diagrams] def DefaultPortLabel: Element = js.native
  private[diagrams] def DefaultNodeWidget: Element = js.native
  private[diagrams] def DefaultLinkWidget: Element = js.native
  private[diagrams] def DefaultLabelWidget: Element = js.native
  // scalastyle:on method.name

  type ListenerId = String

  @js.native
  trait BaseEntity extends js.Object {
    def getID(): String = js.native

    def isLocked(): Boolean = js.native
    def setLocked(locked: Boolean): Unit = js.native

    def addListener(listener: BaseListener): ListenerId = js.native
    def removeListener(listener: ListenerId): Unit = js.native
  }

  //Models

  @js.native
  trait BaseModel extends BaseEntity {
    def isSelected(): Boolean = js.native
    def setSelected(selected: Boolean = true): Boolean = js.native
    def remove(): Unit = js.native
  }

  @js.native
  class DiagramModel extends BaseEntity {
    def addNode(node: NodeModel): NodeModel = js.native
    def addLink(link: LinkModel): LinkModel = js.native
    def addAll(models: BaseModel*): js.Array[BaseModel] = js.native
    def removeNode(node: NodeModel): Unit = js.native
    def removeLink(link: LinkModel): Unit = js.native

    def setGridSize(size: Double): Unit = js.native
    def getGridPosition(pos: Double): Double = js.native

    def setZoomLevel(zoom: Double): Unit = js.native
    def getZoomLevel(): Double = js.native

    def setOffset(offsetX: Double, offsetY: Double): Unit = js.native
    def setOffsetX(offsetX: Double): Unit = js.native
    def setOffsetY(offsetY: Double): Unit = js.native
    def getOffsetY(): Double = js.native
    def getOffsetX(): Double = js.native
  }

  @js.native
  class LabelModel extends BaseModel

  @js.native
  class LinkModel extends BaseModel {
    def setSourcePort(port: PortModel): Unit = js.native
    def getSourcePort(): PortModel = js.native

    def setTargetPort(port: PortModel): Unit = js.native
    def getTargetPort(): PortModel = js.native

    def isLastPoint(point: PointModel): Boolean = js.native
    def getPointIndex(point: PointModel): Int = js.native
    def getPortForPoint(point: PointModel): PortModel = js.native
    def getPointForPort(port: PortModel): PointModel = js.native
    def getFirstPoint(): PointModel = js.native
    def getLastPoint(): PointModel = js.native

    def point(x: Double, y: Double): PointModel = js.native
    def getPoints(): js.Array[PointModel] = js.native
    def setPoints(points: js.Array[PointModel]): Unit = js.native
    def removePoint(pointModel: PointModel): Unit = js.native
    def removePointsBefore(pointModel: PointModel): Unit = js.native
    def removePointsAfter(pointModel: PointModel): Unit = js.native
    def removeMiddlePoints(): Unit = js.native
    def addPoint(pointModel: PointModel, index: Int = 1): PointModel = js.native
    def generatePoint(x: Double = 0, y: Double = 0): PointModel = js.native

    def addLabel(label: LabelModel): Unit = js.native
  }

  @js.native
  class NodeModel extends BaseModel {
    def setPosition(x: Double, y: Double): Unit = js.native

    def addPort(port: PortModel): PortModel = js.native
    def removePort(port: PortModel): Unit = js.native
  }

  @js.native
  class PointModel extends BaseModel {
    def isConnectedToPort(): Boolean = js.native
    def getLink(): LinkModel = js.native
    def getX(): Double = js.native
    def getY(): Double = js.native
  }

  @js.native
  class PortModel extends BaseModel {
    def getNode(): NodeModel = js.native
    def getName(): String = js.native
    def getMaximumLinks(): Number = js.native
    def setMaximumLinks(maximumLinks: Number): Unit = js.native
    def removeLink(link: LinkModel): Unit = js.native
    def addLink(link: LinkModel): Unit = js.native
    def canLinkToPort(port: PortModel): Boolean = js.native
  }

  // Default Models

  @js.native
  class DefaultLabelModel extends LabelModel {
    def label: String = js.native
    def setLabel(label: String): Unit = js.native
  }

  @js.native
  class DefaultLinkModel extends LinkModel {
    def addLabel(label: LabelModel | String): Unit = js.native
    def setWidth(width: Double): Unit = js.native
    def setColor(color: String): Unit = js.native
  }

  @js.native
  class DefaultNodeModel(val name: String, val color: String) extends NodeModel {
    def addInPort(label: String): DefaultPortModel = js.native
    def addOutPort(label: String): DefaultPortModel = js.native

    def getInPorts(): js.Array[DefaultPortModel] = js.native
    def getOutPorts(): js.Array[DefaultPortModel] = js.native
  }

  @js.native
  class DefaultPortModel(isInput: Boolean, name: String, label: String) extends PortModel {
    def link(port: PortModel): LinkModel = js.native
    def createLinkModel(): LinkModel = js.native
  }

  // Abstract Factories

  @js.native
  trait AbstractLabelFactory extends js.Object {
    def generateReactWidget(diagramEngine: DiagramEngine, label: LabelModel): Element = js.native
  }

  @js.native
  trait AbstractLinkFactory extends js.Object {
    def generateReactWidget(diagramEngine: DiagramEngine, link: LinkModel): Element = js.native
  }

  @js.native
  trait AbstractNodeFactory extends js.Object {
    def generateReactWidget(diagramEngine: DiagramEngine, node: NodeModel): Element = js.native
  }

  @js.native
  trait AbstractPortFactory extends js.Object

  // Default factories

  @js.native
  class DefaultLabelFactory extends AbstractLabelFactory

  @js.native
  class DefaultLinkFactory extends AbstractLinkFactory

  @js.native
  class DefaultNodeFactory extends AbstractNodeFactory

  @js.native
  class DefaultPortFactory extends AbstractPortFactory

  // Diagram Engine

  @js.native
  class DiagramEngine extends BaseEntity {
    def installDefaultFactories(): Unit = js.native

    def repaintCanvas(): Unit = js.native
    def clearRepaintEntities(): Unit = js.native
    def recalculatePortsVisually(): Unit = js.native

    def setDiagramModel(model: DiagramModel): Unit = js.native
    def getDiagramModel(): DiagramModel = js.native

    def registerLabelFactory(factory: AbstractLabelFactory): Unit = js.native
    def registerPortFactory(factory: AbstractPortFactory): Unit = js.native
    def registerNodeFactory(factory: AbstractNodeFactory): Unit = js.native
    def registerLinkFactory(factory: AbstractLinkFactory): Unit = js.native

    def getPortFactory(`type`: String): AbstractPortFactory = js.native
    def getNodeFactory(`type`: String): AbstractPortFactory = js.native
    def getLinkFactory(`type`: String): AbstractPortFactory = js.native
    def getLabelFactory(`type`: String): AbstractPortFactory = js.native

    def getMaxNumberPointsPerLink(): Int = js.native
    def setMaxNumberPointsPerLink(max: Int): Unit = js.native

    def isSmartRoutingEnabled(): Boolean = js.native
    def setSmartRoutingStatus(status: Boolean): Unit = js.native

    def zoomToFit(): Unit = js.native
  }

  @js.native
  trait SelectionModel extends js.Object {
    def model: BaseModel = js.native
    def initialX: Int = js.native
    def initialY: Int = js.native
  }

  @js.native
  class BaseAction extends js.Object {
    def mouseX: Int = js.native
    def mouseY: Int = js.native
  }

  @js.native
  class MoveCanvasAction extends BaseAction {
    def initialOffsetX: Int = js.native
    def initialOffsetY: Int = js.native
  }

  @js.native
  class MoveItemsAction extends BaseAction {
    def moved: Boolean = js.native
    def selectionModels: js.Array[SelectionModel] = js.native
  }

  @js.native
  class SelectingAction extends BaseAction {
    def mouseX2: Int = js.native
    def mouseY2: Int = js.native
  }

  @js.native
  trait BaseEvent extends js.Object {
    def entity: BaseEntity = js.native
    def firing: Boolean = js.native
    def id: String = js.native
  }

  @js.native
  trait BaseListener extends js.Object
}
// scalastyle:on number.of.methods
