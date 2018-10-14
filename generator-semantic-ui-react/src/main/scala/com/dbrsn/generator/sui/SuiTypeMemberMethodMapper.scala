package com.dbrsn.generator.sui

import com.dbrsn.generator.{CompName, MemberMapper, MemberMethod, ParsedMethod}

object SuiTypeMemberMethodMapper extends MemberMapper {

  override def apply(compName: CompName)(memberMethod: MemberMethod): ParsedMethod =
    ParsedMethod(
      apply(compName, memberMethod.paramNames, memberMethod.name),
      None
    )

  private def apply(c: CompName, args: Seq[String], m: String): String =
    (c.value, args.size, m) match {
      case ("DatePicker", 0, "getDate") => "getDate(): js.Date"

      case other ⇒
        // scalastyle:off regex
        println(s"missing types for method: $other")
        // scalastyle:on regex
        m + args.map(sanitize(_) + ": js.Any").mkString("(", ", ", ")") + ": js.Dynamic"
    }

  def sanitize(s: String): String =
    if (s == "val") "`val`" else s
}
