package com.dbrsn.scalajs.react.beautifuldnd

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object BeautifulDnd {
  @js.native @JSImport("react-beautiful-dnd/dist/DragDropContext", JSImport.Default)
  object DragDropContext extends js.Any

  @js.native @JSImport("react-beautiful-dnd/dist/Draggable", JSImport.Default)
  object Draggable extends js.Any

  @js.native @JSImport("react-beautiful-dnd/dist/Droppable", JSImport.Default)
  object Droppable extends js.Any
}
