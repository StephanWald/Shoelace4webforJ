package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;

import java.util.Map;

/**
 * Shoelace Textarea component.
 * 
 * <p>The Textarea component is a multi-line text input control that allows users to enter and edit 
 * larger amounts of text. It provides features like resizing, auto-sizing, label, help text, validation, 
 * and various styling options.
 * 
 * <p><strong>Basic Usage:</strong>
 * <pre>{@code
 * Textarea textarea = new Textarea("Comments");
 * textarea.setPlaceholder("Enter your comments here...")
 *         .setRows(5)
 *         .setResize("auto");
 * }</pre>
 * 
 * <p><strong>With Validation:</strong>
 * <pre>{@code
 * Textarea feedback = new Textarea("Feedback");
 * feedback.setRequired(true)
 *         .setHelpText("Please provide detailed feedback")
 *         .onChange(event -> {
 *             String value = event.getComponent().getValue();
 *             System.out.println("Feedback: " + value);
 *         });
 * }</pre>
 * 
 * <p><strong>Character Counter Example:</strong>
 * <pre>{@code
 * Textarea message = new Textarea("Message");
 * message.setMaxLength(280);
 * 
 * Text counter = new Text("0/280 characters");
 * message.onInput(event -> {
 *     String value = event.getComponent().getValue();
 *     counter.setText(value.length() + "/280 characters");
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/textarea">Shoelace Textarea Documentation</a>
 * 
 * @author Hyyan Abo Fakher
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/textarea/textarea.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-textarea")
public final class Textarea extends ElementComposite implements HasComponents, HasStyle<Textarea> {

  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<Boolean> filledProp = PropertyDescriptor.property("filled", false);
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> helpTextProp = PropertyDescriptor.property("help-text", "");
  private final PropertyDescriptor<String> placeholderProp = PropertyDescriptor.property("placeholder", "");
  private final PropertyDescriptor<Integer> rowsProp = PropertyDescriptor.property("rows", 4);
  private final PropertyDescriptor<String> resizeProp = PropertyDescriptor.property("resize", "vertical");
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> readonlyProp = PropertyDescriptor.property("readonly", false);
  private final PropertyDescriptor<Boolean> requiredProp = PropertyDescriptor.property("required", false);
  private final PropertyDescriptor<Integer> minLengthProp = PropertyDescriptor.property("minlength", null);
  private final PropertyDescriptor<Integer> maxLengthProp = PropertyDescriptor.property("maxlength", null);
  private final PropertyDescriptor<Boolean> autofocusProp = PropertyDescriptor.property("autofocus", false);
  private final PropertyDescriptor<String> autocompleteProp = PropertyDescriptor.property("autocomplete", "off");
  private final PropertyDescriptor<Boolean> spellcheckProp = PropertyDescriptor.property("spellcheck", true);

  /**
   * Creates a new Textarea component.
   */
  public Textarea() {
    super();
  }

  /**
   * Creates a new Textarea component with the specified label.
   * 
   * @param label the label text for the textarea
   */
  public Textarea(String label) {
    super();
    setLabel(label);
  }

  /**
   * Creates a new Textarea component with label and placeholder.
   * 
   * @param label the label text for the textarea
   * @param placeholder the placeholder text
   */
  public Textarea(String label, String placeholder) {
    super();
    setLabel(label);
    setPlaceholder(placeholder);
  }

  /**
   * Gets the textarea's name attribute.
   * 
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the textarea's name attribute.
   * 
   * @param name the name
   * @return this instance
   */
  public Textarea setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the textarea's value.
   * 
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the textarea's value.
   * 
   * @param value the value
   * @return this instance
   */
  public Textarea setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the textarea's size.
   * 
   * @return the size ("small", "medium", or "large")
   */
  public String getSize() {
    return get(sizeProp);
  }

  /**
   * Sets the textarea's size.
   * 
   * @param size the size ("small", "medium", or "large")
   * @return this instance
   */
  public Textarea setSize(String size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Checks if the textarea has a filled style.
   * 
   * @return true if filled, false otherwise
   */
  public boolean isFilled() {
    return get(filledProp);
  }

  /**
   * Sets whether the textarea has a filled style.
   * 
   * @param filled true for filled style, false otherwise
   * @return this instance
   */
  public Textarea setFilled(boolean filled) {
    set(filledProp, filled);
    return this;
  }

  /**
   * Gets the textarea's label.
   * 
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the textarea's label.
   * 
   * @param label the label
   * @return this instance
   */
  public Textarea setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the textarea's help text.
   * 
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Sets the textarea's help text.
   * 
   * @param helpText the help text
   * @return this instance
   */
  public Textarea setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Gets the textarea's placeholder text.
   * 
   * @return the placeholder
   */
  public String getPlaceholder() {
    return get(placeholderProp);
  }

  /**
   * Sets the textarea's placeholder text.
   * 
   * @param placeholder the placeholder
   * @return this instance
   */
  public Textarea setPlaceholder(String placeholder) {
    set(placeholderProp, placeholder);
    return this;
  }

  /**
   * Gets the number of rows in the textarea.
   * 
   * @return the number of rows
   */
  public int getRows() {
    return get(rowsProp);
  }

  /**
   * Sets the number of rows in the textarea.
   * 
   * @param rows the number of rows
   * @return this instance
   */
  public Textarea setRows(int rows) {
    set(rowsProp, rows);
    return this;
  }

  /**
   * Gets the resize behavior of the textarea.
   * 
   * @return the resize behavior ("none", "vertical", "horizontal", or "auto")
   */
  public String getResize() {
    return get(resizeProp);
  }

  /**
   * Sets the resize behavior of the textarea.
   * 
   * @param resize the resize behavior ("none", "vertical", "horizontal", or "auto")
   * @return this instance
   */
  public Textarea setResize(String resize) {
    set(resizeProp, resize);
    return this;
  }

  /**
   * Checks if the textarea is disabled.
   * 
   * @return true if disabled, false otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the textarea is disabled.
   * 
   * @param disabled true to disable, false otherwise
   * @return this instance
   */
  public Textarea setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Checks if the textarea is readonly.
   * 
   * @return true if readonly, false otherwise
   */
  public boolean isReadonly() {
    return get(readonlyProp);
  }

  /**
   * Sets whether the textarea is readonly.
   * 
   * @param readonly true for readonly, false otherwise
   * @return this instance
   */
  public Textarea setReadonly(boolean readonly) {
    set(readonlyProp, readonly);
    return this;
  }

  /**
   * Checks if the textarea is required.
   * 
   * @return true if required, false otherwise
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Sets whether the textarea is required.
   * 
   * @param required true for required, false otherwise
   * @return this instance
   */
  public Textarea setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Gets the minimum length constraint.
   * 
   * @return the minimum length, or null if not set
   */
  public Integer getMinLength() {
    return get(minLengthProp);
  }

  /**
   * Sets the minimum length constraint.
   * 
   * @param minLength the minimum length
   * @return this instance
   */
  public Textarea setMinLength(Integer minLength) {
    set(minLengthProp, minLength);
    return this;
  }

  /**
   * Gets the maximum length constraint.
   * 
   * @return the maximum length, or null if not set
   */
  public Integer getMaxLength() {
    return get(maxLengthProp);
  }

  /**
   * Sets the maximum length constraint.
   * 
   * @param maxLength the maximum length
   * @return this instance
   */
  public Textarea setMaxLength(Integer maxLength) {
    set(maxLengthProp, maxLength);
    return this;
  }

  /**
   * Checks if the textarea has autofocus.
   * 
   * @return true if autofocus is enabled, false otherwise
   */
  public boolean isAutofocus() {
    return get(autofocusProp);
  }

  /**
   * Sets whether the textarea has autofocus.
   * 
   * @param autofocus true to enable autofocus, false otherwise
   * @return this instance
   */
  public Textarea setAutofocus(boolean autofocus) {
    set(autofocusProp, autofocus);
    return this;
  }

  /**
   * Gets the autocomplete attribute value.
   * 
   * @return the autocomplete value
   */
  public String getAutocomplete() {
    return get(autocompleteProp);
  }

  /**
   * Sets the autocomplete attribute value.
   * 
   * @param autocomplete the autocomplete value
   * @return this instance
   */
  public Textarea setAutocomplete(String autocomplete) {
    set(autocompleteProp, autocomplete);
    return this;
  }

  /**
   * Checks if spellcheck is enabled.
   * 
   * @return true if spellcheck is enabled, false otherwise
   */
  public boolean isSpellcheck() {
    return get(spellcheckProp);
  }

  /**
   * Sets whether spellcheck is enabled.
   * 
   * @param spellcheck true to enable spellcheck, false otherwise
   * @return this instance
   */
  public Textarea setSpellcheck(boolean spellcheck) {
    set(spellcheckProp, spellcheck);
    return this;
  }

  /**
   * Add a listener for the blur event.
   * 
   * <p>Fired when the textarea loses focus.
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
   * <p>Fired when the textarea's value changes and it loses focus.
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
   * <p>Fired when the textarea gains focus.
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
   * <p>Fired when the user types in the textarea.
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
   * <p>Fired when the textarea's value fails validation.
   *
   * @param listener the invalid event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InvalidEvent> onInvalid(EventListener<InvalidEvent> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  @Override
  public Textarea setStyle(String property, String value) {
    getBoundComponent().setStyle(property, value);
    return this;
  }

  @Override
  public Textarea removeStyle(String property) {
    getBoundComponent().removeStyle(property);
    return this;
  }

  @Override
  public String getStyle(String property) {
    return getBoundComponent().getStyle(property);
  }

  @Override
  public String getComputedStyle(String property) {
    return getBoundComponent().getComputedStyle(property);
  }

  /**
   * Blur event dispatched when the textarea loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<Textarea> {
    /**
     * Creates a new blur event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public BlurEvent(Textarea component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Change event dispatched when the textarea's value changes and loses focus.
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class ChangeEvent extends ComponentEvent<Textarea> {
    /**
     * Creates a new change event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public ChangeEvent(Textarea component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Gets the new value of the textarea.
     *
     * @return the value
     */
    public String getValue() {
      return (String) getData().get("value");
    }
  }

  /**
   * Focus event dispatched when the textarea gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<Textarea> {
    /**
     * Creates a new focus event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public FocusEvent(Textarea component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Input event dispatched when the user types in the textarea.
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class InputEvent extends ComponentEvent<Textarea> {
    /**
     * Creates a new input event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public InputEvent(Textarea component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Gets the current value of the textarea.
     *
     * @return the value
     */
    public String getValue() {
      return (String) getData().get("value");
    }
  }

  /**
   * Invalid event dispatched when the textarea's value fails validation.
   */
  @EventName("sl-invalid")
  public static class InvalidEvent extends ComponentEvent<Textarea> {
    /**
     * Creates a new invalid event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public InvalidEvent(Textarea component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
}