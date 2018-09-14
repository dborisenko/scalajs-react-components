package com.olvind

import java.io.File

import ammonite.ops.{Path, RelPath}
import com.olvind.requiresjs._

import scala.collection.mutable

object Runner {

  def preludeFor(library: Library): String =
    s"""package com.dbrsn.scalajs.react.${library.name}
       |
       |import com.dbrsn.scalajs.react.macros.tojs.JSMacro
       |import japgolly.scalajs.react._
       |import japgolly.scalajs.react.component.Js._
       |import japgolly.scalajs.react.raw._
       |import japgolly.scalajs.react.vdom._
       |import org.scalajs.dom
       |import scala.scalajs.js
       |import scala.scalajs.js.`|`
       |
       |/**
       | * This file is generated - submit issues instead of PR against it
       | */
    """.stripMargin

  def destinationPathFor(outputPath: Path, prefixOpt: Option[String], comp: CompName): Path = {
    val baseFile = comp.value + ".scala"
    val filename = prefixOpt.fold(baseFile)(_ + baseFile)
    outputPath / filename
  }

  def foundComponentsFor(library: Library): Seq[FoundComponent] = {
    val visited = mutable.HashSet.empty[Path]

    def flattenScan(r: Required): Seq[FoundComponent] =
      r match {
        case NotFound(path) =>
          // scalastyle:off regex
          System.err.println(s"not found required path: $path")
          // scalastyle:on regex
          Seq.empty[FoundComponent]

        case Single(n, c) =>
          Seq(c)

        case Multiple(path, rs) =>
          if (visited.contains(path)) {
            Seq.empty[FoundComponent]
          } else {
            visited += path
            val requireds: Seq[Required] = rs.map(_.run).toList
            val recursive: Seq[FoundComponent] = requireds flatMap flattenScan
            // scalastyle:off regex
            System.err.println(s"Found in path $path: ${recursive.map(_.name.value)}")
            // scalastyle:on regex

            recursive
          }
      }

    library.locations.map(requiresjs.Require(_, library.indexNames)).flatMap(flattenScan)
  }

  // scalastyle:off method.length
  def apply(library: Library, outputFolder: Path): Seq[Path] = {
    val foundComponents: Seq[FoundComponent] = foundComponentsFor(library)

    val allFound: Map[CompName, FoundComponent] = foundComponents.map(c => c.name -> c).toMap

    val (mainFiles: Seq[PrimaryOutFile], secondaryFiles: Seq[SecondaryOutFile]) =
      library.components.foldLeft((Seq.empty[PrimaryOutFile], Seq.empty[SecondaryOutFile])) {
        case ((ps, ss), c) =>
          val parsed: ParsedComponent = ParseComponent(allFound, library, c)

          val (primaryFile, secondaryFile) = Printer(library.prefixOpt.getOrElse(""), parsed)

          (ps :+ primaryFile, ss ++ secondaryFile)
      }

    val fullOutputPath = outputFolder / RelPath(
      library.packageName.replaceAll("\\.", if (File.separator == "\\") "\\\\" else File.separator)
    )
    fullOutputPath.toIO.mkdirs()

    val prelude: String =
      preludeFor(library)

    val secondary: Path = fullOutputPath / "gen-types.scala"
    printToFile(secondary) { w =>
      // scalastyle:off regex
      w.println(prelude)
      // scalastyle:on regex
      secondaryFiles.sortBy(_.content).distinct.foreach { file =>
        // scalastyle:off regex
        w.println(file.content)
        w.println("")
        // scalastyle:on regex
      }
    }

    val outs: Seq[(PrimaryOutFile, Path)] =
      mainFiles map (f => (f, destinationPathFor(fullOutputPath, library.prefixOpt, f.filename)))

    outs.foreach {
      case (PrimaryOutFile(compName, content, secondaries), file) =>
        printToFile(file) { w =>
          // scalastyle:off regex
          w.println(prelude + content)
          // scalastyle:on regex
          secondaries.foreach {
            case SecondaryOutFile(_, c) =>
              // scalastyle:off regex
              w.println("")
              w.println(c)
            // scalastyle:on regex
          }
        }
    }
    outs.map(_._2) :+ secondary
  }
  // scalastyle:off method.length
}
