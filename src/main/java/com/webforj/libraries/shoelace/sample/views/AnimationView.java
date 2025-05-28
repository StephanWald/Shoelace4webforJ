package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Animation;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.slider.Slider;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/animation", outlet = MainLayout.class)
@FrameTitle("Animation")
public class AnimationView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public AnimationView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Animation");
    Paragraph description = new Paragraph(
      "Animate elements declaratively with nearly 100 baked-in presets, or roll your own " +
      "with CSS. Animations are built on the Web Animations API and can be controlled " +
      "programmatically."
    );

    // Component import and documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Animation.html",
      "https://shoelace.style/components/animation"
    );

    header.add(title, description, docLinks);

    // Basic animations section
    FlexLayout basicExample = createSection(
      "Basic Animations",
      "Use the name property to choose from built-in animations."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    FlexLayout animationsGrid = new FlexLayout();
    animationsGrid.setSpacing("20px");
    animationsGrid.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    // Create sample animations
    String[] animationNames = {"bounce", "pulse", "shake", "flip"};
    for (String name : animationNames) {
      FlexLayout animBox = new FlexLayout();
      animBox.setDirection(FlexDirection.COLUMN);
      animBox.setAlignment(FlexAlignment.CENTER);
      animBox.setSpacing("10px");
      animBox.setStyle("text-align", "center");

      Animation animation = new Animation(name);
      animation.setPlay(true);
      animation.setIterations("Infinity");

      // For spin animation, adjust duration for better visibility
      if (name.equals("spin")) {
        animation.setDuration(2000); // Slower spin
      }

      Div box = new Div();
      box.setStyle("width", "80px");
      box.setStyle("height", "80px");
      box.setStyle("background", "#0969da");
      box.setStyle("border-radius", "8px");
      animation.add(box);

      Div label = new Div(name);
      label.setStyle("font-size", "14px");
      label.setStyle("margin-top", "8px");

      animBox.add(animation, label);
      animationsGrid.add(animBox);
    }

    Div basicCode = new Div();
    basicCode.setText(
      "Animation animation = new Animation(\"bounce\");\n" +
      "animation.setPlay(true);\n" +
      "animation.setIterations(\"Infinity\");\n\n" +
      "// Add content to animate\n" +
      "Div box = new Div();\n" +
      "animation.add(box);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(animationsGrid, basicCode);
    basicExample.add(basicDemo);

    // Animation controls section
    FlexLayout controlsExample = createSection(
      "Animation Controls",
      "Control animations with duration, delay, easing, and more."
    );

    FlexLayout controlsDemo = new FlexLayout();
    controlsDemo.setDirection(FlexDirection.COLUMN);
    controlsDemo.setSpacing("20px");

    // Controlled animation
    Animation controlledAnim = new Animation("rubberBand");
    controlledAnim.setDuration(1000);
    controlledAnim.setIterations(1);

    Div controlledBox = new Div("Animate Me!");
    controlledBox.setStyle("width", "200px");
    controlledBox.setStyle("height", "100px");
    controlledBox.setStyle("background", "#10b981");
    controlledBox.setStyle("color", "white");
    controlledBox.setStyle("display", "flex");
    controlledBox.setStyle("align-items", "center");
    controlledBox.setStyle("justify-content", "center");
    controlledBox.setStyle("border-radius", "12px");
    controlledBox.setStyle("font-weight", "bold");
    controlledBox.setStyle("font-size", "18px");
    controlledAnim.add(controlledBox);

    // Control buttons
    FlexLayout controlButtons = new FlexLayout();
    controlButtons.setSpacing("10px");

    ShoelaceButton playBtn = new ShoelaceButton("Play");
    playBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    playBtn.onClick(e -> {
      controlledAnim.play();
    });

    ShoelaceButton pauseBtn = new ShoelaceButton("Pause");
    pauseBtn.onClick(e -> {
      controlledAnim.pause();
    });

    ShoelaceButton cancelBtn = new ShoelaceButton("Cancel");
    cancelBtn.setVariant(ShoelaceButton.Variant.DANGER);
    cancelBtn.onClick(e -> {
      controlledAnim.cancel();
    });

    controlButtons.add(playBtn, pauseBtn, cancelBtn);

    Div controlsCode = new Div();
    controlsCode.setText(
      "Animation animation = new Animation(\"rubberBand\");\n" +
      "animation.setDuration(1000);\n" +
      "animation.setIterations(1);\n\n" +
      "// Control playback\n" +
      "playBtn.addClickListener(e -> animation.play());\n" +
      "pauseBtn.addClickListener(e -> animation.pause());\n" +
      "cancelBtn.addClickListener(e -> animation.cancel());"
    );
    styleCodeBlock(controlsCode);

    controlsDemo.add(controlledAnim, controlButtons, controlsCode);
    controlsExample.add(controlsDemo);

    // Interactive example
    FlexLayout interactiveExample = createSection(
      "Interactive Example",
      "Customize animation properties to see how they affect the animation."
    );

    FlexLayout interactiveDemo = new FlexLayout();
    interactiveDemo.setDirection(FlexDirection.COLUMN);
    interactiveDemo.setSpacing("20px");

    // Controls
    FlexLayout controls = new FlexLayout();
    controls.setDirection(FlexDirection.COLUMN);
    controls.setSpacing("15px");

    // Animation selector
    ChoiceBox animationChoice = new ChoiceBox();
    animationChoice.setLabel("Animation");
    String[] animations = {
      "bounce", "flash", "pulse", "rubberBand", "shakeX", "shakeY",
      "headShake", "swing", "tada", "wobble", "jello", "heartBeat"
    };
    for (String anim : animations) {
      animationChoice.add(anim, anim);
    }
    animationChoice.selectKey("bounce");

    // Duration slider
    Slider durationSlider = new Slider();
    durationSlider.setMin(200);
    durationSlider.setMax(3000);
    durationSlider.setValue(1000);
    Label durationLabel = new Label("Duration: 1000ms");

    // Iterations selector
    ChoiceBox iterationsChoice = new ChoiceBox();
    iterationsChoice.setLabel("Iterations");
    iterationsChoice.add("1", "1");
    iterationsChoice.add("2", "2");
    iterationsChoice.add("3", "3");
    iterationsChoice.add("Infinity", "Infinite");
    iterationsChoice.selectKey("1");

    // Easing selector
    ChoiceBox easingChoice = new ChoiceBox();
    easingChoice.setLabel("Easing");
    easingChoice.add("linear", "Linear");
    easingChoice.add("ease", "Ease");
    easingChoice.add("ease-in", "Ease In");
    easingChoice.add("ease-out", "Ease Out");
    easingChoice.add("ease-in-out", "Ease In Out");
    easingChoice.selectKey("linear");

    controls.add(animationChoice, durationLabel, durationSlider,
                 iterationsChoice, easingChoice);

    // Interactive animation
    Animation interactiveAnim = new Animation("bounce");
    interactiveAnim.setDuration(1000);

    Div interactiveBox = new Div("🎯");
    interactiveBox.setStyle("width", "150px");
    interactiveBox.setStyle("height", "150px");
    interactiveBox.setStyle("background", "linear-gradient(135deg, #667eea 0%, #764ba2 100%)");
    interactiveBox.setStyle("color", "white");
    interactiveBox.setStyle("display", "flex");
    interactiveBox.setStyle("align-items", "center");
    interactiveBox.setStyle("justify-content", "center");
    interactiveBox.setStyle("border-radius", "16px");
    interactiveBox.setStyle("font-size", "48px");
    interactiveBox.setStyle("box-shadow", "0 10px 30px rgba(0,0,0,0.2)");
    interactiveAnim.add(interactiveBox);

    // Play button
    ShoelaceButton interactivePlayBtn = new ShoelaceButton("Play Animation");
    interactivePlayBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    interactivePlayBtn.setSize(ShoelaceButton.Size.LARGE);
    interactivePlayBtn.onClick(e -> {
      // Reset and play the animation
      interactiveAnim.setPlay(false);
      // Toggle iterations to force reset
      String currentIterations = interactiveAnim.getIterations();
      interactiveAnim.setIterations("0");
      interactiveAnim.setIterations(currentIterations);
      interactiveAnim.setPlay(true);
    });

    // Event handlers
    animationChoice.onSelect(e -> {
      String selected = (String) animationChoice.getSelectedKey();
      interactiveAnim.setName(selected);
    });

    durationSlider.addValueChangeListener(e -> {
      int value = durationSlider.getValue().intValue();
      durationLabel.setText("Duration: " + value + "ms");
      interactiveAnim.setDuration(value);
    });

    iterationsChoice.onSelect(e -> {
      String selected = (String) iterationsChoice.getSelectedKey();
      interactiveAnim.setIterations(selected);
    });

    easingChoice.onSelect(e -> {
      String selected = (String) easingChoice.getSelectedKey();
      interactiveAnim.setEasing(selected);
    });

    // Note: In production, add click handler through JavaScript interop

    FlexLayout animContainer = new FlexLayout();
    animContainer.setAlignment(FlexAlignment.CENTER);
    animContainer.setJustifyContent(com.webforj.component.layout.flexlayout.FlexJustifyContent.CENTER);
    animContainer.setStyle("min-height", "200px");
    animContainer.add(interactiveAnim);

    interactiveDemo.add(controls, animContainer, interactivePlayBtn);
    interactiveExample.add(interactiveDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Animation component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events section
    FlexLayout eventsSection = createSection(
      "Event Handling",
      "Animation components fire events when they start, finish, or are cancelled."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Event demo animation
    Animation eventAnim = new Animation("flipInX");
    eventAnim.setDuration(1500);
    eventAnim.setIterations(1);

    Div eventBox = new Div("Event Demo");
    eventBox.setStyle("width", "200px")
            .setStyle("height", "100px")
            .setStyle("background", "#8b5cf6")
            .setStyle("color", "white")
            .setStyle("display", "flex")
            .setStyle("align-items", "center")
            .setStyle("justify-content", "center")
            .setStyle("border-radius", "12px")
            .setStyle("font-weight", "bold")
            .setStyle("font-size", "18px");
    eventAnim.add(eventBox);

    // Event status display
    FlexLayout eventStatus = new FlexLayout();
    eventStatus.setDirection(FlexDirection.COLUMN)
               .setSpacing("5px")
               .setPadding("15px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border", "1px solid #dee2e6")
               .setStyle("border-radius", "8px")
               .setStyle("min-height", "100px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "13px");

    Label statusLabel = new Label("Animation events will appear here...");
    statusLabel.setStyle("color", "#6c757d");
    eventStatus.add(statusLabel);

    // Control buttons
    FlexLayout eventControls = new FlexLayout();
    eventControls.setSpacing("10px");

    ShoelaceButton startEventBtn = new ShoelaceButton("Start Animation");
    startEventBtn.setVariant(ShoelaceButton.Variant.PRIMARY);

    ShoelaceButton cancelEventBtn = new ShoelaceButton("Cancel Animation");
    cancelEventBtn.setVariant(ShoelaceButton.Variant.DANGER);

    eventControls.add(startEventBtn, cancelEventBtn);

    // Add event handlers
    eventAnim.onStart(event -> {
      Label startLabel = new Label("[" + getTimestamp() + "] Animation started");
      startLabel.setStyle("color", "#10b981");
      eventStatus.add(startLabel);
      if (eventStatus.getComponentCount() > 6) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
    });

    eventAnim.onFinish(event -> {
      Label finishLabel = new Label("[" + getTimestamp() + "] Animation finished");
      finishLabel.setStyle("color", "#0969da");
      eventStatus.add(finishLabel);
      if (eventStatus.getComponentCount() > 6) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
      ((Animation) event.getComponent()).setPlay(false);
    });

    eventAnim.onCancel(event -> {
      Label cancelLabel = new Label("[" + getTimestamp() + "] Animation cancelled");
      cancelLabel.setStyle("color", "#dc2626");
      eventStatus.add(cancelLabel);
      if (eventStatus.getComponentCount() > 6) {
        eventStatus.remove(eventStatus.getComponents().get(1));
      }
    });

    // Wire up buttons
    startEventBtn.onClick(e -> {
      // Reset animation before playing
      eventStatus.removeAll();
      Label readyLabel = new Label("Starting animation...");
      readyLabel.setStyle("color", "#6c757d");
      eventStatus.add(readyLabel);

      eventAnim.setPlay(false);
      // Toggle iterations to force reset
      String currentIterations = eventAnim.getIterations();
      eventAnim.setIterations("0");
      eventAnim.setIterations(currentIterations);
      eventAnim.setPlay(true);
    });

    cancelEventBtn.onClick(e -> {
      eventAnim.cancel();
    });

    Div eventCode = new Div();
    eventCode.setText(
      "// Animation event handlers\n" +
      "animation.onStart(event -> {\n" +
      "    System.out.println(\"Animation started\");\n" +
      "    updateUI();\n" +
      "});\n\n" +
      "animation.onFinish(event -> {\n" +
      "    System.out.println(\"Animation finished\");\n" +
      "    event.getComponent().setPlay(false);\n" +
      "    // Maybe trigger another animation\n" +
      "});\n\n" +
      "animation.onCancel(event -> {\n" +
      "    System.out.println(\"Animation was cancelled\");\n" +
      "    resetUI();\n" +
      "});"
    );
    styleCodeBlock(eventCode);

    eventsDemo.add(eventAnim, eventControls, eventStatus, eventCode);
    eventsSection.add(eventsDemo);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsSection.add(eventsTable);

    // Add all sections to main layout
    self.add(header, basicExample, controlsExample, interactiveExample, eventsSection, propertiesSection);
  }

  private String getTimestamp() {
    return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
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
      {"name", "The animation name", "String", "\"none\""},
      {"play", "Plays/pauses the animation", "boolean", "false"},
      {"delay", "Delay before starting (ms)", "int", "0"},
      {"direction", "Animation direction", "String", "\"normal\""},
      {"duration", "Animation duration (ms)", "int", "1000"},
      {"easing", "Easing function", "String", "\"linear\""},
      {"fill", "Fill mode", "String", "\"auto\""},
      {"iterations", "Number of iterations", "String", "\"Infinity\""},
      {"playbackRate", "Playback speed multiplier", "double", "1.0"}
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
      {"sl-start", "Emitted when the animation starts", "None"},
      {"sl-finish", "Emitted when the animation finishes", "None"},
      {"sl-cancel", "Emitted when the animation is cancelled", "None"}
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
