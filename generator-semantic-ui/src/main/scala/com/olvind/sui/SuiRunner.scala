package com.olvind
package sui

object SuiRunner extends App {
  args.toList match {
    case OutputFolder(buildFolder) :: OutputFolder(outputFolder) :: Nil =>
      Runner(SuiLibrary(buildFolder), outputFolder)

    case _ =>
      // scalastyle:off regex
      System.err.println("Syntax: SuiRunner <directory with transpiled javascript> <output folder>")
      // scalastyle:on regex
      System.exit(1)
  }
}
