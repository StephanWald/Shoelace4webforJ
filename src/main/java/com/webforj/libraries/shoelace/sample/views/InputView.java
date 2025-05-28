package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Icon;
import com.webforj.libraries.shoelace.components.Input;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.component.toast.Toast;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/input", outlet = MainLayout.class)
@FrameTitle("Input")
public class InputView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public InputView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Input");
    Paragraph description = new Paragraph(
      "Inputs collect data from the user. They support various types, sizes, states, " +
      "and validation features for building robust forms."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.Input;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "4px 8px")
               .setStyle("border-radius", "4px")
               .setStyle("font-size", "14px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Input.html",
      "https://shoelace.style/components/input"
    );

    header.add(title, description, componentTag, docsLinks);

    // Basic Example section
    FlexLayout basicExample = createSection(
      "Basic Example",
      "A simple text input with label and placeholder. Try typing in the input to see it in action."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setSpacing("20px");
    basicDemo.setAlignment(FlexAlignment.CENTER);

    Input basicInput = new Input("Name");
    basicInput.setPlaceholder("Enter your name");

    Div basicCode = new Div();
    basicCode.setText(
      "// Simple input\n" +
      "Input input = new Input(\"Name\");\n" +
      "input.setPlaceholder(\"Enter your name\");\n\n" +
      "// Get and set value\n" +
      "String value = input.getValue();\n" +
      "input.setValue(\"John Doe\");"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicInput);
    basicExample.add(basicDemo, basicCode);

    // Input types section
    FlexLayout typesExample = createSection(
      "Input Types",
      "Different input types for various data formats with built-in browser validation."
    );

    FlexLayout typesDemo = new FlexLayout();
    typesDemo.setDirection(FlexDirection.COLUMN);
    typesDemo.setSpacing("15px");

    // Email input
    Input emailInput = new Input("Email", Input.Type.EMAIL);
    emailInput.setPlaceholder("user@example.com");
    emailInput.setClearable(true);

    // Number input
    Input numberInput = new Input("Age", Input.Type.NUMBER);
    numberInput.setPlaceholder("Enter your age");
    numberInput.setMin("0");
    numberInput.setMax("120");
    numberInput.setStep("1");

    // Password input
    Input passwordInput = new Input("Password", Input.Type.PASSWORD);
    passwordInput.setPlaceholder("Enter password");
    passwordInput.setPasswordToggle(true);

    // Date input
    Input dateInput = new Input("Birth Date", Input.Type.DATE);

    // Search input
    Input searchInput = new Input("Search", Input.Type.SEARCH);
    searchInput.setPlaceholder("Search...");
    searchInput.setClearable(true);

    Div typesCode = new Div();
    typesCode.setText(
      "// Email input\n" +
      "Input email = new Input(\"Email\", Input.Type.EMAIL);\n" +
      "email.setClearable(true);\n\n" +
      "// Number input with min/max\n" +
      "Input age = new Input(\"Age\", Input.Type.NUMBER);\n" +
      "age.setMin(\"0\").setMax(\"120\").setStep(\"1\");\n\n" +
      "// Password with toggle\n" +
      "Input password = new Input(\"Password\", Input.Type.PASSWORD);\n" +
      "password.setPasswordToggle(true);\n\n" +
      "// Date input\n" +
      "Input date = new Input(\"Date\", Input.Type.DATE);\n\n" +
      "// Search with clear button\n" +
      "Input search = new Input(\"Search\", Input.Type.SEARCH);\n" +
      "search.setClearable(true);"
    );
    styleCodeBlock(typesCode);

    typesDemo.add(emailInput, numberInput, passwordInput, dateInput, searchInput, typesCode);
    typesExample.add(typesDemo);

    // Sizes section
    FlexLayout sizesExample = createSection(
      "Sizes",
      "Inputs come in three sizes: small, medium, and large."
    );

    FlexLayout sizesDemo = new FlexLayout();
    sizesDemo.setDirection(FlexDirection.COLUMN);
    sizesDemo.setSpacing("15px");

    Input smallInput = new Input("Small");
    smallInput.setSize(Input.Size.SMALL);
    smallInput.setPlaceholder("Small input");

    Input mediumInput = new Input("Medium");
    mediumInput.setSize(Input.Size.MEDIUM);
    mediumInput.setPlaceholder("Medium input (default)");

    Input largeInput = new Input("Large");
    largeInput.setSize(Input.Size.LARGE);
    largeInput.setPlaceholder("Large input");

    Div sizesCode = new Div();
    sizesCode.setText(
      "input.setSize(Input.Size.SMALL);\n" +
      "input.setSize(Input.Size.MEDIUM);\n" +
      "input.setSize(Input.Size.LARGE);"
    );
    styleCodeBlock(sizesCode);

    sizesDemo.add(smallInput, mediumInput, largeInput, sizesCode);
    sizesExample.add(sizesDemo);

    // States section
    FlexLayout statesExample = createSection(
      "States",
      "Various states to control input behavior and appearance."
    );

    FlexLayout statesDemo = new FlexLayout();
    statesDemo.setDirection(FlexDirection.COLUMN);
    statesDemo.setSpacing("15px");

    // Disabled input
    Input disabledInput = new Input("Disabled");
    disabledInput.setValue("Cannot edit this");
    disabledInput.setDisabled(true);

    // Readonly input
    Input readonlyInput = new Input("Readonly");
    readonlyInput.setValue("Can select but not edit");
    readonlyInput.setReadonly(true);

    // Required input
    Input requiredInput = new Input("Required Field");
    requiredInput.setPlaceholder("This field is required");
    requiredInput.setRequired(true);

    // Pill input
    Input pillInput = new Input("Pill Shape");
    pillInput.setPlaceholder("Rounded corners");
    pillInput.setPill(true);

    Div statesCode = new Div();
    statesCode.setText(
      "// Disabled state\n" +
      "input.setDisabled(true);\n\n" +
      "// Readonly state\n" +
      "input.setReadonly(true);\n\n" +
      "// Required field\n" +
      "input.setRequired(true);\n\n" +
      "// Pill shape\n" +
      "input.setPill(true);"
    );
    styleCodeBlock(statesCode);

    statesDemo.add(disabledInput, readonlyInput, requiredInput, pillInput, statesCode);
    statesExample.add(statesDemo);

    // Prefix and suffix section
    FlexLayout prefixSuffixExample = createSection(
      "Prefix & Suffix",
      "Add icons or text before and after the input."
    );

    FlexLayout prefixSuffixDemo = new FlexLayout();
    prefixSuffixDemo.setDirection(FlexDirection.COLUMN);
    prefixSuffixDemo.setSpacing("15px");

    // Email with prefix icon
    Input emailPrefixInput = new Input("Email");
    emailPrefixInput.setType(Input.Type.EMAIL);
    emailPrefixInput.setPlaceholder("user@example.com");
    
    Div emailPrefix = new Div();
    emailPrefix.setAttribute("slot", "prefix");
    emailPrefix.add(Icon.bootstrap("envelope"));
    emailPrefixInput.add(emailPrefix);

    // Price with prefix and suffix
    Input priceInput = new Input("Price");
    priceInput.setType(Input.Type.NUMBER);
    priceInput.setPlaceholder("0.00");
    priceInput.setStep("0.01");
    
    Div dollarPrefix = new Div();
    dollarPrefix.setAttribute("slot", "prefix");
    dollarPrefix.setText("$");
    
    Div usdSuffix = new Div();
    usdSuffix.setAttribute("slot", "suffix");
    usdSuffix.setText("USD");
    
    priceInput.add(dollarPrefix, usdSuffix);

    Div prefixSuffixCode = new Div();
    prefixSuffixCode.setText(
      "// Add prefix icon\n" +
      "Div prefix = new Div();\n" +
      "prefix.setAttribute(\"slot\", \"prefix\");\n" +
      "prefix.add(Icon.bootstrap(\"envelope\"));\n" +
      "input.add(prefix);\n\n" +
      "// Add prefix and suffix text\n" +
      "Div dollarPrefix = new Div();\n" +
      "dollarPrefix.setAttribute(\"slot\", \"prefix\");\n" +
      "dollarPrefix.setText(\"$\");\n\n" +
      "Div suffix = new Div();\n" +
      "suffix.setAttribute(\"slot\", \"suffix\");\n" +
      "suffix.setText(\"USD\");\n\n" +
      "input.add(dollarPrefix, suffix);"
    );
    styleCodeBlock(prefixSuffixCode);

    prefixSuffixDemo.add(emailPrefixInput, priceInput, prefixSuffixCode);
    prefixSuffixExample.add(prefixSuffixDemo);

    // Help text section
    FlexLayout helpTextExample = createSection(
      "Help Text",
      "Provide additional context with help text."
    );

    FlexLayout helpTextDemo = new FlexLayout();
    helpTextDemo.setDirection(FlexDirection.COLUMN);
    helpTextDemo.setSpacing("15px");

    Input helpInput = new Input("Username");
    helpInput.setPlaceholder("Choose a username");
    helpInput.setHelpText("Your username must be unique and contain only letters and numbers");
    helpInput.setPattern("[a-zA-Z0-9]+");

    Div helpCode = new Div();
    helpCode.setText(
      "// Add help text\n" +
      "input.setHelpText(\"Your username must be unique and contain only letters and numbers\");\n" +
      "input.setPattern(\"[a-zA-Z0-9]+\");"
    );
    styleCodeBlock(helpCode);

    helpTextDemo.add(helpInput, helpCode);
    helpTextExample.add(helpTextDemo);

    // Event Handling section
    FlexLayout eventsSection = createSection(
      "Event Handling",
      "Input components support various events for responding to user interaction. " +
      "The input event fires continuously as you type, while change fires when you finish editing."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("30px");

    // Interactive event demo
    FlexLayout eventInputContainer = new FlexLayout();
    eventInputContainer.setDirection(FlexDirection.COLUMN);
    eventInputContainer.setAlignment(FlexAlignment.CENTER);
    eventInputContainer.setSpacing("20px");

    Input eventInput = new Input("Interactive Input");
    eventInput.setPlaceholder("Type here to see events fire!");
    eventInput.setHelpText("Try typing, clearing, focusing, and blurring");
    eventInput.setClearable(true);
    eventInput.setSize(Input.Size.LARGE);

    // Character count display
    Label charCount = new Label("Characters: 0");
    charCount.setStyle("font-size", "14px")
             .setStyle("color", "#6b7280");

    // Event status display
    Div eventStatus = new Div();
    eventStatus.setText("Interact with the input above to see events!");
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
    eventInput.onInput(event -> {
      String value = event.getValue();
      charCount.setText("Characters: " + value.length());
      eventStatus.setText(String.format("Input event: Current value = \"%s\"", value));
      eventStatus.setStyle("background", "#e1f5fe");
    });

    eventInput.onChange(event -> {
      String value = event.getValue();
      eventStatus.setText(String.format("Change event: Final value = \"%s\"", value));
      eventStatus.setStyle("background", "#c8e6c9");
      if (!value.isEmpty()) {
        Toast.show("Input saved: " + value);
      }
    });

    eventInput.onFocus(event -> {
      eventStatus.setText("Focus event: Input is now focused");
      eventStatus.setStyle("background", "#fff3cd");
    });

    eventInput.onBlur(event -> {
      eventStatus.setText("Blur event: Input lost focus");
      eventStatus.setStyle("background", "#f8f9fa");
    });

    eventInput.onClear(event -> {
      eventStatus.setText("Clear event: Input was cleared!");
      eventStatus.setStyle("background", "#ffccbc");
      charCount.setText("Characters: 0");
      Toast.show("Input cleared");
    });

    // Validation demo
    Input validationInput = new Input("Email (with validation)");
    validationInput.setType(Input.Type.EMAIL);
    validationInput.setPlaceholder("Enter a valid email");
    validationInput.setRequired(true);
    validationInput.setHelpText("Try submitting an invalid email");

    validationInput.onInvalid(event -> {
      eventStatus.setText("Invalid event: Please enter a valid email address!");
      eventStatus.setStyle("background", "#ffebee");
    });

    eventInputContainer.add(eventInput, charCount, eventStatus, validationInput);

    // Event code examples
    Div eventCode = new Div();
    eventCode.setText(
      "// Input event - fires continuously as user types\n" +
      "input.onInput(event -> {\n" +
      "    String currentValue = event.getValue();\n" +
      "    updateCharacterCount(currentValue.length());\n" +
      "});\n\n" +
      "// Change event - fires when input loses focus\n" +
      "input.onChange(event -> {\n" +
      "    String finalValue = event.getValue();\n" +
      "    saveData(finalValue);\n" +
      "});\n\n" +
      "// Clear event - fires when clear button clicked\n" +
      "input.onClear(event -> {\n" +
      "    resetForm();\n" +
      "});\n\n" +
      "// Focus/blur events\n" +
      "input.onFocus(event -> highlightInput());\n" +
      "input.onBlur(event -> validateInput());\n\n" +
      "// Validation event\n" +
      "input.onInvalid(event -> {\n" +
      "    showValidationError();\n" +
      "});\n\n" +
      "// Remove listener when needed\n" +
      "ListenerRegistration<Input.InputEvent> reg = input.onInput(handler);\n" +
      "reg.remove();"
    );
    styleCodeBlock(eventCode);

    eventsDemo.add(eventInputContainer, eventCode);
    eventsSection.add(eventsDemo);

    // Validation section
    FlexLayout validationExample = createSection(
      "Validation",
      "Built-in validation for common patterns."
    );

    FlexLayout validationDemo = new FlexLayout();
    validationDemo.setDirection(FlexDirection.COLUMN);
    validationDemo.setSpacing("15px");

    // Pattern validation
    Input patternInput = new Input("Phone Number");
    patternInput.setType(Input.Type.TEL);
    patternInput.setPlaceholder("(123) 456-7890");
    patternInput.setPattern("\\(\\d{3}\\) \\d{3}-\\d{4}");
    patternInput.setHelpText("Format: (123) 456-7890");

    // Length validation
    Input lengthInput = new Input("Username");
    lengthInput.setPlaceholder("4-12 characters");
    lengthInput.setMinLength(4);
    lengthInput.setMaxLength(12);
    lengthInput.setHelpText("Must be between 4 and 12 characters");

    // Number range validation
    Input rangeInput = new Input("Quantity", Input.Type.NUMBER);
    rangeInput.setMin("1");
    rangeInput.setMax("100");
    rangeInput.setStep("1");
    rangeInput.setValue("1");
    rangeInput.setHelpText("Enter a quantity between 1 and 100");

    Div validationCode = new Div();
    validationCode.setText(
      "// Pattern validation\n" +
      "input.setPattern(\"\\\\(\\\\d{3}\\\\) \\\\d{3}-\\\\d{4}\");\n\n" +
      "// Length validation\n" +
      "input.setMinLength(4);\n" +
      "input.setMaxLength(12);\n\n" +
      "// Number range\n" +
      "input.setType(Input.Type.NUMBER);\n" +
      "input.setMin(\"1\");\n" +
      "input.setMax(\"100\");\n" +
      "input.setStep(\"1\");"
    );
    styleCodeBlock(validationCode);

    validationDemo.add(patternInput, lengthInput, rangeInput, validationCode);
    validationExample.add(validationDemo);

    // Properties table section
    FlexLayout propertiesSection = createSection(
      "Properties Table",
      "The Input component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events table section
    FlexLayout eventsTableSection = createSection(
      "Events Table",
      "The Input component supports the following events:"
    );

    FlexLayout eventsTable = createEventsTable();
    eventsTableSection.add(eventsTable);

    // Add all sections to main layout
    self.add(
      header,
      basicExample,
      typesExample,
      sizesExample,
      statesExample,
      prefixSuffixExample,
      helpTextExample,
      eventsSection,
      validationExample,
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
      {"type", "Input type", "Type", "TEXT"},
      {"name", "Form field name", "String", "\"\""},
      {"value", "Input value", "String", "\"\""},
      {"label", "Input label", "String", "\"\""},
      {"placeholder", "Placeholder text", "String", "\"\""},
      {"help-text", "Help text", "String", "\"\""},
      {"size", "Input size", "Size", "MEDIUM"},
      {"disabled", "Disabled state", "boolean", "false"},
      {"readonly", "Readonly state", "boolean", "false"},
      {"required", "Required field", "boolean", "false"},
      {"clearable", "Show clear button", "boolean", "false"},
      {"pill", "Pill shape", "boolean", "false"},
      {"password-toggle", "Password visibility", "boolean", "false"},
      {"pattern", "Validation pattern", "String", "\"\""},
      {"minLength", "Min characters", "Integer", "null"},
      {"maxLength", "Max characters", "Integer", "null"},
      {"min", "Min value (number/date)", "String", "\"\""},
      {"max", "Max value (number/date)", "String", "\"\""},
      {"step", "Step value (number)", "String", "\"\""}
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
    FlexLayout inputRow = createTableRow(false);
    inputRow.add(
      createTableCell("onInput", false),
      createTableCell("Fired continuously as user types", false),
      createTableCell("value", false)
    );

    FlexLayout changeRow = createTableRow(false);
    changeRow.add(
      createTableCell("onChange", false),
      createTableCell("Fired when value changes and input loses focus", false),
      createTableCell("value", false)
    );

    FlexLayout clearRow = createTableRow(false);
    clearRow.add(
      createTableCell("onClear", false),
      createTableCell("Fired when clear button is clicked", false),
      createTableCell("-", false)
    );

    FlexLayout focusRow = createTableRow(false);
    focusRow.add(
      createTableCell("onFocus", false),
      createTableCell("Fired when input gains focus", false),
      createTableCell("-", false)
    );

    FlexLayout blurRow = createTableRow(false);
    blurRow.add(
      createTableCell("onBlur", false),
      createTableCell("Fired when input loses focus", false),
      createTableCell("-", false)
    );

    FlexLayout invalidRow = createTableRow(false);
    invalidRow.add(
      createTableCell("onInvalid", false),
      createTableCell("Fired when form validation fails", false),
      createTableCell("-", false)
    );

    table.add(headerRow, inputRow, changeRow, clearRow, focusRow, blurRow, invalidRow);
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