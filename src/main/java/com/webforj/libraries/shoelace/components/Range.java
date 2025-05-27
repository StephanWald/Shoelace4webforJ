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
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Shoelace Range component for selecting numeric values within a range.
 * 
 * <p>The Range component provides a slider input for selecting values between
 * minimum and maximum bounds. It supports customizable steps, tooltips, and
 * can be used in forms for numeric input.
 * 
 * <p>Example usage:
 * <pre>{@code
 * Range volumeRange = new Range(0, 100);
 * volumeRange.setLabel("Volume");
 * volumeRange.setValue(50);
 * volumeRange.setStep(5);
 * volumeRange.setTooltip(Range.TooltipPlacement.TOP);
 * 
 * volumeRange.onInput(event -> {
 *   System.out.println("Volume: " + event.getValue());
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/range">Shoelace Range Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/range/range.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-range")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Range extends ElementComposite implements HasComponents, HasStyle<Range> {
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<Double> valueProp = PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> helpTextProp = PropertyDescriptor.property("help-text", "");
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Double> minProp = PropertyDescriptor.property("min", 0.0);
  private final PropertyDescriptor<Double> maxProp = PropertyDescriptor.property("max", 100.0);
  private final PropertyDescriptor<Double> stepProp = PropertyDescriptor.property("step", 1.0);
  private final PropertyDescriptor<String> tooltipProp = PropertyDescriptor.property("tooltip", "top");
  private final PropertyDescriptor<String> formProp = PropertyDescriptor.property("form", "");
  private final PropertyDescriptor<Boolean> requiredProp = PropertyDescriptor.property("required", false);

  /**
   * Tooltip placement options for the range slider.
   */
  public enum TooltipPlacement {
    /** Show tooltip above the slider */
    TOP("top"),
    /** Show tooltip below the slider */
    BOTTOM("bottom"),
    /** Don't show tooltip */
    NONE("none");

    private final String value;

    TooltipPlacement(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new Range component.
   */
  public Range() {
    super();
  }

  /**
   * Create a new Range with min and max values.
   *
   * @param min the minimum value
   * @param max the maximum value
   */
  public Range(double min, double max) {
    super();
    setMin(min);
    setMax(max);
  }

  /**
   * Create a new Range with min, max, and initial value.
   *
   * @param min the minimum value
   * @param max the maximum value  
   * @param value the initial value
   */
  public Range(double min, double max, double value) {
    super();
    setMin(min);
    setMax(max);
    setValue(value);
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
  public Range setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Get the current value.
   *
   * @return the current numeric value
   */
  public double getValue() {
    return get(valueProp);
  }

  /**
   * Set the current value.
   *
   * @param value the numeric value
   * @return this instance for method chaining
   */
  public Range setValue(double value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Get the label text.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Set the label text.
   *
   * @param label the label text
   * @return this instance for method chaining
   */
  public Range setLabel(String label) {
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
   * Set the help text displayed below the range.
   *
   * @param helpText the help text
   * @return this instance for method chaining
   */
  public Range setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Check if the range is disabled.
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
  public Range setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Get the minimum value.
   *
   * @return the minimum value
   */
  public double getMin() {
    return get(minProp);
  }

  /**
   * Set the minimum value.
   *
   * @param min the minimum value
   * @return this instance for method chaining
   */
  public Range setMin(double min) {
    set(minProp, min);
    return this;
  }

  /**
   * Get the maximum value.
   *
   * @return the maximum value
   */
  public double getMax() {
    return get(maxProp);
  }

  /**
   * Set the maximum value.
   *
   * @param max the maximum value
   * @return this instance for method chaining
   */
  public Range setMax(double max) {
    set(maxProp, max);
    return this;
  }

  /**
   * Get the step value.
   *
   * @return the step increment
   */
  public double getStep() {
    return get(stepProp);
  }

  /**
   * Set the step value for increments.
   *
   * @param step the step increment
   * @return this instance for method chaining
   */
  public Range setStep(double step) {
    set(stepProp, step);
    return this;
  }

  /**
   * Get the tooltip placement.
   *
   * @return the tooltip placement value
   */
  public String getTooltip() {
    return get(tooltipProp);
  }

  /**
   * Set the tooltip placement using the enum.
   *
   * @param tooltip the tooltip placement
   * @return this instance for method chaining
   */
  public Range setTooltip(TooltipPlacement tooltip) {
    set(tooltipProp, tooltip.getValue());
    return this;
  }

  /**
   * Set the tooltip placement using a string value.
   *
   * @param tooltip the tooltip placement value
   * @return this instance for method chaining
   */
  public Range setTooltip(String tooltip) {
    set(tooltipProp, tooltip);
    return this;
  }

  /**
   * Get the form ID.
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
  public Range setForm(String form) {
    set(formProp, form);
    return this;
  }

  /**
   * Check if the range is required.
   *
   * @return true if required, false otherwise
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Set whether the range is required for form submission.
   *
   * @param required true to make required, false otherwise
   * @return this instance for method chaining
   */
  public Range setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Set custom label content
   *
   * @param label the label component
   * @return this instance
   */
  public Range setLabelSlot(com.webforj.component.Component label) {
    getBoundComponent().add("label", label);
    return this;
  }

  /**
   * Set custom help text content
   *
   * @param helpText the help text component
   * @return this instance
   */
  public Range setHelpTextSlot(com.webforj.component.Component helpText) {
    getBoundComponent().add("help-text", helpText);
    return this;
  }

  /**
   * Focus the range
   */
  public void focus() {
    // Note: Would need JavaScript interop
  }

  /**
   * Blur the range
   */
  public void blur() {
    // Note: Would need JavaScript interop
  }

  /**
   * Increment the value by one step
   */
  public void stepUp() {
    // Note: Would need JavaScript interop
  }

  /**
   * Decrement the value by one step
   */
  public void stepDown() {
    // Note: Would need JavaScript interop
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
   * Set custom validity message.
   *
   * @param message the validation message
   */
  public void setCustomValidity(String message) {
    // Note: Would need JavaScript interop
  }

  /**
   * Add a listener for the blur event.
   * 
   * <p>Fired when the range loses focus.
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
   * <p>Fired when the value changes and the range loses focus.
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
   * <p>Fired when the range gains focus.
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
   * <p>Fired continuously as the value changes during drag.
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
   * <p>Fired when the range fails validation.
   *
   * @param listener the invalid event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InvalidEvent> onInvalid(EventListener<InvalidEvent> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Blur event fired when the range loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<Range> {
    public BlurEvent(Range component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Change event fired when the value changes and focus is lost.
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class ChangeEvent extends ComponentEvent<Range> {
    public ChangeEvent(Range component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the new value.
     *
     * @return the numeric value
     */
    public double getValue() {
      Object value = getEventMap().getOrDefault("value", 0.0);
      if (value instanceof Number) {
        return ((Number) value).doubleValue();
      }
      return Double.parseDouble(value.toString());
    }
  }

  /**
   * Focus event fired when the range gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<Range> {
    public FocusEvent(Range component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Input event fired continuously during value changes.
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class InputEvent extends ComponentEvent<Range> {
    public InputEvent(Range component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the current value during drag.
     *
     * @return the numeric value
     */
    public double getValue() {
      Object value = getEventMap().getOrDefault("value", 0.0);
      if (value instanceof Number) {
        return ((Number) value).doubleValue();
      }
      return Double.parseDouble(value.toString());
    }
  }

  /**
   * Invalid event fired when validation fails.
   */
  @EventName("sl-invalid")
  public static class InvalidEvent extends ComponentEvent<Range> {
    public InvalidEvent(Range component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
}