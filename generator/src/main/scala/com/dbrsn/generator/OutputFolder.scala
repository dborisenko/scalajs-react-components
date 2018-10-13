package com.dbrsn.generator

import ammonite.ops.FileType.Dir
import ammonite.ops.{mkdir, pwd, Path}

import scala.util.{Failure, Success, Try}

object OutputFolder {
  def unapply(s: String): Option[Path] =
    Try {
      val p = Path(s, pwd)
      if (!exists(p)) {
        mkdir(p)
      }

      (p, p.fileType)
    } match {
      case Success((p, Dir)) =>
        Some(p)
      case Success((_, _)) =>
        // scalastyle:off regex
        System.err.println(s"Illegal argument: s. must be folder")
        // scalastyle:on regex
        None
      case Failure(th) =>
        // scalastyle:off regex
        System.err.println(s"Illegal argument $s: ${th.getMessage}")
        // scalastyle:on regex
        None
    }
}
