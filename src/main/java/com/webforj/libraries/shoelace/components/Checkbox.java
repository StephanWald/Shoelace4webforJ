package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.event.ComponentEvent;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Checkboxes allow the user to toggle an option on or off.
 * 
 * <p>Checkboxes are used to let users select one or more options from a set. They can be used
 * individually or grouped together. The checkbox supports an indeterminate state which is useful
 * for representing a "select all" checkbox when only some items in a group are selected.</p>
 * 
 * <h2>Features</h2>
 * <ul>
 *   <li>Three states: unchecked, checked, and indeterminate</li>
 *   <li>Built-in validation support</li>
 *   <li>Customizable size (small, medium, large)</li>
 *   <li>Help text support for additional context</li>
 *   <li>Full keyboard navigation support</li>
 *   <li>Accessible by default with proper ARIA attributes</li>
 * </ul>
 * 
 * <h2>Events</h2>
 * <p>The checkbox component supports the following events:</p>
 * <ul>
 *   <li>{@link BlurEvent} - Fired when the checkbox loses focus</li>
 *   <li>{@link ChangeEvent} - Fired when the checked state changes</li>
 *   <li>{@link FocusEvent} - Fired when the checkbox gains focus</li>
 *   <li>{@link InputEvent} - Fired when the value changes (before blur)</li>
 *   <li>{@link InvalidEvent} - Fired when form validation fails</li>
 * </ul>
 * 
 * <h2>Example Usage</h2>
 * <pre>{@code
 * // Basic checkbox
 * Checkbox checkbox = new Checkbox("I agree to the terms");
 * checkbox.setChecked(true);
 * 
 * // Listen for changes
 * checkbox.onChange(event -> {
 *     boolean isChecked = event.isChecked();
 *     System.out.println("Checkbox is now: " + (isChecked ? "checked" : "unchecked"));
 * });
 * 
 * // Indeterminate state
 * Checkbox selectAll = new Checkbox("Select All");
 * selectAll.setIndeterminate(true);
 * }</pre>
 * 
 * @author Shoelace Web Components
 * @see <a href="https://shoelace.style/components/checkbox">Shoelace Checkbox Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/checkbox/checkbox.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-checkbox")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class Checkbox extends ElementComposite implements HasHtml<Checkbox>, HasStyle<Checkbox> {
  
  // Properties
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> checkedProp = PropertyDescriptor.property("checked", false);
  private final PropertyDescriptor<Boolean> indeterminateProp = PropertyDescriptor.property("indeterminate", false);
  private final PropertyDescriptor<Boolean> requiredProp = PropertyDescriptor.property("required", false);
  private final PropertyDescriptor<String> helpTextProp = PropertyDescriptor.property("help-text", "");
  
  // Size constants
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
  
  public Checkbox() {
    super();
  }
  
  public Checkbox(String label) {
    this();
    setHtml(label);
  }
  
  /**
   * Gets the checkbox name.
   */
  public String getName() {
    return get(nameProp);
  }
  
  /**
   * Sets the checkbox name.
   */
  public Checkbox setName(String name) {
    set(nameProp, name);
    return this;
  }
  
  /**
   * Gets the checkbox value.
   */
  public String getValue() {
    return get(valueProp);
  }
  
  /**
   * Sets the checkbox value.
   */
  public Checkbox setValue(String value) {
    set(valueProp, value);
    return this;
  }
  
  /**
   * Gets the checkbox size.
   */
  public String getSize() {
    return get(sizeProp);
  }
  
  /**
   * Sets the checkbox size.
   */
  public Checkbox setSize(Size size) {
    set(sizeProp, size.getValue());
    return this;
  }
  
  /**
   * Sets the checkbox size.
   */
  public Checkbox setSize(String size) {
    set(sizeProp, size);
    return this;
  }
  
  /**
   * Gets whether the checkbox is disabled.
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }
  
  /**
   * Sets whether the checkbox is disabled.
   */
  public Checkbox setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }
  
  /**
   * Gets whether the checkbox is checked.
   */
  public boolean isChecked() {
    return get(checkedProp);
  }
  
  /**
   * Sets whether the checkbox is checked.
   */
  public Checkbox setChecked(boolean checked) {
    set(checkedProp, checked);
    return this;
  }
  
  /**
   * Gets whether the checkbox is indeterminate.
   */
  public boolean isIndeterminate() {
    return get(indeterminateProp);
  }
  
  /**
   * Sets whether the checkbox is indeterminate.
   */
  public Checkbox setIndeterminate(boolean indeterminate) {
    set(indeterminateProp, indeterminate);
    return this;
  }
  
  /**
   * Gets whether the checkbox is required.
   */
  public boolean isRequired() {
    return get(requiredProp);
  }
  
  /**
   * Sets whether the checkbox is required.
   */
  public Checkbox setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }
  
  /**
   * Gets the help text.
   */
  public String getHelpText() {
    return get(helpTextProp);
  }
  
  /**
   * Sets the help text.
   */
  public Checkbox setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }
  
  // Event handling
  
  /**
   * Adds a listener for the blur event, which fires when the checkbox loses focus.
   * 
   * @param listener the blur event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<BlurEvent> onBlur(EventListener<BlurEvent> listener) {
    return addEventListener(BlurEvent.class, listener);
  }
  
  /**
   * Adds a listener for the change event, which fires when the checked state changes.
   * 
   * <p>This event provides access to the current checked state and is the primary
   * event for responding to user interaction with the checkbox.</p>
   * 
   * @param listener the change event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<ChangeEvent> onChange(EventListener<ChangeEvent> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }
  
  /**
   * Adds a listener for the focus event, which fires when the checkbox gains focus.
   * 
   * @param listener the focus event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<FocusEvent> onFocus(EventListener<FocusEvent> listener) {
    return addEventListener(FocusEvent.class, listener);
  }
  
  /**
   * Adds a listener for the input event, which fires when the value changes before blur.
   * 
   * <p>This event fires immediately when the checkbox state changes, before the change
   * event. It's useful for real-time updates.</p>
   * 
   * @param listener the input event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<InputEvent> onInput(EventListener<InputEvent> listener) {
    return addEventListener(InputEvent.class, listener);
  }
  
  /**
   * Adds a listener for the invalid event, which fires when form validation fails.
   * 
   * <p>This event is triggered when the checkbox is part of a form and validation
   * constraints are not met (e.g., required checkbox not checked).</p>
   * 
   * @param listener the invalid event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<InvalidEvent> onInvalid(EventListener<InvalidEvent> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }
  
  // Event classes
  
  /**
   * Event fired when the checkbox loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<Checkbox> {
    public BlurEvent(Checkbox component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
  
  /**
   * Event fired when the checked state changes.
   * 
   * <p>This event provides access to the current checked state of the checkbox.</p>
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "checked", exp = "event.target.checked"),
    @EventOptions.EventData(key = "indeterminate", exp = "event.target.indeterminate")
  })
  public static class ChangeEvent extends ComponentEvent<Checkbox> {
    public ChangeEvent(Checkbox component, Map<String, Object> detail) {
      super(component, detail);
    }
    
    /**
     * Gets whether the checkbox is currently checked.
     * 
     * @return true if checked, false otherwise
     */
    public boolean isChecked() {
      return (boolean) getEventMap().getOrDefault("checked", false);
    }
    
    /**
     * Gets whether the checkbox is in an indeterminate state.
     * 
     * @return true if indeterminate, false otherwise
     */
    public boolean isIndeterminate() {
      return (boolean) getEventMap().getOrDefault("indeterminate", false);
    }
  }
  
  /**
   * Event fired when the checkbox gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<Checkbox> {
    public FocusEvent(Checkbox component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
  
  /**
   * Event fired when the value changes (before blur).
   * 
   * <p>This event fires immediately when the checkbox state changes.</p>
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "checked", exp = "event.target.checked"),
    @EventOptions.EventData(key = "indeterminate", exp = "event.target.indeterminate")
  })
  public static class InputEvent extends ComponentEvent<Checkbox> {
    public InputEvent(Checkbox component, Map<String, Object> detail) {
      super(component, detail);
    }
    
    /**
     * Gets whether the checkbox is currently checked.
     * 
     * @return true if checked, false otherwise
     */
    public boolean isChecked() {
      return (boolean) getEventMap().getOrDefault("checked", false);
    }
    
    /**
     * Gets whether the checkbox is in an indeterminate state.
     * 
     * @return true if indeterminate, false otherwise
     */
    public boolean isIndeterminate() {
      return (boolean) getEventMap().getOrDefault("indeterminate", false);
    }
  }
  
  /**
   * Event fired when form validation fails.
   */
  @EventName("sl-invalid")
  public static class InvalidEvent extends ComponentEvent<Checkbox> {
    public InvalidEvent(Checkbox component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
}