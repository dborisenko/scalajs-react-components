package com.dbrsn.scalajs.react.syntax.highlighter
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

sealed trait PrismStyle extends js.Any

object PrismStyle {
  // scalastyle:off object.name
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/coy", JSImport.Default)
  object coy extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/dark", JSImport.Default)
  object dark extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/funky", JSImport.Default)
  object funky extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/okaidia", JSImport.Default)
  object okaidia extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/solarizedlight", JSImport.Default)
  object solarizedlight extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/tomorrow", JSImport.Default)
  object tomorrow extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/twilight", JSImport.Default)
  object twilight extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/prism", JSImport.Default)
  object prism extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/atomDark", JSImport.Default)
  object atomDark extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/base16AteliersulphurpoolLight", JSImport.Default)
  object base16AteliersulphurpoolLight extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/cb", JSImport.Default)
  object cb extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/darcula", JSImport.Default)
  object darcula extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/duotoneDark", JSImport.Default)
  object duotoneDark extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/duotoneEarth", JSImport.Default)
  object duotoneEarth extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/duotoneForest", JSImport.Default)
  object duotoneForest extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/duotoneLight", JSImport.Default)
  object duotoneLight extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/duotoneSea", JSImport.Default)
  object duotoneSea extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/duotoneSpace", JSImport.Default)
  object duotoneSpace extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/ghcolors", JSImport.Default)
  object ghcolors extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/hopscotch", JSImport.Default)
  object hopscotch extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/pojoaque", JSImport.Default)
  object pojoaque extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/vs", JSImport.Default)
  object vs extends PrismStyle
  @js.native @JSImport("react-syntax-highlighter/dist/styles/prism/xonokai", JSImport.Default)
  object xonokai extends PrismStyle
  // scalastyle:on object.name
}
