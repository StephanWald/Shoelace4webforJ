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
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.awt.Color;
import java.util.Map;

/**
 * QRCode Generator using Shoelace QRCode component.
 * 
 * <p>The QRCode component generates Quick Response (QR) codes that can encode text, URLs, 
 * or any string data. QR codes are widely used for sharing information that can be quickly 
 * scanned by smartphones and other devices.</p>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Customizable size and colors</li>
 *   <li>Adjustable error correction levels</li>
 *   <li>Rounded corners support</li>
 *   <li>Accessibility support with labels</li>
 *   <li>Mouse and touch event handling</li>
 * </ul>
 * 
 * <h3>Example Usage:</h3>
 * <pre>{@code
 * // Basic QR code
 * QRCode qr = new QRCode("https://webforj.com");
 * 
 * // Customized QR code
 * QRCode customQR = new QRCode("Contact Info", 256)
 *     .setFill("#3B82F6")
 *     .setBackground("#EFF6FF")
 *     .setRadius(0.3)
 *     .setErrorCorrection(ErrorCorrection.HIGH)
 *     .setLabel("Scan for contact information");
 * 
 * // With event handling
 * qr.onClick(event -> {
 *     System.out.println("QR code clicked at: " + event.getClientX() + ", " + event.getClientY());
 * });
 * }</pre>
 * 
 * @see <a href="https://shoelace.style/components/qr-code">Shoelace QR Code Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/qr-code/qr-code.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-qr-code")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class QRCode extends ElementComposite {
  
  // ==================== Property Descriptors ====================
  
  /** The value/content to encode in the QR code */
  private final PropertyDescriptor<String> VALUE = PropertyDescriptor.property("value", "");
  
  /** The accessibility label for screen readers */
  private final PropertyDescriptor<String> LABEL = PropertyDescriptor.property("label", "");
  
  /** The size of the QR code in pixels */
  private final PropertyDescriptor<Integer> SIZE = PropertyDescriptor.property("size", 128);
  
  /** The foreground color of the QR code modules */
  private final PropertyDescriptor<String> FILL = PropertyDescriptor.property("fill", "black");
  
  /** The background color of the QR code */
  private final PropertyDescriptor<String> BACKGROUND = PropertyDescriptor.property("background", "white");
  
  /** The corner radius of each module (0-0.5) */
  private final PropertyDescriptor<Double> RADIUS = PropertyDescriptor.property("radius", 0.0);
  
  /** The error correction level (L, M, Q, H) */
  private final PropertyDescriptor<String> ERROR_CORRECTION = PropertyDescriptor.property("error-correction", "H");

  // ==================== Enums ====================

  /**
   * Error correction levels for QR codes.
   * Higher levels create more complex codes but can recover from more damage.
   */
  public enum ErrorCorrection {
    /** Low - ~7% error correction capability */
    LOW("L"),
    /** Medium - ~15% error correction capability */
    MEDIUM("M"),
    /** Quartile - ~25% error correction capability */
    QUARTILE("Q"),
    /** High - ~30% error correction capability (default) */
    HIGH("H");

    private final String value;

    ErrorCorrection(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  // ==================== Constructors ====================

  /**
   * Creates a new empty QRCode component.
   */
  public QRCode() {
    super();
  }

  /**
   * Creates a new QRCode with the specified value.
   *
   * @param value the content to encode in the QR code
   */
  public QRCode(String value) {
    super();
    this.setValue(value);
  }

  /**
   * Creates a new QRCode with the specified value and size.
   *
   * @param value the content to encode in the QR code
   * @param size  the size of the QR code in pixels
   */
  public QRCode(String value, int size) {
    super();
    this.setValue(value);
    this.setSize(size);
  }

  // ==================== Core Properties ====================

  /**
   * Gets the value encoded in the QR code.
   *
   * @return the encoded value
   */
  public String getValue() {
    return get(VALUE);
  }

  /**
   * Sets the value to encode in the QR code.
   *
   * @param value the content to encode (text, URL, or any string data)
   * @return this QRCode instance for method chaining
   */
  public QRCode setValue(String value) {
    set(VALUE, value);
    return this;
  }

  /**
   * Gets the size of the QR code.
   *
   * @return the size in pixels
   */
  public int getSize() {
    return get(SIZE);
  }

  /**
   * Sets the size of the QR code.
   *
   * @param size the size in pixels (minimum 64)
   * @return this QRCode instance for method chaining
   */
  public QRCode setSize(int size) {
    set(SIZE, size);
    return this;
  }

  // ==================== Accessibility ====================

  /**
   * Gets the accessibility label.
   *
   * @return the accessibility label for screen readers
   */
  public String getLabel() {
    return get(LABEL);
  }

  /**
   * Sets the accessibility label for screen readers.
   * 
   * <p>The label should describe what the QR code contains or where it leads when scanned.</p>
   *
   * @param label descriptive text for screen readers
   * @return this QRCode instance for method chaining
   */
  public QRCode setLabel(String label) {
    set(LABEL, label);
    return this;
  }

  // ==================== Color Properties ====================

  /**
   * Gets the fill color of the QR code modules.
   *
   * @return the fill color as a CSS color string
   */
  public String getFill() {
    return get(FILL);
  }

  /**
   * Sets the fill color of the QR code modules.
   *
   * @param fill the fill color (any valid CSS color: hex, rgb, hsl, or color name)
   * @return this QRCode instance for method chaining
   */
  public QRCode setFill(String fill) {
    set(FILL, fill);
    return this;
  }

  /**
   * Sets the fill color using a Java Color object.
   *
   * @param color the fill color as a Color object
   * @return this QRCode instance for method chaining
   */
  public QRCode setFill(Color color) {
    String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    set(FILL, hex);
    return this;
  }

  /**
   * Gets the background color of the QR code.
   *
   * @return the background color as a CSS color string
   */
  public String getBackground() {
    return get(BACKGROUND);
  }

  /**
   * Sets the background color of the QR code.
   *
   * @param background the background color (any valid CSS color or 'transparent')
   * @return this QRCode instance for method chaining
   */
  public QRCode setBackground(String background) {
    set(BACKGROUND, background);
    return this;
  }

  /**
   * Sets the background color using a Java Color object.
   *
   * @param color the background color as a Color object
   * @return this QRCode instance for method chaining
   */
  public QRCode setBackground(Color color) {
    String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    set(BACKGROUND, hex);
    return this;
  }

  // ==================== Style Properties ====================

  /**
   * Gets the corner radius of each module.
   *
   * @return the radius value (0-0.5)
   */
  public Double getRadius() {
    return get(RADIUS);
  }

  /**
   * Sets the corner radius of each module in the QR code.
   * 
   * <p>Values range from 0 (sharp corners) to 0.5 (circular modules).</p>
   *
   * @param radius the radius value (must be between 0 and 0.5)
   * @return this QRCode instance for method chaining
   * @throws IllegalArgumentException if radius is not between 0 and 0.5
   */
  public QRCode setRadius(double radius) {
    if (radius < 0 || radius > 0.5) {
      throw new IllegalArgumentException("Radius must be between 0 and 0.5");
    }
    set(RADIUS, radius);
    return this;
  }

  // ==================== Error Correction ====================

  /**
   * Gets the error correction level.
   *
   * @return the error correction level (L, M, Q, or H)
   */
  public String getErrorCorrection() {
    return get(ERROR_CORRECTION);
  }

  /**
   * Sets the error correction level using the enum.
   *
   * @param errorCorrection the error correction level
   * @return this QRCode instance for method chaining
   */
  public QRCode setErrorCorrection(ErrorCorrection errorCorrection) {
    set(ERROR_CORRECTION, errorCorrection.getValue());
    return this;
  }

  /**
   * Sets the error correction level using a string value.
   *
   * @param errorCorrection the error correction level (L, M, Q, or H)
   * @return this QRCode instance for method chaining
   */
  public QRCode setErrorCorrection(String errorCorrection) {
    set(ERROR_CORRECTION, errorCorrection);
    return this;
  }

  // ==================== Legacy Methods (Deprecated) ====================

  /**
   * @deprecated Use {@link #getFill()} instead
   */
  @Deprecated
  public Color getColor() {
    String hex = get(FILL);
    return Color.decode(hex);
  }

  /**
   * @deprecated Use {@link #setFill(Color)} instead
   */
  @Deprecated
  public QRCode setColor(Color color) {
    return setFill(color);
  }

  // ==================== Event Handling ====================

  /**
   * Adds a click event listener to the QR code.
   * 
   * <p>The click event provides the mouse position where the click occurred.</p>
   *
   * @param listener the event listener to handle click events
   * @return a registration object that can be used to remove the listener
   */
  public ListenerRegistration<ClickEvent> onClick(EventListener<ClickEvent> listener) {
    return addEventListener(ClickEvent.class, listener);
  }

  /**
   * Adds a double-click event listener to the QR code.
   *
   * @param listener the event listener to handle double-click events
   * @return a registration object that can be used to remove the listener
   */
  public ListenerRegistration<DoubleClickEvent> onDoubleClick(EventListener<DoubleClickEvent> listener) {
    return addEventListener(DoubleClickEvent.class, listener);
  }

  /**
   * Adds a mouse enter event listener to the QR code.
   * 
   * <p>Fired when the mouse cursor enters the QR code area.</p>
   *
   * @param listener the event listener to handle mouse enter events
   * @return a registration object that can be used to remove the listener
   */
  public ListenerRegistration<MouseEnterEvent> onMouseEnter(EventListener<MouseEnterEvent> listener) {
    return addEventListener(MouseEnterEvent.class, listener);
  }

  /**
   * Adds a mouse leave event listener to the QR code.
   * 
   * <p>Fired when the mouse cursor leaves the QR code area.</p>
   *
   * @param listener the event listener to handle mouse leave events
   * @return a registration object that can be used to remove the listener
   */
  public ListenerRegistration<MouseLeaveEvent> onMouseLeave(EventListener<MouseLeaveEvent> listener) {
    return addEventListener(MouseLeaveEvent.class, listener);
  }

  /**
   * Adds a context menu (right-click) event listener to the QR code.
   *
   * @param listener the event listener to handle context menu events
   * @return a registration object that can be used to remove the listener
   */
  public ListenerRegistration<ContextMenuEvent> onContextMenu(EventListener<ContextMenuEvent> listener) {
    return addEventListener(ContextMenuEvent.class, listener);
  }

  // ==================== Event Classes ====================

  /**
   * Event fired when the QR code is clicked.
   * 
   * <p>Provides access to the mouse coordinates where the click occurred.</p>
   */
  @EventName("click")
  @EventOptions(data = { 
    @EventOptions.EventData(key = "clientX", exp = "event.clientX"),
    @EventOptions.EventData(key = "clientY", exp = "event.clientY")
  })
  public static class ClickEvent extends ComponentEvent<QRCode> {

    public ClickEvent(QRCode source, Map<String, Object> detail) {
      super(source, detail);
    }

    /**
     * Gets the X coordinate of the mouse pointer relative to the viewport.
     *
     * @return the X coordinate in pixels
     */
    public int getClientX() {
      return ((Number) getEventMap().get("clientX")).intValue();
    }

    /**
     * Gets the Y coordinate of the mouse pointer relative to the viewport.
     *
     * @return the Y coordinate in pixels
     */
    public int getClientY() {
      return ((Number) getEventMap().get("clientY")).intValue();
    }
  }

  /**
   * Event fired when the QR code is double-clicked.
   */
  @EventName("dblclick")
  @EventOptions(data = { 
    @EventOptions.EventData(key = "clientX", exp = "event.clientX"),
    @EventOptions.EventData(key = "clientY", exp = "event.clientY")
  })
  public static class DoubleClickEvent extends ComponentEvent<QRCode> {

    public DoubleClickEvent(QRCode source, Map<String, Object> detail) {
      super(source, detail);
    }

    /**
     * Gets the X coordinate of the mouse pointer relative to the viewport.
     *
     * @return the X coordinate in pixels
     */
    public int getClientX() {
      return ((Number) getEventMap().get("clientX")).intValue();
    }

    /**
     * Gets the Y coordinate of the mouse pointer relative to the viewport.
     *
     * @return the Y coordinate in pixels
     */
    public int getClientY() {
      return ((Number) getEventMap().get("clientY")).intValue();
    }
  }

  /**
   * Event fired when the mouse enters the QR code area.
   */
  @EventName("mouseenter")
  public static class MouseEnterEvent extends ComponentEvent<QRCode> {

    public MouseEnterEvent(QRCode source, Map<String, Object> detail) {
      super(source, detail);
    }
  }

  /**
   * Event fired when the mouse leaves the QR code area.
   */
  @EventName("mouseleave")
  public static class MouseLeaveEvent extends ComponentEvent<QRCode> {

    public MouseLeaveEvent(QRCode source, Map<String, Object> detail) {
      super(source, detail);
    }
  }

  /**
   * Event fired when the context menu is requested (right-click).
   */
  @EventName("contextmenu")
  @EventOptions(data = { 
    @EventOptions.EventData(key = "clientX", exp = "event.clientX"),
    @EventOptions.EventData(key = "clientY", exp = "event.clientY")
  })
  public static class ContextMenuEvent extends ComponentEvent<QRCode> {

    public ContextMenuEvent(QRCode source, Map<String, Object> detail) {
      super(source, detail);
    }

    /**
     * Gets the X coordinate of the mouse pointer relative to the viewport.
     *
     * @return the X coordinate in pixels
     */
    public int getClientX() {
      return ((Number) getEventMap().get("clientX")).intValue();
    }

    /**
     * Gets the Y coordinate of the mouse pointer relative to the viewport.
     *
     * @return the Y coordinate in pixels
     */
    public int getClientY() {
      return ((Number) getEventMap().get("clientY")).intValue();
    }
  }
}