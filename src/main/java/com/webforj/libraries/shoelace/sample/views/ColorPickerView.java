package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.ColorPicker;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.text.Label;
import com.webforj.component.toast.Toast;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/color-picker", outlet = MainLayout.class)
@FrameTitle("Color Picker")
public class ColorPickerView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public ColorPickerView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Color Picker");
    Paragraph description = new Paragraph(
      "Color pickers allow the user to select a color using a visual interface. " +
      "They support multiple formats, inline display, opacity, and custom swatches."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.ColorPicker;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "4px 8px")
               .setStyle("border-radius", "4px")
               .setStyle("font-size", "14px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/ColorPicker.html",
      "https://shoelace.style/components/color-picker"
    );

    header.add(title, description, componentTag, docsLinks);

    // Basic Example section
    FlexLayout basicExample = createSection(
      "Basic Example",
      "Click the color swatch to open the picker. The picker supports various color formats."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setSpacing("20px");
    basicDemo.setAlignment(FlexAlignment.CENTER);

    ColorPicker basicPicker = new ColorPicker("#0969da");
    basicPicker.setLabel("Choose a color");

    Div basicCode = new Div();
    basicCode.setText(
      "// Simple color picker\n" +
      "ColorPicker picker = new ColorPicker(\"#0969da\");\n" +
      "picker.setLabel(\"Choose a color\");\n\n" +
      "// Get the selected color\n" +
      "String color = picker.getValue();\n\n" +
      "// Set a new color\n" +
      "picker.setValue(\"#ff0000\");"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicPicker);
    basicExample.add(basicDemo, basicCode);

    // Formats section
    FlexLayout formatsExample = createSection(
      "Color Formats",
      "Color pickers support hex, RGB, HSL, and HSV formats. Use the format toggle or set it programmatically."
    );

    FlexLayout formatsDemo = new FlexLayout();
    formatsDemo.setDirection(FlexDirection.COLUMN);
    formatsDemo.setSpacing("20px");

    FlexLayout formatPickers = new FlexLayout();
    formatPickers.setSpacing("20px");
    formatPickers.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    // HEX format
    ColorPicker hexPicker = new ColorPicker("#ff6b6b");
    hexPicker.setFormat(ColorPicker.Format.HEX);
    hexPicker.setLabel("HEX Format");

    // RGB format
    ColorPicker rgbPicker = new ColorPicker("rgb(54, 162, 235)");
    rgbPicker.setFormat(ColorPicker.Format.RGB);
    rgbPicker.setLabel("RGB Format");

    // HSL format
    ColorPicker hslPicker = new ColorPicker("hsl(259, 71%, 58%)");
    hslPicker.setFormat(ColorPicker.Format.HSL);
    hslPicker.setLabel("HSL Format");

    formatPickers.add(hexPicker, rgbPicker, hslPicker);

    Div formatsCode = new Div();
    formatsCode.setText(
      "// Set format to HEX\n" +
      "picker.setFormat(ColorPicker.Format.HEX);\n\n" +
      "// Set format to RGB\n" +
      "picker.setFormat(ColorPicker.Format.RGB);\n\n" +
      "// Set format to HSL\n" +
      "picker.setFormat(ColorPicker.Format.HSL);\n\n" +
      "// Set format to HSV\n" +
      "picker.setFormat(ColorPicker.Format.HSV);"
    );
    styleCodeBlock(formatsCode);

    formatsDemo.add(formatPickers, formatsCode);
    formatsExample.add(formatsDemo);

    // Inline picker section
    FlexLayout inlineExample = createSection(
      "Inline Color Picker",
      "Display the color picker inline instead of in a dropdown."
    );

    FlexLayout inlineDemo = new FlexLayout();
    inlineDemo.setDirection(FlexDirection.COLUMN);
    inlineDemo.setSpacing("20px");
    inlineDemo.setAlignment(FlexAlignment.CENTER);

    ColorPicker inlinePicker = new ColorPicker("#10b981");
    inlinePicker.setInline(true);

    Div inlineCode = new Div();
    inlineCode.setText(
      "ColorPicker picker = new ColorPicker(\"#10b981\");\n" +
      "picker.setInline(true);"
    );
    styleCodeBlock(inlineCode);

    inlineDemo.add(inlinePicker, inlineCode);
    inlineExample.add(inlineDemo);

    // Opacity section
    FlexLayout opacityExample = createSection(
      "Opacity Support",
      "Enable the opacity slider to allow alpha channel selection."
    );

    FlexLayout opacityDemo = new FlexLayout();
    opacityDemo.setDirection(FlexDirection.COLUMN);
    opacityDemo.setSpacing("20px");

    ColorPicker opacityPicker = new ColorPicker("rgba(59, 130, 246, 0.5)");
    opacityPicker.setOpacity(0.5);
    opacityPicker.setFormat(ColorPicker.Format.RGB);
    opacityPicker.setLabel("Color with opacity");

    Div opacityCode = new Div();
    opacityCode.setText(
      "// Enable opacity with initial value\n" +
      "ColorPicker picker = new ColorPicker(\"rgba(59, 130, 246, 0.5)\");\n" +
      "picker.setOpacity(0.5);\n" +
      "picker.setFormat(ColorPicker.Format.RGB);\n\n" +
      "// Opacity works with all formats\n" +
      "// HEX: #3b82f680\n" +
      "// RGB: rgba(59, 130, 246, 0.5)\n" +
      "// HSL: hsla(217, 91%, 60%, 0.5)"
    );
    styleCodeBlock(opacityCode);

    opacityDemo.add(opacityPicker, opacityCode);
    opacityExample.add(opacityDemo);

    // Swatches section
    FlexLayout swatchesExample = createSection(
      "Color Swatches",
      "Provide predefined color options for quick selection."
    );

    FlexLayout swatchesDemo = new FlexLayout();
    swatchesDemo.setDirection(FlexDirection.COLUMN);
    swatchesDemo.setSpacing("20px");

    ColorPicker swatchesPicker = new ColorPicker("#6366f1");
    String[] brandColors = {
      "#ef4444", "#f97316", "#f59e0b", "#10b981",
      "#3b82f6", "#6366f1", "#8b5cf6", "#ec4899"
    };
    swatchesPicker.setSwatches(brandColors);
    swatchesPicker.setLabel("Choose a brand color");

    Div swatchesCode = new Div();
    swatchesCode.setText(
      "// Set custom swatches\n" +
      "String[] colors = {\n" +
      "  \"#ef4444\", \"#f97316\", \"#f59e0b\", \"#10b981\",\n" +
      "  \"#3b82f6\", \"#6366f1\", \"#8b5cf6\", \"#ec4899\"\n" +
      "};\n" +
      "picker.setSwatches(colors);\n\n" +
      "// Or use a semicolon-delimited string\n" +
      "picker.setSwatches(\"#ff0000;#00ff00;#0000ff\");"
    );
    styleCodeBlock(swatchesCode);

    swatchesDemo.add(swatchesPicker, swatchesCode);
    swatchesExample.add(swatchesDemo);

    // Sizes section
    FlexLayout sizesExample = createSection(
      "Sizes",
      "Color pickers come in small, medium, and large sizes."
    );

    FlexLayout sizesDemo = new FlexLayout();
    sizesDemo.setSpacing("20px");
    sizesDemo.setAlignment(FlexAlignment.CENTER);

    ColorPicker smallPicker = new ColorPicker("#10b981");
    smallPicker.setSize(ColorPicker.Size.SMALL);
    smallPicker.setLabel("Small");

    ColorPicker mediumPicker = new ColorPicker("#3b82f6");
    mediumPicker.setSize(ColorPicker.Size.MEDIUM);
    mediumPicker.setLabel("Medium");

    ColorPicker largePicker = new ColorPicker("#8b5cf6");
    largePicker.setSize(ColorPicker.Size.LARGE);
    largePicker.setLabel("Large");

    Div sizesCode = new Div();
    sizesCode.setText(
      "picker.setSize(ColorPicker.Size.SMALL);\n" +
      "picker.setSize(ColorPicker.Size.MEDIUM);\n" +
      "picker.setSize(ColorPicker.Size.LARGE);"
    );
    styleCodeBlock(sizesCode);

    sizesDemo.add(smallPicker, mediumPicker, largePicker, sizesCode);
    sizesExample.add(sizesDemo);

    // Event Handling section
    FlexLayout eventsSection = createSection(
      "Event Handling",
      "Color picker components support various events for responding to color selection. " +
      "The input event fires continuously during interaction, while change fires when selection is complete."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("30px");

    // Interactive event demo
    FlexLayout eventPickerContainer = new FlexLayout();
    eventPickerContainer.setDirection(FlexDirection.COLUMN);
    eventPickerContainer.setAlignment(FlexAlignment.CENTER);
    eventPickerContainer.setSpacing("20px");

    ColorPicker eventPicker = new ColorPicker("#3b82f6");
    eventPicker.setLabel("Interactive color picker - try selecting colors!");
    eventPicker.setSize(ColorPicker.Size.LARGE);
    eventPicker.setSwatches(new String[]{
      "#ef4444", "#10b981", "#3b82f6", "#8b5cf6", "#f59e0b", "#000000"
    });

    // Color preview box
    Div colorPreview = new Div();
    colorPreview.setStyle("width", "200px")
                .setStyle("height", "100px")
                .setStyle("background", "#3b82f6")
                .setStyle("border-radius", "8px")
                .setStyle("border", "2px solid #e5e7eb")
                .setStyle("transition", "background-color 0.2s");

    // Event status display
    Div eventStatus = new Div();
    eventStatus.setText("Interact with the color picker to see events!");
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
    eventPicker.onInput(event -> {
      String color = event.getValue();
      colorPreview.setStyle("background", color);
      eventStatus.setText(String.format("Input event: Color changing to %s", color));
      eventStatus.setStyle("background", "#e1f5fe");
    });

    eventPicker.onChange(event -> {
      String color = event.getValue();
      String formatted = event.getFormattedValue();
      eventStatus.setText(String.format("Change event: Selected %s (formatted: %s)", color, formatted));
      eventStatus.setStyle("background", "#c8e6c9");
      Toast.show("Color selected: " + color);
    });

    eventPicker.onFocus(event -> {
      eventStatus.setText("Focus event: Color picker opened");
      eventStatus.setStyle("background", "#fff3cd");
    });

    eventPicker.onBlur(event -> {
      eventStatus.setText("Blur event: Color picker closed");
      eventStatus.setStyle("background", "#f8f9fa");
    });

    // Format switcher to demonstrate real-time updates
    com.webforj.component.list.ChoiceBox formatSwitcher = new com.webforj.component.list.ChoiceBox();
    formatSwitcher.setLabel("Switch format to see value changes");
    formatSwitcher.add("hex", "HEX");
    formatSwitcher.add("rgb", "RGB");
    formatSwitcher.add("hsl", "HSL");
    formatSwitcher.selectKey("hex");
    
    formatSwitcher.onSelect(e -> {
      String format = (String) formatSwitcher.getSelectedKey();
      eventPicker.setFormat(format);
      eventStatus.setText("Format changed to " + format.toUpperCase());
      eventStatus.setStyle("background", "#e8eaf6");
    });

    eventPickerContainer.add(eventPicker, colorPreview, formatSwitcher, eventStatus);

    // Event code examples
    Div eventCode = new Div();
    eventCode.setText(
      "// Input event - fires continuously during color selection\n" +
      "colorPicker.onInput(event -> {\n" +
      "    String currentColor = event.getValue();\n" +
      "    updatePreview(currentColor);\n" +
      "});\n\n" +
      "// Change event - fires when selection is complete\n" +
      "colorPicker.onChange(event -> {\n" +
      "    String finalColor = event.getValue();\n" +
      "    String formatted = event.getFormattedValue();\n" +
      "    saveColor(finalColor);\n" +
      "});\n\n" +
      "// Focus/blur events\n" +
      "colorPicker.onFocus(event -> showColorHints());\n" +
      "colorPicker.onBlur(event -> hideColorHints());\n\n" +
      "// Validation event\n" +
      "colorPicker.onInvalid(event -> {\n" +
      "    showError(\"Please select a valid color\");\n" +
      "});\n\n" +
      "// Remove listener when needed\n" +
      "ListenerRegistration<ColorPicker.ChangeEvent> reg = colorPicker.onChange(handler);\n" +
      "reg.remove();"
    );
    styleCodeBlock(eventCode);

    eventsDemo.add(eventPickerContainer, eventCode);
    eventsSection.add(eventsDemo);

    // Interactive example
    FlexLayout interactiveExample = createSection(
      "Interactive Example",
      "Customize the color picker properties."
    );

    FlexLayout interactiveDemo = new FlexLayout();
    interactiveDemo.setDirection(FlexDirection.COLUMN);
    interactiveDemo.setSpacing("20px");

    // Controls
    FlexLayout controls = new FlexLayout();
    controls.setDirection(FlexDirection.COLUMN);
    controls.setSpacing("15px");

    com.webforj.component.list.ChoiceBox formatChoice = new com.webforj.component.list.ChoiceBox();
    formatChoice.setLabel("Format");
    formatChoice.add("hex", "HEX");
    formatChoice.add("rgb", "RGB");
    formatChoice.add("hsl", "HSL");
    formatChoice.add("hsv", "HSV");
    formatChoice.selectKey("hex");

    com.webforj.component.list.ChoiceBox sizeChoice = new com.webforj.component.list.ChoiceBox();
    sizeChoice.setLabel("Size");
    sizeChoice.add("small", "Small");
    sizeChoice.add("medium", "Medium");
    sizeChoice.add("large", "Large");
    sizeChoice.selectKey("medium");

    CheckBox inlineCheck = new CheckBox("Inline");
    CheckBox opacityCheck = new CheckBox("Enable Opacity");
    CheckBox noFormatCheck = new CheckBox("Hide Format Toggle");
    CheckBox uppercaseCheck = new CheckBox("Uppercase HEX");
    CheckBox disabledCheck = new CheckBox("Disabled");

    controls.add(formatChoice, sizeChoice, inlineCheck, opacityCheck,
                 noFormatCheck, uppercaseCheck, disabledCheck);

    // Preview picker
    ColorPicker previewPicker = new ColorPicker("#6366f1");

    FlexLayout previewContainer = new FlexLayout();
    previewContainer.setAlignment(FlexAlignment.CENTER);
    previewContainer.setJustifyContent(com.webforj.component.layout.flexlayout.FlexJustifyContent.CENTER);
    previewContainer.setStyle("min-height", "300px");
    previewContainer.setStyle("border", "1px dashed #dee2e6");
    previewContainer.setStyle("border-radius", "8px");
    previewContainer.add(previewPicker);

    // Event handlers
    formatChoice.onSelect(e -> {
      String format = (String) formatChoice.getSelectedKey();
      previewPicker.setFormat(format);
    });

    sizeChoice.onSelect(e -> {
      String size = (String) sizeChoice.getSelectedKey();
      previewPicker.setSize(size);
    });

    inlineCheck.addValueChangeListener(e ->
      previewPicker.setInline(inlineCheck.isChecked())
    );

    opacityCheck.addValueChangeListener(e -> {
      if (opacityCheck.isChecked()) {
        previewPicker.setOpacity(1.0);
      } else {
        previewPicker.setOpacity(null);
      }
    });

    noFormatCheck.addValueChangeListener(e ->
      previewPicker.setNoFormatToggle(noFormatCheck.isChecked())
    );

    uppercaseCheck.addValueChangeListener(e ->
      previewPicker.setUppercase(uppercaseCheck.isChecked())
    );

    disabledCheck.addValueChangeListener(e ->
      previewPicker.setDisabled(disabledCheck.isChecked())
    );

    interactiveDemo.add(controls, previewContainer);
    interactiveExample.add(interactiveDemo);

    // Properties table section
    FlexLayout propertiesSection = createSection(
      "Properties Table",
      "The ColorPicker component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events table section
    FlexLayout eventsTableSection = createSection(
      "Events Table",
      "The ColorPicker component supports the following events:"
    );

    FlexLayout eventsTable = createEventsTable();
    eventsTableSection.add(eventsTable);

    // Add all sections to main layout
    self.add(
      header,
      basicExample,
      formatsExample,
      inlineExample,
      opacityExample,
      swatchesExample,
      sizesExample,
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
      {"value", "The current color value", "String", "\"#ffffff\""},
      {"label", "Accessible label", "String", "\"Select a color\""},
      {"format", "Color format", "String", "\"hex\""},
      {"inline", "Display inline", "boolean", "false"},
      {"size", "Size of the picker", "String", "\"medium\""},
      {"no-format-toggle", "Hide format toggle", "boolean", "false"},
      {"disabled", "Disable the picker", "boolean", "false"},
      {"hoist", "Hoist the dropdown", "boolean", "false"},
      {"opacity", "Enable opacity slider", "Double", "null"},
      {"uppercase", "Uppercase hex values", "boolean", "false"},
      {"swatches", "Predefined colors", "String/String[]", "\"\""}
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
      createTableCell("Fired continuously during color selection", false),
      createTableCell("value, formattedValue", false)
    );

    FlexLayout changeRow = createTableRow(false);
    changeRow.add(
      createTableCell("onChange", false),
      createTableCell("Fired when color selection is complete", false),
      createTableCell("value, formattedValue", false)
    );

    FlexLayout focusRow = createTableRow(false);
    focusRow.add(
      createTableCell("onFocus", false),
      createTableCell("Fired when color picker gains focus", false),
      createTableCell("-", false)
    );

    FlexLayout blurRow = createTableRow(false);
    blurRow.add(
      createTableCell("onBlur", false),
      createTableCell("Fired when color picker loses focus", false),
      createTableCell("-", false)
    );

    FlexLayout invalidRow = createTableRow(false);
    invalidRow.add(
      createTableCell("onInvalid", false),
      createTableCell("Fired when form validation fails", false),
      createTableCell("-", false)
    );

    table.add(headerRow, inputRow, changeRow, focusRow, blurRow, invalidRow);
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