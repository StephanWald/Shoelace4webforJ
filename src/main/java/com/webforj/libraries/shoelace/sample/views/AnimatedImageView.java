package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.AnimatedImage;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/animated-image", outlet = MainLayout.class)
@FrameTitle("Animated Image")
public class AnimatedImageView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public AnimatedImageView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Animated Image");
    Paragraph description = new Paragraph(
      "A component for displaying animated GIFs and WEBPs that play and pause on interaction. " +
      "Unlike the <img> element, the user can control playback, making it ideal for " +
      "accessibility and reducing motion."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.AnimatedImage;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Component import and documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/AnimatedImage.html",
      "https://shoelace.style/components/animated-image"
    );

    header.add(title, description, componentImport, docLinks);

    // Basic example section
    FlexLayout basicExample = createSection(
      "Basic Animated Image",
      "Click the play button to start the animation. Click again to pause."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    AnimatedImage basicAnimated = new AnimatedImage(
      "https://shoelace.style/assets/images/walk.gif",
      "Animation of a shoe walking"
    );
    basicAnimated.setStyle("width", "300px");

    Div basicCode = new Div();
    basicCode.setText(
      "AnimatedImage animated = new AnimatedImage(\n" +
      "  \"https://example.com/animation.gif\",\n" +
      "  \"Description of animation\"\n" +
      ");\n" +
      "animated.setStyle(\"width\", \"300px\");"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicAnimated, basicCode);
    basicExample.add(basicDemo);

    // Auto-play example section
    FlexLayout autoplayExample = createSection(
      "Auto-playing Animation",
      "Set the play property to start the animation automatically."
    );

    FlexLayout autoplayDemo = new FlexLayout();
    autoplayDemo.setDirection(FlexDirection.COLUMN);
    autoplayDemo.setSpacing("20px");

    AnimatedImage autoplayAnimated = new AnimatedImage(
      "https://shoelace.style/assets/images/tie.webp",
      "Animation of a necktie being tied"
    );
    autoplayAnimated.setStyle("width", "300px");
    autoplayAnimated.setPlay(true);

    Div autoplayCode = new Div();
    autoplayCode.setText(
      "AnimatedImage animated = new AnimatedImage(\n" +
      "  \"animation.webp\",\n" +
      "  \"Alt text\"\n" +
      ");\n" +
      "animated.setPlay(true);  // Auto-play"
    );
    styleCodeBlock(autoplayCode);

    autoplayDemo.add(autoplayAnimated, autoplayCode);
    autoplayExample.add(autoplayDemo);

    // Multiple animations section
    FlexLayout multipleExample = createSection(
      "Multiple Animations",
      "You can have multiple animated images with independent controls."
    );

    FlexLayout multipleDemo = new FlexLayout();
    multipleDemo.setDirection(FlexDirection.COLUMN);
    multipleDemo.setSpacing("20px");

    FlexLayout animationsRow = new FlexLayout();
    animationsRow.setSpacing("20px");
    animationsRow.setAlignment(FlexAlignment.CENTER);

    // Create multiple animated images
    String[] animations = {
      "https://shoelace.style/assets/images/walk.gif",
      "https://shoelace.style/assets/images/tie.webp"
    };
    String[] alts = {
      "Walking animation",
      "Tie animation"
    };

    for (int i = 0; i < animations.length; i++) {
      AnimatedImage animated = new AnimatedImage(animations[i], alts[i]);
      animated.setStyle("width", "200px");
      animated.setStyle("height", "200px");
      animated.setStyle("object-fit", "cover");
      animationsRow.add(animated);
    }

    Div multipleCode = new Div();
    multipleCode.setText(
      "// Create multiple independent animations\n" +
      "for (String url : animationUrls) {\n" +
      "  AnimatedImage animated = new AnimatedImage(url, alt);\n" +
      "  animated.setStyle(\"width\", \"200px\");\n" +
      "  container.add(animated);\n" +
      "}"
    );
    styleCodeBlock(multipleCode);

    multipleDemo.add(animationsRow, multipleCode);
    multipleExample.add(multipleDemo);

    // Programmatic control section
    FlexLayout controlExample = createSection(
      "Programmatic Control",
      "Control animations programmatically with play() and pause() methods."
    );

    FlexLayout controlDemo = new FlexLayout();
    controlDemo.setDirection(FlexDirection.COLUMN);
    controlDemo.setSpacing("20px");

    AnimatedImage controlAnimated = new AnimatedImage(
      "https://shoelace.style/assets/images/walk.gif",
      "Controlled animation"
    );
    controlAnimated.setStyle("width", "300px");

    FlexLayout controlButtons = new FlexLayout();
    controlButtons.setSpacing("10px");

    Button playBtn = new Button("Play");
    playBtn.addClickListener(e -> controlAnimated.play());

    Button pauseBtn = new Button("Pause");
    pauseBtn.addClickListener(e -> controlAnimated.pause());

    Button toggleBtn = new Button("Toggle");
    toggleBtn.addClickListener(e ->
      controlAnimated.setPlay(!controlAnimated.isPlaying())
    );

    controlButtons.add(playBtn, pauseBtn, toggleBtn);

    Div controlCode = new Div();
    controlCode.setText(
      "AnimatedImage animated = new AnimatedImage(src, alt);\n\n" +
      "// Control playback\n" +
      "playButton.addClickListener(e -> animated.play());\n" +
      "pauseButton.addClickListener(e -> animated.pause());\n" +
      "toggleButton.addClickListener(e -> \n" +
      "  animated.setPlay(!animated.isPlaying())\n" +
      ");"
    );
    styleCodeBlock(controlCode);

    controlDemo.add(controlAnimated, controlButtons, controlCode);
    controlExample.add(controlDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Animated Image component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Event handling section
    FlexLayout eventsSection = createSection(
      "Event Handling",
      "Animated Images fire events when they load successfully or fail to load."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Create animated images with event handling
    FlexLayout eventImagesRow = new FlexLayout();
    eventImagesRow.setSpacing("20px");
    eventImagesRow.setAlignment(FlexAlignment.START);

    // Success case
    AnimatedImage successImage = new AnimatedImage(
      "https://shoelace.style/assets/images/walk.gif",
      "Successfully loaded animation"
    );
    successImage.setStyle("width", "200px")
                .setStyle("height", "200px")
                .setStyle("object-fit", "cover");

    // Error case (invalid URL)
    AnimatedImage errorImage = new AnimatedImage(
      "https://invalid-url-for-demo.com/nonexistent.gif",
      "Failed to load animation"
    );
    errorImage.setStyle("width", "200px")
              .setStyle("height", "200px")
              .setStyle("object-fit", "cover")
              .setStyle("border", "2px dashed #dee2e6");

    eventImagesRow.add(successImage, errorImage);

    // Event status display
    FlexLayout eventStatus = new FlexLayout();
    eventStatus.setDirection(FlexDirection.COLUMN)
               .setSpacing("5px")
               .setPadding("15px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border", "1px solid #dee2e6")
               .setStyle("border-radius", "8px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "13px")
               .setStyle("min-height", "100px");

    Label statusLabel = new Label("Image events will appear here...");
    statusLabel.setStyle("color", "#6c757d");
    eventStatus.add(statusLabel);

    // Add event handlers
    successImage.onLoad(event -> {
      Label loadLabel = new Label("[" + getTimestamp() + "] sl-load: First image loaded successfully");
      loadLabel.setStyle("color", "#28a745");
      eventStatus.add(loadLabel);
      if (eventStatus.getComponentCount() > 5) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
    });

    successImage.onError(event -> {
      Label errorLabel = new Label("[" + getTimestamp() + "] sl-error: First image failed to load");
      errorLabel.setStyle("color", "#dc3545");
      eventStatus.add(errorLabel);
    });

    errorImage.onLoad(event -> {
      Label loadLabel = new Label("[" + getTimestamp() + "] sl-load: Second image loaded successfully");
      loadLabel.setStyle("color", "#28a745");
      eventStatus.add(loadLabel);
    });

    errorImage.onError(event -> {
      Label errorLabel = new Label("[" + getTimestamp() + "] sl-error: Second image failed to load (expected)");
      errorLabel.setStyle("color", "#dc3545");
      eventStatus.add(errorLabel);
      if (eventStatus.getComponentCount() > 5) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
    });

    // Reload button
    Button reloadBtn = new Button("Reload Images");
    reloadBtn.addClickListener(e -> {
      // Clear status
      eventStatus.removeAll();
      Label clearLabel = new Label("Reloading images...");
      clearLabel.setStyle("color", "#6c757d");
      eventStatus.add(clearLabel);
      
      // Force reload by changing the src with a cache-busting parameter
      String timestamp = "?t=" + System.currentTimeMillis();
      successImage.setSrc("https://shoelace.style/assets/images/walk.gif" + timestamp);
      errorImage.setSrc("https://broken-link.example/image.gif" + timestamp);
    });

    Div eventCode = new Div();
    eventCode.setText(
      "// Handle successful load\n" +
      "animatedImage.onLoad(event -> {\n" +
      "    System.out.println(\"Image loaded: \" + event.getComponent().getSrc());\n" +
      "    enablePlayControls();\n" +
      "});\n\n" +
      "// Handle load errors\n" +
      "animatedImage.onError(event -> {\n" +
      "    System.err.println(\"Failed to load: \" + event.getComponent().getSrc());\n" +
      "    showFallbackContent();\n" +
      "});"
    );
    styleCodeBlock(eventCode);

    eventsDemo.add(eventImagesRow, reloadBtn, eventStatus, eventCode);
    eventsSection.add(eventsDemo);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsSection.add(eventsTable);

    // Add all sections to main layout
    self.add(header, basicExample, autoplayExample, multipleExample,
             controlExample, eventsSection, propertiesSection);
  }

  private String getTimestamp() {
    return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
  }

  private FlexLayout createEventsTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden");

    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
      createTableCell("Event", true),
      createTableCell("Description", true),
      createTableCell("When Fired", true)
    );
    table.add(headerRow);

    // Data rows
    String[][] events = {
      {"sl-load", "onLoad", "When the image loads successfully"},
      {"sl-error", "onError", "When the image fails to load"}
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
    table.add(headerRow);

    // Data rows
    String[][] properties = {
      {"src", "The image source (URL)", "String", "\"\""},
      {"alt", "Alternative text description", "String", "\"\""},
      {"play", "Whether the animation is playing", "boolean", "false"}
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
