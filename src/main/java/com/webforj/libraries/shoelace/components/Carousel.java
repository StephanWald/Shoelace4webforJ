package com.webforj.libraries.shoelace.components;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.event.ComponentEvent;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Shoelace Carousel component.
 * 
 * <p>Carousels display an arbitrary number of content slides along a horizontal or vertical axis.
 * They are commonly used for image galleries, testimonials, product showcases, and content sliders.
 * 
 * <p><strong>Basic Usage:</strong>
 * <pre>{@code
 * Carousel carousel = new Carousel();
 * carousel.add(
 *     new CarouselItem("<img src='slide1.jpg' alt='Slide 1'>"),
 *     new CarouselItem("<img src='slide2.jpg' alt='Slide 2'>"),
 *     new CarouselItem("<img src='slide3.jpg' alt='Slide 3'>")
 * );
 * carousel.setNavigation(true)
 *         .setPagination(true);
 * }</pre>
 * 
 * <p><strong>Autoplay Carousel:</strong>
 * <pre>{@code
 * Carousel carousel = new Carousel()
 *     .setAutoplay(true)
 *     .setAutoplayInterval(5000)  // 5 seconds
 *     .setLoop(true)
 *     .setNavigation(true);
 * 
 * // Add slides
 * for (String image : imageUrls) {
 *     carousel.addItem(new CarouselItem("<img src='" + image + "'>"));
 * }
 * }</pre>
 * 
 * <p><strong>Multiple Slides Per View:</strong>
 * <pre>{@code
 * Carousel productCarousel = new Carousel()
 *     .setSlidesPerPage(3)
 *     .setSlidesPerMove(1)
 *     .setNavigation(true)
 *     .setLoop(true);
 * 
 * // Add product cards
 * for (Product product : products) {
 *     CarouselItem item = new CarouselItem();
 *     item.add(createProductCard(product));
 *     productCarousel.addItem(item);
 * }
 * }</pre>
 * 
 * <p><strong>Vertical Carousel:</strong>
 * <pre>{@code
 * Carousel verticalCarousel = new Carousel()
 *     .setOrientation(Carousel.Orientation.VERTICAL)
 *     .setNavigation(true)
 *     .setStyle("height", "400px");  // Set height for vertical carousel
 * }</pre>
 * 
 * <p><strong>Draggable Carousel:</strong>
 * <pre>{@code
 * Carousel gallery = new Carousel()
 *     .setMouseDragging(true)
 *     .setPagination(true)
 *     .setLoop(true);
 * }</pre>
 * 
 * <p><strong>Event Handling:</strong>
 * <pre>{@code
 * carousel.onSlideChange(event -> {
 *     int currentIndex = event.getIndex();
 *     CarouselItem currentSlide = event.getSlide();
 *     System.out.println("Now showing slide " + currentIndex);
 * });
 * }</pre>
 * 
 * <p><strong>Responsive Slides Per Page:</strong>
 * <pre>{@code
 * // You can use CSS variables to make slides-per-page responsive
 * carousel.setStyle("--slides-per-page", "1");
 * carousel.setStyle("@media (min-width: 768px)", "--slides-per-page: 2");
 * carousel.setStyle("@media (min-width: 1024px)", "--slides-per-page: 3");
 * }</pre>
 * 
 * @see CarouselItem
 * @see <a href="https://shoelace.style/components/carousel">Shoelace Carousel Documentation</a>
 * 
 * @author Hyyan Abo Fakher
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/carousel/carousel.js",
  attributes = {@Attribute(name = "type", value = "module")})
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
@NodeName("sl-carousel")
public final class Carousel extends ElementComposite implements HasStyle<Carousel>, HasComponents {
  // ==================== Property Descriptors ====================
  
  /** Whether the carousel loops back to the beginning when it reaches the end */
  private final PropertyDescriptor<Boolean> loopProp = PropertyDescriptor.property("loop", false);
  
  /** Whether navigation arrows are shown */
  private final PropertyDescriptor<Boolean> navigationProp = PropertyDescriptor.property("navigation", false);
  
  /** Whether pagination dots are shown */
  private final PropertyDescriptor<Boolean> paginationProp = PropertyDescriptor.property("pagination", false);
  
  /** Number of slides to show per page */
  private final PropertyDescriptor<Integer> slidesPerPageProp = PropertyDescriptor.property("slides-per-page", 1);
  
  /** Number of slides to advance when navigating */
  private final PropertyDescriptor<Integer> slidesPerMoveProp = PropertyDescriptor.property("slides-per-move", 1);
  
  /** Carousel orientation (horizontal or vertical) */
  private final PropertyDescriptor<String> orientationProp = PropertyDescriptor.property("orientation", "horizontal");
  
  /** Whether mouse dragging is enabled */
  private final PropertyDescriptor<Boolean> mouseDraggingProp = PropertyDescriptor.property("mouse-dragging", false);
  
  /** Whether autoplay is enabled */
  private final PropertyDescriptor<Boolean> autoplayProp = PropertyDescriptor.property("autoplay", false);
  
  /** Autoplay interval in milliseconds */
  private final PropertyDescriptor<Integer> autoplayIntervalProp = PropertyDescriptor.property("autoplay-interval", 3000);
  
  // ==================== Enums ====================

  /**
   * Carousel orientations that determine the slide direction.
   */
  public enum Orientation {
    /** Slides move horizontally (default) */
    HORIZONTAL("horizontal"),
    /** Slides move vertically */
    VERTICAL("vertical");

    private final String value;

    Orientation(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }
  
  // ==================== Constructors ====================

  /**
   * Creates a new empty Carousel.
   */
  public Carousel() {
    super();
  }
  
  /**
   * Creates a new Carousel with the specified items.
   *
   * @param items the carousel items to add
   */
  public Carousel(CarouselItem... items) {
    super();
    for (CarouselItem item : items) {
      addItem(item);
    }
  }
  
  // ==================== Properties ====================

  /**
   * Checks if the carousel loops back to the beginning when it reaches the end.
   *
   * @return true if loop is enabled
   */
  public boolean isLoop() {
    return get(loopProp);
  }

  /**
   * Sets whether the carousel should loop infinitely.
   * When enabled, navigating past the last slide will loop back to the first.
   *
   * @param loop true to enable infinite loop
   * @return this instance for method chaining
   */
  public Carousel setLoop(boolean loop) {
    set(loopProp, loop);
    return this;
  }

  /**
   * Checks if navigation arrows are shown.
   *
   * @return true if navigation is enabled
   */
  public boolean isNavigation() {
    return get(navigationProp);
  }

  /**
   * Sets whether to show navigation arrows for previous/next slide.
   *
   * @param navigation true to show navigation buttons
   * @return this instance for method chaining
   */
  public Carousel setNavigation(boolean navigation) {
    set(navigationProp, navigation);
    return this;
  }

  /**
   * Checks if pagination dots are shown.
   *
   * @return true if pagination is enabled
   */
  public boolean isPagination() {
    return get(paginationProp);
  }

  /**
   * Sets whether to show pagination dots indicating slide position.
   *
   * @param pagination true to show pagination dots
   * @return this instance for method chaining
   */
  public Carousel setPagination(boolean pagination) {
    set(paginationProp, pagination);
    return this;
  }

  /**
   * Gets the number of slides shown per page.
   *
   * @return the number of slides per page
   */
  public int getSlidesPerPage() {
    return get(slidesPerPageProp);
  }

  /**
   * Sets the number of slides to show per page.
   * This determines how many slides are visible at once.
   *
   * @param slidesPerPage the number of slides to show per page (minimum 1)
   * @return this instance for method chaining
   */
  public Carousel setSlidesPerPage(int slidesPerPage) {
    set(slidesPerPageProp, slidesPerPage);
    return this;
  }

  /**
   * Gets the number of slides to advance when navigating.
   *
   * @return the number of slides per move
   */
  public int getSlidesPerMove() {
    return get(slidesPerMoveProp);
  }

  /**
   * Sets the number of slides to advance when navigating.
   * For example, if slides-per-page is 3 and slides-per-move is 1,
   * clicking next will advance by 1 slide instead of 3.
   *
   * @param slidesPerMove the number of slides to advance per move (minimum 1)
   * @return this instance for method chaining
   */
  public Carousel setSlidesPerMove(int slidesPerMove) {
    set(slidesPerMoveProp, slidesPerMove);
    return this;
  }

  /**
   * Gets the carousel orientation.
   *
   * @return the orientation ("horizontal" or "vertical")
   */
  public String getOrientation() {
    return get(orientationProp);
  }

  /**
   * Sets the carousel orientation as a string.
   *
   * @param orientation the orientation ("horizontal" or "vertical")
   * @return this instance for method chaining
   */
  public Carousel setOrientation(String orientation) {
    set(orientationProp, orientation);
    return this;
  }

  /**
   * Sets the carousel orientation using the enum.
   * Vertical carousels require a height to be set.
   *
   * @param orientation the orientation enum value
   * @return this instance for method chaining
   */
  public Carousel setOrientation(Orientation orientation) {
    set(orientationProp, orientation.getValue());
    return this;
  }

  /**
   * Checks if mouse dragging is enabled.
   *
   * @return true if mouse dragging is enabled
   */
  public boolean isMouseDragging() {
    return get(mouseDraggingProp);
  }

  /**
   * Sets whether the carousel can be navigated by dragging with the mouse.
   *
   * @param mouseDragging true to enable mouse dragging
   * @return this instance for method chaining
   */
  public Carousel setMouseDragging(boolean mouseDragging) {
    set(mouseDraggingProp, mouseDragging);
    return this;
  }

  /**
   * Checks if autoplay is enabled.
   *
   * @return true if autoplay is enabled
   */
  public boolean isAutoplay() {
    return get(autoplayProp);
  }

  /**
   * Sets whether the carousel should automatically advance slides.
   *
   * @param autoplay true to enable autoplay
   * @return this instance for method chaining
   */
  public Carousel setAutoplay(boolean autoplay) {
    set(autoplayProp, autoplay);
    return this;
  }

  /**
   * Gets the autoplay interval in milliseconds.
   *
   * @return the autoplay interval in milliseconds
   */
  public int getAutoplayInterval() {
    return get(autoplayIntervalProp);
  }

  /**
   * Sets the time between automatic slide advances.
   * Only applies when autoplay is enabled.
   *
   * @param interval the interval in milliseconds (default: 3000)
   * @return this instance for method chaining
   */
  public Carousel setAutoplayInterval(int interval) {
    set(autoplayIntervalProp, interval);
    return this;
  }
  
  // ==================== Methods ====================

  /**
   * Adds a carousel item to this carousel.
   *
   * @param item the carousel item to add
   * @return this instance for method chaining
   */
  public Carousel addItem(CarouselItem item) {
    add(item);
    return this;
  }
  
  /**
   * Adds multiple carousel items to this carousel.
   *
   * @param items the carousel items to add
   * @return this instance for method chaining
   */
  public Carousel addItems(CarouselItem... items) {
    for (CarouselItem item : items) {
      add(item);
    }
    return this;
  }
  
  /**
   * Sets custom width for horizontal carousels.
   *
   * @param width the width value (e.g., "800px", "100%")
   * @return this instance for method chaining
   */
  public Carousel setWidth(String width) {
    setStyle("width", width);
    return this;
  }
  
  /**
   * Sets custom height for vertical carousels.
   * Required when using vertical orientation.
   *
   * @param height the height value (e.g., "400px", "50vh")
   * @return this instance for method chaining
   */
  public Carousel setHeight(String height) {
    setStyle("height", height);
    return this;
  }
  
  /**
   * Sets the gap between slides.
   *
   * @param gap the gap value (e.g., "1rem", "20px")
   * @return this instance for method chaining
   */
  public Carousel setGap(String gap) {
    setStyle("--gap", gap);
    return this;
  }
  
  // ==================== Events ====================
  
  /**
   * Adds a listener for the slide-change event.
   * 
   * <p>Fired when the active slide changes.
   *
   * @param listener the slide-change event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<SlideChangeEvent> onSlideChange(EventListener<SlideChangeEvent> listener) {
    return addEventListener(SlideChangeEvent.class, listener);
  }
  
  // ==================== Event Classes ====================
  
  /**
   * Slide change event dispatched when the active slide changes.
   */
  @EventName("sl-slide-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "index", exp = "event.detail.index"),
    @EventOptions.EventData(key = "slide", exp = "event.detail.slide")
  })
  public static class SlideChangeEvent extends ComponentEvent<Carousel> {
    /**
     * Creates a new slide-change event.
     *
     * @param component the carousel component
     * @param eventData the event data
     */
    public SlideChangeEvent(Carousel component, Map<String, Object> eventData) {
      super(component, eventData);
    }
    
    /**
     * Gets the index of the current slide.
     * The index is zero-based.
     *
     * @return the current slide index
     */
    public int getIndex() {
      Object index = getData().get("index");
      return index instanceof Number ? ((Number) index).intValue() : 0;
    }
    
    /**
     * Gets the current slide element.
     * Note: This returns the DOM element reference which may not be directly
     * accessible in Java. Use getIndex() to identify the slide.
     *
     * @return the slide element reference or null
     */
    public Object getSlide() {
      return getData().get("slide");
    }
  }
}