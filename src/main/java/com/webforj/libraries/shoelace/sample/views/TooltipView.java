package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Tooltip;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/tooltip", outlet = MainLayout.class)
@FrameTitle("Tooltip")
public class TooltipView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public TooltipView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Tooltip");
    Paragraph description = new Paragraph(
      "Tooltips display additional information based on a specific action. " +
      "They're useful for providing context or explanatory text for interface elements."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.Tooltip;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "8px 12px")
               .setStyle("border-radius", "4px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "14px");

    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Tooltip.html",
      "https://shoelace.style/components/tooltip"
    );

    header.add(title, description, componentTag, docLinks);

    // Basic tooltip example
    FlexLayout basicExample = createSection(
      "Basic Tooltips",
      "Tooltips appear when hovering over the target element by default."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setSpacing("20px");
    basicDemo.setAlignment(FlexAlignment.CENTER);

    Tooltip topTooltip = new Tooltip("This is a tooltip");
    topTooltip.add(new Button("Hover me"));

    Tooltip contentTooltip = new Tooltip("Tooltip with longer content that explains something in detail");
    contentTooltip.add(new Button("Detailed info"));

    Div basicCode = new Div();
    basicCode.setText(
      "Tooltip tooltip = new Tooltip(\"This is a tooltip\");\n" +
      "Button button = new Button(\"Hover me\");\n" +
      "tooltip.add(button);\n\n" +
      "// Tooltip with longer content\n" +
      "Tooltip detailedTooltip = new Tooltip(\n" +
      "    \"Longer content that explains something in detail\"\n" +
      ");\n" +
      "detailedTooltip.add(new Button(\"Detailed info\"));"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(topTooltip, contentTooltip);
    basicExample.add(basicDemo, basicCode);

    // Placement section
    FlexLayout placementExample = createSection(
      "Placement",
      "Use the placement attribute to control where the tooltip appears relative to its target."
    );

    FlexLayout placementDemo = new FlexLayout();
    placementDemo.setDirection(FlexDirection.COLUMN);
    placementDemo.setSpacing("30px");

    // Top row
    FlexLayout topRow = new FlexLayout();
    topRow.setJustifyContent(FlexJustifyContent.CENTER);
    topRow.setSpacing("10px");

    Tooltip topStart = new Tooltip("Top start").setPlacement("top-start");
    topStart.add(new Button("Top Start"));

    Tooltip top = new Tooltip("Top").setPlacement("top");
    top.add(new Button("Top"));

    Tooltip topEnd = new Tooltip("Top end").setPlacement("top-end");
    topEnd.add(new Button("Top End"));

    topRow.add(topStart, top, topEnd);

    // Middle row with sides
    FlexLayout middleRow = new FlexLayout();
    middleRow.setJustifyContent(FlexJustifyContent.CENTER);
    middleRow.setAlignment(FlexAlignment.CENTER);

    FlexLayout leftColumn = new FlexLayout();
    leftColumn.setDirection(FlexDirection.COLUMN);
    leftColumn.setSpacing("10px");

    Tooltip leftStart = new Tooltip("Left start").setPlacement("left-start");
    leftStart.add(new Button("Left Start"));

    Tooltip left = new Tooltip("Left").setPlacement("left");
    left.add(new Button("Left"));

    Tooltip leftEnd = new Tooltip("Left end").setPlacement("left-end");
    leftEnd.add(new Button("Left End"));

    leftColumn.add(leftStart, left, leftEnd);

    FlexLayout rightColumn = new FlexLayout();
    rightColumn.setDirection(FlexDirection.COLUMN);
    rightColumn.setSpacing("10px");

    Tooltip rightStart = new Tooltip("Right start").setPlacement("right-start");
    rightStart.add(new Button("Right Start"));

    Tooltip right = new Tooltip("Right").setPlacement("right");
    right.add(new Button("Right"));

    Tooltip rightEnd = new Tooltip("Right end").setPlacement("right-end");
    rightEnd.add(new Button("Right End"));

    rightColumn.add(rightStart, right, rightEnd);
    middleRow.add(leftColumn, rightColumn);

    // Bottom row
    FlexLayout bottomRow = new FlexLayout();
    bottomRow.setJustifyContent(FlexJustifyContent.CENTER);
    bottomRow.setSpacing("10px");

    Tooltip bottomStart = new Tooltip("Bottom start").setPlacement("bottom-start");
    bottomStart.add(new Button("Bottom Start"));

    Tooltip bottom = new Tooltip("Bottom").setPlacement("bottom");
    bottom.add(new Button("Bottom"));

    Tooltip bottomEnd = new Tooltip("Bottom end").setPlacement("bottom-end");
    bottomEnd.add(new Button("Bottom End"));

    bottomRow.add(bottomStart, bottom, bottomEnd);

    Div placementCode = new Div();
    placementCode.setText(
      "// Top placements\n" +
      "tooltip.setPlacement(\"top\");\n" +
      "tooltip.setPlacement(\"top-start\");\n" +
      "tooltip.setPlacement(\"top-end\");\n\n" +
      "// Right placements\n" +
      "tooltip.setPlacement(\"right\");\n" +
      "tooltip.setPlacement(\"right-start\");\n" +
      "tooltip.setPlacement(\"right-end\");\n\n" +
      "// Bottom placements\n" +
      "tooltip.setPlacement(\"bottom\");\n" +
      "tooltip.setPlacement(\"bottom-start\");\n" +
      "tooltip.setPlacement(\"bottom-end\");\n\n" +
      "// Left placements\n" +
      "tooltip.setPlacement(\"left\");\n" +
      "tooltip.setPlacement(\"left-start\");\n" +
      "tooltip.setPlacement(\"left-end\");"
    );
    styleCodeBlock(placementCode);

    placementDemo.add(topRow, middleRow, bottomRow);
    placementExample.add(placementDemo, placementCode);

    // Triggers section
    FlexLayout triggersExample = createSection(
      "Triggers",
      "Set the trigger attribute to control when the tooltip appears."
    );

    FlexLayout triggersDemo = new FlexLayout();
    triggersDemo.setSpacing("20px");
    triggersDemo.setAlignment(FlexAlignment.CENTER);

    Tooltip hoverTooltip = new Tooltip("Appears on hover (default)").setTrigger("hover");
    hoverTooltip.add(new Button("Hover"));

    Tooltip clickTooltip = new Tooltip("Click to toggle").setTrigger("click");
    clickTooltip.add(new Button("Click"));

    Tooltip focusTooltip = new Tooltip("Appears on focus").setTrigger("focus");
    focusTooltip.add(new Button("Focus"));

    Tooltip manualTooltip = new Tooltip("Manually controlled").setTrigger("manual").setOpen(true);
    manualTooltip.add(new Button("Always visible"));

    Div triggersCode = new Div();
    triggersCode.setText(
      "// Hover trigger (default)\n" +
      "tooltip.setTrigger(\"hover\");\n\n" +
      "// Click trigger\n" +
      "tooltip.setTrigger(\"click\");\n\n" +
      "// Focus trigger\n" +
      "tooltip.setTrigger(\"focus\");\n\n" +
      "// Manual trigger (controlled programmatically)\n" +
      "tooltip.setTrigger(\"manual\");\n" +
      "tooltip.setOpen(true);  // Show tooltip\n" +
      "tooltip.setOpen(false); // Hide tooltip"
    );
    styleCodeBlock(triggersCode);

    triggersDemo.add(hoverTooltip, clickTooltip, focusTooltip, manualTooltip);
    triggersExample.add(triggersDemo, triggersCode);

    // Distance and skidding section
    FlexLayout distanceExample = createSection(
      "Distance and Skidding",
      "Customize the tooltip's position with distance and skidding options."
    );

    FlexLayout distanceDemo = new FlexLayout();
    distanceDemo.setSpacing("20px");
    distanceDemo.setAlignment(FlexAlignment.CENTER);

    Tooltip farTooltip = new Tooltip("20px away").setDistance(20);
    farTooltip.add(new Button("More distance"));

    Tooltip closeTooltip = new Tooltip("2px away").setDistance(2);
    closeTooltip.add(new Button("Less distance"));

    Tooltip skiddedTooltip = new Tooltip("Skidded 15px").setSkidding(15);
    skiddedTooltip.add(new Button("Skidded"));

    Div distanceCode = new Div();
    distanceCode.setText(
      "// Distance from target\n" +
      "tooltip.setDistance(20); // 20px away\n" +
      "tooltip.setDistance(2);  // 2px away\n\n" +
      "// Skidding (offset along the side)\n" +
      "tooltip.setSkidding(15); // 15px offset"
    );
    styleCodeBlock(distanceCode);

    distanceDemo.add(farTooltip, closeTooltip, skiddedTooltip);
    distanceExample.add(distanceDemo, distanceCode);

    // Disabled state section
    FlexLayout disabledExample = createSection(
      "Disabled State",
      "Tooltips can be disabled to prevent them from appearing."
    );

    FlexLayout disabledDemo = new FlexLayout();
    disabledDemo.setSpacing("20px");
    disabledDemo.setAlignment(FlexAlignment.CENTER);

    Tooltip disabledTooltip = new Tooltip("This tooltip is disabled").setDisabled(true);
    disabledTooltip.add(new Button("Disabled tooltip"));

    Tooltip enabledTooltip = new Tooltip("This tooltip is enabled");
    enabledTooltip.add(new Button("Enabled tooltip"));

    Div disabledCode = new Div();
    disabledCode.setText(
      "// Disable a tooltip\n" +
      "tooltip.setDisabled(true);\n\n" +
      "// Enable a tooltip\n" +
      "tooltip.setDisabled(false);"
    );
    styleCodeBlock(disabledCode);

    disabledDemo.add(disabledTooltip, enabledTooltip);
    disabledExample.add(disabledDemo, disabledCode);

    // Practical examples section
    FlexLayout practicalExample = createSection(
      "Practical Examples",
      "Common use cases for tooltips in real applications."
    );

    FlexLayout practicalDemo = new FlexLayout();
    practicalDemo.setSpacing("20px");
    practicalDemo.setAlignment(FlexAlignment.CENTER);

    // Help button
    Tooltip helpTooltip = new Tooltip("Click for more information about this feature");
    Button helpButton = new Button("?");
    helpButton.setStyle("width", "30px")
              .setStyle("height", "30px")
              .setStyle("border-radius", "50%")
              .setStyle("padding", "0");
    helpTooltip.add(helpButton);

    // Save button with keyboard shortcut
    Tooltip saveTooltip = new Tooltip("Save your work (Ctrl+S)");
    saveTooltip.add(new Button("Save"));

    // Delete button with warning
    Tooltip deleteTooltip = new Tooltip("This action cannot be undone!").setPlacement("top");
    Button deleteButton = new Button("Delete");
    deleteButton.setStyle("background-color", "#dc3545")
                .setStyle("color", "white");
    deleteTooltip.add(deleteButton);

    Div practicalCode = new Div();
    practicalCode.setText(
      "// Help tooltip\n" +
      "Tooltip helpTooltip = new Tooltip(\n" +
      "    \"Click for more information\"\n" +
      ");\n" +
      "Button helpButton = new Button(\"?\");\n" +
      "helpButton.setStyle(\"border-radius\", \"50%\");\n" +
      "helpTooltip.add(helpButton);\n\n" +
      "// Keyboard shortcut tooltip\n" +
      "Tooltip saveTooltip = new Tooltip(\n" +
      "    \"Save your work (Ctrl+S)\"\n" +
      ");\n" +
      "saveTooltip.add(new Button(\"Save\"));\n\n" +
      "// Warning tooltip\n" +
      "Tooltip deleteTooltip = new Tooltip(\n" +
      "    \"This action cannot be undone!\"\n" +
      ").setPlacement(\"top\");\n" +
      "deleteTooltip.add(deleteButton);"
    );
    styleCodeBlock(practicalCode);

    practicalDemo.add(helpTooltip, saveTooltip, deleteTooltip);
    practicalExample.add(practicalDemo, practicalCode);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Tooltip component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, placementExample, triggersExample,
             distanceExample, disabledExample, practicalExample, propertiesSection);
  }

  private FlexLayout createSection(String title, String description) {
    FlexLayout section = new FlexLayout();
    section.setDirection(FlexDirection.COLUMN);
    section.setSpacing("15px");

    H2 sectionTitle = new H2(title);
    Paragraph sectionDesc = new Paragraph(description);

    section.add(sectionTitle, sectionDesc);
    return section;
  }

  private void styleCodeBlock(Div code) {
    code.setStyle("background", "#f8f9fa")
        .setStyle("padding", "16px")
        .setStyle("border-radius", "8px")
        .setStyle("font-size", "14px")
        .setStyle("font-family", "monospace")
        .setStyle("white-space", "pre")
        .setStyle("overflow-x", "auto")
        .setStyle("border", "1px solid #e9ecef");
  }

  private FlexLayout createPropertiesTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden");

    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
      createTableCell("Property", true),
      createTableCell("Description", true),
      createTableCell("Type", true),
      createTableCell("Default", true)
    );

    // Data rows
    FlexLayout contentRow = createTableRow(false);
    contentRow.add(
      createTableCell("content", false),
      createTableCell("The tooltip's content", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout placementRow = createTableRow(false);
    placementRow.add(
      createTableCell("placement", false),
      createTableCell("The preferred placement of the tooltip", false),
      createTableCell("String", false),
      createTableCell("\"top\"", false)
    );

    FlexLayout triggerRow = createTableRow(false);
    triggerRow.add(
      createTableCell("trigger", false),
      createTableCell("Controls when the tooltip appears", false),
      createTableCell("String", false),
      createTableCell("\"hover\"", false)
    );

    FlexLayout distanceRow = createTableRow(false);
    distanceRow.add(
      createTableCell("distance", false),
      createTableCell("Distance in pixels from the target", false),
      createTableCell("int", false),
      createTableCell("8", false)
    );

    FlexLayout skiddingRow = createTableRow(false);
    skiddingRow.add(
      createTableCell("skidding", false),
      createTableCell("Offset along the tooltip's side in pixels", false),
      createTableCell("int", false),
      createTableCell("0", false)
    );

    FlexLayout openRow = createTableRow(false);
    openRow.add(
      createTableCell("open", false),
      createTableCell("Controls whether the tooltip is shown", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout disabledRow = createTableRow(false);
    disabledRow.add(
      createTableCell("disabled", false),
      createTableCell("Disables the tooltip", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout hoistRow = createTableRow(false);
    hoistRow.add(
      createTableCell("hoist", false),
      createTableCell("Hoists tooltip to prevent clipping", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    table.add(headerRow, contentRow, placementRow, triggerRow, distanceRow,
              skiddingRow, openRow, disabledRow, hoistRow);
    return table;
  }

  private FlexLayout createTableRow(boolean isHeader) {
    FlexLayout row = new FlexLayout();
    row.setStyle("border-bottom", "1px solid #dee2e6");
    if (isHeader) {
      row.setStyle("background", "#f8f9fa")
         .setStyle("font-weight", "bold");
    }
    return row;
  }

  private Div createTableCell(String content, boolean isHeader) {
    Div cell = new Div();
    cell.setText(content);
    cell.setStyle("padding", "12px 16px")
        .setStyle("flex", "1");
    if (isHeader) {
      cell.setStyle("font-weight", "600");
    }
    return cell;
  }
}
