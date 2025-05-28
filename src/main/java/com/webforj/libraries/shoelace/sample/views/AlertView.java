package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Alert;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.*;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/alert", outlet = MainLayout.class)
@FrameTitle("Alert")
public class AlertView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public AlertView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = createHeader();

    // Basic Example section
    FlexLayout basicExample = createBasicExample();

    // Variants section
    FlexLayout variantsExample = createVariantsExample();

    // Closable section
    FlexLayout closableExample = createClosableExample();

    // Toast Notification section
    FlexLayout toastExample = createToastExample();

    // Event Handling section
    FlexLayout eventsSection = createEventsSection();

    // Properties section
    FlexLayout propertiesSection = createPropertiesSection();

    // Add all sections to main layout
    self.add(
      header,
      basicExample,
      variantsExample,
      closableExample,
      toastExample,
      eventsSection,
      propertiesSection
    );
  }

  private FlexLayout createHeader() {
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Alert");
    Paragraph description = new Paragraph(
      "Alerts display important messages inline or as toast notifications. They support multiple " +
      "variants to indicate the nature of the message and can include an optional close button."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Alert;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Alert.html",
      "https://shoelace.style/components/alert"
    );

    header.add(title, description, componentImport, docsLinks);
    return header;
  }

  private FlexLayout createBasicExample() {
    FlexLayout section = createSection(
      "Basic Example",
      "Use the Alert component to display important messages. Set the variant property to control the visual style."
    );

    Alert basicAlert = new Alert("This is a basic alert message", Alert.Variant.PRIMARY);
    basicAlert.setOpen(true);

    Div code = new Div();
    code.setText(
      "// Basic alert\n" +
      "Alert alert = new Alert(\"This is a basic alert message\", Alert.Variant.PRIMARY);\n" +
      "alert.setOpen(true);\n\n" +
      "// Or use the show() method\n" +
      "alert.show();"
    );
    styleCodeBlock(code);

    section.add(basicAlert, code);
    return section;
  }

  private FlexLayout createVariantsExample() {
    FlexLayout section = createSection(
      "Alert Variants",
      "Alerts support different semantic variants to convey different types of messages."
    );

    FlexLayout variantsDemo = new FlexLayout();
    variantsDemo.setDirection(FlexDirection.COLUMN);
    variantsDemo.setSpacing("15px");

    // Primary alert
    Alert primaryAlert = new Alert("This is a primary alert", Alert.Variant.PRIMARY);
    primaryAlert.setOpen(true);

    // Success alert
    Alert successAlert = new Alert("Your changes have been saved successfully!", Alert.Variant.SUCCESS);
    successAlert.setOpen(true);
    successAlert.setIcon(TablerIcon.create("circle-check"));

    // Neutral alert
    Alert neutralAlert = new Alert("This is a neutral alert for general information.", Alert.Variant.NEUTRAL);
    neutralAlert.setOpen(true);

    // Warning alert
    Alert warningAlert = new Alert("Your session will expire in 5 minutes.", Alert.Variant.WARNING);
    warningAlert.setOpen(true);
    warningAlert.setIcon(TablerIcon.create("alert-triangle"));

    // Danger alert
    Alert dangerAlert = new Alert("Error: Unable to save changes. Please try again.", Alert.Variant.DANGER);
    dangerAlert.setOpen(true);
    dangerAlert.setIcon(TablerIcon.create("exclamation-circle"));

    Div code = new Div();
    code.setText(
      "// Primary (default)\n" +
      "new Alert(\"Primary alert\", Alert.Variant.PRIMARY);\n\n" +
      "// Success with icon\n" +
      "Alert success = new Alert(\"Success message\", Alert.Variant.SUCCESS);\n" +
      "success.setIcon(TablerIcon.create(\"circle-check\"));\n\n" +
      "// Neutral\n" +
      "new Alert(\"Neutral message\", Alert.Variant.NEUTRAL);\n\n" +
      "// Warning with icon\n" +
      "Alert warning = new Alert(\"Warning message\", Alert.Variant.WARNING);\n" +
      "warning.setIcon(TablerIcon.create(\"alert-triangle\"));\n\n" +
      "// Danger with icon\n" +
      "Alert danger = new Alert(\"Error message\", Alert.Variant.DANGER);\n" +
      "danger.setIcon(TablerIcon.create(\"exclamation-circle\"));"
    );
    styleCodeBlock(code);

    variantsDemo.add(primaryAlert, successAlert, neutralAlert, warningAlert, dangerAlert);
    section.add(variantsDemo, code);
    return section;
  }

  private FlexLayout createClosableExample() {
    FlexLayout section = createSection(
      "Closable Alerts",
      "Add a close button to allow users to dismiss alerts."
    );

    FlexLayout demo = new FlexLayout();
    demo.setDirection(FlexDirection.COLUMN);
    demo.setSpacing("15px");

    Alert closableAlert = new Alert("This alert can be closed by the user.", Alert.Variant.SUCCESS)
      .setClosable(true)
      .setOpen(true);

    Alert autoCloseAlert = new Alert("This alert will close automatically in 5 seconds.", Alert.Variant.WARNING)
      .setClosable(true)
      .setDuration(5000);

    Button showAutoClose = new Button("Show Auto-Close Alert");
    showAutoClose.addClickListener(e -> autoCloseAlert.show());

    Div code = new Div();
    code.setText(
      "// Closable alert\n" +
      "Alert closable = new Alert(\"This can be closed\", Alert.Variant.SUCCESS)\n" +
      "    .setClosable(true)\n" +
      "    .setOpen(true);\n\n" +
      "// Auto-close after 5 seconds\n" +
      "Alert autoClose = new Alert(\"Auto-closing alert\", Alert.Variant.WARNING)\n" +
      "    .setClosable(true)\n" +
      "    .setDuration(5000);\n" +
      "autoClose.show();"
    );
    styleCodeBlock(code);

    demo.add(closableAlert, showAutoClose, autoCloseAlert);
    section.add(demo, code);
    return section;
  }

  private FlexLayout createToastExample() {
    FlexLayout section = createSection(
      "Toast Notifications",
      "Alerts can be positioned as toast notifications. Below is a demo area showing how toasts appear in the top-right corner."
    );

    FlexLayout controls = new FlexLayout();
    controls.setSpacing("10px");

    Button showSuccess = new Button("Show Success Toast");
    Button showError = new Button("Show Error Toast");
    Button showInfo = new Button("Show Info Toast");

    // Create a container within the section for demonstration
    FlexLayout toastDemo = new FlexLayout();
    toastDemo.setDirection(FlexDirection.COLUMN);
    toastDemo.setSpacing("15px");
    toastDemo.setStyle("position", "relative")
             .setStyle("min-height", "200px")
             .setStyle("border", "1px dashed #dee2e6")
             .setStyle("border-radius", "8px")
             .setStyle("padding", "20px");

    // Toast container that will be positioned within the demo area
    Div toastContainer = new Div();
    toastContainer.setStyle("position", "absolute")
                  .setStyle("top", "20px")
                  .setStyle("right", "20px")
                  .setStyle("z-index", "10")
                  .setStyle("display", "flex")
                  .setStyle("flex-direction", "column")
                  .setStyle("gap", "10px")
                  .setStyle("max-width", "350px");

    Paragraph demoNote = new Paragraph("Toast notifications will appear in the top-right corner of this demo area:");
    demoNote.setStyle("margin", "0 0 10px 0")
            .setStyle("color", "#6c757d")
            .setStyle("font-size", "14px");

    showSuccess.addClickListener(e -> {
      Alert toast = new Alert("Operation completed successfully!", Alert.Variant.SUCCESS)
        .setClosable(true)
        .setDuration(3000);
      toast.setIcon(TablerIcon.create("check"));
      toast.setStyle("box-shadow", "0 4px 12px rgba(0,0,0,0.15)");
      toastContainer.add(toast);
      toast.show();
      
      toast.onAfterHide(event -> toastContainer.remove(toast));
    });

    showError.addClickListener(e -> {
      Alert toast = new Alert("An error occurred. Please try again.", Alert.Variant.DANGER)
        .setClosable(true)
        .setDuration(4000);
      toast.setIcon(TablerIcon.create("x"));
      toast.setStyle("box-shadow", "0 4px 12px rgba(0,0,0,0.15)");
      toastContainer.add(toast);
      toast.show();
      
      toast.onAfterHide(event -> toastContainer.remove(toast));
    });

    showInfo.addClickListener(e -> {
      Alert toast = new Alert("New update available!", Alert.Variant.PRIMARY)
        .setClosable(true)
        .setDuration(3000);
      toast.setIcon(TablerIcon.create("info-circle"));
      toast.setStyle("box-shadow", "0 4px 12px rgba(0,0,0,0.15)");
      toastContainer.add(toast);
      toast.show();
      
      toast.onAfterHide(event -> toastContainer.remove(toast));
    });

    toastDemo.add(demoNote, toastContainer);

    Div code = new Div();
    code.setText(
      "// Create toast container\n" +
      "Div toastContainer = new Div();\n" +
      "toastContainer.setStyle(\"position\", \"absolute\")\n" +
      "              .setStyle(\"top\", \"20px\")\n" +
      "              .setStyle(\"right\", \"20px\")\n" +
      "              .setStyle(\"z-index\", \"10\");\n\n" +
      "// Show toast notification\n" +
      "Alert toast = new Alert(\"Success!\", Alert.Variant.SUCCESS)\n" +
      "    .setClosable(true)\n" +
      "    .setDuration(3000);\n" +
      "toast.setIcon(TablerIcon.create(\"check\"));\n" +
      "toast.setStyle(\"box-shadow\", \"0 4px 12px rgba(0,0,0,0.15)\");\n" +
      "toastContainer.add(toast);\n" +
      "toast.show();\n\n" +
      "// Auto-remove after hide animation\n" +
      "toast.onAfterHide(event -> toastContainer.remove(toast));"
    );
    styleCodeBlock(code);

    controls.add(showSuccess, showError, showInfo);
    section.add(controls, toastDemo, code);
    return section;
  }

  private FlexLayout createEventsSection() {
    FlexLayout section = createSection(
      "Event Handling",
      "Alerts emit events during their show/hide lifecycle, allowing you to hook into animations and state changes."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Event demo alert
    Alert eventAlert = new Alert("I'm an interactive alert! Watch the event log below.", Alert.Variant.NEUTRAL)
      .setClosable(true)
      .setDuration(10000);

    // Event status display
    Div eventStatus = new Div();
    eventStatus.setText("Event log will appear here...");
    eventStatus.setStyle("padding", "16px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border-radius", "8px")
               .setStyle("font-size", "14px")
               .setStyle("min-height", "100px")
               .setStyle("white-space", "pre-wrap")
               .setStyle("border", "1px solid #e9ecef");

    // Register event handlers
    eventAlert.onShow(event -> {
      eventStatus.setText("Event: sl-show\nAlert is starting to show...");
    });

    eventAlert.onAfterShow(event -> {
      String current = eventStatus.getText();
      eventStatus.setText(current + "\n\nEvent: sl-after-show\nAlert is fully visible!");
    });

    eventAlert.onHide(event -> {
      String current = eventStatus.getText();
      eventStatus.setText(current + "\n\nEvent: sl-hide\nAlert is starting to hide...");
    });

    eventAlert.onAfterHide(event -> {
      String current = eventStatus.getText();
      eventStatus.setText(current + "\n\nEvent: sl-after-hide\nAlert is completely hidden!");
    });

    // Control buttons
    FlexLayout eventControls = new FlexLayout();
    eventControls.setSpacing("10px");

    Button showEventAlert = new Button("Show Alert");
    showEventAlert.addClickListener(e -> eventAlert.show());

    Button hideEventAlert = new Button("Hide Alert");
    hideEventAlert.addClickListener(e -> eventAlert.hide());

    eventControls.add(showEventAlert, hideEventAlert);

    // Event code example
    Div eventCode = new Div();
    eventCode.setText(
      "// Show event - fired when alert starts to show\n" +
      "alert.onShow(event -> {\n" +
      "    System.out.println(\"Alert is showing...\");\n" +
      "});\n\n" +
      "// After show event - fired when show animation completes\n" +
      "alert.onAfterShow(event -> {\n" +
      "    System.out.println(\"Alert is fully visible\");\n" +
      "});\n\n" +
      "// Hide event - fired when alert starts to hide\n" +
      "alert.onHide(event -> {\n" +
      "    System.out.println(\"Alert is hiding...\");\n" +
      "});\n\n" +
      "// After hide event - fired when hide animation completes\n" +
      "alert.onAfterHide(event -> {\n" +
      "    System.out.println(\"Alert is completely hidden\");\n" +
      "    // Good place to remove the alert from DOM if needed\n" +
      "});"
    );
    styleCodeBlock(eventCode);

    eventsDemo.add(eventAlert, eventControls, eventStatus, eventCode);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsDemo.add(eventsTable);

    section.add(eventsDemo);
    return section;
  }

  private FlexLayout createPropertiesSection() {
    FlexLayout section = createSection(
      "Properties",
      "The Alert component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    section.add(propertiesTable);
    return section;
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

  private FlexLayout createEventsTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden");

    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
      createTableCell("Event", true),
      createTableCell("Description", true),
      createTableCell("When Fired", true)
    );
    table.add(headerRow);

    // Data rows
    String[][] events = {
      {"sl-show", "onShow", "When the alert starts to show"},
      {"sl-after-show", "onAfterShow", "After the show animation completes"},
      {"sl-hide", "onHide", "When the alert starts to hide"},
      {"sl-after-hide", "onAfterHide", "After the hide animation completes"}
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
    table.add(headerRow);

    // Data rows
    String[][] properties = {
      {"open", "Shows or hides the alert", "boolean", "false"},
      {"closable", "Shows a close button", "boolean", "false"},
      {"variant", "Alert variant style", "String", "\"primary\""},
      {"duration", "Auto-close duration in ms", "Integer", "null"}
    };

    for (String[] property : properties) {
      FlexLayout row = createTableRow(false);
      row.add(
        createTableCell(property[0], false),
        createTableCell(property[1], false),
        createTableCell(property[2], false),
        createTableCell(property[3], false)
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
}