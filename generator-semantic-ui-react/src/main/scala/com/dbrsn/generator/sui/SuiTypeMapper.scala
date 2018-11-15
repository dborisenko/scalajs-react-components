package com.dbrsn.generator.sui

import com.dbrsn.generator._

object SuiTypeMapper extends TypeMapper {
  val typeT: Normal = Normal("T").generic("T")
  val typeTJs: Normal = Normal("T").genericJs("T")

  // scalastyle:off cyclomatic.complexity method.length
  def apply(compName: CompName, fieldName: PropName, typeString: String): Type = {
    def split(drop: Int, s: String): Array[String] =
      s.split("[\'\"\\(\\)\\[\\],\\s]").map(_.trim).filterNot(_.isEmpty).drop(drop)

    (compName.value, fieldName.value, typeString) match {
      case ("Input", "icon", _)      => Normal("SuiIconType")
      case ("Flag", "name", _)       => Normal("String | SuiCountry")
      case ("Header", "as", _)       => Normal("String | js.Function")
      case ("Header", "image", _)    => Normal("String | dom.Element")
      case ("Header", "icon", _)     => Normal("String | js.Object | dom.Element")
      case ("Button", "children", _) => Normal("VdomNode")
      case ("Button", "animated", _) => Normal("Boolean | ButtonAnimatedType")
      case ("Icon", "name", "_lib.customsuggest(_lib.SUI.ALL_ICONS_IN_ALL_CONTEXTS)") =>
        Normal("SuiIconType")
      case (_, "textAlign", _) =>
        Enum(compName, Seq("left", "center", "right", "justified"), "SuiTextAlignment")

      case (_, "computer" | "largeScreen" | "mobile" | "tablet" | "widescreen" | "width", _) =>
        Enum(
          compName,
          Seq(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen"
          ),
          "SuiDeviceWidth"
        )

      case (_, "size", _) =>
        Enum(compName, Seq("mini", "tiny", "small", "medium", "large", "big", "huge", "massive"), "SuiSize")
      case ("IconGroup", "name", "_lib.customsuggest(_lib.SUI.ALL_ICONS_IN_ALL_CONTEXTS)") =>
        Normal("SuiIconType")
      case (_, _, e) if e.contains("oneOfType") || e.contains("some(") =>
        val splitted = split(1, e)
        Normal(splitted.map(t => apply(compName, fieldName, t)) map (_.name) mkString " | ")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.WIDTHS)") => Normal("Double")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.COLORS)") =>
        Enum(
          compName,
          Seq(
            "red",
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
            "black"
          ),
          "SuiColor"
        )
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.FLOATS)") =>
        Enum(compName, Seq("left", "right"), "SuiFloat")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.SIZES)") =>
        Enum(compName, Seq("mini", "tiny", "small", "medium", "large", "big", "huge", "massive"), "SuiSize")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.TEXT_ALIGNMENTS)") =>
        Enum(compName, Seq("left", "center", "right", "justified"), "SuiTextAlignment")
      case (_, _, "_propTypes.default.oneOf(_lib.SUI.VERTICAL_ALIGNMENTS)") =>
        Enum(compName, Seq("bottom", "middle", "top"), "SuiVerticalAlignment")

      case (_, _, enum) if enum.contains("oneOf(") && enum.contains(']') =>
        val found = "(\\[.*?\\])".r.findAllIn(enum).toList
        val array =
          found.last.replaceAll("\\[|\\]", "").split(", ").map(_.replace("'", "").replace(" ", ""))
        Enum(compName, array)
      case (_, _, enum) if enum.contains("oneOf(") && !enum.contains(']') =>
        Enum(compName, split(1, enum))

      case (_, _, "_lib.customas") => Normal("js.Any") //TODO: what to do with this?

      /* general */
      case (_, "valueLink", "object")          => Normal("js.Any")
      case (_, _, "string")                    => Normal("String")
      case (_, _, "bool")                      => Normal("Boolean")
      case (_, "children", "element")          => Normal("VdomElement")
      case (_, _, "element")                   => Normal("dom.Element")
      case (_, "children", "node")             => Normal("VdomNode")
      case (_, _, "node")                      => Normal("React.Node")
      case (_, _, "number")                    => Normal("Double")
      case (_, "children", "arrayOf(element)") => Normal("js.Array[dom.Element]")

      case (_, _, "Mui.arrayOf")                                      => Normal("js.Array[js.Any]")
      case (_, "valueLink", "_propTypes.default.object")              => Normal("js.Any")
      case (_, _, "_propTypes.default.string")                        => Normal("String")
      case (_, _, "_propTypes.default.bool")                          => Normal("Boolean")
      case (_, "children", "_propTypes.default.element")              => Normal("VdomElement")
      case (_, _, "_propTypes.default.element")                       => Normal("dom.Element")
      case (_, "children", "_propTypes.default.node")                 => Normal("VdomNode")
      case (_, _, "_propTypes.default.node")                          => Normal("React.Node")
      case (_, _, "_propTypes.default.object")                        => Normal("js.Object")
      case (_, _, "_propTypes.default.number")                        => Normal("Double")
      case (_, "children", "Mui.arrayOf(_propTypes.default.element)") => Normal("js.Array[dom.Element]")

      case ("AutoComplete", "popoverProps", "object")     => Normal("js.Any")
      case ("RadioButtonGroup", "defaultSelected", "any") => Normal("js.Any")
      case ("RadioButtonGroup", "valueSelected", "any")   => Normal("js.Any")
      case ("Stepper", "children", "arrayOf(node)")       => Normal("js.Any")
      /*Added by roberto@leibman.net*/
      case ("DatePicker", "utils", "object")              => Normal("DatePickerUtils") //TODO ???
      case ("SelectField", "dropDownMenuProps", "object") => Normal("DropDownMenuProps") //TODO ???

      case ("Select", "options", _)                                => Normal("js.Array[SuiDropdownItem]")
      case ("DropdownItem", "text", "_lib.customcontentShorthand") => Normal("String")

      case (_, _, "_propTypes.default.func") => Normal(SuiTypeMapperFunction(compName, fieldName))
      case (a, b, c)                         =>
        // scalastyle:off regex
        println(s"""case ("$a","$b","$c") => Normal("") //TODO write this Missing in TypeMapper""")
        // scalastyle:on regex
        Normal("js.Any /*//TODO: fix this in the TypeMapper*/")
    }
    // scalastyle:on cyclomatic.complexity method.length
  }
}
