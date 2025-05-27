package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasHtml;

/**
 * Badge component using Shoelace sl-badge
 *
 * Badges are used to draw attention and display statuses or counts.
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/badge/badge.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-badge")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Badge extends ElementComposite implements HasHtml {
  private final PropertyDescriptor<String> VARIANT = PropertyDescriptor.property("variant", "primary");
  private final PropertyDescriptor<Boolean> PILL = PropertyDescriptor.property("pill", false);
  private final PropertyDescriptor<Boolean> PULSE = PropertyDescriptor.property("pulse", false);

  /**
   * Badge variants
   */
  public enum Variant {
    PRIMARY("primary"),
    SUCCESS("success"),
    NEUTRAL("neutral"),
    WARNING("warning"),
    DANGER("danger");

    private final String value;

    Variant(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new Badge
   */
  public Badge() {
    super();
  }

  /**
   * Create a new Badge with text
   *
   * @param text the text to display in the badge
   */
  public Badge(String text) {
    super();
    this.setHtml(text);
  }

  /**
   * Create a new Badge with text and variant
   *
   * @param text the text to display in the badge
   * @param variant the badge variant
   */
  public Badge(String text, Variant variant) {
    super();
    this.setHtml(text);
    this.setVariant(variant);
  }

  /**
   * Get the variant of the badge
   *
   * @return the variant
   */
  public String getVariant() {
    return get(VARIANT);
  }

  /**
   * Set the variant of the badge
   *
   * @param variant the variant (primary, success, neutral, warning, danger)
   */
  public Badge setVariant(String variant) {
    set(VARIANT, variant);
    return this;
  }

  /**
   * Set the variant of the badge using enum
   *
   * @param variant the variant enum
   */
  public Badge setVariant(Variant variant) {
    set(VARIANT, variant.getValue());
    return this;
  }

  /**
   * Check if the badge has pill style
   *
   * @return true if pill style is enabled
   */
  public boolean isPill() {
    return get(PILL);
  }

  /**
   * Set the pill style
   *
   * @param pill true to enable pill style
   */
  public Badge setPill(boolean pill) {
    set(PILL, pill);
    return this;
  }

  /**
   * Check if the badge has pulse animation
   *
   * @return true if pulse animation is enabled
   */
  public boolean isPulse() {
    return get(PULSE);
  }

  /**
   * Set the pulse animation
   *
   * @param pulse true to enable pulse animation
   */
  public Badge setPulse(boolean pulse) {
    set(PULSE, pulse);
    return this;
  }
}
