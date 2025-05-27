package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.event.ComponentEvent;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Shoelace Radio Button component - a button-styled radio for selecting one option from a set.
 * 
 * <p>Radio buttons provide an alternative visual presentation to regular radio inputs,
 * appearing as buttons that can be toggled. Like regular radios, only one radio button
 * in a group can be selected at a time.
 * 
 * <p>Example usage:
 * <pre>{@code
 * RadioGroup group = new RadioGroup("Choose plan");
 * RadioButton basic = new RadioButton("Basic", "basic");
 * RadioButton pro = new RadioButton("Pro", "pro").setPill(true);
 * RadioButton enterprise = new RadioButton("Enterprise", "enterprise");
 * 
 * group.add(basic, pro, enterprise);
 * group.onRadioChange(event -> {
 *   System.out.println("Selected plan: " + event.getSelectedValue());
 * });
 * }</pre>
 * 
 * @see Radio
 * @see RadioGroup
 * @see <a href="https://shoelace.style/components/radio-button">Shoelace Radio Button Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/radio-button/radio-button.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-radio-button")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class RadioButton extends ElementComposite implements HasComponents, HasHtml<RadioButton> {
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> checkedProp = PropertyDescriptor.property("checked", false);
  private final PropertyDescriptor<Boolean> pillProp = PropertyDescriptor.property("pill", false);

  /**
   * Radio button sizes
   */
  public enum Size {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String value;

    Size(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new RadioButton
   */
  public RadioButton() {
    super();
  }

  /**
   * Create a new RadioButton with label
   *
   * @param label the radio button label
   */
  public RadioButton(String label) {
    super();
    setHtml(label);
  }

  /**
   * Create a new RadioButton with label and value
   *
   * @param label the radio button label
   * @param value the radio button value
   */
  public RadioButton(String label, String value) {
    super();
    setHtml(label);
    setValue(value);
  }

  /**
   * Get the radio button's name attribute.
   *
   * @return the name attribute value
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Set the radio button's name attribute.
   *
   * @param name the name attribute value
   * @return this instance for method chaining
   */
  public RadioButton setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Get the radio button's value.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Set the radio button's value.
   *
   * @param value the value
   * @return this instance for method chaining
   */
  public RadioButton setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Get the radio button's size.
   *
   * @return the size
   */
  public String getSize() {
    return get(sizeProp);
  }

  /**
   * Set the radio button's size.
   *
   * @param size the size
   * @return this instance for method chaining
   */
  public RadioButton setSize(Size size) {
    set(sizeProp, size.getValue());
    return this;
  }

  /**
   * Set the radio button's size.
   *
   * @param size the size value
   * @return this instance for method chaining
   */
  public RadioButton setSize(String size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Check if the radio button is disabled.
   *
   * @return true if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Set the disabled state.
   *
   * @param disabled true to disable
   * @return this instance for method chaining
   */
  public RadioButton setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Check if the radio button is checked.
   *
   * @return true if checked
   */
  public boolean isChecked() {
    return get(checkedProp);
  }

  /**
   * Set the checked state.
   *
   * @param checked true to check
   * @return this instance for method chaining
   */
  public RadioButton setChecked(boolean checked) {
    set(checkedProp, checked);
    return this;
  }

  /**
   * Check if the radio button has pill style.
   *
   * @return true if pill
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Set the pill style.
   *
   * @param pill true for pill style
   * @return this instance for method chaining
   */
  public RadioButton setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Set the prefix slot content
   *
   * @param prefix the prefix component
   * @return this instance
   */
  public RadioButton setPrefix(com.webforj.component.Component prefix) {
    getBoundComponent().add("prefix", prefix);
    return this;
  }

  /**
   * Set the suffix slot content
   *
   * @param suffix the suffix component
   * @return this instance
   */
  public RadioButton setSuffix(com.webforj.component.Component suffix) {
    getBoundComponent().add("suffix", suffix);
    return this;
  }

  /**
   * Focus the radio button.
   */
  public void focus() {
    // Note: Would need JavaScript interop
  }

  /**
   * Blur the radio button.
   */
  public void blur() {
    // Note: Would need JavaScript interop
  }

  /**
   * Add a listener for the blur event.
   *
   * @param listener the blur event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<BlurEvent> onBlur(EventListener<BlurEvent> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Add a listener for the change event.
   *
   * @param listener the change event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<ChangeEvent> onChange(EventListener<ChangeEvent> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Add a listener for the focus event.
   *
   * @param listener the focus event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<FocusEvent> onFocus(EventListener<FocusEvent> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Add a listener for the input event.
   *
   * @param listener the input event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InputEvent> onInput(EventListener<InputEvent> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Blur event fired when the radio button loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<RadioButton> {
    public BlurEvent(RadioButton component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Change event fired when the radio button's checked state changes.
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "checked", exp = "event.target.checked"),
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class ChangeEvent extends ComponentEvent<RadioButton> {
    public ChangeEvent(RadioButton component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get whether the radio button is now checked.
     *
     * @return true if checked, false otherwise
     */
    public boolean isChecked() {
      return (boolean) getEventMap().getOrDefault("checked", false);
    }

    /**
     * Get the value of the radio button.
     *
     * @return the radio button value
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
  }

  /**
   * Focus event fired when the radio button gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<RadioButton> {
    public FocusEvent(RadioButton component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Input event fired when the radio button value changes.
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "checked", exp = "event.target.checked"),
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class InputEvent extends ComponentEvent<RadioButton> {
    public InputEvent(RadioButton component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get whether the radio button is checked.
     *
     * @return true if checked, false otherwise
     */
    public boolean isChecked() {
      return (boolean) getEventMap().getOrDefault("checked", false);
    }

    /**
     * Get the value of the radio button.
     *
     * @return the radio button value
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
  }

  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
}