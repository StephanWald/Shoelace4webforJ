package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.ProgressBar;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/progress-bar", outlet = MainLayout.class)
@FrameTitle("Progress Bar")
public class ProgressBarView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();
  private ProgressBar dynamicProgressBar;
  private int currentProgress = 0;

  public ProgressBarView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Progress Bar");
    Paragraph description = new Paragraph(
      "Progress bars show the completion status of a task or process. " +
      "They can be determinate (showing a specific percentage) or indeterminate " +
      "(showing activity without a specific progress value)."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.ProgressBar;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/ProgressBar.html",
      "https://shoelace.style/components/progress-bar"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic progress bar section
    FlexLayout basicExample = createSection(
      "Basic Progress Bar",
      "A simple progress bar showing completion percentage."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    FlexLayout progressBars = new FlexLayout();
    progressBars.setDirection(FlexDirection.COLUMN);
    progressBars.setSpacing("15px");

    ProgressBar progress0 = new ProgressBar(0);
    ProgressBar progress25 = new ProgressBar(25);
    ProgressBar progress50 = new ProgressBar(50);
    ProgressBar progress75 = new ProgressBar(75);
    ProgressBar progress100 = new ProgressBar(100);

    progressBars.add(
      createLabeledProgress(progress0, "0%"),
      createLabeledProgress(progress25, "25%"),
      createLabeledProgress(progress50, "50%"),
      createLabeledProgress(progress75, "75%"),
      createLabeledProgress(progress100, "100%")
    );

    Div basicCode = new Div();
    basicCode.setText(
      "// Create progress bar with value\n" +
      "ProgressBar progressBar = new ProgressBar(50);\n\n" +
      "// Set value later\n" +
      "progressBar.setValue(75);\n\n" +
      "// Get current value\n" +
      "int value = progressBar.getValue();"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(progressBars, basicCode);
    basicExample.add(basicDemo);

    // Custom styling section
    FlexLayout stylingExample = createSection(
      "Custom Styling",
      "Customize the appearance with colors and height."
    );

    FlexLayout stylingDemo = new FlexLayout();
    stylingDemo.setDirection(FlexDirection.COLUMN);
    stylingDemo.setSpacing("20px");

    FlexLayout styledBars = new FlexLayout();
    styledBars.setDirection(FlexDirection.COLUMN);
    styledBars.setSpacing("15px");

    // Custom height
    ProgressBar thinBar = new ProgressBar(60);
    thinBar.setHeight("4px");

    ProgressBar thickBar = new ProgressBar(60);
    thickBar.setHeight("20px");

    // Custom colors
    ProgressBar greenBar = new ProgressBar(80);
    greenBar.setIndicatorColor("#10b981");

    ProgressBar gradientBar = new ProgressBar(90);
    gradientBar.setIndicatorColor("linear-gradient(to right, #667eea, #764ba2)");

    // Custom track color
    ProgressBar customTrackBar = new ProgressBar(70);
    customTrackBar.setTrackColor("#e3f2fd");
    customTrackBar.setIndicatorColor("#1976d2");

    styledBars.add(
      createLabeledProgress(thinBar, "Thin (4px)"),
      createLabeledProgress(thickBar, "Thick (20px)"),
      createLabeledProgress(greenBar, "Custom Color"),
      createLabeledProgress(gradientBar, "Gradient"),
      createLabeledProgress(customTrackBar, "Custom Track")
    );

    Div stylingCode = new Div();
    stylingCode.setText(
      "// Custom height\n" +
      "progressBar.setHeight(\"4px\");\n" +
      "progressBar.setHeight(\"20px\");\n\n" +
      "// Custom colors\n" +
      "progressBar.setIndicatorColor(\"#10b981\");\n" +
      "progressBar.setIndicatorColor(\"linear-gradient(...)\");\n\n" +
      "// Custom track color\n" +
      "progressBar.setTrackColor(\"#e3f2fd\");\n" +
      "progressBar.setIndicatorColor(\"#1976d2\");"
    );
    styleCodeBlock(stylingCode);

    stylingDemo.add(styledBars, stylingCode);
    stylingExample.add(stylingDemo);

    // Progress with label section
    FlexLayout labelExample = createSection(
      "Progress with Labels",
      "Show percentage or custom text inside the progress bar."
    );

    FlexLayout labelDemo = new FlexLayout();
    labelDemo.setDirection(FlexDirection.COLUMN);
    labelDemo.setSpacing("20px");

    FlexLayout labeledBars = new FlexLayout();
    labeledBars.setDirection(FlexDirection.COLUMN);
    labeledBars.setSpacing("15px");

    // Percentage label
    ProgressBar percentageBar = new ProgressBar(45);
    percentageBar.showPercentage();
    percentageBar.setHeight("24px");

    // Custom text
    ProgressBar loadingBar = new ProgressBar(60);
    loadingBar.setHtml("Loading...");
    loadingBar.setHeight("24px");

    // Step progress
    ProgressBar stepBar = new ProgressBar(33);
    stepBar.setHtml("Step 1 of 3");
    stepBar.setHeight("24px");

    // File upload
    ProgressBar uploadBar = new ProgressBar(85);
    uploadBar.setHtml("8.5 MB / 10 MB");
    uploadBar.setHeight("24px");
    uploadBar.setIndicatorColor("#10b981");

    labeledBars.add(
      percentageBar,
      loadingBar,
      stepBar,
      uploadBar
    );

    Div labelCode = new Div();
    labelCode.setText(
      "// Show percentage\n" +
      "progressBar.showPercentage();\n\n" +
      "// Custom text\n" +
      "progressBar.setHtml(\"Loading...\");\n" +
      "progressBar.setHtml(\"Step 1 of 3\");\n" +
      "progressBar.setHtml(\"8.5 MB / 10 MB\");\n\n" +
      "// Clear content\n" +
      "progressBar.clearContent();"
    );
    styleCodeBlock(labelCode);

    labelDemo.add(labeledBars, labelCode);
    labelExample.add(labelDemo);

    // Indeterminate section
    FlexLayout indeterminateExample = createSection(
      "Indeterminate Progress",
      "Use when the progress amount is unknown."
    );

    FlexLayout indeterminateDemo = new FlexLayout();
    indeterminateDemo.setDirection(FlexDirection.COLUMN);
    indeterminateDemo.setSpacing("20px");

    ProgressBar indeterminateBar = new ProgressBar();
    indeterminateBar.setIndeterminate(true);
    indeterminateBar.setLabel("Loading, please wait...");

    ProgressBar coloredIndeterminate = new ProgressBar();
    coloredIndeterminate.setIndeterminate(true);
    coloredIndeterminate.setIndicatorColor("#dc3545");
    coloredIndeterminate.setHeight("8px");

    FlexLayout indeterminateBars = new FlexLayout();
    indeterminateBars.setDirection(FlexDirection.COLUMN);
    indeterminateBars.setSpacing("15px");
    indeterminateBars.add(indeterminateBar, coloredIndeterminate);

    Div indeterminateCode = new Div();
    indeterminateCode.setText(
      "// Create indeterminate progress\n" +
      "ProgressBar progressBar = new ProgressBar();\n" +
      "progressBar.setIndeterminate(true);\n" +
      "progressBar.setLabel(\"Loading, please wait...\");\n\n" +
      "// Check if indeterminate\n" +
      "boolean isIndeterminate = progressBar.isIndeterminate();"
    );
    styleCodeBlock(indeterminateCode);

    indeterminateDemo.add(indeterminateBars, indeterminateCode);
    indeterminateExample.add(indeterminateDemo);

    // Dynamic progress section
    FlexLayout dynamicExample = createSection(
      "Dynamic Progress",
      "Simulate progress updates over time."
    );

    FlexLayout dynamicDemo = new FlexLayout();
    dynamicDemo.setDirection(FlexDirection.COLUMN);
    dynamicDemo.setSpacing("20px");

    dynamicProgressBar = new ProgressBar(0);
    dynamicProgressBar.showPercentage();
    dynamicProgressBar.setHeight("24px");
    dynamicProgressBar.setIndicatorColor("#0969da");

    FlexLayout controls = new FlexLayout();
    controls.setSpacing("10px");
    controls.setAlignment(FlexAlignment.CENTER);

    ShoelaceButton startBtn = new ShoelaceButton("Start Progress");
    ShoelaceButton resetBtn = new ShoelaceButton("Reset");
    resetBtn.setVariant(ShoelaceButton.Variant.DEFAULT);

    // Note: These would need JavaScript interop to actually animate
    controls.add(startBtn, resetBtn);

    Div dynamicInfo = new Div();
    dynamicInfo.setText("Note: Animation would require JavaScript interop for timer functionality.");
    dynamicInfo.setStyle("color", "#6b7280");
    dynamicInfo.setStyle("font-size", "14px");

    Div dynamicCode = new Div();
    dynamicCode.setText(
      "// Simulate progress updates\n" +
      "ProgressBar progressBar = new ProgressBar(0);\n" +
      "progressBar.showPercentage();\n\n" +
      "// Update progress (would use timer)\n" +
      "for (int i = 0; i <= 100; i += 10) {\n" +
      "  progressBar.setValue(i);\n" +
      "  // Add delay here\n" +
      "}"
    );
    styleCodeBlock(dynamicCode);

    dynamicDemo.add(dynamicProgressBar, controls, dynamicInfo, dynamicCode);
    dynamicExample.add(dynamicDemo);

    // Use cases section
    FlexLayout useCasesExample = createSection(
      "Common Use Cases",
      "Progress bars in different contexts."
    );

    FlexLayout useCasesDemo = new FlexLayout();
    useCasesDemo.setDirection(FlexDirection.COLUMN);
    useCasesDemo.setSpacing("30px");

    // File upload
    FlexLayout uploadCase = createUseCase(
      "File Upload",
      "document.pdf",
      75,
      "7.5 MB / 10 MB",
      "#10b981"
    );

    // Installation
    FlexLayout installCase = createUseCase(
      "Software Installation",
      "Installing components...",
      60,
      "60%",
      "#0969da"
    );

    // Form completion
    FlexLayout formCase = createUseCase(
      "Form Completion",
      "Profile setup",
      80,
      "4 of 5 steps",
      "#8b5cf6"
    );

    useCasesDemo.add(uploadCase, installCase, formCase);
    useCasesExample.add(useCasesDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Progress Bar component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, stylingExample, labelExample,
             indeterminateExample, dynamicExample, useCasesExample, propertiesSection);
  }

  private FlexLayout createLabeledProgress(ProgressBar progressBar, String label) {
    FlexLayout container = new FlexLayout();
    container.setDirection(FlexDirection.COLUMN);
    container.setSpacing("5px");

    Div labelDiv = new Div();
    labelDiv.setText(label);
    labelDiv.setStyle("font-size", "14px");
    labelDiv.setStyle("color", "#6b7280");

    container.add(labelDiv, progressBar);
    return container;
  }

  private FlexLayout createUseCase(String title, String subtitle, int value, String label, String color) {
    FlexLayout useCase = new FlexLayout();
    useCase.setDirection(FlexDirection.COLUMN);
    useCase.setSpacing("10px");
    useCase.setStyle("padding", "16px");
    useCase.setStyle("background", "#f8f9fa");
    useCase.setStyle("border-radius", "8px");

    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("4px");

    Div titleDiv = new Div();
    titleDiv.setText(title);
    titleDiv.setStyle("font-weight", "600");

    Div subtitleDiv = new Div();
    subtitleDiv.setText(subtitle);
    subtitleDiv.setStyle("font-size", "14px");
    subtitleDiv.setStyle("color", "#6b7280");

    header.add(titleDiv, subtitleDiv);

    ProgressBar progressBar = new ProgressBar(value);
    progressBar.setHtml(label);
    progressBar.setHeight("20px");
    progressBar.setIndicatorColor(color);

    useCase.add(header, progressBar);
    return useCase;
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
      {"indeterminate", "Indeterminate state", "boolean", "false"},
      {"label", "Accessibility label", "String", "\"\""},
      {"setValue()", "Sets progress value", "method", "-"},
      {"setIndeterminate()", "Sets indeterminate state", "method", "-"},
      {"setHeight()", "Sets custom height", "method", "-"},
      {"setTrackColor()", "Sets track color", "method", "-"},
      {"setIndicatorColor()", "Sets indicator color", "method", "-"},
      {"showPercentage()", "Shows percentage text", "method", "-"},
      {"clearContent()", "Clears inner content", "method", "-"}
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
