package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasStyle;

/**
 * Divider component for visual separation of content
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/divider/divider.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-divider")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Divider extends ElementComposite implements HasStyle<Divider> {
  private final PropertyDescriptor<Boolean> VERTICAL = PropertyDescriptor.property("vertical", false);

  /**
   * Create a new horizontal divider
   */
  public Divider() {
    super();
  }

  /**
   * Create a new divider with specified orientation
   *
   * @param vertical true for vertical divider, false for horizontal
   */
  public Divider(boolean vertical) {
    super();
    setVertical(vertical);
  }

  /**
   * Check if the divider is vertical
   *
   * @return true if vertical, false if horizontal
   */
  public boolean isVertical() {
    return get(VERTICAL);
  }

  /**
   * Set the divider orientation
   *
   * @param vertical true for vertical divider, false for horizontal
   */
  public Divider setVertical(boolean vertical) {
    set(VERTICAL, vertical);
    return this;
  }

  /**
   * Set the divider color
   *
   * @param color the color value (any valid CSS color)
   */
  public Divider setColor(String color) {
    setStyle("--color", color);
    return this;
  }

  /**
   * Set the divider width/thickness
   *
   * @param width the width value (e.g., "2px", "0.5rem")
   */
  public Divider setWidth(String width) {
    setStyle("--width", width);
    return this;
  }

  /**
   * Set the divider spacing (margin around it)
   *
   * @param spacing the spacing value (e.g., "1rem", "20px")
   */
  public Divider setSpacing(String spacing) {
    setStyle("--spacing", spacing);
    return this;
  }
}