package com.webforj.libraries.shoelace.sample.views;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.H3;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.libraries.shoelace.components.Switch;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;

@Route(value = "/switch", outlet = MainLayout.class)
@FrameTitle("Switch")
public class SwitchView extends Composite<FlexLayout> {
  private final FlexLayout self = getBoundComponent();

  public SwitchView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Title and documentation links
    self.add(new H1("Switch"));
    self.add(new DocumentationLinks(
        "/static/javadoc/com/webforj/libraries/shoelace/components/Switch.html",
        "https://shoelace.style/components/switch"
    ));
    
    self.add(new Paragraph("Switches allow users to toggle an option on or off. They're similar to checkboxes but are designed for instant actions rather than form submission."));

    // Basic Examples
    self.add(new H2("Basic Examples"));
    
    Switch basicSwitch = new Switch();
    self.add(basicSwitch);
    
    Switch labeledSwitch = new Switch("Enable notifications");
    self.add(labeledSwitch);
    
    Switch checkedSwitch = new Switch("Active by default", true);
    self.add(checkedSwitch);

    // Sizes
    self.add(new H2("Sizes"));
    
    Switch smallSwitch = new Switch("Small");
    smallSwitch.setSize("small");
    self.add(smallSwitch);
    
    Switch mediumSwitch = new Switch("Medium (default)");
    mediumSwitch.setSize("medium");
    self.add(mediumSwitch);
    
    Switch largeSwitch = new Switch("Large");
    largeSwitch.setSize("large");
    self.add(largeSwitch);

    // Help Text
    self.add(new H2("Help Text"));
    
    Switch helpSwitch = new Switch("Sync data automatically");
    helpSwitch.setHelpText("Your data will be synchronized every hour");
    self.add(helpSwitch);

    // States
    self.add(new H2("States"));
    
    Switch disabledOff = new Switch("Disabled (off)");
    disabledOff.setDisabled(true);
    self.add(disabledOff);
    
    Switch disabledOn = new Switch("Disabled (on)");
    disabledOn.setChecked(true);
    disabledOn.setDisabled(true);
    self.add(disabledOn);
    
    Switch requiredSwitch = new Switch("Required switch");
    requiredSwitch.setRequired(true);
    requiredSwitch.setHelpText("This switch must be turned on");
    self.add(requiredSwitch);

    // Event Handling
    self.add(new H2("Event Handling"));
    self.add(new Paragraph("Switches emit events when toggled or when they receive/lose focus."));
    
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
    
    Switch eventSwitch = new Switch("Toggle me for events");
    eventSwitch.setHelpText("Try toggling and using Tab/Shift+Tab to see all events");
    
    Div currentState = new Div();
    currentState.setStyle("margin-top", "10px")
                .setStyle("font-weight", "bold")
                .setHtml("Current state: <span style='color: #dc3545'>OFF</span>");
    
    // Change event
    eventSwitch.onChange(event -> {
        boolean checked = event.getData().get("checked") != null ? (Boolean) event.getData().get("checked") : false;
        String state = checked ? "ON" : "OFF";
        String color = checked ? "#28a745" : "#dc3545";
        
        Label changeEvent = new Label("[" + getTimestamp() + "] sl-change: checked = " + checked);
        changeEvent.setStyle("color", "#28a745");
        eventOutput.add(changeEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
        
        currentState.setHtml("Current state: <span style='color: " + color + "'>" + state + "</span>");
    });
    
    // Input event (fires during interaction)
    eventSwitch.onInput(event -> {
        boolean checked = event.getData().get("checked") != null ? (Boolean) event.getData().get("checked") : false;
        Label inputEvent = new Label("[" + getTimestamp() + "] sl-input: checked = " + checked);
        inputEvent.setStyle("color", "#17a2b8");
        eventOutput.add(inputEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Focus/blur events
    eventSwitch.onFocus(event -> {
        Label focusEvent = new Label("[" + getTimestamp() + "] sl-focus");
        focusEvent.setStyle("color", "#6610f2");
        eventOutput.add(focusEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    eventSwitch.onBlur(event -> {
        Label blurEvent = new Label("[" + getTimestamp() + "] sl-blur");
        blurEvent.setStyle("color", "#fd7e14");
        eventOutput.add(blurEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Invalid event
    eventSwitch.onInvalid(event -> {
        Label invalidEvent = new Label("[" + getTimestamp() + "] sl-invalid");
        invalidEvent.setStyle("color", "#dc3545");
        eventOutput.add(invalidEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    self.add(eventSwitch);
    self.add(eventOutput);
    self.add(currentState);

    // Practical Example - Settings Panel
    self.add(new H2("Practical Example - Settings Panel"));
    
    Div settingsPanel = new Div();
    settingsPanel.setStyle("padding", "20px")
                 .setStyle("background", "#f8f9fa")
                 .setStyle("border-radius", "8px")
                 .setStyle("max-width", "400px");
    
    Div settingsTitle = new Div();
    settingsTitle.setHtml("<strong>Notification Settings</strong>");
    settingsTitle.setStyle("margin-bottom", "20px")
                 .setStyle("font-size", "18px");
    
    Switch emailSwitch = new Switch("Email notifications");
    emailSwitch.setChecked(true);
    emailSwitch.onChange(e -> {
        // Email notifications toggled
    });
    
    Switch pushSwitch = new Switch("Push notifications");
    pushSwitch.setHelpText("Receive notifications on your device");
    pushSwitch.onChange(e -> {
        // Push notifications toggled
    });
    
    Switch marketingSwitch = new Switch("Marketing emails");
    marketingSwitch.setHelpText("Occasional updates about new features");
    marketingSwitch.onChange(e -> {
        // Marketing emails toggled
    });
    
    settingsPanel.add(settingsTitle);
    settingsPanel.add(emailSwitch);
    settingsPanel.add(pushSwitch);
    settingsPanel.add(marketingSwitch);
    
    self.add(settingsPanel);

    // Properties table
    self.add(new H2("Properties"));
    self.add(createPropertiesTable());
    
    // Events table
    self.add(new H2("Events"));
    self.add(createEventsTable());
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
      {"checked", "boolean", "false", "Whether the switch is on or off"},
      {"disabled", "boolean", "false", "Disables the switch"},
      {"size", "String", "\"medium\"", "The switch's size"},
      {"help-text", "String", "\"\"", "Help text below the switch"},
      {"name", "String", "\"\"", "The input's name attribute"},
      {"value", "String", "\"on\"", "The value when checked"},
      {"required", "boolean", "false", "Makes the switch required"}
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
      {"sl-change", "Emitted when the switch value changes", "checked: boolean"},
      {"sl-input", "Emitted when the user interacts with the switch", "checked: boolean"},
      {"sl-focus", "Emitted when the switch gains focus", "-"},
      {"sl-blur", "Emitted when the switch loses focus", "-"},
      {"sl-invalid", "Emitted when the form control fails validation", "-"}
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
