package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.ProgressRing;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/progress-ring", outlet = MainLayout.class)
@FrameTitle("Progress Ring")
public class ProgressRingView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public ProgressRingView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Progress Ring");
    Paragraph description = new Paragraph(
      "Progress rings show the completion status of a task in a circular format. " +
      "They're more compact than progress bars and work well in dashboards and cards."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.ProgressRing;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/ProgressRing.html",
      "https://shoelace.style/components/progress-ring"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic progress ring section
    FlexLayout basicExample = createSection(
      "Basic Progress Ring",
      "Simple progress rings showing different completion percentages."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    FlexLayout progressRings = new FlexLayout();
    progressRings.setSpacing("30px");
    progressRings.setAlignment(FlexAlignment.CENTER);
    progressRings.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    ProgressRing ring0 = new ProgressRing(0);
    ring0.showPercentage();

    ProgressRing ring25 = new ProgressRing(25);
    ring25.showPercentage();

    ProgressRing ring50 = new ProgressRing(50);
    ring50.showPercentage();

    ProgressRing ring75 = new ProgressRing(75);
    ring75.showPercentage();

    ProgressRing ring100 = new ProgressRing(100);
    ring100.showPercentage();

    progressRings.add(
      createLabeledRing(ring0, "Empty"),
      createLabeledRing(ring25, "Quarter"),
      createLabeledRing(ring50, "Half"),
      createLabeledRing(ring75, "Three Quarters"),
      createLabeledRing(ring100, "Complete")
    );

    Div basicCode = new Div();
    basicCode.setText(
      "// Create progress ring with value\n" +
      "ProgressRing ring = new ProgressRing(50);\n" +
      "ring.showPercentage();\n\n" +
      "// Set value\n" +
      "ring.setValue(75);\n\n" +
      "// Get value\n" +
      "int value = ring.getValue();"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(progressRings, basicCode);
    basicExample.add(basicDemo);

    // Size variations section
    FlexLayout sizesExample = createSection(
      "Size Variations",
      "Progress rings can be sized to fit different contexts."
    );

    FlexLayout sizesDemo = new FlexLayout();
    sizesDemo.setDirection(FlexDirection.COLUMN);
    sizesDemo.setSpacing("20px");

    FlexLayout sizeRings = new FlexLayout();
    sizeRings.setSpacing("30px");
    sizeRings.setAlignment(FlexAlignment.END);

    ProgressRing smallRing = new ProgressRing(60);
    smallRing.setSize("48px");
    smallRing.showPercentage();

    ProgressRing mediumRing = new ProgressRing(60);
    mediumRing.setSize("80px");
    mediumRing.showPercentage();

    ProgressRing largeRing = new ProgressRing(60);
    largeRing.setSize("120px");
    largeRing.showPercentage();

    ProgressRing xlargeRing = new ProgressRing(60);
    xlargeRing.setSize("200px");
    xlargeRing.showPercentage();

    sizeRings.add(smallRing, mediumRing, largeRing, xlargeRing);

    Div sizesCode = new Div();
    sizesCode.setText(
      "// Set custom size\n" +
      "ring.setSize(\"48px\");   // Small\n" +
      "ring.setSize(\"80px\");   // Medium\n" +
      "ring.setSize(\"120px\");  // Large\n" +
      "ring.setSize(\"200px\");  // Extra large\n\n" +
      "// Using rem units\n" +
      "ring.setSize(\"10rem\");"
    );
    styleCodeBlock(sizesCode);

    sizesDemo.add(sizeRings, sizesCode);
    sizesExample.add(sizesDemo);

    // Custom styling section
    FlexLayout stylingExample = createSection(
      "Custom Styling",
      "Customize colors and stroke widths."
    );

    FlexLayout stylingDemo = new FlexLayout();
    stylingDemo.setDirection(FlexDirection.COLUMN);
    stylingDemo.setSpacing("20px");

    FlexLayout styledRings = new FlexLayout();
    styledRings.setSpacing("30px");
    styledRings.setAlignment(FlexAlignment.CENTER);
    styledRings.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    // Custom color
    ProgressRing greenRing = new ProgressRing(70);
    greenRing.setSize("100px");
    greenRing.setIndicatorColor("#10b981");
    greenRing.showPercentage();

    // Gradient color
    ProgressRing gradientRing = new ProgressRing(85);
    gradientRing.setSize("100px");
    gradientRing.setIndicatorColor("linear-gradient(to right, #667eea, #764ba2)");
    gradientRing.showPercentage();

    // Custom stroke width
    ProgressRing thinRing = new ProgressRing(60);
    thinRing.setSize("100px");
    thinRing.setTrackWidth("2px");
    thinRing.setIndicatorWidth("2px");
    thinRing.showPercentage();

    // Thick stroke
    ProgressRing thickRing = new ProgressRing(45);
    thickRing.setSize("100px");
    thickRing.setTrackWidth("12px");
    thickRing.setIndicatorWidth("12px");
    thickRing.setIndicatorColor("#dc3545");
    thickRing.showPercentage();

    styledRings.add(
      createLabeledRing(greenRing, "Custom Color"),
      createLabeledRing(gradientRing, "Gradient"),
      createLabeledRing(thinRing, "Thin Stroke"),
      createLabeledRing(thickRing, "Thick Stroke")
    );

    Div stylingCode = new Div();
    stylingCode.setText(
      "// Custom colors\n" +
      "ring.setIndicatorColor(\"#10b981\");\n" +
      "ring.setIndicatorColor(\"linear-gradient(...)\");\n\n" +
      "// Custom stroke width\n" +
      "ring.setTrackWidth(\"2px\");\n" +
      "ring.setIndicatorWidth(\"2px\");\n\n" +
      "// Custom track color\n" +
      "ring.setTrackColor(\"#e3f2fd\");"
    );
    styleCodeBlock(stylingCode);

    stylingDemo.add(styledRings, stylingCode);
    stylingExample.add(stylingDemo);

    // Custom content section
    FlexLayout contentExample = createSection(
      "Custom Content",
      "Display custom text or icons inside the ring."
    );

    FlexLayout contentDemo = new FlexLayout();
    contentDemo.setDirection(FlexDirection.COLUMN);
    contentDemo.setSpacing("20px");

    FlexLayout contentRings = new FlexLayout();
    contentRings.setSpacing("30px");
    contentRings.setAlignment(FlexAlignment.CENTER);
    contentRings.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    // Text content
    ProgressRing textRing = new ProgressRing(75);
    textRing.setSize("120px");
    textRing.showText("3/4");
    textRing.setIndicatorColor("#0969da");

    // Icon content
    ProgressRing iconRing = new ProgressRing(100);
    iconRing.setSize("120px");
    iconRing.setHtml("✓");
    iconRing.setStyle("font-size", "48px");
    iconRing.setStyle("color", "#10b981");
    iconRing.setIndicatorColor("#10b981");

    // Loading text
    ProgressRing loadingRing = new ProgressRing(65);
    loadingRing.setSize("120px");
    loadingRing.showText("Loading");
    loadingRing.setStyle("font-size", "14px");

    // Score display
    ProgressRing scoreRing = new ProgressRing(92);
    scoreRing.setSize("120px");
    scoreRing.setHtml("<div style='text-align:center'><div style='font-size:28px;font-weight:bold'>A+</div><div style='font-size:12px;color:#6b7280'>Excellent</div></div>");
    scoreRing.setIndicatorColor("#8b5cf6");

    contentRings.add(
      createLabeledRing(textRing, "Fraction"),
      createLabeledRing(iconRing, "Icon"),
      createLabeledRing(loadingRing, "Loading"),
      createLabeledRing(scoreRing, "Score")
    );

    Div contentCode = new Div();
    contentCode.setText(
      "// Show custom text\n" +
      "ring.showText(\"3/4\");\n" +
      "ring.showText(\"Loading\");\n\n" +
      "// Show HTML content\n" +
      "ring.setHtml(\"✓\");\n" +
      "ring.setHtml(\"<div>A+</div>\");\n\n" +
      "// Clear content\n" +
      "ring.clearContent();"
    );
    styleCodeBlock(contentCode);

    contentDemo.add(contentRings, contentCode);
    contentExample.add(contentDemo);

    // Use cases section
    FlexLayout useCasesExample = createSection(
      "Common Use Cases",
      "Progress rings in practical applications."
    );

    FlexLayout useCasesDemo = new FlexLayout();
    useCasesDemo.setDirection(FlexDirection.COLUMN);
    useCasesDemo.setSpacing("30px");

    FlexLayout useCasesGrid = new FlexLayout();
    useCasesGrid.setSpacing("30px");
    useCasesGrid.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    // Dashboard stats
    FlexLayout statsCase = createStatCard(
      "Storage Used",
      85,
      "8.5 GB / 10 GB",
      "#ef4444"
    );

    // Task completion
    FlexLayout tasksCase = createStatCard(
      "Tasks Completed",
      72,
      "18 / 25",
      "#10b981"
    );

    // Performance score
    FlexLayout scoreCase = createStatCard(
      "Performance Score",
      94,
      "94%",
      "#8b5cf6"
    );

    // Loading state
    FlexLayout loadingCase = createStatCard(
      "Processing",
      65,
      "65%",
      "#0969da"
    );

    useCasesGrid.add(statsCase, tasksCase, scoreCase, loadingCase);
    useCasesExample.add(useCasesGrid);

    // Static helper section
    FlexLayout helperExample = createSection(
      "Static Helper Method",
      "Create styled progress rings with a single method call."
    );

    FlexLayout helperDemo = new FlexLayout();
    helperDemo.setDirection(FlexDirection.COLUMN);
    helperDemo.setSpacing("20px");

    ProgressRing largeCustomRing = ProgressRing.createLarge(78, "150px", "#f59e0b");

    FlexLayout helperContainer = new FlexLayout();
    helperContainer.setJustifyContent(FlexJustifyContent.CENTER);
    helperContainer.add(largeCustomRing);

    Div helperCode = new Div();
    helperCode.setText(
      "// Create large styled ring\n" +
      "ProgressRing ring = ProgressRing.createLarge(\n" +
      "  78,        // value\n" +
      "  \"150px\",   // size\n" +
      "  \"#f59e0b\"  // color\n" +
      ");"
    );
    styleCodeBlock(helperCode);

    helperDemo.add(helperContainer, helperCode);
    helperExample.add(helperDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Progress Ring component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, sizesExample, stylingExample, contentExample,
             useCasesExample, helperExample, propertiesSection);
  }

  private FlexLayout createLabeledRing(ProgressRing ring, String label) {
    FlexLayout container = new FlexLayout();
    container.setDirection(FlexDirection.COLUMN);
    container.setSpacing("10px");
    container.setAlignment(FlexAlignment.CENTER);

    Div labelDiv = new Div();
    labelDiv.setText(label);
    labelDiv.setStyle("font-size", "14px");
    labelDiv.setStyle("color", "#6b7280");
    labelDiv.setStyle("text-align", "center");

    container.add(ring, labelDiv);
    return container;
  }

  private FlexLayout createStatCard(String title, int value, String label, String color) {
    FlexLayout card = new FlexLayout();
    card.setDirection(FlexDirection.COLUMN);
    card.setSpacing("15px");
    card.setAlignment(FlexAlignment.CENTER);
    card.setStyle("padding", "20px");
    card.setStyle("background", "#ffffff");
    card.setStyle("border", "1px solid #e5e7eb");
    card.setStyle("border-radius", "12px");
    card.setStyle("box-shadow", "0 1px 3px rgba(0,0,0,0.1)");
    card.setStyle("min-width", "200px");

    Div titleDiv = new Div();
    titleDiv.setText(title);
    titleDiv.setStyle("font-weight", "600");
    titleDiv.setStyle("color", "#1f2937");

    ProgressRing ring = new ProgressRing(value);
    ring.setSize("100px");
    ring.setIndicatorColor(color);
    ring.showText(label);
    ring.setStyle("font-size", "14px");
    ring.setStyle("font-weight", "500");

    card.add(titleDiv, ring);
    return card;
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
      {"value", "Progress value (0-100)", "int", "0"},
      {"label", "Accessibility label", "String", "\"\""},
      {"setValue()", "Sets progress value", "method", "-"},
      {"setSize()", "Sets ring diameter", "method", "-"},
      {"setTrackWidth()", "Sets track stroke width", "method", "-"},
      {"setIndicatorWidth()", "Sets indicator stroke width", "method", "-"},
      {"setTrackColor()", "Sets track color", "method", "-"},
      {"setIndicatorColor()", "Sets indicator color", "method", "-"},
      {"showPercentage()", "Shows percentage text", "method", "-"},
      {"showText()", "Shows custom text", "method", "-"},
      {"clearContent()", "Clears inner content", "method", "-"},
      {"createLarge()", "Creates styled ring", "static method", "-"}
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
