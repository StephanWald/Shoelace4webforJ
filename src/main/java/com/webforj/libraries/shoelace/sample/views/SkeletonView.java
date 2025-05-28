package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Skeleton;
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
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/skeleton", outlet = MainLayout.class)
@FrameTitle("Skeleton")
public class SkeletonView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public SkeletonView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Skeleton");
    Paragraph description = new Paragraph(
      "Skeletons are used to provide a visual representation of where content will eventually be " +
      "drawn. They indicate that content is loading without blocking the user's workflow."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Skeleton;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Skeleton.html",
      "https://shoelace.style/components/skeleton"
    );

    header.add(title, description, componentImport, docsLinks);

    // Effects example
    FlexLayout effectsExample = createSection(
      "Effects",
      "Skeletons support different animation effects to indicate loading states."
    );

    FlexLayout effectsContainer = new FlexLayout();
    effectsContainer.setDirection(FlexDirection.COLUMN);
    effectsContainer.setSpacing("30px");

    // None effect
    FlexLayout noneContainer = createEffectContainer("None (default)");
    Skeleton noneEffect = new Skeleton();
    noneEffect.setEffect(Skeleton.Effect.NONE);
    noneEffect.setDimensions("100%", "20px");
    noneContainer.add(noneEffect);

    // Pulse effect
    FlexLayout pulseContainer = createEffectContainer("Pulse");
    Skeleton pulseEffect = new Skeleton();
    pulseEffect.setEffect(Skeleton.Effect.PULSE);
    pulseEffect.setDimensions("100%", "20px");
    pulseContainer.add(pulseEffect);

    // Sheen effect
    FlexLayout sheenContainer = createEffectContainer("Sheen");
    Skeleton sheenEffect = new Skeleton();
    sheenEffect.setEffect(Skeleton.Effect.SHEEN);
    sheenEffect.setDimensions("100%", "20px");
    sheenContainer.add(sheenEffect);

    effectsContainer.add(noneContainer, pulseContainer, sheenContainer);

    Div effectsCode = new Div();
    effectsCode.setText(
      "// No animation\n" +
      "Skeleton skeleton1 = new Skeleton();\n" +
      "skeleton1.setEffect(Skeleton.Effect.NONE);\n\n" +
      "// Pulse animation\n" +
      "Skeleton skeleton2 = new Skeleton();\n" +
      "skeleton2.setEffect(Skeleton.Effect.PULSE);\n\n" +
      "// Sheen animation\n" +
      "Skeleton skeleton3 = new Skeleton();\n" +
      "skeleton3.setEffect(Skeleton.Effect.SHEEN);"
    );
    styleCodeBlock(effectsCode);

    effectsExample.add(effectsContainer, effectsCode);

    // Shapes example
    FlexLayout shapesExample = createSection(
      "Shapes",
      "Use built-in methods to create common skeleton shapes."
    );

    FlexLayout shapesContainer = new FlexLayout();
    shapesContainer.setSpacing("20px");
    shapesContainer.setAlignment(FlexAlignment.CENTER);
    shapesContainer.setStyle("flex-wrap", "wrap");

    // Text skeleton
    Skeleton textSkeleton = Skeleton.text("200px");
    textSkeleton.setEffect(Skeleton.Effect.SHEEN);

    // Circle skeleton
    Skeleton circleSkeleton = Skeleton.circle("60px");
    circleSkeleton.setEffect(Skeleton.Effect.SHEEN);

    // Square skeleton
    Skeleton squareSkeleton = Skeleton.square("60px");
    squareSkeleton.setEffect(Skeleton.Effect.SHEEN);

    // Rectangle skeleton
    Skeleton rectSkeleton = Skeleton.rectangle("200px", "100px");
    rectSkeleton.setEffect(Skeleton.Effect.SHEEN);

    shapesContainer.add(textSkeleton, circleSkeleton, squareSkeleton, rectSkeleton);

    Div shapesCode = new Div();
    shapesCode.setText(
      "// Text skeleton\n" +
      "Skeleton text = Skeleton.text(\"200px\");\n\n" +
      "// Circle skeleton\n" +
      "Skeleton circle = Skeleton.circle(\"60px\");\n\n" +
      "// Square skeleton\n" +
      "Skeleton square = Skeleton.square(\"60px\");\n\n" +
      "// Rectangle skeleton\n" +
      "Skeleton rectangle = Skeleton.rectangle(\"200px\", \"100px\");"
    );
    styleCodeBlock(shapesCode);

    shapesExample.add(shapesContainer, shapesCode);

    // Custom Styling example
    FlexLayout stylingExample = createSection(
      "Custom Styling",
      "Customize skeleton appearance using CSS custom properties."
    );

    FlexLayout stylingContainer = new FlexLayout();
    stylingContainer.setDirection(FlexDirection.COLUMN);
    stylingContainer.setSpacing("20px");

    // Custom colored skeleton
    Skeleton coloredSkeleton = new Skeleton();
    coloredSkeleton.setEffect(Skeleton.Effect.SHEEN);
    coloredSkeleton.setDimensions("100%", "30px");
    coloredSkeleton.setColor("#e2e8f0");
    coloredSkeleton.setSheenColor("#cbd5e1");

    // Custom border radius
    Skeleton roundedSkeleton = new Skeleton();
    roundedSkeleton.setEffect(Skeleton.Effect.PULSE);
    roundedSkeleton.setDimensions("150px", "40px");
    roundedSkeleton.setBorderRadius("20px");

    // Combined custom styles
    Skeleton customSkeleton = new Skeleton();
    customSkeleton.setEffect(Skeleton.Effect.SHEEN);
    customSkeleton.setDimensions("200px", "50px");
    customSkeleton.setColor("#fef3c7");
    customSkeleton.setSheenColor("#fbbf24");
    customSkeleton.setBorderRadius("8px");

    stylingContainer.add(coloredSkeleton, roundedSkeleton, customSkeleton);

    Div stylingCode = new Div();
    stylingCode.setText(
      "// Custom colors\n" +
      "Skeleton colored = new Skeleton();\n" +
      "colored.setColor(\"#e2e8f0\");\n" +
      "colored.setSheenColor(\"#cbd5e1\");\n\n" +
      "// Custom border radius\n" +
      "Skeleton rounded = new Skeleton();\n" +
      "rounded.setBorderRadius(\"20px\");\n\n" +
      "// Combined styles\n" +
      "Skeleton custom = new Skeleton();\n" +
      "custom.setColor(\"#fef3c7\");\n" +
      "custom.setSheenColor(\"#fbbf24\");\n" +
      "custom.setBorderRadius(\"8px\");"
    );
    styleCodeBlock(stylingCode);

    stylingExample.add(stylingContainer, stylingCode);

    // Complex Layouts example
    FlexLayout complexExample = createSection(
      "Complex Layouts",
      "Create realistic loading states for complex content."
    );

    FlexLayout complexContainer = new FlexLayout();
    complexContainer.setDirection(FlexDirection.COLUMN);
    complexContainer.setSpacing("30px");

    // Card skeleton
    FlexLayout cardSkeleton = createCardSkeleton();

    // List skeleton
    FlexLayout listSkeleton = createListSkeleton();

    // Article skeleton
    FlexLayout articleSkeleton = createArticleSkeleton();

    complexContainer.add(cardSkeleton, listSkeleton, articleSkeleton);

    Div complexCode = new Div();
    complexCode.setText(
      "// Card skeleton layout\n" +
      "FlexLayout card = new FlexLayout();\n" +
      "card.add(Skeleton.rectangle(\"100%\", \"200px\")); // Image\n" +
      "card.add(Skeleton.text(\"80%\")); // Title\n" +
      "card.add(Skeleton.text(\"100%\")); // Description line 1\n" +
      "card.add(Skeleton.text(\"90%\")); // Description line 2"
    );
    styleCodeBlock(complexCode);

    complexExample.add(complexContainer, complexCode);

    // Toggle Example
    FlexLayout toggleExample = createSection(
      "Toggle Loading State",
      "Click the button to toggle between skeleton loading state and actual content."
    );

    FlexLayout toggleContainer = new FlexLayout();
    toggleContainer.setDirection(FlexDirection.COLUMN);
    toggleContainer.setSpacing("20px");

    Button toggleButton = new Button("Toggle Loading");
    toggleButton.setTheme(ButtonTheme.PRIMARY);

    FlexLayout contentContainer = new FlexLayout();
    contentContainer.setDirection(FlexDirection.COLUMN);
    contentContainer.setSpacing("10px");
    contentContainer.setStyle("padding", "20px")
                    .setStyle("background", "#f8f9fa")
                    .setStyle("border-radius", "8px");

    // Initially show skeleton
    showSkeleton(contentContainer);

    final boolean[] isLoading = {true};
    toggleButton.onClick(e -> {
      isLoading[0] = !isLoading[0];
      if (isLoading[0]) {
        showSkeleton(contentContainer);
      } else {
        showContent(contentContainer);
      }
    });

    toggleContainer.add(toggleButton, contentContainer);

    toggleExample.add(toggleContainer);

    // Add all sections to the main layout
    self.add(
      header,
      effectsExample,
      shapesExample,
      stylingExample,
      complexExample,
      toggleExample
    );
  }

  private FlexLayout createEffectContainer(String label) {
    FlexLayout container = new FlexLayout();
    container.setDirection(FlexDirection.COLUMN);
    container.setSpacing("10px");
    container.setStyle("flex", "1");

    Label effectLabel = new Label(label);
    effectLabel.setStyle("font-weight", "600");
    container.add(effectLabel);

    return container;
  }

  private FlexLayout createCardSkeleton() {
    FlexLayout card = new FlexLayout();
    card.setDirection(FlexDirection.COLUMN);
    card.setSpacing("10px");
    card.setStyle("padding", "15px")
        .setStyle("background", "white")
        .setStyle("border", "1px solid #e2e8f0")
        .setStyle("border-radius", "8px")
        .setStyle("width", "300px");

    Skeleton image = Skeleton.rectangle("100%", "180px");
    image.setEffect(Skeleton.Effect.SHEEN);

    Skeleton title = Skeleton.text("80%");
    title.setEffect(Skeleton.Effect.SHEEN);

    Skeleton desc1 = Skeleton.text("100%");
    desc1.setEffect(Skeleton.Effect.SHEEN);

    Skeleton desc2 = Skeleton.text("90%");
    desc2.setEffect(Skeleton.Effect.SHEEN);

    card.add(image, title, desc1, desc2);
    return card;
  }

  private FlexLayout createListSkeleton() {
    FlexLayout list = new FlexLayout();
    list.setDirection(FlexDirection.COLUMN);
    list.setSpacing("15px");
    list.setStyle("padding", "15px")
        .setStyle("background", "white")
        .setStyle("border", "1px solid #e2e8f0")
        .setStyle("border-radius", "8px");

    for (int i = 0; i < 3; i++) {
      FlexLayout item = new FlexLayout();
      item.setSpacing("15px");
      item.setAlignment(FlexAlignment.CENTER);

      Skeleton avatar = Skeleton.circle("40px");
      avatar.setEffect(Skeleton.Effect.SHEEN);

      FlexLayout content = new FlexLayout();
      content.setDirection(FlexDirection.COLUMN);
      content.setSpacing("5px");
      content.setStyle("flex", "1");

      Skeleton name = Skeleton.text("120px");
      name.setEffect(Skeleton.Effect.SHEEN);

      Skeleton email = Skeleton.text("180px");
      email.setEffect(Skeleton.Effect.SHEEN);

      content.add(name, email);
      item.add(avatar, content);
      list.add(item);
    }

    return list;
  }

  private FlexLayout createArticleSkeleton() {
    FlexLayout article = new FlexLayout();
    article.setDirection(FlexDirection.COLUMN);
    article.setSpacing("15px");
    article.setStyle("padding", "20px")
           .setStyle("background", "white")
           .setStyle("border", "1px solid #e2e8f0")
           .setStyle("border-radius", "8px");

    // Title
    Skeleton title = new Skeleton();
    title.setEffect(Skeleton.Effect.SHEEN);
    title.setDimensions("70%", "2em");
    title.setBorderRadius("4px");

    // Meta info
    FlexLayout meta = new FlexLayout();
    meta.setSpacing("10px");
    meta.setAlignment(FlexAlignment.CENTER);

    Skeleton authorAvatar = Skeleton.circle("30px");
    authorAvatar.setEffect(Skeleton.Effect.SHEEN);

    Skeleton authorName = Skeleton.text("100px");
    authorName.setEffect(Skeleton.Effect.SHEEN);

    Skeleton date = Skeleton.text("80px");
    date.setEffect(Skeleton.Effect.SHEEN);

    meta.add(authorAvatar, authorName, date);

    // Paragraph lines
    FlexLayout paragraph = new FlexLayout();
    paragraph.setDirection(FlexDirection.COLUMN);
    paragraph.setSpacing("8px");

    for (int i = 0; i < 4; i++) {
      double width = (i == 3) ? 60 : 95;
      Skeleton line = new Skeleton();
      line.setEffect(Skeleton.Effect.SHEEN);
      line.setDimensions(width + "%", "1em");
      line.setBorderRadius("4px");
      paragraph.add(line);
    }

    article.add(title, meta, paragraph);
    return article;
  }

  private void showSkeleton(FlexLayout container) {
    container.removeAll();

    FlexLayout skeletonContent = new FlexLayout();
    skeletonContent.setDirection(FlexDirection.COLUMN);
    skeletonContent.setSpacing("10px");

    Skeleton titleSkeleton = Skeleton.text("60%");
    titleSkeleton.setEffect(Skeleton.Effect.SHEEN);
    titleSkeleton.setStyle("height", "1.5em");

    Skeleton line1 = Skeleton.text("100%");
    line1.setEffect(Skeleton.Effect.SHEEN);

    Skeleton line2 = Skeleton.text("100%");
    line2.setEffect(Skeleton.Effect.SHEEN);

    Skeleton line3 = Skeleton.text("80%");
    line3.setEffect(Skeleton.Effect.SHEEN);

    skeletonContent.add(titleSkeleton, line1, line2, line3);
    container.add(skeletonContent);
  }

  private void showContent(FlexLayout container) {
    container.removeAll();

    FlexLayout actualContent = new FlexLayout();
    actualContent.setDirection(FlexDirection.COLUMN);
    actualContent.setSpacing("10px");

    H2 contentTitle = new H2("Loaded Content");
    contentTitle.setStyle("margin", "0");

    Paragraph contentText = new Paragraph(
      "This is the actual content that appears after loading. " +
      "The skeleton provided a visual placeholder while this content was being fetched."
    );

    actualContent.add(contentTitle, contentText);
    container.add(actualContent);
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
