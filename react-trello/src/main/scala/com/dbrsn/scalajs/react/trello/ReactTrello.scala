package com.dbrsn.scalajs.react.trello

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object ReactTrello {
  @js.native @JSImport("react-trello/dist/Board", JSImport.Default)
  object Board extends js.Any

  @js.native @JSImport("react-trello/dist/Card", JSImport.Default)
  object Card extends js.Any

}
