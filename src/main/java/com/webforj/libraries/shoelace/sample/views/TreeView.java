package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Tree;
import com.webforj.libraries.shoelace.components.TreeItem;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.util.List;

@Route(outlet = MainLayout.class)
@FrameTitle("Tree")
public class TreeView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public TreeView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Tree");
    Paragraph description = new Paragraph(
      "Trees allow you to display a hierarchical list of selectable tree items. " +
      "Items with children can be expanded and collapsed. The tree supports " +
      "various selection modes for different use cases."
    );

    // Documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Tree.html",
      "https://shoelace.style/components/tree"
    );

    header.add(title, description, docLinks);

    // Add all sections
    self.add(
      header,
      createBasicExample(),
      createExpandedExample(),
      createSelectionModesExample(),
      createNestedExample(),
      createEventHandlingExample(),
      createPropertiesTable()
    );
  }

  private FlexLayout createBasicExample() {
    FlexLayout section = createSection(
      "Basic Tree",
      "A basic tree with expandable items."
    );

    Tree tree = new Tree();

    TreeItem item1 = new TreeItem("Item 1");
    TreeItem subItem1 = new TreeItem("Item 1-1");
    TreeItem subItem2 = new TreeItem("Item 1-2");
    item1.addTreeItem(subItem1).addTreeItem(subItem2);

    TreeItem item2 = new TreeItem("Item 2");
    TreeItem item3 = new TreeItem("Item 3");

    tree.addTreeItem(item1).addTreeItem(item2).addTreeItem(item3);

    Div code = new Div();
    code.setText(
      "Tree tree = new Tree();\n" +
      "\n" +
      "TreeItem item1 = new TreeItem(\"Item 1\");\n" +
      "TreeItem subItem1 = new TreeItem(\"Item 1-1\");\n" +
      "TreeItem subItem2 = new TreeItem(\"Item 1-2\");\n" +
      "item1.addTreeItem(subItem1).addTreeItem(subItem2);\n" +
      "\n" +
      "TreeItem item2 = new TreeItem(\"Item 2\");\n" +
      "TreeItem item3 = new TreeItem(\"Item 3\");\n" +
      "\n" +
      "tree.addTreeItem(item1).addTreeItem(item2).addTreeItem(item3);"
    );
    styleCodeBlock(code);

    section.add(tree, code);
    return section;
  }

  private FlexLayout createExpandedExample() {
    FlexLayout section = createSection(
      "Expanded Tree",
      "Use the expanded property to expand tree items by default."
    );

    Tree tree = new Tree();

    TreeItem documents = new TreeItem("Documents").setExpanded(true);
    TreeItem reports = new TreeItem("Reports");
    TreeItem financials = new TreeItem("Financials");
    TreeItem q1 = new TreeItem("Q1 Report.pdf");
    TreeItem q2 = new TreeItem("Q2 Report.pdf");
    financials.addTreeItem(q1).addTreeItem(q2);
    reports.addTreeItem(financials);

    TreeItem personal = new TreeItem("Personal");
    TreeItem resume = new TreeItem("Resume.docx");
    TreeItem cover = new TreeItem("Cover Letter.docx");
    personal.addTreeItem(resume).addTreeItem(cover);

    documents.addTreeItem(reports).addTreeItem(personal);
    tree.addTreeItem(documents);

    Div code = new Div();
    code.setText(
      "TreeItem documents = new TreeItem(\"Documents\").setExpanded(true);\n" +
      "TreeItem reports = new TreeItem(\"Reports\");\n" +
      "TreeItem financials = new TreeItem(\"Financials\");\n" +
      "// ... add items\n" +
      "documents.addTreeItem(reports).addTreeItem(personal);"
    );
    styleCodeBlock(code);

    section.add(tree, code);
    return section;
  }

  private FlexLayout createSelectionModesExample() {
    FlexLayout section = createSection(
      "Selection Modes",
      "Trees support single selection, multiple selection, and leaf selection."
    );

    FlexLayout demos = new FlexLayout();
    demos.setDirection(FlexDirection.COLUMN);
    demos.setSpacing("20px");

    // Single selection
    Paragraph singleLabel = new Paragraph("Single Selection (default):");
    singleLabel.setStyle("font-weight", "bold");
    Tree singleTree = new Tree().setSelection("single");
    TreeItem s1 = new TreeItem("Option 1");
    TreeItem s2 = new TreeItem("Option 2");
    TreeItem s3 = new TreeItem("Option 3");
    singleTree.addTreeItem(s1).addTreeItem(s2).addTreeItem(s3);

    // Multiple selection
    Paragraph multiLabel = new Paragraph("Multiple Selection:");
    multiLabel.setStyle("font-weight", "bold");
    Tree multiTree = new Tree().setSelection("multiple");
    TreeItem m1 = new TreeItem("Choice A");
    TreeItem m2 = new TreeItem("Choice B");
    TreeItem m3 = new TreeItem("Choice C");
    multiTree.addTreeItem(m1).addTreeItem(m2).addTreeItem(m3);

    // Leaf selection
    Paragraph leafLabel = new Paragraph("Leaf Selection:");
    leafLabel.setStyle("font-weight", "bold");
    Tree leafTree = new Tree().setSelection("leaf");
    TreeItem parent = new TreeItem("Parent");
    TreeItem leaf1 = new TreeItem("Leaf 1");
    TreeItem leaf2 = new TreeItem("Leaf 2");
    parent.addTreeItem(leaf1).addTreeItem(leaf2);
    leafTree.addTreeItem(parent);

    Div code = new Div();
    code.setText(
      "// Single selection (default)\n" +
      "Tree singleTree = new Tree().setSelection(\"single\");\n" +
      "\n" +
      "// Multiple selection\n" +
      "Tree multiTree = new Tree().setSelection(\"multiple\");\n" +
      "\n" +
      "// Leaf selection (only leaves can be selected)\n" +
      "Tree leafTree = new Tree().setSelection(\"leaf\");"
    );
    styleCodeBlock(code);

    demos.add(singleLabel, singleTree, multiLabel, multiTree, leafLabel, leafTree);
    section.add(demos, code);
    return section;
  }

  private FlexLayout createNestedExample() {
    FlexLayout section = createSection(
      "Nested Tree Structure",
      "Trees can be deeply nested to represent complex hierarchies."
    );

    Tree tree = new Tree();

    TreeItem root = new TreeItem("Company").setExpanded(true);

    TreeItem engineering = new TreeItem("Engineering").setExpanded(true);
    TreeItem frontend = new TreeItem("Frontend");
    TreeItem john = new TreeItem("John Doe");
    TreeItem jane = new TreeItem("Jane Smith");
    frontend.addTreeItem(john).addTreeItem(jane);

    TreeItem backend = new TreeItem("Backend");
    TreeItem bob = new TreeItem("Bob Johnson");
    TreeItem alice = new TreeItem("Alice Brown");
    backend.addTreeItem(bob).addTreeItem(alice);

    engineering.addTreeItem(frontend).addTreeItem(backend);

    TreeItem sales = new TreeItem("Sales");
    TreeItem domestic = new TreeItem("Domestic");
    TreeItem international = new TreeItem("International");
    sales.addTreeItem(domestic).addTreeItem(international);

    root.addTreeItem(engineering).addTreeItem(sales);
    tree.addTreeItem(root);

    Div code = new Div();
    code.setText(
      "TreeItem root = new TreeItem(\"Company\").setExpanded(true);\n" +
      "\n" +
      "TreeItem engineering = new TreeItem(\"Engineering\").setExpanded(true);\n" +
      "TreeItem frontend = new TreeItem(\"Frontend\");\n" +
      "frontend.addTreeItem(new TreeItem(\"John Doe\"))\n" +
      "        .addTreeItem(new TreeItem(\"Jane Smith\"));\n" +
      "\n" +
      "engineering.addTreeItem(frontend).addTreeItem(backend);\n" +
      "root.addTreeItem(engineering).addTreeItem(sales);"
    );
    styleCodeBlock(code);

    section.add(tree, code);
    return section;
  }

  private FlexLayout createEventHandlingExample() {
    FlexLayout section = createSection(
      "Event Handling",
      "Trees fire events when items are selected, expanded, or collapsed."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Interactive tree demo
    FlexLayout treeContainer = new FlexLayout();
    treeContainer.setDirection(FlexDirection.COLUMN);
    treeContainer.setSpacing("15px");
    treeContainer.setStyle("border", "1px solid #dee2e6")
                 .setStyle("border-radius", "8px")
                 .setStyle("padding", "20px")
                 .setStyle("background", "#f8f9fa");

    H3 demoTitle = new H3("Interactive Tree Demo");
    
    Tree eventTree = new Tree();
    eventTree.setSelection("single");

    TreeItem projectRoot = new TreeItem("Project Files").setExpanded(true);
    
    TreeItem srcFolder = new TreeItem("src");
    TreeItem mainJava = new TreeItem("Main.java");
    TreeItem utilsJava = new TreeItem("Utils.java");
    srcFolder.addTreeItem(mainJava).addTreeItem(utilsJava);
    
    TreeItem testFolder = new TreeItem("test");
    TreeItem testJava = new TreeItem("MainTest.java");
    testFolder.addTreeItem(testJava);
    
    TreeItem configFile = new TreeItem("config.json");
    TreeItem readmeFile = new TreeItem("README.md");
    
    projectRoot.addTreeItem(srcFolder)
               .addTreeItem(testFolder)
               .addTreeItem(configFile)
               .addTreeItem(readmeFile);
    
    eventTree.addTreeItem(projectRoot);

    // Event feedback labels
    Label selectionLabel = new Label("Selection: None");
    selectionLabel.setStyle("font-size", "14px")
                  .setStyle("color", "#6c757d");

    Label expandLabel = new Label("Last Action: None");
    expandLabel.setStyle("font-size", "14px")
               .setStyle("color", "#6c757d");

    // Add event listeners for tree
    eventTree.onSelectionChange(event -> {
      List<TreeItem> selectedItems = event.getSelection();
      if (!selectedItems.isEmpty()) {
        // In production, this would return actual TreeItem objects
        // For demo, we'll just show a selection was made
        selectionLabel.setText("Selection: Item Selected");
        selectionLabel.setStyle("color", "#28a745");
      } else {
        selectionLabel.setText("Selection: None");
        selectionLabel.setStyle("color", "#6c757d");
      }
    });

    // Add expand/collapse listeners to tree items
    TreeItem docsItem = new TreeItem("Documents");
    docsItem.setExpanded(true);
    docsItem.onExpand(event -> {
      expandLabel.setText("Last Action: Expanded \"" + docsItem.getText() + "\"");
      expandLabel.setStyle("color", "#007bff");
    });
    docsItem.onCollapse(event -> {
      expandLabel.setText("Last Action: Collapsed \"" + docsItem.getText() + "\"");
      expandLabel.setStyle("color", "#6610f2");
    });

    treeContainer.add(demoTitle, eventTree, selectionLabel, expandLabel);

    Div eventsCode = new Div();
    eventsCode.setText(
      "// Tree selection change event\n" +
      "tree.onSelectionChange(event -> {\n" +
      "  List<TreeItem> selectedItems = event.getSelection();\n" +
      "  System.out.println(\"Selected items: \" + selectedItems.size());\n" +
      "  updateSelectionDisplay(selectedItems);\n" +
      "});\n\n" +
      "// TreeItem expand event\n" +
      "treeItem.onExpand(event -> {\n" +
      "  System.out.println(\"Item expanded: \" + event.getComponent().getText());\n" +
      "});\n\n" +
      "// TreeItem collapse event\n" +
      "treeItem.onCollapse(event -> {\n" +
      "  System.out.println(\"Item collapsed: \" + event.getComponent().getText());\n" +
      "});\n\n" +
      "// TreeItem lazy load event\n" +
      "treeItem.onLazyLoad(event -> {\n" +
      "  // Load children asynchronously\n" +
      "  loadChildrenAsync(event.getComponent());\n" +
      "});"
    );
    styleCodeBlock(eventsCode);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    section.add(eventsTable);

    eventsDemo.add(treeContainer, eventsCode);
    section.add(eventsDemo);
    return section;
  }

  private FlexLayout createSection(String title, String description) {
    FlexLayout section = new FlexLayout();
    section.setDirection(FlexDirection.COLUMN);
    section.setSpacing("16px");

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
    FlexLayout container = new FlexLayout();
    container.setDirection(FlexDirection.COLUMN);
    container.setSpacing("16px");

    H2 title = new H2("Properties");

    // Tree properties
    Paragraph treeTitle = new Paragraph("Tree Properties:");
    treeTitle.setStyle("font-weight", "bold");

    FlexLayout treeTable = new FlexLayout();
    treeTable.setDirection(FlexDirection.COLUMN);
    treeTable.setStyle("border", "1px solid #dee2e6")
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
    FlexLayout selectionRow = createTableRow(false);
    selectionRow.add(
      createTableCell("selection", false),
      createTableCell("The selection behavior", false),
      createTableCell("'single' | 'multiple' | 'leaf'", false),
      createTableCell("'single'", false)
    );

    treeTable.add(headerRow, selectionRow);

    // TreeItem properties
    Paragraph itemTitle = new Paragraph("TreeItem Properties:");
    itemTitle.setStyle("font-weight", "bold");
    itemTitle.setStyle("margin-top", "20px");

    FlexLayout itemTable = new FlexLayout();
    itemTable.setDirection(FlexDirection.COLUMN);
    itemTable.setStyle("border", "1px solid #dee2e6")
             .setStyle("border-radius", "8px")
             .setStyle("overflow", "hidden");

    // Header row
    FlexLayout itemHeaderRow = createTableRow(true);
    itemHeaderRow.add(
      createTableCell("Property", true),
      createTableCell("Description", true),
      createTableCell("Type", true),
      createTableCell("Default", true)
    );

    // Data rows
    FlexLayout expandedRow = createTableRow(false);
    expandedRow.add(
      createTableCell("expanded", false),
      createTableCell("Expands the tree item", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout selectedRow = createTableRow(false);
    selectedRow.add(
      createTableCell("selected", false),
      createTableCell("Draws the tree item in a selected state", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout disabledRow = createTableRow(false);
    disabledRow.add(
      createTableCell("disabled", false),
      createTableCell("Disables the tree item", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout lazyRow = createTableRow(false);
    lazyRow.add(
      createTableCell("lazy", false),
      createTableCell("Enables lazy loading behavior", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    itemTable.add(itemHeaderRow, expandedRow, selectedRow, disabledRow, lazyRow);

    container.add(title, treeTitle, treeTable, itemTitle, itemTable);
    return container;
  }

  private FlexLayout createTableRow(boolean isHeader) {
    FlexLayout row = new FlexLayout();
    row.setStyle("display", "flex");
    if (!isHeader) {
      row.setStyle("border-top", "1px solid #dee2e6");
    }
    return row;
  }

  private Div createTableCell(String content, boolean isHeader) {
    Div cell = new Div();
    cell.setText(content);
    cell.setStyle("padding", "12px")
        .setStyle("flex", "1");

    if (isHeader) {
      cell.setStyle("font-weight", "bold")
          .setStyle("background", "#f8f9fa");
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
      {"sl-selection-change", "Emitted when the tree's selection changes", "selection: Array<TreeItem> - The selected tree items"}
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
