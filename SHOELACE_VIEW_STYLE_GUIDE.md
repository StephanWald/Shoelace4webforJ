# Shoelace Component View Style Guide

## View Structure Pattern (Strict Order)

1. **Header Section**
   - H1 title
   - Description paragraph
   - Import statement (styled code block)
   - DocumentationLinks component

2. **Example Sections** (as needed)
   - Basic Example
   - Variants/Sizes/States examples
   - Feature-specific examples

3. **Interactive Example** (if applicable)
   - Always titled "Interactive Example"
   - Contains controls to manipulate component properties
   - Shows live preview of component

4. **Events Section** (if component has events)
   - Title: "Event Handling"
   - Description of events
   - Live demo with event feedback
   - Code example
   - Events table (always at end of section)

5. **Properties Section**
   - Title: "Properties"
   - Description
   - Properties table

## Styling Rules

### Section Creation
```java
private FlexLayout createSection(String title, String description) {
    FlexLayout section = new FlexLayout();
    section.setDirection(FlexDirection.COLUMN);
    section.setSpacing("15px");
    
    H2 sectionTitle = new H2(title);
    Paragraph sectionDesc = new Paragraph(description);
    
    section.add(sectionTitle, sectionDesc);
    return section;
}
```

### Code Blocks
```java
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
```

### Import Statement (Header)
```java
Div componentImport = new Div();
componentImport.setText("import com.webforj.libraries.shoelace.components.ComponentName;");
componentImport.setStyle("background", "#f0f0f0")
               .setStyle("padding", "8px 12px")
               .setStyle("border-radius", "4px")
               .setStyle("font-family", "monospace")
               .setStyle("font-size", "14px")
               .setStyle("margin-bottom", "10px");
```

### Event Status Display
```java
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
```

### Tables (Properties and Events)
```java
private FlexLayout createPropertiesTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden");
    // Note: No margin-top here, handled by section spacing
    
    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
        createTableCell("Property", true),
        createTableCell("Description", true),
        createTableCell("Type", true),
        createTableCell("Default", true)
    );
    // ... rest of table
}

private FlexLayout createEventsTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden")
         .setStyle("margin-top", "20px"); // Extra spacing before events table
    
    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
        createTableCell("Event", true),
        createTableCell("Description", true),
        createTableCell("Event Data", true)
    );
    // ... rest of table
}
```

### Table Rows and Cells
```java
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
```

## Content Guidelines

### Section Titles
- **Header**: Component name only (e.g., "Button", "Alert")
- **Examples**: Descriptive titles (e.g., "Basic Example", "Sizes and Variants", "Auto-playing Animation")
- **Interactive**: Always "Interactive Example"
- **Events**: Always "Event Handling"
- **Properties**: Always "Properties"

### Section Descriptions
- Keep concise (1-2 sentences)
- Focus on what the section demonstrates
- Use present tense
- Examples:
  - "Create simple alerts with different variants to convey meaning."
  - "Control animations with duration, delay, easing, and more."
  - "The component supports the following properties:"

### Code Examples
- Use consistent indentation (2 spaces)
- Include helpful comments
- Show practical usage patterns
- Keep examples focused and minimal
- Always use full class names in import examples

### Event Demonstrations
- Always include timestamp in event feedback
- Use consistent color coding:
  - `#10b981` (green) for positive events (start, load, show)
  - `#0969da` (blue) for neutral events (change, finish)
  - `#dc2626` (red) for negative events (error, cancel, hide)
  - `#6c757d` (gray) for status messages
- Limit event history to 5-6 entries
- Format: `[HH:mm:ss] event-name: Description`

### DocumentationLinks Usage
```java
DocumentationLinks docsLinks = new DocumentationLinks(
    "/static/javadoc/com/webforj/libraries/shoelace/components/ComponentName.html",
    "https://shoelace.style/components/component-name"
);
```

## Component-Specific Rules

### Components Without Events
For components that don't emit events (Badge, Avatar, Icon, etc.), include a note in the Events section:

```java
FlexLayout eventsSection = createSection(
    "Events",
    "The ComponentName component does not emit any custom events."
);

Div noEventsNote = new Div();
noEventsNote.setText(
    "This component is display-only and does not emit events. " +
    "If you need to handle user interactions, you can wrap it in a clickable " +
    "container or use it within interactive components."
);
noEventsNote.setStyle("background", "#f8f9fa")
            .setStyle("padding", "16px")
            .setStyle("border-radius", "8px")
            .setStyle("font-size", "14px")
            .setStyle("color", "#495057")
            .setStyle("border", "1px solid #e9ecef");

eventsSection.add(noEventsNote);
```

## Main Layout Organization
```java
self.add(
    header,
    basicExample,
    variantsExample,     // or other feature examples
    interactiveExample,  // if applicable
    eventsSection,       // always include, even if no events
    propertiesSection    // always last
);
```

## Consistency Checklist
- [ ] Component uses DocumentationLinks with correct paths
- [ ] All sections follow the prescribed order
- [ ] Code blocks use styleCodeBlock() method
- [ ] Tables use consistent styling methods
- [ ] Event demos include timestamp and color coding
- [ ] Properties table includes all component properties
- [ ] Events table includes all component events (or note if none)
- [ ] Import statement shown in header section
- [ ] Consistent spacing between sections (40px on main layout)