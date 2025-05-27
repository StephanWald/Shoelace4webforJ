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
 * CopyButton provides a simple way to copy text data to the clipboard.
 * 
 * <p>This component displays a button with an icon that, when clicked, copies either
 * a specified value or the content of another element to the clipboard. It provides
 * visual feedback showing the copy status and can be customized with different labels,
 * icons, and tooltip settings.</p>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Copy static text values to clipboard</li>
 *   <li>Copy content from other elements using their ID</li>
 *   <li>Visual feedback with success/error states</li>
 *   <li>Customizable labels and icons</li>
 *   <li>Configurable tooltip placement</li>
 *   <li>Custom trigger support via slot</li>
 * </ul>
 * 
 * <h3>Example Usage:</h3>
 * <pre>{@code
 * // Basic copy button with a value
 * CopyButton copyEmail = new CopyButton("user@example.com");
 * 
 * // Copy button with custom labels
 * CopyButton copyCode = new CopyButton("console.log('Hello, World!');")
 *     .setCopyLabel("Copy code")
 *     .setSuccessLabel("Code copied!")
 *     .setErrorLabel("Failed to copy");
 * 
 * // Copy from another element
 * CopyButton copyFromTextarea = new CopyButton()
 *     .setFrom("my-textarea-id")
 *     .setTooltipPlacement("bottom");
 * 
 * // With custom trigger
 * CopyButton customCopy = new CopyButton("Copy this text");
 * customCopy.add(new ShoelaceButton("Click to copy", ShoelaceButton.Variant.PRIMARY));
 * 
 * // Handle copy events
 * copyButton.onCopy(event -> {
 *     String copiedValue = event.getValue();
 *     System.out.println("Copied: " + copiedValue);
 * });
 * 
 * copyButton.onError(event -> {
 *     System.err.println("Copy failed: " + event.getMessage());
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/copy-button">Shoelace Copy Button Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/copy-button/copy-button.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-copy-button")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class CopyButton extends ElementComposite implements HasStyle<CopyButton>, HasComponents {
  
  // ==================== Property Descriptors ====================
  
  /** The value to copy to clipboard */
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  
  /** The ID of the element to copy from */
  private final PropertyDescriptor<String> fromProp = PropertyDescriptor.property("from", "");
  
  /** Whether the button is disabled */
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  
  /** The label shown in the default state */
  private final PropertyDescriptor<String> copyLabelProp = PropertyDescriptor.property("copy-label", "Copy");
  
  /** The label shown on successful copy */
  private final PropertyDescriptor<String> successLabelProp = PropertyDescriptor.property("success-label", "Copied");
  
  /** The label shown on copy error */
  private final PropertyDescriptor<String> errorLabelProp = PropertyDescriptor.property("error-label", "Error");
  
  /** Duration in milliseconds to show feedback */
  private final PropertyDescriptor<Integer> feedbackDurationProp = PropertyDescriptor.property("feedback-duration", 1000);
  
  /** The tooltip placement relative to the button */
  private final PropertyDescriptor<String> tooltipPlacementProp = PropertyDescriptor.property("tooltip-placement", "top");
  
  /** Whether to hoist the tooltip to the body */
  private final PropertyDescriptor<Boolean> hoistProp = PropertyDescriptor.property("hoist", false);
  
  // ==================== Constructors ====================
  
  /**
   * Creates a new CopyButton instance.
   */
  public CopyButton() {
    super();
  }
  
  /**
   * Creates a new CopyButton instance with a value to copy.
   * 
   * @param value the text value to copy to clipboard
   */
  public CopyButton(String value) {
    this();
    setValue(value);
  }
  
  // ==================== HasComponents Implementation ====================
  
  /**
   * Adds components to the copy button's default slot.
   * 
   * <p>This allows you to use a custom trigger element instead of the default button.</p>
   * 
   * @param components the components to add as custom triggers
   */
  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
  
  // ==================== Value Properties ====================
  
  /**
   * Gets the value to copy to clipboard.
   * 
   * @return the value to copy
   */
  public String getValue() {
    return get(valueProp);
  }
  
  /**
   * Sets the value to copy to clipboard.
   * 
   * <p>This value will be copied when the button is clicked. If both value and from
   * are set, value takes precedence.</p>
   * 
   * @param value the text value to copy
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setValue(String value) {
    set(valueProp, value);
    return this;
  }
  
  /**
   * Gets the ID of the element to copy content from.
   * 
   * @return the element ID to copy from
   */
  public String getFrom() {
    return get(fromProp);
  }
  
  /**
   * Sets the ID of the element to copy content from.
   * 
   * <p>When set, the button will copy the text content or value of the element
   * with this ID. This is useful for copying content from inputs, textareas, or
   * other elements.</p>
   * 
   * @param from the ID of the element to copy from
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setFrom(String from) {
    set(fromProp, from);
    return this;
  }
  
  // ==================== State Properties ====================
  
  /**
   * Gets whether the button is disabled.
   * 
   * @return true if the button is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }
  
  /**
   * Sets whether the button is disabled.
   * 
   * <p>When disabled, the button cannot be clicked and copying is prevented.</p>
   * 
   * @param disabled true to disable the button
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }
  
  // ==================== Label Properties ====================
  
  /**
   * Gets the copy label shown in the default state.
   * 
   * @return the copy label
   */
  public String getCopyLabel() {
    return get(copyLabelProp);
  }
  
  /**
   * Sets the label shown in the tooltip when hovering over the button.
   * 
   * @param copyLabel the label to show (default: "Copy")
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setCopyLabel(String copyLabel) {
    set(copyLabelProp, copyLabel);
    return this;
  }
  
  /**
   * Gets the success label shown after successful copy.
   * 
   * @return the success label
   */
  public String getSuccessLabel() {
    return get(successLabelProp);
  }
  
  /**
   * Sets the label shown in the tooltip after successful copy.
   * 
   * @param successLabel the success message (default: "Copied")
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setSuccessLabel(String successLabel) {
    set(successLabelProp, successLabel);
    return this;
  }
  
  /**
   * Gets the error label shown when copy fails.
   * 
   * @return the error label
   */
  public String getErrorLabel() {
    return get(errorLabelProp);
  }
  
  /**
   * Sets the label shown in the tooltip when copying fails.
   * 
   * @param errorLabel the error message (default: "Error")
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setErrorLabel(String errorLabel) {
    set(errorLabelProp, errorLabel);
    return this;
  }
  
  // ==================== Feedback Properties ====================
  
  /**
   * Gets the feedback duration in milliseconds.
   * 
   * @return the feedback duration
   */
  public Integer getFeedbackDuration() {
    return get(feedbackDurationProp);
  }
  
  /**
   * Sets how long the success/error feedback is shown.
   * 
   * @param feedbackDuration duration in milliseconds (default: 1000)
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setFeedbackDuration(int feedbackDuration) {
    set(feedbackDurationProp, feedbackDuration);
    return this;
  }
  
  // ==================== Tooltip Properties ====================
  
  /**
   * Gets the tooltip placement.
   * 
   * @return the tooltip placement
   */
  public String getTooltipPlacement() {
    return get(tooltipPlacementProp);
  }
  
  /**
   * Sets the placement of the tooltip relative to the button.
   * 
   * @param placement the placement (e.g., "top", "bottom", "left", "right")
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setTooltipPlacement(String placement) {
    set(tooltipPlacementProp, placement);
    return this;
  }
  
  /**
   * Gets whether the tooltip is hoisted to the body.
   * 
   * @return true if the tooltip is hoisted
   */
  public boolean isHoist() {
    return get(hoistProp);
  }
  
  /**
   * Sets whether to hoist the tooltip to the body.
   * 
   * <p>Hoisting can help with positioning issues in complex layouts or when
   * the button is inside a container with overflow hidden.</p>
   * 
   * @param hoist true to hoist the tooltip
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setHoist(boolean hoist) {
    set(hoistProp, hoist);
    return this;
  }
  
  // ==================== Slot Management ====================
  
  /**
   * Sets a custom copy icon.
   * 
   * <p>This icon is shown in the default state.</p>
   * 
   * @param icon the component to use as the copy icon
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setCopyIcon(com.webforj.component.Component icon) {
    getBoundComponent().add("copy-icon", icon);
    return this;
  }
  
  /**
   * Sets a custom success icon.
   * 
   * <p>This icon is shown after successful copy.</p>
   * 
   * @param icon the component to use as the success icon
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setSuccessIcon(com.webforj.component.Component icon) {
    getBoundComponent().add("success-icon", icon);
    return this;
  }
  
  /**
   * Sets a custom error icon.
   * 
   * <p>This icon is shown when copying fails.</p>
   * 
   * @param icon the component to use as the error icon
   * @return this CopyButton instance for method chaining
   */
  public CopyButton setErrorIcon(com.webforj.component.Component icon) {
    getBoundComponent().add("error-icon", icon);
    return this;
  }
  
  // ==================== Event Handling ====================
  
  /**
   * Adds a listener for the copy event.
   * 
   * <p>This event is fired when the data has been successfully copied to the clipboard.</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<CopyEvent> onCopy(EventListener<CopyEvent> listener) {
    return addEventListener(CopyEvent.class, listener);
  }
  
  /**
   * Adds a listener for the error event.
   * 
   * <p>This event is fired when the data could not be copied to the clipboard.</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<ErrorEvent> onError(EventListener<ErrorEvent> listener) {
    return addEventListener(ErrorEvent.class, listener);
  }
  
  // ==================== Event Classes ====================
  
  /**
   * Event fired when data has been successfully copied to the clipboard.
   */
  @EventName("sl-copy")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class CopyEvent extends ComponentEvent<CopyButton> {
    /**
     * Creates a new copy event.
     * 
     * @param component the source CopyButton
     * @param detail the event detail map
     */
    public CopyEvent(CopyButton component, Map<String, Object> detail) {
      super(component, detail);
    }
    
    /**
     * Gets the value that was copied to the clipboard.
     * 
     * @return the copied value
     */
    public String getValue() {
      return (String) getData().get("value");
    }
  }
  
  /**
   * Event fired when data could not be copied to the clipboard.
   */
  @EventName("sl-error")
  @EventOptions(data = {
    @EventOptions.EventData(key = "message", exp = "event.message")
  })
  public static class ErrorEvent extends ComponentEvent<CopyButton> {
    /**
     * Creates a new error event.
     * 
     * @param component the source CopyButton
     * @param detail the event detail map
     */
    public ErrorEvent(CopyButton component, Map<String, Object> detail) {
      super(component, detail);
    }
    
    /**
     * Gets the error message describing why the copy failed.
     * 
     * @return the error message
     */
    public String getMessage() {
      return (String) getData().get("message");
    }
  }
}