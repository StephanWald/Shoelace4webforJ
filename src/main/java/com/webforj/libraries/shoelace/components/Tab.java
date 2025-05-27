package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Tabs are used inside tab groups to represent and activate tab panels.
 * 
 * <p>Tabs display content in a set of panels, allowing users to switch between different sections. 
 * They should always be used with {@link TabGroup} and {@link TabPanel} components.</p>
 * 
 * <h2>Basic Usage</h2>
 * <pre>{@code
 * TabGroup tabGroup = new TabGroup();
 * 
 * // Add tabs
 * tabGroup.addTab(new Tab("General", "general-panel"));
 * tabGroup.addTab(new Tab("Settings", "settings-panel"));
 * tabGroup.addTab(new Tab("Advanced", "advanced-panel").setDisabled(true));
 * 
 * // Add panels
 * tabGroup.addPanel(new TabPanel("general-panel").add(new Paragraph("General content")));
 * tabGroup.addPanel(new TabPanel("settings-panel").add(new Paragraph("Settings content")));
 * tabGroup.addPanel(new TabPanel("advanced-panel").add(new Paragraph("Advanced content")));
 * }</pre>
 * 
 * <h2>Closable Tabs</h2>
 * <pre>{@code
 * Tab closableTab = new Tab("Document", "doc-panel")
 *     .setClosable(true)
 *     .onClose(event -> {
 *         // Handle tab close
 *         event.getComponent().remove();
 *     });
 * }</pre>
 * 
 * @see TabGroup
 * @see TabPanel
 * @see <a href="https://shoelace.style/components/tab">Tab Component Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/tab/tab.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-tab")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Tab extends ElementComposite implements HasComponents, HasHtml<Tab> {
  private final PropertyDescriptor<String> panelProp = PropertyDescriptor.property("panel", "");
  private final PropertyDescriptor<Boolean> activeProp = PropertyDescriptor.property("active", false);
  private final PropertyDescriptor<Boolean> closableProp = PropertyDescriptor.property("closable", false);
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);

  /**
   * Create a new Tab
   */
  public Tab() {
    super();
  }

  /**
   * Create a new Tab with label
   *
   * @param label the tab label
   */
  public Tab(String label) {
    super();
    setHtml(label);
  }

  /**
   * Create a new Tab with label and panel
   *
   * @param label the tab label
   * @param panel the associated panel name
   */
  public Tab(String label, String panel) {
    super();
    setHtml(label);
    setPanel(panel);
  }

  /**
   * Get the associated panel name
   *
   * @return the panel name
   */
  public String getPanel() {
    return get(panelProp);
  }

  /**
   * Set the associated panel name
   *
   * @param panel the panel name
   * @return this instance
   */
  public Tab setPanel(String panel) {
    set(panelProp, panel);
    return this;
  }

  /**
   * Check if the tab is active
   *
   * @return true if active
   */
  public boolean isActive() {
    return get(activeProp);
  }

  /**
   * Set the active state
   *
   * @param active true to make active
   * @return this instance
   */
  public Tab setActive(boolean active) {
    set(activeProp, active);
    return this;
  }

  /**
   * Check if the tab is closable
   *
   * @return true if closable
   */
  public boolean isClosable() {
    return get(closableProp);
  }

  /**
   * Set the closable state
   *
   * @param closable true to make closable
   * @return this instance
   */
  public Tab setClosable(boolean closable) {
    set(closableProp, closable);
    return this;
  }

  /**
   * Check if the tab is disabled
   *
   * @return true if disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Set the disabled state
   *
   * @param disabled true to disable
   * @return this instance
   */
  public Tab setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Set the tab label
   *
   * @param label the label text
   * @return this instance
   */
  public Tab setLabel(String label) {
    setHtml(label);
    return this;
  }

  /**
   * Set the tab text (alias for setLabel)
   *
   * @param text the text to display
   * @return this instance
   */
  public Tab setText(String text) {
    setHtml(text);
    return this;
  }

  /**
   * Get the tab text
   *
   * @return the tab text
   */
  public String getText() {
    return getHtml();
  }

  /**
   * Add a close event listener to the tab.
   * This event is fired when the close button of a closable tab is clicked.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CloseEvent> onClose(EventListener<CloseEvent> listener) {
    return addEventListener(CloseEvent.class, listener);
  }

  /**
   * Fired when the close button of a closable tab is clicked.
   * 
   * <p>This event can be prevented to keep the tab from being closed.
   * Use {@code event.preventDefault()} in the event handler to prevent the tab from closing.</p>
   * 
   * <pre>{@code
   * tab.onClose(event -> {
   *     if (!confirmClose()) {
   *         event.preventDefault(); // Prevent the tab from closing
   *     }
   * });
   * }</pre>
   */
  @EventName("sl-close")
  public static class CloseEvent extends ComponentEvent<Tab> {
    /**
     * Creates a new close event
     *
     * @param component the tab component
     * @param eventData the event data
     */
    public CloseEvent(Tab component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
}