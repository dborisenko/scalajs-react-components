package com.dbrsn.generator.requiresjs

import ammonite.ops.Path

import scala.collection.mutable

class ScanCtx {

  private val parsedFiles = mutable.Map.empty[Path, ParsedFile]
  private val requiredFiles = mutable.Map.empty[Path, Lazy[Required]]

  def parsedFile(p: Path): ParsedFile =
    parsedFiles.getOrElseUpdate(p, JsParser(p))

  def required(p: Path, require: ScanCtx ⇒ Lazy[Required]): Lazy[Required] =
    requiredFiles.getOrElseUpdate(p, new Lazy(this).flatMap(require))

}
