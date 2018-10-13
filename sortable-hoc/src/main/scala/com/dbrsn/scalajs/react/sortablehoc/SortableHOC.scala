package com.dbrsn.scalajs.react.sortablehoc

import japgolly.scalajs.react.component.Generic.ComponentRaw
import japgolly.scalajs.react.raw.React

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * A facade to SortableHOC of https://github.com/clauderic/react-sortable-hoc
  */
@js.native
@JSImport("react-sortable-hoc", JSImport.Namespace)
object SortableHOC extends js.Object {
  // scalastyle:off
  def SortableContainer(component: ComponentRaw#Raw): React.Element = js.native

  def SortableElement(component: ComponentRaw#Raw): React.Element = js.native

  def SortableHandle(component: ComponentRaw#Raw): React.Element = js.native
  // scalastyle:on
}
