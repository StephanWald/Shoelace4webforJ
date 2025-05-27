package com.webforj.libraries.shoelace.components;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class DrawerHeader extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public DrawerHeader() {
    self.setDirection(FlexDirection.COLUMN);
    self.setSpacing("15px");
    self.setAlignment(FlexAlignment.CENTER);
    self.setPadding("20px 15px");

    // Logo and title container
    FlexLayout logoContainer = new FlexLayout();
    logoContainer.setAlignment(FlexAlignment.CENTER);
    logoContainer.setSpacing("10px");

    // Shoelace logo
    Img logo = new Img();
    logo.setSrc("static/shoelace-logo.svg");
    logo.setAlt("Shoelace Logo");
    logo.setStyle("width", "40px")
        .setStyle("height", "40px");

    // Title
    H2 title = new H2("Shoelace");
    title.setStyle("margin", "0")
         .setStyle("font-size", "1.5rem")
         .setStyle("font-weight", "600");

    logoContainer.add(logo, title);

    // Subtitle
    Paragraph subtitle = new Paragraph("Components in webforJ");
    subtitle.setStyle("color", "#86888f")
            .setStyle("font-size", "0.9em")
            .setStyle("margin", "0")
            .setStyle("text-align", "center");

    self.add(logoContainer, subtitle);
  }
}