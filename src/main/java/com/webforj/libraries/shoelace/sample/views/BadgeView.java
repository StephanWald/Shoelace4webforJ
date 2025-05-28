package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Badge;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/badge", outlet = MainLayout.class)
@FrameTitle("Badge")
public class BadgeView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public BadgeView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Badge");
    Paragraph description = new Paragraph(
      "Badges are used to draw attention and display statuses or counts. " +
      "They support different variants, pill style, and pulse animation for highlighting important information."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Badge;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Badge.html",
      "https://shoelace.style/components/badge"
    );

    header.add(title, description, componentImport, docsLinks);

    // Variants section
    FlexLayout variantsExample = createSection(
      "Variants",
      "Set the variant attribute to change the badge's appearance."
    );

    FlexLayout variantsDemo = new FlexLayout();
    variantsDemo.setSpacing("20px");
    variantsDemo.setAlignment(FlexAlignment.CENTER);

    Badge primaryBadge = new Badge("Primary", Badge.Variant.PRIMARY);
    Badge successBadge = new Badge("Success", Badge.Variant.SUCCESS);
    Badge neutralBadge = new Badge("Neutral", Badge.Variant.NEUTRAL);
    Badge warningBadge = new Badge("Warning", Badge.Variant.WARNING);
    Badge dangerBadge = new Badge("Danger", Badge.Variant.DANGER);

    Div variantsCode = new Div();
    variantsCode.setText(
      "Badge primaryBadge = new Badge(\"Primary\", Badge.Variant.PRIMARY);\n" +
      "Badge successBadge = new Badge(\"Success\", Badge.Variant.SUCCESS);\n" +
      "Badge neutralBadge = new Badge(\"Neutral\", Badge.Variant.NEUTRAL);\n" +
      "Badge warningBadge = new Badge(\"Warning\", Badge.Variant.WARNING);\n" +
      "Badge dangerBadge = new Badge(\"Danger\", Badge.Variant.DANGER);"
    );
    styleCodeBlock(variantsCode);

    variantsDemo.add(primaryBadge, successBadge, neutralBadge, warningBadge, dangerBadge);
    variantsExample.add(variantsDemo, variantsCode);

    // Pill badges section
    FlexLayout pillExample = createSection(
      "Pill Badges",
      "Use the pill attribute to give badges rounded edges."
    );

    FlexLayout pillDemo = new FlexLayout();
    pillDemo.setSpacing("20px");
    pillDemo.setAlignment(FlexAlignment.CENTER);

    Badge pillPrimary = new Badge("Primary", Badge.Variant.PRIMARY).setPill(true);
    Badge pillSuccess = new Badge("Success", Badge.Variant.SUCCESS).setPill(true);
    Badge pillNeutral = new Badge("Neutral", Badge.Variant.NEUTRAL).setPill(true);
    Badge pillWarning = new Badge("Warning", Badge.Variant.WARNING).setPill(true);
    Badge pillDanger = new Badge("Danger", Badge.Variant.DANGER).setPill(true);

    Div pillCode = new Div();
    pillCode.setText(
      "Badge pillBadge = new Badge(\"Primary\")\n" +
      "    .setVariant(Badge.Variant.PRIMARY)\n" +
      "    .setPill(true);"
    );
    styleCodeBlock(pillCode);

    pillDemo.add(pillPrimary, pillSuccess, pillNeutral, pillWarning, pillDanger);
    pillExample.add(pillDemo, pillCode);

    // Pulsating badges section
    FlexLayout pulseExample = createSection(
      "Pulsating Badges",
      "Use the pulse attribute to draw attention with a subtle animation."
    );

    FlexLayout pulseDemo = new FlexLayout();
    pulseDemo.setSpacing("20px");
    pulseDemo.setAlignment(FlexAlignment.CENTER);

    Badge pulsePrimary = new Badge("1", Badge.Variant.PRIMARY).setPulse(true);
    Badge pulseSuccess = new Badge("2", Badge.Variant.SUCCESS).setPulse(true);
    Badge pulseNeutral = new Badge("3", Badge.Variant.NEUTRAL).setPulse(true);
    Badge pulseWarning = new Badge("4", Badge.Variant.WARNING).setPulse(true);
    Badge pulseDanger = new Badge("5", Badge.Variant.DANGER).setPulse(true);

    Div pulseCode = new Div();
    pulseCode.setText(
      "Badge pulseBadge = new Badge(\"1\")\n" +
      "    .setVariant(Badge.Variant.DANGER)\n" +
      "    .setPulse(true);"
    );
    styleCodeBlock(pulseCode);

    pulseDemo.add(pulsePrimary, pulseSuccess, pulseNeutral, pulseWarning, pulseDanger);
    pulseExample.add(pulseDemo, pulseCode);

    // With buttons section
    FlexLayout buttonExample = createSection(
      "With Buttons",
      "Badges can be used inside buttons to display counts or statuses."
    );

    FlexLayout buttonDemo = new FlexLayout();
    buttonDemo.setSpacing("20px");
    buttonDemo.setAlignment(FlexAlignment.CENTER);

    Button messagesButton = new Button("Messages");
    Badge messageCount = new Badge("12", Badge.Variant.PRIMARY).setPill(true);

    Button notificationsButton = new Button("Notifications");
    Badge notificationCount = new Badge("3", Badge.Variant.DANGER).setPulse(true);

    // Create button + badge groups
    FlexLayout buttonGroup1 = new FlexLayout();
    buttonGroup1.setAlignment(FlexAlignment.CENTER);
    buttonGroup1.setSpacing("8px");
    buttonGroup1.add(messagesButton, messageCount);

    FlexLayout buttonGroup2 = new FlexLayout();
    buttonGroup2.setAlignment(FlexAlignment.CENTER);
    buttonGroup2.setSpacing("8px");
    buttonGroup2.add(notificationsButton, notificationCount);

    Div buttonCode = new Div();
    buttonCode.setText(
      "Button button = new Button(\"Messages\");\n" +
      "Badge badge = new Badge(\"12\", Badge.Variant.PRIMARY)\n" +
      "    .setPill(true);\n\n" +
      "// Create a layout to group button and badge\n" +
      "FlexLayout group = new FlexLayout();\n" +
      "group.setSpacing(\"8px\");\n" +
      "group.add(button, badge);"
    );
    styleCodeBlock(buttonCode);

    buttonDemo.add(buttonGroup1, buttonGroup2);
    buttonExample.add(buttonDemo, buttonCode);

    // Interactive example
    FlexLayout interactiveExample = createSection(
      "Interactive Example",
      "Customize the badge properties to see how they affect the appearance."
    );

    FlexLayout interactiveDemo = new FlexLayout();
    interactiveDemo.setDirection(FlexDirection.COLUMN);
    interactiveDemo.setSpacing("20px");

    com.webforj.component.field.TextField textInput = new com.webforj.component.field.TextField();
    textInput.setLabel("Badge Text");
    textInput.setValue("Custom Badge");

    ChoiceBox variantChoice = new ChoiceBox();
    variantChoice.setLabel("Variant");
    variantChoice.add("primary", "Primary");
    variantChoice.add("success", "Success");
    variantChoice.add("neutral", "Neutral");
    variantChoice.add("warning", "Warning");
    variantChoice.add("danger", "Danger");
    variantChoice.selectKey("primary");

    CheckBox pillCheck = new CheckBox("Pill Style");
    CheckBox pulseCheck = new CheckBox("Pulse Animation");

    Badge interactiveBadge = new Badge("Custom Badge");

    // Event handlers
    textInput.addValueChangeListener(e -> {
      interactiveBadge.setHtml(e.getValue());
    });

    variantChoice.onSelect(e -> {
      String variant = (String) variantChoice.getSelectedKey();
      interactiveBadge.setVariant(variant);
    });

    pillCheck.addValueChangeListener(e -> interactiveBadge.setPill(pillCheck.isChecked()));

    pulseCheck.addValueChangeListener(e -> interactiveBadge.setPulse(pulseCheck.isChecked()));

    interactiveDemo.add(textInput, variantChoice, pillCheck, pulseCheck, interactiveBadge);
    interactiveExample.add(interactiveDemo);

    // Events section
    FlexLayout eventsSection = createSection(
      "Events",
      "The Badge component does not emit any custom events."
    );

    Div noEventsNote = new Div();
    noEventsNote.setText(
      "The Badge component is display-only and does not emit events. " +
      "If you need to handle user interactions with badges, you can wrap them in a clickable " +
      "container or use them within interactive components like buttons."
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
      "The Badge component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, variantsExample, pillExample, pulseExample, buttonExample,
             interactiveExample, eventsSection, propertiesSection);
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
      createTableCell("The badge's theme variant", false),
      createTableCell("String", false),
      createTableCell("\"primary\"", false)
    );

    FlexLayout pillRow = createTableRow(false);
    pillRow.add(
      createTableCell("pill", false),
      createTableCell("Draws a pill-style badge with rounded edges", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout pulseRow = createTableRow(false);
    pulseRow.add(
      createTableCell("pulse", false),
      createTableCell("Makes the badge pulsate to draw attention", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    table.add(headerRow, variantRow, pillRow, pulseRow);
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
