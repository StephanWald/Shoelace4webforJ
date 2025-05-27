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
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Shoelace Select component for choosing one or more options from a dropdown list.
 * 
 * <p>The Select component provides a customizable dropdown interface for selecting
 * values. It supports single and multiple selection modes, custom styling, and
 * comprehensive event handling.
 * 
 * <p>Example usage:
 * <pre>{@code
 * Select countrySelect = new Select("Choose your country");
 * countrySelect.setPlaceholder("Select a country");
 * countrySelect.setClearable(true);
 * 
 * countrySelect.addOption(new Option("United States", "us"));
 * countrySelect.addOption(new Option("Canada", "ca"));
 * countrySelect.addOption(new Option("Mexico", "mx"));
 * 
 * countrySelect.onChange(event -> {
 *   System.out.println("Selected: " + event.getValue());
 * });
 * }</pre>
 * 
 * @see Option
 * @see <a href="https://shoelace.style/components/select">Shoelace Select Documentation</a>
 * 
 * @author Your Name
 * @since 1.0.0
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/select/select.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-select")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public final class Select extends ElementComposite implements HasComponents {
  private final PropertyDescriptor<String> nameProp = PropertyDescriptor.property("name", "");
  private final PropertyDescriptor<String> valueProp = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<String> sizeProp = PropertyDescriptor.property("size", "medium");
  private final PropertyDescriptor<String> placeholderProp = PropertyDescriptor.property("placeholder", "");
  private final PropertyDescriptor<Boolean> multipleProp = PropertyDescriptor.property("multiple", false);
  private final PropertyDescriptor<Boolean> disabledProp = PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> clearableProp = PropertyDescriptor.property("clearable", false);
  private final PropertyDescriptor<Boolean> openProp = PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<String> placementProp = PropertyDescriptor.property("placement", "bottom");
  private final PropertyDescriptor<String> helpTextProp = PropertyDescriptor.property("help-text", "");
  private final PropertyDescriptor<Boolean> requiredProp = PropertyDescriptor.property("required", false);
  private final PropertyDescriptor<Integer> maxOptionsVisibleProp = PropertyDescriptor.property("max-options-visible", 3);
  private final PropertyDescriptor<Boolean> hoistselectProp = PropertyDescriptor.property("hoist", false);
  private final PropertyDescriptor<Boolean> filledProp = PropertyDescriptor.property("filled", false);
  private final PropertyDescriptor<Boolean> pillProp = PropertyDescriptor.property("pill", false);

  /**
   * Select sizes available for the component.
   */
  public enum Size {
    /** Small size select */
    SMALL("small"),
    /** Medium size select (default) */
    MEDIUM("medium"),
    /** Large size select */
    LARGE("large");

    private final String value;

    Size(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Dropdown placement options.
   */
  public enum Placement {
    /** Place dropdown above the select */
    TOP("top"),
    /** Place dropdown below the select (default) */
    BOTTOM("bottom");

    private final String value;

    Placement(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /**
   * Create a new Select component.
   */
  public Select() {
    super();
  }

  /**
   * Create a new Select with label.
   *
   * @param label the select label text
   */
  public Select(String label) {
    super();
    setLabel(label);
  }

  /**
   * Get the form field name.
   *
   * @return the name attribute
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Set the form field name.
   *
   * @param name the name attribute
   * @return this instance for method chaining
   */
  public Select setName(String name) {
    set(nameProp, name);
    return this;
  }

  /**
   * Get the selected value.
   *
   * @return the selected value, or comma-separated values if multiple
   */
  public String getValue() {
    return get(valueProp);
  }

  /**
   * Set the selected value.
   *
   * @param value the value to select
   * @return this instance for method chaining
   */
  public Select setValue(String value) {
    set(valueProp, value);
    return this;
  }

  /**
   * Get selected values for multiple select.
   *
   * @return list of selected values
   */
  public List<String> getValues() {
    String value = getValue();
    if (value == null || value.isEmpty()) {
      return Arrays.asList();
    }
    return Arrays.asList(value.split(","));
  }

  /**
   * Set multiple selected values.
   *
   * @param values the values to select
   * @return this instance for method chaining
   */
  public Select setValues(String... values) {
    set(valueProp, String.join(",", values));
    return this;
  }

  /**
   * Get the size.
   *
   * @return the current size value
   */
  public String getSize() {
    return get(sizeProp);
  }

  /**
   * Set the size using the Size enum.
   *
   * @param size the size to set
   * @return this instance for method chaining
   */
  public Select setSize(Size size) {
    set(sizeProp, size.getValue());
    return this;
  }

  /**
   * Set the size using a custom string value.
   *
   * @param size the size value
   * @return this instance for method chaining
   */
  public Select setSize(String size) {
    set(sizeProp, size);
    return this;
  }

  /**
   * Get the placeholder text.
   *
   * @return the placeholder
   */
  public String getPlaceholder() {
    return get(placeholderProp);
  }

  /**
   * Set the placeholder text.
   *
   * @param placeholder the placeholder text
   * @return this instance for method chaining
   */
  public Select setPlaceholder(String placeholder) {
    set(placeholderProp, placeholder);
    return this;
  }

  /**
   * Check if multiple selection is enabled.
   *
   * @return true if multiple selection is allowed
   */
  public boolean isMultiple() {
    return get(multipleProp);
  }

  /**
   * Set multiple selection mode.
   *
   * @param multiple true for multiple selection, false for single
   * @return this instance for method chaining
   */
  public Select setMultiple(boolean multiple) {
    set(multipleProp, multiple);
    return this;
  }

  /**
   * Check if the select is disabled.
   *
   * @return true if disabled, false otherwise
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Set the disabled state.
   *
   * @param disabled true to disable, false to enable
   * @return this instance for method chaining
   */
  public Select setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Check if the select is clearable.
   *
   * @return true if clearable
   */
  public boolean isClearable() {
    return get(clearableProp);
  }

  /**
   * Set the clearable state.
   * 
   * <p>When true, a clear button is shown when the select has a value.
   *
   * @param clearable true to make clearable
   * @return this instance for method chaining
   */
  public Select setClearable(boolean clearable) {
    set(clearableProp, clearable);
    return this;
  }

  /**
   * Check if the dropdown is open.
   *
   * @return true if open
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Set the open state programmatically.
   *
   * @param open true to open, false to close
   * @return this instance for method chaining
   */
  public Select setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Get the label text.
   *
   * @return the label
   */
  public String getLabel() {
    return get(labelProp);
  }

  /**
   * Set the label text.
   *
   * @param label the label text
   * @return this instance for method chaining
   */
  public Select setLabel(String label) {
    set(labelProp, label);
    return this;
  }

  /**
   * Get the dropdown placement.
   *
   * @return the placement value
   */
  public String getPlacement() {
    return get(placementProp);
  }

  /**
   * Set the dropdown placement.
   *
   * @param placement the placement direction
   * @return this instance for method chaining
   */
  public Select setPlacement(Placement placement) {
    set(placementProp, placement.getValue());
    return this;
  }

  /**
   * Get the help text.
   *
   * @return the help text
   */
  public String getHelpText() {
    return get(helpTextProp);
  }

  /**
   * Set the help text displayed below the select.
   *
   * @param helpText the help text
   * @return this instance for method chaining
   */
  public Select setHelpText(String helpText) {
    set(helpTextProp, helpText);
    return this;
  }

  /**
   * Check if the select is required.
   *
   * @return true if required
   */
  public boolean isRequired() {
    return get(requiredProp);
  }

  /**
   * Set the required state.
   *
   * @param required true if required
   * @return this instance for method chaining
   */
  public Select setRequired(boolean required) {
    set(requiredProp, required);
    return this;
  }

  /**
   * Get the maximum number of options visible for multiple select.
   *
   * @return the max options visible
   */
  public int getMaxOptionsVisible() {
    return get(maxOptionsVisibleProp);
  }

  /**
   * Set the maximum number of options visible for multiple select.
   *
   * @param maxOptionsVisible the max options visible
   * @return this instance for method chaining
   */
  public Select setMaxOptionsVisible(int maxOptionsVisible) {
    set(maxOptionsVisibleProp, maxOptionsVisible);
    return this;
  }

  /**
   * Check if the select has filled style.
   *
   * @return true if filled
   */
  public boolean isFilled() {
    return get(filledProp);
  }

  /**
   * Set the filled style.
   *
   * @param filled true for filled style
   * @return this instance for method chaining
   */
  public Select setFilled(boolean filled) {
    set(filledProp, filled);
    return this;
  }

  /**
   * Check if the select has pill style.
   *
   * @return true if pill
   */
  public boolean isPill() {
    return get(pillProp);
  }

  /**
   * Set the pill style.
   *
   * @param pill true for pill style
   * @return this instance for method chaining
   */
  public Select setPill(boolean pill) {
    set(pillProp, pill);
    return this;
  }

  /**
   * Add an option to the select
   *
   * @param option the option component
   * @return this instance
   */
  public Select addOption(Option option) {
    add(option);
    return this;
  }

  /**
   * Set the prefix slot content
   *
   * @param prefix the prefix component
   * @return this instance
   */
  public Select setPrefix(com.webforj.component.Component prefix) {
    getBoundComponent().add("prefix", prefix);
    return this;
  }

  /**
   * Set the suffix slot content
   *
   * @param suffix the suffix component
   * @return this instance
   */
  public Select setSuffix(com.webforj.component.Component suffix) {
    getBoundComponent().add("suffix", suffix);
    return this;
  }

  /**
   * Set custom label content
   *
   * @param label the label component
   * @return this instance
   */
  public Select setLabelSlot(com.webforj.component.Component label) {
    getBoundComponent().add("label", label);
    return this;
  }

  /**
   * Set custom help text content
   *
   * @param helpText the help text component
   * @return this instance
   */
  public Select setHelpTextSlot(com.webforj.component.Component helpText) {
    getBoundComponent().add("help-text", helpText);
    return this;
  }

  /**
   * Show the dropdown
   */
  public void show() {
    setOpen(true);
  }

  /**
   * Hide the dropdown
   */
  public void hide() {
    setOpen(false);
  }

  /**
   * Focus the select
   */
  public void focus() {
    // Note: Would need JavaScript interop
  }

  /**
   * Blur the select
   */
  public void blur() {
    // Note: Would need JavaScript interop
  }

  /**
   * Check validity.
   *
   * @return true if valid
   */
  public boolean checkValidity() {
    // Note: Would need JavaScript interop
    return true;
  }

  /**
   * Add a listener for the blur event.
   * 
   * <p>Fired when the select loses focus.
   *
   * @param listener the blur event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<BlurEvent> onBlur(EventListener<BlurEvent> listener) {
    return addEventListener(BlurEvent.class, listener);
  }

  /**
   * Add a listener for the change event.
   * 
   * <p>Fired when the selection changes.
   *
   * @param listener the change event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<ChangeEvent> onChange(EventListener<ChangeEvent> listener) {
    return addEventListener(ChangeEvent.class, listener);
  }

  /**
   * Add a listener for the clear event.
   * 
   * <p>Fired when the selection is cleared.
   *
   * @param listener the clear event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<ClearEvent> onClear(EventListener<ClearEvent> listener) {
    return addEventListener(ClearEvent.class, listener);
  }

  /**
   * Add a listener for the focus event.
   * 
   * <p>Fired when the select gains focus.
   *
   * @param listener the focus event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<FocusEvent> onFocus(EventListener<FocusEvent> listener) {
    return addEventListener(FocusEvent.class, listener);
  }

  /**
   * Add a listener for the input event.
   * 
   * <p>Fired when user types in a searchable select.
   *
   * @param listener the input event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InputEvent> onInput(EventListener<InputEvent> listener) {
    return addEventListener(InputEvent.class, listener);
  }

  /**
   * Add a listener for the show event.
   * 
   * <p>Fired when the dropdown opens.
   *
   * @param listener the show event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<ShowEvent> onShow(EventListener<ShowEvent> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Add a listener for the after-show event.
   * 
   * <p>Fired after the dropdown open animation completes.
   *
   * @param listener the after-show event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<AfterShowEvent> onAfterShow(EventListener<AfterShowEvent> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Add a listener for the hide event.
   * 
   * <p>Fired when the dropdown closes.
   *
   * @param listener the hide event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<HideEvent> onHide(EventListener<HideEvent> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Add a listener for the after-hide event.
   * 
   * <p>Fired after the dropdown close animation completes.
   *
   * @param listener the after-hide event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<AfterHideEvent> onAfterHide(EventListener<AfterHideEvent> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Add a listener for the invalid event.
   * 
   * <p>Fired when the select fails validation.
   *
   * @param listener the invalid event listener
   * @return the listener registration for removal
   */
  public ListenerRegistration<InvalidEvent> onInvalid(EventListener<InvalidEvent> listener) {
    return addEventListener(InvalidEvent.class, listener);
  }

  /**
   * Blur event fired when the select loses focus.
   */
  @EventName("sl-blur")
  public static class BlurEvent extends ComponentEvent<Select> {
    public BlurEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Change event fired when the selection changes.
   */
  @EventName("sl-change")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class ChangeEvent extends ComponentEvent<Select> {
    public ChangeEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the selected value(s).
     *
     * @return the selected value or comma-separated values
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }

    /**
     * Get the selected values as a list.
     *
     * @return list of selected values
     */
    public List<String> getValues() {
      String value = getValue();
      if (value == null || value.isEmpty()) {
        return Arrays.asList();
      }
      return Arrays.asList(value.split(","));
    }
  }

  /**
   * Clear event fired when the selection is cleared.
   */
  @EventName("sl-clear")
  public static class ClearEvent extends ComponentEvent<Select> {
    public ClearEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Focus event fired when the select gains focus.
   */
  @EventName("sl-focus")
  public static class FocusEvent extends ComponentEvent<Select> {
    public FocusEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Input event fired when user types in searchable select.
   */
  @EventName("sl-input")
  @EventOptions(data = {
    @EventOptions.EventData(key = "value", exp = "event.target.value")
  })
  public static class InputEvent extends ComponentEvent<Select> {
    public InputEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }

    /**
     * Get the input value.
     *
     * @return the search input value
     */
    public String getValue() {
      return (String) getEventMap().getOrDefault("value", "");
    }
  }

  /**
   * Show event fired when the dropdown opens.
   */
  @EventName("sl-show")
  public static class ShowEvent extends ComponentEvent<Select> {
    public ShowEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-show event fired after dropdown open animation.
   */
  @EventName("sl-after-show")
  public static class AfterShowEvent extends ComponentEvent<Select> {
    public AfterShowEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Hide event fired when the dropdown closes.
   */
  @EventName("sl-hide")
  public static class HideEvent extends ComponentEvent<Select> {
    public HideEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * After-hide event fired after dropdown close animation.
   */
  @EventName("sl-after-hide")
  public static class AfterHideEvent extends ComponentEvent<Select> {
    public AfterHideEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  /**
   * Invalid event fired when validation fails.
   */
  @EventName("sl-invalid")
  public static class InvalidEvent extends ComponentEvent<Select> {
    public InvalidEvent(Select component, Map<String, Object> eventData) {
      super(component, eventData);
    }
  }

  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
}