package com.olvind
package sui

object SuiTypeMapper extends TypeMapper {
  val typeT   = Normal("T").generic("T")
  val typeTJs = Normal("T").genericJs("T")

  def apply(compName: CompName, fieldName: PropName, typeString: String): Type = {
    def is(s: String) =
      fieldName.value.toLowerCase contains s.toLowerCase
    def split(drop: Int, s: String) =
      s.split("[\'\"\\(\\)\\[\\],\\s]").map(_.trim).filterNot(_.isEmpty).drop(drop)

    (compName.value, fieldName.value, typeString) match {
      case ("Input", "icon", _)      => Normal("SuiIconType")
      case ("Flag", "name", _)       => Normal("String | SuiCountry")
      case ("Header", "as", _)       => Normal("String | js.Function")
      case ("Header", "image", _)    => Normal("String | React.Element")
      case ("Header", "icon", _)     => Normal("String | js.Object | React.Element")
      case ("Button", "children", _) => Normal("VdomNode")
      case ("Button", "animated", _) => Normal("Boolean | ButtonAnimatedType")
      case ("Icon", "name", "_lib.customsuggest(_lib.SUI.ALL_ICONS_IN_ALL_CONTEXTS)") =>
        Normal("SuiIconType")
      case (_, "textAlign", _) =>
        Enum(compName, Seq("left", "center", "right", "justified"), "SuiTextAlignment")

      case (_, "size", _) =>
        Enum(compName,
             Seq("mini", "tiny", "small", "medium", "large", "big", "huge", "massive"),
             "SuiSize")
      case ("IconGroup", "name", "_lib.customsuggest(_lib.SUI.ALL_ICONS_IN_ALL_CONTEXTS)") =>
        Normal("SuiIconType")
      case (_, _, e) if e.contains("oneOfType") || e.contains("some(") => {
        val splitted = split(1, e)
        Normal(splitted.map(t => apply(compName, fieldName, t)) map (_.name) mkString " | ")
      }
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.WIDTHS)") => Normal("Double")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.COLORS)") =>
        Enum(compName,
             Seq("red",
                 "orange",
                 "yellow",
                 "olive",
                 "green",
                 "teal",
                 "blue",
                 "violet",
                 "purple",
                 "pink",
                 "brown",
                 "grey",
                 "black"),
             "SuiColor")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.FLOATS)") =>
        Enum(compName, Seq("left", "right"), "SuiFloat")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.SIZES)") =>
        Enum(compName,
             Seq("mini", "tiny", "small", "medium", "large", "big", "huge", "massive"),
             "SuiSize")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.TEXT_ALIGNMENTS)") =>
        Enum(compName, Seq("left", "center", "right", "justified"), "SuiTextAlignment")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.VERTICAL_ALIGNMENTS)") =>
        Enum(compName, Seq("bottom", "middle", "top"), "SuiVerticalAlignment")

      case (a, b, enum) if enum.contains("oneOf(") && enum.contains(']') =>
        val found = "(\\[.*?\\])".r.findAllIn(enum).toList
        val array =
          found.last.replaceAll("\\[|\\]", "").split(", ").map(_.replace("'", "").replace(" ", ""))
        Enum(compName, array)
      case (a, b, enum) if enum.contains("oneOf(") && !enum.contains(']') =>
        Enum(compName, split(1, enum))

      case (_, _, "_lib.customas") => Normal("js.Any") //TODO: what to do with this?

      /* general */
      case (_, "valueLink", "object")          => Normal("js.Any")
      case (_, _, "string")                    => Normal("String")
      case (_, _, "bool")                      => Normal("Boolean")
      case (_, "children", "element")          => Normal("VdomElement")
      case (_, _, "element")                   => Normal("React.Element")
      case (_, "children", "node")             => Normal("VdomNode")
      case (_, _, "node")                      => Normal("React.Node")
      case (_, _, "number")                    => Normal("Double")
      case (_, "children", "arrayOf(element)") => Normal("js.Array[React.Element]")

      case (_, _, "Mui.arrayOf")                         => Normal("js.Array[js.Any]")
      case (_, "valueLink", "_propTypes.default.object") => Normal("js.Any")
      case (_, _, "_propTypes.default.string")           => Normal("String")
      case (_, _, "_propTypes.default.bool")             => Normal("Boolean")
      case (_, "children", "_propTypes.default.element") => Normal("VdomElement")
      case (_, _, "_propTypes.default.element")          => Normal("React.Element")
      case (_, "children", "_propTypes.default.node")    => Normal("VdomNode")
      case (_, _, "_propTypes.default.node")             => Normal("React.Node")
      case (_, _, "_propTypes.default.object")           => Normal("js.Object")
      case (_, _, "_propTypes.default.number")           => Normal("Double")
      case (_, "children", "Mui.arrayOf(_propTypes.default.element)") =>
        Normal("js.Array[React.Element]")

      case ("AutoComplete", "popoverProps", "object")     => Normal("js.Any")
      case ("RadioButtonGroup", "defaultSelected", "any") => Normal("js.Any")
      case ("RadioButtonGroup", "valueSelected", "any")   => Normal("js.Any")
      case ("Stepper", "children", "arrayOf(node)")       => Normal("js.Any")
      /*Added by roberto@leibman.net*/
      case ("DatePicker", "utils", "object")              => Normal("DatePickerUtils")   //TODO ???
      case ("SelectField", "dropDownMenuProps", "object") => Normal("DropDownMenuProps") //TODO ???

      case (_, _, "Mui.func") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (_, _, "func") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (a, b, c) =>
        println(s"""case ("$a","$b","$c") => Normal("") //TODO write this Missing in TypeMapper""")
        Normal("js.Any /*//TODO: fix this in the TypeMapper*/")

    }
  }
}
