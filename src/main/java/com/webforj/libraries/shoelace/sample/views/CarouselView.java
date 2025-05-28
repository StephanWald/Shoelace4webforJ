package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Carousel;
import com.webforj.libraries.shoelace.components.CarouselItem;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.slider.Slider;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/carousel", outlet = MainLayout.class)
@FrameTitle("Carousel")
public class CarouselView extends Composite<FlexLayout> {
  private final FlexLayout self = getBoundComponent();

  public CarouselView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Carousel");
    Paragraph description = new Paragraph(
      "Carousels display an arbitrary number of content slides along a horizontal or vertical axis " +
      "using the Shoelace web component. They support navigation, pagination, autoplay, and " +
      "various display options."
    );

    // Documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Carousel.html",
      "https://shoelace.style/components/carousel"
    );

    header.add(title, description, docLinks);

    // Basic example section
    FlexLayout basicExample = createSection(
      "Basic Carousel",
      "A basic carousel with navigation and pagination."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    Carousel basicCarousel = new Carousel();
    basicCarousel.setNavigation(true);
    basicCarousel.setPagination(true);
    basicCarousel.setStyle("--aspect-ratio", "3/2");

    // Add slides with beautiful images from Unsplash
    CarouselItem slide1 = new CarouselItem();
    slide1.setHtml("<img src=\"https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800&h=450&fit=crop\" alt=\"Swiss Alps mountain landscape\" style=\"width: 100%; height: 100%; object-fit: cover;\">");

    CarouselItem slide2 = new CarouselItem();
    slide2.setHtml("<img src=\"https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=800&h=450&fit=crop\" alt=\"Delicious food platter\" style=\"width: 100%; height: 100%; object-fit: cover;\">");

    CarouselItem slide3 = new CarouselItem();
    slide3.setHtml("<img src=\"https://images.unsplash.com/photo-1501594907352-04cda38ebc29?w=800&h=450&fit=crop\" alt=\"Golden Gate Bridge at sunset\" style=\"width: 100%; height: 100%; object-fit: cover;\">");

    CarouselItem slide4 = new CarouselItem();
    slide4.setHtml("<img src=\"https://images.unsplash.com/photo-1505142468610-359e7d316be0?w=800&h=450&fit=crop\" alt=\"Tropical beach paradise\" style=\"width: 100%; height: 100%; object-fit: cover;\">");

    basicCarousel.addItem(slide1);
    basicCarousel.addItem(slide2);
    basicCarousel.addItem(slide3);
    basicCarousel.addItem(slide4);

    Div basicCode = new Div();
    basicCode.setText(
      "Carousel carousel = new Carousel();\n" +
      "carousel.setNavigation(true);\n" +
      "carousel.setPagination(true);\n\n" +
      "CarouselItem slide1 = new CarouselItem();\n" +
      "slide1.setHtml(\"<div>Slide Content</div>\");\n" +
      "carousel.addItem(slide1);\n\n" +
      "// Add more slides...\n" +
      "carousel.addItem(slide2);\n" +
      "carousel.addItem(slide3);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicCarousel, basicCode);
    basicExample.add(basicDemo);

    // Multiple slides section
    FlexLayout multipleExample = createSection(
      "Multiple Slides Per Page",
      "Display multiple slides simultaneously by setting slides-per-page."
    );

    FlexLayout multipleDemo = new FlexLayout();
    multipleDemo.setDirection(FlexDirection.COLUMN);
    multipleDemo.setSpacing("20px");

    Carousel multipleCarousel = new Carousel();
    multipleCarousel.setNavigation(true);
    multipleCarousel.setPagination(true);
    multipleCarousel.setSlidesPerPage(3);
    multipleCarousel.setSlidesPerMove(3);
    multipleCarousel.setLoop(true);

    // Add food images for multiple slides demonstration
    String[] foodImages = {
      "https://images.unsplash.com/photo-1567620905732-2d1ec7ab7445?w=400&h=300&fit=crop", // Food bowl
      "https://images.unsplash.com/photo-1555939594-58d7cb561ad1?w=400&h=300&fit=crop", // Burger
      "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?w=400&h=300&fit=crop", // Salad
      "https://images.unsplash.com/photo-1565299507177-b0ac66763828?w=400&h=300&fit=crop", // Chicken
      "https://images.unsplash.com/photo-1476224203421-9ac39bcb3327?w=400&h=300&fit=crop", // Breakfast
      "https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=400&h=300&fit=crop"  // Pasta
    };
    String[] foodNames = {"Healthy Bowl", "Gourmet Burger", "Fresh Salad", "Grilled Chicken", "Breakfast", "Italian Pasta"};

    for (int i = 0; i < foodImages.length; i++) {
      CarouselItem slide = new CarouselItem();
      slide.setHtml(
        "<div style=\"height: 200px; margin: 5px; border-radius: 8px; overflow: hidden; position: relative;\">" +
        "<img src=\"" + foodImages[i] + "\" alt=\"" + foodNames[i] + "\" style=\"width: 100%; height: 100%; object-fit: cover;\">" +
        "<div style=\"position: absolute; bottom: 0; left: 0; right: 0; background: rgba(0,0,0,0.6); color: white; padding: 10px; text-align: center;\">" +
        "<span style=\"font-weight: bold;\">" + foodNames[i] + "</span>" +
        "</div>" +
        "</div>"
      );
      multipleCarousel.addItem(slide);
    }

    Div multipleCode = new Div();
    multipleCode.setText(
      "Carousel carousel = new Carousel();\n" +
      "carousel.setNavigation(true);\n" +
      "carousel.setPagination(true);\n" +
      "carousel.setSlidesPerPage(3);  // Show 3 slides at once\n" +
      "carousel.setSlidesPerMove(3);  // Move 3 slides at a time\n" +
      "carousel.setLoop(true);        // Enable infinite loop"
    );
    styleCodeBlock(multipleCode);

    multipleDemo.add(multipleCarousel, multipleCode);
    multipleExample.add(multipleDemo);

    // Autoplay section
    FlexLayout autoplayExample = createSection(
      "Autoplay Carousel",
      "Enable autoplay to automatically advance slides at specified intervals."
    );

    FlexLayout autoplayDemo = new FlexLayout();
    autoplayDemo.setDirection(FlexDirection.COLUMN);
    autoplayDemo.setSpacing("20px");

    Carousel autoplayCarousel = new Carousel();
    autoplayCarousel.setNavigation(true);
    autoplayCarousel.setPagination(true);
    autoplayCarousel.setAutoplay(true);
    autoplayCarousel.setAutoplayInterval(2000);
    autoplayCarousel.setLoop(true);
    autoplayCarousel.setMouseDragging(true);

    // Add slides with beautiful nature and food images
    String[] imageUrls = {
      "https://images.unsplash.com/photo-1540206395-68808572332f?w=800&h=400&fit=crop",  // Ocean sunset
      "https://images.unsplash.com/photo-1511690656952-34342bb7c2f2?w=800&h=400&fit=crop", // Northern lights
      "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=800&h=400&fit=crop", // Food - pizza
      "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?w=800&h=400&fit=crop"  // Restaurant dish
    };
    String[] captions = {
      "Ocean Sunset",
      "Northern Lights",
      "Artisan Pizza",
      "Gourmet Dining"
    };

    for (int i = 0; i < imageUrls.length; i++) {
      CarouselItem slide = new CarouselItem();
      slide.setHtml(
        "<div style=\"position: relative; height: 250px; overflow: hidden;\">" +
        "<img src=\"" + imageUrls[i] + "\" alt=\"" + captions[i] + "\" style=\"width: 100%; height: 100%; object-fit: cover;\">" +
        "<div style=\"position: absolute; bottom: 0; left: 0; right: 0; background: linear-gradient(to top, rgba(0,0,0,0.7), transparent); padding: 20px;\">" +
        "<h3 style=\"color: white; margin: 0; font-size: 1.5rem; text-shadow: 0 2px 4px rgba(0,0,0,0.5);\">" + captions[i] + "</h3>" +
        "</div>" +
        "</div>"
      );
      autoplayCarousel.addItem(slide);
    }

    Div autoplayCode = new Div();
    autoplayCode.setText(
      "Carousel carousel = new Carousel();\n" +
      "carousel.setAutoplay(true);\n" +
      "carousel.setAutoplayInterval(2000);  // 2 seconds\n" +
      "carousel.setLoop(true);\n" +
      "carousel.setMouseDragging(true);     // Allow drag to pause"
    );
    styleCodeBlock(autoplayCode);

    autoplayDemo.add(autoplayCarousel, autoplayCode);
    autoplayExample.add(autoplayDemo);

    // Vertical orientation section
    FlexLayout verticalExample = createSection(
      "Vertical Orientation",
      "Carousels can be oriented vertically for different layout needs."
    );

    FlexLayout verticalDemo = new FlexLayout();
    verticalDemo.setDirection(FlexDirection.COLUMN);
    verticalDemo.setSpacing("20px");

    Carousel verticalCarousel = new Carousel();
    verticalCarousel.setOrientation(Carousel.Orientation.VERTICAL);
    verticalCarousel.setNavigation(true);
    verticalCarousel.setPagination(true);
    verticalCarousel.setStyle("height", "400px");

    // Add landscape images for vertical carousel
    String[] landscapeImages = {
      "https://images.unsplash.com/photo-1469474968028-56623f02e42e?w=600&h=150&fit=crop", // Nature landscape
      "https://images.unsplash.com/photo-1426604966848-d7adac402bff?w=600&h=150&fit=crop", // Mountains
      "https://images.unsplash.com/photo-1494500764479-0c8f2919a3d8?w=600&h=150&fit=crop", // Lake
      "https://images.unsplash.com/photo-1472214103451-9374bd1c798e?w=600&h=150&fit=crop"  // Sunset field
    };
    String[] landscapeNames = {"Mountain Valley", "Alpine Peaks", "Serene Lake", "Golden Fields"};

    for (int i = 0; i < landscapeImages.length; i++) {
      CarouselItem slide = new CarouselItem();
      slide.setHtml(
        "<div style=\"height: 100px; overflow: hidden; position: relative;\">" +
        "<img src=\"" + landscapeImages[i] + "\" alt=\"" + landscapeNames[i] + "\" style=\"width: 100%; height: 100%; object-fit: cover;\">" +
        "<div style=\"position: absolute; inset: 0; background: linear-gradient(to right, rgba(0,0,0,0.5), transparent); display: flex; align-items: center; padding: 0 20px;\">" +
        "<span style=\"color: white; font-weight: bold; text-shadow: 0 2px 4px rgba(0,0,0,0.8);\">" + landscapeNames[i] + "</span>" +
        "</div>" +
        "</div>"
      );
      verticalCarousel.addItem(slide);
    }

    Div verticalCode = new Div();
    verticalCode.setText(
      "Carousel carousel = new Carousel();\n" +
      "carousel.setOrientation(Carousel.Orientation.VERTICAL);\n" +
      "carousel.setNavigation(true);\n" +
      "carousel.setPagination(true);"
    );
    styleCodeBlock(verticalCode);

    verticalDemo.add(verticalCarousel, verticalCode);
    verticalExample.add(verticalDemo);

    // Interactive example
    FlexLayout interactiveExample = createSection(
      "Interactive Example",
      "Customize carousel properties to see how they affect behavior."
    );

    FlexLayout interactiveDemo = new FlexLayout();
    interactiveDemo.setDirection(FlexDirection.COLUMN);
    interactiveDemo.setSpacing("20px");

    // Controls
    FlexLayout controls = new FlexLayout();
    controls.setDirection(FlexDirection.COLUMN);
    controls.setSpacing("15px");

    CheckBox navigationCheck = new CheckBox("Show Navigation");
    navigationCheck.setChecked(true);

    CheckBox paginationCheck = new CheckBox("Show Pagination");
    paginationCheck.setChecked(true);

    CheckBox loopCheck = new CheckBox("Enable Loop");
    loopCheck.setChecked(false);

    CheckBox autoplayCheck = new CheckBox("Enable Autoplay");
    autoplayCheck.setChecked(false);

    CheckBox mouseDragCheck = new CheckBox("Enable Mouse Dragging");
    mouseDragCheck.setChecked(false);

    Slider slidesPerPageSlider = new Slider();
    slidesPerPageSlider.setMin(1);
    slidesPerPageSlider.setMax(4);
    slidesPerPageSlider.setValue(1);
    slidesPerPageSlider.setTicksVisible(true);
    slidesPerPageSlider.setLabelsVisible(true);
    Label slidesPerPageLabel = new Label("Slides per page: 1");

    ChoiceBox orientationChoice = new ChoiceBox();
    orientationChoice.setLabel("Orientation");
    orientationChoice.add("horizontal", "Horizontal");
    orientationChoice.add("vertical", "Vertical");
    orientationChoice.selectKey("horizontal");

    controls.add(navigationCheck, paginationCheck, loopCheck, autoplayCheck,
                 mouseDragCheck, slidesPerPageLabel, slidesPerPageSlider, orientationChoice);

    // Interactive carousel
    Carousel interactiveCarousel = new Carousel();
    interactiveCarousel.setNavigation(true);
    interactiveCarousel.setPagination(true);
    interactiveCarousel.setStyle("--aspect-ratio", "2/1");

    // Add diverse images for interactive carousel
    String[] interactiveImages = {
      "https://images.unsplash.com/photo-1682686581498-5e85c7228119?w=800&h=400&fit=crop", // Aurora
      "https://images.unsplash.com/photo-1519904981063-b0cf448d479e?w=800&h=400&fit=crop", // Coffee
      "https://images.unsplash.com/photo-1444927714506-8492d94b4e3d?w=800&h=400&fit=crop", // Jellyfish
      "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&h=400&fit=crop", // Eiffel Tower
      "https://images.unsplash.com/photo-1490750967868-88aa4486c946?w=800&h=400&fit=crop", // Flowers
      "https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=800&h=400&fit=crop"  // Sushi
    };
    String[] imageDescriptions = {
      "Aurora Borealis",
      "Morning Coffee",
      "Ocean Jellyfish",
      "Paris at Night",
      "Spring Blossoms",
      "Japanese Cuisine"
    };

    for (int i = 0; i < interactiveImages.length; i++) {
      CarouselItem slide = new CarouselItem();
      slide.setHtml(
        "<div style=\"position: relative; height: 200px; overflow: hidden;\">" +
        "<img src=\"" + interactiveImages[i] + "\" alt=\"" + imageDescriptions[i] + "\" style=\"width: 100%; height: 100%; object-fit: cover;\">" +
        "<div style=\"position: absolute; top: 20px; left: 20px; background: rgba(0,0,0,0.7); color: white; padding: 8px 16px; border-radius: 4px; font-weight: bold;\">" +
        imageDescriptions[i] +
        "</div>" +
        "</div>"
      );
      interactiveCarousel.addItem(slide);
    }

    // Event handlers
    navigationCheck.addValueChangeListener(e ->
      interactiveCarousel.setNavigation(navigationCheck.isChecked())
    );

    paginationCheck.addValueChangeListener(e ->
      interactiveCarousel.setPagination(paginationCheck.isChecked())
    );

    loopCheck.addValueChangeListener(e ->
      interactiveCarousel.setLoop(loopCheck.isChecked())
    );

    autoplayCheck.addValueChangeListener(e ->
      interactiveCarousel.setAutoplay(autoplayCheck.isChecked())
    );

    mouseDragCheck.addValueChangeListener(e ->
      interactiveCarousel.setMouseDragging(mouseDragCheck.isChecked())
    );

    slidesPerPageSlider.addValueChangeListener(e -> {
      int value = slidesPerPageSlider.getValue().intValue();
      slidesPerPageLabel.setText("Slides per page: " + value);
      interactiveCarousel.setSlidesPerPage(value);
      interactiveCarousel.setSlidesPerMove(value);
    });

    orientationChoice.onSelect(e -> {
      String orientation = (String) orientationChoice.getSelectedKey();
      interactiveCarousel.setOrientation(orientation);
      if ("vertical".equals(orientation)) {
        interactiveCarousel.setStyle("height", "400px");
        interactiveCarousel.setStyle("--aspect-ratio", "");
      } else {
        interactiveCarousel.setStyle("height", "");
        interactiveCarousel.setStyle("--aspect-ratio", "2/1");
      }
    });

    interactiveDemo.add(controls, interactiveCarousel);
    interactiveExample.add(interactiveDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Carousel component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events section
    FlexLayout eventsExample = createSection(
      "Events",
      "Carousel components emit events that you can listen to for interactivity."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Event carousel
    Carousel eventCarousel = new Carousel();
    eventCarousel.setNavigation(true);
    eventCarousel.setPagination(true);
    eventCarousel.setLoop(true);
    eventCarousel.setStyle("--aspect-ratio", "16/9");

    // Add slides for event demo
    String[] colors = {"#FF6B6B", "#4ECDC4", "#45B7D1", "#96CEB4", "#FECA57"};
    String[] slideNames = {"Red Slide", "Teal Slide", "Blue Slide", "Green Slide", "Yellow Slide"};
    
    for (int i = 0; i < colors.length; i++) {
      CarouselItem slide = new CarouselItem();
      slide.setHtml(
        "<div style='background: " + colors[i] + "; height: 200px; display: flex; align-items: center; justify-content: center; color: white; font-size: 24px; font-weight: bold;'>" +
        "Slide " + (i + 1) + ": " + slideNames[i] +
        "</div>"
      );
      eventCarousel.addItem(slide);
    }

    // Event output labels
    Label slideChangeLabel = new Label("Slide Change Event: No event yet");
    slideChangeLabel.setStyle("font-size", "14px")
                    .setStyle("color", "#6c757d")
                    .setStyle("padding", "10px")
                    .setStyle("background", "#f8f9fa")
                    .setStyle("border-radius", "4px")
                    .setStyle("border", "1px solid #dee2e6");

    Label currentSlideLabel = new Label("Current Slide: 0");
    currentSlideLabel.setStyle("font-size", "14px")
                     .setStyle("color", "#495057")
                     .setStyle("font-weight", "bold");

    // Add slide change listener
    eventCarousel.onSlideChange(event -> {
      int index = event.getIndex();
      slideChangeLabel.setText("Slide Change Event: Changed to slide " + index + " (" + slideNames[index] + ")");
      slideChangeLabel.setStyle("color", "#28a745");
      currentSlideLabel.setText("Current Slide: " + index);
      
      // Color will reset naturally on next event
    });

    Div eventsCode = new Div();
    eventsCode.setText(
      "// Listen for slide change events\n" +
      "carousel.onSlideChange(event -> {\n" +
      "    int slideIndex = event.getIndex();\n" +
      "    System.out.println(\"Changed to slide: \" + slideIndex);\n" +
      "    \n" +
      "    // Update UI based on current slide\n" +
      "    updateSlideInfo(slideIndex);\n" +
      "});\n\n" +
      "// The event provides:\n" +
      "// - getIndex(): Current slide index (0-based)\n" +
      "// - getSlide(): Reference to the slide element"
    );
    styleCodeBlock(eventsCode);

    eventsDemo.add(eventCarousel, currentSlideLabel, slideChangeLabel, eventsCode);
    eventsExample.add(eventsDemo);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsExample.add(eventsTable);

    // Add all sections to main layout
    self.add(header, basicExample, multipleExample, autoplayExample,
             verticalExample, interactiveExample, eventsExample, propertiesSection);
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
    String[][] properties = {
      {"loop", "Allows infinite navigation", "boolean", "false"},
      {"navigation", "Shows navigation buttons", "boolean", "false"},
      {"pagination", "Shows pagination dots", "boolean", "false"},
      {"slidesPerPage", "Number of slides visible at once", "int", "1"},
      {"slidesPerMove", "Number of slides to advance per move", "int", "1"},
      {"orientation", "Carousel orientation", "String", "\"horizontal\""},
      {"mouseDragging", "Enables mouse dragging", "boolean", "false"},
      {"autoplay", "Enables automatic progression", "boolean", "false"},
      {"autoplayInterval", "Autoplay interval in milliseconds", "int", "3000"}
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
    FlexLayout slideChangeRow = createTableRow(false);
    slideChangeRow.add(
      createTableCell("sl-slide-change", false),
      createTableCell("Emitted when the active slide changes", false),
      createTableCell("index: number - The index of the current slide", false)
    );
    table.add(slideChangeRow);

    return table;
  }
}
