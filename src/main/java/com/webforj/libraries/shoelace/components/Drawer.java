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
 * Shoelace Drawer component.
 * 
 * <p>Drawers slide in from a container's edge to overlay content. They are commonly used for navigation,
 * forms, and supplementary content that needs to be accessed temporarily without leaving the current page.
 * 
 * <p><strong>Basic Usage:</strong>
 * <pre>{@code
 * Drawer drawer = new Drawer("Settings");
 * drawer.add(new Paragraph("Configure your preferences here"));
 * drawer.show();
 * }</pre>
 * 
 * <p><strong>With Different Placements:</strong>
 * <pre>{@code
 * // Left drawer for navigation
 * Drawer navDrawer = new Drawer("Navigation", Drawer.Placement.START);
 * navDrawer.add(navigationMenu);
 * 
 * // Bottom drawer for actions
 * Drawer actionsDrawer = new Drawer("Actions", Drawer.Placement.BOTTOM);
 * actionsDrawer.setSize("300px");
 * }</pre>
 * 
 * <p><strong>Contained Drawer:</strong>
 * <pre>{@code
 * // Drawer contained within a parent element
 * Drawer containedDrawer = new Drawer("Filters");
 * containedDrawer.setContained(true);
 * containedDrawer.setPlacement(Drawer.Placement.END);
 * parentContainer.add(containedDrawer);
 * }</pre>
 * 
 * <p><strong>Event Handling:</strong>
 * <pre>{@code
 * drawer.onShow(event -> {
 *     System.out.println("Drawer is opening");
 * });
 * 
 * drawer.onRequestClose(event -> {
 *     // Prevent closing under certain conditions
 *     if (!canClose()) {
 *         event.preventDefault();
 *     }
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/drawer">Shoelace Drawer Documentation</a>
 * 
 * @author Hyyan Abo Fakher
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/drawer/drawer.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-drawer")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Drawer extends ElementComposite implements HasComponents, HasStyle<Drawer> {
  private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> placementProp = PropertyDescriptor.property("placement", "end");
  private final PropertyDescriptor<Boolean> containedProp = PropertyDescriptor.property("contained", false);
  private final PropertyDescriptor<Boolean> noHeaderProp = PropertyDescriptor.property("no-header", false);

  /**
   * Drawer placement options
   */
  public enum Placement {
    TOP("top"),
    END("end"),
    BOTTOM("bottom"),
    START("start");

    private final String value;

    Placement(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Creates a new Drawer component.
   */
  public Drawer() {
    super();
  }

  /**
   * Creates a new Drawer with the specified label.
   *
   * @param label the drawer label/title
   */
  public Drawer(String label) {
    super();
    setLabel(label);
  }

  /**
   * Creates a new Drawer with label and placement.
   *
   * @param label the drawer label/title
   * @param placement the drawer placement
   */
  public Drawer(String label, Placement placement) {
    super();
    setLabel(label);
    setPlacement(placement);
  }

  /**
   * Checks if the drawer is open.
   *
   * @return true if open, false otherwise
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets the open state of the drawer.
   *
   * @param open true to open, false to close
   * @return this instance
   */
  public Drawer setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the drawer label/title.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the drawer label/title.
   *
   * @param label the label to display
   * @return this instance
   */
  public Drawer setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Gets the drawer placement.
   *
   * @return the placement
   */
  public String getPlacement() {
    return get(placementProp);
  }

  /**
   * Sets the drawer placement.
   *
   * @param placement the placement
   * @return this instance
   */
  public Drawer setPlacement(Placement placement) {
    set(placementProp, placement.getValue());
    return this;
  }

  /**
   * Sets the drawer placement with string value.
   *
   * @param placement the placement ("top", "end", "bottom", "start")
   * @return this instance
   */
  public Drawer setPlacement(String placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Checks if the drawer is contained within its parent.
   *
   * @return true if contained
   */
  public boolean isContained() {
    return get(containedProp);
  }

  /**
   * Sets whether the drawer is contained within its parent.
   *
   * @param contained true to contain within parent
   * @return this instance
   */
  public Drawer setContained(boolean contained) {
    set(containedProp, contained);
    return this;
  }

  /**
   * Checks if the header is hidden.
   *
   * @return true if header is hidden
   */
  public boolean isNoHeader() {
    return get(noHeaderProp);
  }

  /**
   * Sets whether to hide the header.
   *
   * @param noHeader true to hide header
   * @return this instance
   */
  public Drawer setNoHeader(boolean noHeader) {
    set(noHeaderProp, noHeader);
    return this;
  }

  /**
   * Shows the drawer.
   * 
   * @return this instance
   */
  public Drawer show() {
    setOpen(true);
    return this;
  }

  /**
   * Hides the drawer.
   * 
   * @return this instance
   */
  public Drawer hide() {
    setOpen(false);
    return this;
  }

  /**
   * Set custom size using CSS custom property
   *
   * @param size the size (e.g., "400px", "50vw")
   */
  public Drawer setSize(String size) {
    setStyle("--size", size);
    return this;
  }

  /**
   * Set header spacing
   *
   * @param spacing the spacing value
   */
  public Drawer setHeaderSpacing(String spacing) {
    setStyle("--header-spacing", spacing);
    return this;
  }

  /**
   * Set body spacing
   *
   * @param spacing the spacing value
   */
  public Drawer setBodySpacing(String spacing) {
    setStyle("--body-spacing", spacing);
    return this;
  }

  /**
   * Set footer spacing
   *
   * @param spacing the spacing value
   */
  public Drawer setFooterSpacing(String spacing) {
    setStyle("--footer-spacing", spacing);
    return this;
  }

  /**
   * Add content to the header slot.
   * 
   * @param components the components to add to the header
   * @return this instance
   */
  public Drawer addToHeader(com.webforj.component.Component... components) {
    getBoundComponent().add("header", components);
    return this;
  }

  /**
   * Add content to the footer slot.
   * 
   * @param components the components to add to the footer
   * @return this instance
   */
  public Drawer addToFooter(com.webforj.component.Component... components) {
    getBoundComponent().add("footer", components);
    return this;
  }

  /**
   * Add a listener for the show event.
   * 
   * <p>Fired when the drawer starts to show.
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
   * <p>Fired after the drawer opens and all animations are complete.
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
   * <p>Fired when the drawer starts to hide.
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
   * <p>Fired after the drawer closes and all animations are complete.
   *
   * @param listener the after-hide event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<AfterHideEvent> onAfterHide(EventListener<AfterHideEvent> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Add a listener for the initial-focus event.
   * 
   * <p>Fired when the drawer's panel gains focus, but before the focus is moved to the drawer's autofocus element.
   *
   * @param listener the initial-focus event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InitialFocusEvent> onInitialFocus(EventListener<InitialFocusEvent> listener) {
    return addEventListener(InitialFocusEvent.class, listener);
  }

  /**
   * Add a listener for the request-close event.
   * 
   * <p>Fired when the user attempts to close the drawer by clicking the close button, clicking the 
   * overlay, or pressing escape. Calling event.preventDefault() will prevent the drawer from closing.
   *
   * @param listener the request-close event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<RequestCloseEvent> onRequestClose(EventListener<RequestCloseEvent> listener) {
    return addEventListener(RequestCloseEvent.class, listener);
  }

  /**
   * Show event dispatched when the drawer starts to show.
   */
  @EventName("sl-show")
  public static class ShowEvent extends ComponentEvent<Drawer> {
    /**
     * Creates a new show event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public ShowEvent(Drawer component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-show event dispatched after the drawer opens and animations complete.
   */
  @EventName("sl-after-show")
  public static class AfterShowEvent extends ComponentEvent<Drawer> {
    /**
     * Creates a new after-show event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public AfterShowEvent(Drawer component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Hide event dispatched when the drawer starts to hide.
   */
  @EventName("sl-hide")
  public static class HideEvent extends ComponentEvent<Drawer> {
    /**
     * Creates a new hide event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public HideEvent(Drawer component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-hide event dispatched after the drawer closes and animations complete.
   */
  @EventName("sl-after-hide")
  public static class AfterHideEvent extends ComponentEvent<Drawer> {
    /**
     * Creates a new after-hide event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public AfterHideEvent(Drawer component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Initial-focus event dispatched when the drawer gains focus.
   */
  @EventName("sl-initial-focus")
  public static class InitialFocusEvent extends ComponentEvent<Drawer> {
    /**
     * Creates a new initial-focus event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public InitialFocusEvent(Drawer component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Request-close event dispatched when the user attempts to close the drawer.
   */
  @EventName("sl-request-close")
  @EventOptions(data = {
    @EventOptions.EventData(key = "source", exp = "event.detail.source")
  })
  public static class RequestCloseEvent extends ComponentEvent<Drawer> {
    /**
     * Creates a new request-close event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public RequestCloseEvent(Drawer component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Gets the source of the close request.
     *
     * @return the source ("close-button", "keyboard", or "overlay")
     */
    public String getSource() {
      return (String) getData().get("source");
    }
  }
}