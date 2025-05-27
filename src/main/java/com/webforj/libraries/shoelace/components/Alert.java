package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.event.ComponentEvent;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Alert displays an important, time-sensitive message.
 * 
 * <p>Alerts are used to display important messages inline or as toast notifications. 
 * They can be configured with different variants to indicate the nature of the message 
 * (e.g., success, warning, danger) and can include an optional close button.</p>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Multiple variants for different message types</li>
 *   <li>Optional close button</li>
 *   <li>Auto-dismiss with configurable duration</li>
 *   <li>Customizable icon slot</li>
 *   <li>Animation support for show/hide transitions</li>
 * </ul>
 * 
 * <h3>Example Usage:</h3>
 * <pre>{@code
 * // Basic alert
 * Alert alert = new Alert("Operation completed successfully!", Alert.Variant.SUCCESS);
 * 
 * // Closable alert with auto-dismiss
 * Alert notification = new Alert("This message will disappear in 5 seconds")
 *     .setClosable(true)
 *     .setDuration(5000)
 *     .setVariant(Alert.Variant.WARNING);
 * 
 * // Alert with custom icon
 * Alert infoAlert = new Alert("Information message")
 *     .setIcon(new Icon("info-circle"))
 *     .setVariant(Alert.Variant.NEUTRAL);
 * 
 * // With event handling
 * alert.onShow(event -> {
 *     System.out.println("Alert is now visible");
 * });
 * 
 * alert.onAfterHide(event -> {
 *     System.out.println("Alert has been completely hidden");
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/alert">Shoelace Alert Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/alert/alert.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-alert")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class Alert extends ElementComposite implements HasHtml<Alert>, HasStyle<Alert>, HasComponents {
  
  // ==================== Property Descriptors ====================
  
  /** Whether the alert is open/visible */
  private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);
  
  /** Whether the alert shows a close button */
  private final PropertyDescriptor<Boolean> closableProp = PropertyDescriptor.property("closable", false);
  
  /** The visual variant of the alert */
  private final PropertyDescriptor<String> variantProp = PropertyDescriptor.property("variant", "primary");
  
  /** Auto-close duration in milliseconds */
  private final PropertyDescriptor<Integer> durationProp = PropertyDescriptor.property("duration", null);
  
  // ==================== Enums ====================
  
  /**
   * Alert variants that determine the visual styling and semantic meaning.
   */
  public enum Variant {
    /** Primary variant for general information */
    PRIMARY("primary"),
    /** Success variant for positive messages */
    SUCCESS("success"),
    /** Neutral variant for neutral information */
    NEUTRAL("neutral"),
    /** Warning variant for caution messages */
    WARNING("warning"),
    /** Danger variant for error or critical messages */
    DANGER("danger");
    
    private final String value;
    
    Variant(String value) {
      this.value = value;
    }
    
    public String getValue() {
      return value;
    }
  }
  
  // ==================== Constructors ====================
  
  /**
   * Creates a new empty Alert component.
   */
  public Alert() {
    super();
  }
  
  /**
   * Creates a new Alert with the specified text content.
   * 
   * @param text the text content to display
   */
  public Alert(String text) {
    this();
    setHtml(text);
  }
  
  /**
   * Creates a new Alert with the specified text and variant.
   * 
   * @param text the text content to display
   * @param variant the visual variant
   */
  public Alert(String text, Variant variant) {
    this(text);
    setVariant(variant);
  }
  
  // ==================== Display Methods ====================
  
  /**
   * Shows the alert with animation.
   * 
   * <p>This is equivalent to calling {@code setOpen(true)}.</p>
   * 
   * @return this Alert instance for method chaining
   */
  public Alert show() {
    setOpen(true);
    return this;
  }
  
  /**
   * Hides the alert with animation.
   * 
   * <p>This is equivalent to calling {@code setOpen(false)}.</p>
   * 
   * @return this Alert instance for method chaining
   */
  public Alert hide() {
    setOpen(false);
    return this;
  }
  
  // ==================== Core Properties ====================
  
  /**
   * Sets whether the alert is open (visible).
   * 
   * @param open true to show the alert, false to hide it
   * @return this Alert instance for method chaining
   */
  public Alert setOpen(boolean open) {
    set(openProp, open);
    return this;
  }
  
  /**
   * Gets whether the alert is open (visible).
   * 
   * @return true if the alert is open
   */
  public boolean isOpen() {
    return get(openProp);
  }
  
  /**
   * Sets whether the alert shows a close button.
   * 
   * <p>When true, a close button appears that allows users to dismiss the alert.</p>
   * 
   * @param closable true to show close button
   * @return this Alert instance for method chaining
   */
  public Alert setClosable(boolean closable) {
    set(closableProp, closable);
    return this;
  }
  
  /**
   * Gets whether the alert shows a close button.
   * 
   * @return true if the alert is closable
   */
  public boolean isClosable() {
    return get(closableProp);
  }
  
  // ==================== Variant Properties ====================
  
  /**
   * Sets the alert variant using the enum.
   * 
   * @param variant the visual variant
   * @return this Alert instance for method chaining
   */
  public Alert setVariant(Variant variant) {
    set(variantProp, variant.getValue());
    return this;
  }
  
  /**
   * Sets the alert variant using a string value.
   * 
   * @param variant the variant name (primary, success, neutral, warning, danger)
   * @return this Alert instance for method chaining
   */
  public Alert setVariant(String variant) {
    set(variantProp, variant);
    return this;
  }
  
  /**
   * Gets the current alert variant.
   * 
   * @return the variant name
   */
  public String getVariant() {
    return get(variantProp);
  }
  
  // ==================== Duration Properties ====================
  
  /**
   * Sets the auto-close duration in milliseconds.
   * 
   * <p>If set, the alert will automatically close after the specified duration.
   * If not set or set to null, the alert will remain open until manually closed.</p>
   * 
   * @param duration the duration in milliseconds, or null to disable auto-close
   * @return this Alert instance for method chaining
   */
  public Alert setDuration(Integer duration) {
    set(durationProp, duration);
    return this;
  }
  
  /**
   * Gets the auto-close duration.
   * 
   * @return the duration in milliseconds, or null if auto-close is disabled
   */
  public Integer getDuration() {
    return get(durationProp);
  }
  
  // ==================== Slot Management ====================
  
  /**
   * Sets the icon slot content.
   * 
   * <p>The icon appears at the start of the alert.</p>
   * 
   * @param icon the component to use as the icon
   * @return this Alert instance for method chaining
   */
  public Alert setIcon(com.webforj.component.Component icon) {
    getBoundComponent().add("icon", icon);
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
   * Adds a listener for the show event.
   * 
   * <p>This event is fired when the alert begins to show (before animation completes).</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<ShowEvent> onShow(EventListener<ShowEvent> listener) {
    return addEventListener(ShowEvent.class, listener);
  }
  
  /**
   * Adds a listener for the after-show event.
   * 
   * <p>This event is fired after the alert is fully shown and all animations are complete.</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<AfterShowEvent> onAfterShow(EventListener<AfterShowEvent> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }
  
  /**
   * Adds a listener for the hide event.
   * 
   * <p>This event is fired when the alert begins to hide (before animation completes).</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<HideEvent> onHide(EventListener<HideEvent> listener) {
    return addEventListener(HideEvent.class, listener);
  }
  
  /**
   * Adds a listener for the after-hide event.
   * 
   * <p>This event is fired after the alert is fully hidden and all animations are complete.</p>
   * 
   * @param listener the event listener
   * @return a registration object for removing the listener
   */
  public ListenerRegistration<AfterHideEvent> onAfterHide(EventListener<AfterHideEvent> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }
  
  // ==================== Event Classes ====================
  
  /**
   * Event fired when the alert begins to show.
   */
  @EventName("sl-show")
  public static class ShowEvent extends ComponentEvent<Alert> {
    public ShowEvent(Alert source, Map<String, Object> detail) {
      super(source, detail);
    }
  }
  
  /**
   * Event fired after the alert is fully shown.
   */
  @EventName("sl-after-show")
  public static class AfterShowEvent extends ComponentEvent<Alert> {
    public AfterShowEvent(Alert source, Map<String, Object> detail) {
      super(source, detail);
    }
  }
  
  /**
   * Event fired when the alert begins to hide.
   */
  @EventName("sl-hide")
  public static class HideEvent extends ComponentEvent<Alert> {
    public HideEvent(Alert source, Map<String, Object> detail) {
      super(source, detail);
    }
  }
  
  /**
   * Event fired after the alert is fully hidden.
   */
  @EventName("sl-after-hide")
  public static class AfterHideEvent extends ComponentEvent<Alert> {
    public AfterHideEvent(Alert source, Map<String, Object> detail) {
      super(source, detail);
    }
  }
}