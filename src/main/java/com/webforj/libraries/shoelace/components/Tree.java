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

import java.util.List;
import java.util.Map;

/**
 * A tree component for displaying hierarchical data.
 * 
 * <p>Trees display a hierarchical list of items that can be expanded and collapsed.
 * They support single, multiple, or leaf selection modes and can be styled with
 * custom indentation guides.</p>
 * 
 * <h2>Basic Usage</h2>
 * <pre>{@code
 * Tree tree = new Tree();
 * 
 * TreeItem root = new TreeItem("Documents");
 * root.addTreeItem(new TreeItem("Photos")
 *     .addTreeItem(new TreeItem("Summer Vacation"))
 *     .addTreeItem(new TreeItem("Winter Holidays"))
 * );
 * root.addTreeItem(new TreeItem("Videos"));
 * 
 * tree.addTreeItem(root);
 * }</pre>
 * 
 * <h2>Selection Modes</h2>
 * <pre>{@code
 * // Single selection (default)
 * Tree singleTree = new Tree();
 * 
 * // Multiple selection
 * Tree multiTree = new Tree()
 *     .setSelection(Tree.SelectionMode.MULTIPLE);
 * 
 * // Leaf selection only
 * Tree leafTree = new Tree()
 *     .setSelection(Tree.SelectionMode.LEAF);
 * }</pre>
 * 
 * <h2>Handling Selection Changes</h2>
 * <pre>{@code
 * tree.onSelectionChange(event -> {
 *     List<TreeItem> selected = event.getSelection();
 *     System.out.println("Selected items: " + selected.size());
 * });
 * }</pre>
 * 
 * <h2>Custom Styling</h2>
 * <pre>{@code
 * tree.setStyle("--indent-size", "2rem")
 *     .setStyle("--indent-guide-color", "var(--sl-color-neutral-200)")
 *     .setStyle("--indent-guide-width", "2px");
 * }</pre>
 * 
 * @see TreeItem
 * @see <a href="https://shoelace.style/components/tree">Tree Component Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/tree/tree.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-tree")
public final class Tree extends ElementComposite implements HasComponents, HasStyle<Tree> {

  private final PropertyDescriptor<String> selectionProp = PropertyDescriptor.property("selection", "single");

  /**
   * Selection modes for the tree
   */
  public enum SelectionMode {
    /**
     * Only one item can be selected at a time
     */
    SINGLE("single"),
    
    /**
     * Multiple items can be selected
     */
    MULTIPLE("multiple"),
    
    /**
     * Only leaf nodes (items without children) can be selected
     */
    LEAF("leaf");
    
    private final String value;
    
    SelectionMode(String value) {
      this.value = value;
    }
    
    /**
     * Get the string value for this selection mode
     *
     * @return the selection mode value
     */
    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new Tree with single selection mode
   */
  public Tree() {
    super();
  }

  /**
   * Get the selection mode
   *
   * @return the selection mode value
   */
  public String getSelection() {
    return get(selectionProp);
  }

  /**
   * Set the selection mode
   *
   * @param selection the selection mode
   * @return this instance
   */
  public Tree setSelection(String selection) {
    set(selectionProp, selection);
    return this;
  }

  /**
   * Set the selection mode using enum
   *
   * @param mode the selection mode
   * @return this instance
   */
  public Tree setSelection(SelectionMode mode) {
    return setSelection(mode.getValue());
  }

  /**
   * Add a tree item to this tree
   *
   * @param item the tree item to add
   * @return this instance
   */
  public Tree addTreeItem(TreeItem item) {
    add(item);
    return this;
  }

  /**
   * Add multiple tree items
   *
   * @param items the tree items to add
   * @return this instance
   */
  public Tree addTreeItems(TreeItem... items) {
    for (TreeItem item : items) {
      add(item);
    }
    return this;
  }

  /**
   * Set the indent size for nested items
   *
   * @param size the indent size (e.g., "2rem", "24px")
   * @return this instance
   */
  public Tree setIndentSize(String size) {
    setStyle("--indent-size", size);
    return this;
  }

  /**
   * Set the indent guide color
   *
   * @param color the color value
   * @return this instance
   */
  public Tree setIndentGuideColor(String color) {
    setStyle("--indent-guide-color", color);
    return this;
  }

  /**
   * Set the indent guide style
   *
   * @param style the line style (e.g., "solid", "dashed", "dotted")
   * @return this instance
   */
  public Tree setIndentGuideStyle(String style) {
    setStyle("--indent-guide-style", style);
    return this;
  }

  /**
   * Set the indent guide width
   *
   * @param width the line width (e.g., "1px", "2px")
   * @return this instance
   */
  public Tree setIndentGuideWidth(String width) {
    setStyle("--indent-guide-width", width);
    return this;
  }

  /**
   * Set the indent guide offset
   *
   * @param offset the vertical offset
   * @return this instance
   */
  public Tree setIndentGuideOffset(String offset) {
    setStyle("--indent-guide-offset", offset);
    return this;
  }

  /**
   * Add a selection change event listener.
   * This event is fired when tree items are selected or deselected.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<SelectionChangeEvent> onSelectionChange(EventListener<SelectionChangeEvent> listener) {
    return addEventListener(SelectionChangeEvent.class, listener);
  }

  @Override
  public Tree setStyle(String property, String value) {
    getBoundComponent().setStyle(property, value);
    return this;
  }

  @Override
  public Tree removeStyle(String property) {
    getBoundComponent().removeStyle(property);
    return this;
  }

  @Override
  public String getStyle(String property) {
    return getBoundComponent().getStyle(property);
  }

  @Override
  public String getComputedStyle(String property) {
    return getBoundComponent().getComputedStyle(property);
  }

  /**
   * Fired when the tree's selection changes.
   * 
   * <p>This event is dispatched whenever items are selected or deselected in the tree.
   * The event includes a list of currently selected TreeItem components.</p>
   * 
   * <pre>{@code
   * tree.onSelectionChange(event -> {
   *     List<TreeItem> selected = event.getSelection();
   *     for (TreeItem item : selected) {
   *         System.out.println("Selected: " + item.getText());
   *     }
   * });
   * }</pre>
   */
  @EventName("sl-selection-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "selection", exp = "event.detail.selection")
  })
  public static class SelectionChangeEvent extends ComponentEvent<Tree> {
    /**
     * Creates a new selection change event
     *
     * @param component the tree component
     * @param eventData the event data
     */
    public SelectionChangeEvent(Tree component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the list of selected tree items
     *
     * @return the selected items
     */
    @SuppressWarnings("unchecked")
    public List<TreeItem> getSelection() {
      return (List<TreeItem>) getData().get("selection");
    }
  }
}