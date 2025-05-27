package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;

/**
 * Breadcrumbs provide a group of links so users can easily navigate a website's hierarchy.
 * 
 * @see <a href="https://shoelace.style/components/breadcrumb">Shoelace Breadcrumb Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/breadcrumb/breadcrumb.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-breadcrumb")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class Breadcrumb extends ElementComposite implements HasStyle<Breadcrumb>, HasComponents {
  
  // Properties
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "Breadcrumb");
  
  public Breadcrumb() {
    super();
  }
  
  /**
   * Adds breadcrumb items.
   */
  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
  
  /**
   * Adds a breadcrumb item.
   */
  public Breadcrumb addItem(BreadcrumbItem item) {
    add(item);
    return this;
  }
  
  /**
   * Adds a breadcrumb item with text and optional href.
   */
  public Breadcrumb addItem(String text, String href) {
    BreadcrumbItem item = new BreadcrumbItem(text);
    if (href != null && !href.isEmpty()) {
      item.setHref(href);
    }
    return addItem(item);
  }
  
  /**
   * Adds a breadcrumb item with just text (no link).
   */
  public Breadcrumb addItem(String text) {
    return addItem(text, null);
  }
  
  /**
   * Sets the accessible label for the breadcrumb.
   */
  public Breadcrumb setLabel(String label) {
    set(labelProp, label);
    return this;
  }
  
  /**
   * Gets the accessible label.
   */
  public String getLabel() {
    return get(labelProp);
  }
  
  /**
   * Sets custom separator content.
   */
  public Breadcrumb setSeparator(com.webforj.component.Component separator) {
    getBoundComponent().add("separator", separator);
    return this;
  }
  
  /**
   * Sets custom separator with icon name.
   */
  public Breadcrumb setSeparatorIcon(String iconName) {
    com.webforj.component.html.elements.Div icon = new com.webforj.component.html.elements.Div();
    icon.setHtml("<sl-icon name=\"" + iconName + "\"></sl-icon>");
    return setSeparator(icon);
  }
}