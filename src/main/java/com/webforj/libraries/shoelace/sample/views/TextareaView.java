package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Textarea;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/textarea", outlet = MainLayout.class)
@FrameTitle("Textarea")
public class TextareaView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public TextareaView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Textarea");
    Paragraph description = new Paragraph(
      "Textareas collect data from the user and allow multiple lines of text. " +
      "They support various sizes, resize options, and states."
    );

    // Documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Textarea.html",
      "https://shoelace.style/components/textarea"
    );

    header.add(title, description, docLinks);

    // Basic textarea example
    FlexLayout basicExample = createSection(
      "Basic Textarea",
      "Use the label attribute to give the textarea an accessible label. Use the placeholder attribute to add placeholder text."
    );

    Textarea basicTextarea = new Textarea()
        .setLabel("Comments")
        .setPlaceholder("Enter your comments here...");

    Div basicCode = new Div();
    basicCode.setText(
      "Textarea textarea = new Textarea()\n" +
      "    .setLabel(\"Comments\")\n" +
      "    .setPlaceholder(\"Enter your comments here...\");"
    );
    styleCodeBlock(basicCode);

    basicExample.add(basicTextarea, basicCode);

    // Sizes section
    FlexLayout sizesExample = createSection(
      "Sizes",
      "Use the size attribute to change a textarea's size."
    );

    FlexLayout sizesDemo = new FlexLayout();
    sizesDemo.setDirection(FlexDirection.COLUMN);
    sizesDemo.setSpacing("20px");

    Textarea smallTextarea = new Textarea()
        .setLabel("Small")
        .setSize("small")
        .setPlaceholder("Small textarea")
        .setRows(3);

    Textarea mediumTextarea = new Textarea()
        .setLabel("Medium")
        .setSize("medium")
        .setPlaceholder("Medium textarea")
        .setRows(3);

    Textarea largeTextarea = new Textarea()
        .setLabel("Large")
        .setSize("large")
        .setPlaceholder("Large textarea")
        .setRows(3);

    Div sizesCode = new Div();
    sizesCode.setText(
      "Textarea smallTextarea = new Textarea()\n" +
      "    .setLabel(\"Small\")\n" +
      "    .setSize(\"small\")\n" +
      "    .setRows(3);\n\n" +
      "Textarea mediumTextarea = new Textarea()\n" +
      "    .setLabel(\"Medium\")\n" +
      "    .setSize(\"medium\")\n" +
      "    .setRows(3);\n\n" +
      "Textarea largeTextarea = new Textarea()\n" +
      "    .setLabel(\"Large\")\n" +
      "    .setSize(\"large\")\n" +
      "    .setRows(3);"
    );
    styleCodeBlock(sizesCode);

    sizesDemo.add(smallTextarea, mediumTextarea, largeTextarea);
    sizesExample.add(sizesDemo, sizesCode);

    // Rows section
    FlexLayout rowsExample = createSection(
      "Rows",
      "Use the rows attribute to change the number of text rows that are displayed."
    );

    FlexLayout rowsDemo = new FlexLayout();
    rowsDemo.setDirection(FlexDirection.COLUMN);
    rowsDemo.setSpacing("20px");

    Textarea rows2 = new Textarea()
        .setLabel("2 rows")
        .setRows(2)
        .setPlaceholder("Only 2 rows");

    Textarea rows6 = new Textarea()
        .setLabel("6 rows")
        .setRows(6)
        .setPlaceholder("6 rows textarea");

    Div rowsCode = new Div();
    rowsCode.setText(
      "Textarea textarea = new Textarea()\n" +
      "    .setLabel(\"Custom rows\")\n" +
      "    .setRows(6)\n" +
      "    .setPlaceholder(\"6 rows textarea\");"
    );
    styleCodeBlock(rowsCode);

    rowsDemo.add(rows2, rows6);
    rowsExample.add(rowsDemo, rowsCode);

    // Resize options section
    FlexLayout resizeExample = createSection(
      "Resize Options",
      "Use the resize attribute to control how the textarea can be resized."
    );

    FlexLayout resizeDemo = new FlexLayout();
    resizeDemo.setDirection(FlexDirection.COLUMN);
    resizeDemo.setSpacing("20px");

    Textarea noResize = new Textarea()
        .setLabel("No resize")
        .setResize("none")
        .setPlaceholder("Cannot be resized");

    Textarea verticalResize = new Textarea()
        .setLabel("Vertical resize (default)")
        .setResize("vertical")
        .setPlaceholder("Can be resized vertically");

    Textarea autoResize = new Textarea()
        .setLabel("Auto resize")
        .setResize("auto")
        .setPlaceholder("Automatically resizes based on content")
        .setValue("This textarea will automatically resize as you type more content. Try adding more lines to see it grow!");

    Div resizeCode = new Div();
    resizeCode.setText(
      "// Prevent resizing\n" +
      "textarea.setResize(\"none\");\n\n" +
      "// Vertical resize only (default)\n" +
      "textarea.setResize(\"vertical\");\n\n" +
      "// Auto-resize based on content\n" +
      "textarea.setResize(\"auto\");"
    );
    styleCodeBlock(resizeCode);

    resizeDemo.add(noResize, verticalResize, autoResize);
    resizeExample.add(resizeDemo, resizeCode);

    // Filled variant section
    FlexLayout filledExample = createSection(
      "Filled Textareas",
      "Add the filled attribute to draw a filled textarea."
    );

    Textarea filledTextarea = new Textarea()
        .setLabel("Filled textarea")
        .setFilled(true)
        .setPlaceholder("This is a filled textarea");

    Div filledCode = new Div();
    filledCode.setText(
      "Textarea filledTextarea = new Textarea()\n" +
      "    .setLabel(\"Filled textarea\")\n" +
      "    .setFilled(true)\n" +
      "    .setPlaceholder(\"This is a filled textarea\");"
    );
    styleCodeBlock(filledCode);

    filledExample.add(filledTextarea, filledCode);

    // States section
    FlexLayout statesExample = createSection(
      "States",
      "Textareas can be disabled, readonly, or required."
    );

    FlexLayout statesDemo = new FlexLayout();
    statesDemo.setDirection(FlexDirection.COLUMN);
    statesDemo.setSpacing("20px");

    Textarea disabledTextarea = new Textarea()
        .setLabel("Disabled")
        .setDisabled(true)
        .setValue("This textarea is disabled");

    Textarea readonlyTextarea = new Textarea()
        .setLabel("Readonly")
        .setReadonly(true)
        .setValue("This textarea is read-only. You can't edit this text.");

    Textarea requiredTextarea = new Textarea()
        .setLabel("Required")
        .setRequired(true)
        .setPlaceholder("This field is required");

    Div statesCode = new Div();
    statesCode.setText(
      "// Disabled state\n" +
      "textarea.setDisabled(true);\n\n" +
      "// Readonly state\n" +
      "textarea.setReadonly(true);\n\n" +
      "// Required field\n" +
      "textarea.setRequired(true);"
    );
    styleCodeBlock(statesCode);

    statesDemo.add(disabledTextarea, readonlyTextarea, requiredTextarea);
    statesExample.add(statesDemo, statesCode);

    // Help text section
    FlexLayout helpExample = createSection(
      "Help Text",
      "Add help text to give users additional information about the textarea."
    );

    Textarea helpTextarea = new Textarea()
        .setLabel("Message")
        .setHelpText("Please provide detailed information about your inquiry")
        .setPlaceholder("Type your message here...");

    Div helpCode = new Div();
    helpCode.setText(
      "Textarea textarea = new Textarea()\n" +
      "    .setLabel(\"Message\")\n" +
      "    .setHelpText(\"Please provide detailed information\")\n" +
      "    .setPlaceholder(\"Type your message here...\");"
    );
    styleCodeBlock(helpCode);

    helpExample.add(helpTextarea, helpCode);

    // Event handling section
    FlexLayout eventsExample = createSection(
      "Event Handling",
      "The Textarea component fires events when it gains/loses focus, when its value changes, and when validation occurs."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Create a feedback form example
    FlexLayout feedbackForm = new FlexLayout();
    feedbackForm.setDirection(FlexDirection.COLUMN);
    feedbackForm.setSpacing("15px");
    feedbackForm.setStyle("border", "1px solid #dee2e6")
                .setStyle("border-radius", "8px")
                .setStyle("padding", "20px")
                .setStyle("background", "#f8f9fa");

    H3 formTitle = new H3("Feedback Form");
    
    Textarea feedbackTextarea = new Textarea("Your Feedback");
    feedbackTextarea.setPlaceholder("Share your thoughts...")
                    .setRows(5)
                    .setRequired(true)
                    .setMaxLength(500)
                    .setHelpText("Maximum 500 characters");

    // Status labels
    Label focusStatus = new Label("Focus Status: Not focused");
    focusStatus.setStyle("font-size", "14px")
               .setStyle("color", "#6c757d");
    
    Label charCount = new Label("Characters: 0/500");
    charCount.setStyle("font-size", "14px")
             .setStyle("color", "#6c757d");

    Label lastChange = new Label("Last change: None");
    lastChange.setStyle("font-size", "14px")
              .setStyle("color", "#6c757d");

    // Add event listeners
    feedbackTextarea.onFocus(event -> {
      focusStatus.setText("Focus Status: Focused ✓");
      focusStatus.setStyle("color", "#28a745");
    });

    feedbackTextarea.onBlur(event -> {
      focusStatus.setText("Focus Status: Not focused");
      focusStatus.setStyle("color", "#6c757d");
    });

    feedbackTextarea.onInput(event -> {
      String value = event.getValue();
      int length = value != null ? value.length() : 0;
      charCount.setText("Characters: " + length + "/500");
      
      if (length >= 450) {
        charCount.setStyle("color", "#dc3545");
      } else if (length >= 400) {
        charCount.setStyle("color", "#ffc107");
      } else {
        charCount.setStyle("color", "#6c757d");
      }
    });

    feedbackTextarea.onChange(event -> {
      String value = event.getValue();
      if (value != null && !value.isEmpty()) {
        lastChange.setText("Last change: Saved (" + value.length() + " chars)");
        lastChange.setStyle("color", "#28a745");
      }
    });

    feedbackTextarea.onInvalid(event -> {
      lastChange.setText("Last change: Validation failed!");
      lastChange.setStyle("color", "#dc3545");
    });

    feedbackForm.add(formTitle, feedbackTextarea, focusStatus, charCount, lastChange);

    Div eventsCode = new Div();
    eventsCode.setText(
      "// Focus event\n" +
      "textarea.onFocus(event -> {\n" +
      "    System.out.println(\"Textarea focused\");\n" +
      "});\n\n" +
      "// Blur event\n" +
      "textarea.onBlur(event -> {\n" +
      "    System.out.println(\"Textarea lost focus\");\n" +
      "});\n\n" +
      "// Input event (fires as user types)\n" +
      "textarea.onInput(event -> {\n" +
      "    String currentValue = event.getValue();\n" +
      "    System.out.println(\"Current value: \" + currentValue);\n" +
      "});\n\n" +
      "// Change event (fires when value changes and loses focus)\n" +
      "textarea.onChange(event -> {\n" +
      "    String newValue = event.getValue();\n" +
      "    System.out.println(\"Value changed to: \" + newValue);\n" +
      "});\n\n" +
      "// Invalid event\n" +
      "textarea.onInvalid(event -> {\n" +
      "    System.out.println(\"Validation failed\");\n" +
      "});"
    );
    styleCodeBlock(eventsCode);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsExample.add(eventsTable);

    eventsDemo.add(feedbackForm, eventsCode);
    eventsExample.add(eventsDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Textarea component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, sizesExample, rowsExample, resizeExample,
             filledExample, statesExample, helpExample, eventsExample, propertiesSection);
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
    FlexLayout labelRow = createTableRow(false);
    labelRow.add(
      createTableCell("label", false),
      createTableCell("The textarea's label", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout placeholderRow = createTableRow(false);
    placeholderRow.add(
      createTableCell("placeholder", false),
      createTableCell("Placeholder text", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout rowsRow = createTableRow(false);
    rowsRow.add(
      createTableCell("rows", false),
      createTableCell("The number of rows to display", false),
      createTableCell("int", false),
      createTableCell("4", false)
    );

    FlexLayout sizeRow = createTableRow(false);
    sizeRow.add(
      createTableCell("size", false),
      createTableCell("The textarea's size", false),
      createTableCell("String", false),
      createTableCell("\"medium\"", false)
    );

    FlexLayout resizeRow = createTableRow(false);
    resizeRow.add(
      createTableCell("resize", false),
      createTableCell("Controls how the textarea can be resized", false),
      createTableCell("String", false),
      createTableCell("\"vertical\"", false)
    );

    FlexLayout filledRow = createTableRow(false);
    filledRow.add(
      createTableCell("filled", false),
      createTableCell("Draws a filled textarea", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout helpTextRow = createTableRow(false);
    helpTextRow.add(
      createTableCell("helpText", false),
      createTableCell("Help text for the textarea", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout disabledRow = createTableRow(false);
    disabledRow.add(
      createTableCell("disabled", false),
      createTableCell("Disables the textarea", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout readonlyRow = createTableRow(false);
    readonlyRow.add(
      createTableCell("readonly", false),
      createTableCell("Makes the textarea readonly", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout requiredRow = createTableRow(false);
    requiredRow.add(
      createTableCell("required", false),
      createTableCell("Makes the textarea required", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    table.add(headerRow, labelRow, placeholderRow, rowsRow, sizeRow, resizeRow,
              filledRow, helpTextRow, disabledRow, readonlyRow, requiredRow);
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
    String[][] events = {
      {"sl-change", "Emitted when the value changes and the element loses focus", "value: String"},
      {"sl-input", "Emitted when the value changes (as user types)", "value: String"},
      {"sl-focus", "Emitted when the textarea gains focus", "None"},
      {"sl-blur", "Emitted when the textarea loses focus", "None"},
      {"sl-invalid", "Emitted when the element's validity is checked and fails", "None"}
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
