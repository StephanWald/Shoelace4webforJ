package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;

/**
 * MenuLabel is used to describe a group of menu items within a {@link Menu}.
 * 
 * <p>Menu labels provide a way to categorize and organize menu items into logical groups. 
 * They appear as non-interactive text headers within the menu structure and are commonly 
 * used to improve menu navigation and user experience.</p>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Non-interactive descriptive text</li>
 *   <li>Visual separation of menu item groups</li>
 *   <li>Supports HTML content for formatting</li>
 *   <li>Automatically styled to differentiate from menu items</li>
 * </ul>
 * 
 * <h3>Example Usage:</h3>
 * <pre>{@code
 * // Basic menu label
 * MenuLabel fileLabel = new MenuLabel("File Operations");
 * 
 * // Creating a menu with labeled sections
 * Menu menu = new Menu()
 *     .addLabel(new MenuLabel("File"))
 *     .addItem(new MenuItem("New", "new"))
 *     .addItem(new MenuItem("Open", "open"))
 *     .addItem(new MenuItem("Save", "save"))
 *     .addDivider()
 *     .addLabel(new MenuLabel("Edit"))
 *     .addItem(new MenuItem("Cut", "cut"))
 *     .addItem(new MenuItem("Copy", "copy"))
 *     .addItem(new MenuItem("Paste", "paste"));
 * 
 * // Menu label with formatted text
 * MenuLabel advancedLabel = new MenuLabel("<strong>Advanced Options</strong>");
 * }</pre>
 * 
 * @see Menu
 * @see MenuItem
 * @see <a href="https://shoelace.style/components/menu-label">Shoelace Menu Label Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/menu-label/menu-label.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-menu-label")
public final class MenuLabel extends ElementComposite implements HasHtml<MenuLabel>, HasStyle<MenuLabel> {

  // ==================== Constructors ====================

  /**
   * Creates a new empty MenuLabel.
   */
  public MenuLabel() {
    super();
  }

  /**
   * Creates a new MenuLabel with the specified text.
   *
   * @param text the label text to display
   */
  public MenuLabel(String text) {
    super();
    setHtml(text);
  }
}