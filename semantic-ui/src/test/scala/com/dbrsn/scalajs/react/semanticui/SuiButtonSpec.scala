package com.dbrsn.scalajs.react.semanticui

import java.util.UUID

import com.dbrsn.scalajs.react.semanticui.SuiSpec._
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Js
import japgolly.scalajs.react.component.Js.{MountedWithRawType, RawMounted}
import japgolly.scalajs.react.test._
import japgolly.scalajs.react.vdom.Implicits._
import org.specs2.matcher.MatchResult
import org.specs2.mutable.Specification

import scala.language.existentials
import scala.scalajs.js

class SuiButtonSpec extends Specification {

  private def testTextAndClick[M](
      unmounted: (String, Callback) => UnmountedDef): MatchResult[Any] = {
    val token: String = UUID.randomUUID().toString
    val clicked       = ReactTestVar(false)
    val rendered =
      ReactTestUtils.renderIntoDocument(unmounted(testPhrase(token), clicked.setStateFn(true)))
    val element = ReactTestUtils.findRenderedDOMComponentWithTag(rendered, "button")
    Simulate.click(element.getDOMNode.asElement)
    (rendered.outerHtmlScrubbed() must contain(token)) and (clicked.value() must_=== true)
  }

  private def wrap(cb: Callback): ReactMouseEventFromInput => Callback = _ => cb

  "TYPES" >> {
    "Button: A standard button." >>
      testTextAndClick((txt, cb) => SuiButton(onClick = wrap(cb))(txt))
    "Button: You can do the same using label." >>
      testTextAndClick((txt, cb) => SuiButton(onClick = wrap(cb), label = txt)())
    "Emphasis: A button can be formatted to show different levels of emphasis." >> {
      testTextAndClick((txt, cb) => SuiButton(primary = true, onClick = wrap(cb))(txt)) and
        testTextAndClick((txt, cb) => SuiButton(secondary = true, onClick = wrap(cb))(txt))
    }
    "Animated: Buttons can animate to show additional or hidden content." >> {
      testTextAndClick { (txt, cb) =>
        SuiButton(animated = true, onClick = wrap(cb))(
          SuiButtonContent(visible = true)(txt),
          SuiButtonContent(hidden = true)(SuiIcon(name = SuiIconType("arrow right"))())
        )
      } and testTextAndClick { (txt, cb) =>
        SuiButton(animated = ButtonAnimatedType.vertical, onClick = wrap(cb))(
          SuiButtonContent(visible = true)(txt),
          SuiButtonContent(hidden = true)(SuiIcon(name = SuiIconType("shop"))())
        )
      } and testTextAndClick { (txt, cb) =>
        SuiButton(animated = ButtonAnimatedType.fade, onClick = wrap(cb))(
          SuiButtonContent(visible = true)(txt),
          SuiButtonContent(hidden = true)("$12.99 a month")
        )
      }
    }
    "Labeled: A button can be accompanied by a label." >> {
      testTextAndClick { (txt, cb) =>
        SuiButton(as = js.Any.fromString("div"), onClick = wrap(cb))(
          SuiButton(icon = true)(SuiIcon(name = SuiIconType("heart"))(), "Like"),
          SuiLabel(as = js.Any.fromString("a"), basic = true, pointing = js.Any.fromString("left"))(
            txt)
        )
      } and testTextAndClick { (txt, cb) =>
        SuiButton(as = js.Any.fromString("div"),
                  onClick = wrap(cb),
                  labelPosition = RightLeft.left)(
          SuiLabel(as = js.Any.fromString("a"),
                   basic = true,
                   pointing = js.Any.fromString("right"))(txt),
          SuiButton(icon = true)(SuiIcon(name = SuiIconType("heart"))(), "Like")
        )
      } and testTextAndClick { (txt, cb) =>
        SuiButton(as = js.Any.fromString("div"),
                  onClick = wrap(cb),
                  labelPosition = RightLeft.left)(
          SuiLabel(as = js.Any.fromString("a"), basic = true)(txt),
          SuiButton(icon = true)(SuiIcon(name = SuiIconType("fork"))())
        )
      }
    }
    "Colored" >> {
      testTextAndClick { (txt, cb) =>
        SuiButton(as = js.Any.fromString("div"),
                  onClick = wrap(cb),
                  labelPosition = RightLeft.right)(
          SuiButton(color = new FacebookGoogleplusInstagramLinkedinTwitterVkYoutube("red"))(
            SuiIcon(name = SuiIconType("heart"))(),
            "Like"),
          SuiLabel(as = js.Any.fromString("a"),
                   basic = true,
                   pointing = js.Any.fromString("left"),
                   color = SuiColor.red)(txt)
        )
      } and testTextAndClick { (txt, cb) =>
        SuiButton(as = js.Any.fromString("div"),
                  onClick = wrap(cb),
                  labelPosition = RightLeft.right)(
          SuiButton(color = new FacebookGoogleplusInstagramLinkedinTwitterVkYoutube("blue"),
                    basic = true)(SuiIcon(name = SuiIconType("fork"))(), "Fork"),
          SuiLabel(as = js.Any.fromString("a"), basic = true, pointing = js.Any.fromString("left"))(
            txt)
        )
      }
    }
    "Icon: A button can be made of only an icon." >>
      testTextAndClick((txt, cb) =>
        SuiButton(icon = true, onClick = wrap(cb))(SuiIcon(name = SuiIconType("world"))(), txt))
    "Icon: You can do the same using shorthands." >>
      testTextAndClick((txt, cb) => SuiButton(icon = "world", onClick = wrap(cb))(txt))
    "Labeled Icon: A button can use an icon as a label." >> {
      testTextAndClick { (txt, cb) =>
        SuiButton(icon = true, onClick = wrap(cb), labelPosition = RightLeft.left)(
          SuiIcon(name = SuiIconType("pause"))(),
          txt)
      } and testTextAndClick { (txt, cb) =>
        SuiButton(icon = true, onClick = wrap(cb), labelPosition = RightLeft.right)(
          SuiIcon(name = SuiIconType("right arrow"))(),
          txt)
      }
    }
    "Labeled Icon: You can do the same using shorthands." >> {
      testTextAndClick { (txt, cb) =>
        SuiButton(icon = "pause", onClick = wrap(cb), labelPosition = RightLeft.left, label = txt)()
      } and testTextAndClick { (txt, cb) =>
        SuiButton(icon = "right arrow",
                  onClick = wrap(cb),
                  labelPosition = RightLeft.right,
                  label = txt)()
      }
    }
    "Basic: The basic button has a subtle appearance." >> {
      def testColor(color: String): MatchResult[Any] = testTextAndClick { (txt, cb) =>
        SuiButton(
          basic = true,
          color = new FacebookGoogleplusInstagramLinkedinTwitterVkYoutube(color),
          onClick = wrap(cb),
          label = txt
        )()
      }
      testTextAndClick((txt, cb) => SuiButton(basic = true, onClick = wrap(cb), label = txt)()) and
        testColor("red") and testColor("orange") and testColor("yellow") and testColor("olive") and
        testColor("green") and testColor("teal") and testColor("blue") and testColor("violet") and
        testColor("purple") and testColor("pink") and testColor("brown") and testColor("grey") and
        testColor("black")
    }
    "Inverted: A button can be formatted to appear on a dark background." >> {
      def genButton(color: String) =
        SuiButton(
          color = new FacebookGoogleplusInstagramLinkedinTwitterVkYoutube(color),
          label = color,
          inverted = true
        )()

      val rendered = ReactTestUtils
        .renderIntoDocument(SuiSegment(inverted = true)(
          SuiButton(inverted = true)("Standard"),
          genButton("red"),
          genButton("orange"),
          genButton("yellow"),
          genButton("olive"),
          genButton("green"),
          genButton("teal"),
          genButton("blue"),
          genButton("violet"),
          genButton("purple"),
          genButton("pink"),
          genButton("brown"),
          genButton("grey"),
          genButton("black")
        ))
        .outerHtmlScrubbed()
      (rendered must contain("Standard")) and (rendered must contain("violet"))
    }
  }

  "GROUPS" >> {
    "Group: Buttons can exist together as a group." >> {
      val rendered = ReactTestUtils
        .renderIntoDocument(
          SuiButtonGroup()(
            SuiButton()("One"),
            SuiButton()("Two"),
            SuiButton()("Three")
          ))
        .outerHtmlScrubbed()
      (rendered must contain("One")) and (rendered must contain("Two")) and (rendered must contain(
        "Three"))
    }
  }
}
