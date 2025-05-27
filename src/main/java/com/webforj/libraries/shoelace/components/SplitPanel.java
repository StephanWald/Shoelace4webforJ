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
 * Split Panel component for resizable panels
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/split-panel/split-panel.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-split-panel")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class SplitPanel extends ElementComposite implements HasComponents, HasStyle<SplitPanel> {
  private final PropertyDescriptor<Double> POSITION = PropertyDescriptor.property("position", 50.0);
  private final PropertyDescriptor<Double> POSITION_IN_PIXELS = PropertyDescriptor.property("position-in-pixels", null);
  private final PropertyDescriptor<Boolean> VERTICAL = PropertyDescriptor.property("vertical", false);
  private final PropertyDescriptor<Boolean> DISABLED = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<String> PRIMARY = PropertyDescriptor.property("primary", null);
  private final PropertyDescriptor<String> SNAP = PropertyDescriptor.property("snap", null);
  private final PropertyDescriptor<Integer> SNAP_THRESHOLD = PropertyDescriptor.property("snap-threshold", 12);

  /**
   * Primary panel options
   */
  public enum Primary {
    START("start"),
    END("end");

    private final String value;

    Primary(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new SplitPanel
   */
  public SplitPanel() {
    super();
  }

  /**
   * Get the position percentage
   *
   * @return the position (0-100)
   */
  public double getPosition() {
    return get(POSITION);
  }

  /**
   * Set the position percentage
   *
   * @param position the position (0-100)
   * @return this instance
   */
  public SplitPanel setPosition(double position) {
    set(POSITION, position);
    return this;
  }

  /**
   * Get the position in pixels
   *
   * @return the position in pixels
   */
  public Double getPositionInPixels() {
    return get(POSITION_IN_PIXELS);
  }

  /**
   * Set the position in pixels
   *
   * @param pixels the position in pixels
   * @return this instance
   */
  public SplitPanel setPositionInPixels(double pixels) {
    set(POSITION_IN_PIXELS, pixels);
    return this;
  }

  /**
   * Check if the split panel is vertical
   *
   * @return true if vertical
   */
  public boolean isVertical() {
    return get(VERTICAL);
  }

  /**
   * Set the vertical orientation
   *
   * @param vertical true for vertical split
   * @return this instance
   */
  public SplitPanel setVertical(boolean vertical) {
    set(VERTICAL, vertical);
    return this;
  }

  /**
   * Check if the split panel is disabled
   *
   * @return true if disabled
   */
  public boolean isDisabled() {
    return get(DISABLED);
  }

  /**
   * Set the disabled state
   *
   * @param disabled true to disable resizing
   * @return this instance
   */
  public SplitPanel setDisabled(boolean disabled) {
    set(DISABLED, disabled);
    return this;
  }

  /**
   * Get the primary panel
   *
   * @return the primary panel
   */
  public String getPrimary() {
    return get(PRIMARY);
  }

  /**
   * Set the primary panel
   *
   * @param primary the primary panel
   * @return this instance
   */
  public SplitPanel setPrimary(Primary primary) {
    set(PRIMARY, primary != null ? primary.getValue() : null);
    return this;
  }

  /**
   * Get the snap points
   *
   * @return the snap points
   */
  public String getSnap() {
    return get(SNAP);
  }

  /**
   * Set snap points
   *
   * @param snap the snap points (e.g., "0% 50% 100%")
   * @return this instance
   */
  public SplitPanel setSnap(String snap) {
    set(SNAP, snap);
    return this;
  }

  /**
   * Get the snap threshold
   *
   * @return the snap threshold
   */
  public int getSnapThreshold() {
    return get(SNAP_THRESHOLD);
  }

  /**
   * Set the snap threshold
   *
   * @param threshold the snap threshold in pixels
   * @return this instance
   */
  public SplitPanel setSnapThreshold(int threshold) {
    set(SNAP_THRESHOLD, threshold);
    return this;
  }

  /**
   * Add content to the start panel
   *
   * @param component the component to add
   * @return this instance
   */
  public SplitPanel addToStart(com.webforj.component.Component component) {
    getBoundComponent().add("start", component);
    return this;
  }

  /**
   * Add content to the end panel
   *
   * @param component the component to add
   * @return this instance
   */
  public SplitPanel addToEnd(com.webforj.component.Component component) {
    getBoundComponent().add("end", component);
    return this;
  }

  /**
   * Set custom divider content
   *
   * @param divider the divider component
   * @return this instance
   */
  public SplitPanel setDivider(com.webforj.component.Component divider) {
    getBoundComponent().add("divider", divider);
    return this;
  }

  /**
   * Set the divider width
   *
   * @param width the divider width
   * @return this instance
   */
  public SplitPanel setDividerWidth(String width) {
    setStyle("--divider-width", width);
    return this;
  }

  /**
   * Set the divider hit area
   *
   * @param hitArea the hit area size
   * @return this instance
   */
  public SplitPanel setDividerHitArea(String hitArea) {
    setStyle("--divider-hit-area", hitArea);
    return this;
  }

  /**
   * Set the minimum size of the primary panel
   *
   * @param min the minimum size
   * @return this instance
   */
  public SplitPanel setMin(String min) {
    setStyle("--min", min);
    return this;
  }

  /**
   * Set the maximum size of the primary panel
   *
   * @param max the maximum size
   * @return this instance
   */
  public SplitPanel setMax(String max) {
    setStyle("--max", max);
    return this;
  }

  /**
   * Create a horizontal split panel
   *
   * @return a new split panel instance
   */
  public static SplitPanel horizontal() {
    return new SplitPanel().setVertical(false);
  }

  /**
   * Create a vertical split panel
   *
   * @return a new split panel instance
   */
  public static SplitPanel vertical() {
    return new SplitPanel().setVertical(true);
  }
}