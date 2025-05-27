package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;

/**
 * Button groups organize buttons into horizontal or vertical groups.
 * 
 * @see <a href="https://shoelace.style/components/button-group">Shoelace Button Group Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/button-group/button-group.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-button-group")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class ButtonGroup extends ElementComposite implements HasStyle<ButtonGroup>, HasComponents {
  
  // Properties
  private final PropertyDescriptor<String> labelProp = PropertyDescriptor.property("label", "");
  
  public ButtonGroup() {
    super();
  }
  
  /**
   * Sets the accessible label for the button group.
   */
  public ButtonGroup setLabel(String label) {
    set(labelProp, label);
    return this;
  }
  
  /**
   * Gets the accessible label.
   */
  public String getLabel() {
    return get(labelProp);
  }
  
  /**
   * Adds a button to the group.
   */
  public ButtonGroup addButton(ShoelaceButton button) {
    getBoundComponent().add(button);
    return this;
  }
  
  /**
   * Removes a button from the group.
   */
  public ButtonGroup removeButton(ShoelaceButton button) {
    getBoundComponent().remove(button);
    return this;
  }
  
  /**
   * Removes all buttons from the group.
   */
  public ButtonGroup clearButtons() {
    getBoundComponent().removeAll();
    return this;
  }
}