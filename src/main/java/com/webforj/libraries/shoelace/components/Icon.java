package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasStyle;

/**
 * Icon component that renders SVG icons
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/icon/icon.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-icon")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Icon extends ElementComposite implements HasStyle<Icon> {
  private final PropertyDescriptor<String> NAME = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> SRC = PropertyDescriptor.property("src", "");
  private final PropertyDescriptor<String> LABEL = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> LIBRARY = PropertyDescriptor.property("library", "default");

  /**
   * Create a new Icon
   */
  public Icon() {
    super();
  }

  /**
   * Create a new Icon with name
   *
   * @param name the icon name
   */
  public Icon(String name) {
    super();
    setName(name);
  }

  /**
   * Create a new Icon with name and library
   *
   * @param name the icon name
   * @param library the icon library
   */
  public Icon(String name, String library) {
    super();
    setName(name);
    setLibrary(library);
  }

  /**
   * Get the icon name
   *
   * @return the icon name
   */
  public String getName() {
    return get(NAME);
  }

  /**
   * Set the icon name
   *
   * @param name the icon name
   */
  public Icon setName(String name) {
    set(NAME, name);
    return this;
  }

  /**
   * Get the icon source URL
   *
   * @return the source URL
   */
  public String getSrc() {
    return get(SRC);
  }

  /**
   * Set the icon source URL (for external SVGs)
   *
   * @param src the source URL
   */
  public Icon setSrc(String src) {
    set(SRC, src);
    return this;
  }

  /**
   * Get the accessibility label
   *
   * @return the label
   */
  public String getLabel() {
    return get(LABEL);
  }

  /**
   * Set the accessibility label
   *
   * @param label the label
   */
  public Icon setLabel(String label) {
    set(LABEL, label);
    return this;
  }

  /**
   * Get the icon library
   *
   * @return the library name
   */
  public String getLibrary() {
    return get(LIBRARY);
  }

  /**
   * Set the icon library
   *
   * @param library the library name
   */
  public Icon setLibrary(String library) {
    set(LIBRARY, library);
    return this;
  }

  /**
   * Set the icon size with font size
   *
   * @param size the size (e.g., "24px", "2rem")
   */
  public Icon setSize(String size) {
    setStyle("font-size", size);
    return this;
  }

  /**
   * Set the icon color
   *
   * @param color the color value
   */
  public Icon setColor(String color) {
    setStyle("color", color);
    return this;
  }

  /**
   * Create a Bootstrap icon
   */
  public static Icon bootstrap(String name) {
    return new Icon(name, "default");
  }

  /**
   * Create a Tabler icon
   */
  public static Icon tabler(String name) {
    return new Icon(name, "tabler");
  }

  /**
   * Create a Material icon
   */
  public static Icon material(String name) {
    return new Icon(name, "material");
  }

  /**
   * Create a Font Awesome icon
   */
  public static Icon fontAwesome(String name) {
    return new Icon(name, "fa");
  }

  /**
   * Create a Boxicons icon
   */
  public static Icon boxicons(String name) {
    return new Icon(name, "boxicons");
  }

  /**
   * Create a Lucide icon
   */
  public static Icon lucide(String name) {
    return new Icon(name, "lucide");
  }

  /**
   * Create a Heroicons icon
   */
  public static Icon heroicons(String name) {
    return new Icon(name, "heroicons");
  }

  /**
   * Create an Ionicons icon
   */
  public static Icon ionicons(String name) {
    return new Icon(name, "ionicons");
  }

  /**
   * Create a Remix icon
   */
  public static Icon remix(String name) {
    return new Icon(name, "remixicon");
  }

  /**
   * Create an Unicons icon
   */
  public static Icon unicons(String name) {
    return new Icon(name, "unicons");
  }
}