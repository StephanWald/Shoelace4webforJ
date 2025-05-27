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
 * Option component for use within select and other form controls
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/option/option.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-option")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Option extends ElementComposite implements HasComponents, HasHtml<Option>, HasStyle<Option> {
  private final PropertyDescriptor<String> VALUE = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Boolean> DISABLED = PropertyDescriptor.property("disabled", false);

  /**
   * Create a new Option
   */
  public Option() {
    super();
  }

  /**
   * Create a new Option with text
   *
   * @param text the option text
   */
  public Option(String text) {
    super();
    setText(text);
  }

  /**
   * Create a new Option with text and value
   *
   * @param text the option text
   * @param value the option value
   */
  public Option(String text, String value) {
    super();
    setText(text);
    setValue(value);
  }

  /**
   * Get the option value
   *
   * @return the value
   */
  public String getValue() {
    return get(VALUE);
  }

  /**
   * Set the option value
   *
   * @param value the value
   */
  public Option setValue(String value) {
    set(VALUE, value);
    return this;
  }

  /**
   * Check if the option is disabled
   *
   * @return true if disabled
   */
  public boolean isDisabled() {
    return get(DISABLED);
  }

  /**
   * Set the disabled state
   *
   * @param disabled true to disable
   */
  public Option setDisabled(boolean disabled) {
    set(DISABLED, disabled);
    return this;
  }

  /**
   * Set the option text
   *
   * @param text the text to display
   */
  public Option setText(String text) {
    setHtml(text);
    return this;
  }

  /**
   * Set the prefix slot content
   *
   * @param prefix the prefix component
   */
  public Option setPrefix(com.webforj.component.Component prefix) {
    getBoundComponent().add("prefix", prefix);
    return this;
  }

  /**
   * Set the suffix slot content
   *
   * @param suffix the suffix component
   */
  public Option setSuffix(com.webforj.component.Component suffix) {
    getBoundComponent().add("suffix", suffix);
    return this;
  }

  /**
   * Get the text label of the option
   * Note: This would need JavaScript interop to call getTextLabel()
   *
   * @return the text label
   */
  public String getTextLabel() {
    // Note: Would need JavaScript interop to call the component's getTextLabel() method
    return getHtml();
  }
}