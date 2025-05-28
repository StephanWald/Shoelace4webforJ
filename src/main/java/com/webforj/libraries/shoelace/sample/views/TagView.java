package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Tag;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/tag", outlet = MainLayout.class)
@FrameTitle("Tag")
public class TagView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public TagView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Tag");
    Paragraph description = new Paragraph(
      "Tags are used as labels to organize things or to indicate a selection. " +
      "They support different variants, sizes, and can be removable."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.Tag;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "8px 12px")
               .setStyle("border-radius", "4px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "14px");

    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Tag.html",
      "https://shoelace.style/components/tag"
    );

    header.add(title, description, componentTag, docLinks);

    // Variants section
    FlexLayout variantsExample = createSection(
      "Variants",
      "Set the variant attribute to change the tag's appearance."
    );

    FlexLayout variantsDemo = new FlexLayout();
    variantsDemo.setSpacing("10px");
    variantsDemo.setWrap(FlexWrap.WRAP);
    variantsDemo.setAlignment(FlexAlignment.CENTER);

    Tag primaryTag = new Tag("Primary").setVariant("primary");
    Tag successTag = new Tag("Success").setVariant("success");
    Tag neutralTag = new Tag("Neutral").setVariant("neutral");
    Tag warningTag = new Tag("Warning").setVariant("warning");
    Tag dangerTag = new Tag("Danger").setVariant("danger");
    Tag textTag = new Tag("Text").setVariant("text");

    Div variantsCode = new Div();
    variantsCode.setText(
      "Tag primaryTag = new Tag(\"Primary\").setVariant(\"primary\");\n" +
      "Tag successTag = new Tag(\"Success\").setVariant(\"success\");\n" +
      "Tag neutralTag = new Tag(\"Neutral\").setVariant(\"neutral\");\n" +
      "Tag warningTag = new Tag(\"Warning\").setVariant(\"warning\");\n" +
      "Tag dangerTag = new Tag(\"Danger\").setVariant(\"danger\");\n" +
      "Tag textTag = new Tag(\"Text\").setVariant(\"text\");"
    );
    styleCodeBlock(variantsCode);

    variantsDemo.add(primaryTag, successTag, neutralTag, warningTag, dangerTag, textTag);
    variantsExample.add(variantsDemo, variantsCode);

    // Sizes section
    FlexLayout sizesExample = createSection(
      "Sizes",
      "Use the size attribute to change a tag's size."
    );

    FlexLayout sizesDemo = new FlexLayout();
    sizesDemo.setSpacing("10px");
    sizesDemo.setAlignment(FlexAlignment.CENTER);

    Tag smallTag = new Tag("Small").setSize("small");
    Tag mediumTag = new Tag("Medium").setSize("medium");
    Tag largeTag = new Tag("Large").setSize("large");

    Div sizesCode = new Div();
    sizesCode.setText(
      "Tag smallTag = new Tag(\"Small\").setSize(\"small\");\n" +
      "Tag mediumTag = new Tag(\"Medium\").setSize(\"medium\");\n" +
      "Tag largeTag = new Tag(\"Large\").setSize(\"large\");"
    );
    styleCodeBlock(sizesCode);

    sizesDemo.add(smallTag, mediumTag, largeTag);
    sizesExample.add(sizesDemo, sizesCode);

    // Pills section
    FlexLayout pillsExample = createSection(
      "Pills",
      "Use the pill attribute to give tags rounded edges."
    );

    FlexLayout pillsDemo = new FlexLayout();
    pillsDemo.setSpacing("10px");
    pillsDemo.setWrap(FlexWrap.WRAP);
    pillsDemo.setAlignment(FlexAlignment.CENTER);

    Tag pillPrimary = new Tag("Primary Pill").setVariant("primary").setPill(true);
    Tag pillSuccess = new Tag("Success Pill").setVariant("success").setPill(true);
    Tag pillNeutral = new Tag("Neutral Pill").setVariant("neutral").setPill(true);
    Tag pillWarning = new Tag("Warning Pill").setVariant("warning").setPill(true);
    Tag pillDanger = new Tag("Danger Pill").setVariant("danger").setPill(true);

    Div pillsCode = new Div();
    pillsCode.setText(
      "Tag pillTag = new Tag(\"Primary Pill\")\n" +
      "    .setVariant(\"primary\")\n" +
      "    .setPill(true);"
    );
    styleCodeBlock(pillsCode);

    pillsDemo.add(pillPrimary, pillSuccess, pillNeutral, pillWarning, pillDanger);
    pillsExample.add(pillsDemo, pillsCode);

    // Removable tags section
    FlexLayout removableExample = createSection(
      "Removable Tags",
      "Use the removable attribute to add a remove button to the tag."
    );

    FlexLayout removableDemo = new FlexLayout();
    removableDemo.setSpacing("10px");
    removableDemo.setWrap(FlexWrap.WRAP);
    removableDemo.setAlignment(FlexAlignment.CENTER);

    Tag removable1 = new Tag("Tag 1").setRemovable(true);
    Tag removable2 = new Tag("Tag 2").setRemovable(true).setVariant("primary");
    Tag removable3 = new Tag("Tag 3").setRemovable(true).setVariant("success");
    Tag removable4 = new Tag("Tag 4").setRemovable(true).setVariant("warning");
    Tag removable5 = new Tag("Tag 5").setRemovable(true).setVariant("danger");

    // Note: Event listeners would need to be implemented in the Tag component

    Div removableCode = new Div();
    removableCode.setText(
      "Tag removableTag = new Tag(\"Removable\")\n" +
      "    .setRemovable(true);\n\n" +
      "// Note: The removable button shows an X icon\n" +
      "// Event handling would need to be implemented\n" +
      "// in the Tag component for full functionality"
    );
    styleCodeBlock(removableCode);

    removableDemo.add(removable1, removable2, removable3, removable4, removable5);
    removableExample.add(removableDemo, removableCode);

    // Use cases section
    FlexLayout useCasesExample = createSection(
      "Use Cases",
      "Tags are versatile and can be used in many different contexts."
    );

    FlexLayout useCasesContent = new FlexLayout();
    useCasesContent.setDirection(FlexDirection.COLUMN);
    useCasesContent.setSpacing("20px");

    // Status indicators
    Paragraph statusLabel = new Paragraph("Status indicators:");
    statusLabel.setStyle("font-weight", "600");

    FlexLayout statusDemo = new FlexLayout();
    statusDemo.setSpacing("10px");
    statusDemo.setAlignment(FlexAlignment.CENTER);
    statusDemo.add(
      new Tag("Active").setVariant("success"),
      new Tag("Pending").setVariant("warning"),
      new Tag("Inactive").setVariant("neutral"),
      new Tag("Error").setVariant("danger")
    );

    // Categories
    Paragraph categoryLabel = new Paragraph("Categories:");
    categoryLabel.setStyle("font-weight", "600");

    FlexLayout categoryDemo = new FlexLayout();
    categoryDemo.setSpacing("10px");
    categoryDemo.setWrap(FlexWrap.WRAP);
    categoryDemo.setAlignment(FlexAlignment.CENTER);
    categoryDemo.add(
      new Tag("Documentation").setVariant("primary").setPill(true),
      new Tag("Tutorial").setVariant("primary").setPill(true),
      new Tag("API Reference").setVariant("primary").setPill(true),
      new Tag("Examples").setVariant("primary").setPill(true)
    );

    // User selections
    Paragraph selectionLabel = new Paragraph("User selections (removable):");
    selectionLabel.setStyle("font-weight", "600");

    FlexLayout selectionDemo = new FlexLayout();
    selectionDemo.setSpacing("10px");
    selectionDemo.setWrap(FlexWrap.WRAP);
    selectionDemo.setAlignment(FlexAlignment.CENTER);

    String[] skills = {"JavaScript", "TypeScript", "React", "Vue", "Angular"};
    for (String skill : skills) {
      Tag skillTag = new Tag(skill).setRemovable(true);
      selectionDemo.add(skillTag);
    }

    useCasesContent.add(statusLabel, statusDemo, categoryLabel, categoryDemo, selectionLabel, selectionDemo);
    useCasesExample.add(useCasesContent);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Tag component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, variantsExample, sizesExample, pillsExample,
             removableExample, useCasesExample, propertiesSection);
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
    FlexLayout variantRow = createTableRow(false);
    variantRow.add(
      createTableCell("variant", false),
      createTableCell("The tag's theme variant", false),
      createTableCell("String", false),
      createTableCell("\"neutral\"", false)
    );

    FlexLayout sizeRow = createTableRow(false);
    sizeRow.add(
      createTableCell("size", false),
      createTableCell("The tag's size", false),
      createTableCell("String", false),
      createTableCell("\"medium\"", false)
    );

    FlexLayout pillRow = createTableRow(false);
    pillRow.add(
      createTableCell("pill", false),
      createTableCell("Draws a pill-style tag with rounded edges", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout removableRow = createTableRow(false);
    removableRow.add(
      createTableCell("removable", false),
      createTableCell("Makes the tag removable", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    table.add(headerRow, variantRow, sizeRow, pillRow, removableRow);
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
