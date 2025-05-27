package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.Component;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.event.ComponentEvent;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * MenuItem represents an option within a {@link Menu}.
 * 
 * <p>Menu items can display text, icons, and badges. They support two types: normal items 
 * for actions and checkbox items for toggleable options. Menu items can also contain submenus 
 * for creating hierarchical menu structures.</p>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Normal and checkbox types</li>
 *   <li>Support for prefix and suffix content (icons, badges)</li>
 *   <li>Submenu support for hierarchical menus</li>
 *   <li>Loading and disabled states</li>
 *   <li>Value association for programmatic handling</li>
 * </ul>
 * 
 * <h3>Example Usage:</h3>
 * <pre>{@code
 * // Basic menu item
 * MenuItem saveItem = new MenuItem("Save", "save");
 * 
 * // Menu item with icon
 * MenuItem newFile = new MenuItem("New File")
 *     .setPrefix(new Icon("file-plus"))
 *     .setValue("new-file");
 * 
 * // Checkbox menu item
 * MenuItem showToolbar = new MenuItem("Show Toolbar")
 *     .setType(MenuItem.Type.CHECKBOX)
 *     .setChecked(true)
 *     .setValue("toolbar-visible");
 * 
 * // Menu item with submenu
 * MenuItem recentFiles = new MenuItem("Recent Files")
 *     .setSubmenu(new Menu()
 *         .addItem(new MenuItem("Document1.txt"))
 *         .addItem(new MenuItem("Document2.txt")));
 * 
 * // Disabled menu item
 * MenuItem deleteItem = new MenuItem("Delete")
 *     .setDisabled(true);
 * 
 * // With event handling
 * saveItem.onSelect(event -> {
 *     System.out.println("Save selected");
 * });
 * }</pre>
 * 
 * @see Menu
 * @see MenuLabel
 * @see <a href="https://shoelace.style/components/menu-item">Shoelace Menu Item Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/menu-item/menu-item.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-menu-item")
public final class MenuItem extends ElementComposite implements HasStyle<MenuItem>, HasHtml<MenuItem>, HasComponents {
  
  // ==================== Property Descriptors ====================
  
  /** The type of menu item (normal or checkbox) */
  private final PropertyDescriptor<String> typeProp = PropertyDescriptor.property("type", "normal");
  
  /** Whether a checkbox menu item is checked */
  private final PropertyDescriptor<Boolean> checkedProp = PropertyDescriptor.property("checked", false);
  
  /** The value associated with this menu item */
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  
  /** Whether the menu item shows a loading spinner */
  private final PropertyDescriptor<Boolean> loadingProp = PropertyDescriptor.property("loading", false);
  
  /** Whether the menu item is disabled */
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);

  // ==================== Enums ====================

  /**
   * Types of menu items.
   */
  public enum Type {
    /** Normal menu item for actions */
    NORMAL("normal"),
    /** Checkbox menu item for toggleable options */
    CHECKBOX("checkbox");

    private final String value;

    Type(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  // ==================== Constructors ====================

  /**
   * Creates a new empty MenuItem.
   */
  public MenuItem() {
    super();
  }

  /**
   * Creates a new MenuItem with the specified text.
   *
   * @param text the text to display
   */
  public MenuItem(String text) {
    super();
    setHtml(text);
  }

  /**
   * Creates a new MenuItem with the specified text and value.
   *
   * @param text the text to display
   * @param value the value to associate with this item
   */
  public MenuItem(String text, String value) {
    super();
    setHtml(text);
    setValue(value);
  }

  // ==================== Type Methods ====================

  /**
   * Gets the type of the menu item.
   *
   * @return the type ("normal" or "checkbox")
   */
  public String getType() {
    return get(typeProp);
  }

  /**
   * Sets the type of the menu item.
   *
   * @param type the type ("normal" or "checkbox")
   * @return this instance for method chaining
   */
  public MenuItem setType(String type) {
    set(typeProp, type);
    return this;
  }

  /**
   * Sets the type of the menu item using the enum.
   *
   * @param type the type enum value
   * @return this instance for method chaining
   */
  public MenuItem setType(Type type) {
    set(typeProp, type.getValue());
    return this;
  }

  // ==================== Checked State Methods ====================

  /**
   * Checks if the menu item is checked.
   * 
   * <p>Only applies to checkbox type menu items.</p>
   *
   * @return true if checked, false otherwise
   */
  public boolean isChecked() {
    return get(checkedProp);
  }

  /**
   * Sets the checked state of the menu item.
   * 
   * <p>Only applies to checkbox type menu items.</p>
   *
   * @param checked true to check, false to uncheck
   * @return this instance for method chaining
   */
  public MenuItem setChecked(boolean checked) {
    set(checkedProp, checked);
    return this;
  }

  // ==================== Value Methods ====================

  /**
   * Gets the value associated with the menu item.
   *
   * @return the value
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Sets the value associated with the menu item.
   * 
   * <p>This value can be used to identify the menu item programmatically 
   * when handling selection events.</p>
   *
   * @param value the value to set
   * @return this instance for method chaining
   */
  public MenuItem setValue(String value) {
    set(valueProp, value);
    return this;
  }

  // ==================== State Methods ====================

  /**
   * Checks if the menu item is in a loading state.
   *
   * @return true if loading, false otherwise
   */
  public boolean isLoading() {
    return get(loadingProp);
  }

  /**
   * Sets the loading state of the menu item.
   * 
   * <p>When loading, a spinner is shown instead of the prefix icon.</p>
   *
   * @param loading true to show loading state, false otherwise
   * @return this instance for method chaining
   */
  public MenuItem setLoading(boolean loading) {
    set(loadingProp, loading);
    return this;
  }

  /**
   * Checks if the menu item is disabled.
   *
   * @return true if disabled, false otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets the disabled state of the menu item.
   * 
   * <p>Disabled menu items cannot be selected or interacted with.</p>
   *
   * @param disabled true to disable, false to enable
   * @return this instance for method chaining
   */
  public MenuItem setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  // ==================== Slot Methods ====================

  /**
   * Sets a prefix component (typically an icon) for this menu item.
   * 
   * <p>The prefix appears before the menu item's text content.</p>
   *
   * @param component the component to add as prefix
   * @return this instance for method chaining
   */
  public MenuItem setPrefix(Component component) {
    getBoundComponent().add("prefix", component);
    return this;
  }

  /**
   * Sets a suffix component (typically a badge or icon) for this menu item.
   * 
   * <p>The suffix appears after the menu item's text content.</p>
   *
   * @param component the component to add as suffix
   * @return this instance for method chaining
   */
  public MenuItem setSuffix(Component component) {
    getBoundComponent().add("suffix", component);
    return this;
  }

  /**
   * Adds a submenu to this menu item.
   * 
   * <p>When a submenu is present, the menu item displays an arrow indicator 
   * and reveals the submenu on hover or focus.</p>
   *
   * @param submenu the submenu to add
   * @return this instance for method chaining
   */
  public MenuItem setSubmenu(Menu submenu) {
    getBoundComponent().add("submenu", submenu);
    return this;
  }

  // ==================== Event Handlers ====================

  /**
   * Adds a listener for the select event.
   * 
   * <p>The select event is fired when this menu item is selected by the user.</p>
   * 
   * @param listener the select event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<SelectEvent> onSelect(EventListener<SelectEvent> listener) {
    return addEventListener(SelectEvent.class, listener);
  }

  // ==================== Events ====================

  /**
   * Event fired when the menu item is selected.
   */
  @EventName("sl-select")
  @EventOptions(data = {
    @EventOptions.EventData(key = "item", exp = "event.detail.item")
  })
  public static class SelectEvent extends ComponentEvent<MenuItem> {
    /**
     * Creates a new select event.
     *
     * @param component the menu item component
     * @param eventData the event data
     */
    public SelectEvent(MenuItem component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Gets the selected menu item reference.
     * 
     * <p>Note: This returns the JavaScript object reference to the menu item.</p>
     *
     * @return the selected menu item reference
     */
    public Object getItem() {
      return getData().get("item");
    }
  }
}