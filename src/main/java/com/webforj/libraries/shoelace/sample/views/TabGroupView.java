package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Tab;
import com.webforj.libraries.shoelace.components.TabGroup;
import com.webforj.libraries.shoelace.components.TabPanel;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.text.Label;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/tabgroup", outlet = MainLayout.class)
@FrameTitle("Tab Group")
public class TabGroupView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public TabGroupView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Tab Group");
    Paragraph description = new Paragraph(
      "Tab groups organize content into a container that shows one section at a time. " +
      "They provide an easy way to switch between different views or content areas."
    );

    // Component import and documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/TabGroup.html",
      "https://shoelace.style/components/tab-group"
    );

    header.add(title, description, docLinks);

    // Basic tabs example
    FlexLayout basicExample = createSection(
      "Basic Tabs",
      "Tab groups consist of tabs and panels. Each tab must be associated with a panel by name."
    );

    TabGroup basicTabs = new TabGroup();

    Tab generalTab = new Tab().setPanel("general").setText("General");
    Tab customTab = new Tab().setPanel("custom").setText("Custom");
    Tab advancedTab = new Tab().setPanel("advanced").setText("Advanced");
    Tab disabledTab = new Tab().setPanel("disabled").setText("Disabled").setDisabled(true);

    basicTabs.addTab(generalTab)
             .addTab(customTab)
             .addTab(advancedTab)
             .addTab(disabledTab);

    TabPanel generalPanel = new TabPanel().setName("general").setActive(true);
    generalPanel.add(new Paragraph("This is the general tab panel."));

    TabPanel customPanel = new TabPanel().setName("custom");
    customPanel.add(new Paragraph("This is the custom tab panel."));

    TabPanel advancedPanel = new TabPanel().setName("advanced");
    advancedPanel.add(new Paragraph("This is the advanced tab panel."));

    TabPanel disabledPanel = new TabPanel().setName("disabled");
    disabledPanel.add(new Paragraph("This is a disabled tab panel."));

    basicTabs.addPanel(generalPanel)
             .addPanel(customPanel)
             .addPanel(advancedPanel)
             .addPanel(disabledPanel);

    Div basicCode = new Div();
    basicCode.setText(
      "TabGroup tabGroup = new TabGroup();\n\n" +
      "// Create tabs\n" +
      "Tab generalTab = new Tab().setPanel(\"general\").setText(\"General\");\n" +
      "Tab customTab = new Tab().setPanel(\"custom\").setText(\"Custom\");\n" +
      "Tab advancedTab = new Tab().setPanel(\"advanced\").setText(\"Advanced\");\n" +
      "Tab disabledTab = new Tab().setPanel(\"disabled\")\n" +
      "    .setText(\"Disabled\").setDisabled(true);\n\n" +
      "tabGroup.addTab(generalTab).addTab(customTab)\n" +
      "        .addTab(advancedTab).addTab(disabledTab);\n\n" +
      "// Create panels\n" +
      "TabPanel generalPanel = new TabPanel()\n" +
      "    .setName(\"general\").setActive(true);\n" +
      "generalPanel.add(new Paragraph(\"General content\"));\n\n" +
      "TabPanel customPanel = new TabPanel().setName(\"custom\");\n" +
      "customPanel.add(new Paragraph(\"Custom content\"));\n\n" +
      "tabGroup.addPanel(generalPanel).addPanel(customPanel);"
    );
    styleCodeBlock(basicCode);

    basicExample.add(basicTabs, basicCode);

    // Tab placement example
    FlexLayout placementExample = createSection(
      "Tab Placement",
      "Tabs can be positioned at the top, bottom, start, or end of the tab group."
    );

    // Bottom placement
    Paragraph bottomLabel = new Paragraph("Bottom placement:");
    bottomLabel.setStyle("font-weight", "600");

    TabGroup bottomTabs = new TabGroup().setPlacement("bottom");

    Tab tab1 = new Tab().setPanel("tab-1").setText("Tab 1");
    Tab tab2 = new Tab().setPanel("tab-2").setText("Tab 2");
    Tab tab3 = new Tab().setPanel("tab-3").setText("Tab 3");

    bottomTabs.addTab(tab1).addTab(tab2).addTab(tab3);

    TabPanel panel1 = new TabPanel().setName("tab-1").setActive(true);
    panel1.add(new Paragraph("Tab panel 1"));

    TabPanel panel2 = new TabPanel().setName("tab-2");
    panel2.add(new Paragraph("Tab panel 2"));

    TabPanel panel3 = new TabPanel().setName("tab-3");
    panel3.add(new Paragraph("Tab panel 3"));

    bottomTabs.addPanel(panel1).addPanel(panel2).addPanel(panel3);

    // Vertical tabs
    Paragraph verticalLabel = new Paragraph("Vertical placement (start):");
    verticalLabel.setStyle("font-weight", "600").setStyle("margin-top", "20px");

    TabGroup verticalTabs = new TabGroup().setPlacement("start");

    Tab vtab1 = new Tab().setPanel("vtab-1").setText("Tab 1");
    Tab vtab2 = new Tab().setPanel("vtab-2").setText("Tab 2");
    Tab vtab3 = new Tab().setPanel("vtab-3").setText("Tab 3");
    Tab vtab4 = new Tab().setPanel("vtab-4").setText("Tab 4");

    verticalTabs.addTab(vtab1).addTab(vtab2).addTab(vtab3).addTab(vtab4);

    TabPanel vpanel1 = new TabPanel().setName("vtab-1").setActive(true);
    vpanel1.add(new Paragraph("This is tab panel 1"));

    TabPanel vpanel2 = new TabPanel().setName("vtab-2");
    vpanel2.add(new Paragraph("This is tab panel 2"));

    TabPanel vpanel3 = new TabPanel().setName("vtab-3");
    vpanel3.add(new Paragraph("This is tab panel 3"));

    TabPanel vpanel4 = new TabPanel().setName("vtab-4");
    vpanel4.add(new Paragraph("This is tab panel 4"));

    verticalTabs.addPanel(vpanel1).addPanel(vpanel2).addPanel(vpanel3).addPanel(vpanel4);

    Div verticalContainer = new Div();
    verticalContainer.setStyle("height", "200px");
    verticalContainer.add(verticalTabs);

    Div placementCode = new Div();
    placementCode.setText(
      "// Bottom placement\n" +
      "TabGroup bottomTabs = new TabGroup().setPlacement(\"bottom\");\n\n" +
      "// Vertical placement\n" +
      "TabGroup verticalTabs = new TabGroup().setPlacement(\"start\");\n" +
      "// Also available: \"end\" for right-side tabs"
    );
    styleCodeBlock(placementCode);

    placementExample.add(bottomLabel, bottomTabs, verticalLabel, verticalContainer, placementCode);

    // Closable tabs
    FlexLayout closableExample = createSection(
      "Closable Tabs",
      "Add the closable attribute to individual tabs to allow users to dismiss them."
    );

    TabGroup closableTabs = new TabGroup();

    Tab ctab1 = new Tab().setPanel("ctab-1").setText("Closable 1").setClosable(true);
    Tab ctab2 = new Tab().setPanel("ctab-2").setText("Closable 2").setClosable(true);
    Tab ctab3 = new Tab().setPanel("ctab-3").setText("Closable 3").setClosable(true);
    Tab ctab4 = new Tab().setPanel("ctab-4").setText("Not Closable");

    closableTabs.addTab(ctab1).addTab(ctab2).addTab(ctab3).addTab(ctab4);

    TabPanel cpanel1 = new TabPanel().setName("ctab-1").setActive(true);
    cpanel1.add(new Paragraph("This tab is closable"));

    TabPanel cpanel2 = new TabPanel().setName("ctab-2");
    cpanel2.add(new Paragraph("This tab is also closable"));

    TabPanel cpanel3 = new TabPanel().setName("ctab-3");
    cpanel3.add(new Paragraph("This tab can be closed too"));

    TabPanel cpanel4 = new TabPanel().setName("ctab-4");
    cpanel4.add(new Paragraph("This tab cannot be closed"));

    closableTabs.addPanel(cpanel1).addPanel(cpanel2).addPanel(cpanel3).addPanel(cpanel4);

    Div closableCode = new Div();
    closableCode.setText(
      "Tab closableTab = new Tab()\n" +
      "    .setPanel(\"panel-name\")\n" +
      "    .setText(\"Closable Tab\")\n" +
      "    .setClosable(true);\n\n" +
      "// Handle close events\n" +
      "closableTab.onClose(event -> {\n" +
      "    // Handle tab close\n" +
      "    event.getComponent().remove();\n" +
      "});"
    );
    styleCodeBlock(closableCode);

    closableExample.add(closableTabs, closableCode);

    // Scrolling tabs
    FlexLayout scrollingExample = createSection(
      "Scrolling Tabs",
      "When tabs don't fit in the container, scroll controls will appear automatically."
    );

    TabGroup scrollingTabs = new TabGroup();

    for (int i = 1; i <= 20; i++) {
      Tab scrollTab = new Tab().setPanel("scroll-" + i).setText("Tab " + i);
      scrollingTabs.addTab(scrollTab);
    }

    for (int i = 1; i <= 20; i++) {
      TabPanel scrollPanel = new TabPanel().setName("scroll-" + i);
      if (i == 1) scrollPanel.setActive(true);
      scrollPanel.add(new Paragraph("Content for tab " + i));
      scrollingTabs.addPanel(scrollPanel);
    }

    Div scrollingCode = new Div();
    scrollingCode.setText(
      "TabGroup scrollingTabs = new TabGroup();\n\n" +
      "// Add many tabs\n" +
      "for (int i = 1; i <= 20; i++) {\n" +
      "    Tab tab = new Tab()\n" +
      "        .setPanel(\"scroll-\" + i)\n" +
      "        .setText(\"Tab \" + i);\n" +
      "    scrollingTabs.addTab(tab);\n" +
      "}\n\n" +
      "// Disable scroll controls if needed\n" +
      "scrollingTabs.setNoScrollControls(true);"
    );
    styleCodeBlock(scrollingCode);

    scrollingExample.add(scrollingTabs, scrollingCode);

    // Manual activation
    FlexLayout manualExample = createSection(
      "Manual Activation",
      "By default, tabs are selected as the user navigates them with arrow keys. Use manual activation to require a click or Enter/Space key."
    );

    TabGroup manualTabs = new TabGroup().setActivation(TabGroup.Activation.MANUAL);

    Tab mtab1 = new Tab().setPanel("manual-1").setText("Manual 1");
    Tab mtab2 = new Tab().setPanel("manual-2").setText("Manual 2");
    Tab mtab3 = new Tab().setPanel("manual-3").setText("Manual 3");

    manualTabs.addTab(mtab1).addTab(mtab2).addTab(mtab3);

    TabPanel mpanel1 = new TabPanel().setName("manual-1").setActive(true);
    mpanel1.add(new Paragraph("Manual activation tab 1"));

    TabPanel mpanel2 = new TabPanel().setName("manual-2");
    mpanel2.add(new Paragraph("Manual activation tab 2"));

    TabPanel mpanel3 = new TabPanel().setName("manual-3");
    mpanel3.add(new Paragraph("Manual activation tab 3"));

    manualTabs.addPanel(mpanel1).addPanel(mpanel2).addPanel(mpanel3);

    Div manualCode = new Div();
    manualCode.setText(
      "TabGroup manualTabs = new TabGroup()\n" +
      "    .setActivation(TabGroup.Activation.MANUAL);\n\n" +
      "// Users must click or press Enter/Space to select tabs"
    );
    styleCodeBlock(manualCode);

    manualExample.add(manualTabs, manualCode);

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties",
      "The Tab Group component supports the following properties:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Events section
    FlexLayout eventsSection = createSection(
      "Events",
      "Tab groups fire events when tabs are shown or hidden. Tab components fire close events."
    );

    TabGroup eventTabs = new TabGroup();
    Tab eventTab1 = new Tab("Events", "events-1");
    Tab eventTab2 = new Tab("Example", "events-2");
    Tab eventTab3 = new Tab("Closable", "events-3").setClosable(true);
    
    eventTabs.addTab(eventTab1)
             .addTab(eventTab2)
             .addTab(eventTab3);

    TabPanel eventPanel1 = new TabPanel("events-1").setActive(true);
    eventPanel1.add(new Paragraph("Click tabs to see events fired"));

    TabPanel eventPanel2 = new TabPanel("events-2");
    eventPanel2.add(new Paragraph("This panel demonstrates tab events"));

    TabPanel eventPanel3 = new TabPanel("events-3");
    eventPanel3.add(new Paragraph("Close this tab to see the close event"));

    eventTabs.addPanel(eventPanel1)
             .addPanel(eventPanel2)
             .addPanel(eventPanel3);

    // Event output area
    FlexLayout eventOutput = new FlexLayout();
    eventOutput.setDirection(FlexDirection.COLUMN)
               .setSpacing("5px")
               .setPadding("10px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border", "1px solid #dee2e6")
               .setStyle("border-radius", "4px")
               .setStyle("margin-top", "10px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "13px")
               .setStyle("max-height", "200px")
               .setStyle("overflow-y", "auto");

    Label eventLabel = new Label("Events will appear here...");
    eventLabel.setStyle("color", "#6c757d");
    eventOutput.add(eventLabel);

    // Add event listeners
    eventTabs.onTabShow(event -> {
      Label showEvent = new Label("[" + getTimestamp() + "] sl-tab-show: " + event.getName());
      showEvent.setStyle("color", "#28a745");
      eventOutput.add(showEvent);
      if (eventOutput.getComponentCount() > 10) {
        eventOutput.remove(eventOutput.getComponents().get(1));
      }
    });

    eventTabs.onTabHide(event -> {
      Label hideEvent = new Label("[" + getTimestamp() + "] sl-tab-hide: " + event.getName());
      hideEvent.setStyle("color", "#dc3545");
      eventOutput.add(hideEvent);
      if (eventOutput.getComponentCount() > 10) {
        eventOutput.remove(eventOutput.getComponents().get(1));
      }
    });

    eventTab3.onClose(event -> {
      Label closeEvent = new Label("[" + getTimestamp() + "] sl-close: Tab closed");
      closeEvent.setStyle("color", "#6610f2");
      eventOutput.add(closeEvent);
      // Allow the tab to close by not preventing default
    });

    Div eventCode = new Div();
    eventCode.setText(
      "// Tab show event\n" +
      "tabGroup.onTabShow(event -> {\n" +
      "    String panelName = event.getName();\n" +
      "    System.out.println(\"Tab shown: \" + panelName);\n" +
      "});\n\n" +
      "// Tab hide event\n" +
      "tabGroup.onTabHide(event -> {\n" +
      "    String panelName = event.getName();\n" +
      "    System.out.println(\"Tab hidden: \" + panelName);\n" +
      "});\n\n" +
      "// Tab close event\n" +
      "tab.onClose(event -> {\n" +
      "    // Prevent close if needed\n" +
      "    if (!confirmClose()) {\n" +
      "        event.preventDefault();\n" +
      "    }\n" +
      "});"
    );
    styleCodeBlock(eventCode);

    eventsSection.add(eventTabs, eventOutput, eventCode);
    
    // Events table
    FlexLayout eventsTable = createEventsTable();
    eventsSection.add(eventsTable);

    // Add all sections to main layout
    self.add(header, basicExample, placementExample, closableExample,
             scrollingExample, manualExample, eventsSection, propertiesSection);
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

    // TabGroup properties
    FlexLayout placementRow = createTableRow(false);
    placementRow.add(
      createTableCell("placement", false),
      createTableCell("The placement of the tabs", false),
      createTableCell("String", false),
      createTableCell("\"top\"", false)
    );

    FlexLayout activationRow = createTableRow(false);
    activationRow.add(
      createTableCell("activation", false),
      createTableCell("When tabs are auto-activated", false),
      createTableCell("Activation", false),
      createTableCell("AUTO", false)
    );

    FlexLayout noScrollRow = createTableRow(false);
    noScrollRow.add(
      createTableCell("noScrollControls", false),
      createTableCell("Disables scroll arrows", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    // Tab properties
    FlexLayout tabHeaderRow = createTableRow(true);
    tabHeaderRow.add(
      createTableCell("Tab Properties", true),
      createTableCell("", true),
      createTableCell("", true),
      createTableCell("", true)
    );

    FlexLayout panelRow = createTableRow(false);
    panelRow.add(
      createTableCell("panel", false),
      createTableCell("The name of the associated panel", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout closableRow = createTableRow(false);
    closableRow.add(
      createTableCell("closable", false),
      createTableCell("Makes the tab closable", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout disabledRow = createTableRow(false);
    disabledRow.add(
      createTableCell("disabled", false),
      createTableCell("Disables the tab", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    table.add(headerRow, placementRow, activationRow, noScrollRow,
              tabHeaderRow, panelRow, closableRow, disabledRow);
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
      createTableCell("Event Data", true),
      createTableCell("Component", true)
    );

    // Data rows
    String[][] events = {
      {"sl-tab-show", "Emitted when a tab is shown", "name: string, panel: TabPanel", "TabGroup"},
      {"sl-tab-hide", "Emitted when a tab is hidden", "name: string, panel: TabPanel", "TabGroup"},
      {"sl-close", "Emitted when the close button is clicked", "-", "Tab"}
    };

    table.add(headerRow);
    for (String[] event : events) {
      FlexLayout row = createTableRow(false);
      row.add(
        createTableCell(event[0], false),
        createTableCell(event[1], false),
        createTableCell(event[2], false),
        createTableCell(event[3], false)
      );
      table.add(row);
    }

    return table;
  }
}
