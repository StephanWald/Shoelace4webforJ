package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasHtml;

/**
 * Skeleton component for displaying loading states
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/skeleton/skeleton.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-skeleton")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Skeleton extends ElementComposite implements HasComponents, HasStyle<Skeleton>, HasHtml<Skeleton> {
  private final PropertyDescriptor<String> EFFECT = PropertyDescriptor.property("effect", "none");

  /**
   * Skeleton animation effects
   */
  public enum Effect {
    NONE("none"),
    PULSE("pulse"),
    SHEEN("sheen");

    private final String value;

    Effect(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new Skeleton
   */
  public Skeleton() {
    super();
  }

  /**
   * Get the animation effect
   *
   * @return the effect
   */
  public String getEffect() {
    return get(EFFECT);
  }

  /**
   * Set the animation effect
   *
   * @param effect the effect
   * @return this instance
   */
  public Skeleton setEffect(Effect effect) {
    set(EFFECT, effect.getValue());
    return this;
  }

  /**
   * Set the animation effect
   *
   * @param effect the effect value
   * @return this instance
   */
  public Skeleton setEffect(String effect) {
    set(EFFECT, effect);
    return this;
  }

  /**
   * Set custom dimensions
   *
   * @param width the width
   * @param height the height
   * @return this instance
   */
  public Skeleton setDimensions(String width, String height) {
    if (width != null) {
      setStyle("width", width);
    }
    if (height != null) {
      setStyle("height", height);
    }
    return this;
  }

  /**
   * Set the border radius
   *
   * @param borderRadius the border radius
   * @return this instance
   */
  public Skeleton setBorderRadius(String borderRadius) {
    setStyle("--border-radius", borderRadius);
    return this;
  }

  /**
   * Set the skeleton color
   *
   * @param color the color
   * @return this instance
   */
  public Skeleton setColor(String color) {
    setStyle("--color", color);
    return this;
  }

  /**
   * Set the sheen color
   *
   * @param sheenColor the sheen color
   * @return this instance
   */
  public Skeleton setSheenColor(String sheenColor) {
    setStyle("--sheen-color", sheenColor);
    return this;
  }

  /**
   * Create a text skeleton
   *
   * @param width the width
   * @return a new skeleton instance
   */
  public static Skeleton text(String width) {
    Skeleton skeleton = new Skeleton();
    skeleton.setDimensions(width, "1em");
    skeleton.setBorderRadius("4px");
    return skeleton;
  }

  /**
   * Create a circle skeleton
   *
   * @param size the diameter
   * @return a new skeleton instance
   */
  public static Skeleton circle(String size) {
    Skeleton skeleton = new Skeleton();
    skeleton.setDimensions(size, size);
    skeleton.setBorderRadius("50%");
    return skeleton;
  }

  /**
   * Create a square skeleton
   *
   * @param size the size
   * @return a new skeleton instance
   */
  public static Skeleton square(String size) {
    Skeleton skeleton = new Skeleton();
    skeleton.setDimensions(size, size);
    return skeleton;
  }

  /**
   * Create a rectangle skeleton
   *
   * @param width the width
   * @param height the height
   * @return a new skeleton instance
   */
  public static Skeleton rectangle(String width, String height) {
    Skeleton skeleton = new Skeleton();
    skeleton.setDimensions(width, height);
    return skeleton;
  }

  /**
   * Create a paragraph skeleton with multiple lines
   *
   * @param lines the number of lines
   * @return a new skeleton instance
   */
  public static Skeleton paragraph(int lines) {
    Skeleton skeleton = new Skeleton();
    skeleton.setStyle("display", "block");
    skeleton.setDimensions("100%", "auto");
    
    // For now, just create a simple multi-line effect
    // Full implementation would require adding child components
    
    return skeleton;
  }
}