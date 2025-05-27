# Shoelace Harmonization Notes

## Core Patterns

### 1. Component Class Pattern
```java
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/[name]/[name].js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-[name]")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class ComponentName extends ElementComposite implements HasHtml<ComponentName>, HasStyle<ComponentName>, HasComponents {
    // Property descriptors use camelCase
    private final PropertyDescriptor<String> variantProp = PropertyDescriptor.property("variant", "primary");
    
    // Event classes are inner static classes
    @EventName("sl-event-name")
    public static class EventNameEvent extends ComponentEvent<ComponentName> {
        public EventNameEvent(ComponentName component, Map<String, Object> eventData) {
            super(component, eventData);
        }
    }
    
    // Event handler methods return ListenerRegistration
    public ListenerRegistration<EventNameEvent> onEventName(EventListener<EventNameEvent> listener) {
        return this.addEventListener(EventNameEvent.class, listener);
    }
}
```

### 2. View Class Pattern
```java
@Route(value = "/component-name", outlet = MainLayout.class)
@FrameTitle("Component Name")
public class ComponentNameView extends Composite<FlexLayout> {
    private FlexLayout self = getBoundComponent();
    
    public ComponentNameView() {
        self.setDirection(FlexDirection.COLUMN);
        self.setPadding("20px");
        self.setSpacing("40px");
        self.setMaxWidth("800px");
        self.setMargin("0 auto");
        
        // Sections in order
        self.add(header, examples..., interactiveExample, eventsSection, propertiesSection);
    }
}
```

## Event Implementation Rules

### 1. Event Data Access
```java
// CORRECT - Use getData()
event.getData().get("propertyName")

// WRONG - These don't exist
event.getEventData()
event.getEventMap()
```

### 2. Event Naming Convention
- Component events: `sl-event-name` (kebab-case)
- Java class: `EventNameEvent` (PascalCase + Event suffix)
- Handler method: `onEventName` (camelCase with on prefix)

### 3. Event Handler Pattern
```java
component.onEventName(event -> {
    // Get event data
    String value = (String) event.getData().get("value");
    
    // Update UI with timestamp
    Label eventLabel = new Label("[" + getTimestamp() + "] sl-event-name: " + description);
    eventLabel.setStyle("color", "#10b981"); // Use appropriate color
    eventStatus.add(eventLabel);
    
    // Limit history
    if (eventStatus.getComponentCount() > 5) {
        eventStatus.remove(eventStatus.getComponents().get(1));
    }
});
```

## Property Patterns

### 1. Property Descriptor Naming
```java
// CORRECT - camelCase
private final PropertyDescriptor<String> variantProp = PropertyDescriptor.property("variant", "primary");

// WRONG - UPPERCASE
private final PropertyDescriptor<String> VARIANT = PropertyDescriptor.property("variant", "primary");
```

### 2. Getter/Setter Pattern
```java
public String getVariant() {
    return get(variantProp);
}

public ComponentName setVariant(String variant) {
    set(variantProp, variant);
    return this; // Fluent API
}
```

## Common Pitfalls to Avoid

### 1. JavaScript Execution
```java
// WRONG - Can't access element directly in ElementComposite
getBoundComponent().getElement().executeJs("...");

// CORRECT - Use component methods or property changes
component.setPlay(false);
component.setIterations("0");
component.setIterations(originalValue);
```

### 2. HasComponents Interface
```java
// CORRECT - No type parameter
implements HasComponents

// WRONG - HasComponents doesn't take type parameters
implements HasComponents<ComponentName>
```

### 3. Event Tables
Always include these columns:
1. Event (sl-event-name)
2. Description (what triggers it)
3. Event Data (properties available in event.getData())

## Components Groupings by Events

### Has Events
Alert, AnimatedImage, Animation, Button, Carousel, Checkbox, ColorPicker, CopyButton, Details, Dialog, Drawer, Dropdown, Input, Menu, Radio/RadioButton/RadioGroup, Range, Rating, Select, Switch, Tab/TabGroup, Textarea, Tree

### No Events (Display Only)
Avatar, Badge, Breadcrumb, Card, Divider, Icon, ImageComparer, Option, ProgressBar, ProgressRing, Skeleton, Spinner, SplitPanel, Tag, Tooltip

## Harmonization Checklist

### For Each Component Class:
- [ ] Comprehensive JavaDoc with examples
- [ ] Property descriptors use camelCase
- [ ] All Shoelace events implemented
- [ ] Event classes use @EventName annotation
- [ ] Event handlers return ListenerRegistration
- [ ] Implements correct interfaces

### For Each View Class:
- [ ] Has DocumentationLinks in header
- [ ] Follows section order: Header → Examples → Interactive → Events → Properties
- [ ] Uses consistent styling methods
- [ ] Events section has demo + table (or note if no events)
- [ ] Properties section has table
- [ ] Code examples use styleCodeBlock()
- [ ] Event demos show real-time feedback with timestamps

## Migration Steps

1. **Update Component Class**
   - Add/update JavaDoc
   - Convert property names to camelCase
   - Add missing events
   - Ensure proper interfaces

2. **Update View Header**
   - Add import statement display
   - Add DocumentationLinks with correct paths

3. **Reorganize Sections**
   - Move sections to correct order
   - Ensure consistent naming

4. **Add Missing Sections**
   - Add Events section with demo and table
   - Add Properties table if missing
   - Add Interactive example if applicable

5. **Apply Consistent Styling**
   - Use styleCodeBlock() for all code
   - Use standard table creation methods
   - Apply event status styling

6. **Test Compilation**
   - Run mvn compile
   - Fix any errors
   - Verify event handlers work