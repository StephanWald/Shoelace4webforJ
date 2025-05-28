package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.ImageComparer;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/image-comparer", outlet = MainLayout.class)
@FrameTitle("Image Comparer")
public class ImageComparerView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public ImageComparerView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Image Comparer");
    Paragraph description = new Paragraph(
      "Image comparers allow users to compare two images by dragging a divider. " +
      "They're commonly used for before/after comparisons, image processing demonstrations, " +
      "and visual quality comparisons."
    );

    // Import statement
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.ImageComparer;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/ImageComparer.html",
      "https://shoelace.style/components/image-comparer"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic example section
    FlexLayout basicExample = createSection(
      "Basic Image Comparer",
      "Compare two images by dragging the divider handle."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    // Create image comparer with placeholder images
    ImageComparer basicComparer = new ImageComparer();

    // Before image
    Img beforeImg = new Img();
    beforeImg.setSrc("https://images.unsplash.com/photo-1517331156700-3c241d2b4d83?w=800");
    beforeImg.setAlt("Kitten looking up (before)");
    beforeImg.setAttribute("slot", "before");

    // After image
    Img afterImg = new Img();
    afterImg.setSrc("https://images.unsplash.com/photo-1517331156700-3c241d2b4d83?w=800&blur=5");
    afterImg.setAlt("Kitten looking up (after)");
    afterImg.setAttribute("slot", "after");

    basicComparer.add(beforeImg, afterImg);

    Div basicInfo = new Div();
    basicInfo.setText("Drag the handle to compare the original and blurred versions of the image.");
    basicInfo.setStyle("color", "#6b7280");
    basicInfo.setStyle("font-size", "14px");

    Div basicCode = new Div();
    basicCode.setText(
      "// Create image comparer\n" +
      "ImageComparer comparer = new ImageComparer();\n\n" +
      "// Add before image\n" +
      "Img beforeImg = new Img();\n" +
      "beforeImg.setSrc(\"before.jpg\");\n" +
      "beforeImg.setAttribute(\"slot\", \"before\");\n\n" +
      "// Add after image\n" +
      "Img afterImg = new Img();\n" +
      "afterImg.setSrc(\"after.jpg\");\n" +
      "afterImg.setAttribute(\"slot\", \"after\");\n\n" +
      "comparer.add(beforeImg, afterImg);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicComparer, basicInfo, basicCode);
    basicExample.add(basicDemo);

    // Initial position section
    FlexLayout positionExample = createSection(
      "Initial Position",
      "Set the initial position of the divider handle."
    );

    FlexLayout positionDemo = new FlexLayout();
    positionDemo.setDirection(FlexDirection.COLUMN);
    positionDemo.setSpacing("20px");

    FlexLayout positionGrid = new FlexLayout();
    positionGrid.setSpacing("20px");
    positionGrid.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    // 25% position
    ImageComparer comparer25 = new ImageComparer(25);
    comparer25.setStyle("max-width", "300px");
    Img before25 = createDemoImage("https://images.unsplash.com/photo-1519052537078-e6302a4968d4?w=600", "before");
    Img after25 = createDemoImage("https://images.unsplash.com/photo-1519052537078-e6302a4968d4?w=600&grayscale", "after");
    comparer25.add(before25, after25);

    FlexLayout box25 = createPositionBox(comparer25, "25% Position");

    // 75% position
    ImageComparer comparer75 = new ImageComparer(75);
    comparer75.setStyle("max-width", "300px");
    Img before75 = createDemoImage("https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=600", "before");
    Img after75 = createDemoImage("https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=600&sepia", "after");
    comparer75.add(before75, after75);

    FlexLayout box75 = createPositionBox(comparer75, "75% Position");

    positionGrid.add(box25, box75);

    Div positionCode = new Div();
    positionCode.setText(
      "// Set initial position (0-100)\n" +
      "ImageComparer comparer = new ImageComparer(25);\n\n" +
      "// Or set it later\n" +
      "comparer.setPosition(75);\n\n" +
      "// Get current position\n" +
      "int position = comparer.getPosition();"
    );
    styleCodeBlock(positionCode);

    positionDemo.add(positionGrid, positionCode);
    positionExample.add(positionDemo);

    // Custom handle section
    FlexLayout handleExample = createSection(
      "Custom Handle Icon",
      "Customize the divider handle with your own icon."
    );

    FlexLayout handleDemo = new FlexLayout();
    handleDemo.setDirection(FlexDirection.COLUMN);
    handleDemo.setSpacing("20px");

    ImageComparer customHandleComparer = new ImageComparer();
    customHandleComparer.setStyle("max-width", "600px");

    Img beforeCustom = createDemoImage("https://images.unsplash.com/photo-1574158622682-e40e69881006?w=800", "before");
    Img afterCustom = createDemoImage("https://images.unsplash.com/photo-1574158622682-e40e69881006?w=800&brightness=1.5", "after");

    // Custom handle icon
    Div customHandle = new Div();
    customHandle.setAttribute("slot", "handle");
    customHandle.setHtml(
      "<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24' fill='currentColor'>" +
      "<path d='M8 5v14l11-7z'/>" +
      "<path d='M16 5v14l-11-7z' opacity='0.5'/>" +
      "</svg>"
    );
    customHandle.setStyle("color", "white");
    customHandle.setStyle("background", "rgba(0,0,0,0.8)");
    customHandle.setStyle("border-radius", "50%");
    customHandle.setStyle("padding", "8px");

    customHandleComparer.add(beforeCustom, afterCustom, customHandle);

    Div handleInfo = new Div();
    handleInfo.setText("The handle icon has been customized with an SVG icon.");
    handleInfo.setStyle("color", "#6b7280");
    handleInfo.setStyle("font-size", "14px");

    Div handleCode = new Div();
    handleCode.setText(
      "// Add custom handle icon\n" +
      "Div customHandle = new Div();\n" +
      "customHandle.setAttribute(\"slot\", \"handle\");\n" +
      "customHandle.setHtml(svgIcon);\n" +
      "customHandle.setStyle(\"background\", \"rgba(0,0,0,0.8)\");\n\n" +
      "comparer.add(beforeImg, afterImg, customHandle);\n\n" +
      "// Or use setHandle method\n" +
      "comparer.setHandle(customHandle);"
    );
    styleCodeBlock(handleCode);

    handleDemo.add(customHandleComparer, handleInfo, handleCode);
    handleExample.add(handleDemo);

    // Use cases section
    FlexLayout useCasesExample = createSection(
      "Common Use Cases",
      "Image comparers are perfect for various comparison scenarios."
    );

    FlexLayout useCasesDemo = new FlexLayout();
    useCasesDemo.setDirection(FlexDirection.COLUMN);
    useCasesDemo.setSpacing("30px");

    // Before/After editing
    FlexLayout editingCase = createUseCase(
      "Photo Editing",
      "Show the difference between original and edited photos.",
      "https://images.unsplash.com/photo-1472214103451-9374bd1c798e?w=600",
      "https://images.unsplash.com/photo-1472214103451-9374bd1c798e?w=600&saturation=2"
    );

    // Day/Night comparison
    FlexLayout dayNightCase = createUseCase(
      "Time Comparison",
      "Compare the same location at different times.",
      "https://images.unsplash.com/photo-1480714378408-67cf0d13bc1b?w=600&brightness=1.2",
      "https://images.unsplash.com/photo-1480714378408-67cf0d13bc1b?w=600&brightness=0.5"
    );

    useCasesDemo.add(editingCase, dayNightCase);
    useCasesExample.add(useCasesDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Image Comparer component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, positionExample, handleExample,
             useCasesExample, propertiesSection);
  }

  private Img createDemoImage(String src, String slot) {
    Img img = new Img();
    img.setSrc(src);
    img.setAttribute("slot", slot);
    img.setStyle("display", "block");
    img.setStyle("width", "100%");
    return img;
  }

  private FlexLayout createPositionBox(ImageComparer comparer, String label) {
    FlexLayout box = new FlexLayout();
    box.setDirection(FlexDirection.COLUMN);
    box.setSpacing("10px");
    box.setAlignment(FlexAlignment.CENTER);

    Div labelDiv = new Div();
    labelDiv.setText(label);
    labelDiv.setStyle("font-weight", "500");
    labelDiv.setStyle("text-align", "center");

    box.add(comparer, labelDiv);
    return box;
  }

  private FlexLayout createUseCase(String title, String description, String beforeSrc, String afterSrc) {
    FlexLayout useCase = new FlexLayout();
    useCase.setDirection(FlexDirection.COLUMN);
    useCase.setSpacing("15px");

    H4 caseTitle = new H4(title);
    caseTitle.setStyle("margin", "0");

    Paragraph caseDesc = new Paragraph(description);
    caseDesc.setStyle("color", "#6b7280");
    caseDesc.setStyle("margin", "0");

    ImageComparer comparer = new ImageComparer(50);
    comparer.setStyle("max-width", "500px");

    Img before = createDemoImage(beforeSrc, "before");
    Img after = createDemoImage(afterSrc, "after");
    comparer.add(before, after);

    useCase.add(caseTitle, caseDesc, comparer);
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
      {"position", "Slider position", "int", "50"},
      {"setPosition()", "Sets slider position (0-100)", "method", "-"},
      {"setBefore()", "Sets before image", "method", "-"},
      {"setAfter()", "Sets after image", "method", "-"},
      {"setImages()", "Sets both images", "method", "-"},
      {"setHandle()", "Sets custom handle icon", "method", "-"}
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
