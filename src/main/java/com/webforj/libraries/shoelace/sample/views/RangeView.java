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
import com.webforj.libraries.shoelace.components.Range;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;

@Route(value = "/range", outlet = MainLayout.class)
@FrameTitle("Range")
public class RangeView extends Composite<FlexLayout> {
  private final FlexLayout self = getBoundComponent();

  public RangeView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Title and documentation links
    self.add(new H1("Range"));
    self.add(new DocumentationLinks(
        "/static/javadoc/com/webforj/libraries/shoelace/components/Range.html",
        "https://shoelace.style/components/range"
    ));
    
    self.add(new Paragraph("Ranges allow users to select a single value within a given range using a slider."));

    // Basic Range example
    self.add(new H2("Basic Range"));
    Range basicRange = new Range();
    basicRange.setLabel("Volume");
    basicRange.setValue(50);
    
    Div basicValue = new Div();
    basicValue.setStyle("padding", "10px")
              .setStyle("background-color", "#f0f0f0")
              .setStyle("border-radius", "4px")
              .setStyle("font-family", "monospace")
              .setHtml("Value: <strong>50</strong>");
    
    basicRange.onInput(event -> {
        basicValue.setHtml("Value: <strong>" + Math.round(event.getValue()) + "</strong>");
    });
    
    self.add(basicRange);
    self.add(basicValue);

    // Min, Max, and Step example
    self.add(new H2("Min, Max, and Step"));
    Range tempRange = new Range(-10, 40, 20);
    tempRange.setLabel("Temperature (°C)");
    tempRange.setStep(0.5);
    tempRange.setHelpText("Select a temperature between -10°C and 40°C");
    
    Div tempValue = new Div();
    tempValue.setStyle("padding", "10px")
             .setStyle("background-color", "#f0f0f0")
             .setStyle("border-radius", "4px")
             .setStyle("font-family", "monospace")
             .setHtml("Temperature: <strong>20.0°C</strong>");
    
    tempRange.onInput(event -> {
        tempValue.setHtml("Temperature: <strong>" + event.getValue() + "°C</strong>");
    });
    
    self.add(tempRange);
    self.add(tempValue);

    // Tooltip Positions
    self.add(new H2("Tooltip Positions"));
    
    Range topTooltip = new Range();
    topTooltip.setLabel("Top Tooltip (default)");
    topTooltip.setTooltip("top");
    topTooltip.setValue(50);
    self.add(topTooltip);
    
    Range bottomTooltip = new Range();
    bottomTooltip.setLabel("Bottom Tooltip");
    bottomTooltip.setTooltip("bottom");
    bottomTooltip.setValue(50);
    self.add(bottomTooltip);
    
    Range noTooltip = new Range();
    noTooltip.setLabel("No Tooltip");
    noTooltip.setTooltip("none");
    noTooltip.setValue(50);
    self.add(noTooltip);

    // States
    self.add(new H2("States"));
    
    Range disabledRange = new Range();
    disabledRange.setLabel("Disabled Range");
    disabledRange.setValue(50);
    disabledRange.setDisabled(true);
    self.add(disabledRange);
    
    Range requiredRange = new Range();
    requiredRange.setLabel("Required Range");
    requiredRange.setRequired(true);
    requiredRange.setHelpText("This field is required");
    self.add(requiredRange);

    // Event Handling
    self.add(new H2("Event Handling"));
    self.add(new Paragraph("Ranges emit events when their value changes or when they receive/lose focus."));
    
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
    
    Range eventRange = new Range(0, 100, 25);
    eventRange.setLabel("Event Demo");
    eventRange.setStep(5);
    eventRange.setHelpText("Drag the slider and use Tab/Shift+Tab to see all events");
    
    // Real-time input tracking
    eventRange.onInput(event -> {
        Label inputEvent = new Label("[" + getTimestamp() + "] sl-input: value = " + event.getValue());
        inputEvent.setStyle("color", "#17a2b8");
        eventOutput.add(inputEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Change event (on blur or release)
    eventRange.onChange(event -> {
        Label changeEvent = new Label("[" + getTimestamp() + "] sl-change: value = " + event.getValue());
        changeEvent.setStyle("color", "#28a745");
        eventOutput.add(changeEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Focus/blur events
    eventRange.onFocus(event -> {
        Label focusEvent = new Label("[" + getTimestamp() + "] sl-focus");
        focusEvent.setStyle("color", "#6610f2");
        eventOutput.add(focusEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    eventRange.onBlur(event -> {
        Label blurEvent = new Label("[" + getTimestamp() + "] sl-blur");
        blurEvent.setStyle("color", "#fd7e14");
        eventOutput.add(blurEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    // Invalid event (when validation fails)
    eventRange.onInvalid(event -> {
        Label invalidEvent = new Label("[" + getTimestamp() + "] sl-invalid");
        invalidEvent.setStyle("color", "#dc3545");
        eventOutput.add(invalidEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
    });
    
    self.add(eventRange);
    self.add(eventOutput);

    // Practical Examples
    self.add(new H2("Practical Examples"));
    
    // Price range with formatting
    Range priceRange = new Range(0, 1000, 500);
    priceRange.setLabel("Price Range");
    priceRange.setStep(50);
    priceRange.setHelpText("Select your budget");
    
    Div priceDisplay = new Div();
    priceDisplay.setStyle("font-size", "24px")
                .setStyle("font-weight", "bold")
                .setStyle("color", "#059669")
                .setHtml("$500");
    
    priceRange.onInput(event -> {
        priceDisplay.setHtml("$" + Math.round(event.getValue()));
    });
    
    self.add(priceRange);
    self.add(priceDisplay);
    
    // Brightness control
    self.add(new H2("Interactive Demo - Brightness Control"));
    
    Range brightnessRange = new Range(0, 100, 100);
    brightnessRange.setLabel("Brightness");
    brightnessRange.setStyle("--track-color-active", "#fbbf24");
    
    Div brightnessDemo = new Div();
    brightnessDemo.setText("🌞")
                  .setStyle("font-size", "72px")
                  .setStyle("text-align", "center")
                  .setStyle("padding", "20px")
                  .setStyle("background", "#fffbeb")
                  .setStyle("border-radius", "8px")
                  .setStyle("filter", "brightness(100%)");
    
    brightnessRange.onInput(event -> {
        double brightness = event.getValue();
        brightnessDemo.setStyle("filter", "brightness(" + brightness + "%)");
        
        // Change background color based on brightness
        if (brightness < 30) {
            brightnessDemo.setStyle("background", "#1f2937");
        } else if (brightness < 70) {
            brightnessDemo.setStyle("background", "#fef3c7");
        } else {
            brightnessDemo.setStyle("background", "#fffbeb");
        }
    });
    
    self.add(brightnessRange);
    self.add(brightnessDemo);

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
      {"name", "String", "\"\"", "The input's name attribute"},
      {"value", "double", "0.0", "The current numeric value"},
      {"label", "String", "\"\"", "The range's label"},
      {"help-text", "String", "\"\"", "Help text displayed below the range"},
      {"min", "double", "0.0", "The minimum allowed value"},
      {"max", "double", "100.0", "The maximum allowed value"},
      {"step", "double", "1.0", "The increment/decrement amount"},
      {"tooltip", "String", "\"top\"", "Tooltip placement: top, bottom, or none"},
      {"disabled", "boolean", "false", "Disables the range"},
      {"required", "boolean", "false", "Makes the range required"},
      {"form", "String", "\"\"", "Associates with a form by ID"}
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
      {"sl-change", "Emitted when the value changes via user interaction", "value: number"},
      {"sl-input", "Emitted continuously as the user drags the slider", "value: number"},
      {"sl-focus", "Emitted when the range gains focus", "-"},
      {"sl-blur", "Emitted when the range loses focus", "-"},
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
