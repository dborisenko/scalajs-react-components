scalajs-react-components
========================

[![Build Status](https://travis-ci.org/dborisenko/scalajs-react-components.svg?branch=master)](https://travis-ci.org/dborisenko/scalajs-react-components)
[![License](https://img.shields.io/github/license/dborisenko/scalajs-react-components.svg)](LICENSE)
[![scalajs-react](https://img.shields.io/badge/scalajs--react-1.2.3-blue.svg)](https://github.com/japgolly/scalajs-react)
[![react](https://img.shields.io/badge/react-16.5.0-blue.svg)](https://reactjs.org)

Reusable [scalajs-react](https://github.com/japgolly/scalajs-react) components.

This project was initially a clone of [chandu0101/scalajs-react-components](https://github.com/chandu0101/scalajs-react-components) project, but with updated version of [japgolly/scalajs-react](https://github.com/japgolly/scalajs-react) library. But during the upgrade it was discovered that some of the components cannot be migrated to the latest version of React. Therefore the author took a decision to extract some of the components into separate projcet to simplify the update.

We are trying to make the experience of using javascript components in scala.js as good as possible by adding typed wrappers.

Adding types to javascript is a lot of guesswork, and we're certain to have gotten them wrong
 some places. Bug reports and/or pull requests are very much welcome! :)

# Semantic UI
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/semantic-ui_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/semantic-ui_sjs0.6_2.12)
[![react](https://img.shields.io/badge/semantic--ui--react-0.82.3-blue.svg)](https://www.npmjs.com/package/semantic-ui-react)

Module `semantic-ui` contains scalajs wrapper for [semantic-ui-react](https://react.semantic-ui.com) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "semantic-ui" % "0.0.1"
)
npmDependencies in Compile ++= Seq(
  "semantic-ui-react" -> "0.82.3",
  "react" -> "16.5.0",
  "react-dom" -> "16.5.0"
)
```

Example of usage:

```scala
SuiButton(animated = true, onClick = (_: ReactMouseEventFromInput) => Callback(???))(
  SuiButtonContent(visible = true)("Hello, World!"),
  SuiButtonContent(hidden = true)(SuiIcon(name = SuiIconType("arrow right"))())
)
```
