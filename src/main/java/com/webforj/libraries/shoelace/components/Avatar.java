package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;

/**
 * Avatars are used to represent a person or object using Shoelace's {@code <sl-avatar>} component.
 * 
 * <p>By default, a generic icon will be shown. You can personalize avatars by adding custom icons, 
 * initials, and images. Avatars should be used in conjunction with a meaningful label to ensure they're 
 * accessible to assistive devices.</p>
 * 
 * <h2>Basic Usage</h2>
 * <pre>{@code
 * // Default avatar with generic icon
 * Avatar avatar = new Avatar();
 * 
 * // Avatar with initials
 * Avatar initialsAvatar = new Avatar("JD");
 * initialsAvatar.setLabel("John Doe");
 * 
 * // Avatar with image
 * Avatar imageAvatar = new Avatar();
 * imageAvatar.setImage("https://example.com/user.jpg")
 *            .setLabel("User profile");
 * }</pre>
 * 
 * <h2>Shapes</h2>
 * <pre>{@code
 * // Circle shape (default)
 * avatar.setShapeCircle();
 * 
 * // Square shape
 * avatar.setShapeSquare();
 * 
 * // Rounded square shape
 * avatar.setShapeRounded();
 * }</pre>
 * 
 * <h2>Lazy Loading</h2>
 * <pre>{@code
 * // Enable lazy loading for images
 * avatar.setLoading("lazy");
 * }</pre>
 * 
 * <h2>Styling</h2>
 * <p>The size of the avatar can be customized using the {@code --size} CSS custom property:</p>
 * <pre>{@code
 * avatar.setStyle("--size", "64px");
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/avatar">Shoelace Avatar Documentation</a>
 * @since 1.0.0
 * @author Shoelace Components
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/avatar/avatar.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-avatar")
public final class Avatar extends ElementComposite implements HasHtml<Avatar>, HasStyle<Avatar> {
  private final PropertyDescriptor<String> imageProp = PropertyDescriptor.property("image", "");
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> initialsProp = PropertyDescriptor.property("initials", "");
  private final PropertyDescriptor<String> shapeProp = PropertyDescriptor.property("shape", "circle");
  private final PropertyDescriptor<String> loadingProp = PropertyDescriptor.property("loading", "eager");

  /**
   * Create a new Avatar
   */
  public Avatar() {
    super();
  }

  /**
   * Create a new Avatar with initials
   *
   * @param initials the initials to display (1-2 characters)
   */
  public Avatar(String initials) {
    super();
    this.setInitials(initials);
  }

  /**
   * Get the image source
   *
   * @return the image source URL
   */
  public String getImage() {
    return get(imageProp);
  }

  /**
   * Set the image source
   *
   * @param image the image source URL
   */
  public Avatar setImage(String image) {
    set(imageProp, image);
    return this;
  }

  /**
   * Get the label for assistive devices
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Set the label for assistive devices
   *
   * @param label the label
   */
  public Avatar setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Get the initials to display
   *
   * @return the initials
   */
  public String getInitials() {
    return get(initialsProp);
  }

  /**
   * Set the initials to display (1-2 characters)
   *
   * @param initials the initials
   */
  public Avatar setInitials(String initials) {
    set(initialsProp, initials);
    return this;
  }

  /**
   * Get the shape of the avatar
   *
   * @return the shape (circle, square, or rounded)
   */
  public String getShape() {
    return get(shapeProp);
  }

  /**
   * Set the shape of the avatar
   *
   * @param shape the shape (circle, square, or rounded)
   */
  public Avatar setShape(String shape) {
    set(shapeProp, shape);
    return this;
  }

  /**
   * Set the shape to circle
   */
  public Avatar setShapeCircle() {
    return setShape("circle");
  }

  /**
   * Set the shape to square
   */
  public Avatar setShapeSquare() {
    return setShape("square");
  }

  /**
   * Set the shape to rounded
   */
  public Avatar setShapeRounded() {
    return setShape("rounded");
  }

  /**
   * Get the loading strategy
   *
   * @return the loading strategy (eager or lazy)
   */
  public String getLoading() {
    return get(loadingProp);
  }

  /**
   * Set the loading strategy
   *
   * @param loading the loading strategy (eager or lazy)
   */
  public Avatar setLoading(String loading) {
    set(loadingProp, loading);
    return this;
  }
}
