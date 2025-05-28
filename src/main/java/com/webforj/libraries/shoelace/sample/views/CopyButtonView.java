package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.CopyButton;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.field.TextArea;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.*;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/copy-button", outlet = MainLayout.class)
@FrameTitle("Copy Button")
public class CopyButtonView extends Composite<FlexLayout> {
  private final FlexLayout self = getBoundComponent();

  public CopyButtonView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Copy Button");
    Paragraph description = new Paragraph(
      "Copy buttons let users copy text or other data to the clipboard with a single click. " +
      "They provide visual feedback when copying succeeds or fails."
    );

    // Documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/CopyButton.html",
      "https://shoelace.style/components/copy-button"
    );

    header.add(title, description, docLinks);

    // Basic example section
    FlexLayout basicExample = createSection(
      "Basic Copy Button",
      "Click the button to copy text to the clipboard."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    CopyButton basicCopy = new CopyButton("Hello, World!");

    Paragraph basicInfo = new Paragraph("Click the copy button to copy \"Hello, World!\" to your clipboard.");
    basicInfo.setStyle("color", "#6b7280");

    Div basicCode = new Div();
    basicCode.setText(
      "// Copy a simple string\n" +
      "CopyButton copyBtn = new CopyButton(\"Hello, World!\");\n\n" +
      "// Get the value\n" +
      "String value = copyBtn.getValue();\n\n" +
      "// Change the value\n" +
      "copyBtn.setValue(\"New text to copy\");"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicCopy, basicInfo, basicCode);
    basicExample.add(basicDemo);

    // Copy from input section
    FlexLayout inputExample = createSection(
      "Copy from Input",
      "Copy values from form controls using the from attribute."
    );

    FlexLayout inputDemo = new FlexLayout();
    inputDemo.setDirection(FlexDirection.COLUMN);
    inputDemo.setSpacing("20px");

    TextField emailInput = new TextField();
    emailInput.setLabel("Email Address");
    emailInput.setValue("user@example.com");
    emailInput.setAttribute("id", "email-input");
    emailInput.setStyle("max-width", "300px");

    FlexLayout emailRow = new FlexLayout();
    emailRow.setSpacing("10px");
    emailRow.setAlignment(FlexAlignment.END);

    CopyButton emailCopy = new CopyButton();
    emailCopy.setFrom("email-input");

    emailRow.add(emailInput, emailCopy);

    TextArea codeArea = new TextArea();
    codeArea.setLabel("Code Snippet");
    codeArea.setValue("const greeting = 'Hello, World!';\nconsole.log(greeting);");
    codeArea.setAttribute("id", "code-area");
    codeArea.setRows(3);
    codeArea.setStyle("font-family", "monospace");

    CopyButton codeCopy = new CopyButton();
    codeCopy.setFrom("code-area");
    codeCopy.setStyle("margin-top", "10px");

    Div inputCode = new Div();
    inputCode.setText(
      "// Copy from an input element\n" +
      "TextField input = new TextField();\n" +
      "input.setId(\"my-input\");\n\n" +
      "CopyButton copyBtn = new CopyButton();\n" +
      "copyBtn.setFrom(\"my-input\");"
    );
    styleCodeBlock(inputCode);

    inputDemo.add(emailRow, codeArea, codeCopy, inputCode);
    inputExample.add(inputDemo);

    // Custom labels section
    FlexLayout labelsExample = createSection(
      "Custom Labels",
      "Customize the tooltip labels for different states."
    );

    FlexLayout labelsDemo = new FlexLayout();
    labelsDemo.setDirection(FlexDirection.COLUMN);
    labelsDemo.setSpacing("20px");

    FlexLayout labelsContainer = new FlexLayout();
    labelsContainer.setSpacing("20px");
    labelsContainer.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    // Different languages
    CopyButton spanishCopy = new CopyButton("¡Hola, Mundo!");
    spanishCopy.setCopyLabel("Copiar");
    spanishCopy.setSuccessLabel("Copiado");
    spanishCopy.setErrorLabel("Error");

    CopyButton frenchCopy = new CopyButton("Bonjour le monde!");
    frenchCopy.setCopyLabel("Copier");
    frenchCopy.setSuccessLabel("Copié");
    frenchCopy.setErrorLabel("Erreur");

    CopyButton customCopy = new CopyButton("Custom feedback");
    customCopy.setCopyLabel("Click to copy");
    customCopy.setSuccessLabel("Yay! Copied! 🎉");
    customCopy.setErrorLabel("Oops! Try again");
    customCopy.setFeedbackDuration(2000);

    labelsContainer.add(spanishCopy, frenchCopy, customCopy);

    Div labelsCode = new Div();
    labelsCode.setText(
      "// Customize labels\n" +
      "copyBtn.setCopyLabel(\"Click to copy\");\n" +
      "copyBtn.setSuccessLabel(\"Copied! 🎉\");\n" +
      "copyBtn.setErrorLabel(\"Failed to copy\");\n\n" +
      "// Change feedback duration\n" +
      "copyBtn.setFeedbackDuration(2000); // 2 seconds"
    );
    styleCodeBlock(labelsCode);

    labelsDemo.add(labelsContainer, labelsCode);
    labelsExample.add(labelsDemo);

    // Custom trigger section
    FlexLayout triggerExample = createSection(
      "Custom Trigger",
      "Use any element as the copy trigger."
    );

    FlexLayout triggerDemo = new FlexLayout();
    triggerDemo.setDirection(FlexDirection.COLUMN);
    triggerDemo.setSpacing("20px");

    FlexLayout triggersContainer = new FlexLayout();
    triggersContainer.setSpacing("20px");
    triggersContainer.setAlignment(FlexAlignment.CENTER);

    // Button trigger
    CopyButton buttonTrigger = new CopyButton("Copy with button");
    ShoelaceButton customButton = new ShoelaceButton("Copy to Clipboard");
    customButton.setVariant(ShoelaceButton.Variant.PRIMARY);
    customButton.setPrefix(TablerIcon.create("copy"));
    buttonTrigger.add(customButton);

    // Link trigger
    CopyButton linkTrigger = new CopyButton("https://shoelace.style");
    Anchor linkElement = new Anchor();
    linkElement.setText("Copy Link");
    linkElement.setHref("#");
    linkElement.setStyle("color", "#0969da");
    linkElement.setStyle("text-decoration", "underline");
    linkTrigger.add(linkElement);

    // Icon trigger
    CopyButton iconTrigger = new CopyButton("Icon triggered copy");
    Div iconWrapper = new Div();
    iconWrapper.add(TablerIcon.create("clipboard"));
    iconWrapper.setStyle("cursor", "pointer");
    iconWrapper.setStyle("padding", "8px");
    iconWrapper.setStyle("border-radius", "4px");
    iconWrapper.setStyle("background", "#f3f4f6");
    iconWrapper.setStyle("display", "inline-block");
    iconTrigger.add(iconWrapper);

    triggersContainer.add(buttonTrigger, linkTrigger, iconTrigger);

    Div triggerCode = new Div();
    triggerCode.setText(
      "// Custom button trigger\n" +
      "CopyButton copyBtn = new CopyButton(\"Text to copy\");\n" +
      "ShoelaceButton button = new ShoelaceButton(\"Copy\");\n" +
      "copyBtn.add(button);\n\n" +
      "// Custom icon trigger\n" +
      "copyBtn.add(TablerIcon.create(\"clipboard\"));"
    );
    styleCodeBlock(triggerCode);

    triggerDemo.add(triggersContainer, triggerCode);
    triggerExample.add(triggerDemo);

    // Complex content section
    FlexLayout complexExample = createSection(
      "Complex Content",
      "Copy formatted content or multiple values."
    );

    FlexLayout complexDemo = new FlexLayout();
    complexDemo.setDirection(FlexDirection.COLUMN);
    complexDemo.setSpacing("20px");

    // API key example
    FlexLayout apiKeyContainer = new FlexLayout();
    apiKeyContainer.setSpacing("10px");
    apiKeyContainer.setAlignment(FlexAlignment.CENTER);
    apiKeyContainer.setStyle("background", "#f9fafb");
    apiKeyContainer.setStyle("padding", "12px");
    apiKeyContainer.setStyle("border-radius", "8px");
    apiKeyContainer.setStyle("border", "1px solid #e5e7eb");

    Div apiKey = new Div();
    apiKey.setText("sk-1234567890abcdef");
    apiKey.setStyle("font-family", "monospace");
    apiKey.setStyle("background", "#e5e7eb");
    apiKey.setStyle("padding", "4px 8px");
    apiKey.setStyle("border-radius", "4px");

    CopyButton apiKeyCopy = new CopyButton("sk-1234567890abcdef");
    apiKeyCopy.setTooltipPlacement("right");

    apiKeyContainer.add(apiKey, apiKeyCopy);

    // Contact info example
    String contactInfo = "John Doe\nEmail: john@example.com\nPhone: +1-555-0123";

    Div contactCard = new Div();
    contactCard.setStyle("background", "#ffffff");
    contactCard.setStyle("padding", "16px");
    contactCard.setStyle("border", "1px solid #e5e7eb");
    contactCard.setStyle("border-radius", "8px");
    contactCard.setStyle("max-width", "300px");

    H4 contactName = new H4("John Doe");
    contactName.setStyle("margin", "0 0 8px 0");

    Div contactDetails = new Div();
    contactDetails.setHtml("Email: john@example.com<br>Phone: +1-555-0123");
    contactDetails.setStyle("color", "#6b7280");
    contactDetails.setStyle("font-size", "14px");

    CopyButton contactCopy = new CopyButton(contactInfo);
    contactCopy.setCopyLabel("Copy contact");
    contactCopy.setStyle("margin-top", "12px");

    contactCard.add(contactName, contactDetails, contactCopy);

    Div complexCode = new Div();
    complexCode.setText(
      "// Copy multi-line content\n" +
      "String data = \"Line 1\\nLine 2\\nLine 3\";\n" +
      "CopyButton copyBtn = new CopyButton(data);\n\n" +
      "// Position tooltip\n" +
      "copyBtn.setTooltipPlacement(\"right\");"
    );
    styleCodeBlock(complexCode);

    complexDemo.add(apiKeyContainer, contactCard, complexCode);
    complexExample.add(complexDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Copy Button component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events section
    FlexLayout eventsExample = createSection(
      "Events",
      "Copy buttons emit events when copying succeeds or fails."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Event demo container
    FlexLayout eventDemoContainer = new FlexLayout();
    eventDemoContainer.setDirection(FlexDirection.COLUMN);
    eventDemoContainer.setSpacing("15px");
    eventDemoContainer.setStyle("border", "1px solid #dee2e6")
                      .setStyle("border-radius", "8px")
                      .setStyle("padding", "20px")
                      .setStyle("background", "#f8f9fa");

    H3 eventDemoTitle = new H3("Try the Events");
    
    // Copy buttons for event demo
    FlexLayout buttonsRow = new FlexLayout();
    buttonsRow.setSpacing("15px");
    buttonsRow.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    CopyButton successCopy = new CopyButton("Click to copy this text successfully");
    successCopy.setCopyLabel("Copy Text");
    successCopy.setSuccessLabel("Copied! ✓");

    // Create a button that will fail (trying to copy from non-existent element)
    CopyButton errorCopy = new CopyButton();
    errorCopy.setFrom("non-existent-element-id");
    errorCopy.setCopyLabel("Copy (will fail)");
    errorCopy.setErrorLabel("Failed! ✗");

    // Event output labels
    Label copyEventLabel = new Label("Copy Event: No event fired yet");
    copyEventLabel.setStyle("font-size", "14px")
                  .setStyle("color", "#6c757d")
                  .setStyle("padding", "10px")
                  .setStyle("background", "#ffffff")
                  .setStyle("border-radius", "4px")
                  .setStyle("border", "1px solid #dee2e6");

    Label errorEventLabel = new Label("Error Event: No event fired yet");
    errorEventLabel.setStyle("font-size", "14px")
                   .setStyle("color", "#6c757d")
                   .setStyle("padding", "10px")
                   .setStyle("background", "#ffffff")
                   .setStyle("border-radius", "4px")
                   .setStyle("border", "1px solid #dee2e6");

    Label lastActionLabel = new Label("Last Action: None");
    lastActionLabel.setStyle("font-size", "14px")
                   .setStyle("color", "#495057")
                   .setStyle("font-weight", "bold");

    // Add event listeners
    successCopy.onCopy(event -> {
      String value = event.getValue();
      copyEventLabel.setText("Copy Event: Successfully copied \"" + value + "\"");
      copyEventLabel.setStyle("color", "#28a745")
                    .setStyle("background", "#d4edda")
                    .setStyle("border-color", "#c3e6cb");
      lastActionLabel.setText("Last Action: Copy Success at " + new java.util.Date());
      
      // Styling will show the success state
    });

    errorCopy.onCopy(event -> {
      // This won't fire for the error button
      copyEventLabel.setText("Copy Event: Unexpected success!");
    });

    successCopy.onError(event -> {
      errorEventLabel.setText("Error Event: Copy failed - " + event.getMessage());
      errorEventLabel.setStyle("color", "#dc3545")
                     .setStyle("background", "#f8d7da")
                     .setStyle("border-color", "#f5c6cb");
      lastActionLabel.setText("Last Action: Copy Error");
    });

    errorCopy.onError(event -> {
      errorEventLabel.setText("Error Event: Copy failed (expected) - Element not found");
      errorEventLabel.setStyle("color", "#dc3545")
                     .setStyle("background", "#f8d7da")
                     .setStyle("border-color", "#f5c6cb");
      lastActionLabel.setText("Last Action: Copy Error at " + new java.util.Date());
      
      // Styling will show the error state
    });

    buttonsRow.add(successCopy, errorCopy);
    eventDemoContainer.add(eventDemoTitle, buttonsRow, lastActionLabel, copyEventLabel, errorEventLabel);

    Div eventsCode = new Div();
    eventsCode.setText(
      "// Listen for successful copy events\n" +
      "copyButton.onCopy(event -> {\n" +
      "    String copiedValue = event.getValue();\n" +
      "    System.out.println(\"Copied: \" + copiedValue);\n" +
      "    showSuccessNotification(\"Copied to clipboard!\");\n" +
      "});\n\n" +
      "// Listen for copy error events\n" +
      "copyButton.onError(event -> {\n" +
      "    String errorMessage = event.getMessage();\n" +
      "    System.err.println(\"Copy failed: \" + errorMessage);\n" +
      "    showErrorNotification(\"Failed to copy\");\n" +
      "});\n\n" +
      "// Events provide:\n" +
      "// CopyEvent: getValue() - The text that was copied\n" +
      "// ErrorEvent: getMessage() - Error description"
    );
    styleCodeBlock(eventsCode);

    eventsDemo.add(eventDemoContainer, eventsCode);
    eventsExample.add(eventsDemo);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsExample.add(eventsTable);

    // Add all sections to main layout
    self.add(header, basicExample, inputExample, labelsExample,
             triggerExample, complexExample, eventsExample, propertiesSection);
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
    table.add(headerRow);

    // Data rows
    String[][] properties = {
      {"value", "Text to copy", "String", "\"\""},
      {"from", "ID of element to copy from", "String", "\"\""},
      {"disabled", "Disables the button", "boolean", "false"},
      {"copy-label", "Copy state label", "String", "\"Copy\""},
      {"success-label", "Success state label", "String", "\"Copied\""},
      {"error-label", "Error state label", "String", "\"Error\""},
      {"feedback-duration", "Feedback duration (ms)", "int", "1000"},
      {"tooltip-placement", "Tooltip position", "String", "\"top\""},
      {"hoist", "Hoist the tooltip", "boolean", "false"}
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
    FlexLayout copyRow = createTableRow(false);
    copyRow.add(
      createTableCell("sl-copy", false),
      createTableCell("Emitted when the text is successfully copied", false),
      createTableCell("value: string - The text that was copied", false)
    );
    table.add(copyRow);

    FlexLayout errorRow = createTableRow(false);
    errorRow.add(
      createTableCell("sl-error", false),
      createTableCell("Emitted when the copy operation fails", false),
      createTableCell("None", false)
    );
    table.add(errorRow);

    return table;
  }
}
