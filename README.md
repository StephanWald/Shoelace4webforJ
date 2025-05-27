# Shoelace Components for webforJ

A comprehensive showcase and implementation of [Shoelace](https://shoelace.style/) web components wrapped for use in [webforJ](https://webforj.com/) applications. This project demonstrates how to integrate modern web components with Java, providing a complete reference implementation with over 40 components.

<div align="center">
  <strong>Built with</strong><br>
  <a href="https://shoelace.style/">Shoelace</a> - A forward-thinking library of web components<br>
  <a href="https://webforj.com/">webforJ</a> - Modern Java framework for web applications
</div>

## What is this?

This application serves as both a **component library** and a **living showcase** of Shoelace web components integrated with webforJ. Each component is:
- Fully wrapped as a Java class extending `ElementComposite`
- Demonstrated with interactive examples and code samples
- Documented with properties, methods, and events
- Styled consistently following Material Design principles

## What can you learn?

### 1. **Web Component Integration Patterns**
Learn how to wrap any web component for use in Java applications:
```java
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/button/button.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-button")
public class ShoelaceButton extends ElementComposite implements HasComponents {
  // Component implementation
}
```

### 2. **Event Bridging Between JavaScript and Java**
Understand how to expose JavaScript events to Java developers:
```java
@EventName("sl-show")
@EventOptions(data = {@EventData(key = "detail", exp = "event.detail")})
public class ShowEvent extends ComponentEvent<Dialog> {
  public ShowEvent(Dialog component, Map<String, Object> detail) {
    super(component, detail);
  }
}
```

### 3. **Property Management with Type Safety**
Master the PropertyDescriptor pattern for managing component state:
```java
private final PropertyDescriptor<String> variantProp = PropertyDescriptor.property("variant", "primary");
private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);
```

### 4. **Modern UI Component Patterns**
Explore implementations of:
- **Form Controls**: Input, Select, Checkbox, Radio, Switch, Range
- **Feedback**: Alert, Toast, Spinner, Skeleton, Progress indicators
- **Layout**: Card, Drawer, Dialog, Split Panel, Tab Group
- **Navigation**: Breadcrumb, Menu, Tree
- **Data Display**: Badge, Tag, Avatar, Tooltip
- **Media**: Image Comparer, Animated Image, QR Code
- **Advanced**: Animation, Carousel, Color Picker

### 5. **Best Practices for Component Libraries**
- Consistent API design across components
- Comprehensive JavaDoc with examples
- Interactive demos with real-time feedback
- Event handling patterns
- Slot management for content projection
- CSS-in-JS styling approaches

## Getting Started

### Prerequisites
- Java 21 or newer
- Maven 3.9+

### Running the Application
```bash
mvn jetty:run
```
Then open [http://localhost:8080](http://localhost:8080) in your browser.

### Building for Production
```bash
mvn clean package -Pprod
```

## Project Structure

```
src/main/java/com/webforj/libraries/shoelace/
├── components/              # Shoelace component wrappers
│   ├── Alert.java
│   ├── Dialog.java
│   ├── events/             # Event classes for each component
│   │   ├── AlertEvent.java
│   │   └── DialogEvent.java
│   └── ...
└── sample/                 # Showcase application
    ├── views/              # Component demonstration views
    │   ├── AlertView.java
    │   ├── DialogView.java
    │   └── ...
    ├── MainLayout.java     # Navigation and layout
    └── App.java           # Application entry point
```

## Key Features

### 🎨 **Comprehensive Component Coverage**
Every Shoelace component is implemented with full property support, proper typing, and Java-friendly APIs.

### 📚 **Interactive Documentation**
Each component view includes:
- Live examples with different configurations
- Interactive demos with real-time event feedback
- Code samples ready to copy and use
- Complete property reference tables
- Links to JavaDoc and Shoelace documentation

### 🔌 **Event System**
Components that emit events include proper event classes and registration methods:
```java
dialog.onShow(event -> {
    // Handle show event
});
dialog.onHide(event -> {
    // Handle hide event
});
```

### 🎯 **Type Safety**
Enums for variants, proper null handling, and compile-time type checking:
```java
button.setVariant(ButtonVariant.PRIMARY);
alert.setVariant(AlertVariant.SUCCESS);
```

### 🎭 **Consistent Styling**
All views follow a consistent structure with:
- Clear section headers
- Styled code blocks
- Responsive layouts
- Accessible color choices
- Professional typography

## Learning Path

1. **Start with Basic Components**: Begin with Button, Input, and Alert to understand the wrapper pattern
2. **Explore Form Controls**: Learn about validation, events, and two-way binding
3. **Study Layout Components**: Understand slots and content projection with Card, Dialog, and Drawer
4. **Advanced Components**: Dive into Animation, Tree, and other complex components
5. **Event Handling**: Learn the event bridging system through interactive examples

## Technical Highlights

- **Zero JavaScript Required**: Write everything in Java while leveraging modern web components
- **Lazy Loading**: Components and their dependencies load on demand
- **Reactive Properties**: Changes to Java properties automatically update the DOM
- **Custom Elements**: Full support for web component lifecycle and shadow DOM
- **CDN Integration**: Components load from Shoelace's CDN with proper versioning

## Resources

- [webforJ Documentation](https://docs.webforj.com)
- [Shoelace Documentation](https://shoelace.style)
- [Component JavaDoc](/static/javadoc/index.html)
- [GitHub Repository](https://github.com/webforj/webforj-shoelace)

## Contributing

This project demonstrates best practices for wrapping web components in webforJ. Contributions that improve the patterns, add missing features, or enhance the documentation are welcome!

## Credits & Acknowledgments

This project is made possible by:

- **[Shoelace](https://shoelace.style/)** - Created by [Cory LaViska](https://twitter.com/claviska) and the Shoelace community
  - A forward-thinking library of web components built on web standards
  - Designed to work with any framework or no framework at all
  - Beautiful, accessible, and customizable components
  - [GitHub](https://github.com/shoelace-style/shoelace) | [Documentation](https://shoelace.style/) | [Discord](https://discord.gg/mg8f26C)

- **[webforJ](https://webforj.com/)** - A modern Java framework for building web applications
  - Seamless integration of Java with web technologies
  - Component-based architecture
  - Powerful development tools and debugging capabilities
  - [GitHub](https://github.com/webforj/webforj) | [Documentation](https://docs.webforj.com/)

## License

This showcase application is provided as a reference implementation for the webforJ community.

---

<div align="center">
  Made with ❤️ by the webforJ community<br>
  <a href="https://webforj.com/">webforJ.com</a> | <a href="https://shoelace.style/">shoelace.style</a>
</div>