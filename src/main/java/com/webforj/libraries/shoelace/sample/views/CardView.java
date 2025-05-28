package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Card;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.components.Badge;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.*;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/card", outlet = MainLayout.class)
@FrameTitle("Card")
public class CardView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public CardView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("15px");

    H1 title = new H1("Card");
    Paragraph description = new Paragraph(
      "Cards can be used to group related subjects in a container. They support headers, " +
      "footers, images, and various content layouts."
    );

    // Component import
    Div componentImport = new Div();
    componentImport.setText("import com.webforj.libraries.shoelace.components.Card;");
    componentImport.setStyle("background", "#f0f0f0")
                   .setStyle("padding", "8px 12px")
                   .setStyle("border-radius", "4px")
                   .setStyle("font-family", "monospace")
                   .setStyle("font-size", "14px")
                   .setStyle("margin-bottom", "10px");

    // Documentation links
    DocumentationLinks docsLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Card.html",
      "https://shoelace.style/components/card"
    );

    header.add(title, description, componentImport, docsLinks);

    // Basic card section
    FlexLayout basicExample = createSection(
      "Basic Card",
      "A basic card with content."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    Card basicCard = new Card();
    basicCard.setStyle("max-width", "400px");

    Div cardContent = new Div();
    cardContent.setText(
      "This is just a basic card. No image, no header, and no footer. " +
      "Just your content."
    );
    basicCard.add(cardContent);

    Div basicCode = new Div();
    basicCode.setText(
      "Card card = new Card();\n\n" +
      "Div content = new Div();\n" +
      "content.setText(\"Card content goes here.\");\n" +
      "card.add(content);"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(basicCard, basicCode);
    basicExample.add(basicDemo);

    // Card with header section
    FlexLayout headerExample = createSection(
      "Card with Header",
      "Cards can have a header to provide context."
    );

    FlexLayout headerDemo = new FlexLayout();
    headerDemo.setDirection(FlexDirection.COLUMN);
    headerDemo.setSpacing("20px");

    Card headerCard = new Card();
    headerCard.setStyle("max-width", "400px");
    headerCard.setHeader("Card Header");

    Div headerContent = new Div();
    headerContent.setText(
      "Some quick example text to build on the card title and make up " +
      "the bulk of the card's content."
    );
    headerCard.add(headerContent);

    Div headerCode = new Div();
    headerCode.setText(
      "Card card = new Card();\n" +
      "card.setHeader(\"Card Header\");\n\n" +
      "Div content = new Div();\n" +
      "content.setText(\"Card content...\");\n" +
      "card.add(content);"
    );
    styleCodeBlock(headerCode);

    headerDemo.add(headerCard, headerCode);
    headerExample.add(headerDemo);

    // Card with header, footer, and image section
    FlexLayout fullExample = createSection(
      "Complete Card",
      "A card with header, image, content, and footer."
    );

    FlexLayout fullDemo = new FlexLayout();
    fullDemo.setDirection(FlexDirection.COLUMN);
    fullDemo.setSpacing("20px");

    Card fullCard = new Card();
    fullCard.setStyle("max-width", "400px");

    // Header with icon
    FlexLayout cardHeader = new FlexLayout();
    cardHeader.setAlignment(FlexAlignment.CENTER);
    cardHeader.setSpacing("10px");
    cardHeader.add(TablerIcon.create("photo"));
    cardHeader.add(new Span("Featured Image"));
    fullCard.setHeader(cardHeader);

    // Image
    fullCard.setImage("https://images.unsplash.com/photo-1559209172-0ff8f6d49ff7?w=500&h=300&fit=crop", "Kitten");

    // Content
    FlexLayout cardBody = new FlexLayout();
    cardBody.setDirection(FlexDirection.COLUMN);
    cardBody.setSpacing("10px");

    H3 cardTitle = new H3("Mittens");
    cardTitle.setStyle("margin", "0");

    Paragraph cardText = new Paragraph(
      "This kitten is as cute as he is playful. Bring him home today!"
    );
    cardText.setStyle("margin", "0");

    Div cardMeta = new Div("6 weeks old");
    cardMeta.setStyle("color", "#6c757d");
    cardMeta.setStyle("font-size", "0.875rem");

    cardBody.add(cardTitle, cardText, cardMeta);
    fullCard.add(cardBody);

    // Footer with buttons
    FlexLayout cardFooter = new FlexLayout();
    cardFooter.setSpacing("10px");
    cardFooter.setJustifyContent(FlexJustifyContent.END);

    ShoelaceButton moreBtn = new ShoelaceButton("More Info");
    moreBtn.setVariant(ShoelaceButton.Variant.TEXT);
    moreBtn.setSize(ShoelaceButton.Size.SMALL);

    ShoelaceButton adoptBtn = new ShoelaceButton("Adopt");
    adoptBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    adoptBtn.setSize(ShoelaceButton.Size.SMALL);

    cardFooter.add(moreBtn, adoptBtn);
    fullCard.setFooter(cardFooter);

    Div fullCode = new Div();
    fullCode.setText(
      "Card card = new Card();\n\n" +
      "// Header with icon\n" +
      "FlexLayout header = new FlexLayout();\n" +
      "header.add(TablerIcon.create(\"photo\"));\n" +
      "header.add(new Span(\"Featured\"));\n" +
      "card.setHeader(header);\n\n" +
      "// Image\n" +
      "card.setImage(\"image-url.jpg\", \"Alt text\");\n\n" +
      "// Content\n" +
      "card.add(contentComponents);\n\n" +
      "// Footer\n" +
      "card.setFooter(footerComponents);"
    );
    styleCodeBlock(fullCode);

    fullDemo.add(fullCard, fullCode);
    fullExample.add(fullDemo);

    // Product card examples section
    FlexLayout productExample = createSection(
      "Product Cards",
      "Cards are perfect for displaying products or services."
    );

    FlexLayout productDemo = new FlexLayout();
    productDemo.setDirection(FlexDirection.COLUMN);
    productDemo.setSpacing("20px");

    FlexLayout productGrid = new FlexLayout();
    productGrid.setSpacing("20px");
    productGrid.setWrap(FlexWrap.WRAP);

    // Create product cards
    String[][] products = {
      {"https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400&h=300&fit=crop", "Smartwatch", "$299", "Latest model with health tracking"},
      {"https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400&h=300&fit=crop", "Headphones", "$199", "Wireless noise-cancelling"},
      {"https://images.unsplash.com/photo-1484704849700-f032a568e944?w=400&h=300&fit=crop", "Headphones Pro", "$349", "Premium audio experience"}
    };

    for (String[] product : products) {
      Card productCard = new Card();
      productCard.setStyle("width", "250px");

      // Image
      productCard.setImage(product[0], product[1]);

      // Content
      FlexLayout productContent = new FlexLayout();
      productContent.setDirection(FlexDirection.COLUMN);
      productContent.setSpacing("8px");
      productContent.setStyle("padding", "16px");

      H4 productName = new H4(product[1]);
      productName.setStyle("margin", "0");

      Div price = new Div(product[2]);
      price.setStyle("font-size", "1.25rem")
           .setStyle("font-weight", "bold")
           .setStyle("color", "#0969da");

      Div productDesc = new Div(product[3]);
      productDesc.setStyle("color", "#6c757d");
      productDesc.setStyle("font-size", "0.875rem");

      // Rating
      FlexLayout rating = new FlexLayout();
      rating.setSpacing("2px");
      for (int i = 0; i < 5; i++) {
        Div starWrapper = new Div();
        starWrapper.add(TablerIcon.create(i < 4 ? "star-filled" : "star"));
        starWrapper.setStyle("color", "#fbbf24");
        starWrapper.setStyle("width", "16px");
        starWrapper.setStyle("height", "16px");
        rating.add(starWrapper);
      }

      ShoelaceButton buyBtn = new ShoelaceButton("Add to Cart");
      buyBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
      buyBtn.setStyle("width", "100%");
      buyBtn.setStyle("margin-top", "8px");

      productContent.add(productName, price, productDesc, rating, buyBtn);
      productCard.add(productContent);

      productGrid.add(productCard);
    }

    Div productCode = new Div();
    productCode.setText(
      "// Product card example\n" +
      "Card card = new Card();\n" +
      "card.setImage(productImageUrl, productName);\n\n" +
      "// Add product details\n" +
      "FlexLayout content = new FlexLayout();\n" +
      "content.add(productName, price, description, rating);\n" +
      "card.add(content);\n\n" +
      "// Add action button\n" +
      "ShoelaceButton buyBtn = new ShoelaceButton(\"Add to Cart\");\n" +
      "content.add(buyBtn);"
    );
    styleCodeBlock(productCode);

    productDemo.add(productGrid, productCode);
    productExample.add(productDemo);

    // User profile card section
    FlexLayout profileExample = createSection(
      "Profile Cards",
      "Cards can display user profiles and social information."
    );

    FlexLayout profileDemo = new FlexLayout();
    profileDemo.setDirection(FlexDirection.COLUMN);
    profileDemo.setSpacing("20px");

    Card profileCard = new Card();
    profileCard.setStyle("max-width", "350px");

    // Cover image
    profileCard.setImage("https://images.unsplash.com/photo-1543610892-0b1f7e6d8ac1?w=400&h=200&fit=crop", "Profile background");

    // Profile content
    FlexLayout profileContent = new FlexLayout();
    profileContent.setDirection(FlexDirection.COLUMN);
    profileContent.setAlignment(FlexAlignment.CENTER);
    profileContent.setSpacing("12px");
    profileContent.setStyle("padding", "20px");
    profileContent.setStyle("text-align", "center");

    // Avatar (positioned over the image)
    Div avatarWrapper = new Div();
    avatarWrapper.setStyle("width", "80px");
    avatarWrapper.setStyle("height", "80px");
    avatarWrapper.setStyle("margin-top", "-60px");
    avatarWrapper.setStyle("border", "4px solid white");
    avatarWrapper.setStyle("box-shadow", "0 2px 8px rgba(0,0,0,0.15)");
    avatarWrapper.setStyle("border-radius", "50%");
    avatarWrapper.setStyle("overflow", "hidden");

  com.webforj.libraries.shoelace.components.Avatar profileAvatar = new  com.webforj.libraries.shoelace.components.Avatar();
    profileAvatar.setImage("https://images.unsplash.com/photo-1580489944761-15a19d654956?w=150&h=150&fit=crop");
    profileAvatar.setLabel("Jane Smith");
    avatarWrapper.add(profileAvatar);

    H3 userName = new H3("Jane Smith");
    userName.setStyle("margin", "0");

    Paragraph userBio = new Paragraph("Senior Product Designer");
    userBio.setStyle("margin", "0");
    userBio.setStyle("color", "#6c757d");

    // Stats
    FlexLayout stats = new FlexLayout();
    stats.setJustifyContent(FlexJustifyContent.CENTER);
    stats.setSpacing("30px");
    stats.setStyle("margin", "10px 0");

    String[][] statData = {{"128", "Projects"}, {"24K", "Followers"}, {"892", "Following"}};
    for (String[] stat : statData) {
      FlexLayout statItem = new FlexLayout();
      statItem.setDirection(FlexDirection.COLUMN);
      statItem.setAlignment(FlexAlignment.CENTER);

      Strong statValue = new Strong(stat[0]);
      statValue.setStyle("font-size", "1.25rem");

      Div statLabel = new Div(stat[1]);
      statLabel.setStyle("color", "#6c757d");
      statLabel.setStyle("font-size", "0.875rem");

      statItem.add(statValue, statLabel);
      stats.add(statItem);
    }

    // Badges
    FlexLayout badges = new FlexLayout();
    badges.setJustifyContent(FlexJustifyContent.CENTER);
    badges.setSpacing("8px");
    badges.setWrap(FlexWrap.WRAP);

    badges.add(new Badge("Pro", Badge.Variant.PRIMARY));
    badges.add(new Badge("Verified", Badge.Variant.SUCCESS));
    badges.add(new Badge("Top Contributor", Badge.Variant.WARNING));

    // Follow button
    ShoelaceButton followBtn = new ShoelaceButton("Follow");
    followBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    followBtn.setStyle("width", "100%");

    profileContent.add(avatarWrapper, userName, userBio, stats, badges, followBtn);
    profileCard.add(profileContent);

    Div profileCode = new Div();
    profileCode.setText(
      "// Profile card with cover image\n" +
      "Card card = new Card();\n" +
      "card.setImage(coverImageUrl, \"Cover\");\n\n" +
      "// Avatar positioned over image\n" +
      "Avatar avatar = new Avatar();\n" +
      "avatar.setStyle(\"margin-top\", \"-60px\");\n\n" +
      "// Add user info and stats\n" +
      "content.add(avatar, userName, bio, stats, badges);"
    );
    styleCodeBlock(profileCode);

    profileDemo.add(profileCard, profileCode);
    profileExample.add(profileDemo);

    // Add all sections to main layout
    self.add(header, basicExample, headerExample, fullExample,
             productExample, profileExample);
  }

  private FlexLayout createSection(String title, String description) {
    FlexLayout section = new FlexLayout();
    section.setDirection(FlexDirection.COLUMN);
    section.setSpacing("15px");

    H2 sectionTitle = new H2(title);
    Paragraph sectionDesc = new Paragraph(description);

    section.add(sectionTitle, sectionDesc);
    return section;
  }

  private void styleCodeBlock(Div code) {
    code.setStyle("background", "#f8f9fa")
        .setStyle("padding", "16px")
        .setStyle("border-radius", "8px")
        .setStyle("font-size", "14px")
        .setStyle("font-family", "monospace")
        .setStyle("white-space", "pre")
        .setStyle("overflow-x", "auto")
        .setStyle("border", "1px solid #e9ecef");
  }
}
