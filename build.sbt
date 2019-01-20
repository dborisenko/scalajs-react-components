import sbtrelease.ReleaseStateTransformations._
import xerial.sbt.Sonatype.GitHubHosting
import xerial.sbt.Sonatype.SonatypeCommand.sonatypeRelease

inThisBuild(
  List(
    scalaVersion := Dependencies.Versions.scala,
    organization := "com.dbrsn.scalajs.react.components",
    scalacOptions := Seq(
      "-deprecation", // warning and location for usages of deprecated APIs
      "-encoding",
      "UTF-8",
      "-feature", // warning and location for usages of features that should be imported explicitly
      "-unchecked", // additional warnings where generated code depends on assumptions
      "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
      "-Xfuture", // Turn on future language features.
      "-Yno-adapted-args", // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
      "-Ypartial-unification", // Enable partial unification in type constructor inference
      "-Ywarn-dead-code", // Warn when dead code is identified.
      "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
      "-Ywarn-infer-any", // Warn when a type argument is inferred to be `Any`.
      "-Ywarn-nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
      "-Ywarn-nullary-unit", // Warn when nullary methods return Unit.
      "-Ywarn-numeric-widen", // Warn when numerics are widened.
      "-Ywarn-value-discard", // Warn when non-Unit expression results are unused.
      "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
      "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
      "-Xlint:adapted-args", // Warn if an argument list is modified to match the receiver.
      "-Xlint:by-name-right-associative", // By-name parameter of right associative operator.
      "-Xlint:delayedinit-select", // Selecting member of DelayedInit.
      "-Xlint:doc-detached", // A Scaladoc comment appears to be detached from its element.
      "-Xlint:inaccessible", // Warn about inaccessible types in method signatures.
      "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
      "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
      "-Xlint:nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
      "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
      "-Xlint:option-implicit", // Option.apply used implicit view.
      "-Xlint:package-object-classes", // Class or object defined in package object.
      "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
      "-Xlint:private-shadow", // A private field (or class parameter) shadows a superclass field.
      "-Xlint:stars-align", // Pattern sequence wildcard must align with sequence component.
      "-Xlint:type-parameter-shadow", // A local type parameter shadows a type already in scope.
      "-Xlint:unsound-match", // Pattern match may not be typesafe.
      "-Xlint:constant", // Evaluation of a constant arithmetic expression results in an error.
      "-Ywarn-unused:implicits", // Warn if an implicit parameter is unused.
      "-Ywarn-unused:locals", // Warn if a local definition is unused.
      "-Ywarn-unused:params", // Warn if a value parameter is unused.
      "-Ywarn-unused:patvars", // Warn if a variable bound in a pattern is unused.
      "-Ywarn-unused:privates" // Warn if a private member is unused.
    ),
    scalafmtOnCompile := true,
    scalafmtTestOnCompile := true
  )
)

lazy val commonSettings = List(
  scalastyleFailOnError := true,
  scalastyleFailOnWarning := true,
  wartremoverErrors in (Compile, compile) := Warts.all,
  wartremoverErrors in (Test, compile) := Warts.all
)

lazy val publishSettings = List(
  sonatypeProfileName := "com.dbrsn",
  publishTo := sonatypePublishTo.value,
  licenses += ("Apache 2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
  mappings.in(Compile, packageBin) += baseDirectory.in(ThisBuild).value / "LICENSE" -> "LICENSE",
  sonatypeProjectHosting := Some(GitHubHosting("dborisenko", "scalajs-react-components", "dborisenko@gmail.com")),
  homepage := Some(url("https://github.com/dborisenko/scalajs-react-components")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/dborisenko/scalajs-react-components"),
      "scm:git:git://github.com:dborisenko/scalajs-react-components.git"
    )
  ),
  developers := List(
    Developer(
      id = "chandu0101",
      name = "Chandra Sekhar Kode",
      email = "chandu.csu2010@gmail.com",
      url = url("https://github.com/chandu0101")
    ),
    Developer(
      id = "oyvindberg",
      name = "Øyvind Raddum Berg",
      email = "elacin@gmail.com",
      url = url("https://github.com/oyvindberg")
    ),
    Developer(
      id = "fmcgough",
      name = "Frankie",
      email = "",
      url = url("https://github.com/fmcgough")
    ),
    Developer(
      id = "roberto@leibman.net",
      name = "Roberto Leibman",
      email = "",
      url = url("http://leibman.net")
    ),
    Developer(
      id = "dborisenko",
      name = "Denis Borisenko",
      email = "dborisenko@gmail.com",
      url = url("http://dbrsn.com")
    )
  )
)

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommand("publishSigned"),
  releaseStepCommand(sonatypeRelease),
  setNextVersion,
  commitNextVersion,
  pushChanges
)

lazy val macros = project
  .in(file("macros"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.`scalajs-react-core`.value,
      Dependencies.`scalajs-react-extra`.value,
      Dependencies.scalatest.value % Test
    )
  )
  .settings(
    wartremoverErrors in (Compile, compile) := Warts.allBut(
      Wart.Any,
      Wart.AnyVal,
      Wart.NonUnitStatements,
      Wart.Nothing,
      Wart.Null,
      Wart.OptionPartial,
      Wart.Recursion,
      Wart.ToString,
      Wart.TraversableOps
    ),
    wartremoverErrors in (Test, compile) := Warts.allBut(
      Wart.Any,
      Wart.ArrayEquals,
      Wart.AsInstanceOf,
      Wart.DefaultArguments,
      Wart.Equals,
      Wart.IsInstanceOf,
      Wart.Null,
      Wart.OptionPartial,
      Wart.ToString
    )
  )

lazy val generator = project
  .in(file("generator"))
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.`ammonite-ops`,
      Dependencies.scalatest.value % Test
    )
  )
  .settings(
    wartremoverErrors in (Compile, compile) := Warts.allBut(
      Wart.Any,
      Wart.Equals,
      Wart.MutableDataStructures,
      Wart.NonUnitStatements,
      Wart.Recursion,
      Wart.Option2Iterable,
      Wart.DefaultArguments,
      Wart.ToString,
      Wart.Throw,
      Wart.TraversableOps,
      Wart.OptionPartial,
      Wart.AsInstanceOf,
      Wart.Var,
      Wart.Overloading
    ),
    wartremoverErrors in (Test, compile) := Warts.allBut(Wart.Any, Wart.NonUnitStatements)
  )

lazy val `generator-semantic-ui-react` = project
  .in(file("generator-semantic-ui-react"))
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(
    version in webpack := Dependencies.Versions.webpack,
    libraryDependencies ++= Seq(
      Dependencies.scalatest.value % Test
    )
  )
  .settings(
    useYarn := true,
    npmDependencies in Compile := Seq(
      Dependencies.`semantic-ui-react`,
      Dependencies.react,
      Dependencies.`react-dom`
    )
  )
  .settings(
    wartremoverErrors in (Compile, compile) := Warts
      .allBut(Wart.NonUnitStatements, Wart.Recursion, Wart.TraversableOps, Wart.Overloading, Wart.Equals, Wart.Throw)
  )
  .dependsOn(generator)

lazy val generateSui = TaskKey[Seq[File]]("generateSui")

lazy val `semantic-ui-react` = project
  .in(file("semantic-ui-react"))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings)
  .settings(publishSettings)
  .dependsOn(macros)
  .settings(
    generateSui := {
      val genDir = sourceManaged.value
      genDir.mkdirs()
      val res = runner.value.run(
        "com.dbrsn.generator.sui.SuiRunner",
        (fullClasspath in (`generator-semantic-ui-react`, Runtime)).value.files,
        List(
          (npmUpdate in (`generator-semantic-ui-react`, Compile)).value / "node_modules" / "semantic-ui-react" / "dist" / "commonjs",
          sourceManaged.value / "main"
        ).map(_.absolutePath),
        streams.value.log
      )
      val pathFinder: PathFinder = sourceManaged.value ** "*.scala"
      pathFinder.get.filter(_.getAbsolutePath.contains("semanticui"))
    },
    sourceGenerators in Compile += generateSui
  )
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.`scalajs-react-test`.value % Test,
      Dependencies.specs2.value % Test
    ),
    npmDependencies in Test := Seq(
      Dependencies.`semantic-ui-react`,
      Dependencies.react,
      Dependencies.`react-dom`
    ),
    (org.scalajs.sbtplugin.ScalaJSPluginInternal.scalaJSRequestsDOM in Test) := true
  )
  .settings(
    wartremoverErrors in (Compile, compile) := Warts
      .allBut(Wart.Any, Wart.DefaultArguments, Wart.Nothing, Wart.Overloading),
    wartremoverErrors in (Test, compile) := Warts.allBut(Wart.Any, Wart.NonUnitStatements, Wart.Nothing)
  )

lazy val `react-sortable-hoc` = project
  .in(file("react-sortable-hoc"))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.`scalajs-react-core`.value,
      Dependencies.`scalajs-react-test`.value % Test,
      Dependencies.specs2.value % Test
    ),
    npmDependencies in Test := Seq(
      Dependencies.`react-sortable-hoc`,
      Dependencies.react,
      Dependencies.`react-dom`
    ),
    (org.scalajs.sbtplugin.ScalaJSPluginInternal.scalaJSRequestsDOM in Test) := true
  )
  .settings(
    wartremoverErrors in (Compile, compile) := Warts
      .allBut(Wart.MutableDataStructures, Wart.Any, Wart.AsInstanceOf, Wart.DefaultArguments, Wart.Nothing),
    wartremoverErrors in (Test, compile) := Warts.allBut(Wart.Any, Wart.NonUnitStatements, Wart.Nothing)
  )

lazy val `react-trello` = project
  .in(file("react-trello"))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.`scalajs-react-core`.value,
      Dependencies.`scalacss-ext-react`.value,
      Dependencies.`scalajs-react-test`.value % Test,
      Dependencies.specs2.value % Test
    ),
    npmDependencies in Test := Seq(
      Dependencies.`react-trello`,
      Dependencies.`babel-runtime`,
      Dependencies.react,
      Dependencies.`react-dom`
    ),
    (org.scalajs.sbtplugin.ScalaJSPluginInternal.scalaJSRequestsDOM in Test) := true
  )
  .settings(
    wartremoverErrors in (Compile, compile) := Warts
      .allBut(Wart.MutableDataStructures, Wart.Any, Wart.AsInstanceOf, Wart.DefaultArguments, Wart.Nothing),
    wartremoverErrors in (Test, compile) := Warts.allBut(Wart.Any, Wart.NonUnitStatements, Wart.Nothing)
  )
  .dependsOn(macros)

lazy val `storm-react-diagrams` = project
  .in(file("storm-react-diagrams"))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.`scalajs-react-core`.value,
      Dependencies.`scalajs-react-test`.value % Test,
      Dependencies.specs2.value % Test
    ),
    npmDependencies in Test := Seq(
      Dependencies.`storm-react-diagrams`,
      Dependencies.react,
      Dependencies.`react-dom`
    ),
    (org.scalajs.sbtplugin.ScalaJSPluginInternal.scalaJSRequestsDOM in Test) := true
  )
  .settings(
    wartremoverErrors in (Compile, compile) := Warts
      .allBut(Wart.Any, Wart.AsInstanceOf, Wart.Overloading, Wart.Nothing, Wart.DefaultArguments),
    wartremoverErrors in (Test, compile) := Warts.allBut(Wart.NonUnitStatements)
  )

lazy val `scalajs-react-components` = project
  .in(file("."))
  .settings(commonSettings)
  .settings(publishSettings)
  .aggregate(macros)
  .aggregate(`generator-semantic-ui-react`)
  .aggregate(`semantic-ui-react`)
  .aggregate(`react-sortable-hoc`)
  .aggregate(`react-trello`)
  .aggregate(`storm-react-diagrams`)
  .dependsOn(`semantic-ui-react`)
  .dependsOn(`react-sortable-hoc`)
  .dependsOn(`react-trello`)
  .dependsOn(`storm-react-diagrams`)
