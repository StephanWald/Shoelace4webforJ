package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Icon;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/icon", outlet = MainLayout.class)
@FrameTitle("Icon")
public class IconView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public IconView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Icon");
    Paragraph description = new Paragraph(
      "Icons are symbols that can be used to represent various concepts and actions. " +
      "Shoelace provides access to multiple icon libraries with thousands of icons."
    );

    // Component import
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Icon;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Icon.html",
      "https://shoelace.style/components/icon"
    );

    header.add(title, description, componentImport, docsLinks);

    // Default library section
    FlexLayout defaultExample = createSection(
      "Default Library (Bootstrap Icons)",
      "The default library contains over 1,300 Bootstrap icons."
    );

    FlexLayout defaultDemo = new FlexLayout();
    defaultDemo.setDirection(FlexDirection.COLUMN);
    defaultDemo.setSpacing("20px");

    FlexLayout iconGrid = new FlexLayout();
    iconGrid.setWrap(FlexWrap.WRAP);
    iconGrid.setSpacing("20px");
    iconGrid.setAlignment(FlexAlignment.CENTER);

    // Sample Bootstrap icons
    String[] bootstrapIcons = {
      "house", "person", "gear", "heart", "star", "envelope",
      "calendar", "clock", "search", "bell", "trash", "pencil"
    };

    for (String iconName : bootstrapIcons) {
      FlexLayout iconBox = createIconBox(new Icon(iconName), iconName);
      iconGrid.add(iconBox);
    }

    Div defaultCode = new Div();
    defaultCode.setText(
      "// Create icon from default library\n" +
      "Icon icon = new Icon(\"house\");\n" +
      "Icon icon = new Icon(\"person\");\n" +
      "Icon icon = new Icon(\"gear\");\n\n" +
      "// Or use the helper method\n" +
      "Icon icon = Icon.bootstrap(\"star\");"
    );
    styleCodeBlock(defaultCode);

    defaultDemo.add(iconGrid, defaultCode);
    defaultExample.add(defaultDemo);

    // Sizing section
    FlexLayout sizingExample = createSection(
      "Icon Sizing",
      "Icons inherit their size from the current font size. You can also set custom sizes."
    );

    FlexLayout sizingDemo = new FlexLayout();
    sizingDemo.setDirection(FlexDirection.COLUMN);
    sizingDemo.setSpacing("20px");

    FlexLayout sizeContainer = new FlexLayout();
    sizeContainer.setSpacing("20px");
    sizeContainer.setAlignment(FlexAlignment.END);

    Icon smallIcon = new Icon("star");
    smallIcon.setSize("16px");

    Icon mediumIcon = new Icon("star");
    mediumIcon.setSize("24px");

    Icon largeIcon = new Icon("star");
    largeIcon.setSize("32px");

    Icon xlargeIcon = new Icon("star");
    xlargeIcon.setSize("48px");

    Icon remIcon = new Icon("star");
    remIcon.setSize("3rem");

    sizeContainer.add(
      createLabeledIcon(smallIcon, "16px"),
      createLabeledIcon(mediumIcon, "24px"),
      createLabeledIcon(largeIcon, "32px"),
      createLabeledIcon(xlargeIcon, "48px"),
      createLabeledIcon(remIcon, "3rem")
    );

    Div sizingCode = new Div();
    sizingCode.setText(
      "// Set icon size\n" +
      "icon.setSize(\"24px\");\n" +
      "icon.setSize(\"2rem\");\n" +
      "icon.setSize(\"48px\");\n\n" +
      "// Icons inherit font size\n" +
      "container.setStyle(\"font-size\", \"24px\");\n" +
      "container.add(new Icon(\"star\")); // Will be 24px"
    );
    styleCodeBlock(sizingCode);

    sizingDemo.add(sizeContainer, sizingCode);
    sizingExample.add(sizingDemo);

    // Color section
    FlexLayout colorExample = createSection(
      "Icon Colors",
      "Icons inherit their color from the current text color. You can also set custom colors."
    );

    FlexLayout colorDemo = new FlexLayout();
    colorDemo.setDirection(FlexDirection.COLUMN);
    colorDemo.setSpacing("20px");

    FlexLayout colorContainer = new FlexLayout();
    colorContainer.setSpacing("20px");

    Icon defaultColorIcon = new Icon("heart");
    defaultColorIcon.setSize("32px");

    Icon primaryIcon = new Icon("heart-fill");
    primaryIcon.setSize("32px");
    primaryIcon.setColor("#0969da");

    Icon successIcon = new Icon("check-circle-fill");
    successIcon.setSize("32px");
    successIcon.setColor("#1a7f37");

    Icon dangerIcon = new Icon("exclamation-triangle-fill");
    dangerIcon.setSize("32px");
    dangerIcon.setColor("#dc3545");

    Icon gradientIcon = new Icon("star-fill");
    gradientIcon.setSize("32px");
    gradientIcon.setStyle("background", "linear-gradient(45deg, #667eea, #764ba2)");
    gradientIcon.setStyle("-webkit-background-clip", "text");
    gradientIcon.setStyle("-webkit-text-fill-color", "transparent");

    colorContainer.add(defaultColorIcon, primaryIcon, successIcon, dangerIcon, gradientIcon);

    Div colorCode = new Div();
    colorCode.setText(
      "// Set icon color\n" +
      "icon.setColor(\"#0969da\");\n" +
      "icon.setColor(\"red\");\n" +
      "icon.setColor(\"rgb(26, 127, 55)\");\n\n" +
      "// Icons inherit text color\n" +
      "container.setStyle(\"color\", \"blue\");\n" +
      "container.add(new Icon(\"star\")); // Will be blue"
    );
    styleCodeBlock(colorCode);

    colorDemo.add(colorContainer, colorCode);
    colorExample.add(colorDemo);

    // External SVG section
    FlexLayout externalExample = createSection(
      "External SVGs",
      "Load icons from external SVG files using the src attribute."
    );

    FlexLayout externalDemo = new FlexLayout();
    externalDemo.setDirection(FlexDirection.COLUMN);
    externalDemo.setSpacing("20px");

    Icon externalIcon = new Icon();
    externalIcon.setSrc("/static/favicon.svg");
    externalIcon.setSize("48px");
    externalIcon.setLabel("Application logo");

    Div externalInfo = new Div();
    externalInfo.setText("Example using the project's favicon.svg");
    externalInfo.setStyle("color", "#6b7280");
    externalInfo.setStyle("font-size", "14px");

    Div externalCode = new Div();
    externalCode.setText(
      "// Load external SVG\n" +
      "Icon icon = new Icon();\n" +
      "icon.setSrc(\"/path/to/icon.svg\");\n" +
      "icon.setSize(\"48px\");\n" +
      "icon.setLabel(\"Description for accessibility\");"
    );
    styleCodeBlock(externalCode);

    externalDemo.add(externalIcon, externalInfo, externalCode);
    externalExample.add(externalDemo);

    // Icon libraries section
    FlexLayout librariesExample = createSection(
      "Icon Libraries",
      "Access different icon libraries by setting the library attribute."
    );

    FlexLayout librariesDemo = new FlexLayout();
    librariesDemo.setDirection(FlexDirection.COLUMN);
    librariesDemo.setSpacing("30px");

    // Library examples
    FlexLayout libraryGrid = new FlexLayout();
    libraryGrid.setDirection(FlexDirection.COLUMN);
    libraryGrid.setSpacing("20px");

    // Create library showcases
    libraryGrid.add(
      createLibraryShowcase("Bootstrap Icons (default)", "default",
        new String[]{"house", "gear", "heart", "star", "envelope"}),
      createLibraryShowcase("System Icons", "system",
        new String[]{"chevron-down", "chevron-left", "chevron-right", "check", "x"})
    );

    Div librariesCode = new Div();
    librariesCode.setText(
      "// Set icon library\n" +
      "Icon icon = new Icon(\"house\", \"default\");\n" +
      "Icon icon = new Icon(\"chevron-down\", \"system\");\n\n" +
      "// Using static helpers\n" +
      "Icon.bootstrap(\"star\");\n" +
      "Icon.tabler(\"home\");\n" +
      "Icon.material(\"settings\");\n" +
      "Icon.fontAwesome(\"user\");\n" +
      "Icon.boxicons(\"bx-heart\");\n" +
      "Icon.lucide(\"search\");\n" +
      "Icon.heroicons(\"bell\");\n" +
      "Icon.ionicons(\"calendar\");\n" +
      "Icon.remix(\"ri-home-line\");\n" +
      "Icon.unicons(\"home\");"
    );
    styleCodeBlock(librariesCode);

    Div librariesNote = new Div();
    librariesNote.setText(
      "Note: To use third-party icon libraries, you'll need to register them first. " +
      "See the Shoelace documentation for details on registering icon libraries."
    );
    librariesNote.setStyle("background", "#fff3cd");
    librariesNote.setStyle("border", "1px solid #ffeaa7");
    librariesNote.setStyle("color", "#856404");
    librariesNote.setStyle("padding", "12px");
    librariesNote.setStyle("border-radius", "8px");
    librariesNote.setStyle("font-size", "14px");

    librariesDemo.add(libraryGrid, librariesCode, librariesNote);
    librariesExample.add(librariesDemo);

    // Accessibility section
    FlexLayout accessibilityExample = createSection(
      "Accessibility",
      "Use the label attribute to provide accessible descriptions for icons."
    );

    FlexLayout accessibilityDemo = new FlexLayout();
    accessibilityDemo.setDirection(FlexDirection.COLUMN);
    accessibilityDemo.setSpacing("20px");

    FlexLayout accessibilityContainer = new FlexLayout();
    accessibilityContainer.setSpacing("20px");

    Icon labeledIcon1 = new Icon("gear");
    labeledIcon1.setLabel("Settings");
    labeledIcon1.setSize("24px");

    Icon labeledIcon2 = new Icon("trash");
    labeledIcon2.setLabel("Delete item");
    labeledIcon2.setSize("24px");

    Icon labeledIcon3 = new Icon("download");
    labeledIcon3.setLabel("Download file");
    labeledIcon3.setSize("24px");

    accessibilityContainer.add(
      createLabeledIcon(labeledIcon1, "Settings"),
      createLabeledIcon(labeledIcon2, "Delete"),
      createLabeledIcon(labeledIcon3, "Download")
    );

    Div accessibilityCode = new Div();
    accessibilityCode.setText(
      "// Add accessibility labels\n" +
      "icon.setLabel(\"Settings\");\n" +
      "icon.setLabel(\"Delete item\");\n" +
      "icon.setLabel(\"Download file\");\n\n" +
      "// Important for:\n" +
      "// - Screen readers\n" +
      "// - Icon-only buttons\n" +
      "// - Meaningful actions"
    );
    styleCodeBlock(accessibilityCode);

    accessibilityDemo.add(accessibilityContainer, accessibilityCode);
    accessibilityExample.add(accessibilityDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Icon component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, defaultExample, sizingExample, colorExample,
             externalExample, librariesExample, accessibilityExample, propertiesSection);
  }

  private FlexLayout createIconBox(Icon icon, String name) {
    FlexLayout box = new FlexLayout();
    box.setDirection(FlexDirection.COLUMN);
    box.setAlignment(FlexAlignment.CENTER);
    box.setSpacing("8px");
    box.setStyle("padding", "16px");
    box.setStyle("background", "#f8f9fa");
    box.setStyle("border-radius", "8px");
    box.setStyle("min-width", "100px");

    icon.setSize("24px");

    Div label = new Div();
    label.setText(name);
    label.setStyle("font-size", "12px");
    label.setStyle("color", "#6b7280");

    box.add(icon, label);
    return box;
  }

  private FlexLayout createLabeledIcon(Icon icon, String label) {
    FlexLayout container = new FlexLayout();
    container.setDirection(FlexDirection.COLUMN);
    container.setAlignment(FlexAlignment.CENTER);
    container.setSpacing("4px");

    Div labelDiv = new Div();
    labelDiv.setText(label);
    labelDiv.setStyle("font-size", "12px");
    labelDiv.setStyle("color", "#6b7280");

    container.add(icon, labelDiv);
    return container;
  }

  private FlexLayout createLibraryShowcase(String title, String library, String[] iconNames) {
    FlexLayout showcase = new FlexLayout();
    showcase.setDirection(FlexDirection.COLUMN);
    showcase.setSpacing("10px");

    H4 libraryTitle = new H4(title);
    libraryTitle.setStyle("margin", "0");

    FlexLayout iconRow = new FlexLayout();
    iconRow.setSpacing("16px");

    for (String iconName : iconNames) {
      Icon icon = new Icon(iconName, library);
      icon.setSize("24px");
      iconRow.add(icon);
    }

    showcase.add(libraryTitle, iconRow);
    return showcase;
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
      {"name", "Icon name from library", "String", "\"\""},
      {"src", "External SVG URL", "String", "\"\""},
      {"label", "Accessibility label", "String", "\"\""},
      {"library", "Icon library name", "String", "\"default\""},
      {"setSize()", "Sets icon size", "method", "-"},
      {"setColor()", "Sets icon color", "method", "-"}
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
