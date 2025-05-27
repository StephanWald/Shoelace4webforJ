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
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Buttons represent actions that are available to the user.
 * 
 * <p>Buttons are one of the most common interactive elements in web applications. 
 * They can be styled with different variants, sizes, and states to communicate 
 * their purpose and importance to users.</p>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Multiple variants for different contexts</li>
 *   <li>Size options (small, medium, large)</li>
 *   <li>Loading and disabled states</li>
 *   <li>Link button functionality with href</li>
 *   <li>Icon support via prefix/suffix slots</li>
 *   <li>Outline, pill, and circle styles</li>
 *   <li>Form integration support</li>
 * </ul>
 * 
 * <h3>Example Usage:</h3>
 * <pre>{@code
 * // Basic button
 * ShoelaceButton button = new ShoelaceButton("Click Me", ShoelaceButton.Variant.PRIMARY);
 * 
 * // Button with icon
 * ShoelaceButton saveButton = new ShoelaceButton("Save")
 *     .setVariant(ShoelaceButton.Variant.SUCCESS)
 *     .setPrefix(new Icon("save"));
 * 
 * // Loading button
 * ShoelaceButton submitButton = new ShoelaceButton("Submit")
 *     .setLoading(true)
 *     .setDisabled(true);
 * 
 * // Link button
 * ShoelaceButton linkButton = new ShoelaceButton("Visit Site")
 *     .setHref("https://example.com")
 *     .setTarget("_blank");
 * 
 * // With event handling
 * button.onClick(event -> {
 *     System.out.println("Button clicked at: " + event.getClientX() + ", " + event.getClientY());
 * });
 * 
 * button.onFocus(event -> {
 *     System.out.println("Button received focus");
 * });
 * }</pre>
 *
 * @see <a href="https://shoelace.style/components/button">Shoelace Button Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/button/button.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-button")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class ShoelaceButton extends ElementComposite implements HasHtml<ShoelaceButton>, HasStyle<ShoelaceButton>, HasComponents {

  // ==================== Property Descriptors ====================
  
  /** The visual variant of the button */
  private final PropertyDescriptor<String> variantProp = PropertyDescriptor.property("variant", "default");
  
  /** The size of the button */
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  
  /** Whether the button has outline style */
  private final PropertyDescriptor<Boolean> outlineProp = PropertyDescriptor.property("outline", false);
  
  /** Whether the button has pill shape */
  private final PropertyDescriptor<Boolean> pillProp = PropertyDescriptor.property("pill", false);
  
  /** Whether the button is circular */
  private final PropertyDescriptor<Boolean> circleProp = PropertyDescriptor.property("circle", false);
  
  /** Whether the button shows a caret */
  private final PropertyDescriptor<Boolean> caretProp = PropertyDescriptor.property("caret", false);
  
  /** Whether the button is in loading state */
  private final PropertyDescriptor<Boolean> loadingProp = PropertyDescriptor.property("loading", false);
  
  /** Whether the button is disabled */
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  
  /** The button type for forms */
  private final PropertyDescriptor<String> typeProp = PropertyDescriptor.property("type", "button");
  
  /** The button name for form submission */
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  
  /** The button value for form submission */
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  
  /** The href for link buttons */
  private final PropertyDescriptor<String> hrefProp = PropertyDescriptor.property("href", "");
  
  /** The target for link buttons */
  private final PropertyDescriptor<String> targetProp = PropertyDescriptor.property("target", "");
  
  /** The download attribute for link buttons */
  private final PropertyDescriptor<String> downloadProp = PropertyDescriptor.property("download", "");

  // ==================== Enums ====================

  /**
   * Button variants that determine the visual styling.
   */
  public enum Variant {
    /** Default button style */
    DEFAULT("default"),
    /** Primary action button */
    PRIMARY("primary"),
    /** Success/positive action button */
    SUCCESS("success"),
    /** Neutral button style */
    NEUTRAL("neutral"),
    /** Warning action button */
    WARNING("warning"),
    /** Danger/destructive action button */
    DANGER("danger"),
    /** Text-only button style */
    TEXT("text");

    private final String value;

    Variant(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Button size options.
   */
  public enum Size {
    /** Small button size */
    SMALL("small"),
    /** Medium button size (default) */
    MEDIUM("medium"),
    /** Large button size */
    LARGE("large");

    private final String value;

    Size(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  // ==================== Constructors ====================

  /**
   * Creates a new empty Button component.
   */
  public ShoelaceButton() {
    super();
  }

  /**
   * Creates a new Button with the specified text.
   * 
   * @param text the button text
   */
  public ShoelaceButton(String text) {
    this();
    setHtml(text);
  }

  /**
   * Creates a new Button with the specified text and variant.
   * 
   * @param text the button text
   * @param variant the visual variant
   */
  public ShoelaceButton(String text, Variant variant) {
    this(text);
    setVariant(variant);
  }

  // ==================== Variant Properties ====================

  /**
   * Sets the button variant using the enum.
   * 
   * @param variant the visual variant
   * @return this button instance for method chaining
   */
  public ShoelaceButton setVariant(Variant variant) {
    set(variantProp, variant.getValue());
    return this;
  }

  /**
   * Sets the button variant using a string value.
   * 
   * @param variant the variant name
   * @return this button instance for method chaining
   */
  public ShoelaceButton setVariant(String variant) {
    set(variantProp, variant);
    return this;
  }

  /**
   * Gets the current button variant.
   * 
   * @return the variant name
   */
  public String getVariant() {
    return get(variantProp);
  }

  // ==================== Size Properties ====================

  /**
   * Sets the button size using the enum.
   * 
   * @param size the button size
   * @return this button instance for method chaining
   */
  public ShoelaceButton setSize(Size size) {
    set(sizeProp, size.getValue());
    return this;
  }

  /**
   * Sets the button size using a string value.
   * 
   * @param size the size name
   * @return this button instance for method chaining
   */
  public ShoelaceButton setSize(String size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Gets the current button size.
   * 
   * @return the size name
   */
  public String getSize() {
    return get(sizeProp);
  }

  // ==================== Style Properties ====================

  /**
   * Sets whether the button has an outline style.
   * 
   * @param outline true for outline style
   * @return this button instance for method chaining
   */
  public ShoelaceButton setOutline(boolean outline) {
    set(outlineProp, outline);
    return this;
  }

  /**
   * Gets whether the button has an outline style.
   * 
   * @return true if outline style is enabled
   */
  public boolean isOutline() {
    return get(outlineProp);
  }

  /**
   * Sets whether the button has a pill shape (rounded ends).
   * 
   * @param pill true for pill shape
   * @return this button instance for method chaining
   */
  public ShoelaceButton setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Gets whether the button has a pill shape.
   * 
   * @return true if pill shape is enabled
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Sets whether the button is circular.
   * 
   * <p>Circular buttons work best with icons and no text.</p>
   * 
   * @param circle true for circular shape
   * @return this button instance for method chaining
   */
  public ShoelaceButton setCircle(boolean circle) {
    set(circleProp, circle);
    return this;
  }

  /**
   * Gets whether the button is circular.
   * 
   * @return true if circular shape is enabled
   */
  public boolean isCircle() {
    return get(circleProp);
  }

  /**
   * Sets whether the button displays a caret (dropdown arrow).
   * 
   * @param caret true to show caret
   * @return this button instance for method chaining
   */
  public ShoelaceButton setCaret(boolean caret) {
    set(caretProp, caret);
    return this;
  }

  /**
   * Gets whether the button displays a caret.
   * 
   * @return true if caret is shown
   */
  public boolean hasCaret() {
    return get(caretProp);
  }

  // ==================== State Properties ====================

  /**
   * Sets whether the button is in loading state.
   * 
   * <p>Loading buttons show a spinner and are non-interactive.</p>
   * 
   * @param loading true for loading state
   * @return this button instance for method chaining
   */
  public ShoelaceButton setLoading(boolean loading) {
    set(loadingProp, loading);
    return this;
  }

  /**
   * Gets whether the button is in loading state.
   * 
   * @return true if loading
   */
  public boolean isLoading() {
    return get(loadingProp);
  }

  /**
   * Sets whether the button is disabled.
   * 
   * @param disabled true to disable the button
   * @return this button instance for method chaining
   */
  public ShoelaceButton setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets whether the button is disabled.
   * 
   * @return true if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  // ==================== Form Properties ====================

  /**
   * Sets the button type for form submission.
   * 
   * @param type the button type (button, submit, reset)
   * @return this button instance for method chaining
   */
  public ShoelaceButton setType(String type) {
    set(typeProp, type);
    return this;
  }

  /**
   * Gets the button type.
   * 
   * @return the button type
   */
  public String getType() {
    return get(typeProp);
  }

  /**
   * Sets the button name for form submission.
   * 
   * @param name the button name
   * @return this button instance for method chaining
   */
  public ShoelaceButton setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Gets the button name.
   * 
   * @return the button name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the button value for form submission.
   * 
   * @param value the button value
   * @return this button instance for method chaining
   */
  public ShoelaceButton setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Gets the button value.
   * 
   * @return the button value
   */
  public String getValue() {
    return get(valueProp);
  }

  // ==================== Link Properties ====================

  /**
   * Sets the href for link buttons.
   * 
   * <p>When set, the button behaves as a link.</p>
   * 
   * @param href the URL to navigate to
   * @return this button instance for method chaining
   */
  public ShoelaceButton setHref(String href) {
    set(hrefProp, href);
    return this;
  }

  /**
   * Gets the href.
   * 
   * @return the href URL
   */
  public String getHref() {
    return get(hrefProp);
  }

  /**
   * Sets the target for link buttons.
   * 
   * @param target the target (_blank, _self, _parent, _top, or frame name)
   * @return this button instance for method chaining
   */
  public ShoelaceButton setTarget(String target) {
    set(targetProp, target);
    return this;
  }

  /**
   * Gets the target.
   * 
   * @return the target value
   */
  public String getTarget() {
    return get(targetProp);
  }

  /**
   * Sets the download attribute for link buttons.
   * 
   * <p>Suggests a filename when downloading the linked resource.</p>
   * 
   * @param download the suggested filename
   * @return this button instance for method chaining
   */
  public ShoelaceButton setDownload(String download) {
    set(downloadProp, download);
    return this;
  }

  /**
   * Gets the download attribute.
   * 
   * @return the download filename
   */
  public String getDownload() {
    return get(downloadProp);
  }

  // ==================== Slot Management ====================

  /**
   * Sets the prefix slot content.
   * 
   * <p>Typically used for icons before the button text.</p>
   * 
   * @param prefix the component to use as prefix
   * @return this button instance for method chaining
   */
  public ShoelaceButton setPrefix(com.webforj.component.Component prefix) {
    getBoundComponent().add("prefix", prefix);
    return this;
  }

  /**
   * Sets the suffix slot content.
   * 
   * <p>Typically used for icons after the button text.</p>
   * 
   * @param suffix the component to use as suffix
   * @return this button instance for method chaining
   */
  public ShoelaceButton setSuffix(com.webforj.component.Component suffix) {
    getBoundComponent().add("suffix", suffix);
    return this;
  }

  // ==================== HasComponents Implementation ====================

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }

  // ==================== Event Handling ====================

  /**
   * Adds a click event listener to the button.
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<ClickEvent> onClick(EventListener<ClickEvent> listener) {
    return addEventListener(ClickEvent.class, listener);
  }

  /**
   * Adds a double-click event listener to the button.
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<DoubleClickEvent> onDoubleClick(EventListener<DoubleClickEvent> listener) {
    return addEventListener(DoubleClickEvent.class, listener);
  }

  /**
   * Adds a focus event listener to the button.
   * 
   * <p>This Shoelace-specific event is fired when the button receives focus.</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<FocusEvent> onFocus(EventListener<FocusEvent> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Adds a blur event listener to the button.
   * 
   * <p>This Shoelace-specific event is fired when the button loses focus.</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<BlurEvent> onBlur(EventListener<BlurEvent> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Adds an invalid event listener to the button.
   * 
   * <p>This event is fired when the button's form validation fails.</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<InvalidEvent> onInvalid(EventListener<InvalidEvent> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Adds a mouse enter event listener to the button.
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<MouseEnterEvent> onMouseEnter(EventListener<MouseEnterEvent> listener) {
    return addEventListener(MouseEnterEvent.class, listener);
  }

  /**
   * Adds a mouse leave event listener to the button.
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<MouseLeaveEvent> onMouseLeave(EventListener<MouseLeaveEvent> listener) {
    return addEventListener(MouseLeaveEvent.class, listener);
  }

  // ==================== Event Classes ====================

  /**
   * Event fired when the button is clicked.
   */
  @EventName("click")
  @EventOptions(data = { 
    @EventOptions.EventData(key = "clientX", exp = "event.clientX"),
    @EventOptions.EventData(key = "clientY", exp = "event.clientY")
  })
  public static class ClickEvent extends ComponentEvent<ShoelaceButton> {
    public ClickEvent(ShoelaceButton source, Map<String, Object> detail) {
      super(source, detail);
    }

    /**
     * Gets the X coordinate of the mouse pointer.
     * @return the X coordinate
     */
    public int getClientX() {
      return ((Number) getData().get("clientX")).intValue();
    }

    /**
     * Gets the Y coordinate of the mouse pointer.
     * @return the Y coordinate
     */
    public int getClientY() {
      return ((Number) getData().get("clientY")).intValue();
    }
  }

  /**
   * Event fired when the button is double-clicked.
   */
  @EventName("dblclick")
  @EventOptions(data = { 
    @EventOptions.EventData(key = "clientX", exp = "event.clientX"),
    @EventOptions.EventData(key = "clientY", exp = "event.clientY")
  })
  public static class DoubleClickEvent extends ComponentEvent<ShoelaceButton> {
    public DoubleClickEvent(ShoelaceButton source, Map<String, Object> detail) {
      super(source, detail);
    }

    /**
     * Gets the X coordinate of the mouse pointer.
     * @return the X coordinate
     */
    public int getClientX() {
      return ((Number) getData().get("clientX")).intValue();
    }

    /**
     * Gets the Y coordinate of the mouse pointer.
     * @return the Y coordinate
     */
    public int getClientY() {
      return ((Number) getData().get("clientY")).intValue();
    }
  }

  /**
   * Shoelace-specific focus event.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<ShoelaceButton> {
    public FocusEvent(ShoelaceButton source, Map<String, Object> detail) {
      super(source, detail);
    }
  }

  /**
   * Shoelace-specific blur event.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<ShoelaceButton> {
    public BlurEvent(ShoelaceButton source, Map<String, Object> detail) {
      super(source, detail);
    }
  }

  /**
   * Event fired when form validation fails.
   */
  @EventName("sl-invalid")
  public static class InvalidEvent extends ComponentEvent<ShoelaceButton> {
    public InvalidEvent(ShoelaceButton source, Map<String, Object> detail) {
      super(source, detail);
    }
  }

  /**
   * Event fired when mouse enters the button.
   */
  @EventName("mouseenter")
  public static class MouseEnterEvent extends ComponentEvent<ShoelaceButton> {
    public MouseEnterEvent(ShoelaceButton source, Map<String, Object> detail) {
      super(source, detail);
    }
  }

  /**
   * Event fired when mouse leaves the button.
   */
  @EventName("mouseleave")
  public static class MouseLeaveEvent extends ComponentEvent<ShoelaceButton> {
    public MouseLeaveEvent(ShoelaceButton source, Map<String, Object> detail) {
      super(source, detail);
    }
  }
}