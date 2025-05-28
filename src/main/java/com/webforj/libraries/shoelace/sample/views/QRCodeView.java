package com.webforj.libraries.shoelace.sample.views;

import com.webforj.component.toast.Toast;
import com.webforj.libraries.shoelace.components.QRCode;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.field.NumberField;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.slider.Slider;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;


@Route(value = "/qr-code", outlet = MainLayout.class)
@FrameTitle("QR Code")
public class QRCodeView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public QRCodeView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("QR Code");
    Paragraph description = new Paragraph(
      "Generates QR codes using the Shoelace web component. This component is useful for " +
      "encoding and displaying information that can be easily scanned by smartphones."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.QRCode;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "4px 8px")
               .setStyle("border-radius", "4px")
               .setStyle("font-size", "14px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/QRCode.html",
      "https://shoelace.style/components/qr-code"
    );

    header.add(title, description, componentTag, docsLinks);

    // Interactive Demo Section
    FlexLayout interactiveDemo = createSection(
      "Interactive Demo",
      "Try out all the QR code options in this interactive demo:"
    );

    FlexLayout demoContainer = new FlexLayout();
    demoContainer.setDirection(FlexDirection.ROW);
    demoContainer.setSpacing("40px");
    demoContainer.setAlignment(FlexAlignment.START);
    demoContainer.setStyle("flex-wrap", "wrap");

    // Controls panel
    FlexLayout controls = new FlexLayout();
    controls.setDirection(FlexDirection.COLUMN);
    controls.setSpacing("20px");
    controls.setStyle("flex", "1");
    controls.setStyle("min-width", "300px");

    // Value input
    TextField valueInput = new TextField();
    valueInput.setLabel("Value");
    valueInput.setValue("https://shoelace.style/components/qr-code");
    valueInput.setPlaceholder("Enter text to encode");

    // Label input
    TextField labelInput = new TextField();
    labelInput.setLabel("Label (Accessibility)");
    labelInput.setValue("QR code for Shoelace website");
    labelInput.setPlaceholder("Screen reader label");

    // Size input
    NumberField sizeInput = new NumberField();
    sizeInput.setLabel("Size");
    sizeInput.setValue(200.0);
    sizeInput.setMin(64.0);
    sizeInput.setMax(500.0);
    sizeInput.setStep(8.0);

    // Fill color
    TextField fillColor = new TextField();
    fillColor.setLabel("Fill Color");
    fillColor.setValue("#000000");
    fillColor.setPlaceholder("CSS color value");

    // Background color
    TextField backgroundColor = new TextField();
    backgroundColor.setLabel("Background Color");
    backgroundColor.setValue("#ffffff");
    backgroundColor.setPlaceholder("CSS color value");

    // Radius slider
    Label radiusLabel = new Label("Module Radius: 0");
    Slider radiusSlider = new Slider();
    radiusSlider.setMin(0);
    radiusSlider.setMax(50);
    radiusSlider.setValue(0);
    radiusSlider.setTicksVisible(true);
    radiusSlider.setMajorTickSpacing(50);
    radiusSlider.setMinorTickSpacing(10);
    radiusSlider.setLabelsVisible(true);
    radiusSlider.setSnapToTicks(true);
    radiusSlider.setWidth("100%");

    // Error correction
    ChoiceBox errorCorrectionChoice = new ChoiceBox();
    errorCorrectionChoice.setLabel("Error Correction");
    errorCorrectionChoice.add("Low (L)", "L");
    errorCorrectionChoice.add("Medium (M)", "M");
    errorCorrectionChoice.add("Quartile (Q)", "Q");
    errorCorrectionChoice.add("High (H)", "H");

    controls.add(
      valueInput,
      labelInput,
      sizeInput,
      fillColor,
      backgroundColor,
      radiusLabel,
      radiusSlider,
      errorCorrectionChoice
    );

    // Preview panel
    FlexLayout preview = new FlexLayout();
    preview.setDirection(FlexDirection.COLUMN);
    preview.setSpacing("20px");
    preview.setAlignment(FlexAlignment.CENTER);
    preview.setJustifyContent(FlexJustifyContent.CENTER);
    preview.setStyle("flex", "1");
    preview.setStyle("min-width", "300px");
    preview.setStyle("background", "#f8f9fa");
    preview.setStyle("border-radius", "8px");
    preview.setStyle("padding", "40px");

    QRCode demoQR = new QRCode("https://shoelace.style/components/qr-code", 200);
    demoQR.setLabel("QR code for Shoelace website");

    // Update handlers
    valueInput.onModify(e -> demoQR.setValue(valueInput.getValue()));
    labelInput.onModify(e -> demoQR.setLabel(labelInput.getValue()));
    sizeInput.onModify(e -> demoQR.setSize(sizeInput.getValue().intValue()));
    fillColor.onModify(e -> demoQR.setFill(fillColor.getValue()));
    backgroundColor.onModify(e -> demoQR.setBackground(backgroundColor.getValue()));
    radiusSlider.addValueChangeListener(e -> {
      double radius = e.getValue() / 100.0;
      radiusLabel.setText("Module Radius: " + String.format("%.2f", radius));
      demoQR.setRadius(radius);
    });
    errorCorrectionChoice.addValueChangeListener(e -> {
      if (errorCorrectionChoice.getSelectedItem() != null) {
        String selected = (String) errorCorrectionChoice.getSelectedItem().getKey();
        demoQR.setErrorCorrection(selected);
      }
    });

    preview.add(demoQR);

    // Code preview
    Div codePreview = new Div();
    updateCodePreview(codePreview, valueInput, labelInput, sizeInput, fillColor, backgroundColor, radiusSlider, errorCorrectionChoice);
    styleCodeBlock(codePreview);

    // Add update handlers to refresh code preview
    valueInput.onModify(e -> updateCodePreview(codePreview, valueInput, labelInput, sizeInput, fillColor, backgroundColor, radiusSlider, errorCorrectionChoice));
    labelInput.onModify(e -> updateCodePreview(codePreview, valueInput, labelInput, sizeInput, fillColor, backgroundColor, radiusSlider, errorCorrectionChoice));
    sizeInput.onModify(e -> updateCodePreview(codePreview, valueInput, labelInput, sizeInput, fillColor, backgroundColor, radiusSlider, errorCorrectionChoice));
    fillColor.onModify(e -> updateCodePreview(codePreview, valueInput, labelInput, sizeInput, fillColor, backgroundColor, radiusSlider, errorCorrectionChoice));
    backgroundColor.onModify(e -> updateCodePreview(codePreview, valueInput, labelInput, sizeInput, fillColor, backgroundColor, radiusSlider, errorCorrectionChoice));
    radiusSlider.addValueChangeListener(e -> updateCodePreview(codePreview, valueInput, labelInput, sizeInput, fillColor, backgroundColor, radiusSlider, errorCorrectionChoice));
    errorCorrectionChoice.addValueChangeListener(e -> updateCodePreview(codePreview, valueInput, labelInput, sizeInput, fillColor, backgroundColor, radiusSlider, errorCorrectionChoice));

    demoContainer.add(controls, preview);
    interactiveDemo.add(demoContainer, codePreview);

    // Basic Example section
    FlexLayout basicExample = createSection(
      "Basic Example",
      "Use the QRCode component to generate a basic QR code. Set the value property to encode any string data."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setSpacing("20px");
    basicDemo.setAlignment(FlexAlignment.CENTER);

    QRCode basicQR = new QRCode("https://webforj.com");

    Div basicCode = new Div();
    basicCode.setText(
      "// Simple QR code\n" +
      "QRCode qrCode = new QRCode(\"https://webforj.com\");\n\n" +
      "// Or with size\n" +
      "QRCode qrCode = new QRCode(\"https://webforj.com\", 256);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicQR);
    basicExample.add(basicDemo, basicCode);

    // Event Handling Section
    FlexLayout eventsSection = createSection(
      "Event Handling",
      "QRCode components support various mouse events that allow you to create interactive experiences. " +
      "This powerful feature bridges JavaScript events with Java's type-safe event handling system."
    );

    // Interactive events demo
    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("30px");

    // Event demo QR code
    FlexLayout eventQRContainer = new FlexLayout();
    eventQRContainer.setDirection(FlexDirection.COLUMN);
    eventQRContainer.setAlignment(FlexAlignment.CENTER);
    eventQRContainer.setSpacing("20px");

    QRCode eventQR = new QRCode("https://github.com/webforj", 250);
    eventQR.setLabel("Interactive QR Code - Try hovering, clicking, or right-clicking!");
    eventQR.setFill("#3B82F6");
    eventQR.setBackground("#EFF6FF");
    eventQR.setRadius(0.1);

    // Event status display
    Div eventStatus = new Div();
    eventStatus.setText("Interact with the QR code above to see events in action!");
    eventStatus.setStyle("padding", "16px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border-radius", "8px")
               .setStyle("text-align", "center")
               .setStyle("font-size", "14px")
               .setStyle("min-height", "50px")
               .setStyle("display", "flex")
               .setStyle("align-items", "center")
               .setStyle("justify-content", "center");

    // Register all event handlers
    eventQR.onClick(event -> {
      String message = String.format("Clicked at coordinates: (%d, %d)", 
        event.getClientX(), event.getClientY());
      eventStatus.setText(message);
      Toast.show("QR Code clicked!");
    });

    eventQR.onDoubleClick(event -> {
      eventStatus.setText("Double-clicked! This could trigger a special action.");
      Toast.show("Double-click detected!");
    });

    eventQR.onMouseEnter(event -> {
      eventStatus.setText("Mouse entered - QR code is ready for interaction!");
      // Add visual feedback by modifying the event status
      eventStatus.setStyle("background", "#e3f2fd");
    });

    eventQR.onMouseLeave(event -> {
      eventStatus.setText("Mouse left - Come back to interact more!");
      // Reset visual feedback
      eventStatus.setStyle("background", "#f8f9fa");
    });

    eventQR.onContextMenu(event -> {
      eventStatus.setText(String.format("Right-clicked at: (%d, %d) - Custom context menu could appear here!", 
        event.getClientX(), event.getClientY()));
      Toast.show("Context menu event captured!");
    });

    eventQRContainer.add(eventQR, eventStatus);

    // Event handling code examples
    Div eventCode = new Div();
    eventCode.setText(
      "// Click event with coordinates\n" +
      "qrCode.onClick(event -> {\n" +
      "    System.out.println(\"Clicked at: \" + event.getClientX() + \", \" + event.getClientY());\n" +
      "    Toast.show(\"QR Code clicked!\");\n" +
      "});\n\n" +
      "// Double-click event\n" +
      "qrCode.onDoubleClick(event -> {\n" +
      "    // Handle double-click action\n" +
      "    navigateToURL(qrCode.getValue());\n" +
      "});\n\n" +
      "// Mouse hover effects\n" +
      "qrCode.onMouseEnter(event -> {\n" +
      "    qrCode.setStyle(\"transform\", \"scale(1.05)\");\n" +
      "});\n\n" +
      "qrCode.onMouseLeave(event -> {\n" +
      "    qrCode.setStyle(\"transform\", \"scale(1)\");\n" +
      "});\n\n" +
      "// Context menu (right-click)\n" +
      "ListenerRegistration<QRCode.ContextMenuEvent> reg = qrCode.onContextMenu(event -> {\n" +
      "    showCustomMenu(event.getClientX(), event.getClientY());\n" +
      "});\n\n" +
      "// Remove listener when needed\n" +
      "reg.remove();"
    );
    styleCodeBlock(eventCode);

    // Event architecture explanation
    FlexLayout eventArchitecture = new FlexLayout();
    eventArchitecture.setDirection(FlexDirection.COLUMN);
    eventArchitecture.setSpacing("15px");
    eventArchitecture.setStyle("margin-top", "20px");

    H2 architectureTitle = new H2("Event Architecture");
    Paragraph architectureDesc = new Paragraph(
      "The QRCode component uses webforJ's event bridging system to connect JavaScript events " +
      "with Java event handlers. This is achieved through:"
    );

    Div architectureDetails = new Div();
    architectureDetails.setHtml(
      "<ul style='margin: 0; padding-left: 20px; line-height: 1.8;'>" +
      "<li><strong>@EventName</strong> - Maps Java event classes to JavaScript event names</li>" +
      "<li><strong>@EventOptions</strong> - Specifies which event data to capture (e.g., mouse coordinates)</li>" +
      "<li><strong>Type-safe event classes</strong> - Each event type has its own Java class with getters for event data</li>" +
      "<li><strong>ListenerRegistration</strong> - Allows proper cleanup by removing event listeners when no longer needed</li>" +
      "</ul>"
    );

    eventArchitecture.add(architectureTitle, architectureDesc, architectureDetails);

    eventsDemo.add(eventQRContainer, eventCode, eventArchitecture);
    eventsSection.add(eventsDemo);

    // Colors section
    FlexLayout colorsExample = createSection(
      "Colors",
      "Customize the fill and background colors of the QR code."
    );

    FlexLayout colorsDemo = new FlexLayout();
    colorsDemo.setSpacing("20px");
    colorsDemo.setAlignment(FlexAlignment.CENTER);

    QRCode blueQR = new QRCode("Blue QR Code", 150)
      .setFill("#3B82F6")
      .setBackground("#EFF6FF");

    QRCode greenQR = new QRCode("Green QR Code", 150)
      .setFill("#10B981")
      .setBackground("#F0FDF4");

    QRCode gradientQR = new QRCode("Custom Colors", 150)
      .setFill("#8B5CF6")
      .setBackground("#FDE68A");

    Div colorCode = new Div();
    colorCode.setText(
      "// Blue theme\n" +
      "QRCode blueQR = new QRCode(\"Blue QR Code\")\n" +
      "    .setFill(\"#3B82F6\")\n" +
      "    .setBackground(\"#EFF6FF\");\n\n" +
      "// Using Color objects\n" +
      "QRCode greenQR = new QRCode(\"Green QR Code\")\n" +
      "    .setFill(new Color(16, 185, 129))\n" +
      "    .setBackground(new Color(240, 253, 244));\n\n" +
      "// Transparent background\n" +
      "QRCode transparentQR = new QRCode(\"Transparent\")\n" +
      "    .setBackground(\"transparent\");"
    );
    styleCodeBlock(colorCode);

    colorsDemo.add(blueQR, greenQR, gradientQR);
    colorsExample.add(colorsDemo, colorCode);

    // Radius section
    FlexLayout radiusExample = createSection(
      "Module Radius",
      "Round the corners of each module in the QR code for a softer appearance."
    );

    FlexLayout radiusDemo = new FlexLayout();
    radiusDemo.setSpacing("20px");
    radiusDemo.setAlignment(FlexAlignment.CENTER);

    QRCode sharpQR = new QRCode("Sharp Corners", 150)
      .setRadius(0);

    QRCode slightRoundQR = new QRCode("Slight Rounding", 150)
      .setRadius(0.1);

    QRCode roundedQR = new QRCode("Rounded", 150)
      .setRadius(0.3);

    QRCode circularQR = new QRCode("Circular Modules", 150)
      .setRadius(0.5);

    Div radiusCode = new Div();
    radiusCode.setText(
      "// Sharp corners (default)\n" +
      "QRCode sharpQR = new QRCode(\"Sharp\").setRadius(0);\n\n" +
      "// Slightly rounded\n" +
      "QRCode slightRoundQR = new QRCode(\"Rounded\").setRadius(0.1);\n\n" +
      "// More rounded\n" +
      "QRCode roundedQR = new QRCode(\"Rounded\").setRadius(0.3);\n\n" +
      "// Circular modules (max)\n" +
      "QRCode circularQR = new QRCode(\"Circular\").setRadius(0.5);"
    );
    styleCodeBlock(radiusCode);

    radiusDemo.add(sharpQR, slightRoundQR, roundedQR, circularQR);
    radiusExample.add(radiusDemo, radiusCode);

    // Error Correction section
    FlexLayout errorCorrectionExample = createSection(
      "Error Correction",
      "QR codes can recover from damage. Higher error correction levels create more complex codes but can recover from more damage."
    );

    FlexLayout errorCorrectionDemo = new FlexLayout();
    errorCorrectionDemo.setSpacing("20px");
    errorCorrectionDemo.setAlignment(FlexAlignment.CENTER);

    QRCode lowEC = new QRCode("Low EC", 150)
      .setErrorCorrection(QRCode.ErrorCorrection.LOW);

    QRCode mediumEC = new QRCode("Medium EC", 150)
      .setErrorCorrection(QRCode.ErrorCorrection.MEDIUM);

    QRCode quartileEC = new QRCode("Quartile EC", 150)
      .setErrorCorrection(QRCode.ErrorCorrection.QUARTILE);

    QRCode highEC = new QRCode("High EC", 150)
      .setErrorCorrection(QRCode.ErrorCorrection.HIGH);

    Div errorCorrectionCode = new Div();
    errorCorrectionCode.setText(
      "// Using enum\n" +
      "qrCode.setErrorCorrection(QRCode.ErrorCorrection.LOW);     // ~7% recovery\n" +
      "qrCode.setErrorCorrection(QRCode.ErrorCorrection.MEDIUM);  // ~15% recovery\n" +
      "qrCode.setErrorCorrection(QRCode.ErrorCorrection.QUARTILE);// ~25% recovery\n" +
      "qrCode.setErrorCorrection(QRCode.ErrorCorrection.HIGH);    // ~30% recovery\n\n" +
      "// Using string values\n" +
      "qrCode.setErrorCorrection(\"L\");  // Low\n" +
      "qrCode.setErrorCorrection(\"M\");  // Medium\n" +
      "qrCode.setErrorCorrection(\"Q\");  // Quartile\n" +
      "qrCode.setErrorCorrection(\"H\");  // High (default)"
    );
    styleCodeBlock(errorCorrectionCode);

    errorCorrectionDemo.add(lowEC, mediumEC, quartileEC, highEC);
    errorCorrectionExample.add(errorCorrectionDemo, errorCorrectionCode);

    // Accessibility section
    FlexLayout accessibilityExample = createSection(
      "Accessibility",
      "Use the label property to provide accessible text for screen readers."
    );

    FlexLayout accessibilityDemo = new FlexLayout();
    accessibilityDemo.setDirection(FlexDirection.COLUMN);
    accessibilityDemo.setSpacing("20px");

    QRCode accessibleQR = new QRCode("https://github.com/shoelace-style/shoelace", 200)
      .setLabel("QR code linking to Shoelace's GitHub repository");

    Div accessibilityCode = new Div();
    accessibilityCode.setText(
      "// Provide a descriptive label for screen readers\n" +
      "QRCode accessibleQR = new QRCode(\"https://github.com/shoelace-style/shoelace\")\n" +
      "    .setLabel(\"QR code linking to Shoelace's GitHub repository\");\n\n" +
      "// The label should describe what the QR code contains\n" +
      "// or where it leads when scanned"
    );
    styleCodeBlock(accessibilityCode);

    accessibilityDemo.add(accessibleQR, accessibilityCode);
    accessibilityExample.add(accessibilityDemo);

    // Properties table section
    FlexLayout propertiesSection = createSection(
      "Properties Table",
      "The QRCode component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events table section
    FlexLayout eventsTableSection = createSection(
      "Events Table",
      "The QRCode component supports the following events:"
    );

    FlexLayout eventsTable = createEventsTable();
    eventsTableSection.add(eventsTable);

    // Add all sections to main layout
    self.add(
      header,
      basicExample,
      interactiveDemo,
      colorsExample,
      radiusExample,
      errorCorrectionExample,
      accessibilityExample,
      eventsSection,
      propertiesSection,
      eventsTableSection
    );
  }

  private void updateCodePreview(Div codePreview, TextField valueInput, TextField labelInput,
                                NumberField sizeInput, TextField fillColor, TextField backgroundColor,
                                Slider radiusSlider, ChoiceBox errorCorrectionChoice) {
    StringBuilder code = new StringBuilder();
    code.append("QRCode qrCode = new QRCode()\n");
    code.append("    .setValue(\"").append(valueInput.getValue()).append("\")\n");
    code.append("    .setLabel(\"").append(labelInput.getValue()).append("\")\n");
    code.append("    .setSize(").append(sizeInput.getValue().intValue()).append(")\n");
    code.append("    .setFill(\"").append(fillColor.getValue()).append("\")\n");
    code.append("    .setBackground(\"").append(backgroundColor.getValue()).append("\")\n");
    code.append("    .setRadius(").append(String.format("%.2f", radiusSlider.getValue() / 100.0)).append(")\n");
    String errorCorrection = errorCorrectionChoice.getSelectedItem() != null ?
      (String) errorCorrectionChoice.getSelectedItem().getKey() : "H";
    code.append("    .setErrorCorrection(\"").append(errorCorrection).append("\");");

    codePreview.setText(code.toString());
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
        .setStyle("display", "block")
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
    FlexLayout valueRow = createTableRow(false);
    valueRow.add(
      createTableCell("value", false),
      createTableCell("The data to encode in the QR code", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout labelRow = createTableRow(false);
    labelRow.add(
      createTableCell("label", false),
      createTableCell("Accessible label for screen readers", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout sizeRow = createTableRow(false);
    sizeRow.add(
      createTableCell("size", false),
      createTableCell("The size of the QR code in pixels", false),
      createTableCell("int", false),
      createTableCell("128", false)
    );

    FlexLayout fillRow = createTableRow(false);
    fillRow.add(
      createTableCell("fill", false),
      createTableCell("The foreground color (modules)", false),
      createTableCell("String/Color", false),
      createTableCell("\"black\"", false)
    );

    FlexLayout backgroundRow = createTableRow(false);
    backgroundRow.add(
      createTableCell("background", false),
      createTableCell("The background color", false),
      createTableCell("String/Color", false),
      createTableCell("\"white\"", false)
    );

    FlexLayout radiusRow = createTableRow(false);
    radiusRow.add(
      createTableCell("radius", false),
      createTableCell("Corner radius of modules (0-0.5)", false),
      createTableCell("double", false),
      createTableCell("0", false)
    );

    FlexLayout errorCorrectionRow = createTableRow(false);
    errorCorrectionRow.add(
      createTableCell("errorCorrection", false),
      createTableCell("Error correction level (L, M, Q, H)", false),
      createTableCell("String/Enum", false),
      createTableCell("\"H\"", false)
    );

    table.add(headerRow, valueRow, labelRow, sizeRow, fillRow, backgroundRow, radiusRow, errorCorrectionRow);
    return table;
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
      createTableCell("Event Data", true)
    );

    // Event rows
    FlexLayout clickRow = createTableRow(false);
    clickRow.add(
      createTableCell("onClick", false),
      createTableCell("Fired when the QR code is clicked", false),
      createTableCell("clientX, clientY", false)
    );

    FlexLayout dblClickRow = createTableRow(false);
    dblClickRow.add(
      createTableCell("onDoubleClick", false),
      createTableCell("Fired when the QR code is double-clicked", false),
      createTableCell("clientX, clientY", false)
    );

    FlexLayout mouseEnterRow = createTableRow(false);
    mouseEnterRow.add(
      createTableCell("onMouseEnter", false),
      createTableCell("Fired when mouse enters the QR code area", false),
      createTableCell("-", false)
    );

    FlexLayout mouseLeaveRow = createTableRow(false);
    mouseLeaveRow.add(
      createTableCell("onMouseLeave", false),
      createTableCell("Fired when mouse leaves the QR code area", false),
      createTableCell("-", false)
    );

    FlexLayout contextMenuRow = createTableRow(false);
    contextMenuRow.add(
      createTableCell("onContextMenu", false),
      createTableCell("Fired on right-click", false),
      createTableCell("clientX, clientY", false)
    );

    table.add(headerRow, clickRow, dblClickRow, mouseEnterRow, mouseLeaveRow, contextMenuRow);
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