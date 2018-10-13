package com.dbrsn.scalajs.react.semanticui

import com.dbrsn.scalajs.react.semanticui.SuiSpec._
import japgolly.scalajs.react.vdom.Implicits._
import japgolly.scalajs.react.vdom.html_<^.{< => tg}
import org.specs2.mutable.Specification

import scala.scalajs.js

class SuiHeaderSpec extends Specification {
  "TYPES" >> {
    "Page Headers: Headers may be oriented to give the hierarchy of a section in the context of the page." >> testTextW {
      txt =>
        tg.div(
          SuiHeader(as = "h1")("1"),
          SuiHeader(as = "h2")("2"),
          SuiHeader(as = "h3")("3"),
          SuiHeader(as = "h4")(txt),
          SuiHeader(as = "h5")("5"),
          SuiHeader(as = "h6")("6")
        )
    }
    "Content Headers: Headers may be oriented to give the importance of a section." >> testTextW { txt =>
      tg.div(
        SuiHeader(size = SuiSize.huge)("1"),
        SuiHeader(size = SuiSize.large)("2"),
        SuiHeader(size = SuiSize.medium)("3"),
        SuiHeader(size = SuiSize.small)(txt),
        SuiHeader(size = SuiSize.tiny)("5")
      )
    }
    "Icon Headers: A header can be formatted to emphasize an icon." >> testTextW { txt =>
      SuiHeader(as = "h2", icon = "settings")(
        SuiIcon(name = SuiIconType("settings"))(),
        "Account Settings",
        SuiHeaderSubheader()(txt)
      )
    }
    "Other example" >> testTextW { txt =>
      tg.div(
        SuiHeader(as = "h2", icon = "users", textAlign = SuiTextAlignment.center)(
          SuiIcon(name = SuiIconType("users"), circular = true)(),
          SuiHeaderContent()(txt)
        ),
        SuiImage(centered = true, size = SuiSize.large)()
      )
    }
    "Subheaders: Headers may be formatted to label smaller or de-emphasized content." >> testTextW { txt =>
      tg.div(SuiHeader(sub = true)(txt), tg.span("$10.99"))
    }
  }
  "CONTENT" >> {
    "Image: A header may contain an image." >>
      testTextW(SuiHeader(as = "h2", icon = "settings")(SuiImage(circular = true)(), _))
    "You can also define an image with props." >> testTextW { txt =>
      SuiHeader(as = "h2", image = "/images/icons/school.png", content = txt: js.Any)()
    }
  }
  "STATES" >> {
    "Disabled: A header can show that it is inactive." >>
      testTextW(SuiHeader(as = "h2", disabled = true)(_))
  }
  "VARIATIONS" >> {
    "Dividing: A header can be formatted to divide itself from the content below it." >>
      testTextW(SuiHeader(as = "h2", dividing = true)(_))
    "Block: A header can be formatted to appear inside a content block." >>
      testTextW(SuiHeader(as = "h2", block = true)(_))
  }
}
