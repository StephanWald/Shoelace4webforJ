# webforJ `SideMenu` Archetype

A minimal and ready-to-use starting point for building webforJ applications. This archetype includes the essential setup to help you launch your project quickly and focus on your app logic.

## Prerequisites

- Java 21 or newer  
- Maven 3.9+

## Getting Started

To run the application in development mode:

```bash
mvn jetty:run
```

Then open [http://localhost:8080](http://localhost:8080) in your browser.

This project is preconfigured to use the **Jetty Maven Plugin**, which makes development fast and iterative. It includes automatic scanning for class and resource changes.

### Jetty Auto-Reload (Hot Deployment)

By default, this project enables **Jetty's scan mode** using the following property:

```xml
<jetty.scan>1</jetty.scan>
```

This means Jetty will **poll for changes in compiled classes and resources every second**, allowing the app to **auto-reload** without restarting the server. This is great for quick feedback while developing UI or backend logic.

If you're using a live reload tool (like JRebel or similar), you may want to set this to `0` to disable it.

```xml
<jetty.scan>0</jetty.scan>
```

## Running Integration Tests

To run end-to-end and integration tests:

```bash
mvn verify
```

This command:
- Starts Jetty before tests using the `jetty:start` goal.
- Runs integration tests using the **Failsafe Plugin** (tests ending with `*IT.java`).
- Shuts down Jetty after tests complete.

## Learn More

Explore the webforJ ecosystem through our documentation and examples:

- [Full Documentation](https://docs.webforj.com)
- [Component Overview](https://docs.webforj.com/docs/components/overview)
- [Quick Tutorial](https://docs.webforj.com/docs/introduction/tutorial/overview)
- [Advanced Topics](https://docs.webforj.com/docs/advanced/overview)

## Wrapping Web Components in webforJ: Lessons Learned

This project demonstrates wrapping [Shoelace](https://shoelace.style/) web components for use in webforJ applications. Through implementing 40+ components, we've discovered important patterns and best practices.

### Key Principles

#### 1. Component Structure
Every web component wrapper should:
- Extend `ElementComposite`
- Implement appropriate interfaces (`HasComponents`, `HasStyle<T>`, `HasHtml<T>`)
- Use `PropertyDescriptor` for managing properties
- Include proper annotations for JavaScript and CSS imports

```java
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/badge/badge.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-badge")
public final class Badge extends ElementComposite implements HasComponents, HasHtml<Badge>, HasStyle<Badge> {
  // Component implementation
}
```

#### 2. Property Management
Use `PropertyDescriptor` for all component properties:
```java
private final PropertyDescriptor<String> VARIANT = PropertyDescriptor.property("variant", "primary");
private final PropertyDescriptor<Boolean> PILL = PropertyDescriptor.property("pill", false);

public String getVariant() {
  return get(VARIANT);
}

public Badge setVariant(String variant) {
  set(VARIANT, variant);
  return this;
}
```

#### 3. Import Annotations
- Use `@JavaScript` for component scripts with ES modules
- Use `@StyleSheet` for CSS themes
- Use `@NodeName` to specify the custom element name
- Import paths must be correct - use CDN paths from Shoelace documentation

#### 4. Interface Implementation
Common patterns for interface methods:
```java
@Override
public Badge setHtml(String html) {
  getBoundComponent().setHtml(html);
  return this;
}

@Override
public Badge setStyle(String property, String value) {
  getBoundComponent().setStyle(property, value);
  return this;
}
```

#### 5. Slot Support
For components with slots, use the add method with slot name:
```java
public TabGroup addTab(Tab tab) {
  getBoundComponent().add("nav", tab);  // Adds to 'nav' slot
  return this;
}
```

### Common Pitfalls and Solutions

#### 1. Import Path Issues
**Problem**: Wrong import package for annotations
```java
// ❌ Wrong
import com.webforj.component.element.annotation.JavaScript;

// ✅ Correct
import com.webforj.annotation.JavaScript;
```

#### 2. Generic Type Parameters
**Problem**: HasComponents doesn't take type parameters
```java
// ❌ Wrong
implements HasComponents<Badge>

// ✅ Correct
implements HasComponents
```

#### 3. Event Handling Limitations
**Problem**: webforJ has limited JavaScript interop for events
```java
// ❌ Not available
component.addEventListener("sl-change", listener);

// ✅ Alternative: Use property change listeners or custom implementations
```

#### 4. Method Access
**Problem**: Cannot call JavaScript methods directly
```java
// ❌ Not available
getBoundComponent().callJsMethod("focus");

// ✅ Alternative: Use property-based approaches or document limitations
```

#### 5. CSS File References
**Problem**: Incorrect CSS file paths in view classes
```java
// ❌ Wrong
@InlineStyleSheet("context://css/badge_view.css")

// ✅ Correct
@InlineStyleSheet("context://static/css/badge_view.css")

// ✅ Better: Use FlexLayout without external CSS
public class BadgeView extends Composite<FlexLayout>
```

### View Page Best Practices

#### 1. Consistent Structure
All view pages should follow this pattern:
- Extend `Composite<FlexLayout>`
- Include header with title, description, import code, and documentation link
- Use sections for different examples
- Include code samples with proper formatting
- Add comprehensive properties table

#### 2. Code Example Formatting
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

#### 3. Properties Table
Create structured tables showing all component properties:
```java
private FlexLayout createPropertiesTable() {
  // Create table structure with header and data rows
  // Include Property, Description, Type, and Default columns
}
```

### Testing and Validation

1. **Always compile after changes**: `mvn compile`
2. **Test in development mode**: `mvn jetty:run`
3. **Verify route annotations**: Ensure `outlet = MainLayout.class`
4. **Check component rendering**: Verify custom elements load properly
5. **Validate property binding**: Test that properties update the DOM

### Project Structure

```
src/main/java/com/example/
├── components/          # Web component wrappers
│   ├── Badge.java
│   ├── Button.java
│   └── ...
├── views/              # View pages with examples
│   ├── BadgeView.java
│   ├── ButtonView.java
│   └── ...
└── MainLayout.java     # Main navigation layout
```

### Future Considerations

1. **Event System**: Implement a proper event handling system for web component events
2. **Type Safety**: Consider using enums for string-based properties
3. **Documentation**: Generate JavaDoc from Shoelace documentation
4. **Testing**: Add unit tests for property management
5. **Performance**: Consider lazy loading for heavy components# Shoelace4webforJ
