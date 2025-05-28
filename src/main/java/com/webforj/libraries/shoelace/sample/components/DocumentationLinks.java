package com.webforj.libraries.shoelace.sample.components;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.layout.flexlayout.FlexLayout;

/**
 * A reusable component that displays documentation links for Shoelace components.
 * Provides consistent styling and behavior for JavaDoc and Shoelace documentation buttons.
 */
public class DocumentationLinks extends Composite<FlexLayout> {
  private final FlexLayout container = getBoundComponent();
  private final String javadocPath;
  private final String shoelaceUrl;
  
  /**
   * Creates a new DocumentationLinks component.
   * 
   * @param javadocPath The relative path to the JavaDoc page (e.g., "/static/javadoc/com/webforj/libraries/shoelace/components/Alert.html")
   * @param shoelaceUrl The full URL to the Shoelace documentation page (e.g., "https://shoelace.style/components/alert")
   */
  public DocumentationLinks(String javadocPath, String shoelaceUrl) {
    this.javadocPath = javadocPath;
    this.shoelaceUrl = shoelaceUrl;
    
    initializeComponent();
  }
  
  private void initializeComponent() {
    // Configure container layout
    container.setSpacing("10px");
    container.setStyle("margin-top", "10px");
    
    // Create JavaDoc button
    Button javadocButton = new Button("📚 JavaDoc");
    javadocButton.addClickListener(e -> {
      container.getElement().executeJs(
        String.format("window.open('%s', '_blank');", javadocPath)
      );
    });
    
    // Create Shoelace documentation button
    Button shoelaceButton = new Button("🔗 Shoelace Docs");
    shoelaceButton.addClickListener(e -> {
      container.getElement().executeJs(
        String.format("window.open('%s', '_blank');", shoelaceUrl)
      );
    });
    
    // Add buttons to container
    container.add(javadocButton, shoelaceButton);
  }
}