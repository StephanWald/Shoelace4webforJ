package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Icon;
import com.webforj.libraries.shoelace.components.Option;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/option", outlet = MainLayout.class)
@FrameTitle("Option")
public class OptionView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public OptionView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Option");
    Paragraph description = new Paragraph(
      "Options define selectable items within form controls such as select. " +
      "While typically used inside select components, options can be customized with " +
      "text, values, icons, and disabled states."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Option;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Option.html",
      "https://shoelace.style/components/option"
    );

    header.add(title, description, componentImport, docsLinks);

    // Note about usage
    Div usageNote = new Div();
    usageNote.setText(
      "Note: Options are designed to work inside select components. " +
      "This page demonstrates the Option API and how options would be created. " +
      "In practice, you would add these options to a Select component."
    );
    usageNote.setStyle("background", "#e3f2fd");
    usageNote.setStyle("border", "1px solid #90caf9");
    usageNote.setStyle("color", "#1565c0");
    usageNote.setStyle("padding", "16px");
    usageNote.setStyle("border-radius", "8px");
    usageNote.setStyle("margin-top", "20px");
    header.add(usageNote);

    // Basic option section
    FlexLayout basicExample = createSection(
      "Basic Options",
      "Options with text and values."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    // Create demo container to show how options would look
    FlexLayout optionsContainer = createOptionsContainer("Basic Options");

    Option option1 = new Option("First Option", "option-1");
    Option option2 = new Option("Second Option", "option-2");
    Option option3 = new Option("Third Option", "option-3");

    // Style options for display
    styleOption(option1);
    styleOption(option2);
    styleOption(option3);

    optionsContainer.add(option1, option2, option3);

    Div basicCode = new Div();
    basicCode.setText(
      "// Create options\n" +
      "Option option1 = new Option(\"First Option\", \"option-1\");\n" +
      "Option option2 = new Option(\"Second Option\", \"option-2\");\n" +
      "Option option3 = new Option(\"Third Option\", \"option-3\");\n\n" +
      "// In practice, add to select:\n" +
      "// select.add(option1, option2, option3);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(optionsContainer, basicCode);
    basicExample.add(basicDemo);

    // Disabled options section
    FlexLayout disabledExample = createSection(
      "Disabled Options",
      "Options can be disabled to prevent selection."
    );

    FlexLayout disabledDemo = new FlexLayout();
    disabledDemo.setDirection(FlexDirection.COLUMN);
    disabledDemo.setSpacing("20px");

    FlexLayout disabledContainer = createOptionsContainer("Options with Disabled States");

    Option enabledOption = new Option("Available", "available");
    Option disabledOption1 = new Option("Not Available", "not-available");
    disabledOption1.setDisabled(true);
    Option enabledOption2 = new Option("Also Available", "also-available");
    Option disabledOption2 = new Option("Coming Soon", "coming-soon");
    disabledOption2.setDisabled(true);

    styleOption(enabledOption);
    styleOption(disabledOption1);
    styleOption(enabledOption2);
    styleOption(disabledOption2);

    disabledContainer.add(enabledOption, disabledOption1, enabledOption2, disabledOption2);

    Div disabledCode = new Div();
    disabledCode.setText(
      "// Create disabled option\n" +
      "Option option = new Option(\"Not Available\", \"disabled\");\n" +
      "option.setDisabled(true);\n\n" +
      "// Check if disabled\n" +
      "boolean isDisabled = option.isDisabled();"
    );
    styleCodeBlock(disabledCode);

    disabledDemo.add(disabledContainer, disabledCode);
    disabledExample.add(disabledDemo);

    // Options with icons section
    FlexLayout iconsExample = createSection(
      "Options with Icons",
      "Add prefix and suffix icons to options."
    );

    FlexLayout iconsDemo = new FlexLayout();
    iconsDemo.setDirection(FlexDirection.COLUMN);
    iconsDemo.setSpacing("20px");

    FlexLayout iconsContainer = createOptionsContainer("Options with Icons");

    // Home option with prefix icon
    Option homeOption = new Option("Home", "home");
    homeOption.setPrefix(Icon.bootstrap("house-fill"));
    styleOption(homeOption);

    // Settings option with prefix icon
    Option settingsOption = new Option("Settings", "settings");
    settingsOption.setPrefix(Icon.bootstrap("gear-fill"));
    styleOption(settingsOption);

    // Premium option with suffix icon
    Option premiumOption = new Option("Premium Plan", "premium");
    premiumOption.setSuffix(Icon.bootstrap("star-fill"));
    styleOption(premiumOption);

    // Both prefix and suffix
    Option specialOption = new Option("Special Feature", "special");
    specialOption.setPrefix(Icon.bootstrap("lightning-fill"));
    specialOption.setSuffix(Icon.bootstrap("arrow-right"));
    styleOption(specialOption);

    iconsContainer.add(homeOption, settingsOption, premiumOption, specialOption);

    Div iconsCode = new Div();
    iconsCode.setText(
      "// Add prefix icon\n" +
      "Option option = new Option(\"Home\", \"home\");\n" +
      "option.setPrefix(Icon.bootstrap(\"house-fill\"));\n\n" +
      "// Add suffix icon\n" +
      "option.setSuffix(Icon.bootstrap(\"star-fill\"));\n\n" +
      "// Add both prefix and suffix\n" +
      "option.setPrefix(Icon.bootstrap(\"lightning-fill\"));\n" +
      "option.setSuffix(Icon.bootstrap(\"arrow-right\"));"
    );
    styleCodeBlock(iconsCode);

    iconsDemo.add(iconsContainer, iconsCode);
    iconsExample.add(iconsDemo);

    // Complex options section
    FlexLayout complexExample = createSection(
      "Complex Options",
      "Options can contain rich content for advanced use cases."
    );

    FlexLayout complexDemo = new FlexLayout();
    complexDemo.setDirection(FlexDirection.COLUMN);
    complexDemo.setSpacing("20px");

    FlexLayout complexContainer = createOptionsContainer("Rich Content Options");

    // Country options with flags
    Option usOption = createCountryOption("United States", "us", "🇺🇸");
    Option ukOption = createCountryOption("United Kingdom", "uk", "🇬🇧");
    Option jpOption = createCountryOption("Japan", "jp", "🇯🇵");
    Option deOption = createCountryOption("Germany", "de", "🇩🇪");

    complexContainer.add(usOption, ukOption, jpOption, deOption);

    Div complexCode = new Div();
    complexCode.setText(
      "// Create rich option content\n" +
      "Option countryOption = new Option();\n" +
      "countryOption.setValue(\"us\");\n\n" +
      "// Add flag as prefix\n" +
      "Div flag = new Div();\n" +
      "flag.setText(\"🇺🇸\");\n" +
      "countryOption.setPrefix(flag);\n\n" +
      "// Set main text\n" +
      "countryOption.setText(\"United States\");"
    );
    styleCodeBlock(complexCode);

    complexDemo.add(complexContainer, complexCode);
    complexExample.add(complexDemo);

    // API methods section
    FlexLayout apiExample = createSection(
      "API Methods",
      "Working with Option properties and methods."
    );

    FlexLayout apiDemo = new FlexLayout();
    apiDemo.setDirection(FlexDirection.COLUMN);
    apiDemo.setSpacing("20px");

    Div apiCode = new Div();
    apiCode.setText(
      "// Create option with constructor\n" +
      "Option option = new Option(); // Empty option\n" +
      "Option option = new Option(\"Text\"); // With text\n" +
      "Option option = new Option(\"Text\", \"value\"); // With text and value\n\n" +
      "// Set properties\n" +
      "option.setText(\"Display Text\");\n" +
      "option.setValue(\"internal-value\");\n" +
      "option.setDisabled(true);\n\n" +
      "// Get properties\n" +
      "String value = option.getValue();\n" +
      "boolean disabled = option.isDisabled();\n" +
      "String label = option.getTextLabel(); // Gets plain text\n\n" +
      "// Add to select component\n" +
      "// select.add(option);"
    );
    styleCodeBlock(apiCode);

    apiDemo.add(apiCode);
    apiExample.add(apiDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Option component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, disabledExample, iconsExample,
             complexExample, apiExample, propertiesSection);
  }

  private FlexLayout createOptionsContainer(String label) {
    FlexLayout container = new FlexLayout();
    container.setDirection(FlexDirection.COLUMN);
    container.setSpacing("1px");
    container.setStyle("border", "1px solid #dee2e6");
    container.setStyle("border-radius", "8px");
    container.setStyle("overflow", "hidden");
    container.setStyle("max-width", "400px");
    container.setStyle("background", "#f8f9fa");

    if (label != null) {
      Div labelDiv = new Div();
      labelDiv.setText(label);
      labelDiv.setStyle("padding", "8px 12px");
      labelDiv.setStyle("background", "#e9ecef");
      labelDiv.setStyle("font-size", "12px");
      labelDiv.setStyle("font-weight", "600");
      labelDiv.setStyle("color", "#6c757d");
      container.add(labelDiv);
    }

    return container;
  }

  private void styleOption(Option option) {
    option.setStyle("padding", "10px 16px");
    option.setStyle("background", "white");
    option.setStyle("cursor", "pointer");
    option.setStyle("display", "flex");
    option.setStyle("align-items", "center");
    option.setStyle("gap", "8px");
    option.setStyle("transition", "background-color 0.2s");

    if (option.isDisabled()) {
      option.setStyle("opacity", "0.5");
      option.setStyle("cursor", "not-allowed");
      option.setStyle("color", "#6c757d");
    }
  }

  private Option createCountryOption(String country, String code, String flag) {
    Option option = new Option(country, code);

    Div flagDiv = new Div();
    flagDiv.setText(flag);
    flagDiv.setStyle("font-size", "20px");
    option.setPrefix(flagDiv);

    styleOption(option);
    return option;
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

    // Properties and methods
    String[][] items = {
      {"value", "Option value", "String", "\"\""},
      {"disabled", "Disabled state", "boolean", "false"},
      {"setText()", "Sets display text", "method", "-"},
      {"setPrefix()", "Sets prefix content", "method", "-"},
      {"setSuffix()", "Sets suffix content", "method", "-"},
      {"getTextLabel()", "Gets plain text", "method", "-"}
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
}
