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
 * Image Comparer component for visual comparison of two images
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/image-comparer/image-comparer.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-image-comparer")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class ImageComparer extends ElementComposite implements HasComponents, HasStyle<ImageComparer> {
  private final PropertyDescriptor<Integer> POSITION = PropertyDescriptor.property("position", 50);

  /**
   * Create a new ImageComparer
   */
  public ImageComparer() {
    super();
  }

  /**
   * Create a new ImageComparer with initial position
   *
   * @param position the initial position (0-100)
   */
  public ImageComparer(int position) {
    super();
    setPosition(position);
  }

  /**
   * Get the slider position
   *
   * @return the position (0-100)
   */
  public int getPosition() {
    return get(POSITION);
  }

  /**
   * Set the slider position
   *
   * @param position the position (0-100)
   */
  public ImageComparer setPosition(int position) {
    if (position < 0 || position > 100) {
      throw new IllegalArgumentException("Position must be between 0 and 100");
    }
    set(POSITION, position);
    return this;
  }

  /**
   * Set the before image
   *
   * @param beforeImage the before image component
   */
  public ImageComparer setBefore(com.webforj.component.Component beforeImage) {
    getBoundComponent().add("before", beforeImage);
    return this;
  }

  /**
   * Set the after image
   *
   * @param afterImage the after image component
   */
  public ImageComparer setAfter(com.webforj.component.Component afterImage) {
    getBoundComponent().add("after", afterImage);
    return this;
  }

  /**
   * Set both before and after images
   *
   * @param beforeImage the before image component
   * @param afterImage the after image component
   */
  public ImageComparer setImages(com.webforj.component.Component beforeImage, 
                                com.webforj.component.Component afterImage) {
    setBefore(beforeImage);
    setAfter(afterImage);
    return this;
  }

  /**
   * Set the handle icon
   *
   * @param handleIcon the handle icon component
   */
  public ImageComparer setHandle(com.webforj.component.Component handleIcon) {
    getBoundComponent().add("handle", handleIcon);
    return this;
  }
}