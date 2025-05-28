package com.webforj.libraries.shoelace.sample.views;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.libraries.shoelace.components.Option;
import com.webforj.libraries.shoelace.components.Select;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;

@Route(value = "/select", outlet = MainLayout.class)
@FrameTitle("Select")
public class SelectView extends Composite<FlexLayout> {
  private final FlexLayout self = getBoundComponent();

  public SelectView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Title and documentation links
    self.add(new H1("Select"));
    self.add(new DocumentationLinks(
        "/static/javadoc/com/webforj/libraries/shoelace/components/Select.html",
        "https://shoelace.style/components/select"
    ));
    
    self.add(new Paragraph("Selects allow you to choose items from a menu of predefined options."));

    // Basic Select example
    self.add(new H2("Basic Select"));
    
    Select basicSelect = new Select("Select a fruit");
    basicSelect.addOption(new Option("Apple", "apple"));
    basicSelect.addOption(new Option("Banana", "banana"));
    basicSelect.addOption(new Option("Orange", "orange"));
    basicSelect.addOption(new Option("Grape", "grape"));
    basicSelect.addOption(new Option("Strawberry", "strawberry"));
    
    Div selectedValue = new Div();
    selectedValue.setStyle("padding", "10px")
                 .setStyle("background-color", "#f0f0f0")
                 .setStyle("border-radius", "4px")
                 .setStyle("font-family", "monospace")
                 .setHtml("Selected: <strong>none</strong>");
    
    basicSelect.onChange(event -> {
        String value = event.getValue();
        selectedValue.setHtml("Selected: <strong>" + value + "</strong>");
        // Show selection in UI instead of Toast
    });
    
    self.add(basicSelect);
    self.add(selectedValue);

    // Placeholder and Clearable
    self.add(new H2("Placeholder and Clearable"));
    
    Select placeholderSelect = new Select();
    placeholderSelect.setPlaceholder("Choose your favorite framework");
    placeholderSelect.setClearable(true);
    placeholderSelect.addOption(new Option("Angular", "angular"));
    placeholderSelect.addOption(new Option("React", "react"));
    placeholderSelect.addOption(new Option("Vue", "vue"));
    placeholderSelect.addOption(new Option("Svelte", "svelte"));
    
    placeholderSelect.onClear(event -> {
        // Selection cleared
    });
    
    self.add(placeholderSelect);

    // Multiple Select
    self.add(new H2("Multiple Select"));
    
    Select multiSelect = new Select("Select your skills");
    multiSelect.setMultiple(true);
    multiSelect.setMaxOptionsVisible(3);
    multiSelect.setClearable(true);
    multiSelect.addOption(new Option("Java", "java"));
    multiSelect.addOption(new Option("JavaScript", "javascript"));
    multiSelect.addOption(new Option("Python", "python"));
    multiSelect.addOption(new Option("TypeScript", "typescript"));
    multiSelect.addOption(new Option("C++", "cpp"));
    multiSelect.addOption(new Option("Go", "go"));
    multiSelect.addOption(new Option("Rust", "rust"));
    
    Div multiValue = new Div();
    multiValue.setStyle("padding", "10px")
              .setStyle("background-color", "#f0f0f0")
              .setStyle("border-radius", "4px")
              .setStyle("font-family", "monospace")
              .setHtml("Selected: <strong>none</strong>");
    
    multiSelect.onChange(event -> {
        String values = String.join(", ", event.getValues());
        multiValue.setHtml("Selected: <strong>" + (values.isEmpty() ? "none" : values) + "</strong>");
    });
    
    self.add(multiSelect);
    self.add(multiValue);

    // Sizes
    self.add(new H2("Sizes"));
    
    Select smallSelect = new Select("Small");
    smallSelect.setSize("small");
    smallSelect.addOption(new Option("Option 1", "1"));
    smallSelect.addOption(new Option("Option 2", "2"));
    smallSelect.addOption(new Option("Option 3", "3"));
    self.add(smallSelect);
    
    Select mediumSelect = new Select("Medium (default)");
    mediumSelect.setSize("medium");
    mediumSelect.addOption(new Option("Option 1", "1"));
    mediumSelect.addOption(new Option("Option 2", "2"));
    mediumSelect.addOption(new Option("Option 3", "3"));
    self.add(mediumSelect);
    
    Select largeSelect = new Select("Large");
    largeSelect.setSize("large");
    largeSelect.addOption(new Option("Option 1", "1"));
    largeSelect.addOption(new Option("Option 2", "2"));
    largeSelect.addOption(new Option("Option 3", "3"));
    self.add(largeSelect);

    // Event Handling
    self.add(new H2("Event Handling"));
    self.add(new Paragraph("Select components emit various events during interaction."));
    
    FlexLayout eventOutput = new FlexLayout();
    eventOutput.setDirection(FlexDirection.COLUMN)
               .setSpacing("5px")
               .setPadding("10px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border", "1px solid #dee2e6")
               .setStyle("border-radius", "4px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "13px")
               .setStyle("max-height", "200px")
               .setStyle("overflow-y", "auto");
    
    Label eventLabel = new Label("Events will appear here...");
    eventLabel.setStyle("color", "#6c757d");
    eventOutput.add(eventLabel);
    
    Select eventSelect = new Select("Interactive select");
    eventSelect.setPlaceholder("Choose an option to see events");
    eventSelect.setClearable(true);
    eventSelect.setHelpText("Try opening, selecting, clearing, and using Tab/Shift+Tab");
    
    eventSelect.addOption(new Option("First option", "first"));
    eventSelect.addOption(new Option("Second option", "second"));
    eventSelect.addOption(new Option("Third option", "third"));
    
    // Change event
    eventSelect.onChange(event -> {
        Label changeEvent = new Label("[" + getTimestamp() + "] sl-change: value = " + event.getValue());
        changeEvent.setStyle("color", "#28a745");
        eventOutput.add(changeEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Clear event
    eventSelect.onClear(event -> {
        Label clearEvent = new Label("[" + getTimestamp() + "] sl-clear: Selection cleared");
        clearEvent.setStyle("color", "#dc3545");
        eventOutput.add(clearEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Input event
    eventSelect.onInput(event -> {
        Label inputEvent = new Label("[" + getTimestamp() + "] sl-input: value = " + event.getValue());
        inputEvent.setStyle("color", "#17a2b8");
        eventOutput.add(inputEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Focus/blur events
    eventSelect.onFocus(event -> {
        Label focusEvent = new Label("[" + getTimestamp() + "] sl-focus");
        focusEvent.setStyle("color", "#6610f2");
        eventOutput.add(focusEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    eventSelect.onBlur(event -> {
        Label blurEvent = new Label("[" + getTimestamp() + "] sl-blur");
        blurEvent.setStyle("color", "#fd7e14");
        eventOutput.add(blurEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Invalid event
    eventSelect.onInvalid(event -> {
        Label invalidEvent = new Label("[" + getTimestamp() + "] sl-invalid");
        invalidEvent.setStyle("color", "#dc3545");
        eventOutput.add(invalidEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Show/hide events
    eventSelect.onShow(event -> {
        Label showEvent = new Label("[" + getTimestamp() + "] sl-show: Dropdown opening");
        showEvent.setStyle("color", "#20c997");
        eventOutput.add(showEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    eventSelect.onAfterShow(event -> {
        Label afterShowEvent = new Label("[" + getTimestamp() + "] sl-after-show: Dropdown opened");
        afterShowEvent.setStyle("color", "#198754");
        eventOutput.add(afterShowEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    eventSelect.onHide(event -> {
        Label hideEvent = new Label("[" + getTimestamp() + "] sl-hide: Dropdown closing");
        hideEvent.setStyle("color", "#e85d04");
        eventOutput.add(hideEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    eventSelect.onAfterHide(event -> {
        Label afterHideEvent = new Label("[" + getTimestamp() + "] sl-after-hide: Dropdown closed");
        afterHideEvent.setStyle("color", "#dc3545");
        eventOutput.add(afterHideEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    self.add(eventSelect);
    self.add(eventOutput);

    // States
    self.add(new H2("States"));
    
    Select disabledSelect = new Select("Disabled");
    disabledSelect.setDisabled(true);
    disabledSelect.addOption(new Option("Option 1", "1"));
    disabledSelect.addOption(new Option("Option 2", "2"));
    self.add(disabledSelect);
    
    Select requiredSelect = new Select("Required");
    requiredSelect.setRequired(true);
    requiredSelect.setHelpText("This field is required");
    requiredSelect.addOption(new Option("Option 1", "1"));
    requiredSelect.addOption(new Option("Option 2", "2"));
    requiredSelect.addOption(new Option("Option 3", "3"));
    self.add(requiredSelect);
    
    // Styling Options
    self.add(new H2("Styling Options"));
    
    Select filledSelect = new Select("Filled style");
    filledSelect.setFilled(true);
    filledSelect.addOption(new Option("Option A", "a"));
    filledSelect.addOption(new Option("Option B", "b"));
    filledSelect.addOption(new Option("Option C", "c"));
    self.add(filledSelect);
    
    Select pillSelect = new Select("Pill style");
    pillSelect.setPill(true);
    pillSelect.addOption(new Option("Choice 1", "1"));
    pillSelect.addOption(new Option("Choice 2", "2"));
    pillSelect.addOption(new Option("Choice 3", "3"));
    self.add(pillSelect);

    // Prefix and Suffix Icons
    self.add(new H2("Prefix and Suffix Icons"));
    
    Select prefixSelect = new Select("With prefix icon");
    prefixSelect.setPrefix(TablerIcon.create("user"));
    prefixSelect.addOption(new Option("John Doe", "john"));
    prefixSelect.addOption(new Option("Jane Smith", "jane"));
    prefixSelect.addOption(new Option("Bob Johnson", "bob"));
    self.add(prefixSelect);
    
    Select suffixSelect = new Select("With suffix icon");
    suffixSelect.setSuffix(TablerIcon.create("calendar"));
    suffixSelect.addOption(new Option("Today", "today"));
    suffixSelect.addOption(new Option("Tomorrow", "tomorrow"));
    suffixSelect.addOption(new Option("Next Week", "next-week"));
    self.add(suffixSelect);
    
    // Options with Icons
    self.add(new H2("Options with Icons"));
    
    Select iconOptionsSelect = new Select("Select a country");
    iconOptionsSelect.setPlaceholder("Choose a country");
    
    Option usa = new Option("United States", "us");
    usa.setPrefix(createFlagIcon("🇺🇸"));
    
    Option uk = new Option("United Kingdom", "uk");
    uk.setPrefix(createFlagIcon("🇬🇧"));
    
    Option canada = new Option("Canada", "ca");
    canada.setPrefix(createFlagIcon("🇨🇦"));
    
    Option australia = new Option("Australia", "au");
    australia.setPrefix(createFlagIcon("🇦🇺"));
    
    iconOptionsSelect.addOption(usa);
    iconOptionsSelect.addOption(uk);
    iconOptionsSelect.addOption(canada);
    iconOptionsSelect.addOption(australia);
    
    self.add(iconOptionsSelect);

    // Properties table
    self.add(new H2("Properties"));
    self.add(createPropertiesTable());
    
    // Events table
    self.add(new H2("Events"));
    self.add(createEventsTable());
  }
  
  private Div createFlagIcon(String flag) {
    Div flagIcon = new Div();
    flagIcon.setText(flag);
    flagIcon.setStyle("font-size", "1.2em");
    return flagIcon;
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
      createTableCell("Type", true),
      createTableCell("Default", true),
      createTableCell("Description", true)
    );

    // Data rows
    String[][] properties = {
      {"name", "String", "\"\"", "The input's name attribute"},
      {"value", "String", "\"\"", "The selected value(s)"},
      {"size", "String", "\"medium\"", "The select's size"},
      {"placeholder", "String", "\"\"", "Placeholder text"},
      {"multiple", "boolean", "false", "Enable multiple selection"},
      {"disabled", "boolean", "false", "Disables the select"},
      {"clearable", "boolean", "false", "Add a clear button"},
      {"open", "boolean", "false", "Whether dropdown is open"},
      {"label", "String", "\"\"", "The select's label"},
      {"placement", "String", "\"bottom\"", "Dropdown placement"},
      {"help-text", "String", "\"\"", "Help text below the select"},
      {"required", "boolean", "false", "Makes the select required"},
      {"max-options-visible", "int", "3", "Max tags shown for multiple"},
      {"filled", "boolean", "false", "Draws a filled select"},
      {"pill", "boolean", "false", "Draws a pill-style select"}
    };

    table.add(headerRow);
    for (String[] prop : properties) {
      FlexLayout row = createTableRow(false);
      row.add(
        createTableCell(prop[0], false),
        createTableCell(prop[1], false),
        createTableCell(prop[2], false),
        createTableCell(prop[3], false)
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
         .setStyle("overflow", "hidden");

    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
      createTableCell("Event", true),
      createTableCell("Description", true),
      createTableCell("Event Data", true)
    );

    // Data rows
    String[][] events = {
      {"sl-change", "Emitted when the selected value changes", "value: string | string[]"},
      {"sl-clear", "Emitted when the clear button is clicked", "-"},
      {"sl-input", "Emitted when the user interacts with the select", "value: string | string[]"},
      {"sl-focus", "Emitted when the select gains focus", "-"},
      {"sl-blur", "Emitted when the select loses focus", "-"},
      {"sl-invalid", "Emitted when the form control fails validation", "-"},
      {"sl-show", "Emitted when the dropdown starts to open", "-"},
      {"sl-after-show", "Emitted after the dropdown opens and animations complete", "-"},
      {"sl-hide", "Emitted when the dropdown starts to close", "-"},
      {"sl-after-hide", "Emitted after the dropdown closes and animations complete", "-"}
    };

    table.add(headerRow);
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
  
  private String getTimestamp() {
    return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
  }
}
