package com.webforj.libraries.shoelace.sample.views;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.libraries.shoelace.components.Radio;
import com.webforj.libraries.shoelace.components.RadioButton;
import com.webforj.libraries.shoelace.components.RadioGroup;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;

/**
 * View demonstrating Radio, RadioButton, and RadioGroup components.
 */
@Route(value = "/radio", outlet = MainLayout.class)
@FrameTitle("Radio")
public class RadioView extends Composite<FlexLayout> {
  private final FlexLayout self = getBoundComponent();

  public RadioView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Title and documentation links
    self.add(new H1("Radio Components"));
    self.add(new DocumentationLinks(
        "/static/javadoc/com/webforj/libraries/shoelace/components/Radio.html",
        "https://shoelace.style/components/radio"
    ));
    
    self.add(new Paragraph("Radio components allow users to select one option from a set of choices."));

    // Basic Radio Group example
    self.add(new H2("Basic Radio Group"));
    RadioGroup sizeGroup = new RadioGroup("Select size");
    sizeGroup.setName("size");
    sizeGroup.setHelpText("Choose your preferred size");
    
    Radio small = new Radio("Small", "small");
    Radio medium = new Radio("Medium", "medium").setChecked(true);
    Radio large = new Radio("Large", "large");
    
    sizeGroup.add(small, medium, large);
    self.add(sizeGroup);

    // Radio Button Group example
    self.add(new H2("Radio Button Group"));
    RadioGroup planGroup = new RadioGroup("Choose your plan");
    planGroup.setName("plan");
    
    RadioButton basic = new RadioButton("Basic", "basic");
    RadioButton pro = new RadioButton("Pro", "pro").setPill(true);
    RadioButton enterprise = new RadioButton("Enterprise", "enterprise");
    
    planGroup.add(basic, pro, enterprise);
    self.add(planGroup);

    // Mixed Radio and RadioButton
    self.add(new H2("Mixed Radio Types"));
    RadioGroup mixedGroup = new RadioGroup("Mixed selection");
    mixedGroup.setName("mixed");
    
    Radio option1 = new Radio("Regular Option 1", "opt1");
    RadioButton option2 = new RadioButton("Button Option 2", "opt2");
    Radio option3 = new Radio("Regular Option 3", "opt3");
    RadioButton option4 = new RadioButton("Button Option 4", "opt4").setPill(true);
    
    mixedGroup.add(option1, option2, option3, option4);
    self.add(mixedGroup);

    // Different sizes
    self.add(new H2("Radio Sizes"));
    
    FlexLayout sizesContainer = new FlexLayout();
    sizesContainer.setDirection(FlexDirection.ROW);
    sizesContainer.setSpacing("40px");
    
    RadioGroup smallGroup = new RadioGroup("Small");
    smallGroup.setSize("small");
    smallGroup.add(
        new Radio("Option A", "a"),
        new Radio("Option B", "b")
    );
    
    RadioGroup mediumGroup = new RadioGroup("Medium");
    mediumGroup.setSize("medium");
    mediumGroup.add(
        new Radio("Option A", "a"),
        new Radio("Option B", "b")
    );
    
    RadioGroup largeGroup = new RadioGroup("Large");
    largeGroup.setSize("large");
    largeGroup.add(
        new Radio("Option A", "a"),
        new Radio("Option B", "b")
    );
    
    sizesContainer.add(smallGroup, mediumGroup, largeGroup);
    self.add(sizesContainer);

    // States demo
    self.add(new H2("Radio States"));
    RadioGroup statesGroup = new RadioGroup("Different states");
    statesGroup.add(
        new Radio("Normal", "normal"),
        new Radio("Checked", "checked").setChecked(true),
        new Radio("Disabled", "disabled").setDisabled(true),
        new Radio("Disabled Checked", "disabled-checked").setDisabled(true).setChecked(true)
    );
    self.add(statesGroup);

    // Required validation
    self.add(new H2("Required Radio Group"));
    RadioGroup requiredGroup = new RadioGroup("Required selection");
    requiredGroup.setRequired(true);
    requiredGroup.setName("required-choice");
    requiredGroup.add(
        new Radio("Yes", "yes"),
        new Radio("No", "no"),
        new Radio("Maybe", "maybe")
    );
    self.add(requiredGroup);

    // Events section
    self.add(new H2("Event Handling"));
    self.add(new Paragraph("Radio components emit events when their state changes or when they receive/lose focus."));

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Event demo radio group
    RadioGroup eventGroup = new RadioGroup("Select an option to see events");
    eventGroup.setName("event-demo");
    eventGroup.setHelpText("Try selecting options and using Tab/Shift+Tab to see all events");
    
    Radio eventOpt1 = new Radio("Option 1", "opt1");
    Radio eventOpt2 = new Radio("Option 2", "opt2");
    Radio eventOpt3 = new Radio("Option 3", "opt3");

    // Event status display
    FlexLayout eventStatus = new FlexLayout();
    eventStatus.setDirection(FlexDirection.COLUMN)
               .setSpacing("5px")
               .setPadding("15px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border", "1px solid #dee2e6")
               .setStyle("border-radius", "8px")
               .setStyle("min-height", "100px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "13px");

    Label statusLabel = new Label("Waiting for events...");
    statusLabel.setStyle("color", "#6c757d");
    eventStatus.add(statusLabel);
    
    // Group level events
    eventGroup.onChange(event -> {
        Label changeEvent = new Label("[" + getTimestamp() + "] sl-change: value = " + event.getValue());
        changeEvent.setStyle("color", "#28a745");
        eventStatus.add(changeEvent);
        if (eventStatus.getComponentCount() > 10) {
            eventStatus.remove(eventStatus.getComponents().get(1));
        }
    });
    
    eventGroup.onInput(event -> {
        Label inputEvent = new Label("[" + getTimestamp() + "] sl-input: value = " + event.getValue());
        inputEvent.setStyle("color", "#17a2b8");
        eventStatus.add(inputEvent);
        if (eventStatus.getComponentCount() > 10) {
            eventStatus.remove(eventStatus.getComponents().get(1));
        }
    });
    
    // Individual radio events - apply to all radios
    Radio[] radios = {eventOpt1, eventOpt2, eventOpt3};
    String[] names = {"Option 1", "Option 2", "Option 3"};
    
    for (int i = 0; i < radios.length; i++) {
        final String name = names[i];
        final Radio radio = radios[i];
        
        radio.onFocus(event -> {
            Label focusEvent = new Label("[" + getTimestamp() + "] sl-focus: " + name);
            focusEvent.setStyle("color", "#6610f2");
            eventStatus.add(focusEvent);
            if (eventStatus.getComponentCount() > 10) {
                eventStatus.remove(eventStatus.getComponents().get(1));
            }
        });
        
        radio.onBlur(event -> {
            Label blurEvent = new Label("[" + getTimestamp() + "] sl-blur: " + name);
            blurEvent.setStyle("color", "#fd7e14");
            eventStatus.add(blurEvent);
            if (eventStatus.getComponentCount() > 10) {
                eventStatus.remove(eventStatus.getComponents().get(1));
            }
        });
    }
    
    eventGroup.add(eventOpt1, eventOpt2, eventOpt3);
    eventsDemo.add(eventGroup);
    eventsDemo.add(eventStatus);
    self.add(eventsDemo);

    // Event code example
    self.add(new H2("Event Code Example"));
    
    Div codeExample = new Div();
    codeExample.setStyle("background", "#f8f9fa")
               .setStyle("padding", "20px")
               .setStyle("border-radius", "8px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "14px")
               .setStyle("white-space", "pre-wrap")
               .setStyle("border", "1px solid #dee2e6");
    
    codeExample.setText("""
// RadioGroup events
radioGroup.onChange(event -> {
    String selectedValue = event.getValue();
    System.out.println("Selected: " + selectedValue);
});

radioGroup.onInput(event -> {
    String value = event.getValue();
    System.out.println("Input: " + value);
});

// Individual Radio events
radio.onFocus(event -> {
    System.out.println("Radio focused");
});

radio.onBlur(event -> {
    System.out.println("Radio blurred");
});
""");
    
    self.add(codeExample);

    // Programmatic control
    self.add(new H2("Programmatic Control"));
    
    RadioGroup controlGroup = new RadioGroup("Controlled group");
    controlGroup.setName("controlled");
    
    Radio red = new Radio("Red", "red");
    Radio green = new Radio("Green", "green");
    Radio blue = new Radio("Blue", "blue");
    
    controlGroup.add(red, green, blue);
    
    FlexLayout buttonContainer = new FlexLayout();
    buttonContainer.setDirection(FlexDirection.ROW)
                   .setSpacing("10px");
    
    com.webforj.component.button.Button selectRed = new com.webforj.component.button.Button("Select Red");
    selectRed.onClick(e -> controlGroup.setValue("red"));
    
    com.webforj.component.button.Button selectGreen = new com.webforj.component.button.Button("Select Green");
    selectGreen.onClick(e -> controlGroup.setValue("green"));
    
    com.webforj.component.button.Button selectBlue = new com.webforj.component.button.Button("Select Blue");
    selectBlue.onClick(e -> controlGroup.setValue("blue"));
    
    com.webforj.component.button.Button clearSelection = new com.webforj.component.button.Button("Clear");
    clearSelection.onClick(e -> controlGroup.setValue(""));
    
    buttonContainer.add(selectRed, selectGreen, selectBlue, clearSelection);
    
    self.add(controlGroup);
    self.add(buttonContainer);

    // Properties table
    self.add(new H2("Radio Properties"));
    self.add(createRadioPropertiesTable());

    // RadioGroup properties table
    self.add(new H2("RadioGroup Properties"));
    self.add(createRadioGroupPropertiesTable());
    
    // Events table
    self.add(new H2("Events"));
    self.add(createEventsTable());
  }

  private FlexLayout createRadioPropertiesTable() {
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
      {"name", "Groups radios together", "String", "\"\""},
      {"value", "The value submitted when selected", "String", "\"\""},
      {"size", "The size of the radio", "String", "\"medium\""},
      {"disabled", "Disables the radio", "boolean", "false"},
      {"checked", "Whether the radio is checked", "boolean", "false"},
      {"required", "Makes the radio required", "boolean", "false"}
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

  private FlexLayout createRadioGroupPropertiesTable() {
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
      {"label", "The group label", "String", "\"\""},
      {"name", "The name for all child radios", "String", "\"option\""},
      {"value", "The selected value", "String", "\"\""},
      {"size", "Size for all child radios", "String", "\"medium\""},
      {"required", "Makes selection required", "boolean", "false"},
      {"help-text", "Help text displayed below the group", "String", "\"\""}
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

  private com.webforj.component.html.elements.Div createTableCell(String content, boolean isHeader) {
    com.webforj.component.html.elements.Div cell = new com.webforj.component.html.elements.Div();
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
      createTableCell("Event Data", true),
      createTableCell("Component", true)
    );

    // Data rows
    String[][] events = {
      {"sl-change", "Emitted when the selected value changes", "value: string", "RadioGroup"},
      {"sl-input", "Emitted when the user interacts with a radio", "value: string", "RadioGroup"},
      {"sl-focus", "Emitted when a radio gains focus", "-", "Radio"},
      {"sl-blur", "Emitted when a radio loses focus", "-", "Radio"}
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
  
  private String getTimestamp() {
    return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
  }
}