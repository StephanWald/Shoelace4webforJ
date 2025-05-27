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
 * Color pickers allow the user to select a color.
 * 
 * <p>Color pickers combine a text input with a color dropdown for an intuitive way to select colors.
 * They support multiple color formats including hex, rgb, hsl, and hsv. The component can be displayed
 * inline or as a dropdown, and includes an optional opacity slider and predefined color swatches.</p>
 * 
 * <h2>Features</h2>
 * <ul>
 *   <li>Multiple color formats: hex, rgb, hsl, hsv</li>
 *   <li>Inline or dropdown display modes</li>
 *   <li>Optional opacity/alpha channel support</li>
 *   <li>Predefined color swatches</li>
 *   <li>Format toggle button</li>
 *   <li>Customizable sizes</li>
 *   <li>Full keyboard navigation</li>
 *   <li>Accessible color selection</li>
 * </ul>
 * 
 * <h2>Events</h2>
 * <p>The color picker component supports the following events:</p>
 * <ul>
 *   <li>{@link BlurEvent} - Fired when the color picker loses focus</li>
 *   <li>{@link ChangeEvent} - Fired when the color value changes and the picker loses focus</li>
 *   <li>{@link FocusEvent} - Fired when the color picker gains focus</li>
 *   <li>{@link InputEvent} - Fired when the color changes during interaction</li>
 *   <li>{@link InvalidEvent} - Fired when form validation fails</li>
 * </ul>
 * 
 * <h2>Example Usage</h2>
 * <pre>{@code
 * // Basic color picker
 * ColorPicker colorPicker = new ColorPicker("#ff0000");
 * colorPicker.setLabel("Choose a color");
 * 
 * // Listen for color changes
 * colorPicker.onChange(event -> {
 *     String newColor = event.getValue();
 *     System.out.println("Color changed to: " + newColor);
 * });
 * 
 * // Inline color picker with opacity
 * ColorPicker inlinePicker = new ColorPicker();
 * inlinePicker.setInline(true);
 * inlinePicker.setOpacity(1.0);
 * 
 * // With predefined swatches
 * colorPicker.setSwatches(new String[]{
 *     "#ff0000", "#00ff00", "#0000ff",
 *     "#ffff00", "#ff00ff", "#00ffff"
 * });
 * }</pre>
 * 
 * @author Shoelace Web Components
 * @see <a href="https://shoelace.style/components/color-picker">Shoelace Color Picker Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/color-picker/color-picker.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-color-picker")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class ColorPicker extends ElementComposite implements HasHtml<ColorPicker>, HasStyle<ColorPicker> {
  
  // Properties
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "#ffffff");
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "Select a color");
  private final PropertyDescriptor<String> formatProp = PropertyDescriptor.property("format", "hex");
  private final PropertyDescriptor<Boolean> inlineProp = PropertyDescriptor.property("inline", false);
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<Boolean> noFormatToggleProp = PropertyDescriptor.property("no-format-toggle", false);
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> hoistsMenuProp = PropertyDescriptor.property("hoist", false);
  private final PropertyDescriptor<Double> opacityProp = PropertyDescriptor.property("opacity", null);
  private final PropertyDescriptor<Boolean> uppercaseProp = PropertyDescriptor.property("uppercase", false);
  private final PropertyDescriptor<String> swatchesProp = PropertyDescriptor.property("swatches", "");
  
  // Format constants
  public enum Format {
    HEX("hex"),
    RGB("rgb"),
    HSL("hsl"),
    HSV("hsv");
    
    private final String value;
    
    Format(String value) {
      this.value = value;
    }
    
    public String getValue() {
      return value;
    }
  }
  
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
  
  public ColorPicker() {
    super();
  }
  
  public ColorPicker(String value) {
    this();
    setValue(value);
  }
  
  /**
   * Gets the current color value.
   */
  public String getValue() {
    return get(valueProp);
  }
  
  /**
   * Sets the color value.
   */
  public ColorPicker setValue(String value) {
    set(valueProp, value);
    return this;
  }
  
  /**
   * Gets the label.
   */
  public String getLabel() {
    return get(labelProp);
  }
  
  /**
   * Sets the label.
   */
  public ColorPicker setLabel(String label) {
    set(labelProp, label);
    return this;
  }
  
  /**
   * Gets the color format.
   */
  public String getFormat() {
    return get(formatProp);
  }
  
  /**
   * Sets the color format.
   */
  public ColorPicker setFormat(Format format) {
    set(formatProp, format.getValue());
    return this;
  }
  
  /**
   * Sets the color format.
   */
  public ColorPicker setFormat(String format) {
    set(formatProp, format);
    return this;
  }
  
  /**
   * Gets whether the color picker is inline.
   */
  public boolean isInline() {
    return get(inlineProp);
  }
  
  /**
   * Sets whether the color picker is inline.
   */
  public ColorPicker setInline(boolean inline) {
    set(inlineProp, inline);
    return this;
  }
  
  /**
   * Gets the size.
   */
  public String getSize() {
    return get(sizeProp);
  }
  
  /**
   * Sets the size.
   */
  public ColorPicker setSize(Size size) {
    set(sizeProp, size.getValue());
    return this;
  }
  
  /**
   * Sets the size.
   */
  public ColorPicker setSize(String size) {
    set(sizeProp, size);
    return this;
  }
  
  /**
   * Gets whether the format toggle is hidden.
   */
  public boolean isNoFormatToggle() {
    return get(noFormatToggleProp);
  }
  
  /**
   * Sets whether to hide the format toggle.
   */
  public ColorPicker setNoFormatToggle(boolean noFormatToggle) {
    set(noFormatToggleProp, noFormatToggle);
    return this;
  }
  
  /**
   * Gets the name.
   */
  public String getName() {
    return get(nameProp);
  }
  
  /**
   * Sets the name.
   */
  public ColorPicker setName(String name) {
    set(nameProp, name);
    return this;
  }
  
  /**
   * Gets whether the color picker is disabled.
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }
  
  /**
   * Sets whether the color picker is disabled.
   */
  public ColorPicker setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }
  
  /**
   * Gets whether the dropdown is hoisted.
   */
  public boolean isHoist() {
    return get(hoistsMenuProp);
  }
  
  /**
   * Sets whether to hoist the dropdown.
   */
  public ColorPicker setHoist(boolean hoist) {
    set(hoistsMenuProp, hoist);
    return this;
  }
  
  /**
   * Gets the opacity value.
   */
  public Double getOpacity() {
    return get(opacityProp);
  }
  
  /**
   * Sets the opacity value (null to disable opacity slider).
   */
  public ColorPicker setOpacity(Double opacity) {
    set(opacityProp, opacity);
    return this;
  }
  
  /**
   * Gets whether hex values are uppercase.
   */
  public boolean isUppercase() {
    return get(uppercaseProp);
  }
  
  /**
   * Sets whether hex values should be uppercase.
   */
  public ColorPicker setUppercase(boolean uppercase) {
    set(uppercaseProp, uppercase);
    return this;
  }
  
  /**
   * Gets the color swatches.
   */
  public String getSwatches() {
    return get(swatchesProp);
  }
  
  /**
   * Sets predefined color swatches (semicolon-delimited list of colors).
   */
  public ColorPicker setSwatches(String swatches) {
    set(swatchesProp, swatches);
    return this;
  }
  
  /**
   * Sets predefined color swatches from an array.
   */
  public ColorPicker setSwatches(String[] swatches) {
    set(swatchesProp, String.join(";", swatches));
    return this;
  }
  
  // Event handling
  
  /**
   * Adds a listener for the blur event, which fires when the color picker loses focus.
   * 
   * @param listener the blur event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<BlurEvent> onBlur(EventListener<BlurEvent> listener) {
    return addEventListener(BlurEvent.class, listener);
  }
  
  /**
   * Adds a listener for the change event, which fires when the color value changes and the picker loses focus.
   * 
   * <p>This event provides access to the new color value in the selected format.</p>
   * 
   * @param listener the change event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<ChangeEvent> onChange(EventListener<ChangeEvent> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }
  
  /**
   * Adds a listener for the focus event, which fires when the color picker gains focus.
   * 
   * @param listener the focus event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<FocusEvent> onFocus(EventListener<FocusEvent> listener) {
    return addEventListener(FocusEvent.class, listener);
  }
  
  /**
   * Adds a listener for the input event, which fires when the color changes during interaction.
   * 
   * <p>This event fires continuously as the user interacts with the color picker,
   * providing real-time color updates.</p>
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
   * @param listener the invalid event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<InvalidEvent> onInvalid(EventListener<InvalidEvent> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }
  
  // Event classes
  
  /**
   * Event fired when the color picker loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<ColorPicker> {
    public BlurEvent(ColorPicker component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
  
  /**
   * Event fired when the color value changes and the picker loses focus.
   * 
   * <p>This event provides access to the new color value.</p>
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value"),
    @EventOptions.EventData(key = "formattedValue", exp = "event.target.getFormattedValue()")
  })
  public static class ChangeEvent extends ComponentEvent<ColorPicker> {
    public ChangeEvent(ColorPicker component, Map<String, Object> detail) {
      super(component, detail);
    }
    
    /**
     * Gets the color value in the current format.
     * 
     * @return the color value string
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
    
    /**
     * Gets the formatted color value.
     * 
     * @return the formatted color value string
     */
    public String getFormattedValue() {
      return (String) getEventMap().getOrDefault("formattedValue", "");
    }
  }
  
  /**
   * Event fired when the color picker gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<ColorPicker> {
    public FocusEvent(ColorPicker component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
  
  /**
   * Event fired when the color changes during interaction.
   * 
   * <p>This event fires continuously as the user interacts with the color picker.</p>
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value"),
    @EventOptions.EventData(key = "formattedValue", exp = "event.target.getFormattedValue()")
  })
  public static class InputEvent extends ComponentEvent<ColorPicker> {
    public InputEvent(ColorPicker component, Map<String, Object> detail) {
      super(component, detail);
    }
    
    /**
     * Gets the color value in the current format.
     * 
     * @return the color value string
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
    
    /**
     * Gets the formatted color value.
     * 
     * @return the formatted color value string
     */
    public String getFormattedValue() {
      return (String) getEventMap().getOrDefault("formattedValue", "");
    }
  }
  
  /**
   * Event fired when form validation fails.
   */
  @EventName("sl-invalid")
  public static class InvalidEvent extends ComponentEvent<ColorPicker> {
    public InvalidEvent(ColorPicker component, Map<String, Object> detail) {
      super(component, detail);
    }
  }
}