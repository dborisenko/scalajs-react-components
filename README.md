scalajs-react-components
========================

[![scalajs-react](https://img.shields.io/badge/scalajs--react-1.2.3-blue.svg)](https://github.com/japgolly/scalajs-react)
[![react](https://img.shields.io/badge/react-16.5.0-blue.svg)](https://reactjs.org)

Reusable [scalajs-react](https://github.com/japgolly/scalajs-react) components.

This project was initially a clone of [chandu0101/scalajs-react-components](https://github.com/chandu0101/scalajs-react-components) project, but with updated version of [japgolly/scalajs-react](https://github.com/japgolly/scalajs-react) library. But during the upgrade it was discovered that some of the components cannot be migrated to the latest version of React. Therefore the author took a decision to extract some of the components into separate projcet to simplify the update.

We are trying to make the experience of using javascript components in scala.js as good as possible by adding typed wrappers.

Adding types to javascript is a lot of guesswork, and we're certain to have gotten them wrong
 some places. Bug reports and/or pull requests are very much welcome! :)

# Modules

## Semantic UI
[![react](https://img.shields.io/badge/semantic--ui--react-0.82.3-blue.svg)](https://www.npmjs.com/package/semantic-ui-react)

Module `semantic-ui` contains scalajs wrapper for [semantic-ui-react](https://react.semantic-ui.com) component.

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "semantic-ui" % version
)
```

## Gotchas

#### You have to call `apply` even when components dont have children:
```scala
MuiRaisedButton(label = "label")()
```

## Setup

#### SBT
Add these dependencies to you sbt build file
```scala
libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "1.1.0",
  "com.github.japgolly.scalajs-react" %%% "extra" % "1.1.0",
  "com.olvind" %%% "scalajs-react-components" % "1.0.0-M2"
)
```

This repository includes an example project, by all means use it as a template for your own.


#### ScalaCSS
In order to use the scala.js components, you need to make sure you load their CSS:
```scala
GlobalRegistry.register(<component>.Style)
```
See [here](https://japgolly.github.io/scalacss/book/ext/react.html) for more details

## Full Demo With Code Examples

**Online :**

http://chandu0101.github.io/scalajs-react-components

**Local :** This will start a web server on http://localhost:8080
```
sbt 
fastOptJS::webpack
demo/compile:fastOptJS::startWebpackDevServer

```

## Example project

We've included an example project to give you an idea how to use the components