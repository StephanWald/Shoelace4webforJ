# AI Antipatterns in webforJ Shoelace Integration

This document lists patterns in this webforJ Shoelace project that AI coding agents might find unexpected or handle incorrectly. These represent places where standard Java assumptions don't apply.

## 1. JavaScript/CSS Loading Patterns

**What AI agents might expect:**
```java
// Standard local resource loading
@JavaScript("js/alert.js")
@StyleSheet("css/alert.css")
```

**What this project actually uses:**
```java
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/alert/alert.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
```

**Key antipattern:** Always requires `attributes = {@Attribute(name = "type", value = "module")}` for ES6 modules. AI agents often forget this critical annotation.

## 2. Constructor Patterns

**What AI agents might expect:**
```java
public Alert() {
    super("sl-alert"); // Pass element name to constructor
}
```

**What this project actually uses:**
```java
@NodeName("sl-alert")
public class Alert extends ElementComposite {
    public Alert() {
        super(); // No parameters - NodeName annotation handles element creation
    }
}
```

**Key antipattern:** Constructor calls `super()` without parameters, relying entirely on `@NodeName` annotation.

## 3. Property Management

**What AI agents might expect:**
```java
private boolean open;
private String variant = "primary";

public void setOpen(boolean open) {
    this.open = open; // Direct field assignment
}
```

**What this project actually uses:**
```java
private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);
private final PropertyDescriptor<String> variantProp = PropertyDescriptor.property("variant", "primary");

public Alert setOpen(boolean open) {
    set(openProp, open); // PropertyDescriptor system
    return this;
}
```

**Key antipatterns:**
- HTML attributes use kebab-case ("no-header", "slides-per-page") not camelCase
- PropertyDescriptor manages automatic DOM synchronization
- No direct field access to component state

## 4. Event Handling

**What AI agents might expect:**
```java
public void onClick(ClickListener listener) {
    addListener(listener);
}
```

**What this project actually uses:**
```java
@EventName("sl-request-close")
@EventOptions(data = {
  @EventOptions.EventData(key = "source", exp = "event.detail.source")
})
public static class RequestCloseEvent extends ComponentEvent<Dialog> {
    public String getSource() {
        return (String) getData().get("source");
    }
}
```

**Key antipatterns:**
- Events use Shoelace-specific names ("sl-" prefix) not standard DOM events
- Event data extracted via JavaScript expressions in `@EventOptions`
- Each event type requires its own static nested class
- **IMPORTANT:** ShoelaceButton has NO onClick() method - this is a major gotcha

## 5. Slot Management

**What AI agents might expect:**
```java
public void setIcon(Icon icon) {
    this.icon = icon; // Direct assignment
}
```

**What this project actually uses:**
```java
public Alert setIcon(com.webforj.component.Component icon) {
    getBoundComponent().add("icon", icon); // String-based slot name
    return this;
}
```

**Key antipatterns:**
- Slots identified by string names matching Shoelace slots
- Must use `getBoundComponent()` to access underlying element
- Default content uses `getBoundComponent().add(components)` without slot name

## 6. Interface Implementation Inconsistencies

**What AI agents might expect:**
```java
// Consistent generic parameter usage
public class Alert implements HasHtml<Alert>, HasStyle<Alert>, HasComponents<Alert>
```

**What this project actually uses:**
```java
// Inconsistent generic requirements
public class Alert implements HasHtml<Alert>, HasStyle<Alert>, HasComponents {
    // HasComponents takes NO generic parameters!
}
```

**Key antipattern:** `HasHtml<T>` and `HasStyle<T>` require generic type parameters, but `HasComponents` does not.

## 7. HTML Content vs Component Structure

**What AI agents might expect:**
```java
// Separation of concerns
button.setText("Click Me");
button.setIcon(new Icon("plus"));
```

**What this project actually uses:**
```java
// Raw HTML mixed with component content
circleBtn.setHtml("<sl-icon name=\"plus\"></sl-icon>");
basicBtn.setHtml("Click Me");
```

**Key antipattern:** Components can contain both structured components and raw HTML. `setHtml()` replaces ALL content, not just text.

## 8. CSS Customization

**What AI agents might expect:**
```java
dialog.setStyle("width", "500px");
dialog.setStyle("background-color", "blue");
```

**What this project actually uses:**
```java
dialog.setStyle("--width", "500px"); // CSS custom property
tree.setStyle("--indent-size", "2rem"); // Component-specific custom property
```

**Key antipattern:** Shoelace components use CSS custom properties (--property-name) for customization, not standard CSS properties.

## 9. Event Data Access

**What AI agents might expect:**
```java
public class ClickEvent {
    public int getClientX() { return clientX; } // Typed getter
}
```

**What this project actually uses:**
```java
public int getClientX() {
    return ((Number) getData().get("clientX")).intValue(); // String key + casting
}
```

**Key antipattern:** Event data accessed through string keys with required type casting, not typed getters.

## 10. Component Lifecycle and JavaScript Interop

**What AI agents might expect:**
```java
public void show() {
    setVisible(true); // Pure Java
}
```

**What this project actually uses:**
```java
public Dialog show() {
    // JavaScript execution required for proper behavior
    getBoundComponent().executeJs(
      "if (this.parentElement && document.body && this.parentElement !== document.body) {" +
      "  document.body.appendChild(this);" +
      "}"
    );
    setOpen(true);
    return this;
}
```

**Key antipattern:** Some components require JavaScript execution for proper behavior. Modal dialogs need DOM manipulation that pure Java can't handle.

## 11. Method Availability vs Implementation

**What AI agents might expect:**
```java
// If a method exists, it works
button.focus(); // Should focus the button
```

**What this project reality shows:**
```java
public void focus() {
    // Note: Would need JavaScript interop
    // Method exists but doesn't work without additional implementation
}
```

**Key antipattern:** Some methods are placeholders that require JavaScript interop to actually function.

## 12. Build and Test Patterns

**What AI agents might expect:**
```bash
# Standard Maven commands
mvn test
mvn package
```

**What this project actually uses:**
```bash
# Integration tests require full lifecycle
mvn verify  # Starts Jetty, runs tests, stops Jetty

# Code formatting is enforced
mvn spotless:apply  # Must run before commits
```

**Key antipattern:** Tests are integration tests that require the full web server lifecycle, not unit tests.

## Summary

AI agents working with webforJ and Shoelace integration should be aware that:

1. **Standard Java UI patterns don't apply** - this is web component integration, not Swing/JavaFX
2. **JavaScript interop is often required** - some functionality can't be purely Java
3. **Property management is declarative** - uses PropertyDescriptor system, not direct fields
4. **Event handling is complex** - requires understanding of web component event patterns
5. **HTML/CSS knowledge is essential** - components expose web-native customization patterns
6. **Build process is web-aware** - integration tests, code formatting, and server lifecycle matter

The biggest mistake AI agents make is treating these components like traditional Java UI components when they're actually sophisticated wrappers around web components that require understanding of both Java and web technologies.