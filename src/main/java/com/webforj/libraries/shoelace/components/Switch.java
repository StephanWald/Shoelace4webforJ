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
import com.webforj.concern.HasHtml;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Shoelace Switch component for toggling between on/off states.
 *
 * <p>Switches allow users to toggle an option on or off. They're similar to checkboxes
 * but are designed for instant actions rather than form submission.
 * 
 * <p>Example usage:
 * <pre>{@code
 * Switch darkMode = new Switch("Dark mode");
 * darkMode.setChecked(false);
 * darkMode.setHelpText("Toggle dark mode theme");
 * 
 * darkMode.onChange(event -> {
 *   boolean enabled = event.isChecked();
 *   System.out.println("Dark mode: " + (enabled ? "ON" : "OFF"));
 * });
 * }</pre>
 * 
 * @see Checkbox
 * @see <a href="https://shoelace.style/components/switch">Shoelace Switch Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/switch/switch.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-switch")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Switch extends ElementComposite implements HasHtml<Switch> {
  private final PropertyDescriptor<Boolean> checkedProp = PropertyDescriptor.property("checked", false);
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<String> helpTextProp = PropertyDescriptor.property("help-text", "");
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "on");
  private final PropertyDescriptor<Boolean> requiredProp = PropertyDescriptor.property("required", false);

  /**
   * Switch sizes available for the component.
   */
  public enum Size {
    /** Small size switch */
    SMALL("small"),
    /** Medium size switch (default) */
    MEDIUM("medium"),
    /** Large size switch */
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
   * Create a new Switch component.
   */
  public Switch() {
    super();
  }

  /**
   * Create a new Switch with label.
   *
   * @param label the label text displayed next to the switch
   */
  public Switch(String label) {
    super();
    this.setHtml(label);
  }

  /**
   * Create a new Switch with label and initial state.
   *
   * @param label the label text
   * @param checked the initial checked state
   */
  public Switch(String label, boolean checked) {
    super();
    this.setHtml(label);
    this.setChecked(checked);
  }

  /**
   * Check if the switch is checked.
   *
   * @return true if checked (on), false if unchecked (off)
   */
  public boolean isChecked() {
    return get(checkedProp);
  }

  /**
   * Set the checked state.
   *
   * @param checked true to turn on, false to turn off
   * @return this instance for method chaining
   */
  public Switch setChecked(boolean checked) {
    set(checkedProp, checked);
    return this;
  }

  /**
   * Check if the switch is disabled.
   *
   * @return true if disabled, false otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Set the disabled state.
   *
   * @param disabled true to disable, false to enable
   * @return this instance for method chaining
   */
  public Switch setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Get the size of the switch.
   *
   * @return the current size value
   */
  public String getSize() {
    return get(sizeProp);
  }

  /**
   * Set the size of the switch.
   *
   * @param size the size value ("small", "medium", "large")
   * @return this instance for method chaining
   */
  public Switch setSize(String size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Set the size of the switch using the Size enum.
   *
   * @param size the size to set
   * @return this instance for method chaining
   */
  public Switch setSize(Size size) {
    set(sizeProp, size.getValue());
    return this;
  }

  /**
   * Get the help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Set the help text displayed below the switch.
   *
   * @param helpText the help text
   * @return this instance for method chaining
   */
  public Switch setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Get the form field name.
   *
   * @return the name attribute
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Set the form field name.
   *
   * @param name the name attribute
   * @return this instance for method chaining
   */
  public Switch setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Get the value submitted when checked.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Set the value submitted when checked.
   *
   * @param value the value (default is "on")
   * @return this instance for method chaining
   */
  public Switch setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Check if the switch is required.
   *
   * @return true if required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Set whether the switch is required for form submission.
   *
   * @param required true to make required
   * @return this instance for method chaining
   */
  public Switch setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Focus the switch programmatically.
   */
  public void focus() {
    // Note: Would need JavaScript interop
  }

  /**
   * Remove focus from the switch programmatically.
   */
  public void blur() {
    // Note: Would need JavaScript interop
  }

  /**
   * Add a listener for the blur event.
   * 
   * <p>Fired when the switch loses focus.
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
   * <p>Fired when the switch's checked state changes.
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
   * <p>Fired when the switch gains focus.
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
   * <p>Fired when the switch value changes (before blur).
   *
   * @param listener the input event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InputEvent> onInput(EventListener<InputEvent> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Add a listener for the invalid event.
   * 
   * <p>Fired when the switch fails validation.
   *
   * @param listener the invalid event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InvalidEvent> onInvalid(EventListener<InvalidEvent> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Blur event fired when the switch loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<Switch> {
    public BlurEvent(Switch component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Change event fired when the switch's checked state changes.
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "checked", exp = "event.target.checked")
  })
  public static class ChangeEvent extends ComponentEvent<Switch> {
    public ChangeEvent(Switch component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get whether the switch is now checked.
     *
     * @return true if checked (on), false if unchecked (off)
     */
    public boolean isChecked() {
      return (boolean) getEventMap().getOrDefault("checked", false);
    }
  }

  /**
   * Focus event fired when the switch gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<Switch> {
    public FocusEvent(Switch component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Input event fired when the switch value changes.
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "checked", exp = "event.target.checked")
  })
  public static class InputEvent extends ComponentEvent<Switch> {
    public InputEvent(Switch component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get whether the switch is checked.
     *
     * @return true if checked (on), false if unchecked (off)
     */
    public boolean isChecked() {
      return (boolean) getEventMap().getOrDefault("checked", false);
    }
  }

  /**
   * Invalid event fired when validation fails.
   */
  @EventName("sl-invalid")
  public static class InvalidEvent extends ComponentEvent<Switch> {
    public InvalidEvent(Switch component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
}
