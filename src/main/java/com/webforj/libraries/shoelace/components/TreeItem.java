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
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * A tree item component for use within a tree.
 * 
 * <p>Tree items are hierarchical elements that can contain other tree items.
 * They support expansion, selection, and lazy loading of child items.</p>
 * 
 * <h2>Basic Usage</h2>
 * <pre>{@code
 * TreeItem item = new TreeItem("Documents");
 * item.addTreeItem(new TreeItem("Photos"));
 * item.addTreeItem(new TreeItem("Videos"));
 * 
 * // Add to tree
 * tree.addTreeItem(item);
 * }</pre>
 * 
 * <h2>Expandable Items</h2>
 * <pre>{@code
 * TreeItem folder = new TreeItem("My Folder")
 *     .setExpanded(true);  // Start expanded
 * 
 * folder.onExpand(event -> {
 *     System.out.println("Folder expanded");
 * });
 * 
 * folder.onCollapse(event -> {
 *     System.out.println("Folder collapsed");
 * });
 * }</pre>
 * 
 * <h2>Lazy Loading</h2>
 * <pre>{@code
 * TreeItem lazyItem = new TreeItem("Large Dataset")
 *     .setLazy(true);
 * 
 * lazyItem.onLazyLoad(event -> {
 *     // Load children dynamically
 *     for (String child : loadChildren()) {
 *         lazyItem.addTreeItem(new TreeItem(child));
 *     }
 *     // Mark as no longer lazy
 *     lazyItem.setLazy(false);
 * });
 * }</pre>
 * 
 * <h2>Selection and State</h2>
 * <pre>{@code
 * TreeItem item = new TreeItem("Settings")
 *     .setSelected(true)      // Pre-select
 *     .setDisabled(false);    // Enable/disable
 * }</pre>
 * 
 * @see Tree
 * @see <a href="https://shoelace.style/components/tree-item">Tree Item Component Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/tree-item/tree-item.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-tree-item")
public final class TreeItem extends ElementComposite implements HasComponents, HasHtml<TreeItem>, HasStyle<TreeItem> {

  private final PropertyDescriptor<Boolean> expandedProp = PropertyDescriptor.property("expanded", false);
  private final PropertyDescriptor<Boolean> selectedProp = PropertyDescriptor.property("selected", false);
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> lazyProp = PropertyDescriptor.property("lazy", false);

  /**
   * Create a new TreeItem
   */
  public TreeItem() {
    super();
  }

  /**
   * Create a new TreeItem with text
   *
   * @param text the item text
   */
  public TreeItem(String text) {
    super();
    setText(text);
  }

  /**
   * Check if the item is expanded
   *
   * @return true if expanded
   */
  public boolean isExpanded() {
    return get(expandedProp);
  }

  /**
   * Set the expanded state
   *
   * @param expanded true to expand, false to collapse
   * @return this instance
   */
  public TreeItem setExpanded(boolean expanded) {
    set(expandedProp, expanded);
    return this;
  }

  /**
   * Check if the item is selected
   *
   * @return true if selected
   */
  public boolean isSelected() {
    return get(selectedProp);
  }

  /**
   * Set the selected state
   *
   * @param selected true to select
   * @return this instance
   */
  public TreeItem setSelected(boolean selected) {
    set(selectedProp, selected);
    return this;
  }

  /**
   * Check if the item is disabled
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
  public TreeItem setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Check if the item uses lazy loading
   *
   * @return true if lazy loading is enabled
   */
  public boolean isLazy() {
    return get(lazyProp);
  }

  /**
   * Set the lazy loading state
   *
   * @param lazy true to enable lazy loading
   * @return this instance
   */
  public TreeItem setLazy(boolean lazy) {
    set(lazyProp, lazy);
    return this;
  }

  /**
   * Set the item text
   *
   * @param text the text to display
   * @return this instance
   */
  public TreeItem setText(String text) {
    setHtml(text);
    return this;
  }

  /**
   * Get the item text
   *
   * @return the item text
   */
  public String getText() {
    return getHtml();
  }

  /**
   * Add a child tree item
   *
   * @param item the child item to add
   * @return this instance
   */
  public TreeItem addTreeItem(TreeItem item) {
    add(item);
    return this;
  }

  /**
   * Add multiple child tree items
   *
   * @param items the child items to add
   * @return this instance
   */
  public TreeItem addTreeItems(TreeItem... items) {
    for (TreeItem item : items) {
      add(item);
    }
    return this;
  }

  /**
   * Add an expand event listener.
   * This event is fired when the tree item expands.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ExpandEvent> onExpand(EventListener<ExpandEvent> listener) {
    return addEventListener(ExpandEvent.class, listener);
  }

  /**
   * Add an after expand event listener.
   * This event is fired after the tree item expands and animations complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterExpandEvent> onAfterExpand(EventListener<AfterExpandEvent> listener) {
    return addEventListener(AfterExpandEvent.class, listener);
  }

  /**
   * Add a collapse event listener.
   * This event is fired when the tree item collapses.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CollapseEvent> onCollapse(EventListener<CollapseEvent> listener) {
    return addEventListener(CollapseEvent.class, listener);
  }

  /**
   * Add an after collapse event listener.
   * This event is fired after the tree item collapses and animations complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterCollapseEvent> onAfterCollapse(EventListener<AfterCollapseEvent> listener) {
    return addEventListener(AfterCollapseEvent.class, listener);
  }

  /**
   * Add a lazy change event listener.
   * This event is fired when the lazy state changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LazyChangeEvent> onLazyChange(EventListener<LazyChangeEvent> listener) {
    return addEventListener(LazyChangeEvent.class, listener);
  }

  /**
   * Add a lazy load event listener.
   * This event is fired when a lazy item is selected and needs to load its children.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LazyLoadEvent> onLazyLoad(EventListener<LazyLoadEvent> listener) {
    return addEventListener(LazyLoadEvent.class, listener);
  }

  @Override
  public TreeItem setHtml(String html) {
    getBoundComponent().setHtml(html);
    return this;
  }

  @Override
  public String getHtml() {
    return getBoundComponent().getHtml();
  }

  @Override
  public TreeItem setStyle(String property, String value) {
    getBoundComponent().setStyle(property, value);
    return this;
  }

  @Override
  public TreeItem removeStyle(String property) {
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
   * Fired when the tree item expands.
   * 
   * <p>This event is dispatched when the user expands a collapsed tree item.
   * You can prevent the expansion by calling {@code event.preventDefault()}.</p>
   * 
   * <pre>{@code
   * item.onExpand(event -> {
   *     System.out.println("Item expanding");
   * });
   * }</pre>
   */
  @EventName("sl-expand")
  public static class ExpandEvent extends ComponentEvent<TreeItem> {
    /**
     * Creates a new expand event
     *
     * @param component the tree item component
     * @param eventData the event data
     */
    public ExpandEvent(TreeItem component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Fired after the tree item expands and animations complete.
   * 
   * <p>This event is dispatched after the expand animation has finished.</p>
   * 
   * <pre>{@code
   * item.onAfterExpand(event -> {
   *     System.out.println("Item fully expanded");
   * });
   * }</pre>
   */
  @EventName("sl-after-expand")
  public static class AfterExpandEvent extends ComponentEvent<TreeItem> {
    /**
     * Creates a new after expand event
     *
     * @param component the tree item component
     * @param eventData the event data
     */
    public AfterExpandEvent(TreeItem component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Fired when the tree item collapses.
   * 
   * <p>This event is dispatched when the user collapses an expanded tree item.
   * You can prevent the collapse by calling {@code event.preventDefault()}.</p>
   * 
   * <pre>{@code
   * item.onCollapse(event -> {
   *     System.out.println("Item collapsing");
   * });
   * }</pre>
   */
  @EventName("sl-collapse")
  public static class CollapseEvent extends ComponentEvent<TreeItem> {
    /**
     * Creates a new collapse event
     *
     * @param component the tree item component
     * @param eventData the event data
     */
    public CollapseEvent(TreeItem component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Fired after the tree item collapses and animations complete.
   * 
   * <p>This event is dispatched after the collapse animation has finished.</p>
   * 
   * <pre>{@code
   * item.onAfterCollapse(event -> {
   *     System.out.println("Item fully collapsed");
   * });
   * }</pre>
   */
  @EventName("sl-after-collapse")
  public static class AfterCollapseEvent extends ComponentEvent<TreeItem> {
    /**
     * Creates a new after collapse event
     *
     * @param component the tree item component
     * @param eventData the event data
     */
    public AfterCollapseEvent(TreeItem component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Fired when the lazy state changes.
   * 
   * <p>This event is dispatched when the lazy property is modified.</p>
   * 
   * <pre>{@code
   * item.onLazyChange(event -> {
   *     System.out.println("Lazy state changed");
   * });
   * }</pre>
   */
  @EventName("sl-lazy-change")
  public static class LazyChangeEvent extends ComponentEvent<TreeItem> {
    /**
     * Creates a new lazy change event
     *
     * @param component the tree item component
     * @param eventData the event data
     */
    public LazyChangeEvent(TreeItem component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Fired when a lazy item is selected and needs to load its children.
   * 
   * <p>This event is dispatched when a lazy tree item is expanded for the first time.
   * Use this event to dynamically load child items.</p>
   * 
   * <pre>{@code
   * item.onLazyLoad(event -> {
   *     // Load children asynchronously
   *     loadChildrenAsync().thenAccept(children -> {
   *         for (String child : children) {
   *             item.addTreeItem(new TreeItem(child));
   *         }
   *         item.setLazy(false); // Mark as loaded
   *     });
   * });
   * }</pre>
   */
  @EventName("sl-lazy-load")
  public static class LazyLoadEvent extends ComponentEvent<TreeItem> {
    /**
     * Creates a new lazy load event
     *
     * @param component the tree item component
     * @param eventData the event data
     */
    public LazyLoadEvent(TreeItem component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
}