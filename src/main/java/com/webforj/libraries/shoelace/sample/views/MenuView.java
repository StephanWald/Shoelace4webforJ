package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.*;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.App;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.*;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/menu", outlet = MainLayout.class)
@FrameTitle("Menu")
public class MenuView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public MenuView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Menu");
    Paragraph description = new Paragraph(
      "Menus provide a list of options for the user using Shoelace web components. " +
      "They are composed of menu items, labels, and dividers. Menus support " +
      "keyboard navigation and can include icons, checkboxes, and submenus."
    );

    // Documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Menu.html",
      "https://shoelace.style/components/menu"
    );

    header.add(title, description, docLinks);

    // Basic example section
    FlexLayout basicExample = createSection(
      "Basic Menu",
      "A basic menu with simple menu items."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    Menu basicMenu = new Menu();
    basicMenu.addItem(new MenuItem("Cut", "cut"));
    basicMenu.addItem(new MenuItem("Copy", "copy"));
    basicMenu.addItem(new MenuItem("Paste", "paste"));
    basicMenu.addDivider();
    basicMenu.addItem(new MenuItem("Delete", "delete"));

    // Add border to make menu visible
    basicMenu.setStyle("border", "1px solid #e1e4e8")
             .setStyle("border-radius", "6px")
             .setStyle("max-width", "250px");

    Label selectedLabel = new Label("Selected: none");

    // Simulate selection handling
    Button demoSelectButton = new Button("Simulate Select First Item");
    demoSelectButton.addClickListener(e -> {
      selectedLabel.setText("Selected: cut");
      App.console().log("Menu item selected: cut");
    });

    Div basicCode = new Div();
    basicCode.setText(
      "Menu menu = new Menu();\n" +
      "menu.addItem(new MenuItem(\"Cut\", \"cut\"));\n" +
      "menu.addItem(new MenuItem(\"Copy\", \"copy\"));\n" +
      "menu.addItem(new MenuItem(\"Paste\", \"paste\"));\n" +
      "menu.addDivider();\n" +
      "menu.addItem(new MenuItem(\"Delete\", \"delete\"));"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicMenu, demoSelectButton, selectedLabel, basicCode);
    basicExample.add(basicDemo);

    // Menu with icons section
    FlexLayout iconsExample = createSection(
      "Menu with Icons",
      "Menu items can have prefix and suffix slots for icons or other components."
    );

    FlexLayout iconsDemo = new FlexLayout();
    iconsDemo.setDirection(FlexDirection.COLUMN);
    iconsDemo.setSpacing("20px");

    Menu iconMenu = new Menu();

    MenuItem cutItem = new MenuItem("Cut", "cut");
    cutItem.setPrefix(TablerIcon.create("cut"));
    iconMenu.addItem(cutItem);

    MenuItem copyItem = new MenuItem("Copy", "copy");
    copyItem.setPrefix(TablerIcon.create("copy"));
    iconMenu.addItem(copyItem);

    MenuItem pasteItem = new MenuItem("Paste", "paste");
    pasteItem.setPrefix(TablerIcon.create("clipboard"));
    iconMenu.addItem(pasteItem);

    iconMenu.setStyle("border", "1px solid #e1e4e8")
            .setStyle("border-radius", "6px")
            .setStyle("max-width", "250px");

    Div iconsCode = new Div();
    iconsCode.setText(
      "MenuItem cutItem = new MenuItem(\"Cut\", \"cut\");\n" +
      "cutItem.setPrefix(TablerIcon.create(\"cut\"));\n" +
      "menu.addItem(cutItem);\n\n" +
      "MenuItem copyItem = new MenuItem(\"Copy\", \"copy\");\n" +
      "copyItem.setPrefix(TablerIcon.create(\"copy\"));\n" +
      "menu.addItem(copyItem);"
    );
    styleCodeBlock(iconsCode);

    iconsDemo.add(iconMenu, iconsCode);
    iconsExample.add(iconsDemo);

    // Checkbox menu items section
    FlexLayout checkboxExample = createSection(
      "Checkbox Menu Items",
      "Menu items can be displayed as checkboxes for togglable options."
    );

    FlexLayout checkboxDemo = new FlexLayout();
    checkboxDemo.setDirection(FlexDirection.COLUMN);
    checkboxDemo.setSpacing("20px");

    Menu checkboxMenu = new Menu();

    MenuItem autoSave = new MenuItem("Autosave", "autosave");
    autoSave.setType(MenuItem.Type.CHECKBOX);
    autoSave.setChecked(true);
    checkboxMenu.addItem(autoSave);

    MenuItem notifications = new MenuItem("Notifications", "notifications");
    notifications.setType(MenuItem.Type.CHECKBOX);
    notifications.setChecked(false);
    checkboxMenu.addItem(notifications);

    MenuItem darkMode = new MenuItem("Dark Mode", "darkmode");
    darkMode.setType(MenuItem.Type.CHECKBOX);
    darkMode.setChecked(false);
    checkboxMenu.addItem(darkMode);

    checkboxMenu.setStyle("border", "1px solid #e1e4e8")
                .setStyle("border-radius", "6px")
                .setStyle("max-width", "250px");

    Button toggleButton = new Button("Toggle Dark Mode");
    toggleButton.addClickListener(e -> {
      darkMode.setChecked(!darkMode.isChecked());
    });

    Div checkboxCode = new Div();
    checkboxCode.setText(
      "MenuItem autoSave = new MenuItem(\"Autosave\", \"autosave\");\n" +
      "autoSave.setType(MenuItem.Type.CHECKBOX);\n" +
      "autoSave.setChecked(true);\n" +
      "menu.addItem(autoSave);\n\n" +
      "// Toggle programmatically\n" +
      "autoSave.setChecked(!autoSave.isChecked());"
    );
    styleCodeBlock(checkboxCode);

    checkboxDemo.add(checkboxMenu, toggleButton, checkboxCode);
    checkboxExample.add(checkboxDemo);

    // Menu with labels section
    FlexLayout labelsExample = createSection(
      "Menu with Labels",
      "Use menu labels to group related menu items."
    );

    FlexLayout labelsDemo = new FlexLayout();
    labelsDemo.setDirection(FlexDirection.COLUMN);
    labelsDemo.setSpacing("20px");

    Menu labelMenu = new Menu();

    labelMenu.addLabel(new MenuLabel("Text Options"));
    labelMenu.addItem(new MenuItem("Bold", "bold"));
    labelMenu.addItem(new MenuItem("Italic", "italic"));
    labelMenu.addItem(new MenuItem("Underline", "underline"));

    labelMenu.addDivider();

    labelMenu.addLabel(new MenuLabel("Alignment"));
    labelMenu.addItem(new MenuItem("Left", "align-left"));
    labelMenu.addItem(new MenuItem("Center", "align-center"));
    labelMenu.addItem(new MenuItem("Right", "align-right"));

    labelMenu.setStyle("border", "1px solid #e1e4e8")
             .setStyle("border-radius", "6px")
             .setStyle("max-width", "250px");

    Div labelsCode = new Div();
    labelsCode.setText(
      "menu.addLabel(new MenuLabel(\"Text Options\"));\n" +
      "menu.addItem(new MenuItem(\"Bold\", \"bold\"));\n" +
      "menu.addItem(new MenuItem(\"Italic\", \"italic\"));\n\n" +
      "menu.addDivider();\n\n" +
      "menu.addLabel(new MenuLabel(\"Alignment\"));\n" +
      "menu.addItem(new MenuItem(\"Left\", \"align-left\"));"
    );
    styleCodeBlock(labelsCode);

    labelsDemo.add(labelMenu, labelsCode);
    labelsExample.add(labelsDemo);

    // Disabled and loading states section
    FlexLayout statesExample = createSection(
      "States",
      "Menu items can be disabled or show a loading state."
    );

    FlexLayout statesDemo = new FlexLayout();
    statesDemo.setDirection(FlexDirection.COLUMN);
    statesDemo.setSpacing("20px");

    Menu statesMenu = new Menu();

    MenuItem enabledItem = new MenuItem("Enabled Option", "enabled");
    statesMenu.addItem(enabledItem);

    MenuItem disabledItem = new MenuItem("Disabled Option", "disabled");
    disabledItem.setDisabled(true);
    statesMenu.addItem(disabledItem);

    MenuItem loadingItem = new MenuItem("Loading Option", "loading");
    loadingItem.setLoading(true);
    statesMenu.addItem(loadingItem);

    statesMenu.setStyle("border", "1px solid #e1e4e8")
              .setStyle("border-radius", "6px")
              .setStyle("max-width", "250px");

    Div statesCode = new Div();
    statesCode.setText(
      "// Disable a menu item\n" +
      "menuItem.setDisabled(true);\n\n" +
      "// Show loading state\n" +
      "menuItem.setLoading(true);"
    );
    styleCodeBlock(statesCode);

    statesDemo.add(statesMenu, statesCode);
    statesExample.add(statesDemo);

    // Submenu section
    FlexLayout submenuExample = createSection(
      "Submenus",
      "Create nested menus by adding a Menu component to a MenuItem with the submenu slot."
    );

    FlexLayout submenuDemo = new FlexLayout();
    submenuDemo.setDirection(FlexDirection.COLUMN);
    submenuDemo.setSpacing("20px");

    Menu mainMenu = new Menu();

    mainMenu.addItem(new MenuItem("New", "new"));
    mainMenu.addItem(new MenuItem("Open", "open"));

    // Create Export menu item with submenu
    MenuItem exportItem = new MenuItem("Export", "export");

    // Create the submenu
    Menu exportSubmenu = new Menu();
    exportSubmenu.addItem(new MenuItem("PDF", "export-pdf"));
    exportSubmenu.addItem(new MenuItem("Word", "export-word"));
    exportSubmenu.addItem(new MenuItem("Excel", "export-excel"));
    exportSubmenu.addDivider();
    exportSubmenu.addItem(new MenuItem("Custom Format...", "export-custom"));

    // Add submenu to the export item
    exportItem.setSubmenu(exportSubmenu);
    mainMenu.addItem(exportItem);

    mainMenu.addDivider();

    // Create Settings menu item with submenu
    MenuItem settingsItem = new MenuItem("Settings", "settings");

    Menu settingsSubmenu = new Menu();
    settingsSubmenu.addItem(new MenuItem("General", "settings-general"));
    settingsSubmenu.addItem(new MenuItem("Appearance", "settings-appearance"));
    settingsSubmenu.addItem(new MenuItem("Security", "settings-security"));

    settingsItem.setSubmenu(settingsSubmenu);
    mainMenu.addItem(settingsItem);

    mainMenu.addItem(new MenuItem("Exit", "exit"));

    mainMenu.setStyle("border", "1px solid #e1e4e8")
            .setStyle("border-radius", "6px")
            .setStyle("max-width", "250px");

    Div submenuCode = new Div();
    submenuCode.setText(
      "// Create main menu\n" +
      "Menu mainMenu = new Menu();\n\n" +
      "// Create menu item that will have a submenu\n" +
      "MenuItem exportItem = new MenuItem(\"Export\", \"export\");\n\n" +
      "// Create the submenu\n" +
      "Menu exportSubmenu = new Menu();\n" +
      "exportSubmenu.addItem(new MenuItem(\"PDF\", \"export-pdf\"));\n" +
      "exportSubmenu.addItem(new MenuItem(\"Word\", \"export-word\"));\n\n" +
      "// Add submenu to the menu item\n" +
      "exportItem.setSubmenu(exportSubmenu);\n" +
      "mainMenu.addItem(exportItem);"
    );
    styleCodeBlock(submenuCode);

    submenuDemo.add(mainMenu, submenuCode);
    submenuExample.add(submenuDemo);

    // Interactive example
    FlexLayout interactiveExample = createSection(
      "Interactive Example",
      "Build a custom menu with various options."
    );

    FlexLayout interactiveDemo = new FlexLayout();
    interactiveDemo.setDirection(FlexDirection.COLUMN);
    interactiveDemo.setSpacing("20px");

    TextField itemText = new TextField();
    itemText.setLabel("Item Text");
    itemText.setValue("New Item");

    TextField itemValue = new TextField();
    itemValue.setLabel("Item Value");
    itemValue.setValue("new-item");

    FlexLayout typeControls = new FlexLayout();
    typeControls.setSpacing("10px");

    Button normalTypeBtn = new Button("Normal");
    Button checkboxTypeBtn = new Button("Checkbox");

    typeControls.add(normalTypeBtn, checkboxTypeBtn);

    Menu interactiveMenu = new Menu();
    interactiveMenu.setStyle("border", "1px solid #e1e4e8")
                   .setStyle("border-radius", "6px")
                   .setStyle("max-width", "350px")
                   .setStyle("min-height", "200px");

    // Default items
    interactiveMenu.addLabel(new MenuLabel("Dynamic Menu"));
    interactiveMenu.addItem(new MenuItem("Default Item 1", "item1"));
    interactiveMenu.addItem(new MenuItem("Default Item 2", "item2"));

    Button addItemBtn = new Button("Add Item");
    addItemBtn.addClickListener(e -> {
      MenuItem newItem = new MenuItem(itemText.getValue(), itemValue.getValue());
      interactiveMenu.addItem(newItem);
    });

    normalTypeBtn.addClickListener(e -> {
      MenuItem newItem = new MenuItem(itemText.getValue(), itemValue.getValue());
      newItem.setType(MenuItem.Type.NORMAL);
      interactiveMenu.addItem(newItem);
    });

    checkboxTypeBtn.addClickListener(e -> {
      MenuItem newItem = new MenuItem(itemText.getValue(), itemValue.getValue());
      newItem.setType(MenuItem.Type.CHECKBOX);
      interactiveMenu.addItem(newItem);
    });

    Button addDividerBtn = new Button("Add Divider");
    addDividerBtn.addClickListener(e -> {
      interactiveMenu.addDivider();
    });

    Button clearMenuBtn = new Button("Clear Menu");
    clearMenuBtn.addClickListener(e -> {
      interactiveMenu.clearItems();
      interactiveMenu.addLabel(new MenuLabel("Dynamic Menu"));
    });

    FlexLayout buttonGroup = new FlexLayout();
    buttonGroup.setSpacing("10px");
    buttonGroup.add(addItemBtn, addDividerBtn, clearMenuBtn);

    interactiveDemo.add(itemText, itemValue, typeControls, buttonGroup, interactiveMenu);
    interactiveExample.add(interactiveDemo);

    // Properties tables
    FlexLayout propertiesSection = createSection(
      "Component Properties",
      "Properties available for Menu components:"
    );

    FlexLayout menuPropertiesTable = createMenuPropertiesTable();
    FlexLayout menuItemPropertiesTable = createMenuItemPropertiesTable();

    propertiesSection.add(
      new H3("Menu"),
      menuPropertiesTable,
      new H3("MenuItem"),
      menuItemPropertiesTable
    );

    // Event handling section
    FlexLayout eventsExample = createEventHandlingExample();

    // Add all sections to main layout
    self.add(header, basicExample, iconsExample, checkboxExample, labelsExample,
             statesExample, submenuExample, interactiveExample, eventsExample, propertiesSection);
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

  private FlexLayout createMenuPropertiesTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden");

    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
      createTableCell("Method", true),
      createTableCell("Description", true),
      createTableCell("Return Type", true)
    );

    // Data rows
    FlexLayout addItemRow = createTableRow(false);
    addItemRow.add(
      createTableCell("addItem(MenuItem)", false),
      createTableCell("Adds a menu item to the menu", false),
      createTableCell("Menu", false)
    );

    FlexLayout addLabelRow = createTableRow(false);
    addLabelRow.add(
      createTableCell("addLabel(MenuLabel)", false),
      createTableCell("Adds a label to the menu", false),
      createTableCell("Menu", false)
    );

    FlexLayout addDividerRow = createTableRow(false);
    addDividerRow.add(
      createTableCell("addDivider()", false),
      createTableCell("Adds a divider to the menu", false),
      createTableCell("Menu", false)
    );

    table.add(headerRow, addItemRow, addLabelRow, addDividerRow);
    return table;
  }

  private FlexLayout createMenuItemPropertiesTable() {
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
    FlexLayout typeRow = createTableRow(false);
    typeRow.add(
      createTableCell("type", false),
      createTableCell("The type of menu item", false),
      createTableCell("String", false),
      createTableCell("\"normal\"", false)
    );

    FlexLayout checkedRow = createTableRow(false);
    checkedRow.add(
      createTableCell("checked", false),
      createTableCell("Whether the checkbox is checked", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout valueRow = createTableRow(false);
    valueRow.add(
      createTableCell("value", false),
      createTableCell("The value of the menu item", false),
      createTableCell("String", false),
      createTableCell("\"\"", false)
    );

    FlexLayout disabledRow = createTableRow(false);
    disabledRow.add(
      createTableCell("disabled", false),
      createTableCell("Whether the item is disabled", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    FlexLayout loadingRow = createTableRow(false);
    loadingRow.add(
      createTableCell("loading", false),
      createTableCell("Whether to show loading state", false),
      createTableCell("boolean", false),
      createTableCell("false", false)
    );

    table.add(headerRow, typeRow, checkedRow, valueRow, disabledRow, loadingRow);
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

  private FlexLayout createEventHandlingExample() {
    FlexLayout section = createSection(
      "Event Handling",
      "Menus fire events when items are selected. Use these events to handle user interactions."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Interactive menu demo
    FlexLayout menuContainer = new FlexLayout();
    menuContainer.setDirection(FlexDirection.COLUMN);
    menuContainer.setSpacing("15px");
    menuContainer.setStyle("border", "1px solid #dee2e6")
                 .setStyle("border-radius", "8px")
                 .setStyle("padding", "20px")
                 .setStyle("background", "#f8f9fa");

    H3 demoTitle = new H3("Interactive Menu Demo");
    
    Menu eventMenu = new Menu();
    eventMenu.setStyle("border", "1px solid #e1e4e8")
             .setStyle("border-radius", "6px")
             .setStyle("max-width", "300px");

    // Add menu items with icons
    MenuItem newFile = new MenuItem("New File", "new-file");
    newFile.setPrefix(TablerIcon.create("file-plus"));
    eventMenu.addItem(newFile);

    MenuItem openFile = new MenuItem("Open File", "open-file");
    openFile.setPrefix(TablerIcon.create("folder-open"));
    eventMenu.addItem(openFile);

    MenuItem saveFile = new MenuItem("Save File", "save-file");
    saveFile.setPrefix(TablerIcon.create("device-floppy"));
    eventMenu.addItem(saveFile);

    eventMenu.addDivider();

    // Checkbox items
    MenuItem autoSave = new MenuItem("Auto Save", "auto-save");
    autoSave.setType(MenuItem.Type.CHECKBOX)
            .setChecked(true);
    eventMenu.addItem(autoSave);

    MenuItem wordWrap = new MenuItem("Word Wrap", "word-wrap");
    wordWrap.setType(MenuItem.Type.CHECKBOX)
            .setChecked(false);
    eventMenu.addItem(wordWrap);

    eventMenu.addDivider();

    MenuItem exitItem = new MenuItem("Exit", "exit");
    exitItem.setPrefix(TablerIcon.create("logout"));
    eventMenu.addItem(exitItem);

    // Event feedback labels
    Label lastSelectedLabel = new Label("Last Selected: None");
    lastSelectedLabel.setStyle("font-size", "14px")
                     .setStyle("color", "#6c757d");

    Label actionLabel = new Label("Action: Ready");
    actionLabel.setStyle("font-size", "14px")
               .setStyle("color", "#6c757d");

    Label checkboxStatus = new Label("Auto Save: ON | Word Wrap: OFF");
    checkboxStatus.setStyle("font-size", "14px")
                  .setStyle("color", "#6c757d");

    // Add event listener for menu selection
    eventMenu.onSelect(event -> {
      // In production, getItem() returns a JavaScript object reference
      // For demo purposes, we'll use hardcoded values
      String value = "demo-item";
      String text = "Demo Item Selected";
      
      lastSelectedLabel.setText("Last Selected: " + text);
      lastSelectedLabel.setStyle("color", "#28a745");
      
      // Handle different menu items
      switch(value) {
        case "new-file":
          actionLabel.setText("Action: Creating new file...");
          actionLabel.setStyle("color", "#007bff");
          break;
        case "open-file":
          actionLabel.setText("Action: Opening file dialog...");
          actionLabel.setStyle("color", "#007bff");
          break;
        case "save-file":
          actionLabel.setText("Action: Saving file...");
          actionLabel.setStyle("color", "#28a745");
          break;
        case "exit":
          actionLabel.setText("Action: Exiting application...");
          actionLabel.setStyle("color", "#dc3545");
          break;
        case "auto-save":
        case "word-wrap":
          // For checkbox items, just show settings updated
          checkboxStatus.setStyle("color", "#6610f2");
          actionLabel.setText("Action: Settings updated");
          actionLabel.setStyle("color", "#6610f2");
          break;
      }
    });

    menuContainer.add(demoTitle, eventMenu, lastSelectedLabel, actionLabel, checkboxStatus);

    Div eventsCode = new Div();
    eventsCode.setText(
      "// Menu sl-select event\n" +
      "menu.onSelect(event -> {\n" +
      "  MenuItem selectedItem = event.getItem();\n" +
      "  String value = selectedItem.getValue();\n" +
      "  String text = selectedItem.getText();\n" +
      "  \n" +
      "  System.out.println(\"Selected: \" + value);\n" +
      "  updateUI(value, text);\n" +
      "});\n\n" +
      "// MenuItem can also handle its own select event\n" +
      "menuItem.onSelect(event -> {\n" +
      "  System.out.println(\"Item selected directly\");\n" +
      "  \n" +
      "  // Handle checkbox items\n" +
      "  if (menuItem.getType().equals(\"checkbox\")) {\n" +
      "    boolean checked = menuItem.isChecked();\n" +
      "    System.out.println(\"Checkbox checked: \" + checked);\n" +
      "  }\n" +
      "});"
    );
    styleCodeBlock(eventsCode);

    eventsDemo.add(menuContainer, eventsCode);
    section.add(eventsDemo);
    return section;
  }
}
