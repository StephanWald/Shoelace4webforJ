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
import com.webforj.libraries.shoelace.components.Rating;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;

@Route(value = "/rating", outlet = MainLayout.class)
@FrameTitle("Rating")
public class RatingView extends Composite<FlexLayout> {
  private final FlexLayout self = getBoundComponent();

  public RatingView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Title and documentation links
    self.add(new H1("Rating"));
    self.add(new DocumentationLinks(
        "/static/javadoc/com/webforj/libraries/shoelace/components/Rating.html",
        "https://shoelace.style/components/rating"
    ));
    
    self.add(new Paragraph("Ratings give users a way to quickly view and provide feedback."));

    // Basic Rating example
    self.add(new H2("Basic Rating"));
    
    Rating basicRating = new Rating();
    basicRating.setLabel("Rate your experience");
    basicRating.setValue(3);
    
    Div basicValue = new Div();
    basicValue.setStyle("padding", "10px")
              .setStyle("background-color", "#f0f0f0")
              .setStyle("border-radius", "4px")
              .setStyle("font-family", "monospace")
              .setHtml("Current rating: <strong>3 / 5</strong>");
    
    basicRating.onChange(event -> {
        double value = event.getValue();
        basicValue.setHtml("Current rating: <strong>" + value + " / 5</strong>");
    });
    
    self.add(basicRating);
    self.add(basicValue);

    // Max Value example
    self.add(new H2("Maximum Value"));
    self.add(new Paragraph("Ratings are 0-5 by default. You can change the maximum value."));
    
    Rating maxThree = new Rating(2, 3);
    maxThree.setLabel("Rate out of 3");
    self.add(maxThree);
    
    Rating maxTen = new Rating(7, 10);
    maxTen.setLabel("Rate out of 10");
    self.add(maxTen);
    
    Rating maxHundred = new Rating(85, 100);
    maxHundred.setLabel("Rate out of 100");
    self.add(maxHundred);

    // Precision example
    self.add(new H2("Precision"));
    self.add(new Paragraph("Use the precision attribute to let users select fractional ratings."));
    
    Rating halfStars = new Rating();
    halfStars.setLabel("Half stars");
    halfStars.enableHalfStars();
    halfStars.setValue(2.5);
    self.add(halfStars);
    
    Rating quarterStars = new Rating();
    quarterStars.setLabel("Quarter stars");
    quarterStars.enableQuarterStars();
    quarterStars.setValue(3.75);
    self.add(quarterStars);
    
    Rating customPrecision = new Rating();
    customPrecision.setLabel("0.1 precision");
    customPrecision.setPrecision(0.1);
    customPrecision.setValue(4.3);
    self.add(customPrecision);
    
    Div precisionValue = new Div();
    precisionValue.setStyle("padding", "10px")
                  .setStyle("background-color", "#f0f0f0")
                  .setStyle("border-radius", "4px")
                  .setStyle("font-family", "monospace")
                  .setHtml("Values: Half=2.5, Quarter=3.75, Custom=4.3");
    self.add(precisionValue);

    // States example
    self.add(new H2("States"));
    
    Rating readonlyRating = new Rating(4);
    readonlyRating.setLabel("Readonly rating (focusable but unchangeable)");
    readonlyRating.setReadonly(true);
    self.add(readonlyRating);
    
    Rating disabledRating = new Rating(3);
    disabledRating.setLabel("Disabled rating");
    disabledRating.setDisabled(true);
    self.add(disabledRating);

    // Event Handling
    self.add(new H2("Event Handling"));
    self.add(new Paragraph("Ratings emit events when their value changes and when hovering over stars."));
    
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
    
    Rating eventRating = new Rating(0);
    eventRating.setLabel("Interactive rating with events");
    eventRating.enableHalfStars();
    
    Div currentValue = new Div();
    currentValue.setStyle("margin-top", "10px")
                .setStyle("font-weight", "bold")
                .setHtml("Current value: <span style='color: #28a745'>0</span> stars");
    
    // Change event
    eventRating.onChange(event -> {
        double value = event.getValue();
        Label changeEvent = new Label("[" + getTimestamp() + "] sl-change: value = " + value);
        changeEvent.setStyle("color", "#28a745");
        eventOutput.add(changeEvent);
        if (eventOutput.getComponentCount() > 10) {
            eventOutput.remove(eventOutput.getComponents().get(1));
        }
        currentValue.setHtml("Current value: <span style='color: #28a745'>" + value + "</span> stars");
    });
    
    // Hover event
    eventRating.onHover(event -> {
        double value = event.getValue();
        String phase = event.getPhase();
        
        if ("start".equals(phase)) {
            Label hoverEvent = new Label("[" + getTimestamp() + "] sl-hover: hovering over " + value + " stars");
            hoverEvent.setStyle("color", "#17a2b8");
            eventOutput.add(hoverEvent);
            if (eventOutput.getComponentCount() > 10) {
                eventOutput.remove(eventOutput.getComponents().get(1));
            }
        } else if ("end".equals(phase)) {
            Label hoverEndEvent = new Label("[" + getTimestamp() + "] sl-hover: hover ended");
            hoverEndEvent.setStyle("color", "#6c757d");
            eventOutput.add(hoverEndEvent);
            if (eventOutput.getComponentCount() > 10) {
                eventOutput.remove(eventOutput.getComponents().get(1));
            }
        }
    });
    
    self.add(eventRating);
    self.add(eventOutput);
    self.add(currentValue);
    
    // Custom Styling
    self.add(new H2("Custom Styling"));
    
    Rating coloredRating = new Rating(4);
    coloredRating.setLabel("Custom colors");
    coloredRating.setCustomStyle("#94a3b8", "#f59e0b", null, null);
    self.add(coloredRating);
    
    Rating largeRating = new Rating(3);
    largeRating.setLabel("Large stars");
    largeRating.setCustomStyle(null, null, "3rem", null);
    self.add(largeRating);
    
    Rating styledRating = new Rating(5);
    styledRating.setLabel("Fully styled");
    styledRating.setCustomStyle("#e2e8f0", "#dc2626", "2.5rem", "0.25rem");
    self.add(styledRating);

    // Practical Example - Feedback Form
    self.add(new H2("Practical Example - Feedback Form"));
    
    Div feedbackCard = new Div();
    feedbackCard.setStyle("padding", "20px")
                .setStyle("background", "#f0f9ff")
                .setStyle("border-radius", "8px")
                .setStyle("max-width", "400px");
    
    Div feedbackTitle = new Div();
    feedbackTitle.setHtml("<strong>How was your experience?</strong>");
    feedbackTitle.setStyle("margin-bottom", "15px")
                 .setStyle("font-size", "18px");
    
    Rating feedbackRating = new Rating();
    feedbackRating.setLabel("Rate your experience");
    
    Div feedbackMessage = new Div();
    feedbackMessage.setStyle("margin-top", "15px")
                   .setStyle("padding", "10px")
                   .setStyle("background", "white")
                   .setStyle("border-radius", "4px")
                   .setStyle("min-height", "40px")
                   .setHtml("<em>Please rate your experience above...</em>");
    
    feedbackRating.onChange(event -> {
        double value = event.getValue();
        String message;
        String color;
        
        if (value <= 1) {
            message = "We're sorry to hear that. How can we improve?";
            color = "#dc2626";
        } else if (value <= 2) {
            message = "Thank you for your feedback. We'll work to do better.";
            color = "#f59e0b";
        } else if (value <= 3) {
            message = "Thank you! We appreciate your feedback.";
            color = "#3b82f6";
        } else if (value <= 4) {
            message = "Great to hear! Thank you for the positive feedback.";
            color = "#10b981";
        } else {
            message = "Awesome! Thank you so much for the 5-star rating!";
            color = "#059669";
        }
        
        feedbackMessage.setHtml("<strong>" + message + "</strong>")
                       .setStyle("color", color);
    });
    
    feedbackCard.add(feedbackTitle);
    feedbackCard.add(feedbackRating);
    feedbackCard.add(feedbackMessage);
    
    self.add(feedbackCard);

    // Properties table
    self.add(new H2("Properties"));
    FlexLayout table = createPropertiesTable();
    self.add(table);
    
    // Events table
    self.add(new H2("Events"));
    self.add(createEventsTable());
  }

  private FlexLayout createPropertiesTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #e2e8f0");
    table.setStyle("border-radius", "8px");
    table.setStyle("overflow", "hidden");
    
    // Header
    FlexLayout header = new FlexLayout();
    header.setStyle("background-color", "#f1f5f9");
    header.setStyle("font-weight", "bold");
    header.setStyle("padding", "12px");
    header.setStyle("display", "grid");
    header.setStyle("grid-template-columns", "150px 100px 100px 1fr");
    header.setStyle("gap", "16px");
    
    header.add(new Div("Property"));
    header.add(new Div("Type"));
    header.add(new Div("Default"));
    header.add(new Div("Description"));
    table.add(header);
    
    // Create rows
    String[][] properties = {
      {"label", "String", "\"\"", "Accessibility label for screen readers"},
      {"value", "double", "0.0", "The current rating value"},
      {"max", "int", "5", "Maximum number of symbols"},
      {"precision", "double", "1.0", "Precision for fractional ratings"},
      {"readonly", "boolean", "false", "Makes rating readonly"},
      {"disabled", "boolean", "false", "Disables the rating"}
    };
    
    for (int i = 0; i < properties.length; i++) {
      FlexLayout row = new FlexLayout();
      row.setStyle("padding", "12px");
      row.setStyle("display", "grid");
      row.setStyle("grid-template-columns", "150px 100px 100px 1fr");
      row.setStyle("gap", "16px");
      row.setStyle("background-color", i % 2 == 0 ? "white" : "#f9fafb");
      row.setStyle("border-top", "1px solid #e2e8f0");
      
      Div propName = new Div(properties[i][0]);
      propName.setStyle("font-family", "monospace");
      propName.setStyle("color", "#e11d48");
      
      Div propType = new Div(properties[i][1]);
      propType.setStyle("color", "#6b7280");
      
      Div propDefault = new Div(properties[i][2]);
      propDefault.setStyle("font-family", "monospace");
      propDefault.setStyle("color", "#059669");
      
      Div propDesc = new Div(properties[i][3]);
      propDesc.setStyle("color", "#374151");
      
      row.add(propName);
      row.add(propType);
      row.add(propDefault);
      row.add(propDesc);
      
      table.add(row);
    }
    
    return table;
  }
  
  private FlexLayout createEventsTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #e2e8f0");
    table.setStyle("border-radius", "8px");
    table.setStyle("overflow", "hidden");
    
    // Header
    FlexLayout header = new FlexLayout();
    header.setStyle("background-color", "#f1f5f9");
    header.setStyle("font-weight", "bold");
    header.setStyle("padding", "12px");
    header.setStyle("display", "grid");
    header.setStyle("grid-template-columns", "150px 1fr 200px");
    header.setStyle("gap", "16px");
    
    header.add(new Div("Event"));
    header.add(new Div("Description"));
    header.add(new Div("Event Data"));
    table.add(header);
    
    // Create rows
    String[][] events = {
      {"sl-change", "Emitted when the rating value changes", "value: number"},
      {"sl-hover", "Emitted when hovering over the rating", "value: number, phase: 'start' | 'end'"}
    };
    
    for (int i = 0; i < events.length; i++) {
      FlexLayout row = new FlexLayout();
      row.setStyle("padding", "12px");
      row.setStyle("display", "grid");
      row.setStyle("grid-template-columns", "150px 1fr 200px");
      row.setStyle("gap", "16px");
      row.setStyle("background-color", i % 2 == 0 ? "white" : "#f9fafb");
      row.setStyle("border-top", "1px solid #e2e8f0");
      
      Div eventName = new Div(events[i][0]);
      eventName.setStyle("font-family", "monospace");
      eventName.setStyle("color", "#e11d48");
      
      Div eventDesc = new Div(events[i][1]);
      eventDesc.setStyle("color", "#374151");
      
      Div eventData = new Div(events[i][2]);
      eventData.setStyle("font-family", "monospace");
      eventData.setStyle("color", "#059669");
      eventData.setStyle("font-size", "0.9em");
      
      row.add(eventName);
      row.add(eventDesc);
      row.add(eventData);
      
      table.add(row);
    }
    
    return table;
  }
  
  private String getTimestamp() {
    return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
  }
}
