# webforJ Development Guide for MCP Servers

This guide provides essential information for MCP (Model Context Protocol) servers assisting with webforJ development, particularly when wrapping web components.

## Overview

webforJ is a Java framework for building web applications. This project demonstrates wrapping Shoelace web components for use in webforJ applications. The patterns and practices here apply to wrapping any web component library.

## Critical Knowledge

### 1. Component Architecture

All web component wrappers MUST follow this structure:

```java
package com.example.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;

@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/[component]/[component].js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-[component]")
public final class ComponentName extends ElementComposite implements HasComponents, HasHtml<ComponentName>, HasStyle<ComponentName> {
  // Implementation
}
```

### 2. Import Requirements

**CRITICAL**: Import paths are frequently wrong. Always use:
- `com.webforj.annotation.*` for @JavaScript, @StyleSheet, @Attribute
- `com.webforj.component.element.annotation.NodeName` for @NodeName
- NOT `com.webforj.component.element.annotation.*` for JavaScript/StyleSheet

### 3. Interface Rules

- `HasComponents` - NO type parameters (not `HasComponents<T>`)
- `HasHtml<T>` - Requires type parameter
- `HasStyle<T>` - Requires type parameter
- Always implement all three for maximum flexibility

### 4. Property Management Pattern

```java
private final PropertyDescriptor<String> PROPERTY_NAME = PropertyDescriptor.property("property-name", "default");

public String getPropertyName() {
  return get(PROPERTY_NAME);
}

public ComponentName setPropertyName(String value) {
  set(PROPERTY_NAME, value);
  return this;
}
```

### 5. View Page Structure

All view pages MUST:
1. Extend `Composite<FlexLayout>` (NOT `Composite<Div>`)
2. Use `@Route(outlet = MainLayout.class)` (NOT just `@Route`)
3. Remove any `@InlineStyleSheet` annotations
4. Follow this structure:

```java
@Route(outlet = MainLayout.class)
@FrameTitle("Component Name")
public class ComponentView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public ComponentView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");
    
    // Add sections
    self.add(
      createHeader(),
      createExampleSection(),
      createPropertiesTable()
    );
  }
}
```

## Common Errors and Solutions

### Error: Cannot find symbol - JavaScript/StyleSheet
**Cause**: Wrong import package
**Solution**: Use `com.webforj.annotation.*`

### Error: HasComponents does not take parameters
**Cause**: Using `HasComponents<T>`
**Solution**: Use `HasComponents` without type parameter

### Error: Cannot find symbol - FlexJustify
**Cause**: Class doesn't exist
**Solution**: Use `FlexJustifyContent` with constants CENTER, END

### Error: method add in interface HasComponents cannot be applied
**Cause**: Trying to use slot syntax incorrectly
**Solution**: For slots, use: `getBoundComponent().add("slotname", component)`

### Error: Cannot resolve method 'addEventListener'
**Cause**: webforJ has limited JavaScript interop
**Solution**: Document as limitation or implement alternative approach

### Error: Resource not found: css/component_view.css
**Cause**: Wrong CSS path or using CSS when not needed
**Solution**: Remove @InlineStyleSheet and use FlexLayout styling

## Property Types

Map JavaScript property types to Java:
- `string` → `String`
- `boolean` → `Boolean` 
- `number` → `Integer` or `Double`
- `'value1' | 'value2'` → `String` (consider enum)
- Arrays → Not directly supported, document limitation

## Slot Support

For components with named slots:
```java
public ComponentName addToSlot(String slotName, Component component) {
  getBoundComponent().add(slotName, component);
  return this;
}
```

## Event Handling

webforJ has LIMITED event support. Avoid:
- `addEventListener` methods
- `callJsMethod` for invoking JavaScript methods
- Direct event listener registration

Instead:
- Use property-based state management
- Document limitations in comments
- Consider alternative UI patterns

## CSS and Styling

1. Components use inline FlexLayout styling
2. NO external CSS files for view pages
3. Code blocks use this exact styling:

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

## Testing Commands

Always run these commands after changes:
1. `mvn compile` - Check for compilation errors
2. `mvn jetty:run` - Test in browser at http://localhost:8080

## File Locations

- Components: `/src/main/java/com/example/components/`
- Views: `/src/main/java/com/example/views/`
- Static resources: `/src/main/resources/static/`

## Navigation Menu

Add new components to MainLayout:
```java
appNav.addItem(new AppNavItem("Component Name", ComponentView.class, TablerIcon.create("icon-name")));
```

## Documentation Requirements

Every view MUST include:
1. Header with component description
2. Import code example
3. Link to Shoelace documentation
4. Multiple usage examples with code
5. Properties table with columns: Property, Description, Type, Default

## FlexLayout Constants

Available FlexJustifyContent values:
- `CENTER`
- `END`

NOT available:
- `SPACE_BETWEEN`
- `SPACE_AROUND`
- `START`

## Method Implementation Pattern

For HasHtml interface:
```java
@Override
public ComponentName setHtml(String html) {
  getBoundComponent().setHtml(html);
  return this;
}

@Override
public String getHtml() {
  return getBoundComponent().getHtml();
}
```

For HasStyle interface:
```java
@Override
public ComponentName setStyle(String property, String value) {
  getBoundComponent().setStyle(property, value);
  return this;
}
```

## Quick Checklist

When creating a new component:
- [ ] Correct imports (com.webforj.annotation.*)
- [ ] Extends ElementComposite
- [ ] Implements HasComponents (no type param)
- [ ] Has @JavaScript, @StyleSheet, @NodeName annotations
- [ ] Uses PropertyDescriptor for all properties
- [ ] View extends Composite<FlexLayout>
- [ ] View has @Route(outlet = MainLayout.class)
- [ ] View includes header, examples, and properties table
- [ ] Added to MainLayout navigation
- [ ] Compiles successfully
- [ ] No external CSS files

## Common Component Properties

Most Shoelace components have these:
- `variant` - Visual style variant
- `size` - Component size
- `disabled` - Disabled state
- `label` - Accessible label
- `name` - Form field name
- `value` - Component value

## Remember

1. ALWAYS check import statements first when debugging
2. webforJ has LIMITED JavaScript interop - don't promise what can't be delivered
3. FlexLayout is preferred over external CSS
4. Route annotations MUST include outlet for navigation to work
5. Compile frequently to catch errors early