package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Spinner;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/spinner", outlet = MainLayout.class)
@FrameTitle("Spinner")
public class SpinnerView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public SpinnerView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Spinner");
    Paragraph description = new Paragraph(
      "Spinners are used to show the progress of an indeterminate operation."
    );

    Div componentTag = new Div();
    componentTag.setText("import com.webforj.libraries.shoelace.components.Spinner;");
    componentTag.setStyle("background", "#f0f0f0")
               .setStyle("padding", "8px 12px")
               .setStyle("border-radius", "4px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "14px");

    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Spinner.html",
      "https://shoelace.style/components/spinner"
    );

    header.add(title, description, componentTag, docLinks);

    // Basic Spinner example
    FlexLayout basicExample = createSection(
      "Basic Spinner",
      "A basic spinner with default settings."
    );

    FlexLayout basicContainer = new FlexLayout();
    basicContainer.setAlignment(FlexAlignment.CENTER);
    basicContainer.setJustifyContent(FlexJustifyContent.CENTER);
    basicContainer.setStyle("height", "100px");

    Spinner basicSpinner = new Spinner();
    basicContainer.add(basicSpinner);

    Div basicCode = new Div();
    basicCode.setText("Spinner spinner = new Spinner();");
    styleCodeBlock(basicCode);

    basicExample.add(basicContainer, basicCode);

    // Sizes example
    FlexLayout sizesExample = createSection(
      "Sizes",
      "Spinners are sized based on the current font size. Use the setSize() method to scale them."
    );

    FlexLayout sizesContainer = new FlexLayout();
    sizesContainer.setSpacing("40px");
    sizesContainer.setAlignment(FlexAlignment.CENTER);
    sizesContainer.setJustifyContent(FlexJustifyContent.CENTER);

    // Create different sized spinners
    Spinner smallSpinner = Spinner.small();
    Spinner mediumSpinner = Spinner.medium();
    Spinner largeSpinner = Spinner.large();
    Spinner customSpinner = new Spinner().setSize("4rem");

    // Add labels
    FlexLayout smallContainer = createSpinnerWithLabel(smallSpinner, "Small (1rem)");
    FlexLayout mediumContainer = createSpinnerWithLabel(mediumSpinner, "Medium (2rem)");
    FlexLayout largeContainer = createSpinnerWithLabel(largeSpinner, "Large (3rem)");
    FlexLayout customContainer = createSpinnerWithLabel(customSpinner, "Custom (4rem)");

    sizesContainer.add(smallContainer, mediumContainer, largeContainer, customContainer);

    Div sizesCode = new Div();
    sizesCode.setText(
      "// Small spinner\n" +
      "Spinner small = Spinner.small();\n\n" +
      "// Medium spinner\n" +
      "Spinner medium = Spinner.medium();\n\n" +
      "// Large spinner\n" +
      "Spinner large = Spinner.large();\n\n" +
      "// Custom size\n" +
      "Spinner custom = new Spinner().setSize(\"4rem\");"
    );
    styleCodeBlock(sizesCode);

    sizesExample.add(sizesContainer, sizesCode);

    // Track Width example
    FlexLayout trackWidthExample = createSection(
      "Track Width",
      "Use the setTrackWidth() method to set the width of the spinner's track."
    );

    FlexLayout trackWidthContainer = new FlexLayout();
    trackWidthContainer.setSpacing("40px");
    trackWidthContainer.setAlignment(FlexAlignment.CENTER);
    trackWidthContainer.setJustifyContent(FlexJustifyContent.CENTER);

    Spinner thinTrack = new Spinner()
      .setSize("3rem")
      .setTrackWidth("2px");

    Spinner normalTrack = new Spinner()
      .setSize("3rem")
      .setTrackWidth("4px");

    Spinner thickTrack = new Spinner()
      .setSize("3rem")
      .setTrackWidth("8px");

    FlexLayout thinContainer = createSpinnerWithLabel(thinTrack, "2px");
    FlexLayout normalContainer = createSpinnerWithLabel(normalTrack, "4px (default)");
    FlexLayout thickContainer = createSpinnerWithLabel(thickTrack, "8px");

    trackWidthContainer.add(thinContainer, normalContainer, thickContainer);

    Div trackWidthCode = new Div();
    trackWidthCode.setText(
      "// Thin track\n" +
      "Spinner thin = new Spinner()\n" +
      "    .setSize(\"3rem\")\n" +
      "    .setTrackWidth(\"2px\");\n\n" +
      "// Thick track\n" +
      "Spinner thick = new Spinner()\n" +
      "    .setSize(\"3rem\")\n" +
      "    .setTrackWidth(\"8px\");"
    );
    styleCodeBlock(trackWidthCode);

    trackWidthExample.add(trackWidthContainer, trackWidthCode);

    // Colors example
    FlexLayout colorsExample = createSection(
      "Colors",
      "Spinners can be customized with different colors using predefined methods or custom colors."
    );

    FlexLayout colorsContainer = new FlexLayout();
    colorsContainer.setSpacing("40px");
    colorsContainer.setAlignment(FlexAlignment.CENTER);
    colorsContainer.setJustifyContent(FlexJustifyContent.CENTER);

    // Predefined colors
    Spinner primarySpinner = Spinner.primary().setSize("2rem");
    Spinner successSpinner = Spinner.success().setSize("2rem");
    Spinner warningSpinner = Spinner.warning().setSize("2rem");
    Spinner dangerSpinner = Spinner.danger().setSize("2rem");

    // Custom colors
    Spinner customColorSpinner = Spinner.custom("2rem", "#8b5cf6", "#e9d5ff");

    FlexLayout primaryContainer = createSpinnerWithLabel(primarySpinner, "Primary");
    FlexLayout successContainer = createSpinnerWithLabel(successSpinner, "Success");
    FlexLayout warningContainer = createSpinnerWithLabel(warningSpinner, "Warning");
    FlexLayout dangerContainer = createSpinnerWithLabel(dangerSpinner, "Danger");
    FlexLayout customColorContainer = createSpinnerWithLabel(customColorSpinner, "Custom");

    colorsContainer.add(
      primaryContainer,
      successContainer,
      warningContainer,
      dangerContainer,
      customColorContainer
    );

    Div colorsCode = new Div();
    colorsCode.setText(
      "// Predefined colors\n" +
      "Spinner primary = Spinner.primary();\n" +
      "Spinner success = Spinner.success();\n" +
      "Spinner warning = Spinner.warning();\n" +
      "Spinner danger = Spinner.danger();\n\n" +
      "// Custom colors\n" +
      "Spinner custom = Spinner.custom(\"2rem\", \"#8b5cf6\", \"#e9d5ff\");\n\n" +
      "// Or set individually\n" +
      "Spinner spinner = new Spinner()\n" +
      "    .setIndicatorColor(\"#8b5cf6\")\n" +
      "    .setTrackColor(\"#e9d5ff\");"
    );
    styleCodeBlock(colorsCode);

    colorsExample.add(colorsContainer, colorsCode);

    // Speed example
    FlexLayout speedExample = createSection(
      "Animation Speed",
      "Use the setSpeed() method to control the spinner's animation speed."
    );

    FlexLayout speedContainer = new FlexLayout();
    speedContainer.setSpacing("40px");
    speedContainer.setAlignment(FlexAlignment.CENTER);
    speedContainer.setJustifyContent(FlexJustifyContent.CENTER);

    Spinner slowSpinner = new Spinner()
      .setSize("2rem")
      .setSpeed("2s");

    Spinner normalSpinner = new Spinner()
      .setSize("2rem");

    Spinner fastSpinner = new Spinner()
      .setSize("2rem")
      .setSpeed("500ms");

    FlexLayout slowContainer = createSpinnerWithLabel(slowSpinner, "Slow (2s)");
    FlexLayout normalSpeedContainer = createSpinnerWithLabel(normalSpinner, "Normal (1s)");
    FlexLayout fastContainer = createSpinnerWithLabel(fastSpinner, "Fast (500ms)");

    speedContainer.add(slowContainer, normalSpeedContainer, fastContainer);

    Div speedCode = new Div();
    speedCode.setText(
      "// Slow spinner\n" +
      "Spinner slow = new Spinner().setSpeed(\"2s\");\n\n" +
      "// Fast spinner\n" +
      "Spinner fast = new Spinner().setSpeed(\"500ms\");"
    );
    styleCodeBlock(speedCode);

    speedExample.add(speedContainer, speedCode);

    // Practical Examples
    FlexLayout practicalExample = createSection(
      "Practical Examples",
      "Common use cases for spinners in real applications."
    );

    FlexLayout practicalContainer = new FlexLayout();
    practicalContainer.setDirection(FlexDirection.COLUMN);
    practicalContainer.setSpacing("30px");

    // Loading button
    FlexLayout buttonExample = new FlexLayout();
    buttonExample.setDirection(FlexDirection.COLUMN);
    buttonExample.setSpacing("10px");

    Label buttonLabel = new Label("Loading Button");
    buttonLabel.setStyle("font-weight", "600");

    Button loadingButton = new Button("Save");
    loadingButton.setTheme(ButtonTheme.PRIMARY);

    final boolean[] isLoading = {false};
    loadingButton.onClick(e -> {
      if (!isLoading[0]) {
        isLoading[0] = true;
        loadingButton.setText("Saving...");
        loadingButton.setEnabled(false);

        // Simulate async operation
        new Thread(() -> {
          try {
            Thread.sleep(2000);
            loadingButton.setText("Save");
            loadingButton.setEnabled(true);
            isLoading[0] = false;
          } catch (InterruptedException ex) {
            // Handle exception
          }
        }).start();
      }
    });

    buttonExample.add(buttonLabel, loadingButton);

    // Loading overlay
    FlexLayout overlayExample = new FlexLayout();
    overlayExample.setDirection(FlexDirection.COLUMN);
    overlayExample.setSpacing("10px");

    Label overlayLabel = new Label("Loading Overlay");
    overlayLabel.setStyle("font-weight", "600");

    FlexLayout overlayContainer = new FlexLayout();
    overlayContainer.setStyle("position", "relative")
                    .setStyle("width", "300px")
                    .setStyle("height", "150px")
                    .setStyle("background", "#f8f9fa")
                    .setStyle("border", "1px solid #e9ecef")
                    .setStyle("border-radius", "8px");

    // Content
    Div content = new Div();
    content.setText("Content Area");
    content.setStyle("padding", "20px")
           .setStyle("text-align", "center");

    // Loading overlay
    FlexLayout loadingOverlay = new FlexLayout();
    loadingOverlay.setAlignment(FlexAlignment.CENTER);
    loadingOverlay.setJustifyContent(FlexJustifyContent.CENTER);
    loadingOverlay.setStyle("position", "absolute")
                  .setStyle("top", "0")
                  .setStyle("left", "0")
                  .setStyle("right", "0")
                  .setStyle("bottom", "0")
                  .setStyle("background", "rgba(255, 255, 255, 0.8)")
                  .setStyle("backdrop-filter", "blur(1px)");

    Spinner overlaySpinner = new Spinner().setSize("3rem");
    loadingOverlay.add(overlaySpinner);

    overlayContainer.add(content, loadingOverlay);
    overlayExample.add(overlayLabel, overlayContainer);

    // Inline loading
    FlexLayout inlineExample = new FlexLayout();
    inlineExample.setDirection(FlexDirection.COLUMN);
    inlineExample.setSpacing("10px");

    Label inlineLabel = new Label("Inline Loading");
    inlineLabel.setStyle("font-weight", "600");

    FlexLayout inlineContainer = new FlexLayout();
    inlineContainer.setAlignment(FlexAlignment.CENTER);
    inlineContainer.setSpacing("10px");

    Div inlineText = new Div();
    inlineText.setText("Loading data");

    Spinner inlineSpinner = new Spinner().setSize("1rem");

    inlineContainer.add(inlineText, inlineSpinner);
    inlineExample.add(inlineLabel, inlineContainer);

    practicalContainer.add(buttonExample, overlayExample, inlineExample);

    Div practicalCode = new Div();
    practicalCode.setText(
      "// Loading button\n" +
      "Button button = new Button(\"Save\");\n" +
      "button.onClick(e -> {\n" +
      "    button.setText(\"\");\n" +
      "    button.add(new Spinner().setSize(\"1.2rem\"));\n" +
      "    button.setEnabled(false);\n" +
      "});\n\n" +
      "// Loading overlay\n" +
      "FlexLayout overlay = new FlexLayout();\n" +
      "overlay.setStyle(\"position\", \"absolute\")\n" +
      "       .setStyle(\"background\", \"rgba(255, 255, 255, 0.8)\");\n" +
      "overlay.add(new Spinner().setSize(\"3rem\"));"
    );
    styleCodeBlock(practicalCode);

    practicalExample.add(practicalContainer, practicalCode);

    // Add all sections to the main layout
    self.add(
      header,
      basicExample,
      sizesExample,
      trackWidthExample,
      colorsExample,
      speedExample,
      practicalExample
    );
  }

  private FlexLayout createSpinnerWithLabel(Spinner spinner, String labelText) {
    FlexLayout container = new FlexLayout();
    container.setDirection(FlexDirection.COLUMN);
    container.setAlignment(FlexAlignment.CENTER);
    container.setSpacing("10px");

    Label label = new Label(labelText);
    label.setStyle("font-size", "14px")
         .setStyle("color", "#64748b");

    container.add(spinner, label);
    return container;
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
