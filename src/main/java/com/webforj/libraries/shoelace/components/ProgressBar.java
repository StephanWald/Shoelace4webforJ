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
 * Progress Bar component for showing task progress
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/progress-bar/progress-bar.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-progress-bar")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class ProgressBar extends ElementComposite implements HasComponents, HasHtml<ProgressBar>, HasStyle<ProgressBar> {
  private final PropertyDescriptor<Integer> VALUE = PropertyDescriptor.property("value", 0);
  private final PropertyDescriptor<Boolean> INDETERMINATE = PropertyDescriptor.property("indeterminate", false);
  private final PropertyDescriptor<String> LABEL = PropertyDescriptor.property("label", "");

  /**
   * Create a new ProgressBar
   */
  public ProgressBar() {
    super();
  }

  /**
   * Create a new ProgressBar with value
   *
   * @param value the progress value (0-100)
   */
  public ProgressBar(int value) {
    super();
    setValue(value);
  }

  /**
   * Create a new ProgressBar with value and label
   *
   * @param value the progress value (0-100)
   * @param label the accessibility label
   */
  public ProgressBar(int value, String label) {
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
  public ProgressBar setValue(int value) {
    if (value < 0 || value > 100) {
      throw new IllegalArgumentException("Value must be between 0 and 100");
    }
    set(VALUE, value);
    return this;
  }

  /**
   * Check if the progress bar is indeterminate
   *
   * @return true if indeterminate
   */
  public boolean isIndeterminate() {
    return get(INDETERMINATE);
  }

  /**
   * Set the indeterminate state
   *
   * @param indeterminate true for indeterminate progress
   */
  public ProgressBar setIndeterminate(boolean indeterminate) {
    set(INDETERMINATE, indeterminate);
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
  public ProgressBar setLabel(String label) {
    set(LABEL, label);
    return this;
  }

  /**
   * Set custom height
   *
   * @param height the height (e.g., "6px", "1rem")
   */
  public ProgressBar setHeight(String height) {
    setStyle("--height", height);
    return this;
  }

  /**
   * Set the track color
   *
   * @param color the track color
   */
  public ProgressBar setTrackColor(String color) {
    setStyle("--track-color", color);
    return this;
  }

  /**
   * Set the indicator color
   *
   * @param color the indicator color
   */
  public ProgressBar setIndicatorColor(String color) {
    setStyle("--indicator-color", color);
    return this;
  }

  /**
   * Show percentage text inside the progress bar
   */
  public ProgressBar showPercentage() {
    if (!isIndeterminate()) {
      setHtml(getValue() + "%");
    }
    return this;
  }

  /**
   * Clear the content
   */
  public ProgressBar clearContent() {
    setHtml("");
    return this;
  }
}