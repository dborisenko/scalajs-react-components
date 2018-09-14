package com.olvind
package sui

object SuiTypeMapperFunction {
  val Callback = "Callback"

  def apply(compName: CompName, name: PropName): String =
    (compName.value, name.value) match {
      case ("AccordionTitle", "onClick")    => "ReactMouseEventFromHtml => Callback"
      case ("BreadcrumbSection", "onClick") => "ReactMouseEventFromHtml => Callback"
      case ("Button", "onClick")            => "ReactMouseEventFromHtml => Callback"
      case ("Card", "onClick")              => "ReactMouseEventFromHtml => Callback"
      case ("Checkbox", "onChange")         => "ReactEventFromInput => Callback"
      case ("Checkbox", "onClick")          => "ReactMouseEventFromInput => Callback"
      case ("Checkbox", "onMouseDown")      => "ReactMouseEventFromInput => Callback"
      case ("Confirm", "onCancel")          => "ReactMouseEventFromHtml => Callback"
      case ("Confirm", "onConfirm")         => "ReactMouseEventFromHtml => Callback"
      case ("DropdownItem", "onClick")      => "ReactMouseEventFromHtml => Callback"
      case ("Form", "onSubmit")             => "ReactMouseEventFromHtml => Callback"
      case ("Input", "onChange")            => "ReactEventFromInput => Callback"
      case ("Label", "onClick")             => "ReactMouseEventFromHtml => Callback"
      case ("Label", "onRemove")            => "ReactMouseEventFromHtml => Callback"
      case ("ListItem", "onClick")          => "ReactMouseEventFromHtml => Callback"
      case ("MenuItem", "onClick")          => "ReactMouseEventFromHtml => Callback"
      case ("Message", "onDismiss")         => "ReactMouseEventFromHtml => Callback"
      case ("Rating", "onRate")             => "ReactMouseEventFromHtml => Callback"
      case ("RatingIcon", "onClick")        => "ReactMouseEventFromHtml => Callback"
      case ("RatingIcon", "onKeyUp")        => "ReactMouseEventFromHtml => Callback"
      case ("RatingIcon", "onMouseEnter")   => "ReactMouseEventFromHtml => Callback"
      case ("Sidebar", "onHidden")          => "ReactMouseEventFromHtml => Callback"
      case ("Sidebar", "onHide")            => "ReactMouseEventFromHtml => Callback"
      case ("Sidebar", "onShow")            => "ReactMouseEventFromHtml => Callback"
      case ("Sidebar", "onVisible")         => "ReactMouseEventFromHtml => Callback"
      case ("TextArea", "onChange")         => "ReactEventFromTextArea => Callback"
      case ("TextArea", "onInput")          => "ReactEventFromTextArea => Callback"

      case _ =>
        throw new Error(
          s"""case ("${compName.value}", "${name.value}") => Callback  //TODO: Add function type mapping in ${getClass.getName}"""
        )
    }
}
