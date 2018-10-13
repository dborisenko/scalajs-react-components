package com.dbrsn.scalajs.react.sortablehoc

import japgolly.scalajs.react.{Callback, Children, GenericComponent, JsComponent}

import scala.language.higherKinds
import scala.scalajs.js

/**
  * A facade to SortableContainer of https://github.com/clauderic/react-sortable-hoc
  */
object SortableContainer {

  @js.native
  protected trait Permutation extends js.Object {
    def oldIndex: Int = js.native
    def newIndex: Int = js.native
  }

  @js.native
  trait Props extends js.Object {
    def axis: js.UndefOr[String] = js.native
    def lockAxis: js.UndefOr[String] = js.native
    def helperClass: js.UndefOr[String] = js.native
    def transitionDuration: js.UndefOr[Int] = js.native
    def pressDelay: js.UndefOr[Int] = js.native
    def distance: js.UndefOr[Int] = js.native
    def useDragHandle: js.UndefOr[Boolean] = js.native
    def useWindowAsScrollContainer: js.UndefOr[Boolean] = js.native
    def hideSortableGhost: js.UndefOr[Boolean] = js.native
    def lockToContainerEdges: js.UndefOr[Boolean] = js.native
    //Note this function actually gets "{oldIndex, newIndex, collection}, e", but we don't have much use for the other arguments
    def onSortEnd: js.Function1[Permutation, Unit] = js.native
  }

  object Props {
    // scalastyle:off
    def apply(
      axis: js.UndefOr[String] = js.undefined,
      lockAxis: js.UndefOr[String] = js.undefined,
      helperClass: js.UndefOr[String] = SortableHandleIcon.HandleClassName,
      transitionDuration: js.UndefOr[Int] = js.undefined,
      pressDelay: js.UndefOr[Int] = js.undefined,
      distance: js.UndefOr[Int] = js.undefined,
      useDragHandle: js.UndefOr[Boolean] = js.undefined,
      useWindowAsScrollContainer: js.UndefOr[Boolean] = js.undefined,
      hideSortableGhost: js.UndefOr[Boolean] = js.undefined,
      lockToContainerEdges: js.UndefOr[Boolean] = js.undefined,
      //Note this function actually gets "{oldIndex, newIndex, collection}, e", but we don't have much use for the other arguments
      onSortEnd: IndexChange => Callback = _ => Callback.empty
    ): Props =
      js.Dynamic
        .literal(
          axis = axis,
          lockAxis = lockAxis,
          helperClass = helperClass,
          transitionDuration = transitionDuration,
          pressDelay = pressDelay,
          distance = distance,
          useDragHandle = useDragHandle,
          useWindowAsScrollContainer = useWindowAsScrollContainer,
          hideSortableGhost = hideSortableGhost,
          lockToContainerEdges = lockToContainerEdges,
          onSortEnd = js.defined { p: Permutation =>
            onSortEnd(IndexChange(p.oldIndex, p.newIndex)).runNow()
          }
        )
        .asInstanceOf[Props]
    // scalastyle:on
  }

  /**
    * @param wrappedComponent The wrapped component itself
    * @tparam P The type of Props of the wrapped component
    * @return A component wrapping the wrapped component...
    */
  def apply[P, CT[_, _]](
    wrappedComponent: GenericComponent[P, CT, _]
  ): Props => P => JsComponent.Unmounted[js.Object, Null] = { props => wrappedProps =>
    {
      val reactElement = SortableHOC.SortableContainer(wrappedComponent.raw)
      val component = JsComponent[js.Object, Children.None, Null](reactElement)
      val mergedProps = js.Dynamic.literal()
      mergedProps.updateDynamic("axis")(props.axis)
      mergedProps.updateDynamic("lockAxis")(props.lockAxis)
      mergedProps.updateDynamic("helperClass")(props.helperClass)
      mergedProps.updateDynamic("transitionDuration")(props.transitionDuration)
      mergedProps.updateDynamic("pressDelay")(props.pressDelay)
      mergedProps.updateDynamic("distance")(props.distance)
      mergedProps.updateDynamic("useDragHandle")(props.useDragHandle)
      mergedProps.updateDynamic("useWindowAsScrollContainer")(props.useWindowAsScrollContainer)
      mergedProps.updateDynamic("hideSortableGhost")(props.hideSortableGhost)
      mergedProps.updateDynamic("lockToContainerEdges")(props.lockToContainerEdges)
      mergedProps.updateDynamic("onSortEnd")(props.onSortEnd)
      mergedProps.updateDynamic("a")(wrappedProps.asInstanceOf[js.Any])
      component(mergedProps.asInstanceOf[js.Object])
    }
  }
}
