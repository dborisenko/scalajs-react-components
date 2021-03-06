package com.dbrsn.generator.requiresjs

import ammonite.ops.Path
import com.dbrsn.generator.{CompName, MemberMethod, PropName, PropUnparsed}
import jdk.nashorn.internal.ir.FunctionNode

final case class ParsedFile(path: Path, content: String, result: FunctionNode)

object Required {
  def apply(path: Path, rs: Seq[Lazy[Required]]): Lazy[Required] =
    rs.size match {
      case 0 ⇒ Lazy(NotFound(path))
      case 1 ⇒ rs.head
      case _ ⇒ Lazy(Multiple(path, rs))
    }
}

sealed trait Required

final case class Multiple(path: Path, rs: Seq[Lazy[Required]]) extends Required

final case class Single(compName: CompName, c: FoundComponent) extends Required

final case class NotFound(path: Path) extends Required

final case class FoundComponent(
  name: CompName,
  file: Path,
  jsContent: String,
  props: Map[PropName, PropUnparsed],
  methods: Option[Set[MemberMethod]]
)
