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
 * Shoelace Details component.
 * 
 * <p>Details show a brief summary and expand to reveal additional content.
 * They provide an interactive disclosure widget in which information is visible only 
 * when the widget is toggled into an "open" state.
 * 
 * <p><strong>Basic Usage:</strong>
 * <pre>{@code
 * Details details = new Details("Toggle for more options");
 * details.add(new Paragraph("This is the content that will be shown when expanded."));
 * }</pre>
 * 
 * <p><strong>Disabled State:</strong>
 * <pre>{@code
 * Details details = new Details("Unavailable Options");
 * details.setDisabled(true);
 * details.add(new Paragraph("This content cannot be accessed."));
 * }</pre>
 * 
 * <p><strong>Programmatic Control:</strong>
 * <pre>{@code
 * Details details = new Details("Advanced Settings");
 * 
 * // Open programmatically
 * details.show();
 * 
 * // Close programmatically
 * details.hide();
 * 
 * // Toggle state
 * details.toggle();
 * }</pre>
 * 
 * <p><strong>Event Handling:</strong>
 * <pre>{@code
 * details.onShow(event -> {
 *     System.out.println("Details are opening");
 * });
 * 
 * details.onAfterShow(event -> {
 *     System.out.println("Details are fully opened");
 * });
 * 
 * details.onHide(event -> {
 *     System.out.println("Details are closing");
 * });
 * 
 * details.onAfterHide(event -> {
 *     System.out.println("Details are fully closed");
 * });
 * }</pre>
 * 
 * <p><strong>Custom Icons:</strong>
 * <pre>{@code
 * Details details = new Details("Custom Expand/Collapse Icons");
 * 
 * // Add custom icons to expand/collapse slots
 * Icon expandIcon = new Icon("chevron-right");
 * Icon collapseIcon = new Icon("chevron-down");
 * 
 * details.getBoundComponent().add("expand-icon", expandIcon);
 * details.getBoundComponent().add("collapse-icon", collapseIcon);
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/details">Shoelace Details Documentation</a>
 * 
 * @author Hyyan Abo Fakher
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/details/details.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-details")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Details extends ElementComposite implements HasComponents {
  private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<String> summaryProp = PropertyDescriptor.property("summary", "");
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new Details component.
   */
  public Details() {
    super();
  }

  /**
   * Creates a new Details component with the specified summary.
   *
   * @param summary the summary text
   */
  public Details(String summary) {
    super();
    setSummary(summary);
  }

  /**
   * Creates a new Details component with summary and open state.
   *
   * @param summary the summary text
   * @param open whether the details are open
   */
  public Details(String summary, boolean open) {
    super();
    setSummary(summary);
    setOpen(open);
  }

  /**
   * Checks if the details are open.
   *
   * @return true if open, false otherwise
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets the open state of the details.
   *
   * @param open true to open, false to close
   * @return this instance
   */
  public Details setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the summary text.
   *
   * @return the summary text
   */
  public String getSummary() {
    return get(summaryProp);
  }

  /**
   * Sets the summary text displayed in the header.
   *
   * @param summary the summary text
   * @return this instance
   */
  public Details setSummary(String summary) {
    set(summaryProp, summary);
    return this;
  }

  /**
   * Checks if the details are disabled.
   *
   * @return true if disabled, false otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets the disabled state. When disabled, the details cannot be toggled.
   *
   * @param disabled true to disable, false to enable
   * @return this instance
   */
  public Details setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Shows the details by expanding them.
   * 
   * @return this instance
   */
  public Details show() {
    setOpen(true);
    return this;
  }

  /**
   * Hides the details by collapsing them.
   * 
   * @return this instance
   */
  public Details hide() {
    setOpen(false);
    return this;
  }

  /**
   * Toggles the details between open and closed states.
   * 
   * @return this instance
   */
  public Details toggle() {
    setOpen(!isOpen());
    return this;
  }

  /**
   * Add a listener for the show event.
   * 
   * <p>Fired when the details open.
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
   * <p>Fired after the details open and all animations are complete.
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
   * <p>Fired when the details close.
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
   * <p>Fired after the details close and all animations are complete.
   *
   * @param listener the after-hide event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<AfterHideEvent> onAfterHide(EventListener<AfterHideEvent> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Show event dispatched when the details open.
   */
  @EventName("sl-show")
  public static class ShowEvent extends ComponentEvent<Details> {
    /**
     * Creates a new show event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public ShowEvent(Details component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-show event dispatched after the details open and animations complete.
   */
  @EventName("sl-after-show")
  public static class AfterShowEvent extends ComponentEvent<Details> {
    /**
     * Creates a new after-show event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public AfterShowEvent(Details component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Hide event dispatched when the details close.
   */
  @EventName("sl-hide")
  public static class HideEvent extends ComponentEvent<Details> {
    /**
     * Creates a new hide event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public HideEvent(Details component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-hide event dispatched after the details close and animations complete.
   */
  @EventName("sl-after-hide")
  public static class AfterHideEvent extends ComponentEvent<Details> {
    /**
     * Creates a new after-hide event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public AfterHideEvent(Details component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
}