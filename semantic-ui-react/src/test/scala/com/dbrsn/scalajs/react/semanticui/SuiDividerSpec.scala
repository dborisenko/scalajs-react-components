package com.dbrsn.scalajs.react.semanticui

import com.dbrsn.scalajs.react.semanticui.SuiSpec._
import japgolly.scalajs.react.vdom.Implicits._
import org.specs2.mutable.Specification

class SuiDividerSpec extends Specification {
  "TYPES" >> {
    "Divider: A standard divider." >> testExistenceW(SuiDivider()())
    "Vertical Divider: A divider can segment content vertically." >> testTextW { txt =>
      SuiGrid(columns = new Equal("3"), relaxed = true)(
        SuiGridColumn()(
          SuiSegment(basic = true)("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio.")
        ),
        SuiDivider(vertical = true)("Or"),
        SuiGridColumn()(
          SuiSegment(basic = true)("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio.")
        ),
        SuiDivider(vertical = true)(txt),
        SuiGridColumn()(
          SuiSegment(basic = true)("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio.")
        )
      )
    }
    "Horizontal Divider: A divider can segement content horizontally." >> testTextW { txt =>
      SuiSegment(padded = true)(
        SuiButton(primary = true, fluid = true)("Login"),
        SuiDivider(horizontal = true)(txt),
        SuiButton(secondary = true, fluid = true)("Sign Up Now")
      )
    }
  }
  "VARIATIONS" >> {
    "Inverted: A divider can have its colors inverted." >> testTextW { txt =>
      SuiSegment(inverted = true)(
        SuiDivider(inverted = true)(),
        SuiDivider(horizontal = true, inverted = true)(txt)
      )
    }
    "Fitted: A divider can be fitted, without any space above or below it." >> testTextW { txt =>
      SuiSegment()(txt, SuiDivider(fitted = true)(), "test")
    }
    "Hidden: A hidden divider divides content without creating a dividing line." >> testTextW { txt =>
      SuiSegment()(txt, SuiDivider(hidden = true)(), "test")
    }
    "Section: A divider can provide greater margins to divide sections of content." >> testTextW { txt =>
      SuiSegment()(txt, SuiDivider(section = true)(), "test")
    }
    "Clearing: A divider can clear the contents above it." >> testTextW { txt =>
      SuiSegment()(SuiButton(floated = SuiFloat.right)("Floated Button"), SuiDivider(clearing = true)(), txt)
    }
  }
}
