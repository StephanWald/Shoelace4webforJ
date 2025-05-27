package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;

@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/tag/tag.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-tag")
public final class Tag extends ElementComposite implements HasComponents, HasHtml<Tag>, HasStyle<Tag> {

  private final PropertyDescriptor<String> VARIANT = PropertyDescriptor.property("variant", "neutral");
  private final PropertyDescriptor<String> SIZE = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<Boolean> PILL = PropertyDescriptor.property("pill", false);
  private final PropertyDescriptor<Boolean> REMOVABLE = PropertyDescriptor.property("removable", false);

  public Tag() {
    super();
  }

  public Tag(String text) {
    super();
    setText(text);
  }

  public String getVariant() {
    return get(VARIANT);
  }

  public Tag setVariant(String variant) {
    set(VARIANT, variant);
    return this;
  }

  public String getSize() {
    return get(SIZE);
  }

  public Tag setSize(String size) {
    set(SIZE, size);
    return this;
  }

  public boolean isPill() {
    return get(PILL);
  }

  public Tag setPill(boolean pill) {
    set(PILL, pill);
    return this;
  }

  public boolean isRemovable() {
    return get(REMOVABLE);
  }

  public Tag setRemovable(boolean removable) {
    set(REMOVABLE, removable);
    return this;
  }

  public Tag setText(String text) {
    setHtml(text);
    return this;
  }

  public String getText() {
    return getHtml();
  }

  @Override
  public Tag setHtml(String html) {
    getBoundComponent().setHtml(html);
    return this;
  }

  @Override
  public String getHtml() {
    return getBoundComponent().getHtml();
  }

  @Override
  public Tag setStyle(String property, String value) {
    getBoundComponent().setStyle(property, value);
    return this;
  }

  @Override
  public Tag removeStyle(String property) {
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