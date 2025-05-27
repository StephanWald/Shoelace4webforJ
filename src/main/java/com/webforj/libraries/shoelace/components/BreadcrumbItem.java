package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;

/**
 * Breadcrumb Item is a child element of breadcrumb.
 * 
 * @see <a href="https://shoelace.style/components/breadcrumb-item">Shoelace Breadcrumb Item Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/breadcrumb-item/breadcrumb-item.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-breadcrumb-item")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class BreadcrumbItem extends ElementComposite implements HasHtml<BreadcrumbItem>, HasStyle<BreadcrumbItem>, HasComponents {
  
  // Properties
  private final PropertyDescriptor<String> hrefProp = PropertyDescriptor.property("href", "");
  private final PropertyDescriptor<String> targetProp = PropertyDescriptor.property("target", "");
  private final PropertyDescriptor<String> relProp = PropertyDescriptor.property("rel", "noreferrer noopener");
  
  public BreadcrumbItem() {
    super();
  }
  
  public BreadcrumbItem(String text) {
    this();
    setHtml(text);
  }
  
  /**
   * Adds content to the breadcrumb item.
   */
  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
  
  /**
   * Sets the href for the breadcrumb link.
   */
  public BreadcrumbItem setHref(String href) {
    set(hrefProp, href);
    return this;
  }
  
  /**
   * Gets the href.
   */
  public String getHref() {
    return get(hrefProp);
  }
  
  /**
   * Sets the target for the link.
   */
  public BreadcrumbItem setTarget(String target) {
    set(targetProp, target);
    return this;
  }
  
  /**
   * Gets the target.
   */
  public String getTarget() {
    return get(targetProp);
  }
  
  /**
   * Sets the rel attribute for the link.
   */
  public BreadcrumbItem setRel(String rel) {
    set(relProp, rel);
    return this;
  }
  
  /**
   * Gets the rel attribute.
   */
  public String getRel() {
    return get(relProp);
  }
  
  /**
   * Sets a prefix icon or element.
   */
  public BreadcrumbItem setPrefix(com.webforj.component.Component prefix) {
    getBoundComponent().add("prefix", prefix);
    return this;
  }
  
  /**
   * Sets a suffix icon or element.
   */
  public BreadcrumbItem setSuffix(com.webforj.component.Component suffix) {
    getBoundComponent().add("suffix", suffix);
    return this;
  }
  
  /**
   * Sets prefix with icon name.
   */
  public BreadcrumbItem setPrefixIcon(String iconName) {
    com.webforj.component.html.elements.Div icon = new com.webforj.component.html.elements.Div();
    icon.setHtml("<sl-icon name=\"" + iconName + "\"></sl-icon>");
    return setPrefix(icon);
  }
}