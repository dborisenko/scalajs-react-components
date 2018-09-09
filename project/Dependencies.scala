import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import sbt.Def
import sbt.librarymanagement.DependencyBuilders

object Dependencies extends DependencyBuilders {
  type NpmDependency = (String, String)

  object Versions {
    lazy val scala = "2.12.6"

    // Scala: JVM libraries
    lazy val `ammonite-ops` = "1.0.1"

    // Scala: JS libraries
    lazy val `scalajs-react` = "1.2.3"

    // Scala: JVM + JS libraries
    lazy val scalatest = "3.0.5"
    lazy val specs2 = "4.3.4"

    // JavaScript: Node.js libraries
    lazy val `semantic-ui-react` = "0.82.3"
    lazy val react = "16.5.0"
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
  lazy val react: NpmDependency = "react" -> Versions.react
  lazy val `react-dom`: NpmDependency = "react-dom" -> Versions.react
}
