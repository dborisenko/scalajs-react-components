package com.dbrsn.scalajs.react.semanticui

import com.dbrsn.scalajs.react.semanticui.SuiSpec._
import japgolly.scalajs.react.vdom.Implicits._
import org.specs2.mutable.Specification

import scala.scalajs.js

class SuiImageSpec extends Specification {
  "TYPES" >> {
    "Image: An image." >>
      testExistenceW(SuiImage(size = SuiSize.small)())
    "An image can render wrapped in a div.ui.image as alternative HTML markup." >>
      testExistenceW(SuiImage(size = SuiSize.small, wrapped = true)())
    "Image Link: An image can be formatted to link to other content." >>
      testExistenceW(SuiImage(as = "a": js.Any, size = SuiSize.medium, href = "http://google.com")())
  }
}
