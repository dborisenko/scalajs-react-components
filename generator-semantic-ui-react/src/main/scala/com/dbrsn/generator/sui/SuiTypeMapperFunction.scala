package com.dbrsn.generator.sui

import com.dbrsn.generator.{CompName, PropName}

object SuiTypeMapperFunction {
  val Callback = "Callback"

  // scalastyle:off cyclomatic.complexity method.length
  def apply(compName: CompName, name: PropName): String =
    (compName.value, name.value) match {
      case ("AccordionTitle", "onClick")    => "ReactMouseEventFromHtml => Callback"
      case ("BreadcrumbSection", "onClick") => "ReactMouseEventFromHtml => Callback"
      case ("Button", "onClick")            => "ReactMouseEventFromHtml => Callback"
      case ("Card", "onClick")              => "ReactMouseEventFromHtml => Callback"
      case ("Checkbox", "onChange")         => "ReactEventFromInput => Callback"
      case ("Checkbox", "onClick")          => "ReactMouseEventFromInput => Callback"
      case ("Checkbox", "onMouseDown")      => "ReactMouseEventFromInput => Callback"
      case ("Checkbox", "onMouseUp")        => "ReactMouseEventFromInput => Callback"
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
      case ("Modal", "onActionClick")       => "ReactMouseEventFromHtml => Callback"
      case ("Modal", "onOpen")              => "ReactMouseEventFromHtml => Callback"
      case ("Modal", "onClose")             => "ReactMouseEventFromHtml => Callback"
      case ("Modal", "onMount")             => "Callback"
      case ("Modal", "onUnmount")           => "Callback"
      case ("Pagination", "onPageChange")   => "(ReactMouseEventFromHtml, SuiPaginationData) => Callback"
      case ("PaginationItem", "onClick")    => "ReactMouseEventFromHtml => Callback"
      case ("PaginationItem", "onKeyDown")  => "ReactMouseEventFromHtml => Callback"
      case ("Popup", "onOpen")              => "ReactMouseEventFromHtml => Callback"
      case ("Popup", "onClose")             => "ReactMouseEventFromHtml => Callback"
      case ("Popup", "onMount")             => "Callback"
      case ("Popup", "onUnmount")           => "Callback"
      case ("Portal", "onOpen")             => "ReactMouseEventFromHtml => Callback"
      case ("Portal", "onClose")            => "ReactMouseEventFromHtml => Callback"
      case ("Portal", "onMount")            => "Callback"
      case ("Portal", "onUnmount")          => "Callback"
      case ("Dropdown", "onAddItem")        => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onBlur")           => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onChange")         => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onClick")          => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onClose")          => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onFocus")          => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onLabelClick")     => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onMouseDown")      => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onOpen")           => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "onSearchChange")   => "ReactMouseEventFromHtml => Callback"
      case ("Dropdown", "renderLabel")      => "(js.Any, Int, js.Any) => String"

      case _ =>
        throw new Error(
          s"""case ("${compName.value}", "${name.value}") => Callback  //TODO: Add function type mapping in ${getClass.getName}"""
        )
    }
  // scalastyle:on cyclomatic.complexity method.length
}
