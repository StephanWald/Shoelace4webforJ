package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;

@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/tooltip/tooltip.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-tooltip")
public final class Tooltip extends ElementComposite implements HasComponents, HasStyle<Tooltip> {

  private final PropertyDescriptor<String> CONTENT = PropertyDescriptor.property("content", "");
  private final PropertyDescriptor<String> PLACEMENT = PropertyDescriptor.property("placement", "top");
  private final PropertyDescriptor<Boolean> DISABLED = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Integer> DISTANCE = PropertyDescriptor.property("distance", 8);
  private final PropertyDescriptor<Boolean> OPEN = PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<Integer> SKIDDING = PropertyDescriptor.property("skidding", 0);
  private final PropertyDescriptor<String> TRIGGER = PropertyDescriptor.property("trigger", "hover focus");
  private final PropertyDescriptor<Boolean> HOIST = PropertyDescriptor.property("hoist", false);

  public Tooltip() {
    super();
  }

  public Tooltip(String content) {
    super();
    setContent(content);
  }

  public String getContent() {
    return get(CONTENT);
  }

  public Tooltip setContent(String content) {
    set(CONTENT, content);
    return this;
  }

  public String getPlacement() {
    return get(PLACEMENT);
  }

  public Tooltip setPlacement(String placement) {
    set(PLACEMENT, placement);
    return this;
  }

  public boolean isDisabled() {
    return get(DISABLED);
  }

  public Tooltip setDisabled(boolean disabled) {
    set(DISABLED, disabled);
    return this;
  }

  public int getDistance() {
    return get(DISTANCE);
  }

  public Tooltip setDistance(int distance) {
    set(DISTANCE, distance);
    return this;
  }

  public boolean isOpen() {
    return get(OPEN);
  }

  public Tooltip setOpen(boolean open) {
    set(OPEN, open);
    return this;
  }

  public int getSkidding() {
    return get(SKIDDING);
  }

  public Tooltip setSkidding(int skidding) {
    set(SKIDDING, skidding);
    return this;
  }

  public String getTrigger() {
    return get(TRIGGER);
  }

  public Tooltip setTrigger(String trigger) {
    set(TRIGGER, trigger);
    return this;
  }

  public boolean isHoist() {
    return get(HOIST);
  }

  public Tooltip setHoist(boolean hoist) {
    set(HOIST, hoist);
    return this;
  }

  public void show() {
    setOpen(true);
  }

  public void hide() {
    setOpen(false);
  }

  @Override
  public Tooltip setStyle(String property, String value) {
    getBoundComponent().setStyle(property, value);
    return this;
  }

  @Override
  public Tooltip removeStyle(String property) {
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
}