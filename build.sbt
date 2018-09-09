// *****************************************************************************
// Projects
// *****************************************************************************

lazy val generateMui = TaskKey[Seq[File]]("generateMui")
lazy val generateEui = TaskKey[Seq[File]]("generateEui")
lazy val generateSui = TaskKey[Seq[File]]("generateSui")

lazy val core =
  project
    .in(file("core"))
    .dependsOn(macros)
    .enablePlugins(ScalaJSPlugin)
    .settings(commonSettings, publicationSettings)
    .settings(
      generateEui := {
        val genDir = sourceManaged.value
        genDir.mkdirs()
        val res = runner.value.run(
          "com.olvind.eui.EuiRunner",
          (fullClasspath in (generator, Runtime)).value.files,
          List(
            (npmUpdate in (generator, Compile)).value / "node_modules" / "elemental",
            sourceManaged.value / "main"
          ) map (_.absolutePath),
          streams.value.log
        )

        val pathFinder: PathFinder = sourceManaged.value ** "*.scala"
        pathFinder.get.filter(_.getAbsolutePath.contains("elemental"))
      },
      generateMui := {
        val genDir = sourceManaged.value
        genDir.mkdirs()
        val res = runner.value.run(
          "com.olvind.mui.MuiRunner",
          (fullClasspath in (generator, Runtime)).value.files,
          List(
            (npmUpdate in (generator, Compile)).value / "node_modules" / "material-ui",
            sourceManaged.value / "main"
          ) map (_.absolutePath),
          streams.value.log
        )
        val pathFinder: PathFinder = sourceManaged.value ** "*.scala"
        pathFinder.get.filter(_.getAbsolutePath.contains("material"))
      }
    )
    .settings(
      sourceGenerators in Compile += generateMui,
      sourceGenerators in Compile += generateEui,
      mappings in (Compile, packageSrc) ++= {
        val sourceDir    = (sourceManaged.value / "main").toPath
        def rel(f: File) = sourceDir.relativize(f.toPath).toString

        (managedSources in Compile).value map (s ⇒ s → rel(s))
      },
      libraryDependencies ++= Seq(
        "com.github.japgolly.scalajs-react" %%% "core"        % "1.1.1" withSources (),
        "com.github.japgolly.scalajs-react" %%% "extra"       % "1.1.1" withSources (),
        "com.github.japgolly.scalacss"      %%% "core"        % "0.5.5" withSources (),
        "com.github.japgolly.scalacss"      %%% "ext-react"   % "0.5.5" withSources (),
        "org.scala-js"                      %%% "scalajs-dom" % "0.9.4" withSources (),
        "org.scalacheck"                    %%% "scalacheck"  % "1.13.5" % Test,
        "org.scalatest"                     %%% "scalatest"   % "3.0.4" % Test
      )
    )

lazy val preventPublication = Seq(
  publishArtifact := false,
  publish := {},
  packagedArtifacts := Map.empty) // doesn't work - https://github.com/sbt/sbt-pgp/issues/42

lazy val demo =
  project
    .in(file("demo"))
    .dependsOn(core)
    .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
    .settings(commonSettings, preventPublication, npmSettings, npmDevSettings)
    .settings(
      name := "scalajs-react-components-demo",
      version in webpack := "2.6.1",
//      version in installWebpackDevServer := "2.7.1",
      scalaJSUseMainModuleInitializer := true,
      scalaJSUseMainModuleInitializer.in(Test) := false,
      artifactPath.in(Compile, fastOptJS) := ((crossTarget in (Compile, fastOptJS)).value /
        ((moduleName in fastOptJS).value + "-opt.js")),
      webpackResources :=
        webpackResources.value +++
          PathFinder(Seq(baseDirectory.value / "images", baseDirectory.value / "index.html")) ** "*.*",
      webpackConfigFile in Test := Some(baseDirectory.value / "webpack.config.test.js"),
      webpackConfigFile in (Compile, fastOptJS) := Some(
        baseDirectory.value / "webpack.config.dev.js"),
      webpackConfigFile in (Compile, fullOptJS) := Some(
        baseDirectory.value / "webpack.config.prod.js"),
      jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv,
      webpackBundlingMode := BundlingMode.LibraryOnly()
    )

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val commonSettings =
  Seq(
    scalaVersion := "2.12.6",
    version := "1.0.0-M2",
    name := "scalajs-react-components",
    organization := "com.olvind",
    homepage := Some(url("http://chandu0101.github.io/scalajs-react-components")),
    licenses += ("Apache 2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    mappings.in(Compile, packageBin) += baseDirectory.in(ThisBuild).value / "LICENSE" -> "LICENSE",
    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-unchecked", // Enable additional warnings where generated code depends on assumptions.
      "-language:implicitConversions", // Allow definition of implicit functions called views
      "-language:postfixOps",
      "-P:scalajs:sjsDefinedByDefault"
    ),
    unmanagedSourceDirectories.in(Compile) := Seq(scalaSource.in(Compile).value),
    unmanagedSourceDirectories.in(Test) := Seq(scalaSource.in(Test).value)
  )

lazy val publicationSettings = Seq(
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra :=
    <scm>
      <connection>scm:git:github.com:chandu0101/scalajs-react-components</connection>
      <developerConnection>scm:git:git@github.com:chandu0101/scalajs-react-components.git</developerConnection>
      <url>github.com:chandu0101/scalajs-react-components.git</url>
    </scm>
      <developers>
        <developer>
          <id>chandu0101</id>
          <name>Chandra Sekhar Kode</name>
        </developer>
        <developer>
          <id>oyvindberg</id>
          <name>Øyvind Raddum Berg</name>
        </developer>
        <developer>
          <id>fmcgough</id>
          <name>Frankie</name>
        </developer>
        <developer>
          <id>roberto@leibman.net</id>
          <name>Roberto Leibman</name>
        </developer>
      </developers>
)

lazy val SuiVersion   = "0.68.5"
lazy val EuiVersion   = "0.6.1"
lazy val MuiVersion   = "0.20.0"
lazy val reactVersion = "15.5.4"

lazy val npmSettings = Seq(
  useYarn := true,
  npmDependencies.in(Compile) := Seq(
    "elemental"                         -> EuiVersion,
    "highlight.js"                      -> "9.9.0",
    "material-ui"                       -> MuiVersion,
    "react"                             -> reactVersion,
    "react-dom"                         -> reactVersion,
    "react-addons-create-fragment"      -> "15.6.2",
    "react-addons-css-transition-group" -> "15.6.2",
    "react-addons-pure-render-mixin"    -> "15.6.2",
    "react-addons-transition-group"     -> "15.6.2",
    "react-addons-update"               -> "15.6.2",
    "react-geomicons"                   -> "2.1.0",
    "react-infinite"                    -> "0.12.1",
    "react-select"                      -> "1.2.1",
    "react-slick"                       -> "0.16.0",
    "react-spinner"                     -> "0.2.7",
    "react-split-pane"                  -> "0.1.74",
    "react-tagsinput"                   -> "3.16.1",
    "react-tap-event-plugin"            -> "2.0.1",
    "semantic-ui-react"                 -> SuiVersion,
    "svg-loader"                        -> "0.0.2"
  )
)

lazy val npmDevSettings = {
  val deps = Seq(
    "css-loader"           -> "0.28.9",
    "expose-loader"        -> "0.7.4",
    "file-loader"          -> "1.1.6",
    "gulp-decompress"      -> "2.0.1",
    "imagemin"             -> "5.3.1",
    "image-webpack-loader" -> "4.0.0",
    "less"                 -> "2.7.3",
    "less-loader"          -> "4.0.5",
    "lodash"               -> "4.17.4",
    "node-libs-browser"    -> "2.1.0",
    "react-hot-loader"     -> "3.1.3",
    "style-loader"         -> "0.19.0",
    "url-loader"           -> "0.6.2",
    "webpack"              -> "2.6.1",
    "webpack-dev-server"   -> "2.11.1"
  )

  Seq(
    npmDevDependencies in Test := deps,
    npmDevDependencies in Compile := deps
  )
}

// *****************************************************************************
// !!!!!
// *****************************************************************************

inThisBuild(
  List(
    scalaVersion := Dependencies.Versions.scala,
    organization := "com.dbrsn.scalajs.react.components",
    scalacOptions := Seq(
      "-deprecation", // warning and location for usages of deprecated APIs
      "-encoding", "UTF-8",
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
      "-Ywarn-unused:privates", // Warn if a private member is unused.
    )
  ))

lazy val macros = project
  .in(file("macros"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.`scalajs-react-core`.value,
      Dependencies.`scalajs-react-extra`.value,
      Dependencies.scalatest.value % Test
    )
  )

lazy val generator = project
  .in(file("gen"))
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    version in webpack := "2.6.1",
    libraryDependencies ++= Seq(
      Dependencies.`ammonite-ops`,
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
    scalacOptions := Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-unchecked", // Enable additional warnings where generated code depends on assumptions.
      "-language:implicitConversions", // Allow definition of implicit functions called views
      "-language:postfixOps",
      "-P:scalajs:sjsDefinedByDefault"
    )
  )
  .settings(
    publishArtifact := false
  )

lazy val `semantic-ui` = project
  .in(file("semantic-ui"))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(macros)
  .settings(
    generateSui := {
      val genDir = sourceManaged.value
      genDir.mkdirs()
      val res = runner.value.run(
        "com.olvind.sui.SuiRunner",
        (fullClasspath in (generator, Runtime)).value.files,
        List(
          (npmUpdate in (generator, Compile)).value / "node_modules" / "semantic-ui-react" / "dist" / "commonjs",
          sourceManaged.value / "main"
        ) map (_.absolutePath),
        streams.value.log
      )
      val pathFinder: PathFinder = sourceManaged.value ** "*.scala"
      pathFinder.get.filter(_.getAbsolutePath.contains("semanticui"))
    },
    sourceGenerators in Compile += generateSui
  )
  .settings(
    scalafmtOnCompile := true,
    scalafmtTestOnCompile := true
  )
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.`scalajs-react-test`.value % Test
    )
  )
