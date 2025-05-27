# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a webforJ application showcasing Shoelace web components integration. webforJ is a Java framework for building modern web applications. The project uses:
- Java 21+
- Maven 3.9+
- webforJ 25.00
- Jetty 12.0.14 for development server
- Playwright for integration tests
- Shoelace 2.20.1 web components

## Common Development Commands

### Running the Application
```bash
mvn jetty:run
```
Access at http://localhost:8080

### Running Tests
```bash
# Run integration tests (starts Jetty, runs tests, stops Jetty)
mvn verify

# Run a specific test
mvn -Dtest=InboxViewIT test
```

### Build Commands
```bash
# Clean and compile
mvn clean compile

# Package as WAR
mvn package

# Use production profile
mvn package -Pprod

# Format code with Google Java Format
mvn spotless:apply

# Check code formatting
mvn spotless:check
```

## Architecture and Code Structure

### Project Structure
- **Group ID**: `com.webforj.libraries`
- **Artifact ID**: `shoelace`
- **Packaging**: WAR
- **Main package**: `com.webforj.libraries.shoelace`

### Core Components

1. **Shoelace Component Wrappers**: Located in `com.webforj.libraries.shoelace.components`
   - Each Shoelace component is wrapped as an ElementComposite
   - Components use PropertyDescriptor pattern for state management
   - Annotations handle JavaScript/CSS loading and custom element registration

2. **Sample Application**: Located in `com.webforj.libraries.shoelace.sample`
   - Demonstrates usage of wrapped Shoelace components
   - Serves as reference implementation for component integration

3. **Testing Strategy**:
   - Integration tests use Playwright for browser automation
   - Tests follow `*IT.java` naming convention
   - Tests run against the Jetty server on configured port
   - Maven Failsafe plugin handles test lifecycle

### Configuration

- Development vs Production profiles controlled via Maven profiles
- webforj.conf is dynamically selected based on active profile (webforj-dev.conf vs webforj-prod.conf)
- Jetty auto-reload is disabled by default (jetty.scan=0)
- Code formatting enforced via Spotless plugin with Google Java Format

### Maven Properties
```xml
<webforj.version>25.00</webforj.version>
<jetty.version>12.0.14</jetty.version>
<junit.version>5.11.2</junit.version>
<playwright.version>1.49.0</playwright.version>
```

## Shoelace Components Integration

This project showcases Shoelace web components integrated with webforJ. Key patterns:

### Component Wrapper Pattern
```java
package com.example.components;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;

@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/[component]/[component].js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-[component]")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class ComponentName extends ElementComposite implements HasHtml<ComponentName>, HasStyle<ComponentName>, HasComponents {
  
  // Use PropertyDescriptor for component properties
  private final PropertyDescriptor<String> propName = PropertyDescriptor.property("property-name", defaultValue);
  
  public ComponentName() {
    super();
  }
  
  // Override add method if needed for HasComponents
  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
}
```

### Important Notes

1. **@JavaScript annotation**: Always include `attributes = {@Attribute(name = "type", value = "module")}` for ES6 module loading
2. **@NodeName annotation**: Required to specify the custom element name (e.g., "sl-alert", "sl-button")
3. **Interface implementation**: 
   - HasHtml and HasStyle should include generic type parameter
   - HasComponents does NOT take type parameters
4. **Constructor**: Call `super()` without parameters (NodeName annotation handles element creation)

### Slot Management
```java
// Use getBoundComponent().add() for named slots
public ComponentName setHeader(Component header) {
  getBoundComponent().add("header", header);
  return this;
}

// For default content slot, override add method
@Override
public void add(Component... components) {
  getBoundComponent().add(components);
}
```

### Event Handling
```java
// Note: Direct event handling through addEventListener is not currently supported
// in ElementComposite. Use JavaScript interop or handle events at the view level
// For form controls, consider wrapping native webforJ components that have event support

// IMPORTANT: ShoelaceButton does NOT have onClick() method
// Button click handling needs to be implemented through JavaScript interop
// or by using native webforJ Button components with event support
```

### Implemented Components
- Alert: Dismissible notifications with variants
- AnimatedImage: Displays animated GIFs/WEBPs with play/pause controls
- Animation: Declarative animations with nearly 100 presets
- Avatar: User/entity representation with image/icon/initials
- Badge: Status indicators and labels
- Breadcrumb/BreadcrumbItem: Hierarchical navigation with customizable separators
- ButtonGroup: Groups buttons together
- Card: Content containers with header/footer/image slots
- Carousel/CarouselItem: Image/content slider with navigation
- Checkbox: Form control with indeterminate state support
- ColorPicker: Color selection with multiple formats
- CopyButton: One-click copy to clipboard functionality
- Details: Expandable/collapsible content sections
- Dialog: Modal overlays for alerts and forms
- Divider: Visual content separator with customizable styles
- Drawer/DrawerHeader: Slide-out panels from screen edges
- Dropdown: Toggleable panels with customizable placement
- Icon: SVG icon renderer with multiple icon libraries
- ImageComparer: Side-by-side image comparison with slider
- Input: Text input field with validation
- Menu/MenuItem/MenuLabel: Dropdown menu system with submenus
- Option: Option element for Select component
- ProgressBar/ProgressRing: Progress indicators
- QRCode: QR code generator with customization
- Radio/RadioButton/RadioGroup: Radio button controls
- Range: Slider input control
- Rating: Star rating component
- Select: Dropdown select control
- ShoelaceButton: Button component (note: no direct onClick support)
- Skeleton: Loading placeholder animations
- Spinner: Loading spinner indicator
- SplitPanel: Resizable split panel layout
- Switch: Toggle switches with sizes and states
- Tab/TabGroup/TabPanel: Tabbed interface components
- Tag: Label/tag elements
- Textarea: Multi-line text input
- Tooltip: Hover tooltips
- Tree/TreeItem: Hierarchical tree view

### Common Property Patterns
```java
// Boolean properties
private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);

// String properties with default values
private final PropertyDescriptor<String> variantProp = PropertyDescriptor.property("variant", "primary");

// Nullable properties (e.g., for optional values)
private final PropertyDescriptor<Integer> durationProp = PropertyDescriptor.property("duration", null);

// Enum-based properties
public enum Variant {
  PRIMARY("primary"),
  SUCCESS("success");
  
  private final String value;
  Variant(String value) { this.value = value; }
  public String getValue() { return value; }
}

// Property getter/setter pattern
public ComponentName setVariant(Variant variant) {
  set(variantProp, variant.getValue());
  return this;
}

public String getVariant() {
  return get(variantProp);
}