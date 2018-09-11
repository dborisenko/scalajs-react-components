package com.olvind

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
        System.err.println(s"Illegal argument: s. must be folder")
        None
      case Failure(th) =>
        System.err.println(s"Illegal argument $s: ${th.getMessage}")
        None
    }
}
