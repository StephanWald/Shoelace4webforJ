package com.webforj.libraries.shoelace.components;

import com.webforj.component.element.ElementComposite;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.concern.HasComponents;
import com.webforj.concern.HasStyle;

/**
 * Cards can be used to group related subjects in a container.
 * 
 * @see <a href="https://shoelace.style/components/card">Shoelace Card Documentation</a>
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/components/card/card.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-card")
@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.20.1/cdn/themes/light.css")
public class Card extends ElementComposite implements HasStyle<Card>, HasComponents {
  
  public Card() {
    super();
  }
  
  /**
   * Adds content to the card body.
   */
  @Override
  public void add(com.webforj.component.Component... components) {
    getBoundComponent().add(components);
  }
  
  /**
   * Sets the card header content.
   */
  public Card setHeader(com.webforj.component.Component header) {
    getBoundComponent().add("header", header);
    return this;
  }
  
  /**
   * Sets the card header with text.
   */
  public Card setHeader(String headerText) {
    com.webforj.component.html.elements.Div headerDiv = new com.webforj.component.html.elements.Div();
    headerDiv.setText(headerText);
    return setHeader(headerDiv);
  }
  
  /**
   * Sets the card footer content.
   */
  public Card setFooter(com.webforj.component.Component footer) {
    getBoundComponent().add("footer", footer);
    return this;
  }
  
  /**
   * Sets the card footer with text.
   */
  public Card setFooter(String footerText) {
    com.webforj.component.html.elements.Div footerDiv = new com.webforj.component.html.elements.Div();
    footerDiv.setText(footerText);
    return setFooter(footerDiv);
  }
  
  /**
   * Sets the card image.
   */
  public Card setImage(com.webforj.component.Component image) {
    getBoundComponent().add("image", image);
    return this;
  }
  
  /**
   * Sets the card image with URL.
   */
  public Card setImage(String imageUrl, String alt) {
    com.webforj.component.html.elements.Img img = new com.webforj.component.html.elements.Img();
    img.setSrc(imageUrl);
    img.setAlt(alt);
    img.setStyle("width", "100%");
    img.setStyle("height", "auto");
    return setImage(img);
  }
}