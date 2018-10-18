import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import sbt.Def
import sbt.librarymanagement.DependencyBuilders

object Dependencies extends DependencyBuilders {
  type NpmDependency = (String, String)

  object Versions {
    lazy val scala = "2.12.7"

    lazy val webpack = "2.6.1"

    // Scala: JVM libraries
    lazy val `ammonite-ops` = "1.0.1"

    // Scala: JS libraries
    lazy val `scalajs-react` = "1.3.1"

    // Scala: JVM + JS libraries
    lazy val scalatest = "3.0.5"
    lazy val specs2 = "4.3.5"

    // JavaScript: Node.js libraries
    lazy val `semantic-ui-react` = "0.82.5"
    lazy val react = "16.5.2"
    lazy val `react-sortable-hoc` = "0.8.3"
    lazy val `react-trello` = "2.0.1"
  }

  // Scala: JVM libraries
  lazy val `ammonite-ops` = "com.lihaoyi" %% "ammonite-ops" % Versions.`ammonite-ops`

  // Scala: JS libraries
  lazy val `scalajs-react-core` = Def.setting("com.github.japgolly.scalajs-react" %%% "core" % Versions.`scalajs-react`)
  lazy val `scalajs-react-extra` = Def.setting("com.github.japgolly.scalajs-react" %%% "extra" % Versions.`scalajs-react`)
  lazy val `scalajs-react-test` = Def.setting("com.github.japgolly.scalajs-react" %%% "test" % Versions.`scalajs-react`)

  // Scala: JVM + JS libraries
  lazy val scalatest = Def.setting("org.scalatest" %%% "scalatest" % Versions.scalatest)
  lazy val specs2 = Def.setting("org.specs2" %%% "specs2-core" % Versions.specs2)

  // JavaScript: Node.js libraries
  lazy val `semantic-ui-react`: NpmDependency = "semantic-ui-react" -> Versions.`semantic-ui-react`
  lazy val `react-sortable-hoc`: NpmDependency = "react-sortable-hoc" -> Versions.`react-sortable-hoc`
  lazy val `react-trello`: NpmDependency = "react-trello" -> Versions.`react-trello`
  lazy val react: NpmDependency = "react" -> Versions.react
  lazy val `react-dom`: NpmDependency = "react-dom" -> Versions.react
}
