package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Divider;
import com.webforj.libraries.shoelace.components.Dropdown;
import com.webforj.libraries.shoelace.components.Icon;
import com.webforj.libraries.shoelace.components.Menu;
import com.webforj.libraries.shoelace.components.MenuItem;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/dropdown", outlet = MainLayout.class)
@FrameTitle("Dropdown")
public class DropdownView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public DropdownView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Dropdown");
    Paragraph description = new Paragraph(
      "Dropdowns expose additional content that \"drops down\" in a panel. They're commonly used " +
      "for menus, command palettes, and to toggle additional options."
    );

    // Documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Dropdown.html",
      "https://shoelace.style/components/dropdown"
    );

    header.add(title, description, docLinks);

    // Basic dropdown section
    FlexLayout basicExample = createSection(
      "Basic Dropdown",
      "A simple dropdown with a button trigger and menu content."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    // Create basic dropdown
    Dropdown basicDropdown = new Dropdown();

    // Add trigger button
    Div triggerSlot = new Div();
    triggerSlot.setAttribute("slot", "trigger");
    ShoelaceButton triggerBtn = new ShoelaceButton("Dropdown");
    triggerBtn.setCaret(true);
    triggerSlot.add(triggerBtn);

    // Add menu content
    Menu basicMenu = new Menu();
    basicMenu.add(
      new MenuItem("Cut").setValue("cut"),
      new MenuItem("Copy").setValue("copy"),
      new MenuItem("Paste").setValue("paste"),
      new Divider(),
      new MenuItem("Find").setValue("find"),
      new MenuItem("Replace").setValue("replace")
    );

    basicDropdown.add(triggerSlot, basicMenu);

    Div basicCode = new Div();
    basicCode.setText(
      "// Create dropdown with menu\n" +
      "Dropdown dropdown = new Dropdown();\n\n" +
      "// Add trigger button\n" +
      "ShoelaceButton trigger = new ShoelaceButton(\"Dropdown\");\n" +
      "trigger.setAttribute(\"slot\", \"trigger\");\n" +
      "trigger.setCaret(true);\n\n" +
      "// Add menu items\n" +
      "Menu menu = new Menu();\n" +
      "menu.add(\n" +
      "  new MenuItem(\"Cut\"),\n" +
      "  new MenuItem(\"Copy\"),\n" +
      "  new MenuItem(\"Paste\")\n" +
      ");\n\n" +
      "dropdown.add(trigger, menu);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicDropdown, basicCode);
    basicExample.add(basicDemo);

    // Placement section
    FlexLayout placementExample = createSection(
      "Dropdown Placement",
      "Control where the dropdown panel appears relative to the trigger."
    );

    FlexLayout placementDemo = new FlexLayout();
    placementDemo.setDirection(FlexDirection.COLUMN);
    placementDemo.setSpacing("20px");

    FlexLayout placementGrid = new FlexLayout();
    placementGrid.setWrap(com.webforj.component.layout.flexlayout.FlexWrap.WRAP);
    placementGrid.setSpacing("10px");

    // Create dropdowns for different placements
    String[] placements = {"top", "top-start", "top-end", "bottom", "bottom-start", "bottom-end", "left", "right"};

    for (String placement : placements) {
      Dropdown dropdown = new Dropdown();
      dropdown.setPlacement(placement);

      Div slot = new Div();
      slot.setAttribute("slot", "trigger");
      ShoelaceButton btn = new ShoelaceButton(placement);
      btn.setSize(ShoelaceButton.Size.SMALL);
      slot.add(btn);

      Menu menu = new Menu();
      menu.add(
        new MenuItem("Item 1"),
        new MenuItem("Item 2"),
        new MenuItem("Item 3")
      );

      dropdown.add(slot, menu);
      placementGrid.add(dropdown);
    }

    Div placementCode = new Div();
    placementCode.setText(
      "// Set dropdown placement\n" +
      "dropdown.setPlacement(Dropdown.Placement.TOP);\n" +
      "dropdown.setPlacement(Dropdown.Placement.BOTTOM_START);\n" +
      "dropdown.setPlacement(Dropdown.Placement.RIGHT);\n\n" +
      "// Or use string values\n" +
      "dropdown.setPlacement(\"top-end\");"
    );
    styleCodeBlock(placementCode);

    placementDemo.add(placementGrid, placementCode);
    placementExample.add(placementDemo);

    // Distance and skidding section
    FlexLayout offsetExample = createSection(
      "Distance & Skidding",
      "Fine-tune the dropdown position with distance and skidding offsets."
    );

    FlexLayout offsetDemo = new FlexLayout();
    offsetDemo.setDirection(FlexDirection.COLUMN);
    offsetDemo.setSpacing("20px");

    FlexLayout offsetContainer = new FlexLayout();
    offsetContainer.setSpacing("20px");
    offsetContainer.setAlignment(FlexAlignment.CENTER);

    // Distance example
    Dropdown distanceDropdown = new Dropdown();
    distanceDropdown.setDistance(20);

    Div distanceSlot = new Div();
    distanceSlot.setAttribute("slot", "trigger");
    ShoelaceButton distanceBtn = new ShoelaceButton("Distance: 20px");
    distanceSlot.add(distanceBtn);

    Menu distanceMenu = new Menu();
    distanceMenu.add(
      new MenuItem("Notice the gap"),
      new MenuItem("Between trigger"),
      new MenuItem("And dropdown")
    );

    distanceDropdown.add(distanceSlot, distanceMenu);

    // Skidding example
    Dropdown skiddingDropdown = new Dropdown();
    skiddingDropdown.setSkidding(30);

    Div skiddingSlot = new Div();
    skiddingSlot.setAttribute("slot", "trigger");
    ShoelaceButton skiddingBtn = new ShoelaceButton("Skidding: 30px");
    skiddingSlot.add(skiddingBtn);

    Menu skiddingMenu = new Menu();
    skiddingMenu.add(
      new MenuItem("Shifted to the side"),
      new MenuItem("By 30 pixels"),
      new MenuItem("From default position")
    );

    skiddingDropdown.add(skiddingSlot, skiddingMenu);

    offsetContainer.add(distanceDropdown, skiddingDropdown);

    Div offsetCode = new Div();
    offsetCode.setText(
      "// Set distance from trigger\n" +
      "dropdown.setDistance(20); // 20px gap\n\n" +
      "// Set lateral offset\n" +
      "dropdown.setSkidding(30); // 30px to the side\n\n" +
      "// Combine both\n" +
      "dropdown.setDistance(10).setSkidding(-20);"
    );
    styleCodeBlock(offsetCode);

    offsetDemo.add(offsetContainer, offsetCode);
    offsetExample.add(offsetDemo);

    // Hoisting section
    FlexLayout hoistExample = createSection(
      "Hoisting",
      "Hoist the dropdown to prevent clipping in scrollable containers."
    );

    FlexLayout hoistDemo = new FlexLayout();
    hoistDemo.setDirection(FlexDirection.COLUMN);
    hoistDemo.setSpacing("20px");

    // Create a scrollable container
    Div scrollContainer = new Div();
    scrollContainer.setStyle("height", "200px");
    scrollContainer.setStyle("overflow", "auto");
    scrollContainer.setStyle("border", "1px solid #dee2e6");
    scrollContainer.setStyle("border-radius", "8px");
    scrollContainer.setStyle("padding", "20px");
    scrollContainer.setStyle("background", "#f8f9fa");

    Paragraph scrollText = new Paragraph(
      "This is a scrollable container. The dropdown below is hoisted, so it won't be " +
      "clipped by the container's boundaries. Try scrolling while the dropdown is open."
    );

    Dropdown hoistedDropdown = new Dropdown();
    hoistedDropdown.setHoist(true);

    Div hoistSlot = new Div();
    hoistSlot.setAttribute("slot", "trigger");
    ShoelaceButton hoistBtn = new ShoelaceButton("Hoisted Dropdown");
    hoistSlot.add(hoistBtn);

    Menu hoistMenu = new Menu();
    hoistMenu.add(
      new MenuItem("This dropdown"),
      new MenuItem("Escapes the container"),
      new MenuItem("Using hoisting")
    );

    hoistedDropdown.add(hoistSlot, hoistMenu);

    scrollContainer.add(scrollText, hoistedDropdown);

    Div hoistCode = new Div();
    hoistCode.setText(
      "// Enable hoisting\n" +
      "dropdown.setHoist(true);\n\n" +
      "// Useful in:\n" +
      "// - Scrollable containers\n" +
      "// - Modals and dialogs\n" +
      "// - Tables with overflow"
    );
    styleCodeBlock(hoistCode);

    hoistDemo.add(scrollContainer, hoistCode);
    hoistExample.add(hoistDemo);

    // Stay open on select section
    FlexLayout stayOpenExample = createSection(
      "Stay Open on Select",
      "Keep the dropdown open when items are selected."
    );

    FlexLayout stayOpenDemo = new FlexLayout();
    stayOpenDemo.setDirection(FlexDirection.COLUMN);
    stayOpenDemo.setSpacing("20px");

    Dropdown stayOpenDropdown = new Dropdown();
    stayOpenDropdown.setStayOpenOnSelect(true);

    Div stayOpenSlot = new Div();
    stayOpenSlot.setAttribute("slot", "trigger");
    ShoelaceButton stayOpenBtn = new ShoelaceButton("Select Multiple");
    stayOpenBtn.setCaret(true);
    stayOpenSlot.add(stayOpenBtn);

    Menu stayOpenMenu = new Menu();

    // Create checkbox-style menu items
    MenuItem option1 = new MenuItem("Option 1");
    option1.setPrefix(new Icon("square"));

    MenuItem option2 = new MenuItem("Option 2");
    option2.setPrefix(new Icon("check-square"));

    MenuItem option3 = new MenuItem("Option 3");
    option3.setPrefix(new Icon("square"));

    stayOpenMenu.add(option1, option2, option3);
    stayOpenDropdown.add(stayOpenSlot, stayOpenMenu);

    Div stayOpenCode = new Div();
    stayOpenCode.setText(
      "// Keep dropdown open on select\n" +
      "dropdown.setStayOpenOnSelect(true);\n\n" +
      "// Useful for:\n" +
      "// - Multi-select menus\n" +
      "// - Settings panels\n" +
      "// - Filter dropdowns"
    );
    styleCodeBlock(stayOpenCode);

    stayOpenDemo.add(stayOpenDropdown, stayOpenCode);
    stayOpenExample.add(stayOpenDemo);

    // Disabled section
    FlexLayout disabledExample = createSection(
      "Disabled State",
      "Disable the dropdown to prevent it from opening."
    );

    FlexLayout disabledDemo = new FlexLayout();
    disabledDemo.setDirection(FlexDirection.COLUMN);
    disabledDemo.setSpacing("20px");

    Dropdown disabledDropdown = new Dropdown();
    disabledDropdown.setDisabled(true);

    Div disabledSlot = new Div();
    disabledSlot.setAttribute("slot", "trigger");
    ShoelaceButton disabledBtn = new ShoelaceButton("Disabled Dropdown");
    disabledBtn.setDisabled(true);
    disabledSlot.add(disabledBtn);

    Menu disabledMenu = new Menu();
    disabledMenu.add(new MenuItem("You can't see this"));

    disabledDropdown.add(disabledSlot, disabledMenu);

    Div disabledCode = new Div();
    disabledCode.setText(
      "// Disable dropdown\n" +
      "dropdown.setDisabled(true);\n\n" +
      "// Don't forget to disable the trigger too\n" +
      "triggerButton.setDisabled(true);"
    );
    styleCodeBlock(disabledCode);

    disabledDemo.add(disabledDropdown, disabledCode);
    disabledExample.add(disabledDemo);

    // Event handling section
    FlexLayout eventsExample = createSection(
      "Event Handling",
      "Handle dropdown lifecycle events to respond to user interactions."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    Paragraph eventNote = new Paragraph(
      "Note: Direct event handling through addEventListener is not currently supported " +
      "in ElementComposite. Use JavaScript interop or handle events at the view level."
    );
    eventNote.setStyle("background", "#fff3cd")
             .setStyle("border", "1px solid #ffecb5")
             .setStyle("color", "#664d03")
             .setStyle("padding", "12px")
             .setStyle("border-radius", "4px")
             .setStyle("font-size", "14px");

    Div eventCode = new Div();
    eventCode.setText(
      "// Available events (via JavaScript interop):\n" +
      "// - sl-show: Emitted when the dropdown opens\n" +
      "// - sl-after-show: Emitted after the dropdown opens and all animations are complete\n" +
      "// - sl-hide: Emitted when the dropdown closes\n" +
      "// - sl-after-hide: Emitted after the dropdown closes and all animations are complete\n" +
      "\n" +
      "// Example JavaScript interop:\n" +
      "dropdown.getElement().executeJs(\n" +
      "  \"this.addEventListener('sl-show', () => console.log('Dropdown opened'));\"\n" +
      ");"
    );
    styleCodeBlock(eventCode);

    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsExample.add(eventsTable);

    eventsDemo.add(eventNote, eventCode);
    eventsExample.add(eventsDemo);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Dropdown component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, placementExample, offsetExample,
             hoistExample, stayOpenExample, disabledExample, eventsExample, propertiesSection);
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
      {"open", "Controls dropdown visibility", "boolean", "false"},
      {"placement", "Panel position", "String", "\"bottom-start\""},
      {"disabled", "Prevents opening", "boolean", "false"},
      {"stay-open-on-select", "Keep open on select", "boolean", "false"},
      {"distance", "Offset from trigger", "int", "0"},
      {"skidding", "Lateral offset", "int", "0"},
      {"hoist", "Prevent clipping", "boolean", "false"},
      {"show()", "Opens dropdown", "method", "-"},
      {"hide()", "Closes dropdown", "method", "-"},
      {"toggle()", "Toggles open state", "method", "-"}
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
      {"sl-show", "Emitted when the dropdown opens", "None"},
      {"sl-after-show", "Emitted after the dropdown opens and all animations are complete", "None"},
      {"sl-hide", "Emitted when the dropdown closes", "None"},
      {"sl-after-hide", "Emitted after the dropdown closes and all animations are complete", "None"}
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
