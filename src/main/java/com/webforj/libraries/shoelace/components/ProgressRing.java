package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;

/**
 * Progress Ring component for showing circular progress
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/progress-ring/progress-ring.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-progress-ring")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class ProgressRing extends ElementComposite implements HasComponents, HasHtml<ProgressRing>, HasStyle<ProgressRing> {
  private final PropertyDescriptor<Integer> VALUE = PropertyDescriptor.property("value", 0);
  private final PropertyDescriptor<String> LABEL = PropertyDescriptor.property("label", "");

  /**
   * Create a new ProgressRing
   */
  public ProgressRing() {
    super();
  }

  /**
   * Create a new ProgressRing with value
   *
   * @param value the progress value (0-100)
   */
  public ProgressRing(int value) {
    super();
    setValue(value);
  }

  /**
   * Create a new ProgressRing with value and label
   *
   * @param value the progress value (0-100)
   * @param label the accessibility label
   */
  public ProgressRing(int value, String label) {
    super();
    setValue(value);
    setLabel(label);
  }

  /**
   * Get the progress value
   *
   * @return the value (0-100)
   */
  public int getValue() {
    return get(VALUE);
  }

  /**
   * Set the progress value
   *
   * @param value the value (0-100)
   */
  public ProgressRing setValue(int value) {
    if (value < 0 || value > 100) {
      throw new IllegalArgumentException("Value must be between 0 and 100");
    }
    set(VALUE, value);
    return this;
  }

  /**
   * Get the accessibility label
   *
   * @return the label
   */
  public String getLabel() {
    return get(LABEL);
  }

  /**
   * Set the accessibility label
   *
   * @param label the label
   */
  public ProgressRing setLabel(String label) {
    set(LABEL, label);
    return this;
  }

  /**
   * Set the ring size
   *
   * @param size the size (e.g., "128px", "10rem")
   */
  public ProgressRing setSize(String size) {
    setStyle("--size", size);
    return this;
  }

  /**
   * Set the track width
   *
   * @param width the track width (e.g., "4px")
   */
  public ProgressRing setTrackWidth(String width) {
    setStyle("--track-width", width);
    return this;
  }

  /**
   * Set the indicator width
   *
   * @param width the indicator width (e.g., "4px")
   */
  public ProgressRing setIndicatorWidth(String width) {
    setStyle("--indicator-width", width);
    return this;
  }

  /**
   * Set the track color
   *
   * @param color the track color
   */
  public ProgressRing setTrackColor(String color) {
    setStyle("--track-color", color);
    return this;
  }

  /**
   * Set the indicator color
   *
   * @param color the indicator color
   */
  public ProgressRing setIndicatorColor(String color) {
    setStyle("--indicator-color", color);
    return this;
  }

  /**
   * Show percentage text inside the ring
   */
  public ProgressRing showPercentage() {
    setHtml(getValue() + "%");
    return this;
  }

  /**
   * Show custom text inside the ring
   *
   * @param text the text to display
   */
  public ProgressRing showText(String text) {
    setHtml(text);
    return this;
  }

  /**
   * Clear the content
   */
  public ProgressRing clearContent() {
    setHtml("");
    return this;
  }

  /**
   * Create a large progress ring with custom styling
   *
   * @param value the progress value
   * @param size the size (e.g., "200px")
   * @param color the indicator color
   */
  public static ProgressRing createLarge(int value, String size, String color) {
    ProgressRing ring = new ProgressRing(value);
    ring.setSize(size)
        .setIndicatorColor(color)
        .showPercentage();
    return ring;
  }
}