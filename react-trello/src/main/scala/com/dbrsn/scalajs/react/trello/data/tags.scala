package com.dbrsn.scalajs.react.trello.data

object Tag {
  @inline def apply[U]: Tagger[U] = new Tagger[U]

  trait Tagged[U]
  type @@[+T, U] = T with Tagged[U]

  class Tagger[U] {
    @inline def apply[T](t: T): T @@ U = t.asInstanceOf[T @@ U]
  }
}

object BoardId {
  sealed trait Tag
  @inline def apply(id: String): BoardId = Tag[Tag][String](id)
}

object CardId {
  sealed trait Tag
  @inline def apply(id: String): CardId = Tag[Tag][String](id)

}

object LaneId {
  sealed trait Tag
  @inline def apply(id: String): LaneId = Tag[Tag][String](id)
}
