package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
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
 * Menu provides a list of options for the user to choose from.
 * 
 * <p>Menus are typically placed inside a {@link Dropdown} and are used to display a list of 
 * options or actions. They support items, labels, and dividers to organize content. Menu items 
 * can be configured as checkboxes and support submenus for hierarchical navigation.</p>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Support for menu items, labels, and dividers</li>
 *   <li>Checkbox menu items for multi-selection</li>
 *   <li>Submenu support for hierarchical menus</li>
 *   <li>Keyboard navigation</li>
 *   <li>Selection event handling</li>
 * </ul>
 * 
 * <h3>Example Usage:</h3>
 * <pre>{@code
 * // Basic menu
 * Menu menu = new Menu()
 *     .addLabel(new MenuLabel("File Operations"))
 *     .addItem(new MenuItem("New File", "new"))
 *     .addItem(new MenuItem("Open File", "open"))
 *     .addDivider()
 *     .addItem(new MenuItem("Save", "save"))
 *     .addItem(new MenuItem("Save As...", "save-as"));
 * 
 * // Menu with checkboxes
 * Menu viewMenu = new Menu()
 *     .addLabel(new MenuLabel("View Options"))
 *     .addItem(new MenuItem("Show Toolbar")
 *         .setType(MenuItem.Type.CHECKBOX)
 *         .setChecked(true))
 *     .addItem(new MenuItem("Show Status Bar")
 *         .setType(MenuItem.Type.CHECKBOX));
 * 
 * // Menu with submenu
 * Menu editMenu = new Menu()
 *     .addItem(new MenuItem("Cut"))
 *     .addItem(new MenuItem("Copy"))
 *     .addItem(new MenuItem("Paste"))
 *     .addDivider()
 *     .addItem(new MenuItem("Find")
 *         .setSubmenu(new Menu()
 *             .addItem(new MenuItem("Find in File"))
 *             .addItem(new MenuItem("Find in Project"))));
 * 
 * // With event handling
 * menu.onSelect(event -> {
 *     MenuItem selected = event.getItem();
 *     System.out.println("Selected: " + selected.getValue());
 * });
 * }</pre>
 * 
 * @see MenuItem
 * @see MenuLabel
 * @see Dropdown
 * @see <a href="https://shoelace.style/components/menu">Shoelace Menu Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/menu/menu.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-menu")
public final class Menu extends ElementComposite implements HasStyle<Menu>, HasComponents {

  // ==================== Constructors ====================

  /**
   * Creates a new empty Menu.
   */
  public Menu() {
    super();
  }

  // ==================== Menu Building Methods ====================

  /**
   * Adds a menu item to this menu.
   * 
   * @param item the menu item to add
   * @return this menu instance for method chaining
   */
  public Menu addItem(MenuItem item) {
    add(item);
    return this;
  }

  /**
   * Adds a menu label to this menu.
   * 
   * <p>Labels are used to describe groups of menu items.</p>
   * 
   * @param label the menu label to add
   * @return this menu instance for method chaining
   */
  public Menu addLabel(MenuLabel label) {
    add(label);
    return this;
  }

  /**
   * Adds a divider to this menu.
   * 
   * <p>Dividers visually separate groups of menu items.</p>
   * 
   * @return this menu instance for method chaining
   */
  public Menu addDivider() {
    MenuDivider divider = new MenuDivider();
    add(divider);
    return this;
  }

  /**
   * Removes all items, labels, and dividers from the menu.
   * 
   * @return this menu instance for method chaining
   */
  public Menu clearItems() {
    removeAll();
    return this;
  }

  // ==================== Event Handlers ====================

  /**
   * Adds a listener for the select event.
   * 
   * <p>The select event is fired when a menu item is selected by the user, either 
   * through clicking or keyboard navigation.</p>
   * 
   * @param listener the select event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<SelectEvent> onSelect(EventListener<SelectEvent> listener) {
    return addEventListener(SelectEvent.class, listener);
  }

  // ==================== Events ====================

  /**
   * Event fired when a menu item is selected.
   */
  @EventName("sl-select")
  @EventOptions(data = {
    @EventOptions.EventData(key = "item", exp = "event.detail.item")
  })
  public static class SelectEvent extends ComponentEvent<Menu> {
    /**
     * Creates a new select event.
     *
     * @param component the menu component
     * @param eventData the event data
     */
    public SelectEvent(Menu component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Gets the selected menu item.
     * 
     * <p>Note: The returned object is a JavaScript object reference. In a real 
     * implementation, this would be converted to the corresponding MenuItem instance.</p>
     *
     * @return the selected menu item reference
     */
    public Object getItem() {
      return getData().get("item");
    }
  }

  // ==================== Inner Classes ====================

  /**
   * Simple divider element for menus.
   * 
   * <p>This is a thin wrapper around Shoelace's divider component specifically 
   * for use within menus.</p>
   */
  @JavaScript(
    value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/divider/divider.js",
    attributes = {@Attribute(name = "type", value = "module")})
  @NodeName("sl-divider")
  private static class MenuDivider extends ElementComposite {
    /**
     * Creates a new menu divider.
     */
    public MenuDivider() {
      super();
    }
  }
}