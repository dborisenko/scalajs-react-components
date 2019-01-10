scalajs-react-components
========================

[![Build Status](https://travis-ci.org/dborisenko/scalajs-react-components.svg?branch=master)](https://travis-ci.org/dborisenko/scalajs-react-components)
[![License](https://img.shields.io/github/license/dborisenko/scalajs-react-components.svg)](LICENSE)
[![scalajs-react](https://img.shields.io/badge/scalajs--react-1.3.1-blue.svg)](https://github.com/japgolly/scalajs-react)
[![react](https://img.shields.io/badge/react-16.7.0-blue.svg)](https://reactjs.org)

Reusable [scalajs-react](https://github.com/japgolly/scalajs-react) components.

This project was initially a clone of [chandu0101/scalajs-react-components](https://github.com/chandu0101/scalajs-react-components) project, but with updated version of [japgolly/scalajs-react](https://github.com/japgolly/scalajs-react) library. But during the upgrade it was discovered that some of the components cannot be migrated to the latest version of React. Therefore the author took a decision to extract some of the components into separate projcet to simplify the update.

We are trying to make the experience of using javascript components in scala.js as good as possible by adding typed wrappers.

Adding types to javascript is a lot of guesswork, and we're certain to have gotten them wrong
 some places. Bug reports and/or pull requests are very much welcome! :)

# Semantic UI
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/semantic-ui-react_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/semantic-ui-react_sjs0.6_2.12)
[![react](https://img.shields.io/badge/semantic--ui--react-0.84.0-blue.svg)](https://www.npmjs.com/package/semantic-ui-react)

Module `semantic-ui-react` contains scalajs wrapper for [semantic-ui-react](https://react.semantic-ui.com) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "semantic-ui-react" % "0.0.8"
)
npmDependencies in Compile ++= Seq(
  "semantic-ui-react" -> "0.84.0",
  "react" -> "16.7.0",
  "react-dom" -> "16.7.0"
)
```

Example of usage:

```scala
SuiButton(animated = true, onClick = (_: ReactMouseEventFromHtml) => Callback(???))(
  SuiButtonContent(visible = true)("Hello, World!"),
  SuiButtonContent(hidden = true)(SuiIcon(name = SuiIconType("arrow right"))())
)
```

# React Sortable (HOC)
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/react-sortable-hoc_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/react-sortable-hoc_sjs0.6_2.12)
[![react](https://img.shields.io/badge/react--sortable--hoc-1.4.0-blue.svg)](https://www.npmjs.com/package/react-sortable-hoc)

Module `react-sortable-hoc` contains scalajs wrapper for [react-sortable-hoc](https://github.com/clauderic/react-sortable-hoc) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "react-sortable-hoc" % "0.0.8"
)
npmDependencies in Compile ++= Seq(
  "react-sortable-hoc" -> "1.4.0",
  "react" -> "16.7.0",
  "react-dom" -> "16.7.0"
)
```

Example of usage:

```scala
case class Model(text: String)
case class Props(model: Model)

val item1 = "Test 1"
val item2 = "Test 2"

SortableList[Model, Props].Props(
  listToDisplay = List(Model(item1), Model(item2)),
  sortableContainerProps = SortableContainer.Props(),
  externalProps = Props,
  itemComponent = raw
).render
```

# react-trello
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/react-trello_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/react-trello_sjs0.6_2.12)
[![react](https://img.shields.io/badge/react--trello-2.0.8-blue.svg)](https://www.npmjs.com/package/react-trello)

Module `react-trello` contains scalajs wrapper for [react-trello](https://www.npmjs.com/package/react-trello) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "react-trello" % "0.0.8"
)
npmDependencies in Compile ++= Seq(
  "react-trello" -> "2.0.8",
  "@babel/runtime" -> "7.2.0",
  "react" -> "16.7.0",
  "react-dom" -> "16.7.0"
)
```

Example of usage:

```scala
val data: Data[js.Object] = Data(
  Lane(id = LaneId("REPEAT"), title = "Repeat", label = "1/1", style = laneStyle)(
    Card(id = CardId("Repeat1"), title = "Morning Jog", label = "30 mins", description = "Track using fitbit")
  ),
  Lane(id = LaneId("ARCHIVED"), title = "Archived", label = "1/1", style = laneStyle)(
    Card(id = CardId("Archived1"), title = "Go Trekking", label = "300 mins", description = "Completed 10km on cycle")
  )
)

def onDataChange(nextData: Data[js.Object]): Callback =
  Callback.log("data has changed") >> Callback.log(s"next data: $nextData")

Board(
  data = data,
  draggable = true,
  collapsibleLanes = true,
  onDataChange = onDataChange _
)()
```
