package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Avatar;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/avatar", outlet = MainLayout.class)
@FrameTitle("Avatar")
public class AvatarView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public AvatarView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Avatar");
    Paragraph description = new Paragraph(
      "Avatars are used to represent a person or object using Shoelace's sl-avatar component. " +
      "By default, a generic icon will be shown. You can personalize avatars by adding " +
      "custom icons, initials, and images. Avatars should be used in conjunction with a " +
      "meaningful label to ensure they're accessible to assistive devices."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Avatar;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Avatar.html",
      "https://shoelace.style/components/avatar"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic example section
    FlexLayout basicExample = createSection(
      "Basic Example",
      "Create avatars with initials, images, or use the default icon."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setSpacing("20px");
    basicDemo.setAlignment(FlexAlignment.CENTER);

    Avatar defaultAvatar = new Avatar();
    defaultAvatar.setLabel("Default avatar");

    Avatar initialsAvatar = new Avatar("AB");
    initialsAvatar.setLabel("Avatar with initials");

    Avatar imageAvatar = new Avatar();
    imageAvatar.setImage("https://images.unsplash.com/photo-1529778873920-4da4926a72c2?w=300&h=300&fit=crop")
               .setLabel("Avatar with image");

    Div basicCode = new Div();
    basicCode.setText(
      "// Default avatar\n" +
      "Avatar defaultAvatar = new Avatar();\n\n" +
      "// Avatar with initials\n" +
      "Avatar initialsAvatar = new Avatar(\"AB\");\n\n" +
      "// Avatar with image\n" +
      "Avatar imageAvatar = new Avatar();\n" +
      "imageAvatar.setImage(\"image-url.jpg\");"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(defaultAvatar, initialsAvatar, imageAvatar);
    basicExample.add(basicDemo, basicCode);

    // Shapes section
    FlexLayout shapesExample = createSection(
      "Shapes",
      "Avatars can be shaped as circles (default), squares, or rounded squares."
    );

    FlexLayout shapesDemo = new FlexLayout();
    shapesDemo.setSpacing("20px");
    shapesDemo.setAlignment(FlexAlignment.CENTER);

    Avatar circleAvatar = new Avatar("CI");
    circleAvatar.setShapeCircle()
                .setLabel("Circle avatar");

    Avatar squareAvatar = new Avatar("SQ");
    squareAvatar.setShapeSquare()
                .setLabel("Square avatar");

    Avatar roundedAvatar = new Avatar("RD");
    roundedAvatar.setShapeRounded()
                 .setLabel("Rounded avatar");

    Div shapesCode = new Div();
    shapesCode.setText(
      "// Circle shape (default)\n" +
      "avatar.setShapeCircle();\n\n" +
      "// Square shape\n" +
      "avatar.setShapeSquare();\n\n" +
      "// Rounded shape\n" +
      "avatar.setShapeRounded();"
    );
    styleCodeBlock(shapesCode);

    shapesDemo.add(circleAvatar, squareAvatar, roundedAvatar);
    shapesExample.add(shapesDemo, shapesCode);

    // Interactive example
    FlexLayout interactiveExample = createSection(
      "Interactive Example",
      "Try different combinations of properties to customize the avatar."
    );

    FlexLayout interactiveDemo = new FlexLayout();
    interactiveDemo.setDirection(FlexDirection.COLUMN);
    interactiveDemo.setSpacing("20px");

    TextField initialsInput = new TextField();
    initialsInput.setLabel("Initials");
    initialsInput.setPlaceholder("Enter 1-2 characters");
    initialsInput.setValue("JD");
    initialsInput.setMaxLength(2);

    TextField imageInput = new TextField();
    imageInput.setLabel("Image URL");
    imageInput.setPlaceholder("Enter image URL (optional)");

    ChoiceBox shapeChoice = new ChoiceBox();
    shapeChoice.setLabel("Shape");
    shapeChoice.add("circle", "Circle");
    shapeChoice.add("square", "Square");
    shapeChoice.add("rounded", "Rounded");
    shapeChoice.selectKey("circle");

    Avatar interactiveAvatar = new Avatar("JD");
    // Size is controlled via CSS custom property
    FlexLayout avatarWrapper = new FlexLayout();
    avatarWrapper.setAlignment(FlexAlignment.CENTER);
    avatarWrapper.setStyle("--size", "64px");
    avatarWrapper.add(interactiveAvatar);

    // Event handlers
    initialsInput.addValueChangeListener(e -> {
      interactiveAvatar.setInitials(e.getValue());
    });

    imageInput.addValueChangeListener(e -> {
      String url = e.getValue();
      if (url != null && !url.isEmpty()) {
        interactiveAvatar.setImage(url);
      } else {
        interactiveAvatar.setImage("");
      }
    });

    shapeChoice.onSelect(e -> {
      String shape = (String) shapeChoice.getSelectedKey();
      interactiveAvatar.setShape(shape);
    });

    interactiveDemo.add(initialsInput, imageInput, shapeChoice, avatarWrapper);
    interactiveExample.add(interactiveDemo);

    // Events section
    FlexLayout eventsSection = createSection(
      "Events",
      "The Avatar component does not emit any custom events."
    );

    Div noEventsNote = new Div();
    noEventsNote.setText(
      "The Avatar component is a display-only component and does not emit any events. " +
      "If you need to handle user interactions with avatars, you can wrap them in a clickable " +
      "container or use them within interactive components."
    );
    noEventsNote.setStyle("background", "#f8f9fa")
                .setStyle("padding", "16px")
                .setStyle("border-radius", "8px")
                .setStyle("font-size", "14px")
                .setStyle("color", "#495057")
                .setStyle("border", "1px solid #e9ecef");
    
    eventsSection.add(noEventsNote);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Avatar component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, shapesExample, interactiveExample, eventsSection, propertiesSection);
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
    FlexLayout imageRow = createTableRow(false);
    imageRow.add(
      createTableCell("image", false),
      createTableCell("The image source to use for the avatar", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout labelRow = createTableRow(false);
    labelRow.add(
      createTableCell("label", false),
      createTableCell("A label to use to describe the avatar to assistive devices", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout initialsRow = createTableRow(false);
    initialsRow.add(
      createTableCell("initials", false),
      createTableCell("Initials to use as a fallback when no image is available", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout shapeRow = createTableRow(false);
    shapeRow.add(
      createTableCell("shape", false),
      createTableCell("The shape of the avatar", false),
      createTableCell("String", false),
      createTableCell("\"circle\"", false)
    );

    FlexLayout loadingRow = createTableRow(false);
    loadingRow.add(
      createTableCell("loading", false),
      createTableCell("Indicates how the browser should load the image", false),
      createTableCell("String", false),
      createTableCell("\"eager\"", false)
    );

    table.add(headerRow, imageRow, labelRow, initialsRow, shapeRow, loadingRow);
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
