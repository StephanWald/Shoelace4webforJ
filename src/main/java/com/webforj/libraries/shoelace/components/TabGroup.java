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
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Tab groups organize content into a container that shows one section at a time.
 * 
 * <p>Tab groups are used to group multiple tabs together. They manage the active state
 * of tabs and coordinate the display of tab panels. Each tab in the group must have a
 * unique panel name that corresponds to a tab panel.</p>
 * 
 * <h2>Basic Usage</h2>
 * <pre>{@code
 * TabGroup tabGroup = new TabGroup();
 * 
 * // Add tabs
 * tabGroup.addTab(new Tab("General", "general"));
 * tabGroup.addTab(new Tab("Settings", "settings"));
 * tabGroup.addTab(new Tab("Advanced", "advanced"));
 * 
 * // Add corresponding panels
 * tabGroup.addPanel(new TabPanel("general").add(generalContent));
 * tabGroup.addPanel(new TabPanel("settings").add(settingsContent));
 * tabGroup.addPanel(new TabPanel("advanced").add(advancedContent));
 * 
 * // Listen for tab changes
 * tabGroup.onTabShow(event -> {
 *     System.out.println("Showing tab: " + event.getName());
 * });
 * }</pre>
 * 
 * <h2>Placement Options</h2>
 * <pre>{@code
 * // Position tabs at the bottom
 * tabGroup.setPlacement(TabGroup.Placement.BOTTOM);
 * 
 * // Position tabs on the left side
 * tabGroup.setPlacement(TabGroup.Placement.START);
 * }</pre>
 * 
 * <h2>Manual Activation</h2>
 * <pre>{@code
 * // Require explicit click to activate tabs (useful for form validation)
 * tabGroup.setActivation(TabGroup.Activation.MANUAL);
 * }</pre>
 * 
 * @see Tab
 * @see TabPanel
 * @see <a href="https://shoelace.style/components/tab-group">Tab Group Component Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/tab-group/tab-group.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-tab-group")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class TabGroup extends ElementComposite implements HasComponents, HasStyle<TabGroup> {
  private final PropertyDescriptor<String> placementProp = PropertyDescriptor.property("placement", "top");
  private final PropertyDescriptor<String> activationProp = PropertyDescriptor.property("activation", "auto");
  private final PropertyDescriptor<Boolean> noScrollControlsProp = PropertyDescriptor.property("no-scroll-controls", false);
  private final PropertyDescriptor<Boolean> fixedScrollControlsProp = PropertyDescriptor.property("fixed-scroll-controls", false);

  /**
   * Tab placement options
   */
  public enum Placement {
    TOP("top"),
    BOTTOM("bottom"),
    START("start"),
    END("end");

    private final String value;

    Placement(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Tab activation modes
   */
  public enum Activation {
    AUTO("auto"),
    MANUAL("manual");

    private final String value;

    Activation(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new TabGroup
   */
  public TabGroup() {
    super();
  }

  /**
   * Get the tab placement
   *
   * @return the placement
   */
  public String getPlacement() {
    return get(placementProp);
  }

  /**
   * Set the tab placement
   *
   * @param placement the placement
   * @return this instance
   */
  public TabGroup setPlacement(Placement placement) {
    set(placementProp, placement.getValue());
    return this;
  }

  /**
   * Set the tab placement
   *
   * @param placement the placement value
   * @return this instance
   */
  public TabGroup setPlacement(String placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Get the activation mode
   *
   * @return the activation mode
   */
  public String getActivation() {
    return get(activationProp);
  }

  /**
   * Set the activation mode
   *
   * @param activation the activation mode
   * @return this instance
   */
  public TabGroup setActivation(Activation activation) {
    set(activationProp, activation.getValue());
    return this;
  }

  /**
   * Check if scroll controls are disabled
   *
   * @return true if scroll controls are disabled
   */
  public boolean isNoScrollControls() {
    return get(noScrollControlsProp);
  }

  /**
   * Set whether to disable scroll controls
   *
   * @param noScrollControls true to disable scroll controls
   * @return this instance
   */
  public TabGroup setNoScrollControls(boolean noScrollControls) {
    set(noScrollControlsProp, noScrollControls);
    return this;
  }

  /**
   * Check if scroll controls are fixed
   *
   * @return true if scroll controls are fixed
   */
  public boolean isFixedScrollControls() {
    return get(fixedScrollControlsProp);
  }

  /**
   * Set whether scroll controls are fixed
   *
   * @param fixedScrollControls true to fix scroll controls
   * @return this instance
   */
  public TabGroup setFixedScrollControls(boolean fixedScrollControls) {
    set(fixedScrollControlsProp, fixedScrollControls);
    return this;
  }

  /**
   * Add a tab to the nav slot
   *
   * @param tab the tab component
   * @return this instance
   */
  public TabGroup addTab(Tab tab) {
    getBoundComponent().add("nav", tab);
    return this;
  }

  /**
   * Add a tab panel to the default slot
   *
   * @param panel the tab panel component
   * @return this instance
   */
  public TabGroup addPanel(TabPanel panel) {
    add(panel);
    return this;
  }

  /**
   * Show a specific tab panel
   *
   * @param panel the panel name to show
   */
  public void show(String panel) {
    // Note: Would need JavaScript interop
  }

  /**
   * Set the indicator color
   *
   * @param color the indicator color
   * @return this instance
   */
  public TabGroup setIndicatorColor(String color) {
    setStyle("--indicator-color", color);
    return this;
  }

  /**
   * Set the track color
   *
   * @param color the track color
   * @return this instance
   */
  public TabGroup setTrackColor(String color) {
    setStyle("--track-color", color);
    return this;
  }

  /**
   * Set the track width
   *
   * @param width the track width
   * @return this instance
   */
  public TabGroup setTrackWidth(String width) {
    setStyle("--track-width", width);
    return this;
  }

  /**
   * Add a tab show event listener.
   * This event is fired when a tab is shown.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<TabShowEvent> onTabShow(EventListener<TabShowEvent> listener) {
    return addEventListener(TabShowEvent.class, listener);
  }

  /**
   * Add a tab hide event listener.
   * This event is fired when a tab is hidden.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<TabHideEvent> onTabHide(EventListener<TabHideEvent> listener) {
    return addEventListener(TabHideEvent.class, listener);
  }

  /**
   * Fired when a tab is shown.
   * 
   * <p>This event is dispatched when a tab becomes active, either through user
   * interaction or programmatically. The event includes the name of the panel
   * that is being shown.</p>
   * 
   * <pre>{@code
   * tabGroup.onTabShow(event -> {
   *     String panelName = event.getName();
   *     System.out.println("Tab shown: " + panelName);
   * });
   * }</pre>
   */
  @EventName("sl-tab-show")
  @EventOptions(data = {
    @EventOptions.EventData(key = "name", exp = "event.detail.name")
  })
  public static class TabShowEvent extends ComponentEvent<TabGroup> {
    /**
     * Creates a new tab show event
     *
     * @param component the tab group component
     * @param eventData the event data
     */
    public TabShowEvent(TabGroup component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the name of the panel being shown
     *
     * @return the panel name
     */
    public String getName() {
      return (String) getData().get("name");
    }
  }

  /**
   * Fired when a tab is hidden.
   * 
   * <p>This event is dispatched when a tab becomes inactive. The event includes
   * the name of the panel that is being hidden.</p>
   * 
   * <pre>{@code
   * tabGroup.onTabHide(event -> {
   *     String panelName = event.getName();
   *     System.out.println("Tab hidden: " + panelName);
   * });
   * }</pre>
   */
  @EventName("sl-tab-hide")
  @EventOptions(data = {
    @EventOptions.EventData(key = "name", exp = "event.detail.name")
  })
  public static class TabHideEvent extends ComponentEvent<TabGroup> {
    /**
     * Creates a new tab hide event
     *
     * @param component the tab group component
     * @param eventData the event data
     */
    public TabHideEvent(TabGroup component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the name of the panel being hidden
     *
     * @return the panel name
     */
    public String getName() {
      return (String) getData().get("name");
    }
  }
}