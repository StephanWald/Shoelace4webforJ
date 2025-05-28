package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Divider;
import com.webforj.libraries.shoelace.components.Drawer;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/drawer", outlet = MainLayout.class)
@FrameTitle("Drawer")
public class DrawerView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public DrawerView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Drawer");
    Paragraph description = new Paragraph(
      "Drawers slide in from the edge of the screen to display additional content. " +
      "They're commonly used for navigation menus, settings panels, and detail views."
    );

    // Documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Drawer.html",
      "https://shoelace.style/components/drawer"
    );

    header.add(title, description, docLinks);

    // Basic drawer section
    FlexLayout basicExample = createSection(
      "Basic Drawer",
      "A simple drawer that slides in from the end (right) side."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    // Create basic drawer
    Drawer basicDrawer = new Drawer("Drawer Title");

    Paragraph drawerContent = new Paragraph(
      "This is the drawer content. You can place any content here including forms, " +
      "lists, images, or other components. The drawer will automatically handle scrolling " +
      "if the content exceeds the viewport height."
    );

    // Add footer with close button
    Div basicFooter = new Div();
    basicFooter.setAttribute("slot", "footer");
    ShoelaceButton closeBtn = new ShoelaceButton("Close");
    closeBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    // Note: onClick not available - would need JavaScript interop
    basicFooter.add(closeBtn);

    basicDrawer.add(drawerContent, basicFooter);

    // Button to open drawer
    ShoelaceButton openBasicBtn = new ShoelaceButton("Open Drawer");
    openBasicBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    // Note: onClick not available - would need JavaScript interop

    Div basicCode = new Div();
    basicCode.setText(
      "// Create a drawer\n" +
      "Drawer drawer = new Drawer(\"Drawer Title\");\n" +
      "drawer.add(content);\n\n" +
      "// Add footer\n" +
      "Div footer = new Div();\n" +
      "footer.setAttribute(\"slot\", \"footer\");\n" +
      "footer.add(closeButton);\n" +
      "drawer.add(footer);\n\n" +
      "// Show the drawer\n" +
      "drawer.show();"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(openBasicBtn, basicDrawer, basicCode);
    basicExample.add(basicDemo);

    // Placement section
    FlexLayout placementExample = createSection(
      "Drawer Placement",
      "Drawers can slide in from any edge of the screen."
    );

    FlexLayout placementDemo = new FlexLayout();
    placementDemo.setDirection(FlexDirection.COLUMN);
    placementDemo.setSpacing("20px");

    // Create drawers for each placement
    Drawer topDrawer = new Drawer("Top Drawer", Drawer.Placement.TOP);
    topDrawer.add(new Paragraph("This drawer slides in from the top."));
    addDrawerFooter(topDrawer);

    Drawer endDrawer = new Drawer("End Drawer", Drawer.Placement.END);
    endDrawer.add(new Paragraph("This drawer slides in from the end (right in LTR)."));
    addDrawerFooter(endDrawer);

    Drawer bottomDrawer = new Drawer("Bottom Drawer", Drawer.Placement.BOTTOM);
    bottomDrawer.add(new Paragraph("This drawer slides in from the bottom."));
    addDrawerFooter(bottomDrawer);

    Drawer startDrawer = new Drawer("Start Drawer", Drawer.Placement.START);
    startDrawer.add(new Paragraph("This drawer slides in from the start (left in LTR)."));
    addDrawerFooter(startDrawer);

    FlexLayout placementButtons = new FlexLayout();
    placementButtons.setSpacing("10px");
    placementButtons.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);

    ShoelaceButton openTopBtn = new ShoelaceButton("Open Top");
    ShoelaceButton openEndBtn = new ShoelaceButton("Open End");
    ShoelaceButton openBottomBtn = new ShoelaceButton("Open Bottom");
    ShoelaceButton openStartBtn = new ShoelaceButton("Open Start");

    placementButtons.add(openTopBtn, openEndBtn, openBottomBtn, openStartBtn);

    Div placementCode = new Div();
    placementCode.setText(
      "// Set drawer placement\n" +
      "drawer.setPlacement(Drawer.Placement.TOP);\n" +
      "drawer.setPlacement(Drawer.Placement.END);\n" +
      "drawer.setPlacement(Drawer.Placement.BOTTOM);\n" +
      "drawer.setPlacement(Drawer.Placement.START);\n\n" +
      "// Or create with placement\n" +
      "Drawer drawer = new Drawer(\"Title\", Drawer.Placement.START);"
    );
    styleCodeBlock(placementCode);

    placementDemo.add(placementButtons, topDrawer, endDrawer, bottomDrawer, startDrawer, placementCode);
    placementExample.add(placementDemo);

    // Custom width section
    FlexLayout widthExample = createSection(
      "Custom Size",
      "Customize the drawer size to fit your content."
    );

    FlexLayout widthDemo = new FlexLayout();
    widthDemo.setDirection(FlexDirection.COLUMN);
    widthDemo.setSpacing("20px");

    // Small drawer
    Drawer smallDrawer = new Drawer("Small Drawer");
    smallDrawer.setSize("200px");
    smallDrawer.add(new Paragraph("This is a narrow drawer with a width of 200px."));
    addDrawerFooter(smallDrawer);

    // Large drawer
    Drawer largeDrawer = new Drawer("Large Drawer");
    largeDrawer.setSize("600px");
    largeDrawer.add(new Paragraph("This is a wide drawer with a width of 600px. Perfect for displaying detailed content or forms."));
    addDrawerFooter(largeDrawer);

    // Percentage drawer
    Drawer percentDrawer = new Drawer("Responsive Drawer");
    percentDrawer.setSize("80vw");
    percentDrawer.add(new Paragraph("This drawer takes up 80% of the viewport width, making it responsive to different screen sizes."));
    addDrawerFooter(percentDrawer);

    FlexLayout widthButtons = new FlexLayout();
    widthButtons.setSpacing("10px");

    ShoelaceButton openSmallBtn = new ShoelaceButton("Small (200px)");
    ShoelaceButton openLargeBtn = new ShoelaceButton("Large (600px)");
    ShoelaceButton openPercentBtn = new ShoelaceButton("Responsive (80vw)");

    widthButtons.add(openSmallBtn, openLargeBtn, openPercentBtn);

    Div widthCode = new Div();
    widthCode.setText(
      "// Set custom size\n" +
      "drawer.setSize(\"300px\");\n" +
      "drawer.setSize(\"50vw\");\n" +
      "drawer.setSize(\"600px\");\n\n" +
      "// Custom spacing\n" +
      "drawer.setHeaderSpacing(\"2rem\");\n" +
      "drawer.setBodySpacing(\"2rem\");\n" +
      "drawer.setFooterSpacing(\"1rem\");"
    );
    styleCodeBlock(widthCode);

    widthDemo.add(widthButtons, smallDrawer, largeDrawer, percentDrawer, widthCode);
    widthExample.add(widthDemo);

    // No header section
    FlexLayout noHeaderExample = createSection(
      "Drawer Without Header",
      "Hide the header for a cleaner look when you don't need a title."
    );

    FlexLayout noHeaderDemo = new FlexLayout();
    noHeaderDemo.setDirection(FlexDirection.COLUMN);
    noHeaderDemo.setSpacing("20px");

    Drawer noHeaderDrawer = new Drawer();
    noHeaderDrawer.setNoHeader(true);
    noHeaderDrawer.setSize("400px");

    FlexLayout customHeader = new FlexLayout();
    customHeader.setDirection(FlexDirection.COLUMN);
    customHeader.setSpacing("20px");
    customHeader.setStyle("padding", "20px");

    H3 customTitle = new H3("Custom Content Layout");
    customTitle.setStyle("margin", "0");

    Paragraph customContent = new Paragraph(
      "When you hide the header, you have full control over the drawer's content layout. " +
      "This is useful for creating custom navigation menus or specialized interfaces."
    );

    customHeader.add(customTitle, customContent);
    noHeaderDrawer.add(customHeader);

    // Add custom close button
    Div closeButtonContainer = new Div();
    closeButtonContainer.setStyle("position", "absolute");
    closeButtonContainer.setStyle("top", "10px");
    closeButtonContainer.setStyle("right", "10px");
    ShoelaceButton customCloseBtn = new ShoelaceButton("×");
    customCloseBtn.setVariant(ShoelaceButton.Variant.TEXT);
    customCloseBtn.setStyle("font-size", "24px");
    closeButtonContainer.add(customCloseBtn);
    noHeaderDrawer.add(closeButtonContainer);

    ShoelaceButton openNoHeaderBtn = new ShoelaceButton("Open Drawer Without Header");

    Div noHeaderCode = new Div();
    noHeaderCode.setText(
      "// Create drawer without header\n" +
      "Drawer drawer = new Drawer();\n" +
      "drawer.setNoHeader(true);\n\n" +
      "// Add custom content\n" +
      "drawer.add(customLayout);"
    );
    styleCodeBlock(noHeaderCode);

    noHeaderDemo.add(openNoHeaderBtn, noHeaderDrawer, noHeaderCode);
    noHeaderExample.add(noHeaderDemo);

    // Navigation drawer example
    FlexLayout navExample = createSection(
      "Navigation Drawer",
      "Create a navigation menu using the drawer component."
    );

    FlexLayout navDemo = new FlexLayout();
    navDemo.setDirection(FlexDirection.COLUMN);
    navDemo.setSpacing("20px");

    Drawer navDrawer = new Drawer("Navigation");
    navDrawer.setPlacement(Drawer.Placement.START);
    navDrawer.setSize("280px");

    // Create navigation menu
    FlexLayout navMenu = new FlexLayout();
    navMenu.setDirection(FlexDirection.COLUMN);
    navMenu.setSpacing("5px");
    navMenu.setStyle("padding", "10px");

    navMenu.add(
      createNavItem("Dashboard", "📊"),
      createNavItem("Profile", "👤"),
      createNavItem("Messages", "💬"),
      createNavItem("Settings", "⚙️"),
      new Divider(),
      createNavItem("Help", "❓"),
      createNavItem("Logout", "🚪")
    );

    navDrawer.add(navMenu);

    ShoelaceButton openNavBtn = new ShoelaceButton("Open Navigation");
    openNavBtn.setPrefix(com.webforj.component.icons.TablerIcon.create("menu-2"));

    Div navCode = new Div();
    navCode.setText(
      "// Create navigation drawer\n" +
      "Drawer navDrawer = new Drawer(\"Navigation\");\n" +
      "navDrawer.setPlacement(Drawer.Placement.START);\n" +
      "navDrawer.setSize(\"280px\");\n\n" +
      "// Add navigation items\n" +
      "FlexLayout menu = new FlexLayout();\n" +
      "menu.add(navItems);\n" +
      "navDrawer.add(menu);"
    );
    styleCodeBlock(navCode);

    navDemo.add(openNavBtn, navDrawer, navCode);
    navExample.add(navDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Drawer component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Event handling section
    FlexLayout eventsSection = createEventsSection();

    // Add all sections to main layout
    self.add(header, basicExample, placementExample, widthExample,
             noHeaderExample, navExample, eventsSection, propertiesSection);
  }

  private void addDrawerFooter(Drawer drawer) {
    Div footer = new Div();
    footer.setAttribute("slot", "footer");
    ShoelaceButton closeBtn = new ShoelaceButton("Close");
    footer.add(closeBtn);
    drawer.add(footer);
  }

  private Div createNavItem(String text, String icon) {
    Div item = new Div();
    item.setText(icon + " " + text);
    item.setStyle("padding", "12px 16px");
    item.setStyle("cursor", "pointer");
    item.setStyle("border-radius", "8px");
    item.setStyle("transition", "background-color 0.2s");
    // Note: onMouseEnter/Leave not available - would need JavaScript interop for hover effects
    return item;
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
      {"open", "Controls drawer visibility", "boolean", "false"},
      {"label", "Drawer title", "String", "\"\""},
      {"placement", "Opening direction", "String", "\"end\""},
      {"contained", "Contained in parent", "boolean", "false"},
      {"no-header", "Hides the header", "boolean", "false"},
      {"show()", "Opens the drawer", "method", "-"},
      {"hide()", "Closes the drawer", "method", "-"},
      {"setSize()", "Sets custom size", "method", "-"}
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

  private FlexLayout createEventsSection() {
    FlexLayout section = createSection(
      "Event Handling",
      "Drawers emit events during their lifecycle, allowing you to hook into show/hide animations and handle close requests."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Event drawer
    Drawer eventDrawer = new Drawer("Event Demo Drawer");
    eventDrawer.setPlacement(Drawer.Placement.END);
    eventDrawer.add(new Paragraph("Watch the event log below as you interact with this drawer."));
    
    Div footer = new Div();
    footer.setAttribute("slot", "footer");
    ShoelaceButton closeBtn = new ShoelaceButton("Close");
    closeBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    // Note: onClick not available - would need JavaScript interop
    footer.add(closeBtn);
    eventDrawer.add(footer);

    // Event status display
    Label eventStatus = new Label("Event log will appear here...");
    eventStatus.setStyle("padding", "16px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border-radius", "8px")
               .setStyle("font-size", "14px")
               .setStyle("min-height", "150px")
               .setStyle("white-space", "pre-wrap")
               .setStyle("border", "1px solid #e9ecef")
               .setStyle("display", "block");

    // Register event handlers (simulated as drawer events would need JavaScript interop)
    // In real implementation, these would be:
    // eventDrawer.onShow(event -> { ... });
    // eventDrawer.onAfterShow(event -> { ... });
    // eventDrawer.onHide(event -> { ... });
    // eventDrawer.onAfterHide(event -> { ... });
    // eventDrawer.onInitialFocus(event -> { ... });
    // eventDrawer.onRequestClose(event -> { ... });

    // Control button
    ShoelaceButton showEventDrawer = new ShoelaceButton("Show Event Drawer");
    showEventDrawer.setVariant(ShoelaceButton.Variant.PRIMARY);
    // Note: onClick not available - would need JavaScript interop

    // Code example
    Div eventCode = new Div();
    eventCode.setText(
      "// Show event - fired when drawer starts to show\n" +
      "drawer.onShow(event -> {\n" +
      "    System.out.println(\"Drawer is opening...\");\n" +
      "});\n\n" +
      "// After show event - fired when show animation completes\n" +
      "drawer.onAfterShow(event -> {\n" +
      "    System.out.println(\"Drawer is fully visible\");\n" +
      "});\n\n" +
      "// Hide event - fired when drawer starts to hide\n" +
      "drawer.onHide(event -> {\n" +
      "    System.out.println(\"Drawer is closing...\");\n" +
      "});\n\n" +
      "// After hide event - fired when hide animation completes\n" +
      "drawer.onAfterHide(event -> {\n" +
      "    System.out.println(\"Drawer is completely hidden\");\n" +
      "});\n\n" +
      "// Initial focus event - fired when drawer gains focus\n" +
      "drawer.onInitialFocus(event -> {\n" +
      "    System.out.println(\"Drawer received focus\");\n" +
      "});\n\n" +
      "// Request close event - fired when user attempts to close\n" +
      "drawer.onRequestClose(event -> {\n" +
      "    String source = event.getSource(); // \"close-button\", \"keyboard\", or \"overlay\"\n" +
      "    if (shouldPreventClose(source)) {\n" +
      "        event.preventDefault(); // Prevent the drawer from closing\n" +
      "    }\n" +
      "});"
    );
    styleCodeBlock(eventCode);

    self.add(eventDrawer);
    // Events table
    FlexLayout eventsTable = createEventsTable();
    section.add(eventsTable);

    eventsDemo.add(showEventDrawer, eventStatus, eventCode);
    section.add(eventsDemo);
    
    return section;
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
      {"sl-show", "Emitted when the drawer starts to show", "None"},
      {"sl-after-show", "Emitted after the drawer opens and all animations are complete", "None"},
      {"sl-hide", "Emitted when the drawer starts to hide", "None"},
      {"sl-after-hide", "Emitted after the drawer closes and all animations are complete", "None"},
      {"sl-initial-focus", "Emitted when the drawer receives focus for the first time", "None"},
      {"sl-request-close", "Emitted when the user attempts to close the drawer", "source: 'close-button' | 'keyboard' | 'overlay'"}
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
