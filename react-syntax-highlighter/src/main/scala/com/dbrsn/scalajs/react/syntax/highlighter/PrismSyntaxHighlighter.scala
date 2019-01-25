package com.dbrsn.scalajs.react.syntax.highlighter

import com.dbrsn.scalajs.react.macros.tojs.JSMacro
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedWithRawType}
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.vdom.VdomNode
import japgolly.scalajs.react.{Children, JsComponent}

import scala.scalajs.js
import scala.scalajs.js.{|, undefined, UndefOr}

final case class PrismSyntaxHighlighter(
  /**
    * language - the language to highlight code in. (pass text to just render plain monospaced text).
    */
  language: PrismLanguage,
  /**
    * style - style object required from styles/prism directory depending on whether or not you are
    * importing from react-syntax-highlighter/prism. Will use default if style is not included.
    */
  style: UndefOr[PrismStyle] = undefined,
  /**
    * customStyle - prop that will be combined with the top level style on the pre tag, styles here will overwrite
    * earlier styles.
    * Default value: customStyle = {}
    */
  customStyle: UndefOr[Style] = undefined,
  /**
    * codeTagProps - props that will be spread into the <code> tag that is the direct parent of the highlighted code
    * elements. Useful for styling/assigning classNames.
    * Default value: codeTagProps = { style: style['code[class*="language-"]'] }
    */
  codeTagProps: UndefOr[Props] = undefined,
  /**
    * useInlineStyles - if this prop is passed in as false, react syntax highlighter will not add style objects to
    * elements, and will instead append classNames. You can then style the code block by using one of the CSS files
    * provided by highlight.js.
    * Default value: useInlineStyles = true
    */
  useInlineStyles: UndefOr[Boolean] = undefined,
  /**
    * showLineNumbers - if this is enabled line numbers will be shown next to the code block.
    * Default value: showLineNumbers = false
    */
  showLineNumbers: UndefOr[Boolean] = undefined,
  /**
    * startingLineNumber - if showLineNumbers is enabled the line numbering will start from here.
    * Default value: startingLineNumber = 1
    */
  startingLineNumber: UndefOr[Int] = undefined,
  /**
    * lineNumberContainerStyle - the line numbers container default to appearing to the left with 10px of right padding.
    * You can use this to override those styles.
    * Default value: lineNumberContainerStyle = { float: 'left', paddingRight: '10px' }
    */
  lineNumberContainerStyle: UndefOr[Style] = undefined,
  /**
    * lineNumberStyle - inline style to be passed to the span wrapping each number. Can be either an object or a
    * function that recieves current line number as argument and returns style object.
    * Example: lineNumberStyle = {lineNumber => {
    *               let style = { display: 'block' };
    *               if (ADDED.includes(lineNumber)) {
    *                 style.backgroundColor = '#dbffdb';
    *               }
    *               else if (REMOVED.includes(lineNumber)) {
    *                 style.backgroundColor = '#ffecec';
    *               }
    *               return style;
    *             }}
    */
  lineNumberStyle: UndefOr[Style | Int => Style] = undefined,
  /**
    * wrapLines - a boolean value that determines whether or not each line of code should be wrapped in a parent
    * element. defaults to false, when false one can not take action on an element on the line level.
    */
  wrapLines: UndefOr[Boolean] = undefined,
  /**
    * lineProps - props to be passed to the span wrapping each line if wrapLines is true. Can be either an object or a
    * function that recieves current line number as argument and returns props object.
    * Default value: lineProps = {}
    */
  lineProps: js.UndefOr[Props] = undefined,
  /**
    * renderer - an optional custom renderer for rendering lines of code.
    */
  renderer: js.UndefOr[js.Any] = undefined,
  /**
    * PreTag - the element or custom react component to use in place of the default pre tag, the outermost tag of the
    * component (useful for custom renderer not targeting DOM).
    * Default value: PreTag = 'pre
    */
  PreTag: UndefOr[String | Element] = undefined,
  /**
    * CodeTag - the element or custom react component to use in place of the default code tag, the second tag of the
    * component tree (useful for custom renderer not targeting DOM).
    */
  CodeTag: UndefOr[String | Element] = undefined
) {
  def apply(children: VdomNode*): UnmountedWithRawType[js.Object, Null, RawMounted[js.Object, Null]] = {

    val props = JSMacro[PrismSyntaxHighlighter](this)
    val f = JsComponent[js.Object, Children.Varargs, Null](RawPrismSyntaxHighlighter)
    f(props)(children: _*)
  }
}
