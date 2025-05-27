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
 * Shoelace Radio component for selecting one option from a set.
 * 
 * <p>The Radio component allows users to select a single option from a group of choices.
 * Radio buttons should always be used within a RadioGroup for proper management.
 * 
 * <p>Example usage:
 * <pre>{@code
 * RadioGroup group = new RadioGroup("Choose size");
 * Radio small = new Radio("Small", "small");
 * Radio medium = new Radio("Medium", "medium").setChecked(true);
 * Radio large = new Radio("Large", "large");
 * 
 * group.add(small, medium, large);
 * group.onRadioChange(event -> {
 *   System.out.println("Selected: " + event.getSelectedValue());
 * });
 * }</pre>
 * 
 * @see RadioGroup
 * @see RadioButton
 * @see <a href="https://shoelace.style/components/radio">Shoelace Radio Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/radio/radio.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-radio")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Radio extends ElementComposite implements HasComponents, HasHtml<Radio> {
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> checkedProp = PropertyDescriptor.property("checked", false);
  private final PropertyDescriptor<Boolean> requiredProp = PropertyDescriptor.property("required", false);

  /**
   * Radio sizes available for the component.
   */
  public enum Size {
    /** Small size radio button */
    SMALL("small"),
    /** Medium size radio button (default) */
    MEDIUM("medium"),
    /** Large size radio button */
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
   * Create a new Radio component.
   */
  public Radio() {
    super();
  }

  /**
   * Create a new Radio with label.
   *
   * @param label the radio label text
   */
  public Radio(String label) {
    super();
    setHtml(label);
  }

  /**
   * Create a new Radio with label and value.
   *
   * @param label the radio label text
   * @param value the radio value for form submission
   */
  public Radio(String label, String value) {
    super();
    setHtml(label);
    setValue(value);
  }

  /**
   * Get the radio's name attribute.
   * 
   * <p>The name groups radio buttons together. Only one radio button in a group
   * with the same name can be selected at a time.
   *
   * @return the name attribute value
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Set the radio's name attribute to group radios together.
   * 
   * <p>Radio buttons with the same name form a radio group where only
   * one can be selected at a time.
   *
   * @param name the name attribute value
   * @return this instance for method chaining
   */
  public Radio setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Get the radio's value.
   * 
   * <p>This is the value that will be submitted with the form when this radio is selected.
   *
   * @return the radio value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Set the radio's value.
   * 
   * <p>This value is submitted with the form when the radio is selected.
   *
   * @param value the radio value
   * @return this instance for method chaining
   */
  public Radio setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Get the radio's size.
   *
   * @return the current size value
   */
  public String getSize() {
    return get(sizeProp);
  }

  /**
   * Set the radio's size using the Size enum.
   *
   * @param size the size to set
   * @return this instance for method chaining
   */
  public Radio setSize(Size size) {
    set(sizeProp, size.getValue());
    return this;
  }

  /**
   * Set the radio's size using a custom string value.
   *
   * @param size the size value ("small", "medium", "large")
   * @return this instance for method chaining
   */
  public Radio setSize(String size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Check if the radio is disabled.
   *
   * @return true if the radio is disabled, false otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Set the disabled state of the radio.
   * 
   * <p>Disabled radios cannot be interacted with and are not submitted with forms.
   *
   * @param disabled true to disable the radio, false to enable
   * @return this instance for method chaining
   */
  public Radio setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Check if the radio is checked.
   *
   * @return true if the radio is checked, false otherwise
   */
  public boolean isChecked() {
    return get(checkedProp);
  }

  /**
   * Set the checked state of the radio.
   * 
   * <p>Only one radio in a group can be checked at a time.
   *
   * @param checked true to check the radio, false to uncheck
   * @return this instance for method chaining
   */
  public Radio setChecked(boolean checked) {
    set(checkedProp, checked);
    return this;
  }

  /**
   * Check if the radio is required.
   *
   * @return true if the radio is required, false otherwise
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Set whether the radio is required for form submission.
   *
   * @param required true to make required, false otherwise
   * @return this instance for method chaining
   */
  public Radio setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Focus the radio programmatically.
   */
  public void focus() {
    // Note: Would need JavaScript interop
  }

  /**
   * Remove focus from the radio programmatically.
   */
  public void blur() {
    // Note: Would need JavaScript interop
  }

  /**
   * Add a listener for the blur event.
   * 
   * <p>Fired when the radio loses focus.
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
   * <p>Fired when the radio's checked state changes.
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
   * <p>Fired when the radio gains focus.
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
   * <p>Fired when the radio value changes (before blur).
   *
   * @param listener the input event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InputEvent> onInput(EventListener<InputEvent> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Blur event fired when the radio loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<Radio> {
    public BlurEvent(Radio component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Change event fired when the radio's checked state changes.
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "checked", exp = "event.target.checked"),
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class ChangeEvent extends ComponentEvent<Radio> {
    public ChangeEvent(Radio component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get whether the radio is now checked.
     *
     * @return true if checked, false otherwise
     */
    public boolean isChecked() {
      return (boolean) getEventMap().getOrDefault("checked", false);
    }

    /**
     * Get the value of the radio.
     *
     * @return the radio value
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
  }

  /**
   * Focus event fired when the radio gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<Radio> {
    public FocusEvent(Radio component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Input event fired when the radio value changes.
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "checked", exp = "event.target.checked"),
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class InputEvent extends ComponentEvent<Radio> {
    public InputEvent(Radio component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get whether the radio is checked.
     *
     * @return true if checked, false otherwise
     */
    public boolean isChecked() {
      return (boolean) getEventMap().getOrDefault("checked", false);
    }

    /**
     * Get the value of the radio.
     *
     * @return the radio value
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