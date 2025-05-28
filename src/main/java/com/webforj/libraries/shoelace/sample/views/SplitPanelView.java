package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.SplitPanel;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/split-panel", outlet = MainLayout.class)
@FrameTitle("Split Panel")
public class SplitPanelView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public SplitPanelView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Split Panel");
    Paragraph description = new Paragraph(
      "Split panels display two adjacent panels. Dragging the divider allows users to resize the panels."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.SplitPanel;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "8px 12px")
               .setStyle("border-radius", "4px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "14px");

    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/SplitPanel.html",
      "https://shoelace.style/components/split-panel"
    );

    header.add(title, description, componentTag, docLinks);

    // Basic Split Panel example
    FlexLayout basicExample = createSection(
      "Basic Split Panel",
      "Create a horizontal split panel with two resizable sections."
    );

    SplitPanel basicSplit = new SplitPanel();
    basicSplit.setStyle("height", "300px")
              .setStyle("border", "1px solid #e2e8f0")
              .setStyle("border-radius", "8px");

    // Start panel content
    Div startContent = new Div();
    startContent.setText("Start Panel");
    startContent.setStyle("padding", "20px")
                .setStyle("background", "#f0f9ff")
                .setStyle("height", "100%")
                .setStyle("display", "flex")
                .setStyle("align-items", "center")
                .setStyle("justify-content", "center");

    // End panel content
    Div endContent = new Div();
    endContent.setText("End Panel");
    endContent.setStyle("padding", "20px")
              .setStyle("background", "#fef3c7")
              .setStyle("height", "100%")
              .setStyle("display", "flex")
              .setStyle("align-items", "center")
              .setStyle("justify-content", "center");

    basicSplit.addToStart(startContent);
    basicSplit.addToEnd(endContent);

    Div basicCode = new Div();
    basicCode.setText(
      "SplitPanel splitPanel = new SplitPanel();\n\n" +
      "// Add content to start panel\n" +
      "Div startContent = new Div();\n" +
      "startContent.setText(\"Start Panel\");\n" +
      "splitPanel.addToStart(startContent);\n\n" +
      "// Add content to end panel\n" +
      "Div endContent = new Div();\n" +
      "endContent.setText(\"End Panel\");\n" +
      "splitPanel.addToEnd(endContent);"
    );
    styleCodeBlock(basicCode);

    basicExample.add(basicSplit, basicCode);

    // Vertical Split Panel example
    FlexLayout verticalExample = createSection(
      "Vertical Orientation",
      "Use the vertical attribute to create a vertical split panel."
    );

    SplitPanel verticalSplit = SplitPanel.vertical();
    verticalSplit.setStyle("height", "400px")
                 .setStyle("border", "1px solid #e2e8f0")
                 .setStyle("border-radius", "8px");

    // Top panel content
    Div topContent = new Div();
    topContent.setText("Top Panel");
    topContent.setStyle("padding", "20px")
              .setStyle("background", "#f0fdf4")
              .setStyle("height", "100%")
              .setStyle("display", "flex")
              .setStyle("align-items", "center")
              .setStyle("justify-content", "center");

    // Bottom panel content
    Div bottomContent = new Div();
    bottomContent.setText("Bottom Panel");
    bottomContent.setStyle("padding", "20px")
                 .setStyle("background", "#fef2f2")
                 .setStyle("height", "100%")
                 .setStyle("display", "flex")
                 .setStyle("align-items", "center")
                 .setStyle("justify-content", "center");

    verticalSplit.addToStart(topContent);
    verticalSplit.addToEnd(bottomContent);

    Div verticalCode = new Div();
    verticalCode.setText(
      "// Create vertical split panel\n" +
      "SplitPanel verticalSplit = SplitPanel.vertical();\n" +
      "// or\n" +
      "SplitPanel verticalSplit = new SplitPanel();\n" +
      "verticalSplit.setVertical(true);\n\n" +
      "verticalSplit.addToStart(topContent);\n" +
      "verticalSplit.addToEnd(bottomContent);"
    );
    styleCodeBlock(verticalCode);

    verticalExample.add(verticalSplit, verticalCode);

    // Initial Position example
    FlexLayout positionExample = createSection(
      "Initial Position",
      "Set the initial position of the divider using percentage or pixels."
    );

    FlexLayout positionContainer = new FlexLayout();
    positionContainer.setDirection(FlexDirection.COLUMN);
    positionContainer.setSpacing("20px");

    // 70% position
    SplitPanel percentSplit = new SplitPanel();
    percentSplit.setPosition(70);
    percentSplit.setStyle("height", "200px")
                .setStyle("border", "1px solid #e2e8f0")
                .setStyle("border-radius", "8px");

    Div percentStart = createPanelContent("70%", "#e0e7ff");
    Div percentEnd = createPanelContent("30%", "#fce7f3");

    percentSplit.addToStart(percentStart);
    percentSplit.addToEnd(percentEnd);

    // Pixel position
    SplitPanel pixelSplit = new SplitPanel();
    pixelSplit.setPositionInPixels(200);
    pixelSplit.setStyle("height", "200px")
               .setStyle("border", "1px solid #e2e8f0")
               .setStyle("border-radius", "8px");

    Div pixelStart = createPanelContent("200px", "#ddd6fe");
    Div pixelEnd = createPanelContent("Rest", "#fed7aa");

    pixelSplit.addToStart(pixelStart);
    pixelSplit.addToEnd(pixelEnd);

    positionContainer.add(percentSplit, pixelSplit);

    Div positionCode = new Div();
    positionCode.setText(
      "// Set position as percentage\n" +
      "SplitPanel percentSplit = new SplitPanel();\n" +
      "percentSplit.setPosition(70); // 70%\n\n" +
      "// Set position in pixels\n" +
      "SplitPanel pixelSplit = new SplitPanel();\n" +
      "pixelSplit.setPositionInPixels(200); // 200px"
    );
    styleCodeBlock(positionCode);

    positionExample.add(positionContainer, positionCode);

    // Snap Points example
    FlexLayout snapExample = createSection(
      "Snap Points",
      "Define specific positions where the divider will snap to while dragging."
    );

    SplitPanel snapSplit = new SplitPanel();
    snapSplit.setSnap("0% 25% 50% 75% 100%");
    snapSplit.setSnapThreshold(50);
    snapSplit.setStyle("height", "300px")
             .setStyle("border", "1px solid #e2e8f0")
             .setStyle("border-radius", "8px");

    Div snapStart = new Div();
    snapStart.setText("Drag to snap points: 0%, 25%, 50%, 75%, 100%");
    snapStart.setStyle("padding", "20px")
             .setStyle("background", "#ecfccb")
             .setStyle("height", "100%")
             .setStyle("display", "flex")
             .setStyle("align-items", "center")
             .setStyle("justify-content", "center");

    Div snapEnd = new Div();
    snapEnd.setText("Snap threshold: 50px");
    snapEnd.setStyle("padding", "20px")
           .setStyle("background", "#fef9c3")
           .setStyle("height", "100%")
           .setStyle("display", "flex")
           .setStyle("align-items", "center")
           .setStyle("justify-content", "center");

    snapSplit.addToStart(snapStart);
    snapSplit.addToEnd(snapEnd);

    Div snapCode = new Div();
    snapCode.setText(
      "SplitPanel snapSplit = new SplitPanel();\n" +
      "snapSplit.setSnap(\"0% 25% 50% 75% 100%\");\n" +
      "snapSplit.setSnapThreshold(50); // 50px threshold"
    );
    styleCodeBlock(snapCode);

    snapExample.add(snapSplit, snapCode);

    // Primary Panel example
    FlexLayout primaryExample = createSection(
      "Primary Panel",
      "Set which panel maintains its size when the split panel is resized."
    );

    FlexLayout primaryContainer = new FlexLayout();
    primaryContainer.setDirection(FlexDirection.COLUMN);
    primaryContainer.setSpacing("20px");

    // Primary start
    SplitPanel primaryStartSplit = new SplitPanel();
    primaryStartSplit.setPrimary(SplitPanel.Primary.START);
    primaryStartSplit.setPosition(30);
    primaryStartSplit.setStyle("height", "200px")
                     .setStyle("border", "1px solid #e2e8f0")
                     .setStyle("border-radius", "8px");

    Div primaryStartContent = createPanelContent("Primary (fixed)", "#bfdbfe");
    Div primaryStartEnd = createPanelContent("Resizes", "#fbbf24");

    primaryStartSplit.addToStart(primaryStartContent);
    primaryStartSplit.addToEnd(primaryStartEnd);

    // Primary end
    SplitPanel primaryEndSplit = new SplitPanel();
    primaryEndSplit.setPrimary(SplitPanel.Primary.END);
    primaryEndSplit.setPosition(70);
    primaryEndSplit.setStyle("height", "200px")
                   .setStyle("border", "1px solid #e2e8f0")
                   .setStyle("border-radius", "8px");

    Div primaryEndStart = createPanelContent("Resizes", "#a7f3d0");
    Div primaryEndContent = createPanelContent("Primary (fixed)", "#6ee7b7");

    primaryEndSplit.addToStart(primaryEndStart);
    primaryEndSplit.addToEnd(primaryEndContent);

    primaryContainer.add(
      new Label("Primary: start"),
      primaryStartSplit,
      new Label("Primary: end"),
      primaryEndSplit
    );

    Div primaryCode = new Div();
    primaryCode.setText(
      "// Start panel is primary (maintains size)\n" +
      "SplitPanel primaryStart = new SplitPanel();\n" +
      "primaryStart.setPrimary(SplitPanel.Primary.START);\n\n" +
      "// End panel is primary (maintains size)\n" +
      "SplitPanel primaryEnd = new SplitPanel();\n" +
      "primaryEnd.setPrimary(SplitPanel.Primary.END);"
    );
    styleCodeBlock(primaryCode);

    primaryExample.add(primaryContainer, primaryCode);

    // Disabled State example
    FlexLayout disabledExample = createSection(
      "Disabled State",
      "Disable the split panel to prevent resizing."
    );

    SplitPanel disabledSplit = new SplitPanel();
    disabledSplit.setDisabled(true);
    disabledSplit.setPosition(50);
    disabledSplit.setStyle("height", "200px")
                 .setStyle("border", "1px solid #e2e8f0")
                 .setStyle("border-radius", "8px");

    Div disabledStart = createPanelContent("Cannot resize", "#e5e7eb");
    Div disabledEnd = createPanelContent("Disabled", "#e5e7eb");

    disabledSplit.addToStart(disabledStart);
    disabledSplit.addToEnd(disabledEnd);

    Div disabledCode = new Div();
    disabledCode.setText(
      "SplitPanel disabledSplit = new SplitPanel();\n" +
      "disabledSplit.setDisabled(true);"
    );
    styleCodeBlock(disabledCode);

    disabledExample.add(disabledSplit, disabledCode);

    // Custom Styling example
    FlexLayout stylingExample = createSection(
      "Custom Styling",
      "Customize the divider appearance and constraints."
    );

    SplitPanel styledSplit = new SplitPanel();
    styledSplit.setPosition(50);
    styledSplit.setStyle("height", "300px")
               .setStyle("border", "1px solid #e2e8f0")
               .setStyle("border-radius", "8px");

    // Custom divider styling
    styledSplit.setDividerWidth("8px");
    styledSplit.setDividerHitArea("20px");
    styledSplit.setMin("20%");
    styledSplit.setMax("80%");

    Div styledStart = new Div();
    styledStart.setText("Min: 20%");
    styledStart.setStyle("padding", "20px")
               .setStyle("background", "#c7d2fe")
               .setStyle("height", "100%")
               .setStyle("display", "flex")
               .setStyle("align-items", "center")
               .setStyle("justify-content", "center");

    Div styledEnd = new Div();
    styledEnd.setText("Max: 80%");
    styledEnd.setStyle("padding", "20px")
             .setStyle("background", "#fde047")
             .setStyle("height", "100%")
             .setStyle("display", "flex")
             .setStyle("align-items", "center")
             .setStyle("justify-content", "center");

    styledSplit.addToStart(styledStart);
    styledSplit.addToEnd(styledEnd);

    Div stylingCode = new Div();
    stylingCode.setText(
      "SplitPanel styledSplit = new SplitPanel();\n\n" +
      "// Customize divider\n" +
      "styledSplit.setDividerWidth(\"8px\");\n" +
      "styledSplit.setDividerHitArea(\"20px\");\n\n" +
      "// Set constraints\n" +
      "styledSplit.setMin(\"20%\");\n" +
      "styledSplit.setMax(\"80%\");"
    );
    styleCodeBlock(stylingCode);

    stylingExample.add(styledSplit, stylingCode);

    // Add all sections to the main layout
    self.add(
      header,
      basicExample,
      verticalExample,
      positionExample,
      snapExample,
      primaryExample,
      disabledExample,
      stylingExample
    );
  }

  private Div createPanelContent(String text, String color) {
    Div content = new Div();
    content.setText(text);
    content.setStyle("padding", "20px")
           .setStyle("background", color)
           .setStyle("height", "100%")
           .setStyle("display", "flex")
           .setStyle("align-items", "center")
           .setStyle("justify-content", "center")
           .setStyle("font-weight", "500");
    return content;
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
        .setStyle("font-family", "monospace")
        .setStyle("font-size", "14px")
        .setStyle("white-space", "pre")
        .setStyle("overflow-x", "auto")
        .setStyle("border", "1px solid #e9ecef");
  }
}
