package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * A component for displaying animated GIFs and WEBPs that play and pause on interaction.
 * 
 * <p>The Animated Image component displays animated GIF and WEBP images and offers controls 
 * for playing and pausing them. Unlike traditional images that animate immediately, 
 * this component shows a static preview until the user interacts with it.</p>
 * 
 * <h2>Key Features</h2>
 * <ul>
 *   <li>Automatic play/pause controls on hover</li>
 *   <li>Keyboard support (Enter/Space to toggle)</li>
 *   <li>Reduced motion support - respects user preferences</li>
 *   <li>Loading and error states</li>
 *   <li>Customizable play icon</li>
 * </ul>
 * 
 * <h2>Basic Usage</h2>
 * <pre>{@code
 * // Create an animated image
 * AnimatedImage animatedGif = new AnimatedImage(
 *     "/path/to/animation.gif",
 *     "Loading animation"
 * );
 * 
 * // Start playing immediately
 * animatedGif.play();
 * 
 * // Or control programmatically
 * button.onClick(e -> {
 *     if (animatedGif.isPlaying()) {
 *         animatedGif.pause();
 *     } else {
 *         animatedGif.play();
 *     }
 * });
 * }</pre>
 * 
 * <h2>Event Handling</h2>
 * <pre>{@code
 * // Handle successful load
 * animatedImage.onLoad(event -> {
 *     System.out.println("Animation loaded successfully");
 * });
 * 
 * // Handle load errors
 * animatedImage.onError(event -> {
 *     System.err.println("Failed to load animation");
 *     // Show fallback content
 * });
 * }</pre>
 * 
 * <h2>Styling</h2>
 * <pre>{@code
 * // Set dimensions
 * animatedImage.setStyle("width", "300px")
 *              .setStyle("height", "200px");
 * 
 * // Customize play icon
 * animatedImage.setStyle("--control-box-size", "3rem");
 * animatedImage.setStyle("--icon-size", "calc(var(--control-box-size) * 0.55)");
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/animated-image">Shoelace Animated Image Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/animated-image/animated-image.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-animated-image")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class AnimatedImage extends ElementComposite implements HasStyle<AnimatedImage> {
  
  // Properties
  private final PropertyDescriptor<String> srcProp = PropertyDescriptor.property("src", "");
  private final PropertyDescriptor<String> altProp = PropertyDescriptor.property("alt", "");
  private final PropertyDescriptor<Boolean> playProp = PropertyDescriptor.property("play", false);
  
  public AnimatedImage() {
    super();
  }
  
  public AnimatedImage(String src, String alt) {
    this();
    setSrc(src);
    setAlt(alt);
  }
  
  /**
   * Sets the image source (URL).
   */
  public AnimatedImage setSrc(String src) {
    set(srcProp, src);
    return this;
  }
  
  /**
   * Gets the image source.
   */
  public String getSrc() {
    return get(srcProp);
  }
  
  /**
   * Sets the image alt text.
   */
  public AnimatedImage setAlt(String alt) {
    set(altProp, alt);
    return this;
  }
  
  /**
   * Gets the image alt text.
   */
  public String getAlt() {
    return get(altProp);
  }
  
  /**
   * Sets whether the animation is playing.
   */
  public AnimatedImage setPlay(boolean play) {
    set(playProp, play);
    return this;
  }
  
  /**
   * Gets whether the animation is playing.
   */
  public boolean isPlaying() {
    return get(playProp);
  }
  
  /**
   * Starts the animation.
   */
  public void play() {
    setPlay(true);
  }
  
  /**
   * Pauses the animation.
   */
  public void pause() {
    setPlay(false);
  }
  
  // ==================== Event Handling ====================
  
  /**
   * Adds a load event listener to the animated image.
   * This event is fired when the image loads successfully.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LoadEvent> onLoad(EventListener<LoadEvent> listener) {
    return addEventListener(LoadEvent.class, listener);
  }
  
  /**
   * Adds an error event listener to the animated image.
   * This event is fired when the image fails to load.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent> onError(EventListener<ErrorEvent> listener) {
    return addEventListener(ErrorEvent.class, listener);
  }
  
  // ==================== Event Classes ====================
  
  /**
   * Fired when the image loads successfully.
   * 
   * <p>This event indicates that the animated image has been successfully loaded
   * and is ready for playback.</p>
   * 
   * <pre>{@code
   * animatedImage.onLoad(event -> {
   *     System.out.println("Image loaded: " + event.getComponent().getSrc());
   *     // Enable play controls or auto-play
   * });
   * }</pre>
   */
  @EventName("sl-load")
  public static class LoadEvent extends ComponentEvent<AnimatedImage> {
    /**
     * Creates a new load event
     *
     * @param component the animated image component
     * @param eventData the event data
     */
    public LoadEvent(AnimatedImage component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
  
  /**
   * Fired when the image fails to load.
   * 
   * <p>This event indicates that the animated image could not be loaded,
   * possibly due to a network error, invalid URL, or unsupported format.</p>
   * 
   * <pre>{@code
   * animatedImage.onError(event -> {
   *     System.err.println("Failed to load: " + event.getComponent().getSrc());
   *     // Show error message or fallback content
   * });
   * }</pre>
   */
  @EventName("sl-error")
  public static class ErrorEvent extends ComponentEvent<AnimatedImage> {
    /**
     * Creates a new error event
     *
     * @param component the animated image component
     * @param eventData the event data
     */
    public ErrorEvent(AnimatedImage component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
}