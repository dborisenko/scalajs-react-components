package com.dbrsn

import java.io.File

import ammonite.ops.Path

package object generator {
  private[generator] def panic(s: String): Nothing =
    throw new RuntimeException(s)

  def padTo(s: String)(n: Int): String =
    s + (" " * (n - s.length))

  def indent(n: Int): String =
    "  " * n

  def add(_p: Path, frags: String): Path =
    frags.split("/").filterNot(_.isEmpty).foldLeft(_p) {
      case (p, ".") ⇒ p
      case (p, "..") ⇒ p.copy(segments = p.segments.dropRight(1))
      case (p, frag) ⇒ p / frag
    }

  def exists(path: Path): Boolean =
    new File(path.toString).exists

  def printToFile(f: Path)(op: java.io.PrintWriter => Unit): Unit = {
    val p = new java.io.PrintWriter(f.toIO, "UTF-8")
    try { op(p) } finally { p.close() }
  }
}
