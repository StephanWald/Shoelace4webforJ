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
 * Input component for form data entry.
 * 
 * <p>Inputs are used to collect data from the user. They support various types including text, email,
 * number, password, search, tel, url, date, time, and datetime-local. The component provides built-in
 * validation, formatting, and user interaction features.</p>
 * 
 * <h2>Features</h2>
 * <ul>
 *   <li>Multiple input types for different data formats</li>
 *   <li>Built-in validation with pattern matching</li>
 *   <li>Clearable option with clear button</li>
 *   <li>Password visibility toggle</li>
 *   <li>Three sizes: small, medium, large</li>
 *   <li>Pill shape option for rounded corners</li>
 *   <li>Help text support</li>
 *   <li>Prefix and suffix slot support</li>
 *   <li>Full keyboard navigation</li>
 *   <li>Accessible with proper ARIA attributes</li>
 * </ul>
 * 
 * <h2>Events</h2>
 * <p>The input component supports the following events:</p>
 * <ul>
 *   <li>{@link BlurEvent} - Fired when the input loses focus</li>
 *   <li>{@link ChangeEvent} - Fired when the value changes and input loses focus</li>
 *   <li>{@link ClearEvent} - Fired when the clear button is clicked</li>
 *   <li>{@link FocusEvent} - Fired when the input gains focus</li>
 *   <li>{@link InputEvent} - Fired when the user types in the input</li>
 *   <li>{@link InvalidEvent} - Fired when form validation fails</li>
 * </ul>
 * 
 * <h2>Example Usage</h2>
 * <pre>{@code
 * // Basic text input
 * Input nameInput = new Input("Name");
 * nameInput.setPlaceholder("Enter your name");
 * nameInput.setRequired(true);
 * 
 * // Email input with validation
 * Input emailInput = new Input("Email", Input.Type.EMAIL);
 * emailInput.setPlaceholder("user@example.com");
 * emailInput.setClearable(true);
 * 
 * // Password input with toggle
 * Input passwordInput = new Input("Password", Input.Type.PASSWORD);
 * passwordInput.setPasswordToggle(true);
 * passwordInput.setMinLength(8);
 * 
 * // Listen for input changes
 * nameInput.onInput(event -> {
 *     String currentValue = event.getValue();
 *     validateInput(currentValue);
 * });
 * }</pre>
 * 
 * @author Shoelace Web Components
 * @see <a href="https://shoelace.style/components/input">Shoelace Input Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/input/input.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-input")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Input extends ElementComposite implements HasComponents, HasStyle<Input> {
  private final PropertyDescriptor<String> TYPE = PropertyDescriptor.property("type", "text");
  private final PropertyDescriptor<String> NAME = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> VALUE = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> LABEL = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> PLACEHOLDER = PropertyDescriptor.property("placeholder", "");
  private final PropertyDescriptor<String> HELP_TEXT = PropertyDescriptor.property("help-text", "");
  private final PropertyDescriptor<String> SIZE = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<Boolean> DISABLED = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> READONLY = PropertyDescriptor.property("readonly", false);
  private final PropertyDescriptor<Boolean> REQUIRED = PropertyDescriptor.property("required", false);
  private final PropertyDescriptor<Boolean> CLEARABLE = PropertyDescriptor.property("clearable", false);
  private final PropertyDescriptor<Boolean> PILL = PropertyDescriptor.property("pill", false);
  private final PropertyDescriptor<Boolean> PASSWORD_TOGGLE = PropertyDescriptor.property("password-toggle", false);
  private final PropertyDescriptor<String> PATTERN = PropertyDescriptor.property("pattern", "");
  private final PropertyDescriptor<Integer> MIN_LENGTH = PropertyDescriptor.property("minlength", null);
  private final PropertyDescriptor<Integer> MAX_LENGTH = PropertyDescriptor.property("maxlength", null);
  private final PropertyDescriptor<String> MIN = PropertyDescriptor.property("min", "");
  private final PropertyDescriptor<String> MAX = PropertyDescriptor.property("max", "");
  private final PropertyDescriptor<String> STEP = PropertyDescriptor.property("step", "");

  /**
   * Input types
   */
  public enum Type {
    TEXT("text"),
    EMAIL("email"),
    NUMBER("number"),
    PASSWORD("password"),
    SEARCH("search"),
    TEL("tel"),
    URL("url"),
    DATE("date"),
    TIME("time"),
    DATETIME_LOCAL("datetime-local");

    private final String value;

    Type(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Input sizes
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
   * Create a new Input
   */
  public Input() {
    super();
  }

  /**
   * Create a new Input with label
   *
   * @param label the input label
   */
  public Input(String label) {
    super();
    setLabel(label);
  }

  /**
   * Create a new Input with label and type
   *
   * @param label the input label
   * @param type the input type
   */
  public Input(String label, Type type) {
    super();
    setLabel(label);
    setType(type);
  }

  // Type
  public String getType() {
    return get(TYPE);
  }

  public Input setType(Type type) {
    set(TYPE, type.getValue());
    return this;
  }

  public Input setType(String type) {
    set(TYPE, type);
    return this;
  }

  // Name
  public String getName() {
    return get(NAME);
  }

  public Input setName(String name) {
    set(NAME, name);
    return this;
  }

  // Value
  public String getValue() {
    return get(VALUE);
  }

  public Input setValue(String value) {
    set(VALUE, value);
    return this;
  }

  // Label
  public String getLabel() {
    return get(LABEL);
  }

  public Input setLabel(String label) {
    set(LABEL, label);
    return this;
  }

  // Placeholder
  public String getPlaceholder() {
    return get(PLACEHOLDER);
  }

  public Input setPlaceholder(String placeholder) {
    set(PLACEHOLDER, placeholder);
    return this;
  }

  // Help text
  public String getHelpText() {
    return get(HELP_TEXT);
  }

  public Input setHelpText(String helpText) {
    set(HELP_TEXT, helpText);
    return this;
  }

  // Size
  public String getSize() {
    return get(SIZE);
  }

  public Input setSize(Size size) {
    set(SIZE, size.getValue());
    return this;
  }

  // Disabled
  public boolean isDisabled() {
    return get(DISABLED);
  }

  public Input setDisabled(boolean disabled) {
    set(DISABLED, disabled);
    return this;
  }

  // Readonly
  public boolean isReadonly() {
    return get(READONLY);
  }

  public Input setReadonly(boolean readonly) {
    set(READONLY, readonly);
    return this;
  }

  // Required
  public boolean isRequired() {
    return get(REQUIRED);
  }

  public Input setRequired(boolean required) {
    set(REQUIRED, required);
    return this;
  }

  // Clearable
  public boolean isClearable() {
    return get(CLEARABLE);
  }

  public Input setClearable(boolean clearable) {
    set(CLEARABLE, clearable);
    return this;
  }

  // Pill
  public boolean isPill() {
    return get(PILL);
  }

  public Input setPill(boolean pill) {
    set(PILL, pill);
    return this;
  }

  // Password toggle
  public boolean isPasswordToggle() {
    return get(PASSWORD_TOGGLE);
  }

  public Input setPasswordToggle(boolean passwordToggle) {
    set(PASSWORD_TOGGLE, passwordToggle);
    return this;
  }

  // Pattern
  public String getPattern() {
    return get(PATTERN);
  }

  public Input setPattern(String pattern) {
    set(PATTERN, pattern);
    return this;
  }

  // Min length
  public Integer getMinLength() {
    return get(MIN_LENGTH);
  }

  public Input setMinLength(Integer minLength) {
    set(MIN_LENGTH, minLength);
    return this;
  }

  // Max length
  public Integer getMaxLength() {
    return get(MAX_LENGTH);
  }

  public Input setMaxLength(Integer maxLength) {
    set(MAX_LENGTH, maxLength);
    return this;
  }

  // Min (for number/date inputs)
  public String getMin() {
    return get(MIN);
  }

  public Input setMin(String min) {
    set(MIN, min);
    return this;
  }

  // Max (for number/date inputs)
  public String getMax() {
    return get(MAX);
  }

  public Input setMax(String max) {
    set(MAX, max);
    return this;
  }

  // Step (for number inputs)
  public String getStep() {
    return get(STEP);
  }

  public Input setStep(String step) {
    set(STEP, step);
    return this;
  }

  /**
   * Focus the input
   */
  public void focus() {
    // Note: Would need JavaScript interop
  }

  /**
   * Blur the input
   */
  public void blur() {
    // Note: Would need JavaScript interop
  }

  /**
   * Select all text in the input
   */
  public void select() {
    // Note: Would need JavaScript interop
  }
  
  // Event handling
  
  /**
   * Adds a listener for the blur event, which fires when the input loses focus.
   * 
   * @param listener the blur event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<BlurEvent> onBlur(EventListener<BlurEvent> listener) {
    return addEventListener(BlurEvent.class, listener);
  }
  
  /**
   * Adds a listener for the change event, which fires when the value changes and the input loses focus.
   * 
   * <p>This event is useful for performing validation or saving data after the user
   * has finished editing the input.</p>
   * 
   * @param listener the change event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<ChangeEvent> onChange(EventListener<ChangeEvent> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }
  
  /**
   * Adds a listener for the clear event, which fires when the clear button is clicked.
   * 
   * <p>This event only fires when the input has the clearable property set to true.</p>
   * 
   * @param listener the clear event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<ClearEvent> onClear(EventListener<ClearEvent> listener) {
    return addEventListener(ClearEvent.class, listener);
  }
  
  /**
   * Adds a listener for the focus event, which fires when the input gains focus.
   * 
   * @param listener the focus event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<FocusEvent> onFocus(EventListener<FocusEvent> listener) {
    return addEventListener(FocusEvent.class, listener);
  }
  
  /**
   * Adds a listener for the input event, which fires when the user types in the input.
   * 
   * <p>This event fires continuously as the user types, providing real-time updates
   * of the input value. It's useful for live validation, search suggestions, or
   * character counting.</p>
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
   * <p>This event is triggered when the input fails HTML5 validation constraints
   * such as required, pattern, min/max length, etc.</p>
   * 
   * @param listener the invalid event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<InvalidEvent> onInvalid(EventListener<InvalidEvent> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }
  
  // Event classes
  
  /**
   * Event fired when the input loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<Input> {
    public BlurEvent(Input component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
  
  /**
   * Event fired when the value changes and input loses focus.
   * 
   * <p>This event provides access to the new value after editing is complete.</p>
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class ChangeEvent extends ComponentEvent<Input> {
    public ChangeEvent(Input component, Map<String, Object> detail) {
      super(component, detail);
    }
    
    /**
     * Gets the current value of the input.
     * 
     * @return the input value
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
  }
  
  /**
   * Event fired when the clear button is clicked.
   * 
   * <p>This event only occurs when the input has clearable set to true.</p>
   */
  @EventName("sl-clear")
  public static class ClearEvent extends ComponentEvent<Input> {
    public ClearEvent(Input component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
  
  /**
   * Event fired when the input gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<Input> {
    public FocusEvent(Input component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
  
  /**
   * Event fired when the user types in the input.
   * 
   * <p>This event fires continuously as the user types, providing real-time value updates.</p>
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class InputEvent extends ComponentEvent<Input> {
    public InputEvent(Input component, Map<String, Object> detail) {
      super(component, detail);
    }
    
    /**
     * Gets the current value of the input.
     * 
     * @return the input value
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
  }
  
  /**
   * Event fired when form validation fails.
   */
  @EventName("sl-invalid")
  public static class InvalidEvent extends ComponentEvent<Input> {
    public InvalidEvent(Input component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
  
  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
}