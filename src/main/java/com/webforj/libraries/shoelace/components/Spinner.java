package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;

/**
 * Spinner component for indicating loading or processing state
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/spinner/spinner.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-spinner")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Spinner extends ElementComposite implements HasComponents, HasStyle<Spinner> {

  /**
   * Create a new Spinner
   */
  public Spinner() {
    super();
  }

  /**
   * Set the spinner size using font-size
   *
   * @param size the size (e.g., "2rem", "32px")
   * @return this instance
   */
  public Spinner setSize(String size) {
    setStyle("font-size", size);
    return this;
  }

  /**
   * Set the track width
   *
   * @param width the track width
   * @return this instance
   */
  public Spinner setTrackWidth(String width) {
    setStyle("--track-width", width);
    return this;
  }

  /**
   * Set the track color
   *
   * @param color the track color
   * @return this instance
   */
  public Spinner setTrackColor(String color) {
    setStyle("--track-color", color);
    return this;
  }

  /**
   * Set the indicator color
   *
   * @param color the indicator color
   * @return this instance
   */
  public Spinner setIndicatorColor(String color) {
    setStyle("--indicator-color", color);
    return this;
  }

  /**
   * Set the animation speed
   *
   * @param speed the speed (e.g., "1s", "500ms")
   * @return this instance
   */
  public Spinner setSpeed(String speed) {
    setStyle("--speed", speed);
    return this;
  }

  /**
   * Create a small spinner
   *
   * @return a new spinner instance
   */
  public static Spinner small() {
    return new Spinner().setSize("1rem");
  }

  /**
   * Create a medium spinner
   *
   * @return a new spinner instance
   */
  public static Spinner medium() {
    return new Spinner().setSize("2rem");
  }

  /**
   * Create a large spinner
   *
   * @return a new spinner instance
   */
  public static Spinner large() {
    return new Spinner().setSize("3rem");
  }

  /**
   * Create a spinner with custom styling
   *
   * @param size the size
   * @param indicatorColor the indicator color
   * @param trackColor the track color
   * @return a new spinner instance
   */
  public static Spinner custom(String size, String indicatorColor, String trackColor) {
    Spinner spinner = new Spinner();
    if (size != null) {
      spinner.setSize(size);
    }
    if (indicatorColor != null) {
      spinner.setIndicatorColor(indicatorColor);
    }
    if (trackColor != null) {
      spinner.setTrackColor(trackColor);
    }
    return spinner;
  }

  /**
   * Create a primary colored spinner
   *
   * @return a new spinner instance
   */
  public static Spinner primary() {
    return new Spinner().setIndicatorColor("var(--sl-color-primary-600)");
  }

  /**
   * Create a success colored spinner
   *
   * @return a new spinner instance
   */
  public static Spinner success() {
    return new Spinner().setIndicatorColor("var(--sl-color-success-600)");
  }

  /**
   * Create a warning colored spinner
   *
   * @return a new spinner instance
   */
  public static Spinner warning() {
    return new Spinner().setIndicatorColor("var(--sl-color-warning-600)");
  }

  /**
   * Create a danger colored spinner
   *
   * @return a new spinner instance
   */
  public static Spinner danger() {
    return new Spinner().setIndicatorColor("var(--sl-color-danger-600)");
  }
}