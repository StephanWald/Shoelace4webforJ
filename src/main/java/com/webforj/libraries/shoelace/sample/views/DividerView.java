package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Divider;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/divider", outlet = MainLayout.class)
@FrameTitle("Divider")
public class DividerView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public DividerView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Divider");
    Paragraph description = new Paragraph(
      "Dividers are used to visually separate content. They can be horizontal or vertical, " +
      "and customized with different colors, widths, and spacing."
    );

    // Component import
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Divider;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Divider.html",
      "https://shoelace.style/components/divider"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic divider section
    FlexLayout basicExample = createSection(
      "Basic Divider",
      "A simple horizontal divider to separate content."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    Paragraph beforeText = new Paragraph(
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor " +
      "incididunt ut labore et dolore magna aliqua."
    );

    Divider basicDivider = new Divider();

    Paragraph afterText = new Paragraph(
      "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
      "aliquip ex ea commodo consequat."
    );

    Div basicCode = new Div();
    basicCode.setText(
      "// Create a basic horizontal divider\n" +
      "Divider divider = new Divider();\n\n" +
      "// Or use in a layout\n" +
      "layout.add(content1, new Divider(), content2);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(beforeText, basicDivider, afterText, basicCode);
    basicExample.add(basicDemo);

    // Vertical divider section
    FlexLayout verticalExample = createSection(
      "Vertical Divider",
      "Use the vertical attribute to draw the divider vertically. Useful in flex containers."
    );

    FlexLayout verticalDemo = new FlexLayout();
    verticalDemo.setDirection(FlexDirection.COLUMN);
    verticalDemo.setSpacing("20px");

    FlexLayout verticalContainer = new FlexLayout();
    verticalContainer.setAlignment(FlexAlignment.CENTER);
    verticalContainer.setSpacing("20px");
    verticalContainer.setStyle("background", "#f8f9fa");
    verticalContainer.setStyle("padding", "20px");
    verticalContainer.setStyle("border-radius", "8px");
    verticalContainer.setStyle("height", "100px");

    Div leftContent = new Div();
    leftContent.setText("Left Content");
    leftContent.setStyle("flex", "1");
    leftContent.setStyle("text-align", "center");

    Divider verticalDivider = new Divider(true);

    Div rightContent = new Div();
    rightContent.setText("Right Content");
    rightContent.setStyle("flex", "1");
    rightContent.setStyle("text-align", "center");

    verticalContainer.add(leftContent, verticalDivider, rightContent);

    Div verticalCode = new Div();
    verticalCode.setText(
      "// Create a vertical divider\n" +
      "Divider divider = new Divider(true);\n\n" +
      "// Or set it after creation\n" +
      "divider.setVertical(true);\n\n" +
      "// Use in a flex container\n" +
      "flexLayout.add(leftPanel, divider, rightPanel);"
    );
    styleCodeBlock(verticalCode);

    verticalDemo.add(verticalContainer, verticalCode);
    verticalExample.add(verticalDemo);

    // Custom style section
    FlexLayout styleExample = createSection(
      "Custom Styles",
      "Customize the divider's appearance with color, width, and spacing."
    );

    FlexLayout styleDemo = new FlexLayout();
    styleDemo.setDirection(FlexDirection.COLUMN);
    styleDemo.setSpacing("30px");

    // Color example
    FlexLayout colorExample = new FlexLayout();
    colorExample.setDirection(FlexDirection.COLUMN);
    colorExample.setSpacing("10px");

    H4 colorTitle = new H4("Custom Colors");
    colorTitle.setStyle("margin", "0");

    Divider blueDivider = new Divider();
    blueDivider.setColor("#0969da");

    Divider redDivider = new Divider();
    redDivider.setColor("#dc3545");

    Divider gradientDivider = new Divider();
    gradientDivider.setColor("linear-gradient(90deg, #667eea 0%, #764ba2 100%)");

    colorExample.add(colorTitle, blueDivider, redDivider, gradientDivider);

    // Width example
    FlexLayout widthExample = new FlexLayout();
    widthExample.setDirection(FlexDirection.COLUMN);
    widthExample.setSpacing("15px");

    H4 widthTitle = new H4("Custom Width");
    widthTitle.setStyle("margin", "0");

    Divider thinDivider = new Divider();
    thinDivider.setWidth("1px");

    Divider thickDivider = new Divider();
    thickDivider.setWidth("4px");

    Divider extraThickDivider = new Divider();
    extraThickDivider.setWidth("8px");
    extraThickDivider.setColor("#e9ecef");

    widthExample.add(widthTitle, thinDivider, thickDivider, extraThickDivider);

    // Spacing example
    FlexLayout spacingExample = new FlexLayout();
    spacingExample.setDirection(FlexDirection.COLUMN);
    spacingExample.setSpacing("0");

    H4 spacingTitle = new H4("Custom Spacing");
    spacingTitle.setStyle("margin", "0 0 10px 0");

    Paragraph spacingText1 = new Paragraph("Content with custom divider spacing");

    Divider spacedDivider = new Divider();
    spacedDivider.setSpacing("2rem");
    spacedDivider.setColor("#6c757d");

    Paragraph spacingText2 = new Paragraph("Notice the extra space around the divider");

    spacingExample.add(spacingTitle, spacingText1, spacedDivider, spacingText2);

    Div styleCode = new Div();
    styleCode.setText(
      "// Set custom color\n" +
      "divider.setColor(\"#0969da\");\n" +
      "divider.setColor(\"linear-gradient(90deg, #667eea 0%, #764ba2 100%)\");\n\n" +
      "// Set custom width\n" +
      "divider.setWidth(\"4px\");\n\n" +
      "// Set custom spacing\n" +
      "divider.setSpacing(\"2rem\");\n\n" +
      "// Chain methods\n" +
      "new Divider()\n" +
      "  .setColor(\"#dc3545\")\n" +
      "  .setWidth(\"2px\")\n" +
      "  .setSpacing(\"1.5rem\");"
    );
    styleCodeBlock(styleCode);

    styleDemo.add(colorExample, widthExample, spacingExample, styleCode);
    styleExample.add(styleDemo);

    // Menu divider section
    FlexLayout menuExample = createSection(
      "Menu Dividers",
      "Dividers work great for separating groups of menu items."
    );

    FlexLayout menuDemo = new FlexLayout();
    menuDemo.setDirection(FlexDirection.COLUMN);
    menuDemo.setSpacing("20px");

    // Create a mock menu
    FlexLayout mockMenu = new FlexLayout();
    mockMenu.setDirection(FlexDirection.COLUMN);
    mockMenu.setStyle("background", "#ffffff");
    mockMenu.setStyle("border", "1px solid #dee2e6");
    mockMenu.setStyle("border-radius", "8px");
    mockMenu.setStyle("width", "250px");
    mockMenu.setStyle("padding", "8px 0");
    mockMenu.setStyle("box-shadow", "0 2px 4px rgba(0,0,0,0.1)");

    Div menuItem1 = createMenuItem("Profile");
    Div menuItem2 = createMenuItem("Settings");
    Div menuItem3 = createMenuItem("Account");

    Divider menuDivider = new Divider();
    menuDivider.setSpacing("8px");

    Div menuItem4 = createMenuItem("Help & Support");
    Div menuItem5 = createMenuItem("Sign Out");

    mockMenu.add(menuItem1, menuItem2, menuItem3, menuDivider, menuItem4, menuItem5);

    Div menuCode = new Div();
    menuCode.setText(
      "// Use dividers in menus\n" +
      "menu.add(\n" +
      "  new MenuItem(\"Profile\"),\n" +
      "  new MenuItem(\"Settings\"),\n" +
      "  new MenuItem(\"Account\"),\n" +
      "  new Divider().setSpacing(\"8px\"),\n" +
      "  new MenuItem(\"Help\"),\n" +
      "  new MenuItem(\"Sign Out\")\n" +
      ");"
    );
    styleCodeBlock(menuCode);

    menuDemo.add(mockMenu, menuCode);
    menuExample.add(menuDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Divider component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, verticalExample, styleExample,
             menuExample, propertiesSection);
  }

  private Div createMenuItem(String text) {
    Div item = new Div();
    item.setText(text);
    item.setStyle("padding", "8px 16px");
    item.setStyle("cursor", "pointer");
    item.setStyle("transition", "background-color 0.2s");
    // Note: onMouseEnter/Leave not available - would need JavaScript interop for hover effects
    return item;
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

    // Properties
    String[][] items = {
      {"vertical", "Draws divider vertically", "boolean", "false"},
      {"setColor()", "Sets divider color", "method", "-"},
      {"setWidth()", "Sets divider thickness", "method", "-"},
      {"setSpacing()", "Sets divider margin", "method", "-"}
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
