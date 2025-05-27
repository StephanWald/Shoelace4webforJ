package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.Component;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasHtml;
import com.webforj.concern.HasStyle;

/**
 * Shoelace CarouselItem component.
 * 
 * <p>A carousel item represents a single slide within a {@link Carousel}. Each item can contain
 * any type of content including images, text, or complex layouts.
 * 
 * <p><strong>Basic Image Slide:</strong>
 * <pre>{@code
 * CarouselItem slide = new CarouselItem("<img src='photo.jpg' alt='Photo'>");
 * carousel.addItem(slide);
 * }</pre>
 * 
 * <p><strong>Complex Content Slide:</strong>
 * <pre>{@code
 * CarouselItem slide = new CarouselItem();
 * slide.add(
 *     new Heading("Featured Product"),
 *     new Paragraph("Special offer this week!"),
 *     new Button("Shop Now")
 * );
 * slide.setStyle("display", "flex")
 *      .setStyle("flex-direction", "column")
 *      .setStyle("align-items", "center")
 *      .setStyle("padding", "2rem");
 * }</pre>
 * 
 * <p><strong>Responsive Image with Aspect Ratio:</strong>
 * <pre>{@code
 * CarouselItem imageSlide = new CarouselItem()
 *     .setAspectRatio("16/9")
 *     .setStyle("background-image", "url('banner.jpg')")
 *     .setStyle("background-size", "cover")
 *     .setStyle("background-position", "center");
 * }</pre>
 * 
 * <p><strong>Video Slide:</strong>
 * <pre>{@code
 * CarouselItem videoSlide = new CarouselItem(
 *     "<video controls width='100%'>" +
 *     "<source src='video.mp4' type='video/mp4'>" +
 *     "</video>"
 * );
 * }</pre>
 * 
 * <p><strong>Card Layout Slide:</strong>
 * <pre>{@code
 * CarouselItem cardSlide = new CarouselItem();
 * Card productCard = new Card()
 *     .setHeader("Product Name")
 *     .setImage("product.jpg")
 *     .setContent("Product description...");
 * cardSlide.add(productCard);
 * cardSlide.setStyle("padding", "1rem");
 * }</pre>
 * 
 * <p><strong>Styling Tips:</strong>
 * <ul>
 *   <li>Use setAspectRatio() to maintain consistent slide dimensions</li>
 *   <li>Apply padding to create spacing within slides</li>
 *   <li>Use flexbox or grid for complex layouts</li>
 *   <li>Consider using background images for full-bleed visuals</li>
 * </ul>
 * 
 * @see Carousel
 * @see <a href="https://shoelace.style/components/carousel-item">Shoelace Carousel Item Documentation</a>
 * 
 * @author Hyyan Abo Fakher
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/carousel-item/carousel-item.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-carousel-item")
public final class CarouselItem extends ElementComposite implements HasStyle<CarouselItem>, HasHtml<CarouselItem>, HasComponents {

  // ==================== Constructors ====================
  
  /**
   * Creates a new empty CarouselItem.
   */
  public CarouselItem() {
    super();
  }

  /**
   * Creates a new CarouselItem with HTML content.
   *
   * @param content the HTML content to display in the slide
   */
  public CarouselItem(String content) {
    super();
    this.setHtml(content);
  }
  
  /**
   * Creates a new CarouselItem with components.
   *
   * @param components the components to add to the slide
   */
  public CarouselItem(Component... components) {
    super();
    for (Component component : components) {
      add(component);
    }
  }
  
  // ==================== Methods ====================

  /**
   * Sets the aspect ratio of this carousel item.
   * This helps maintain consistent dimensions across slides.
   *
   * @param aspectRatio the aspect ratio (e.g., "16/9", "4/3", "1/1")
   * @return this instance for method chaining
   */
  public CarouselItem setAspectRatio(String aspectRatio) {
    setStyle("--aspect-ratio", aspectRatio);
    return this;
  }
  
  /**
   * Sets the aspect ratio using common presets.
   *
   * @param width the width component of the ratio
   * @param height the height component of the ratio
   * @return this instance for method chaining
   */
  public CarouselItem setAspectRatio(int width, int height) {
    setStyle("--aspect-ratio", width + "/" + height);
    return this;
  }
  
  /**
   * Sets a background image for this carousel item.
   * Useful for creating full-bleed image slides.
   *
   * @param imageUrl the URL of the background image
   * @return this instance for method chaining
   */
  public CarouselItem setBackgroundImage(String imageUrl) {
    setStyle("background-image", "url('" + imageUrl + "')");
    setStyle("background-size", "cover");
    setStyle("background-position", "center");
    return this;
  }
  
  /**
   * Sets padding for the carousel item content.
   *
   * @param padding the padding value (e.g., "2rem", "20px")
   * @return this instance for method chaining
   */
  public CarouselItem setPadding(String padding) {
    setStyle("padding", padding);
    return this;
  }
  
  /**
   * Centers the content within this carousel item.
   * Applies flexbox centering both horizontally and vertically.
   *
   * @return this instance for method chaining
   */
  public CarouselItem centerContent() {
    setStyle("display", "flex");
    setStyle("align-items", "center");
    setStyle("justify-content", "center");
    return this;
  }
  
  /**
   * Common aspect ratio presets.
   */
  public static class AspectRatio {
    /** 16:9 aspect ratio (widescreen) */
    public static final String WIDESCREEN = "16/9";
    
    /** 4:3 aspect ratio (standard) */
    public static final String STANDARD = "4/3";
    
    /** 1:1 aspect ratio (square) */
    public static final String SQUARE = "1/1";
    
    /** 21:9 aspect ratio (ultra-wide) */
    public static final String ULTRAWIDE = "21/9";
    
    /** 9:16 aspect ratio (vertical/portrait) */
    public static final String PORTRAIT = "9/16";
    
    private AspectRatio() {
      // Utility class
    }
  }
}