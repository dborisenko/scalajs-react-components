package com.dbrsn.scalajs.react.semanticui

final case class ButtonAnimatedType private (value: String) extends AnyVal
object ButtonAnimatedType {
  val fade: ButtonAnimatedType = ButtonAnimatedType("fade")
  val vertical: ButtonAnimatedType = ButtonAnimatedType("vertical")
  val values: List[ButtonAnimatedType] = List(fade, vertical)
}

final case class SuiIconType(value: String) extends AnyVal

final case class SuiCountry(value: String) extends AnyVal

final case class SuiMenuFloated private (value: String) extends AnyVal
object SuiMenuFloated {
  val right: SuiMenuFloated = SuiMenuFloated("SuiMenuFloated")
}
