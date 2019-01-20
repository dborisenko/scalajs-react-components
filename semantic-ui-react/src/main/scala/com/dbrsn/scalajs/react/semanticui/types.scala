package com.dbrsn.scalajs.react.semanticui

final case class ButtonAnimatedType private (value: String) extends AnyVal
object ButtonAnimatedType {
  val fade: ButtonAnimatedType = ButtonAnimatedType("fade")
  val vertical: ButtonAnimatedType = ButtonAnimatedType("vertical")
  val values: List[ButtonAnimatedType] = List(fade, vertical)
}

final case class SuiIconType(value: String) extends AnyVal

final case class SuiCountry(value: String) extends AnyVal

final case class SuiLeftSide private (value: String) extends AnyVal
object SuiLeftSide {
  def apply(): SuiLeftSide = new SuiLeftSide("left")
  private def apply(value: String): SuiLeftSide = apply()
}

final case class SuiRightSide private (value: String) extends AnyVal
object SuiRightSide {
  def apply(): SuiRightSide = new SuiRightSide("right")
  private def apply(value: String): SuiRightSide = apply()
}

final case class SuiBottomSide private (value: String) extends AnyVal
object SuiBottomSide {
  def apply(): SuiBottomSide = new SuiBottomSide("bottom")
  private def apply(value: String): SuiBottomSide = apply()
}

final case class SuiTopSide private (value: String) extends AnyVal
object SuiTopSide {
  def apply(): SuiTopSide = new SuiTopSide("top")
  private def apply(value: String): SuiTopSide = apply()
}

object SuiSide {
  val left: SuiLeftSide = SuiLeftSide()
  val right: SuiRightSide = SuiRightSide()
  val bottom: SuiBottomSide = SuiBottomSide()
  val top: SuiTopSide = SuiTopSide()
}

final case class SuiVery private (value: String) extends AnyVal
object SuiVery {
  def apply(): SuiVery = new SuiVery("very")
  private def apply(value: String): SuiVery = apply()
}

final case class SuiAuto private (value: String) extends AnyVal
object SuiAuto {
  def apply(): SuiAuto = new SuiAuto("auto")
  private def apply(value: String): SuiAuto = apply()
}

final case class SuiLabeled private (value: String) extends AnyVal
object SuiLabeled {
  def apply(): SuiLabeled = new SuiLabeled("labeled")
  private def apply(value: String): SuiLabeled = apply()
}

final case class SuiCentered private (value: String) extends AnyVal
object SuiCentered {
  def apply(): SuiCentered = new SuiCentered("centered")
  private def apply(value: String): SuiCentered = apply()
}

final case class SuiInternally private (value: String) extends AnyVal
object SuiInternally {
  def apply(): SuiInternally = new SuiInternally("internally")
  private def apply(value: String): SuiInternally = apply()
}

final case class SuiVertically private (value: String) extends AnyVal
object SuiVertically {
  def apply(): SuiVertically = new SuiVertically("vertically")
  private def apply(value: String): SuiVertically = apply()
}
