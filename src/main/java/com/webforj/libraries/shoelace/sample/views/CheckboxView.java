package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Checkbox;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.component.toast.Toast;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/checkbox", outlet = MainLayout.class)
@FrameTitle("Checkbox")
public class CheckboxView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public CheckboxView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Checkbox");
    Paragraph description = new Paragraph(
      "Checkboxes allow the user to toggle an option on or off. They're commonly grouped " +
      "in forms to allow users to select multiple options from a list."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.Checkbox;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "4px 8px")
               .setStyle("border-radius", "4px")
               .setStyle("font-size", "14px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Checkbox.html",
      "https://shoelace.style/components/checkbox"
    );

    header.add(title, description, componentTag, docsLinks);

    // Basic Example section
    FlexLayout basicExample = createSection(
      "Basic Example",
      "A simple checkbox with a label. Click the checkbox to toggle its state."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setSpacing("20px");
    basicDemo.setAlignment(FlexAlignment.CENTER);

    Checkbox basicCheckbox = new Checkbox("I agree to the terms and conditions");

    Div basicCode = new Div();
    basicCode.setText(
      "// Simple checkbox\n" +
      "Checkbox checkbox = new Checkbox(\"I agree to the terms\");\n\n" +
      "// Check if selected\n" +
      "boolean isChecked = checkbox.isChecked();\n\n" +
      "// Set checked state\n" +
      "checkbox.setChecked(true);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicCheckbox);
    basicExample.add(basicDemo, basicCode);

    // Sizes section
    FlexLayout sizesExample = createSection(
      "Sizes",
      "Checkboxes come in small, medium, and large sizes."
    );

    FlexLayout sizesDemo = new FlexLayout();
    sizesDemo.setDirection(FlexDirection.COLUMN);
    sizesDemo.setSpacing("15px");

    Checkbox smallCheckbox = new Checkbox("Small");
    smallCheckbox.setSize(Checkbox.Size.SMALL);

    Checkbox mediumCheckbox = new Checkbox("Medium");
    mediumCheckbox.setSize(Checkbox.Size.MEDIUM);

    Checkbox largeCheckbox = new Checkbox("Large");
    largeCheckbox.setSize(Checkbox.Size.LARGE);

    Div sizesCode = new Div();
    sizesCode.setText(
      "checkbox.setSize(Checkbox.Size.SMALL);\n" +
      "checkbox.setSize(Checkbox.Size.MEDIUM);\n" +
      "checkbox.setSize(Checkbox.Size.LARGE);"
    );
    styleCodeBlock(sizesCode);

    sizesDemo.add(smallCheckbox, mediumCheckbox, largeCheckbox, sizesCode);
    sizesExample.add(sizesDemo);

    // States section
    FlexLayout statesExample = createSection(
      "States",
      "Checkboxes can be checked, unchecked, indeterminate, or disabled."
    );

    FlexLayout statesDemo = new FlexLayout();
    statesDemo.setDirection(FlexDirection.COLUMN);
    statesDemo.setSpacing("15px");

    Checkbox checkedBox = new Checkbox("Checked");
    checkedBox.setChecked(true);

    Checkbox uncheckedBox = new Checkbox("Unchecked");

    Checkbox indeterminateBox = new Checkbox("Indeterminate");
    indeterminateBox.setIndeterminate(true);

    Checkbox disabledBox = new Checkbox("Disabled");
    disabledBox.setDisabled(true);

    Checkbox disabledCheckedBox = new Checkbox("Disabled & Checked");
    disabledCheckedBox.setChecked(true);
    disabledCheckedBox.setDisabled(true);

    Div statesCode = new Div();
    statesCode.setText(
      "// Checked state\n" +
      "checkbox.setChecked(true);\n\n" +
      "// Indeterminate state\n" +
      "checkbox.setIndeterminate(true);\n\n" +
      "// Disabled state\n" +
      "checkbox.setDisabled(true);"
    );
    styleCodeBlock(statesCode);

    statesDemo.add(checkedBox, uncheckedBox, indeterminateBox, disabledBox, disabledCheckedBox, statesCode);
    statesExample.add(statesDemo);

    // Help text section
    FlexLayout helpTextExample = createSection(
      "Help Text",
      "Add descriptive help text to checkboxes for additional context."
    );

    FlexLayout helpTextDemo = new FlexLayout();
    helpTextDemo.setDirection(FlexDirection.COLUMN);
    helpTextDemo.setSpacing("15px");

    Checkbox helpTextCheckbox = new Checkbox("Subscribe to newsletter");
    helpTextCheckbox.setHelpText("You'll receive our weekly digest every Monday");

    Checkbox requiredCheckbox = new Checkbox("I accept the privacy policy");
    requiredCheckbox.setRequired(true);
    requiredCheckbox.setHelpText("Required to continue");

    Div helpTextCode = new Div();
    helpTextCode.setText(
      "// Add help text\n" +
      "checkbox.setHelpText(\"Additional information\");\n\n" +
      "// Make required\n" +
      "checkbox.setRequired(true);"
    );
    styleCodeBlock(helpTextCode);

    helpTextDemo.add(helpTextCheckbox, requiredCheckbox, helpTextCode);
    helpTextExample.add(helpTextDemo);

    // Checkbox group section
    FlexLayout groupExample = createSection(
      "Checkbox Group",
      "Group related checkboxes together for multiple selections."
    );

    FlexLayout groupDemo = new FlexLayout();
    groupDemo.setDirection(FlexDirection.COLUMN);
    groupDemo.setSpacing("20px");

    Label groupLabel = new Label("Select your interests:");
    groupLabel.setStyle("font-weight", "bold");

    FlexLayout checkboxGroup = new FlexLayout();
    checkboxGroup.setDirection(FlexDirection.COLUMN);
    checkboxGroup.setSpacing("8px");
    checkboxGroup.setStyle("border", "1px solid #e2e8f0");
    checkboxGroup.setStyle("border-radius", "8px");
    checkboxGroup.setStyle("padding", "16px");

    String[] interests = {"Technology", "Sports", "Music", "Travel", "Food", "Gaming"};
    for (String interest : interests) {
      Checkbox cb = new Checkbox(interest);
      cb.setName("interests");
      cb.setValue(interest.toLowerCase());
      checkboxGroup.add(cb);
    }

    Div groupCode = new Div();
    groupCode.setText(
      "// Create a checkbox group\n" +
      "String[] options = {\"Option 1\", \"Option 2\", \"Option 3\"};\n" +
      "for (String option : options) {\n" +
      "  Checkbox cb = new Checkbox(option);\n" +
      "  cb.setName(\"group-name\");\n" +
      "  cb.setValue(option.toLowerCase());\n" +
      "  container.add(cb);\n" +
      "}"
    );
    styleCodeBlock(groupCode);

    groupDemo.add(groupLabel, checkboxGroup, groupCode);
    groupExample.add(groupDemo);

    // Event Handling section
    FlexLayout eventsSection = createSection(
      "Event Handling",
      "Checkbox components support various events for responding to user interaction. " +
      "The primary event is the change event, which fires when the checked state changes."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("30px");

    // Interactive event demo
    FlexLayout eventCheckboxContainer = new FlexLayout();
    eventCheckboxContainer.setDirection(FlexDirection.COLUMN);
    eventCheckboxContainer.setAlignment(FlexAlignment.CENTER);
    eventCheckboxContainer.setSpacing("20px");

    Checkbox eventCheckbox = new Checkbox("Click me to trigger events!");
    eventCheckbox.setSize(Checkbox.Size.LARGE);
    eventCheckbox.setHelpText("Try clicking, tabbing to/from, and submitting with validation");

    // Event status display
    Div eventStatus = new Div();
    eventStatus.setText("Interact with the checkbox above to see events in action!");
    eventStatus.setStyle("padding", "16px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border-radius", "8px")
               .setStyle("text-align", "center")
               .setStyle("font-size", "14px")
               .setStyle("min-height", "50px")
               .setStyle("display", "flex")
               .setStyle("align-items", "center")
               .setStyle("justify-content", "center");

    // Register event handlers
    eventCheckbox.onChange(event -> {
      String message = String.format("Change event: Checkbox is now %s%s", 
        event.isChecked() ? "checked" : "unchecked",
        event.isIndeterminate() ? " (indeterminate)" : "");
      eventStatus.setText(message);
      eventStatus.setStyle("background", event.isChecked() ? "#c8e6c9" : "#ffccbc");
      Toast.show(event.isChecked() ? "Checkbox checked!" : "Checkbox unchecked!");
    });

    eventCheckbox.onInput(event -> {
      // This fires immediately when state changes (before change event)
      String message = String.format("Input event: Real-time state = %s", 
        event.isChecked() ? "checked" : "unchecked");
      eventStatus.setText(message);
      eventStatus.setStyle("background", "#e1f5fe");
    });

    eventCheckbox.onFocus(event -> {
      eventStatus.setText("Focus event: Checkbox has keyboard focus");
      eventStatus.setStyle("background", "#fff3cd");
    });

    eventCheckbox.onBlur(event -> {
      eventStatus.setText("Blur event: Checkbox lost focus");
      eventStatus.setStyle("background", "#f8f9fa");
    });

    // Add indeterminate toggle button
    Button indeterminateToggle = new Button("Toggle Indeterminate");
    indeterminateToggle.addClickListener(e -> {
      eventCheckbox.setIndeterminate(!eventCheckbox.isIndeterminate());
      eventStatus.setText("Indeterminate state toggled");
      eventStatus.setStyle("background", "#e8eaf6");
    });

    // Validation demo
    Checkbox validationCheckbox = new Checkbox("Required checkbox (submit to validate)");
    validationCheckbox.setRequired(true);
    validationCheckbox.setHelpText("This checkbox must be checked to submit");

    Button validateButton = new Button("Validate");
    validateButton.addClickListener(e -> {
      // In a real form, this would trigger automatically
      if (!validationCheckbox.isChecked()) {
        eventStatus.setText("Invalid event: Required checkbox not checked!");
        eventStatus.setStyle("background", "#ffebee");
      }
    });

    validationCheckbox.onInvalid(event -> {
      eventStatus.setText("Invalid event fired: Validation failed!");
      eventStatus.setStyle("background", "#ffebee");
      Toast.show("Please check the required checkbox!");
    });

    FlexLayout validationGroup = new FlexLayout();
    validationGroup.setSpacing("10px");
    validationGroup.setAlignment(FlexAlignment.CENTER);
    validationGroup.add(validationCheckbox, validateButton);

    eventCheckboxContainer.add(eventCheckbox, indeterminateToggle, eventStatus, validationGroup);

    // Event code examples
    Div eventCode = new Div();
    eventCode.setText(
      "// Change event - primary event for checkbox interaction\n" +
      "checkbox.onChange(event -> {\n" +
      "    boolean isChecked = event.isChecked();\n" +
      "    boolean isIndeterminate = event.isIndeterminate();\n" +
      "    System.out.println(\"Checkbox changed to: \" + isChecked);\n" +
      "});\n\n" +
      "// Input event - fires immediately on state change\n" +
      "checkbox.onInput(event -> {\n" +
      "    // Real-time updates\n" +
      "    updateUI(event.isChecked());\n" +
      "});\n\n" +
      "// Focus/blur events\n" +
      "checkbox.onFocus(event -> highlightCheckbox());\n" +
      "checkbox.onBlur(event -> removeHighlight());\n\n" +
      "// Validation event\n" +
      "checkbox.onInvalid(event -> {\n" +
      "    showValidationError(\"This field is required\");\n" +
      "});\n\n" +
      "// Remove listener when needed\n" +
      "ListenerRegistration<Checkbox.ChangeEvent> reg = checkbox.onChange(handler);\n" +
      "reg.remove();"
    );
    styleCodeBlock(eventCode);

    eventsDemo.add(eventCheckboxContainer, eventCode);
    eventsSection.add(eventsDemo);

    // Interactive example
    FlexLayout interactiveExample = createSection(
      "Interactive Example",
      "Try different checkbox configurations."
    );

    FlexLayout interactiveDemo = new FlexLayout();
    interactiveDemo.setDirection(FlexDirection.COLUMN);
    interactiveDemo.setSpacing("20px");

    // Controls
    FlexLayout controls = new FlexLayout();
    controls.setDirection(FlexDirection.COLUMN);
    controls.setSpacing("15px");

    com.webforj.component.field.TextField labelInput = new com.webforj.component.field.TextField();
    labelInput.setLabel("Label");
    labelInput.setValue("Custom Checkbox");

    com.webforj.component.field.TextField helpInput = new com.webforj.component.field.TextField();
    helpInput.setLabel("Help Text");
    helpInput.setPlaceholder("Optional help text");

    com.webforj.component.list.ChoiceBox sizeChoice = new com.webforj.component.list.ChoiceBox();
    sizeChoice.setLabel("Size");
    sizeChoice.add("small", "Small");
    sizeChoice.add("medium", "Medium");
    sizeChoice.add("large", "Large");
    sizeChoice.selectKey("medium");

    com.webforj.component.optioninput.CheckBox checkedCheck = new com.webforj.component.optioninput.CheckBox("Checked");
    com.webforj.component.optioninput.CheckBox indeterminateCheck = new com.webforj.component.optioninput.CheckBox("Indeterminate");
    com.webforj.component.optioninput.CheckBox disabledCheck = new com.webforj.component.optioninput.CheckBox("Disabled");
    com.webforj.component.optioninput.CheckBox requiredCheck = new com.webforj.component.optioninput.CheckBox("Required");

    controls.add(labelInput, helpInput, sizeChoice, checkedCheck,
                 indeterminateCheck, disabledCheck, requiredCheck);

    // Preview checkbox
    Checkbox previewCheckbox = new Checkbox("Custom Checkbox");

    FlexLayout previewContainer = new FlexLayout();
    previewContainer.setAlignment(FlexAlignment.CENTER);
    previewContainer.setJustifyContent(com.webforj.component.layout.flexlayout.FlexJustifyContent.CENTER);
    previewContainer.setStyle("min-height", "100px");
    previewContainer.setStyle("border", "1px dashed #dee2e6");
    previewContainer.setStyle("border-radius", "8px");
    previewContainer.add(previewCheckbox);

    // Event handlers
    labelInput.onModify(e -> previewCheckbox.setHtml(labelInput.getValue()));
    helpInput.onModify(e -> previewCheckbox.setHelpText(helpInput.getValue()));

    sizeChoice.onSelect(e -> {
      String size = (String) sizeChoice.getSelectedKey();
      previewCheckbox.setSize(size);
    });

    checkedCheck.addValueChangeListener(e ->
      previewCheckbox.setChecked(checkedCheck.isChecked())
    );

    indeterminateCheck.addValueChangeListener(e ->
      previewCheckbox.setIndeterminate(indeterminateCheck.isChecked())
    );

    disabledCheck.addValueChangeListener(e ->
      previewCheckbox.setDisabled(disabledCheck.isChecked())
    );

    requiredCheck.addValueChangeListener(e ->
      previewCheckbox.setRequired(requiredCheck.isChecked())
    );

    interactiveDemo.add(controls, previewContainer);
    interactiveExample.add(interactiveDemo);

    // Properties table section
    FlexLayout propertiesSection = createSection(
      "Properties Table",
      "The Checkbox component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events table section
    FlexLayout eventsTableSection = createSection(
      "Events Table",
      "The Checkbox component supports the following events:"
    );

    FlexLayout eventsTable = createEventsTable();
    eventsTableSection.add(eventsTable);

    // Add all sections to main layout
    self.add(
      header,
      basicExample,
      sizesExample,
      statesExample,
      helpTextExample,
      groupExample,
      eventsSection,
      interactiveExample,
      propertiesSection,
      eventsTableSection
    );
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
      {"name", "Form control name", "String", "\"\""},
      {"value", "Form control value", "String", "\"\""},
      {"size", "Size of the checkbox", "String", "\"medium\""},
      {"disabled", "Disables the checkbox", "boolean", "false"},
      {"checked", "Whether checked", "boolean", "false"},
      {"indeterminate", "Indeterminate state", "boolean", "false"},
      {"required", "Makes checkbox required", "boolean", "false"},
      {"help-text", "Help text description", "String", "\"\""}
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
    FlexLayout changeRow = createTableRow(false);
    changeRow.add(
      createTableCell("onChange", false),
      createTableCell("Fired when checked state changes", false),
      createTableCell("checked, indeterminate", false)
    );

    FlexLayout inputRow = createTableRow(false);
    inputRow.add(
      createTableCell("onInput", false),
      createTableCell("Fired immediately when value changes", false),
      createTableCell("checked, indeterminate", false)
    );

    FlexLayout focusRow = createTableRow(false);
    focusRow.add(
      createTableCell("onFocus", false),
      createTableCell("Fired when checkbox gains focus", false),
      createTableCell("-", false)
    );

    FlexLayout blurRow = createTableRow(false);
    blurRow.add(
      createTableCell("onBlur", false),
      createTableCell("Fired when checkbox loses focus", false),
      createTableCell("-", false)
    );

    FlexLayout invalidRow = createTableRow(false);
    invalidRow.add(
      createTableCell("onInvalid", false),
      createTableCell("Fired when form validation fails", false),
      createTableCell("-", false)
    );

    table.add(headerRow, changeRow, inputRow, focusRow, blurRow, invalidRow);
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