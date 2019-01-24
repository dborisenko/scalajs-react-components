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

# Semantic UI React
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/semantic-ui-react_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/semantic-ui-react_sjs0.6_2.12)
[![react](https://img.shields.io/badge/semantic--ui--react-0.84.0-blue.svg)](https://www.npmjs.com/package/semantic-ui-react)

Semantic is a UI framework designed for theming.

Module `semantic-ui-react` contains scalajs wrapper for [semantic-ui-react](https://react.semantic-ui.com) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "semantic-ui-react" % "0.2.0"
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

Don't forget to add styles to your html:
```html
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/semantic-ui@2.4.1/dist/semantic.min.css" />
```

# React Sortable (HOC)
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/react-sortable-hoc_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/react-sortable-hoc_sjs0.6_2.12)
[![react](https://img.shields.io/badge/react--sortable--hoc-1.4.0-blue.svg)](https://www.npmjs.com/package/react-sortable-hoc)

A set of higher-order components to turn any list into an animated, touch-friendly, sortable list.

Module `react-sortable-hoc` contains scalajs wrapper for [react-sortable-hoc](https://github.com/clauderic/react-sortable-hoc) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "react-sortable-hoc" % "0.2.0"
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

Pluggable components to add a trello-like kanban board to your application.

Module `react-trello` contains scalajs wrapper for [react-trello](https://www.npmjs.com/package/react-trello) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "react-trello" % "0.2.0"
)
npmDependencies in Compile ++= Seq(
  "react-trello" -> "2.0.8",
  "@babel/runtime" -> "7.3.1",
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

# STORM React Diagrams
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/storm-react-diagrams_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/storm-react-diagrams_sjs0.6_2.12)
[![react](https://img.shields.io/badge/storm--react--diagrams-5.2.1-blue.svg)](https://www.npmjs.com/package/storm-react-diagrams)

A super simple, no-nonsense diagramming library written in React that just works.

Module `storm-react-diagrams` contains scalajs wrapper for [storm-react-diagrams](https://www.npmjs.com/package/storm-react-diagrams) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "storm-react-diagrams" % "0.2.0"
)
npmDependencies in Compile ++= Seq(
  "storm-react-diagrams" -> "5.2.1",
  "react" -> "16.7.0",
  "react-dom" -> "16.7.0"
)
```

Example of usage:

```scala
// 1) setup the diagram engine
val engine = new DiagramEngine()
engine.installDefaultFactories()

// 2) setup the diagram model
val model = new DiagramModel()

// 3) create a default node
val node1 = new DefaultNodeModel("Node 1", "rgb(0,192,255)")
val port1 = node1.addOutPort(s"Out")
node1.setPosition(pos1x, pos1y)

// 4) create another default node
val node2 = new DefaultNodeModel("Node 2", "rgb(192,255,0)")
val port2 = node2.addInPort(s"In")
node2.setPosition(pos2x, pos2y)

// 5) link the ports
val link1 = port1.link(port2)

// 6) add the models to the root graph
model.addAll(node1, node2, link1)

// 7) load model into engine
engine.setDiagramModel(model)

StormReactDiagramWidget.Props(engine).render
```

Don't forget to add styles to your html:

```html
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/storm-react-diagrams@5.2.1/dist/style.min.css" />
```

# react-markdown
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/react-markdown_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/react-markdown_sjs0.6_2.12)
[![react](https://img.shields.io/badge/react--markdown-4.0.6-blue.svg)](https://www.npmjs.com/package/react-markdown)

Renders Markdown as pure React components.

Module `react-markdown` contains scalajs wrapper for [react-markdown](https://www.npmjs.com/package/react-markdown) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "react-markdown" % "0.2.0"
)
npmDependencies in Compile ++= Seq(
  "react-markdown" -> "4.0.6",
  "react" -> "16.7.0",
  "react-dom" -> "16.7.0"
)
```

Example of usage:

```scala
ReactMarkdown(source = "# This is a header\n\nAnd this is a paragraph")()
```

# React Syntax Highlighter
[![Maven Central](https://img.shields.io/maven-central/v/com.dbrsn.scalajs.react.components/react-syntax-highlighter_sjs0.6_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/com.dbrsn.scalajs.react.components/react-syntax-highlighter_sjs0.6_2.12)
[![react](https://img.shields.io/badge/react--syntax--highlighter-10.1.2-blue.svg)](https://www.npmjs.com/package/react-syntax-highlighter)

Syntax highlighting component for react with prismjs or highlightjs ast using inline styles.

Module `react-syntax-highlighter` contains scalajs wrapper for [react-syntax-highlighter](https://www.npmjs.com/package/react-syntax-highlighter) component.

Add dependencies in `build.sbt`:

```scala
libraryDependencies ++= Seq(
  "com.dbrsn.scalajs.react.components" %%% "react-syntax-highlighter" % "0.2.0"
)
npmDependencies in Compile ++= Seq(
  "react-syntax-highlighter" -> "10.1.2",
  "babel-runtime" -> "6.26.0",
  "react" -> "16.7.0",
  "react-dom" -> "16.7.0"
)
```

Example of usage:

For highlightjs-based component:
```scala
SyntaxHighlighter(HljsLanguage.javascript, style = HljsStyle.docco)("(num) => num + 1")
```

For prismjs-based component:
```scala
PrismSyntaxHighlighter(PrismLanguage.javascript, style = PrismStyle.dark)("(num) => num + 1")
```
