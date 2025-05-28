package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Breadcrumb;
import com.webforj.libraries.shoelace.components.BreadcrumbItem;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/breadcrumb", outlet = MainLayout.class)
@FrameTitle("Breadcrumb")
public class BreadcrumbView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public BreadcrumbView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Breadcrumb");
    Paragraph description = new Paragraph(
      "Breadcrumbs provide a group of links so users can easily navigate a website's hierarchy. " +
      "They're typically placed at the top of the page, below the header."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText(
      "import com.webforj.libraries.shoelace.components.Breadcrumb;\n" +
      "import com.webforj.libraries.shoelace.components.BreadcrumbItem;"
    );
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Breadcrumb.html",
      "https://shoelace.style/components/breadcrumb"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic example section
    FlexLayout basicExample = createSection(
      "Basic Breadcrumb",
      "Breadcrumbs are composed of individual breadcrumb items."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    Breadcrumb basicBreadcrumb = new Breadcrumb();
    basicBreadcrumb.addItem("Home", "/");
    basicBreadcrumb.addItem("Components", "/components");
    basicBreadcrumb.addItem("Breadcrumb");

    Div basicCode = new Div();
    basicCode.setText(
      "Breadcrumb breadcrumb = new Breadcrumb();\n" +
      "breadcrumb.addItem(\"Home\", \"/\");\n" +
      "breadcrumb.addItem(\"Components\", \"/components\");\n" +
      "breadcrumb.addItem(\"Breadcrumb\");  // Current page (no link)"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicBreadcrumb, basicCode);
    basicExample.add(basicDemo);

    // With icons section
    FlexLayout iconsExample = createSection(
      "Breadcrumb with Icons",
      "Use the prefix slot to add icons to breadcrumb items."
    );

    FlexLayout iconsDemo = new FlexLayout();
    iconsDemo.setDirection(FlexDirection.COLUMN);
    iconsDemo.setSpacing("20px");

    Breadcrumb iconsBreadcrumb = new Breadcrumb();

    // Home with icon
    BreadcrumbItem homeItem = new BreadcrumbItem("Home");
    homeItem.setHref("/");
    homeItem.setPrefixIcon("house");
    iconsBreadcrumb.addItem(homeItem);

    // Settings with icon
    BreadcrumbItem settingsItem = new BreadcrumbItem("Settings");
    settingsItem.setHref("/settings");
    settingsItem.setPrefixIcon("gear");
    iconsBreadcrumb.addItem(settingsItem);

    // Security (current page)
    BreadcrumbItem securityItem = new BreadcrumbItem("Security");
    securityItem.setPrefixIcon("shield-lock");
    iconsBreadcrumb.addItem(securityItem);

    Div iconsCode = new Div();
    iconsCode.setText(
      "Breadcrumb breadcrumb = new Breadcrumb();\n\n" +
      "BreadcrumbItem homeItem = new BreadcrumbItem(\"Home\");\n" +
      "homeItem.setHref(\"/\");\n" +
      "homeItem.setPrefixIcon(\"house\");\n" +
      "breadcrumb.addItem(homeItem);\n\n" +
      "// Add more items with icons..."
    );
    styleCodeBlock(iconsCode);

    iconsDemo.add(iconsBreadcrumb, iconsCode);
    iconsExample.add(iconsDemo);

    // Custom separators section
    FlexLayout separatorsExample = createSection(
      "Custom Separators",
      "Use the separator slot to change the separator between items."
    );

    FlexLayout separatorsDemo = new FlexLayout();
    separatorsDemo.setDirection(FlexDirection.COLUMN);
    separatorsDemo.setSpacing("20px");

    // Breadcrumb with arrow separator
    Breadcrumb arrowBreadcrumb = new Breadcrumb();
    arrowBreadcrumb.setSeparatorIcon("arrow-right");
    arrowBreadcrumb.addItem("First", "#");
    arrowBreadcrumb.addItem("Second", "#");
    arrowBreadcrumb.addItem("Third");

    // Breadcrumb with dot separator
    Breadcrumb dotBreadcrumb = new Breadcrumb();
    dotBreadcrumb.setSeparatorIcon("dot");
    dotBreadcrumb.addItem("Products", "/products");
    dotBreadcrumb.addItem("Electronics", "/products/electronics");
    dotBreadcrumb.addItem("Laptops");

    // Breadcrumb with custom separator
    Breadcrumb customBreadcrumb = new Breadcrumb();
    Div customSeparator = new Div(" → ");
    customSeparator.setStyle("margin", "0 8px");
    customSeparator.setStyle("color", "#6b7280");
    customBreadcrumb.setSeparator(customSeparator);
    customBreadcrumb.addItem("Level 1", "#");
    customBreadcrumb.addItem("Level 2", "#");
    customBreadcrumb.addItem("Level 3");

    Div separatorsCode = new Div();
    separatorsCode.setText(
      "// Arrow separator\n" +
      "breadcrumb.setSeparatorIcon(\"arrow-right\");\n\n" +
      "// Dot separator\n" +
      "breadcrumb.setSeparatorIcon(\"dot\");\n\n" +
      "// Custom separator\n" +
      "Div separator = new Div(\" → \");\n" +
      "breadcrumb.setSeparator(separator);"
    );
    styleCodeBlock(separatorsCode);

    separatorsDemo.add(arrowBreadcrumb, dotBreadcrumb, customBreadcrumb, separatorsCode);
    separatorsExample.add(separatorsDemo);

    // Complex navigation example
    FlexLayout complexExample = createSection(
      "Complex Navigation",
      "A real-world example with multiple navigation levels."
    );

    FlexLayout complexDemo = new FlexLayout();
    complexDemo.setDirection(FlexDirection.COLUMN);
    complexDemo.setSpacing("20px");

    // E-commerce breadcrumb
    Breadcrumb ecommerceBreadcrumb = new Breadcrumb();
    ecommerceBreadcrumb.setLabel("Product navigation");

    BreadcrumbItem storeItem = new BreadcrumbItem("Store");
    storeItem.setHref("/");
    storeItem.setPrefixIcon("building-store");
    ecommerceBreadcrumb.addItem(storeItem);

    ecommerceBreadcrumb.addItem("Electronics", "/electronics");
    ecommerceBreadcrumb.addItem("Computers", "/electronics/computers");
    ecommerceBreadcrumb.addItem("Laptops", "/electronics/computers/laptops");

    BreadcrumbItem productItem = new BreadcrumbItem("MacBook Pro 16\"");
    ecommerceBreadcrumb.addItem(productItem);

    // File system breadcrumb
    Breadcrumb filesBreadcrumb = new Breadcrumb();
    filesBreadcrumb.setSeparatorIcon("chevron-right");

    BreadcrumbItem rootItem = new BreadcrumbItem();
    rootItem.setPrefixIcon("folder");
    rootItem.setHtml("Root");
    rootItem.setHref("/files");
    filesBreadcrumb.addItem(rootItem);

    filesBreadcrumb.addItem("Documents", "/files/documents");
    filesBreadcrumb.addItem("Projects", "/files/documents/projects");
    filesBreadcrumb.addItem("2024", "/files/documents/projects/2024");
    filesBreadcrumb.addItem("Report.pdf");

    Div complexCode = new Div();
    complexCode.setText(
      "// E-commerce navigation\n" +
      "Breadcrumb breadcrumb = new Breadcrumb();\n" +
      "breadcrumb.setLabel(\"Product navigation\");\n\n" +
      "BreadcrumbItem storeItem = new BreadcrumbItem(\"Store\");\n" +
      "storeItem.setPrefixIcon(\"building-store\");\n" +
      "breadcrumb.addItem(storeItem);\n\n" +
      "breadcrumb.addItem(\"Electronics\", \"/electronics\");\n" +
      "breadcrumb.addItem(\"Computers\", \"/electronics/computers\");\n" +
      "breadcrumb.addItem(\"MacBook Pro 16\\\"\");  // Current"
    );
    styleCodeBlock(complexCode);

    complexDemo.add(ecommerceBreadcrumb, filesBreadcrumb, complexCode);
    complexExample.add(complexDemo);

    // Events section
    FlexLayout eventsSection = createSection(
      "Events",
      "The Breadcrumb and BreadcrumbItem components do not emit any custom events."
    );

    Div noEventsNote = new Div();
    noEventsNote.setText(
      "These components are navigation aids and do not emit events. " +
      "Clicks on breadcrumb items are handled as regular link navigation. " +
      "If you need to intercept navigation, you can handle routing at the application level."
    );
    noEventsNote.setStyle("background", "#f8f9fa")
                .setStyle("padding", "16px")
                .setStyle("border-radius", "8px")
                .setStyle("font-size", "14px")
                .setStyle("color", "#495057")
                .setStyle("border", "1px solid #e9ecef");
    
    eventsSection.add(noEventsNote);

    // Properties section
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Breadcrumb and BreadcrumbItem components support the following properties:"
    );

    FlexLayout breadcrumbTable = createBreadcrumbPropertiesTable();
    FlexLayout itemTable = createItemPropertiesTable();

    H3 breadcrumbTitle = new H3("Breadcrumb Properties");
    breadcrumbTitle.setStyle("margin-top", "20px");
    H3 itemTitle = new H3("BreadcrumbItem Properties");
    itemTitle.setStyle("margin-top", "30px");

    propertiesSection.add(breadcrumbTable, itemTitle, itemTable);

    // Add all sections to main layout
    self.add(header, basicExample, iconsExample, separatorsExample,
             complexExample, eventsSection, propertiesSection);
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

  private FlexLayout createBreadcrumbPropertiesTable() {
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
      {"label", "Accessible label for navigation", "String", "\"Breadcrumb\""}
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

  private FlexLayout createItemPropertiesTable() {
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
      {"href", "Link URL for the item", "String", "\"\""},
      {"target", "Link target attribute", "String", "\"\""},
      {"rel", "Link relationship", "String", "\"noreferrer noopener\""}
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
}
