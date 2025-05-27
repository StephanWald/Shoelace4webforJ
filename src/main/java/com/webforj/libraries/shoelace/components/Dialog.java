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
 * Shoelace Dialog component.
 * 
 * <p>Dialogs, sometimes called "modals", appear above the page and require the user's immediate attention.
 * They are commonly used for alerts, confirmations, forms, and other content that should interrupt the
 * current workflow.
 * 
 * <p><strong>Basic Usage:</strong>
 * <pre>{@code
 * Dialog dialog = new Dialog("My Dialog");
 * dialog.add(new Paragraph("This is the dialog content"));
 * dialog.show();
 * }</pre>
 * 
 * <p><strong>With Footer Actions:</strong>
 * <pre>{@code
 * Dialog confirmDialog = new Dialog("Confirm Action");
 * confirmDialog.add(new Paragraph("Are you sure you want to proceed?"));
 * 
 * Button cancelBtn = new Button("Cancel");
 * cancelBtn.onClick(e -> confirmDialog.hide());
 * 
 * Button confirmBtn = new Button("Confirm");
 * confirmBtn.onClick(e -> {
 *     // Handle confirmation
 *     confirmDialog.hide();
 * });
 * 
 * confirmDialog.add("footer", cancelBtn, confirmBtn);
 * }</pre>
 * 
 * <p><strong>Event Handling:</strong>
 * <pre>{@code
 * dialog.onShow(event -> {
 *     System.out.println("Dialog is opening");
 * });
 * 
 * dialog.onRequestClose(event -> {
 *     // Prevent closing under certain conditions
 *     if (!canClose()) {
 *         event.preventDefault();
 *     }
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/dialog">Shoelace Dialog Documentation</a>
 * 
 * @author Hyyan Abo Fakher
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/dialog/dialog.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-dialog")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Dialog extends ElementComposite implements HasComponents, HasStyle<Dialog> {
  private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<Boolean> noHeaderProp = PropertyDescriptor.property("no-header", false);

  /**
   * Creates a new Dialog component.
   */
  public Dialog() {
    super();
  }

  /**
   * Creates a new Dialog with the specified label.
   *
   * @param label the dialog label/title
   */
  public Dialog(String label) {
    super();
    setLabel(label);
  }

  /**
   * Checks if the dialog is open.
   *
   * @return true if open, false otherwise
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets the open state of the dialog.
   *
   * @param open true to open, false to close
   * @return this instance
   */
  public Dialog setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the dialog label/title.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Sets the dialog label/title.
   *
   * @param label the label to display
   * @return this instance
   */
  public Dialog setLabel(String label) {
    set(labelProp, label);
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
  public Dialog setNoHeader(boolean noHeader) {
    set(noHeaderProp, noHeader);
    return this;
  }

  /**
   * Shows the dialog.
   * 
   * @return this instance
   */
  public Dialog show() {
    // Move dialog to body for proper positioning
    getBoundComponent().executeJs(
      "if (this.parentElement && document.body && this.parentElement !== document.body) {" +
      "  document.body.appendChild(this);" +
      "}"
    );
    setOpen(true);
    return this;
  }

  /**
   * Hides the dialog.
   * 
   * @return this instance
   */
  public Dialog hide() {
    setOpen(false);
    return this;
  }

  /**
   * Set custom width using CSS custom property
   *
   * @param width the width (e.g., "400px", "50vw")
   */
  public Dialog setWidth(String width) {
    setStyle("--width", width);
    return this;
  }

  /**
   * Set header spacing
   *
   * @param spacing the spacing value
   */
  public Dialog setHeaderSpacing(String spacing) {
    setStyle("--header-spacing", spacing);
    return this;
  }

  /**
   * Set body spacing
   *
   * @param spacing the spacing value
   */
  public Dialog setBodySpacing(String spacing) {
    setStyle("--body-spacing", spacing);
    return this;
  }

  /**
   * Set footer spacing
   *
   * @param spacing the spacing value
   */
  public Dialog setFooterSpacing(String spacing) {
    setStyle("--footer-spacing", spacing);
    return this;
  }

  /**
   * Add content to the header slot.
   * 
   * @param components the components to add to the header
   * @return this instance
   */
  public Dialog addToHeader(com.webforj.component.Component... components) {
    getBoundComponent().add("header", components);
    return this;
  }

  /**
   * Add content to the footer slot.
   * 
   * @param components the components to add to the footer
   * @return this instance
   */
  public Dialog addToFooter(com.webforj.component.Component... components) {
    getBoundComponent().add("footer", components);
    return this;
  }

  /**
   * Add a listener for the show event.
   * 
   * <p>Fired when the dialog starts to show.
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
   * <p>Fired after the dialog opens and all animations are complete.
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
   * <p>Fired when the dialog starts to hide.
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
   * <p>Fired after the dialog closes and all animations are complete.
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
   * <p>Fired when the dialog's panel gains focus, but before the focus is moved to the dialog's autofocus element.
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
   * <p>Fired when the user attempts to close the dialog by clicking the close button, clicking the 
   * overlay, or pressing escape. Calling event.preventDefault() will prevent the dialog from closing.
   *
   * @param listener the request-close event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<RequestCloseEvent> onRequestClose(EventListener<RequestCloseEvent> listener) {
    return addEventListener(RequestCloseEvent.class, listener);
  }

  /**
   * Show event dispatched when the dialog starts to show.
   */
  @EventName("sl-show")
  public static class ShowEvent extends ComponentEvent<Dialog> {
    /**
     * Creates a new show event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public ShowEvent(Dialog component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-show event dispatched after the dialog opens and animations complete.
   */
  @EventName("sl-after-show")
  public static class AfterShowEvent extends ComponentEvent<Dialog> {
    /**
     * Creates a new after-show event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public AfterShowEvent(Dialog component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Hide event dispatched when the dialog starts to hide.
   */
  @EventName("sl-hide")
  public static class HideEvent extends ComponentEvent<Dialog> {
    /**
     * Creates a new hide event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public HideEvent(Dialog component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-hide event dispatched after the dialog closes and animations complete.
   */
  @EventName("sl-after-hide")
  public static class AfterHideEvent extends ComponentEvent<Dialog> {
    /**
     * Creates a new after-hide event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public AfterHideEvent(Dialog component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Initial-focus event dispatched when the dialog gains focus.
   */
  @EventName("sl-initial-focus")
  public static class InitialFocusEvent extends ComponentEvent<Dialog> {
    /**
     * Creates a new initial-focus event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public InitialFocusEvent(Dialog component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Request-close event dispatched when the user attempts to close the dialog.
   */
  @EventName("sl-request-close")
  @EventOptions(data = {
    @EventOptions.EventData(key = "source", exp = "event.detail.source")
  })
  public static class RequestCloseEvent extends ComponentEvent<Dialog> {
    /**
     * Creates a new request-close event.
     *
     * @param component the component
     * @param eventData the event data
     */
    public RequestCloseEvent(Dialog component, Map<String, Object> eventData) {
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