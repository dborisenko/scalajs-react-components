// Scala.js, the Scala to JavaScript compiler
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.25")

// Module bundler for Scala.js projects that use NPM packages
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.13.1")

// SBT plugin that can check Maven and Ivy repositories for dependency updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.4")

// Scalafmt SBT plugin
addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.15")

// Scalastyle examines your Scala code and indicates potential problems with it
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

// Flexible Scala code linting tool
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.3.5")

// A release plugin for sbt
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.9")

// A sbt plugin for publishing Scala/Java projects to the Maven central
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.3")

// PGP plugin for sbt
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.2")
