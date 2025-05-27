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
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Map;

/**
 * Animate elements declaratively with nearly 100 baked-in presets, or roll your own with CSS.
 * 
 * <p>The Animation component provides a declarative way to animate any content using the Web Animations API.
 * It includes nearly 100 prebuilt animations inspired by Animate.css, allowing you to easily add motion
 * to your applications without writing complex CSS or JavaScript.</p>
 * 
 * <h2>Basic Usage</h2>
 * <pre>{@code
 * // Create an animation with a preset
 * Animation anim = new Animation("bounce");
 * anim.add(new Paragraph("This text will bounce!"));
 * anim.play();
 * 
 * // Control animation properties
 * Animation slideIn = new Animation("slideInLeft")
 *     .setDuration(500)
 *     .setEasing("ease-out")
 *     .setIterations(1);
 * slideIn.add(myComponent);
 * slideIn.play();
 * }</pre>
 * 
 * <h2>Animation Categories</h2>
 * <p>Animations are grouped into the following categories:</p>
 * <ul>
 *   <li><strong>Attention seekers:</strong> bounce, flash, pulse, rubberBand, shakeX, shakeY, headShake, swing, tada, wobble, jello, heartBeat</li>
 *   <li><strong>Back entrances:</strong> backInDown, backInLeft, backInRight, backInUp</li>
 *   <li><strong>Back exits:</strong> backOutDown, backOutLeft, backOutRight, backOutUp</li>
 *   <li><strong>Bouncing entrances:</strong> bounceIn, bounceInDown, bounceInLeft, bounceInRight, bounceInUp</li>
 *   <li><strong>Bouncing exits:</strong> bounceOut, bounceOutDown, bounceOutLeft, bounceOutRight, bounceOutUp</li>
 *   <li><strong>Fading entrances:</strong> fadeIn, fadeInDown, fadeInDownBig, fadeInLeft, fadeInLeftBig, fadeInRight, fadeInRightBig, fadeInUp, fadeInUpBig, fadeInTopLeft, fadeInTopRight, fadeInBottomLeft, fadeInBottomRight</li>
 *   <li><strong>Fading exits:</strong> fadeOut, fadeOutDown, fadeOutDownBig, fadeOutLeft, fadeOutLeftBig, fadeOutRight, fadeOutRightBig, fadeOutUp, fadeOutUpBig, fadeOutTopLeft, fadeOutTopRight, fadeOutBottomLeft, fadeOutBottomRight</li>
 *   <li><strong>Flippers:</strong> flip, flipInX, flipInY, flipOutX, flipOutY</li>
 *   <li><strong>Lightspeed:</strong> lightSpeedInRight, lightSpeedInLeft, lightSpeedOutRight, lightSpeedOutLeft</li>
 *   <li><strong>Rotating entrances:</strong> rotateIn, rotateInDownLeft, rotateInDownRight, rotateInUpLeft, rotateInUpRight</li>
 *   <li><strong>Rotating exits:</strong> rotateOut, rotateOutDownLeft, rotateOutDownRight, rotateOutUpLeft, rotateOutUpRight</li>
 *   <li><strong>Specials:</strong> hinge, jackInTheBox, rollIn, rollOut</li>
 *   <li><strong>Zooming entrances:</strong> zoomIn, zoomInDown, zoomInLeft, zoomInRight, zoomInUp</li>
 *   <li><strong>Zooming exits:</strong> zoomOut, zoomOutDown, zoomOutLeft, zoomOutRight, zoomOutUp</li>
 *   <li><strong>Sliding entrances:</strong> slideInDown, slideInLeft, slideInRight, slideInUp</li>
 *   <li><strong>Sliding exits:</strong> slideOutDown, slideOutLeft, slideOutRight, slideOutUp</li>
 * </ul>
 * 
 * <h2>Custom Animations</h2>
 * <pre>{@code
 * // Use custom keyframes
 * Animation custom = new Animation();
 * custom.setName("none"); // Use 'none' for custom animations
 * custom.setStyle("animation", "myCustomAnimation 1s ease-in-out");
 * }</pre>
 * 
 * <h2>Event Handling</h2>
 * <pre>{@code
 * animation.onStart(event -> {
 *     System.out.println("Animation started");
 * });
 * 
 * animation.onFinish(event -> {
 *     System.out.println("Animation finished");
 *     // Maybe trigger another animation or hide the element
 * });
 * 
 * animation.onCancel(event -> {
 *     System.out.println("Animation was cancelled");
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/animation">Shoelace Animation Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/animation/animation.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-animation")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class Animation extends ElementComposite implements HasStyle<Animation>, HasComponents {
  
  // Properties
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "none");
  private final PropertyDescriptor<Boolean> playProp = PropertyDescriptor.property("play", false);
  private final PropertyDescriptor<Integer> delayProp = PropertyDescriptor.property("delay", 0);
  private final PropertyDescriptor<String> directionProp = PropertyDescriptor.property("direction", "normal");
  private final PropertyDescriptor<Integer> durationProp = PropertyDescriptor.property("duration", 1000);
  private final PropertyDescriptor<String> easingProp = PropertyDescriptor.property("easing", "linear");
  private final PropertyDescriptor<String> endDelayProp = PropertyDescriptor.property("end-delay", "0");
  private final PropertyDescriptor<String> fillProp = PropertyDescriptor.property("fill", "auto");
  private final PropertyDescriptor<String> iterationsProp = PropertyDescriptor.property("iterations", "Infinity");
  private final PropertyDescriptor<Double> iterationStartProp = PropertyDescriptor.property("iteration-start", 0.0);
  private final PropertyDescriptor<Double> playbackRateProp = PropertyDescriptor.property("playback-rate", 1.0);
  
  public Animation() {
    super();
  }
  
  public Animation(String name) {
    this();
    setName(name);
  }
  
  /**
   * Adds content to be animated.
   */
  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
  
  /**
   * Sets the animation name.
   */
  public Animation setName(String name) {
    set(nameProp, name);
    return this;
  }
  
  /**
   * Gets the animation name.
   */
  public String getName() {
    return get(nameProp);
  }
  
  /**
   * Sets whether the animation is playing.
   */
  public Animation setPlay(boolean play) {
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
   * Sets the animation delay in milliseconds.
   */
  public Animation setDelay(int delay) {
    set(delayProp, delay);
    return this;
  }
  
  /**
   * Gets the animation delay.
   */
  public Integer getDelay() {
    return get(delayProp);
  }
  
  /**
   * Sets the animation direction.
   */
  public Animation setDirection(String direction) {
    set(directionProp, direction);
    return this;
  }
  
  /**
   * Gets the animation direction.
   */
  public String getDirection() {
    return get(directionProp);
  }
  
  /**
   * Sets the animation duration in milliseconds.
   */
  public Animation setDuration(int duration) {
    set(durationProp, duration);
    return this;
  }
  
  /**
   * Gets the animation duration.
   */
  public Integer getDuration() {
    return get(durationProp);
  }
  
  /**
   * Sets the animation easing function.
   */
  public Animation setEasing(String easing) {
    set(easingProp, easing);
    return this;
  }
  
  /**
   * Gets the animation easing.
   */
  public String getEasing() {
    return get(easingProp);
  }
  
  /**
   * Sets the animation fill mode.
   */
  public Animation setFill(String fill) {
    set(fillProp, fill);
    return this;
  }
  
  /**
   * Gets the animation fill mode.
   */
  public String getFill() {
    return get(fillProp);
  }
  
  /**
   * Sets the number of iterations.
   */
  public Animation setIterations(String iterations) {
    set(iterationsProp, iterations);
    return this;
  }
  
  /**
   * Sets the number of iterations.
   */
  public Animation setIterations(int iterations) {
    set(iterationsProp, String.valueOf(iterations));
    return this;
  }
  
  /**
   * Gets the number of iterations.
   */
  public String getIterations() {
    return get(iterationsProp);
  }
  
  /**
   * Sets the playback rate.
   */
  public Animation setPlaybackRate(double rate) {
    set(playbackRateProp, rate);
    return this;
  }
  
  /**
   * Gets the playback rate.
   */
  public Double getPlaybackRate() {
    return get(playbackRateProp);
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
  
  /**
   * Cancels the animation.
   */
  public void cancel() {
    // Reset the animation by setting play to false
    setPlay(false);
    // Force reset by manipulating iterations
    String currentIterations = getIterations();
    setIterations("0");
    setIterations(currentIterations);
  }
  
  /**
   * Finishes the animation.
   */
  public void finish() {
    // Jump to the end of the animation
    setPlay(false);
  }
  
  // ==================== Event Handling ====================
  
  /**
   * Adds a start event listener to the animation.
   * This event is fired when the animation starts or restarts.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<StartEvent> onStart(EventListener<StartEvent> listener) {
    return addEventListener(StartEvent.class, listener);
  }
  
  /**
   * Adds a finish event listener to the animation.
   * This event is fired when the animation finishes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FinishEvent> onFinish(EventListener<FinishEvent> listener) {
    return addEventListener(FinishEvent.class, listener);
  }
  
  /**
   * Adds a cancel event listener to the animation.
   * This event is fired when the animation is canceled.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CancelEvent> onCancel(EventListener<CancelEvent> listener) {
    return addEventListener(CancelEvent.class, listener);
  }
  
  // ==================== Event Classes ====================
  
  /**
   * Fired when the animation starts or restarts.
   * 
   * <p>This event is dispatched whenever the animation begins playing, either
   * from the initial start or when restarting after being paused.</p>
   * 
   * <pre>{@code
   * animation.onStart(event -> {
   *     System.out.println("Animation started");
   * });
   * }</pre>
   */
  @EventName("sl-start")
  public static class StartEvent extends ComponentEvent<Animation> {
    /**
     * Creates a new start event
     *
     * @param component the animation component
     * @param eventData the event data
     */
    public StartEvent(Animation component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
  
  /**
   * Fired when the animation finishes.
   * 
   * <p>This event is dispatched when the animation completes all its iterations
   * and comes to a natural end.</p>
   * 
   * <pre>{@code
   * animation.onFinish(event -> {
   *     // Animation completed, maybe hide the element or trigger another animation
   *     event.getComponent().setPlay(false);
   * });
   * }</pre>
   */
  @EventName("sl-finish")
  public static class FinishEvent extends ComponentEvent<Animation> {
    /**
     * Creates a new finish event
     *
     * @param component the animation component
     * @param eventData the event data
     */
    public FinishEvent(Animation component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
  
  /**
   * Fired when the animation is canceled.
   * 
   * <p>This event is dispatched when the animation is stopped before it finishes
   * naturally, typically by calling cancel() or setting play to false.</p>
   * 
   * <pre>{@code
   * animation.onCancel(event -> {
   *     System.out.println("Animation was cancelled");
   * });
   * }</pre>
   */
  @EventName("sl-cancel")
  public static class CancelEvent extends ComponentEvent<Animation> {
    /**
     * Creates a new cancel event
     *
     * @param component the animation component
     * @param eventData the event data
     */
    public CancelEvent(Animation component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }
}