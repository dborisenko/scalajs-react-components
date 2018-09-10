package com.olvind
package sui

import ammonite.ops._

import scala.language.implicitConversions

case class SuiLibrary(base: Path) extends Library {
  /* todo: make requiresjs clever enough to figure this out by itself */
  override val locations =
    Seq(
      base
    )

  override val prefixOpt    = Some("Sui")
  override val name         = "semanticui"
  override val typeMapper   = SuiTypeMapper
  override val memberMapper = SuiTypeMemberMethodMapper
  override val indexNames   = Set("index.js")
  override val packageName  = "com.dbrsn.scalajs.react.semanticui"

  val icon = ComponentDef(CompName("Icon"))

  val components: Seq[ComponentDef] =
    Seq(
      //      ComponentDef(CompName("AutoControlledComponent")),
      //      ComponentDef(CompName("Embed")), //has weird enum for screen res
      //      ComponentDef(CompName("keyboardKey")),
      //      ComponentDef(CompName("leven")),
      //      ComponentDef(CompName("Select")),

      //      ComponentDef(CompName("Accordion")),
      //      ComponentDef(CompName("AccordionContent")),
      //      ComponentDef(CompName("AccordionTitle")),
      //      ComponentDef(CompName("Advertisement")),
      //      ComponentDef(CompName("Breadcrumb")),
      //      ComponentDef(CompName("BreadcrumbDivider")),
      //      ComponentDef(CompName("BreadcrumbSection")),
      ComponentDef(CompName("Button"), domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("ButtonContent")),
      ComponentDef(CompName("ButtonGroup")),
      ComponentDef(CompName("ButtonOr")),
      ComponentDef(CompName("Card")),
      ComponentDef(CompName("CardContent")),
      ComponentDef(CompName("CardDescription")),
      ComponentDef(CompName("CardGroup")),
      ComponentDef(CompName("CardHeader")),
      ComponentDef(CompName("CardMeta")),
      ComponentDef(CompName("Checkbox")),
      ComponentDef(CompName("Comment")),
      ComponentDef(CompName("CommentAction")),
      ComponentDef(CompName("CommentActions")),
      ComponentDef(CompName("CommentAuthor")),
      ComponentDef(CompName("CommentAvatar")),
      ComponentDef(CompName("CommentContent")),
      ComponentDef(CompName("CommentGroup")),
      ComponentDef(CompName("CommentMetadata")),
      ComponentDef(CompName("CommentText")),
      //      ComponentDef(CompName("Confirm")),
      ComponentDef(CompName("Container")),
      //      ComponentDef(CompName("Dimmer")),
      //      ComponentDef(CompName("DimmerDimmable")),
      ComponentDef(CompName("Divider")),
      //      ComponentDef(CompName("Dropdown")),
      //      ComponentDef(CompName("DropdownDivider")),
      //      ComponentDef(CompName("DropdownHeader")),
      //      ComponentDef(CompName("DropdownItem")),
      //      ComponentDef(CompName("DropdownMenu")),
      ComponentDef(CompName("Feed")),
      ComponentDef(CompName("FeedContent")),
      ComponentDef(CompName("FeedDate")),
      ComponentDef(CompName("FeedEvent")),
//      ComponentDef(CompName("FeedExtra")),
      ComponentDef(CompName("FeedLabel")),
      ComponentDef(CompName("FeedLike")),
      ComponentDef(CompName("FeedMeta")),
      ComponentDef(CompName("FeedSummary")),
      ComponentDef(CompName("FeedUser")),
      ComponentDef(CompName("Flag")),
      ComponentDef(CompName("Form")),
      ComponentDef(CompName("FormButton")),
      ComponentDef(CompName("FormCheckbox")),
      ComponentDef(CompName("FormDropdown")),
//      ComponentDef(CompName("FormField")),
      ComponentDef(CompName("FormGroup")),
      ComponentDef(CompName("FormInput")),
      ComponentDef(CompName("FormRadio")),
      ComponentDef(CompName("FormSelect")),
      ComponentDef(CompName("FormTextArea")),
      ComponentDef(CompName("Grid")),
      ComponentDef(CompName("GridColumn")),
      ComponentDef(CompName("GridRow")),
      ComponentDef(CompName("Header")),
      //      ComponentDef(CompName("HeaderContent")),
      //      ComponentDef(CompName("HeaderSubheader")),
      icon,
      ComponentDef(CompName("IconGroup")),
      ComponentDef(CompName("Image")),
      //      ComponentDef(CompName("ImageGroup")),
      ComponentDef(CompName("Input"), domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Item")),
      ComponentDef(CompName("ItemContent")),
      ComponentDef(CompName("ItemDescription")),
      ComponentDef(CompName("ItemExtra")),
      ComponentDef(CompName("ItemGroup")),
      ComponentDef(CompName("ItemHeader")),
      ComponentDef(CompName("ItemImage")),
      ComponentDef(CompName("ItemMeta")),
      ComponentDef(CompName("Label")),
      ComponentDef(CompName("LabelDetail")),
      ComponentDef(CompName("LabelGroup")),
      ComponentDef(CompName("List")),
      ComponentDef(CompName("ListContent")),
      ComponentDef(CompName("ListDescription")),
      ComponentDef(CompName("ListHeader")),
      ComponentDef(CompName("ListIcon"), shared = Some(icon)),
      ComponentDef(CompName("ListItem")),
      ComponentDef(CompName("ListList")),
      ComponentDef(CompName("Loader")),
      ComponentDef(CompName("Menu")),
      ComponentDef(CompName("MenuHeader")),
      ComponentDef(CompName("MenuItem")),
      ComponentDef(CompName("MenuMenu")),
      ComponentDef(CompName("Message")),
      ComponentDef(CompName("MessageContent")),
      ComponentDef(CompName("MessageHeader")),
      ComponentDef(CompName("MessageItem")),
      ComponentDef(CompName("MessageList")),
      //      ComponentDef(CompName("Modal")),
      //      ComponentDef(CompName("ModalActions")),
      //      ComponentDef(CompName("ModalContent")),
      //      ComponentDef(CompName("ModalDescription")),
      //      ComponentDef(CompName("ModalHeader")),
      //      ComponentDef(CompName("Popup")),
      //      ComponentDef(CompName("PopupContent")),
      //      ComponentDef(CompName("PopupHeader")),
      //      ComponentDef(CompName("Portal")),
      //      ComponentDef(CompName("Progress")),
      //      ComponentDef(CompName("Radio")),
      //      ComponentDef(CompName("Rail")),
      //      ComponentDef(CompName("Rating")),
      //      ComponentDef(CompName("RatingIcon")),
      //      ComponentDef(CompName("Reveal")),
      //      ComponentDef(CompName("RevealContent")),
      //      ComponentDef(CompName("Search")),
      //      ComponentDef(CompName("SearchCategory")),
      //      ComponentDef(CompName("SearchResult")),
      //      ComponentDef(CompName("SearchResults")),
      ComponentDef(CompName("Segment")),
      //      ComponentDef(CompName("SegmentGroup")),
      //      ComponentDef(CompName("Sidebar")),
      //      ComponentDef(CompName("SidebarPushable")),
      //      ComponentDef(CompName("SidebarPusher")),
      //      ComponentDef(CompName("Statistic")),
      //      ComponentDef(CompName("StatisticGroup")),
      //      ComponentDef(CompName("StatisticLabel")),
      //      ComponentDef(CompName("StatisticValue")),
      //      ComponentDef(CompName("Step")),
      //      ComponentDef(CompName("StepContent")),
      //      ComponentDef(CompName("StepDescription")),
      //      ComponentDef(CompName("StepGroup")),
      //      ComponentDef(CompName("StepTitle")),
      //      ComponentDef(CompName("Table")),
      //      ComponentDef(CompName("TableBody")),
      //      ComponentDef(CompName("TableCell")),
      //      ComponentDef(CompName("TableFooter")),
      //      ComponentDef(CompName("TableHeader")),
      //      ComponentDef(CompName("TableHeaderCell")),
      //      ComponentDef(CompName("TableRow")),
      ComponentDef(CompName("TextArea")) //      ComponentDef(CompName("Visibility"))
    )
}
