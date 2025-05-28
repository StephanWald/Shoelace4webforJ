package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Details;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/details", outlet = MainLayout.class)
@FrameTitle("Details")
public class DetailsView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public DetailsView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Details");
    Paragraph description = new Paragraph(
      "Details show a summary and expand to reveal additional content. " +
      "They're useful for toggling information that doesn't always need to be visible."
    );

    // Component import
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Details;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Details.html",
      "https://shoelace.style/components/details"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic example section
    FlexLayout basicExample = createSection(
      "Basic Details",
      "Click the summary to toggle the details content."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    Details basicDetails = new Details("Click to show/hide content");
    Paragraph detailsContent = new Paragraph(
      "This is the hidden content that appears when you expand the details component. " +
      "You can put any content here including text, images, forms, or other components."
    );
    basicDetails.add(detailsContent);

    Div basicCode = new Div();
    basicCode.setText(
      "// Create a basic details component\n" +
      "Details details = new Details(\"Click to expand\");\n" +
      "details.add(new Paragraph(\"Hidden content\"));\n\n" +
      "// Check if open\n" +
      "boolean isOpen = details.isOpen();\n\n" +
      "// Set open state\n" +
      "details.setOpen(true);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicDetails, basicCode);
    basicExample.add(basicDemo);

    // Disabled state section
    FlexLayout disabledExample = createSection(
      "Disabled State",
      "Details can be disabled to prevent toggling."
    );

    FlexLayout disabledDemo = new FlexLayout();
    disabledDemo.setDirection(FlexDirection.COLUMN);
    disabledDemo.setSpacing("20px");

    Details disabledDetails = new Details("This is disabled and cannot be toggled");
    disabledDetails.setDisabled(true);
    disabledDetails.add(new Paragraph("You won't be able to see this content."));

    Details openDisabled = new Details("Disabled but open", true);
    openDisabled.setDisabled(true);
    openDisabled.add(new Paragraph("This content is visible but the details cannot be collapsed."));

    Div disabledCode = new Div();
    disabledCode.setText(
      "// Disable a details component\n" +
      "details.setDisabled(true);\n\n" +
      "// Create disabled and open\n" +
      "Details details = new Details(\"Summary\", true);\n" +
      "details.setDisabled(true);"
    );
    styleCodeBlock(disabledCode);

    disabledDemo.add(disabledDetails, openDisabled, disabledCode);
    disabledExample.add(disabledDemo);

    // Custom icons section
    FlexLayout iconsExample = createSection(
      "Custom Icons",
      "Add custom expand and collapse icons using slots."
    );

    FlexLayout iconsDemo = new FlexLayout();
    iconsDemo.setDirection(FlexDirection.COLUMN);
    iconsDemo.setSpacing("20px");

    Details customIconDetails = new Details("Custom icon details");

    // Add expand icon to slot
    Div expandIcon = new Div();
    expandIcon.setAttribute("slot", "expand-icon");
    expandIcon.add(TablerIcon.create("plus"));

    // Add collapse icon to slot
    Div collapseIcon = new Div();
    collapseIcon.setAttribute("slot", "collapse-icon");
    collapseIcon.add(TablerIcon.create("minus"));

    customIconDetails.add(expandIcon, collapseIcon);
    customIconDetails.add(new Paragraph("Content with custom expand/collapse icons."));

    Div iconsCode = new Div();
    iconsCode.setText(
      "// Add custom icons\n" +
      "Details details = new Details(\"Summary\");\n\n" +
      "// Expand icon\n" +
      "Div expandIcon = new Div();\n" +
      "expandIcon.setAttribute(\"slot\", \"expand-icon\");\n" +
      "expandIcon.add(TablerIcon.create(\"plus\"));\n\n" +
      "// Collapse icon\n" +
      "Div collapseIcon = new Div();\n" +
      "collapseIcon.setAttribute(\"slot\", \"collapse-icon\");\n" +
      "collapseIcon.add(TablerIcon.create(\"minus\"));\n\n" +
      "details.add(expandIcon, collapseIcon);"
    );
    styleCodeBlock(iconsCode);

    iconsDemo.add(customIconDetails, iconsCode);
    iconsExample.add(iconsDemo);

    // Grouping example section
    FlexLayout groupingExample = createSection(
      "Grouping Details",
      "Multiple details can be grouped together for better organization."
    );

    FlexLayout groupingDemo = new FlexLayout();
    groupingDemo.setDirection(FlexDirection.COLUMN);
    groupingDemo.setSpacing("20px");

    FlexLayout detailsGroup = new FlexLayout();
    detailsGroup.setDirection(FlexDirection.COLUMN);
    detailsGroup.setSpacing("10px");

    // Create grouped details
    Details firstDetails = new Details("First Section");
    firstDetails.add(new Paragraph("Content for the first section. This could include any type of content or components."));

    Details secondDetails = new Details("Second Section");
    FlexLayout secondContent = new FlexLayout();
    secondContent.setDirection(FlexDirection.COLUMN);
    secondContent.setSpacing("10px");
    secondContent.add(
      new H4("Section Content"),
      new Paragraph("You can include multiple elements in a details section."),
      new ShoelaceButton("Action Button", ShoelaceButton.Variant.PRIMARY)
    );
    secondDetails.add(secondContent);

    Details thirdDetails = new Details("Third Section");
    thirdDetails.add(new Paragraph("Content for the third section. Each section can be toggled independently."));

    detailsGroup.add(firstDetails, secondDetails, thirdDetails);

    Div groupingCode = new Div();
    groupingCode.setText(
      "// Group multiple details\n" +
      "FlexLayout group = new FlexLayout();\n" +
      "group.setDirection(FlexDirection.COLUMN);\n" +
      "group.setSpacing(\"10px\");\n\n" +
      "Details details1 = new Details(\"Section 1\");\n" +
      "Details details2 = new Details(\"Section 2\");\n" +
      "Details details3 = new Details(\"Section 3\");\n\n" +
      "group.add(details1, details2, details3);"
    );
    styleCodeBlock(groupingCode);

    groupingDemo.add(detailsGroup, groupingCode);
    groupingExample.add(groupingDemo);

    // Programmatic control section
    FlexLayout controlExample = createSection(
      "Programmatic Control",
      "Control details components using methods."
    );

    FlexLayout controlDemo = new FlexLayout();
    controlDemo.setDirection(FlexDirection.COLUMN);
    controlDemo.setSpacing("20px");

    Details controlledDetails = new Details("Controlled Details");
    controlledDetails.add(
      new Paragraph("This details component can be controlled with the buttons below.")
    );

    FlexLayout controlButtons = new FlexLayout();
    controlButtons.setSpacing("10px");
    controlButtons.setAlignment(FlexAlignment.CENTER);

    ShoelaceButton showBtn = new ShoelaceButton("Show");
    showBtn.setVariant(ShoelaceButton.Variant.SUCCESS);
    // Note: onClick not available on ShoelaceButton - would need JavaScript interop

    ShoelaceButton hideBtn = new ShoelaceButton("Hide");
    hideBtn.setVariant(ShoelaceButton.Variant.DANGER);
    // Note: onClick not available on ShoelaceButton - would need JavaScript interop

    ShoelaceButton toggleBtn = new ShoelaceButton("Toggle");
    toggleBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    // Note: onClick not available on ShoelaceButton - would need JavaScript interop

    controlButtons.add(showBtn, hideBtn, toggleBtn);

    Div controlCode = new Div();
    controlCode.setText(
      "// Control details programmatically\n" +
      "Details details = new Details(\"Summary\");\n\n" +
      "// Show details\n" +
      "details.show();\n\n" +
      "// Hide details\n" +
      "details.hide();\n\n" +
      "// Toggle state\n" +
      "details.toggle();"
    );
    styleCodeBlock(controlCode);

    controlDemo.add(controlledDetails, controlButtons, controlCode);
    controlExample.add(controlDemo);

    // Events section
    FlexLayout eventsSection = createSection(
      "Event Handling",
      "The Details component emits events when it opens and closes."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Event demo
    Details eventDetails = new Details("Event Demo Details");
    eventDetails.add(new Paragraph("Open and close this details panel to see events fire."));

    // Event status display
    FlexLayout eventStatus = new FlexLayout();
    eventStatus.setDirection(FlexDirection.COLUMN)
               .setSpacing("5px")
               .setPadding("15px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border", "1px solid #dee2e6")
               .setStyle("border-radius", "8px")
               .setStyle("min-height", "100px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "13px");

    Label statusLabel = new Label("Waiting for events...");
    statusLabel.setStyle("color", "#6c757d");
    eventStatus.add(statusLabel);

    // Add event handlers
    eventDetails.onShow(event -> {
      Label showLabel = new Label("[" + getTimestamp() + "] sl-show: Details is opening");
      showLabel.setStyle("color", "#10b981");
      eventStatus.add(showLabel);
      if (eventStatus.getComponentCount() > 5) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
    });

    eventDetails.onAfterShow(event -> {
      Label afterShowLabel = new Label("[" + getTimestamp() + "] sl-after-show: Details opened");
      afterShowLabel.setStyle("color", "#0969da");
      eventStatus.add(afterShowLabel);
      if (eventStatus.getComponentCount() > 5) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
    });

    eventDetails.onHide(event -> {
      Label hideLabel = new Label("[" + getTimestamp() + "] sl-hide: Details is closing");
      hideLabel.setStyle("color", "#dc2626");
      eventStatus.add(hideLabel);
      if (eventStatus.getComponentCount() > 5) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
    });

    eventDetails.onAfterHide(event -> {
      Label afterHideLabel = new Label("[" + getTimestamp() + "] sl-after-hide: Details closed");
      afterHideLabel.setStyle("color", "#6c757d");
      eventStatus.add(afterHideLabel);
      if (eventStatus.getComponentCount() > 5) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
    });

    Div eventCode = new Div();
    eventCode.setText(
      "// Details event handlers\n" +
      "details.onShow(event -> {\n" +
      "    System.out.println(\"Details is opening\");\n" +
      "});\n\n" +
      "details.onAfterShow(event -> {\n" +
      "    System.out.println(\"Details opened and animations complete\");\n" +
      "});\n\n" +
      "details.onHide(event -> {\n" +
      "    System.out.println(\"Details is closing\");\n" +
      "});\n\n" +
      "details.onAfterHide(event -> {\n" +
      "    System.out.println(\"Details closed and animations complete\");\n" +
      "});"
    );
    styleCodeBlock(eventCode);

    eventsDemo.add(eventDetails, eventStatus, eventCode);
    eventsSection.add(eventsDemo);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsSection.add(eventsTable);

    // Properties section
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Details component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, disabledExample, iconsExample,
             groupingExample, controlExample, eventsSection, propertiesSection);
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
      createTableCell("Property/Method", true),
      createTableCell("Description", true),
      createTableCell("Type", true),
      createTableCell("Default", true)
    );
    table.add(headerRow);

    // Properties
    String[][] items = {
      {"open", "Controls visibility of content", "boolean", "false"},
      {"summary", "Summary text", "String", "\"\""},
      {"disabled", "Prevents toggling", "boolean", "false"},
      {"show()", "Opens the details", "method", "-"},
      {"hide()", "Closes the details", "method", "-"},
      {"toggle()", "Toggles open/closed state", "method", "-"}
    };

    for (String[] item : items) {
      FlexLayout row = createTableRow(false);
      row.add(
        createTableCell(item[0], false),
        createTableCell(item[1], false),
        createTableCell(item[2], false),
        createTableCell(item[3], false)
      );
      table.add(row);
    }

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

  private String getTimestamp() {
    return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
  }

  private FlexLayout createEventsTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden")
         .setStyle("margin-top", "20px");

    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
      createTableCell("Event", true),
      createTableCell("Description", true),
      createTableCell("Event Data", true)
    );
    table.add(headerRow);

    // Event rows
    String[][] events = {
      {"sl-show", "Emitted when the details begins to show", "None"},
      {"sl-after-show", "Emitted after the details opens and animations complete", "None"},
      {"sl-hide", "Emitted when the details begins to hide", "None"},
      {"sl-after-hide", "Emitted after the details closes and animations complete", "None"}
    };

    for (String[] event : events) {
      FlexLayout row = createTableRow(false);
      row.add(
        createTableCell(event[0], false),
        createTableCell(event[1], false),
        createTableCell(event[2], false)
      );
      table.add(row);
    }

    return table;
  }
}
