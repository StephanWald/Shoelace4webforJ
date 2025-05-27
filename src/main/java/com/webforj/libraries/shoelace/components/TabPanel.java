package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;

/**
 * Tab panels are used inside tab groups to display content for each tab.
 * 
 * <p>Tab panels work in conjunction with tabs within a tab group. Each panel must have
 * a unique name that corresponds to a tab's panel attribute. When a tab is activated,
 * its associated panel is shown and all other panels are hidden.</p>
 * 
 * <h2>Basic Usage</h2>
 * <pre>{@code
 * TabGroup tabGroup = new TabGroup();
 * 
 * // Create tabs and panels with matching names
 * Tab generalTab = new Tab("General", "general");
 * TabPanel generalPanel = new TabPanel("general")
 *     .add(new Paragraph("General settings content"));
 * 
 * Tab advancedTab = new Tab("Advanced", "advanced");
 * TabPanel advancedPanel = new TabPanel("advanced")
 *     .add(new Paragraph("Advanced settings content"));
 * 
 * // Add to tab group
 * tabGroup.addTab(generalTab);
 * tabGroup.addTab(advancedTab);
 * tabGroup.addPanel(generalPanel);
 * tabGroup.addPanel(advancedPanel);
 * }</pre>
 * 
 * <h2>Custom Padding</h2>
 * <pre>{@code
 * TabPanel panel = new TabPanel("custom")
 *     .setPadding("2rem")
 *     .add(content);
 * }</pre>
 * 
 * @see Tab
 * @see TabGroup
 * @see <a href="https://shoelace.style/components/tab-panel">Tab Panel Component Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/tab-panel/tab-panel.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-tab-panel")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class TabPanel extends ElementComposite implements HasComponents, HasStyle<TabPanel> {
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<Boolean> activeProp = PropertyDescriptor.property("active", false);

  /**
   * Create a new TabPanel
   */
  public TabPanel() {
    super();
  }

  /**
   * Create a new TabPanel with name
   *
   * @param name the panel name
   */
  public TabPanel(String name) {
    super();
    setName(name);
  }

  /**
   * Get the panel name
   *
   * @return the name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Set the panel name
   *
   * @param name the name
   * @return this instance
   */
  public TabPanel setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Check if the panel is active
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
  public TabPanel setActive(boolean active) {
    set(activeProp, active);
    return this;
  }

  /**
   * Set the panel padding
   *
   * @param padding the padding value
   * @return this instance
   */
  public TabPanel setPadding(String padding) {
    setStyle("--padding", padding);
    return this;
  }
}