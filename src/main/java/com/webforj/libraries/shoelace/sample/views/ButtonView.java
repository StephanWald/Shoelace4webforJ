package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.ButtonGroup;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.*;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.toast.Toast;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/button", outlet = MainLayout.class)
@FrameTitle("Button")
public class ButtonView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public ButtonView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Button");
    Paragraph description = new Paragraph(
      "Buttons represent actions that are available to the user. They come in various " +
      "styles and sizes, and can include icons and loading states."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.ShoelaceButton;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "4px 8px")
               .setStyle("border-radius", "4px")
               .setStyle("font-size", "14px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/ShoelaceButton.html",
      "https://shoelace.style/components/button"
    );

    header.add(title, description, componentTag, docsLinks);

    // Basic Example section
    FlexLayout basicExample = createSection(
      "Basic Example",
      "Create a simple button with text content. The button uses the default variant and size."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setSpacing("20px");
    basicDemo.setAlignment(FlexAlignment.CENTER);

    ShoelaceButton basicBtn = new ShoelaceButton("Click Me");

    Div basicCode = new Div();
    basicCode.setText(
      "// Simple button\n" +
      "ShoelaceButton button = new ShoelaceButton(\"Click Me\");\n\n" +
      "// Or with variant\n" +
      "ShoelaceButton button = new ShoelaceButton(\"Primary\", ShoelaceButton.Variant.PRIMARY);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicBtn);
    basicExample.add(basicDemo, basicCode);

    // Variants section
    FlexLayout variantsExample = createSection(
      "Button Variants",
      "Use the variant attribute to set the button's semantic variant."
    );

    FlexLayout variantsDemo = new FlexLayout();
    variantsDemo.setDirection(FlexDirection.COLUMN);
    variantsDemo.setSpacing("20px");

    FlexLayout variantButtons = new FlexLayout();
    variantButtons.setSpacing("10px");
    variantButtons.setWrap(FlexWrap.WRAP);

    ShoelaceButton defaultBtn = new ShoelaceButton("Default", ShoelaceButton.Variant.DEFAULT);
    ShoelaceButton primaryBtn = new ShoelaceButton("Primary", ShoelaceButton.Variant.PRIMARY);
    ShoelaceButton successBtn = new ShoelaceButton("Success", ShoelaceButton.Variant.SUCCESS);
    ShoelaceButton neutralBtn = new ShoelaceButton("Neutral", ShoelaceButton.Variant.NEUTRAL);
    ShoelaceButton warningBtn = new ShoelaceButton("Warning", ShoelaceButton.Variant.WARNING);
    ShoelaceButton dangerBtn = new ShoelaceButton("Danger", ShoelaceButton.Variant.DANGER);
    ShoelaceButton textBtn = new ShoelaceButton("Text", ShoelaceButton.Variant.TEXT);

    variantButtons.add(defaultBtn, primaryBtn, successBtn, neutralBtn, warningBtn, dangerBtn, textBtn);

    Div variantsCode = new Div();
    variantsCode.setText(
      "// Create buttons with different variants\n" +
      "ShoelaceButton primary = new ShoelaceButton(\"Primary\", ShoelaceButton.Variant.PRIMARY);\n" +
      "ShoelaceButton success = new ShoelaceButton(\"Success\", ShoelaceButton.Variant.SUCCESS);\n" +
      "ShoelaceButton danger = new ShoelaceButton(\"Danger\", ShoelaceButton.Variant.DANGER);\n\n" +
      "// Or set variant after creation\n" +
      "button.setVariant(ShoelaceButton.Variant.WARNING);"
    );
    styleCodeBlock(variantsCode);

    variantsDemo.add(variantButtons, variantsCode);
    variantsExample.add(variantsDemo);

    // Outline buttons section
    FlexLayout outlineExample = createSection(
      "Outline Buttons",
      "Use the outline attribute to draw outlined buttons with transparent backgrounds."
    );

    FlexLayout outlineDemo = new FlexLayout();
    outlineDemo.setDirection(FlexDirection.COLUMN);
    outlineDemo.setSpacing("20px");

    FlexLayout outlineButtons = new FlexLayout();
    outlineButtons.setSpacing("10px");
    outlineButtons.setWrap(FlexWrap.WRAP);

    ShoelaceButton outlineDefault = new ShoelaceButton("Default");
    outlineDefault.setOutline(true);

    ShoelaceButton outlinePrimary = new ShoelaceButton("Primary");
    outlinePrimary.setVariant(ShoelaceButton.Variant.PRIMARY).setOutline(true);

    ShoelaceButton outlineSuccess = new ShoelaceButton("Success");
    outlineSuccess.setVariant(ShoelaceButton.Variant.SUCCESS).setOutline(true);

    ShoelaceButton outlineNeutral = new ShoelaceButton("Neutral");
    outlineNeutral.setVariant(ShoelaceButton.Variant.NEUTRAL).setOutline(true);

    ShoelaceButton outlineWarning = new ShoelaceButton("Warning");
    outlineWarning.setVariant(ShoelaceButton.Variant.WARNING).setOutline(true);

    ShoelaceButton outlineDanger = new ShoelaceButton("Danger");
    outlineDanger.setVariant(ShoelaceButton.Variant.DANGER).setOutline(true);

    outlineButtons.add(outlineDefault, outlinePrimary, outlineSuccess, outlineNeutral, outlineWarning, outlineDanger);

    Div outlineCode = new Div();
    outlineCode.setText(
      "ShoelaceButton button = new ShoelaceButton(\"Outline\");\n" +
      "button.setVariant(ShoelaceButton.Variant.PRIMARY);\n" +
      "button.setOutline(true);"
    );
    styleCodeBlock(outlineCode);

    outlineDemo.add(outlineButtons, outlineCode);
    outlineExample.add(outlineDemo);

    // Sizes section
    FlexLayout sizesExample = createSection(
      "Sizes",
      "Use the size attribute to change a button's size."
    );

    FlexLayout sizesDemo = new FlexLayout();
    sizesDemo.setDirection(FlexDirection.COLUMN);
    sizesDemo.setSpacing("20px");

    FlexLayout sizeButtons = new FlexLayout();
    sizeButtons.setSpacing("10px");
    sizeButtons.setAlignment(FlexAlignment.CENTER);

    ShoelaceButton smallBtn = new ShoelaceButton("Small");
    smallBtn.setSize(ShoelaceButton.Size.SMALL);

    ShoelaceButton mediumBtn = new ShoelaceButton("Medium");
    mediumBtn.setSize(ShoelaceButton.Size.MEDIUM);

    ShoelaceButton largeBtn = new ShoelaceButton("Large");
    largeBtn.setSize(ShoelaceButton.Size.LARGE);

    sizeButtons.add(smallBtn, mediumBtn, largeBtn);

    Div sizesCode = new Div();
    sizesCode.setText(
      "button.setSize(ShoelaceButton.Size.SMALL);\n" +
      "button.setSize(ShoelaceButton.Size.MEDIUM);\n" +
      "button.setSize(ShoelaceButton.Size.LARGE);"
    );
    styleCodeBlock(sizesCode);

    sizesDemo.add(sizeButtons, sizesCode);
    sizesExample.add(sizesDemo);

    // Icons and shapes section
    FlexLayout iconsExample = createSection(
      "Icons and Shapes",
      "Buttons can have icons, be pill-shaped, or circular."
    );

    FlexLayout iconsDemo = new FlexLayout();
    iconsDemo.setDirection(FlexDirection.COLUMN);
    iconsDemo.setSpacing("20px");

    FlexLayout iconButtons = new FlexLayout();
    iconButtons.setSpacing("10px");
    iconButtons.setWrap(FlexWrap.WRAP);

    // Icon prefix button
    ShoelaceButton iconPrefixBtn = new ShoelaceButton("Settings");
    iconPrefixBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    iconPrefixBtn.setPrefix(TablerIcon.create("settings"));

    // Icon suffix button
    ShoelaceButton iconSuffixBtn = new ShoelaceButton("Refresh");
    iconSuffixBtn.setSuffix(TablerIcon.create("refresh"));

    // Icon only circular button
    ShoelaceButton circleBtn = new ShoelaceButton();
    circleBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    circleBtn.setCircle(true);
    circleBtn.setHtml("<sl-icon name=\"plus\"></sl-icon>");

    // Pill button
    ShoelaceButton pillBtn = new ShoelaceButton("Pill Button");
    pillBtn.setVariant(ShoelaceButton.Variant.SUCCESS);
    pillBtn.setPill(true);

    // Caret button
    ShoelaceButton caretBtn = new ShoelaceButton("Dropdown");
    caretBtn.setCaret(true);

    iconButtons.add(iconPrefixBtn, iconSuffixBtn, circleBtn, pillBtn, caretBtn);

    Div iconsCode = new Div();
    iconsCode.setText(
      "// Button with icon prefix\n" +
      "button.setPrefix(TablerIcon.create(\"settings\"));\n\n" +
      "// Circular icon button\n" +
      "button.setCircle(true);\n" +
      "button.add(TablerIcon.create(\"plus\"));\n\n" +
      "// Pill-shaped button\n" +
      "button.setPill(true);\n\n" +
      "// Button with caret\n" +
      "button.setCaret(true);"
    );
    styleCodeBlock(iconsCode);

    iconsDemo.add(iconButtons, iconsCode);
    iconsExample.add(iconsDemo);

    // Loading and disabled states section
    FlexLayout statesExample = createSection(
      "States",
      "Buttons can be disabled or show a loading spinner."
    );

    FlexLayout statesDemo = new FlexLayout();
    statesDemo.setDirection(FlexDirection.COLUMN);
    statesDemo.setSpacing("20px");

    FlexLayout stateButtons = new FlexLayout();
    stateButtons.setSpacing("10px");
    stateButtons.setWrap(FlexWrap.WRAP);

    // Loading button
    ShoelaceButton loadingBtn = new ShoelaceButton("Loading");
    loadingBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    loadingBtn.setLoading(true);

    // Disabled button
    ShoelaceButton disabledBtn = new ShoelaceButton("Disabled");
    disabledBtn.setDisabled(true);

    // Click to load button demo
    ShoelaceButton clickLoadBtn = new ShoelaceButton("Click to Load (Demo)");
    clickLoadBtn.setVariant(ShoelaceButton.Variant.SUCCESS);
    // Note: In production, you'd handle click events through JavaScript interop

    stateButtons.add(loadingBtn, disabledBtn, clickLoadBtn);

    Div statesCode = new Div();
    statesCode.setText(
      "// Loading state\n" +
      "button.setLoading(true);\n\n" +
      "// Disabled state\n" +
      "button.setDisabled(true);\n\n" +
      "// Toggle loading on click\n" +
      "button.addClickListener(e -> {\n" +
      "  button.setLoading(true);\n" +
      "  // Perform async operation...\n" +
      "});"
    );
    styleCodeBlock(statesCode);

    statesDemo.add(stateButtons, statesCode);
    statesExample.add(statesDemo);

    // Button groups section
    FlexLayout groupsExample = createSection(
      "Button Groups",
      "Button groups organize related buttons horizontally."
    );

    FlexLayout groupsDemo = new FlexLayout();
    groupsDemo.setDirection(FlexDirection.COLUMN);
    groupsDemo.setSpacing("20px");

    // Basic button group
    ButtonGroup basicGroup = new ButtonGroup();
    basicGroup.setLabel("Alignment options");
    basicGroup.addButton(new ShoelaceButton("Left"));
    basicGroup.addButton(new ShoelaceButton("Center"));
    basicGroup.addButton(new ShoelaceButton("Right"));

    // Icon button group
    ButtonGroup iconGroup = new ButtonGroup();
    iconGroup.setLabel("Text formatting");

    ShoelaceButton boldBtn = new ShoelaceButton();
    boldBtn.setHtml("<sl-icon name=\"type-bold\"></sl-icon>");

    ShoelaceButton italicBtn = new ShoelaceButton();
    italicBtn.setHtml("<sl-icon name=\"type-italic\"></sl-icon>");

    ShoelaceButton underlineBtn = new ShoelaceButton();
    underlineBtn.setHtml("<sl-icon name=\"type-underline\"></sl-icon>");

    iconGroup.addButton(boldBtn);
    iconGroup.addButton(italicBtn);
    iconGroup.addButton(underlineBtn);

    FlexLayout groupsContainer = new FlexLayout();
    groupsContainer.setSpacing("20px");
    groupsContainer.add(basicGroup, iconGroup);

    Div groupsCode = new Div();
    groupsCode.setText(
      "// Create a button group\n" +
      "ButtonGroup group = new ButtonGroup();\n" +
      "group.setLabel(\"Alignment options\");\n\n" +
      "// Add buttons to the group\n" +
      "group.addButton(new ShoelaceButton(\"Left\"));\n" +
      "group.addButton(new ShoelaceButton(\"Center\"));\n" +
      "group.addButton(new ShoelaceButton(\"Right\"));"
    );
    styleCodeBlock(groupsCode);

    groupsDemo.add(groupsContainer, groupsCode);
    groupsExample.add(groupsDemo);

    // Link buttons section
    FlexLayout linkExample = createSection(
      "Link Buttons",
      "Buttons can function as links by setting the href attribute."
    );

    FlexLayout linkDemo = new FlexLayout();
    linkDemo.setDirection(FlexDirection.COLUMN);
    linkDemo.setSpacing("20px");

    FlexLayout linkButtons = new FlexLayout();
    linkButtons.setSpacing("10px");

    ShoelaceButton linkBtn = new ShoelaceButton("Shoelace Docs");
    linkBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    linkBtn.setHref("https://shoelace.style");
    linkBtn.setTarget("_blank");

    ShoelaceButton downloadBtn = new ShoelaceButton("Download");
    downloadBtn.setPrefix(TablerIcon.create("download"));
    downloadBtn.setHref("/path/to/file.pdf");
    downloadBtn.setDownload("file.pdf");

    linkButtons.add(linkBtn, downloadBtn);

    Div linkCode = new Div();
    linkCode.setText(
      "// External link button\n" +
      "button.setHref(\"https://shoelace.style\");\n" +
      "button.setTarget(\"_blank\");\n\n" +
      "// Download button\n" +
      "button.setHref(\"/path/to/file.pdf\");\n" +
      "button.setDownload(\"file.pdf\");"
    );
    styleCodeBlock(linkCode);

    linkDemo.add(linkButtons, linkCode);
    linkExample.add(linkDemo);

    // Interactive example
    FlexLayout interactiveExample = createSection(
      "Interactive Example",
      "Customize button properties to see the result."
    );

    FlexLayout interactiveDemo = new FlexLayout();
    interactiveDemo.setDirection(FlexDirection.COLUMN);
    interactiveDemo.setSpacing("20px");

    // Controls
    FlexLayout controls = new FlexLayout();
    controls.setDirection(FlexDirection.COLUMN);
    controls.setSpacing("15px");

    // Variant selector
    com.webforj.component.list.ChoiceBox variantChoice = new com.webforj.component.list.ChoiceBox();
    variantChoice.setLabel("Variant");
    variantChoice.add("default", "Default");
    variantChoice.add("primary", "Primary");
    variantChoice.add("success", "Success");
    variantChoice.add("neutral", "Neutral");
    variantChoice.add("warning", "Warning");
    variantChoice.add("danger", "Danger");
    variantChoice.add("text", "Text");
    variantChoice.selectKey("primary");

    // Size selector
    com.webforj.component.list.ChoiceBox sizeChoice = new com.webforj.component.list.ChoiceBox();
    sizeChoice.setLabel("Size");
    sizeChoice.add("small", "Small");
    sizeChoice.add("medium", "Medium");
    sizeChoice.add("large", "Large");
    sizeChoice.selectKey("medium");

    CheckBox outlineCheck = new CheckBox("Outline");
    CheckBox pillCheck = new CheckBox("Pill");
    CheckBox circleCheck = new CheckBox("Circle");
    CheckBox caretCheck = new CheckBox("Caret");
    CheckBox loadingCheck = new CheckBox("Loading");
    CheckBox disabledCheck = new CheckBox("Disabled");

    controls.add(variantChoice, sizeChoice, outlineCheck, pillCheck,
                 circleCheck, caretCheck, loadingCheck, disabledCheck);

    // Preview button
    ShoelaceButton previewBtn = new ShoelaceButton("Preview Button");
    previewBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    previewBtn.setPrefix(TablerIcon.create("star"));

    // Event handlers
    variantChoice.onSelect(e -> {
      String variant = (String) variantChoice.getSelectedKey();
      previewBtn.setVariant(variant);
    });

    sizeChoice.onSelect(e -> {
      String size = (String) sizeChoice.getSelectedKey();
      previewBtn.setSize(size);
    });

    outlineCheck.addValueChangeListener(e -> previewBtn.setOutline(outlineCheck.isChecked()));
    pillCheck.addValueChangeListener(e -> previewBtn.setPill(pillCheck.isChecked()));
    circleCheck.addValueChangeListener(e -> {
      previewBtn.setCircle(circleCheck.isChecked());
      if (circleCheck.isChecked()) {
        previewBtn.setHtml("<sl-icon name=\"star\"></sl-icon>");
      } else {
        previewBtn.setHtml("Preview Button");
        previewBtn.setPrefix(TablerIcon.create("star"));
      }
    });
    caretCheck.addValueChangeListener(e -> previewBtn.setCaret(caretCheck.isChecked()));
    loadingCheck.addValueChangeListener(e -> previewBtn.setLoading(loadingCheck.isChecked()));
    disabledCheck.addValueChangeListener(e -> previewBtn.setDisabled(disabledCheck.isChecked()));

    FlexLayout previewContainer = new FlexLayout();
    previewContainer.setAlignment(FlexAlignment.CENTER);
    previewContainer.setJustifyContent(com.webforj.component.layout.flexlayout.FlexJustifyContent.CENTER);
    previewContainer.setStyle("min-height", "100px");
    previewContainer.setStyle("border", "1px dashed #dee2e6");
    previewContainer.setStyle("border-radius", "8px");
    previewContainer.add(previewBtn);

    interactiveDemo.add(controls, previewContainer);
    interactiveExample.add(interactiveDemo);

    // Event Handling section
    FlexLayout eventsSection = createSection(
      "Event Handling",
      "ShoelaceButton components support various user interaction events. These events allow you to " +
      "respond to user actions like clicks, focus changes, and validation states."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("30px");

    // Interactive event demo
    FlexLayout eventButtonContainer = new FlexLayout();
    eventButtonContainer.setDirection(FlexDirection.COLUMN);
    eventButtonContainer.setAlignment(FlexAlignment.CENTER);
    eventButtonContainer.setSpacing("20px");

    ShoelaceButton eventBtn = new ShoelaceButton("Interactive Button");
    eventBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    eventBtn.setSize(ShoelaceButton.Size.LARGE);
    eventBtn.setPrefix(TablerIcon.create("cursor-text"));

    // Event status display
    Div eventStatus = new Div();
    eventStatus.setText("Interact with the button above to see events in action!");
    eventStatus.setStyle("padding", "16px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border-radius", "8px")
               .setStyle("text-align", "center")
               .setStyle("font-size", "14px")
               .setStyle("min-height", "50px")
               .setStyle("display", "flex")
               .setStyle("align-items", "center")
               .setStyle("justify-content", "center");

    // Event count tracker
    int[] clickCount = {0};

    // Register event handlers
    eventBtn.onClick(event -> {
      clickCount[0]++;
      String message = String.format("Click #%d at coordinates: (%d, %d)", 
        clickCount[0], event.getClientX(), event.getClientY());
      eventStatus.setText(message);
      eventStatus.setStyle("background", "#e3f2fd");
    });

    eventBtn.onDoubleClick(event -> {
      eventStatus.setText("Double-clicked! This could trigger a special action.");
      eventStatus.setStyle("background", "#c8e6c9");
    });

    eventBtn.onFocus(event -> {
      eventStatus.setText("Button focused - ready for keyboard interaction!");
      eventStatus.setStyle("background", "#fff3cd");
    });

    eventBtn.onBlur(event -> {
      eventStatus.setText("Button lost focus");
      eventStatus.setStyle("background", "#f8f9fa");
    });

    eventBtn.onMouseEnter(event -> {
      eventStatus.setText("Mouse hovering over button");
      eventStatus.setStyle("background", "#e1f5fe");
    });

    eventBtn.onMouseLeave(event -> {
      eventStatus.setText("Mouse left button area");
      eventStatus.setStyle("background", "#f8f9fa");
    });

    // Form validation demo button
    ShoelaceButton validationBtn = new ShoelaceButton("Submit (Validation Demo)");
    validationBtn.setVariant(ShoelaceButton.Variant.SUCCESS);
    validationBtn.setType("submit");

    validationBtn.onInvalid(event -> {
      eventStatus.setText("Invalid event fired - form validation failed!");
      eventStatus.setStyle("background", "#ffebee");
    });

    FlexLayout eventButtons = new FlexLayout();
    eventButtons.setSpacing("15px");
    eventButtons.add(eventBtn, validationBtn);

    eventButtonContainer.add(eventButtons, eventStatus);

    // Event code examples
    Div eventCode = new Div();
    eventCode.setText(
      "// Click event with coordinates\n" +
      "button.onClick(event -> {\n" +
      "    System.out.println(\"Clicked at: \" + event.getClientX() + \", \" + event.getClientY());\n" +
      "    handleButtonClick();\n" +
      "});\n\n" +
      "// Focus/blur events for accessibility\n" +
      "button.onFocus(event -> {\n" +
      "    highlightButton();\n" +
      "});\n\n" +
      "button.onBlur(event -> {\n" +
      "    removeHighlight();\n" +
      "});\n\n" +
      "// Form validation\n" +
      "button.onInvalid(event -> {\n" +
      "    showValidationError();\n" +
      "});\n\n" +
      "// Remove listener when needed\n" +
      "ListenerRegistration<ShoelaceButton.ClickEvent> reg = button.onClick(handler);\n" +
      "reg.remove();"
    );
    styleCodeBlock(eventCode);

    eventsDemo.add(eventButtonContainer, eventCode);
    eventsSection.add(eventsDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties Table",
      "The ShoelaceButton component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events table section
    FlexLayout eventsTableSection = createSection(
      "Events Table",
      "The ShoelaceButton component supports the following events:"
    );

    FlexLayout eventsTable = createEventsTable();
    eventsTableSection.add(eventsTable);

    // Add all sections to main layout
    self.add(header, basicExample, variantsExample, outlineExample, sizesExample,
             iconsExample, statesExample, groupsExample, linkExample,
             interactiveExample, eventsSection, propertiesSection, eventsTableSection);
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
      {"variant", "Button's semantic variant", "String", "\"default\""},
      {"size", "Button's size", "String", "\"medium\""},
      {"outline", "Draws outline button", "boolean", "false"},
      {"pill", "Draws pill-shaped button", "boolean", "false"},
      {"circle", "Draws circular button", "boolean", "false"},
      {"caret", "Shows dropdown caret", "boolean", "false"},
      {"loading", "Shows loading spinner", "boolean", "false"},
      {"disabled", "Disables the button", "boolean", "false"},
      {"type", "Button type attribute", "String", "\"button\""},
      {"href", "URL for link buttons", "String", "\"\""},
      {"target", "Link target attribute", "String", "\"\""},
      {"download", "Download attribute", "String", "\"\""}
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
      createTableCell("Fired when the button is clicked", false),
      createTableCell("clientX, clientY", false)
    );

    FlexLayout dblClickRow = createTableRow(false);
    dblClickRow.add(
      createTableCell("onDoubleClick", false),
      createTableCell("Fired when the button is double-clicked", false),
      createTableCell("clientX, clientY", false)
    );

    FlexLayout focusRow = createTableRow(false);
    focusRow.add(
      createTableCell("onFocus", false),
      createTableCell("Fired when the button receives focus", false),
      createTableCell("-", false)
    );

    FlexLayout blurRow = createTableRow(false);
    blurRow.add(
      createTableCell("onBlur", false),
      createTableCell("Fired when the button loses focus", false),
      createTableCell("-", false)
    );

    FlexLayout invalidRow = createTableRow(false);
    invalidRow.add(
      createTableCell("onInvalid", false),
      createTableCell("Fired when form validation fails", false),
      createTableCell("-", false)
    );

    FlexLayout mouseEnterRow = createTableRow(false);
    mouseEnterRow.add(
      createTableCell("onMouseEnter", false),
      createTableCell("Fired when mouse enters button area", false),
      createTableCell("-", false)
    );

    FlexLayout mouseLeaveRow = createTableRow(false);
    mouseLeaveRow.add(
      createTableCell("onMouseLeave", false),
      createTableCell("Fired when mouse leaves button area", false),
      createTableCell("-", false)
    );

    table.add(headerRow, clickRow, dblClickRow, focusRow, blurRow, invalidRow, mouseEnterRow, mouseLeaveRow);
    return table;
  }
}
