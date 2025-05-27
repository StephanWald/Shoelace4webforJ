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
 * Shoelace Dropdown component.
 * 
 * <p>Dropdowns expose additional content that "drops down" in a panel when the trigger is activated.
 * They're useful for navigation menus, select menus, and more. Dropdowns are designed to work well 
 * with <a href="https://shoelace.style/components/menu">menus</a> to provide a list of selectable options.
 * 
 * <p><strong>Basic Usage:</strong>
 * <pre>{@code
 * Dropdown dropdown = new Dropdown();
 * 
 * // Add trigger button
 * ShoelaceButton trigger = new ShoelaceButton("Dropdown");
 * trigger.getElement().setAttribute("slot", "trigger");
 * trigger.setCaret(true);
 * dropdown.add(trigger);
 * 
 * // Add menu content
 * Menu menu = new Menu();
 * menu.add(new MenuItem("Option 1"));
 * menu.add(new MenuItem("Option 2"));
 * menu.add(new MenuItem("Option 3"));
 * dropdown.add(menu);
 * }</pre>
 * 
 * <p><strong>With Placement and Distance:</strong>
 * <pre>{@code
 * Dropdown dropdown = new Dropdown()
 *     .setPlacement(Dropdown.Placement.TOP_START)
 *     .setDistance(10)
 *     .setSkidding(5);
 * }</pre>
 * 
 * <p><strong>Stay Open on Select:</strong>
 * <pre>{@code
 * Dropdown multiSelect = new Dropdown()
 *     .setStayOpenOnSelect(true);
 * 
 * Menu menu = new Menu();
 * // Add checkboxes in menu items for multi-select
 * menu.onSelect(event -> {
 *     // Handle selection without closing dropdown
 * });
 * multiSelect.add(menu);
 * }</pre>
 * 
 * <p><strong>Event Handling:</strong>
 * <pre>{@code
 * dropdown.onShow(event -> {
 *     System.out.println("Dropdown is opening");
 * });
 * 
 * dropdown.onAfterShow(event -> {
 *     System.out.println("Dropdown animation complete");
 * });
 * 
 * dropdown.onHide(event -> {
 *     System.out.println("Dropdown is closing");
 * });
 * }</pre>
 * 
 * <p><strong>Hoisting for Fixed Containers:</strong>
 * <pre>{@code
 * // Use hoist when dropdown is inside a container with overflow:hidden
 * Dropdown hoistedDropdown = new Dropdown()
 *     .setHoist(true);
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/dropdown">Shoelace Dropdown Documentation</a>
 * @see Menu
 * @see MenuItem
 * 
 * @author Hyyan Abo Fakher
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/dropdown/dropdown.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-dropdown")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Dropdown extends ElementComposite implements HasComponents {
  private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<String> placementProp = PropertyDescriptor.property("placement", "bottom-start");
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> stayOpenOnSelectProp = PropertyDescriptor.property("stay-open-on-select", false);
  private final PropertyDescriptor<Integer> distanceProp = PropertyDescriptor.property("distance", 0);
  private final PropertyDescriptor<Integer> skiddingProp = PropertyDescriptor.property("skidding", 0);
  private final PropertyDescriptor<Boolean> hoistProp = PropertyDescriptor.property("hoist", false);

  /**
   * Dropdown placement options
   */
  public enum Placement {
    TOP("top"),
    TOP_START("top-start"),
    TOP_END("top-end"),
    BOTTOM("bottom"),
    BOTTOM_START("bottom-start"),
    BOTTOM_END("bottom-end"),
    RIGHT("right"),
    RIGHT_START("right-start"),
    RIGHT_END("right-end"),
    LEFT("left"),
    LEFT_START("left-start"),
    LEFT_END("left-end");

    private final String value;

    Placement(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new Dropdown
   */
  public Dropdown() {
    super();
  }

  /**
   * Checks if the dropdown is open.
   *
   * @return true if open, false otherwise
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets the open state of the dropdown.
   *
   * @param open true to open, false to close
   * @return this instance
   */
  public Dropdown setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the placement of the dropdown.
   *
   * @return the placement value
   */
  public String getPlacement() {
    return get(placementProp);
  }

  /**
   * Sets the placement of the dropdown relative to the trigger.
   *
   * @param placement the placement option
   * @return this instance
   */
  public Dropdown setPlacement(Placement placement) {
    set(placementProp, placement.getValue());
    return this;
  }

  /**
   * Sets the placement of the dropdown using a string value.
   *
   * @param placement the placement string
   * @return this instance
   */
  public Dropdown setPlacement(String placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Checks if the dropdown is disabled.
   *
   * @return true if disabled, false otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets the disabled state of the dropdown. When disabled, the dropdown cannot be opened.
   *
   * @param disabled true to disable
   * @return this instance
   */
  public Dropdown setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Checks if the dropdown stays open when a menu item is selected.
   *
   * @return true if stays open on select
   */
  public boolean isStayOpenOnSelect() {
    return get(stayOpenOnSelectProp);
  }

  /**
   * Sets whether the dropdown should remain open when a menu item is selected.
   * Useful for multi-select scenarios.
   *
   * @param stayOpen true to stay open on select
   * @return this instance
   */
  public Dropdown setStayOpenOnSelect(boolean stayOpen) {
    set(stayOpenOnSelectProp, stayOpen);
    return this;
  }

  /**
   * Gets the distance offset from the trigger.
   *
   * @return the distance in pixels
   */
  public Integer getDistance() {
    return get(distanceProp);
  }

  /**
   * Sets the distance the dropdown should appear from the trigger element.
   *
   * @param distance the distance in pixels
   * @return this instance
   */
  public Dropdown setDistance(int distance) {
    set(distanceProp, distance);
    return this;
  }

  /**
   * Gets the skidding offset.
   *
   * @return the skidding in pixels
   */
  public Integer getSkidding() {
    return get(skiddingProp);
  }

  /**
   * Sets the lateral offset (skidding) of the dropdown along the trigger element.
   *
   * @param skidding the skidding in pixels
   * @return this instance
   */
  public Dropdown setSkidding(int skidding) {
    set(skiddingProp, skidding);
    return this;
  }

  /**
   * Checks if hoisting is enabled.
   *
   * @return true if hoisting is enabled
   */
  public boolean isHoist() {
    return get(hoistProp);
  }

  /**
   * Sets whether the dropdown should be hoisted to the body. This is useful when
   * the dropdown is inside a container with overflow: hidden.
   *
   * @param hoist true to hoist to body
   * @return this instance
   */
  public Dropdown setHoist(boolean hoist) {
    set(hoistProp, hoist);
    return this;
  }

  /**
   * Shows the dropdown.
   * 
   * @return this instance
   */
  public Dropdown show() {
    setOpen(true);
    return this;
  }

  /**
   * Hides the dropdown.
   * 
   * @return this instance
   */
  public Dropdown hide() {
    setOpen(false);
    return this;
  }

  /**
   * Toggles the dropdown between open and closed states.
   * 
   * @return this instance
   */
  public Dropdown toggle() {
    setOpen(!isOpen());
    return this;
  }

  /**
   * Add a listener for the show event.
   * 
   * <p>Fired when the dropdown opens.
   *
   * @param listener the show event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<ShowEvent> onShow(EventListener<ShowEvent> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Add a listener for the after-show event.
   * 
   * <p>Fired after the dropdown opens and all animations are complete.
   *
   * @param listener the after-show event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<AfterShowEvent> onAfterShow(EventListener<AfterShowEvent> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Add a listener for the hide event.
   * 
   * <p>Fired when the dropdown closes.
   *
   * @param listener the hide event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<HideEvent> onHide(EventListener<HideEvent> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Add a listener for the after-hide event.
   * 
   * <p>Fired after the dropdown closes and all animations are complete.
   *
   * @param listener the after-hide event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<AfterHideEvent> onAfterHide(EventListener<AfterHideEvent> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Show event dispatched when the dropdown opens.
   */
  @EventName("sl-show")
  public static class ShowEvent extends ComponentEvent<Dropdown> {
    /**
     * Creates a new show event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public ShowEvent(Dropdown component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-show event dispatched after the dropdown opens and animations complete.
   */
  @EventName("sl-after-show")
  public static class AfterShowEvent extends ComponentEvent<Dropdown> {
    /**
     * Creates a new after-show event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public AfterShowEvent(Dropdown component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Hide event dispatched when the dropdown closes.
   */
  @EventName("sl-hide")
  public static class HideEvent extends ComponentEvent<Dropdown> {
    /**
     * Creates a new hide event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public HideEvent(Dropdown component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-hide event dispatched after the dropdown closes and animations complete.
   */
  @EventName("sl-after-hide")
  public static class AfterHideEvent extends ComponentEvent<Dropdown> {
    /**
     * Creates a new after-hide event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public AfterHideEvent(Dropdown component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
}