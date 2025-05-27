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
 * Shoelace Rating component for star ratings and feedback.
 * 
 * <p>The Rating component allows users to rate something using a star-based
 * or custom symbol interface. It supports fractional ratings, read-only mode,
 * and extensive customization options.
 * 
 * <p>Example usage:
 * <pre>{@code
 * Rating productRating = new Rating(4.5);
 * productRating.setLabel("Product Rating");
 * productRating.enableHalfStars();
 * 
 * productRating.onChange(event -> {
 *   System.out.println("New rating: " + event.getValue());
 * });
 * 
 * productRating.onHover(event -> {
 *   System.out.println("Hovering over: " + event.getValue());
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/rating">Shoelace Rating Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/rating/rating.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-rating")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Rating extends ElementComposite implements HasComponents, HasStyle<Rating> {
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<Double> valueProp = PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<Integer> maxProp = PropertyDescriptor.property("max", 5);
  private final PropertyDescriptor<Double> precisionProp = PropertyDescriptor.property("precision", 1.0);
  private final PropertyDescriptor<Boolean> readonlyProp = PropertyDescriptor.property("readonly", false);
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<String> getSymbolProp = PropertyDescriptor.property("get-symbol", null);

  /**
   * Create a new Rating component.
   */
  public Rating() {
    super();
  }

  /**
   * Create a new Rating with initial value.
   *
   * @param value the initial rating value
   */
  public Rating(double value) {
    super();
    setValue(value);
  }

  /**
   * Create a new Rating with value and max.
   *
   * @param value the initial rating value
   * @param max the maximum rating value (number of stars)
   */
  public Rating(double value, int max) {
    super();
    setValue(value);
    setMax(max);
  }

  /**
   * Get the accessibility label.
   *
   * @return the label text
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Set the accessibility label.
   *
   * @param label the label text for screen readers
   * @return this instance for method chaining
   */
  public Rating setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Get the current rating value.
   *
   * @return the rating value
   */
  public double getValue() {
    return get(valueProp);
  }

  /**
   * Set the rating value.
   *
   * @param value the rating value (0 to max)
   * @return this instance for method chaining
   */
  public Rating setValue(double value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Get the maximum rating value.
   *
   * @return the maximum number of symbols
   */
  public int getMax() {
    return get(maxProp);
  }

  /**
   * Set the maximum rating value.
   *
   * @param max the maximum number of symbols
   * @return this instance for method chaining
   */
  public Rating setMax(int max) {
    set(maxProp, max);
    return this;
  }

  /**
   * Get the rating precision.
   *
   * @return the precision value
   */
  public double getPrecision() {
    return get(precisionProp);
  }

  /**
   * Set the rating precision for fractional ratings.
   *
   * @param precision the precision (e.g., 0.5 for half stars, 0.25 for quarter stars)
   * @return this instance for method chaining
   */
  public Rating setPrecision(double precision) {
    set(precisionProp, precision);
    return this;
  }

  /**
   * Check if the rating is readonly.
   *
   * @return true if readonly, false otherwise
   */
  public boolean isReadonly() {
    return get(readonlyProp);
  }

  /**
   * Set the readonly state.
   * 
   * <p>Readonly ratings can be focused but not changed by the user.
   *
   * @param readonly true for readonly, false otherwise
   * @return this instance for method chaining
   */
  public Rating setReadonly(boolean readonly) {
    set(readonlyProp, readonly);
    return this;
  }

  /**
   * Check if the rating is disabled.
   *
   * @return true if disabled, false otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Set the disabled state.
   * 
   * <p>Disabled ratings cannot be interacted with.
   *
   * @param disabled true to disable, false to enable
   * @return this instance for method chaining
   */
  public Rating setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Focus the rating
   */
  public void focus() {
    // Note: Would need JavaScript interop
  }

  /**
   * Blur the rating
   */
  public void blur() {
    // Note: Would need JavaScript interop
  }

  /**
   * Enable half-star ratings.
   *
   * @return this instance for method chaining
   */
  public Rating enableHalfStars() {
    setPrecision(0.5);
    return this;
  }

  /**
   * Enable quarter-star ratings.
   *
   * @return this instance for method chaining
   */
  public Rating enableQuarterStars() {
    setPrecision(0.25);
    return this;
  }

  /**
   * Set custom CSS properties for styling.
   *
   * @param symbolColor the color of inactive symbols
   * @param symbolColorActive the color of active symbols
   * @param symbolSize the size of symbols
   * @param symbolSpacing the spacing between symbols
   * @return this instance for method chaining
   */
  public Rating setCustomStyle(String symbolColor, String symbolColorActive, String symbolSize, String symbolSpacing) {
    if (symbolColor != null) {
      setStyle("--symbol-color", symbolColor);
    }
    if (symbolColorActive != null) {
      setStyle("--symbol-color-active", symbolColorActive);
    }
    if (symbolSize != null) {
      setStyle("--symbol-size", symbolSize);
    }
    if (symbolSpacing != null) {
      setStyle("--symbol-spacing", symbolSpacing);
    }
    return this;
  }

  /**
   * Add a listener for the change event.
   * 
   * <p>Fired when the rating value changes.
   *
   * @param listener the change event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<ChangeEvent> onChange(EventListener<ChangeEvent> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Add a listener for the hover event.
   * 
   * <p>Fired when hovering over a rating value.
   *
   * @param listener the hover event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<HoverEvent> onHover(EventListener<HoverEvent> listener) {
    return addEventListener(HoverEvent.class, listener);
  }

  /**
   * Change event fired when the rating changes.
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class ChangeEvent extends ComponentEvent<Rating> {
    public ChangeEvent(Rating component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the new rating value.
     *
     * @return the rating value
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
   * Hover event fired when hovering over a rating value.
   */
  @EventName("sl-hover")
  @EventOptions(data = {
    @EventOptions.EventData(key = "phase", exp = "event.detail.phase"),
    @EventOptions.EventData(key = "value", exp = "event.detail.value")
  })
  public static class HoverEvent extends ComponentEvent<Rating> {
    public HoverEvent(Rating component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the hover phase ("start" or "end").
     *
     * @return the hover phase
     */
    public String getPhase() {
      return (String) getEventMap().getOrDefault("phase", "");
    }

    /**
     * Get the value being hovered over.
     *
     * @return the hover value
     */
    public double getValue() {
      Object value = getEventMap().getOrDefault("value", 0.0);
      if (value instanceof Number) {
        return ((Number) value).doubleValue();
      }
      return Double.parseDouble(value.toString());
    }

    /**
     * Check if hover is starting.
     *
     * @return true if hover is starting
     */
    public boolean isHoverStart() {
      return "start".equals(getPhase());
    }

    /**
     * Check if hover is ending.
     *
     * @return true if hover is ending
     */
    public boolean isHoverEnd() {
      return "end".equals(getPhase());
    }
  }

  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
}