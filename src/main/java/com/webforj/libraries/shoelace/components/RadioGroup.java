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
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Shoelace Radio Group component for managing a set of related radio buttons.
 * 
 * <p>The RadioGroup component is a container that manages a set of radio buttons,
 * ensuring only one can be selected at a time. It provides a semantic grouping
 * with an optional label and handles the mutual exclusivity of radio selections.
 * 
 * <p>Example usage:
 * <pre>{@code
 * RadioGroup group = new RadioGroup("Select your preferred contact method");
 * group.setName("contact-method");
 * group.setRequired(true);
 * 
 * Radio email = new Radio("Email", "email");
 * Radio phone = new Radio("Phone", "phone");
 * Radio sms = new Radio("SMS", "sms");
 * 
 * group.add(email, phone, sms);
 * 
 * group.onChange(event -> {
 *   System.out.println("Selected: " + event.getValue());
 * });
 * }</pre>
 * 
 * @see Radio
 * @see RadioButton
 * @see <a href="https://shoelace.style/components/radio-group">Shoelace Radio Group Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/radio-group/radio-group.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-radio-group")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class RadioGroup extends ElementComposite implements HasComponents {
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> helpTextProp = PropertyDescriptor.property("help-text", "");
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "option");
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<String> formProp = PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp = PropertyDescriptor.property("required", false);

  /**
   * Radio group sizes available for all child radios.
   */
  public enum Size {
    /** Small size for all radios */
    SMALL("small"),
    /** Medium size for all radios (default) */
    MEDIUM("medium"),
    /** Large size for all radios */
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
   * Create a new RadioGroup.
   */
  public RadioGroup() {
    super();
  }

  /**
   * Create a new RadioGroup with label.
   *
   * @param label the group label text
   */
  public RadioGroup(String label) {
    super();
    setLabel(label);
  }

  /**
   * Get the group label.
   *
   * @return the label text
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Set the group label.
   *
   * @param label the label text
   * @return this instance for method chaining
   */
  public RadioGroup setLabel(String label) {
    set(labelProp, label);
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
   * Set the help text displayed below the group.
   *
   * @param helpText the help text
   * @return this instance for method chaining
   */
  public RadioGroup setHelpText(String helpText) {
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
   * <p>This should match the name attribute of all child radio buttons.
   *
   * @param name the name attribute
   * @return this instance for method chaining
   */
  public RadioGroup setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Get the currently selected value.
   *
   * @return the selected radio value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Set the selected value programmatically.
   *
   * @param value the value to select
   * @return this instance for method chaining
   */
  public RadioGroup setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Get the size for all radios in the group.
   *
   * @return the size value
   */
  public String getSize() {
    return get(sizeProp);
  }

  /**
   * Set the size for all child radios using the Size enum.
   *
   * @param size the size to apply
   * @return this instance for method chaining
   */
  public RadioGroup setSize(Size size) {
    set(sizeProp, size.getValue());
    return this;
  }

  /**
   * Set the size for all child radios using a custom value.
   *
   * @param size the size value ("small", "medium", "large")
   * @return this instance for method chaining
   */
  public RadioGroup setSize(String size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Get the associated form ID.
   *
   * @return the form ID
   */
  public String getForm() {
    return get(formProp);
  }

  /**
   * Associate with a form by ID.
   *
   * @param form the form ID
   * @return this instance for method chaining
   */
  public RadioGroup setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Check if selection is required.
   *
   * @return true if required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Set the required state.
   *
   * @param required true if required
   * @return this instance for method chaining
   */
  public RadioGroup setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Set custom label content
   *
   * @param label the label component
   * @return this instance
   */
  public RadioGroup setLabelSlot(com.webforj.component.Component label) {
    getBoundComponent().add("label", label);
    return this;
  }

  /**
   * Set custom help text content
   *
   * @param helpText the help text component
   * @return this instance
   */
  public RadioGroup setHelpTextSlot(com.webforj.component.Component helpText) {
    getBoundComponent().add("help-text", helpText);
    return this;
  }

  /**
   * Add a radio to the group
   *
   * @param radio the radio component
   * @return this instance
   */
  public RadioGroup addRadio(Radio radio) {
    add(radio);
    return this;
  }

  /**
   * Add a radio button to the group
   *
   * @param radioButton the radio button component
   * @return this instance
   */
  public RadioGroup addRadioButton(RadioButton radioButton) {
    add(radioButton);
    return this;
  }

  /**
   * Check validity
   *
   * @return true if valid
   */
  public boolean checkValidity() {
    // Note: Would need JavaScript interop
    return true;
  }

  /**
   * Report validity
   *
   * @return true if valid
   */
  public boolean reportValidity() {
    // Note: Would need JavaScript interop
    return true;
  }

  /**
   * Set custom validity message
   *
   * @param message the validation message
   */
  public void setCustomValidity(String message) {
    // Note: Would need JavaScript interop
  }

  /**
   * Focus the radio group.
   */
  public void focus() {
    // Note: Would need JavaScript interop
  }

  /**
   * Add a listener for the change event.
   * 
   * <p>Fired when the selected radio changes.
   *
   * @param listener the change event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<ChangeEvent> onChange(EventListener<ChangeEvent> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Add a listener for the input event.
   * 
   * <p>Fired when the value changes (before blur).
   *
   * @param listener the input event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InputEvent> onInput(EventListener<InputEvent> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Change event fired when the selected radio changes.
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class ChangeEvent extends ComponentEvent<RadioGroup> {
    public ChangeEvent(RadioGroup component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the value of the newly selected radio.
     *
     * @return the selected value
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
  }

  /**
   * Input event fired when the value changes.
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class InputEvent extends ComponentEvent<RadioGroup> {
    public InputEvent(RadioGroup component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the current value.
     *
     * @return the current value
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
  }
}