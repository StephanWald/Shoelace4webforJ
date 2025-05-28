package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Radio;
import com.webforj.libraries.shoelace.components.RadioButton;
import com.webforj.libraries.shoelace.components.RadioGroup;
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

@Route(value = "/radio-group", outlet = MainLayout.class)
@FrameTitle("Radio Group")
public class RadioGroupView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public RadioGroupView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Radio Group");
    Paragraph description = new Paragraph(
      "Radio groups are used to group multiple radios or radio buttons so they function as a single form control."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.RadioGroup;\nimport com.webforj.libraries.shoelace.components.Radio;\nimport com.webforj.libraries.shoelace.components.RadioButton;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("white-space", "pre")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/RadioGroup.html",
      "https://shoelace.style/components/radio-group"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic Radio Group example
    FlexLayout basicExample = createSection(
      "Basic Radio Group",
      "A basic radio group with standard radio inputs."
    );

    RadioGroup basicGroup = new RadioGroup("Select your favorite fruit");
    basicGroup.setHelpText("Choose the fruit you like best");
    basicGroup.addRadio(new Radio("Apple", "apple"));
    basicGroup.addRadio(new Radio("Banana", "banana"));
    basicGroup.addRadio(new Radio("Orange", "orange"));
    basicGroup.addRadio(new Radio("Grape", "grape"));

    Label selectedValue1 = new Label("Selected: (changes will be tracked via sl-change event)");

    Div basicCode = new Div();
    basicCode.setText(
      "RadioGroup group = new RadioGroup(\"Select your favorite fruit\");\n" +
      "group.setHelpText(\"Choose the fruit you like best\");\n" +
      "group.addRadio(new Radio(\"Apple\", \"apple\"));\n" +
      "group.addRadio(new Radio(\"Banana\", \"banana\"));\n" +
      "group.addRadio(new Radio(\"Orange\", \"orange\"));\n" +
      "group.addRadio(new Radio(\"Grape\", \"grape\"));\n\n" +
      "// Listen for changes\n" +
      "group.addEventListener(\"sl-change\", e -> {\n" +
      "    System.out.println(\"Selected: \" + group.getValue());\n" +
      "});"
    );
    styleCodeBlock(basicCode);

    basicExample.add(basicGroup, selectedValue1, basicCode);

    // Radio Buttons example
    FlexLayout radioButtonExample = createSection(
      "Radio Buttons",
      "Radio buttons offer an alternate way to display radio controls. They're perfect for nav items, filtering, and more."
    );

    RadioGroup buttonGroup = new RadioGroup("Select your plan");
    buttonGroup.addRadioButton(new RadioButton("Free", "free"));
    buttonGroup.addRadioButton(new RadioButton("Basic ($9/mo)", "basic"));
    buttonGroup.addRadioButton(new RadioButton("Pro ($19/mo)", "pro"));
    buttonGroup.addRadioButton(new RadioButton("Enterprise", "enterprise"));

    Label selectedValue2 = new Label("Selected plan: (changes will be tracked via sl-change event)");

    Div radioButtonCode = new Div();
    radioButtonCode.setText(
      "RadioGroup buttonGroup = new RadioGroup(\"Select your plan\");\n" +
      "buttonGroup.addRadioButton(new RadioButton(\"Free\", \"free\"));\n" +
      "buttonGroup.addRadioButton(new RadioButton(\"Basic ($9/mo)\", \"basic\"));\n" +
      "buttonGroup.addRadioButton(new RadioButton(\"Pro ($19/mo)\", \"pro\"));\n" +
      "buttonGroup.addRadioButton(new RadioButton(\"Enterprise\", \"enterprise\"));"
    );
    styleCodeBlock(radioButtonCode);

    radioButtonExample.add(buttonGroup, selectedValue2, radioButtonCode);

    // Sizes example
    FlexLayout sizesExample = createSection(
      "Sizes",
      "Radio groups can be small, medium, or large. This size will be applied to all child radios and radio buttons."
    );

    FlexLayout sizesContainer = new FlexLayout();
    sizesContainer.setDirection(FlexDirection.COLUMN);
    sizesContainer.setSpacing("30px");

    // Small size
    RadioGroup smallGroup = new RadioGroup("Small");
    smallGroup.setSize(RadioGroup.Size.SMALL);
    smallGroup.addRadio(new Radio("Option 1", "1"));
    smallGroup.addRadio(new Radio("Option 2", "2"));
    smallGroup.addRadio(new Radio("Option 3", "3"));

    // Medium size
    RadioGroup mediumGroup = new RadioGroup("Medium");
    mediumGroup.setSize(RadioGroup.Size.MEDIUM);
    mediumGroup.addRadio(new Radio("Option 1", "1"));
    mediumGroup.addRadio(new Radio("Option 2", "2"));
    mediumGroup.addRadio(new Radio("Option 3", "3"));

    // Large size
    RadioGroup largeGroup = new RadioGroup("Large");
    largeGroup.setSize(RadioGroup.Size.LARGE);
    largeGroup.addRadio(new Radio("Option 1", "1"));
    largeGroup.addRadio(new Radio("Option 2", "2"));
    largeGroup.addRadio(new Radio("Option 3", "3"));

    sizesContainer.add(smallGroup, mediumGroup, largeGroup);

    Div sizesCode = new Div();
    sizesCode.setText(
      "// Small radio group\n" +
      "RadioGroup smallGroup = new RadioGroup(\"Small\");\n" +
      "smallGroup.setSize(RadioGroup.Size.SMALL);\n\n" +
      "// Medium radio group (default)\n" +
      "RadioGroup mediumGroup = new RadioGroup(\"Medium\");\n" +
      "mediumGroup.setSize(RadioGroup.Size.MEDIUM);\n\n" +
      "// Large radio group\n" +
      "RadioGroup largeGroup = new RadioGroup(\"Large\");\n" +
      "largeGroup.setSize(RadioGroup.Size.LARGE);"
    );
    styleCodeBlock(sizesCode);

    sizesExample.add(sizesContainer, sizesCode);

    // Disabled and Required example
    FlexLayout statesExample = createSection(
      "States",
      "Radio groups can be disabled or marked as required."
    );

    FlexLayout statesContainer = new FlexLayout();
    statesContainer.setSpacing("40px");

    // Disabled group
    RadioGroup disabledGroup = new RadioGroup("Disabled Group");
    disabledGroup.add(new Radio("Option 1", "1").setDisabled(true));
    disabledGroup.add(new Radio("Option 2", "2").setDisabled(true));
    disabledGroup.add(new Radio("Option 3", "3").setDisabled(true));

    // Required group
    RadioGroup requiredGroup = new RadioGroup("Required Group");
    requiredGroup.setRequired(true);
    requiredGroup.setHelpText("This selection is required");
    requiredGroup.addRadio(new Radio("Yes", "yes"));
    requiredGroup.addRadio(new Radio("No", "no"));

    statesContainer.add(disabledGroup, requiredGroup);

    Div statesCode = new Div();
    statesCode.setText(
      "// Disabled radio group\n" +
      "RadioGroup disabledGroup = new RadioGroup(\"Disabled Group\");\n" +
      "disabledGroup.add(new Radio(\"Option 1\", \"1\").setDisabled(true));\n" +
      "disabledGroup.add(new Radio(\"Option 2\", \"2\").setDisabled(true));\n\n" +
      "// Required radio group\n" +
      "RadioGroup requiredGroup = new RadioGroup(\"Required Group\");\n" +
      "requiredGroup.setRequired(true);\n" +
      "requiredGroup.setHelpText(\"This selection is required\");"
    );
    styleCodeBlock(statesCode);

    statesExample.add(statesContainer, statesCode);

    // Mixed content example
    FlexLayout mixedExample = createSection(
      "Mixed Content",
      "You can mix radio buttons and standard radios in the same group."
    );

    RadioGroup mixedGroup = new RadioGroup("Choose your subscription");
    mixedGroup.setHelpText("Mix of radio styles");
    mixedGroup.addRadio(new Radio("Monthly billing", "monthly"));
    mixedGroup.addRadio(new Radio("Annual billing (save 20%)", "annual"));
    mixedGroup.add(new Div().setStyle("margin", "10px 0"));
    mixedGroup.addRadioButton(new RadioButton("Lifetime", "lifetime").setPill(true));

    Label selectedValue3 = new Label("Selected: (changes will be tracked via sl-change event)");

    Div mixedCode = new Div();
    mixedCode.setText(
      "RadioGroup mixedGroup = new RadioGroup(\"Choose your subscription\");\n" +
      "mixedGroup.addRadio(new Radio(\"Monthly billing\", \"monthly\"));\n" +
      "mixedGroup.addRadio(new Radio(\"Annual billing (save 20%)\", \"annual\"));\n" +
      "mixedGroup.add(new Div().setStyle(\"margin\", \"10px 0\"));\n" +
      "mixedGroup.addRadioButton(new RadioButton(\"Lifetime\", \"lifetime\").setPill(true));"
    );
    styleCodeBlock(mixedCode);

    mixedExample.add(mixedGroup, selectedValue3, mixedCode);

    // Validation example
    FlexLayout validationExample = createSection(
      "Validation",
      "Radio groups support custom validation through the browser's constraint validation API."
    );

    RadioGroup validationGroup = new RadioGroup("Terms and Conditions");
    validationGroup.setRequired(true);
    validationGroup.setName("terms");
    validationGroup.addRadio(new Radio("I agree to the terms", "agree"));
    validationGroup.addRadio(new Radio("I do not agree", "disagree"));

    FlexLayout validationDemo = new FlexLayout();
    validationDemo.setDirection(FlexDirection.COLUMN);
    validationDemo.setSpacing("10px");

    com.webforj.component.button.Button validateBtn = new com.webforj.component.button.Button("Validate");
    Label validationResult = new Label("");

    validateBtn.onClick(e -> {
      if (validationGroup.getValue().equals("agree")) {
        validationResult.setText("✓ Valid selection");
        validationResult.setStyle("color", "green");
      } else {
        validationResult.setText("✗ You must agree to the terms");
        validationResult.setStyle("color", "red");
      }
    });

    validationDemo.add(validationGroup, validateBtn, validationResult);

    Div validationCode = new Div();
    validationCode.setText(
      "RadioGroup validationGroup = new RadioGroup(\"Terms and Conditions\");\n" +
      "validationGroup.setRequired(true);\n" +
      "validationGroup.setName(\"terms\");\n" +
      "validationGroup.addRadio(new Radio(\"I agree to the terms\", \"agree\"));\n" +
      "validationGroup.addRadio(new Radio(\"I do not agree\", \"disagree\"));\n\n" +
      "// Custom validation\n" +
      "if (validationGroup.getValue().equals(\"agree\")) {\n" +
      "    // Valid\n" +
      "} else {\n" +
      "    // Invalid - must agree\n" +
      "}"
    );
    styleCodeBlock(validationCode);

    validationExample.add(validationDemo, validationCode);

    // Add all sections to the main layout
    self.add(
      header,
      basicExample,
      radioButtonExample,
      sizesExample,
      statesExample,
      mixedExample,
      validationExample
    );
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
