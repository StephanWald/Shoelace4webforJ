package com.webforj.libraries.shoelace.sample.views;

import com.webforj.libraries.shoelace.components.Dialog;
import com.webforj.libraries.shoelace.components.ShoelaceButton;
import com.webforj.libraries.shoelace.sample.components.DocumentationLinks;
import com.webforj.component.Composite;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.*;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/dialog", outlet = MainLayout.class)
@FrameTitle("Dialog")
public class DialogView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public DialogView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setPadding("20px");
    self.setSpacing("40px");
    self.setMaxWidth("800px");
    self.setMargin("0 auto");

    // Header section
    FlexLayout header = new FlexLayout();
    header.setDirection(FlexDirection.COLUMN);
    header.setSpacing("10px");

    H1 title = new H1("Dialog");
    Paragraph description = new Paragraph(
      "Dialogs are modal overlays that interrupt the current workflow to display important information " +
      "or request user input. They're commonly used for confirmations, forms, and alerts."
    );

    // Documentation links
    DocumentationLinks docLinks = new DocumentationLinks(
      "/static/javadoc/com/webforj/libraries/shoelace/components/Dialog.html",
      "https://shoelace.style/components/dialog"
    );

    header.add(title, description, docLinks);

    // Basic dialog section
    FlexLayout basicExample = createSection(
      "Basic Dialog",
      "A simple dialog with a title and content."
    );

    FlexLayout basicDemo = new FlexLayout();
    basicDemo.setDirection(FlexDirection.COLUMN);
    basicDemo.setSpacing("20px");

    // Create basic dialog
    Dialog basicDialog = new Dialog("Basic Dialog");
    Paragraph dialogContent = new Paragraph(
      "This is a basic dialog with some content. Dialogs interrupt the user's workflow " +
      "to display important messages or collect information."
    );

    // Add footer with close button
    Div basicFooter = new Div();
    basicFooter.setAttribute("slot", "footer");
    ShoelaceButton closeBtn = new ShoelaceButton("Close");
    closeBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    closeBtn.onClick(e -> basicDialog.hide());
    basicFooter.add(closeBtn);

    basicDialog.add(dialogContent, basicFooter);

    // Button to open dialog
    ShoelaceButton openBasicBtn = new ShoelaceButton("Open Basic Dialog");
    openBasicBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    openBasicBtn.onClick(e -> basicDialog.show());

    Div basicCode = new Div();
    basicCode.setText(
      "// Create a basic dialog\n" +
      "Dialog dialog = new Dialog(\"Dialog Title\");\n" +
      "dialog.add(new Paragraph(\"Dialog content\"));\n\n" +
      "// Add footer with close button\n" +
      "Div footer = new Div();\n" +
      "footer.setAttribute(\"slot\", \"footer\");\n" +
      "ShoelaceButton closeBtn = new ShoelaceButton(\"Close\");\n" +
      "closeBtn.onClick(e -> dialog.hide());\n" +
      "footer.add(closeBtn);\n" +
      "dialog.add(footer);\n\n" +
      "// Show the dialog\n" +
      "dialog.show();"
    );
    styleCodeBlock(basicCode);

    basicDemo.add(openBasicBtn, basicCode);
    basicExample.add(basicDemo);
    
    // Add dialog to self so it's properly positioned
    self.add(basicDialog);

    // Custom width section
    FlexLayout widthExample = createSection(
      "Custom Width",
      "Dialogs can have custom widths to fit your content."
    );

    FlexLayout widthDemo = new FlexLayout();
    widthDemo.setDirection(FlexDirection.COLUMN);
    widthDemo.setSpacing("20px");

    // Small dialog
    Dialog smallDialog = new Dialog("Small Dialog");
    smallDialog.setWidth("300px");
    smallDialog.add(new Paragraph("This is a small dialog with a width of 300px."));

    Div smallFooter = new Div();
    smallFooter.setAttribute("slot", "footer");
    ShoelaceButton smallCloseBtn = new ShoelaceButton("Close");
    smallCloseBtn.onClick(e -> smallDialog.hide());
    smallFooter.add(smallCloseBtn);
    smallDialog.add(smallFooter);

    // Large dialog
    Dialog largeDialog = new Dialog("Large Dialog");
    largeDialog.setWidth("80vw");
    largeDialog.add(new Paragraph(
      "This is a large dialog that takes up 80% of the viewport width. " +
      "It's useful for displaying more complex content or forms."
    ));

    Div largeFooter = new Div();
    largeFooter.setAttribute("slot", "footer");
    ShoelaceButton largeCloseBtn = new ShoelaceButton("Close");
    largeCloseBtn.onClick(e -> largeDialog.hide());
    largeFooter.add(largeCloseBtn);
    largeDialog.add(largeFooter);

    FlexLayout widthButtons = new FlexLayout();
    widthButtons.setSpacing("10px");

    ShoelaceButton openSmallBtn = new ShoelaceButton("Small Dialog (300px)");
    openSmallBtn.onClick(e -> smallDialog.show());

    ShoelaceButton openLargeBtn = new ShoelaceButton("Large Dialog (80vw)");
    openLargeBtn.onClick(e -> largeDialog.show());

    widthButtons.add(openSmallBtn, openLargeBtn);

    Div widthCode = new Div();
    widthCode.setText(
      "// Set custom width\n" +
      "dialog.setWidth(\"400px\");\n" +
      "dialog.setWidth(\"50vw\");\n" +
      "dialog.setWidth(\"600px\");"
    );
    styleCodeBlock(widthCode);

    widthDemo.add(widthButtons, widthCode);
    widthExample.add(widthDemo);
    
    // Add dialogs to self so they're properly positioned
    self.add(smallDialog, largeDialog);

    // No header section
    FlexLayout noHeaderExample = createSection(
      "Dialog Without Header",
      "Hide the header for a cleaner look."
    );

    FlexLayout noHeaderDemo = new FlexLayout();
    noHeaderDemo.setDirection(FlexDirection.COLUMN);
    noHeaderDemo.setSpacing("20px");

    Dialog noHeaderDialog = new Dialog();
    noHeaderDialog.setNoHeader(true);
    noHeaderDialog.setWidth("400px");

    FlexLayout noHeaderContent = new FlexLayout();
    noHeaderContent.setDirection(FlexDirection.COLUMN);
    noHeaderContent.setSpacing("15px");
    noHeaderContent.setAlignment(FlexAlignment.CENTER);

    Div icon = new Div();
    icon.add(TablerIcon.create("circle-check"));
    icon.setStyle("color", "#10b981");
    icon.setStyle("text-align", "center");

    H3 successTitle = new H3("Success!");
    successTitle.setStyle("text-align", "center");
    successTitle.setStyle("margin", "0");

    Paragraph successMsg = new Paragraph("Your changes have been saved successfully.");
    successMsg.setStyle("text-align", "center");

    noHeaderContent.add(icon, successTitle, successMsg);
    noHeaderDialog.add(noHeaderContent);

    Div noHeaderFooter = new Div();
    noHeaderFooter.setAttribute("slot", "footer");
    noHeaderFooter.setStyle("text-align", "center");
    ShoelaceButton okBtn = new ShoelaceButton("OK");
    okBtn.setVariant(ShoelaceButton.Variant.SUCCESS);
    okBtn.onClick(e -> noHeaderDialog.hide());
    noHeaderFooter.add(okBtn);
    noHeaderDialog.add(noHeaderFooter);

    ShoelaceButton openNoHeaderBtn = new ShoelaceButton("Open Dialog Without Header");
    openNoHeaderBtn.setVariant(ShoelaceButton.Variant.SUCCESS);
    openNoHeaderBtn.onClick(e -> noHeaderDialog.show());

    Div noHeaderCode = new Div();
    noHeaderCode.setText(
      "// Create dialog without header\n" +
      "Dialog dialog = new Dialog();\n" +
      "dialog.setNoHeader(true);\n" +
      "dialog.setWidth(\"400px\");\n\n" +
      "// Add custom content\n" +
      "dialog.add(icon, title, message);"
    );
    styleCodeBlock(noHeaderCode);

    noHeaderDemo.add(openNoHeaderBtn, noHeaderCode);
    noHeaderExample.add(noHeaderDemo);
    
    // Add dialog to self so it's properly positioned
    self.add(noHeaderDialog);

    // Form dialog section
    FlexLayout formExample = createSection(
      "Form Dialog",
      "Use dialogs to collect user input."
    );

    FlexLayout formDemo = new FlexLayout();
    formDemo.setDirection(FlexDirection.COLUMN);
    formDemo.setSpacing("20px");

    Dialog formDialog = new Dialog("User Information");
    formDialog.setWidth("500px");

    FlexLayout form = new FlexLayout();
    form.setDirection(FlexDirection.COLUMN);
    form.setSpacing("15px");

    TextField nameField = new TextField();
    nameField.setLabel("Name");
    nameField.setPlaceholder("Enter your name");
    nameField.setRequired(true);

    TextField emailField = new TextField();
    emailField.setLabel("Email");
    emailField.setPlaceholder("Enter your email");
    emailField.setRequired(true);
    // Note: setType for email validation would need to be implemented

    form.add(nameField, emailField);
    formDialog.add(form);

    Div formFooter = new Div();
    formFooter.setAttribute("slot", "footer");

    FlexLayout footerButtons = new FlexLayout();
    footerButtons.setSpacing("10px");
    footerButtons.setAlignment(FlexAlignment.END);

    ShoelaceButton cancelBtn = new ShoelaceButton("Cancel");
    cancelBtn.setVariant(ShoelaceButton.Variant.DEFAULT);
    cancelBtn.onClick(e -> {
      nameField.setValue("");
      emailField.setValue("");
      formDialog.hide();
    });

    ShoelaceButton submitBtn = new ShoelaceButton("Submit");
    submitBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    submitBtn.onClick(e -> {
      // In a real app, you would validate and submit the form
      formDialog.hide();
    });

    footerButtons.add(cancelBtn, submitBtn);
    formFooter.add(footerButtons);
    formDialog.add(formFooter);

    ShoelaceButton openFormBtn = new ShoelaceButton("Open Form Dialog");
    openFormBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    openFormBtn.onClick(e -> formDialog.show());

    Div formCode = new Div();
    formCode.setText(
      "// Create form dialog\n" +
      "Dialog dialog = new Dialog(\"User Form\");\n\n" +
      "// Add form fields\n" +
      "TextField name = new TextField();\n" +
      "name.setLabel(\"Name\");\n" +
      "TextField email = new TextField();\n" +
      "email.setLabel(\"Email\");\n\n" +
      "dialog.add(name, email);\n\n" +
      "// Add footer buttons\n" +
      "ShoelaceButton cancel = new ShoelaceButton(\"Cancel\");\n" +
      "cancel.onClick(e -> dialog.hide());\n" +
      "ShoelaceButton submit = new ShoelaceButton(\"Submit\");\n" +
      "submit.onClick(e -> submitForm());"
    );
    styleCodeBlock(formCode);

    formDemo.add(openFormBtn, formCode);
    formExample.add(formDemo);
    
    // Add dialog to self so it's properly positioned
    self.add(formDialog);

    // Confirmation dialog section
    FlexLayout confirmExample = createSection(
      "Confirmation Dialog",
      "Ask users to confirm important actions."
    );

    FlexLayout confirmDemo = new FlexLayout();
    confirmDemo.setDirection(FlexDirection.COLUMN);
    confirmDemo.setSpacing("20px");

    Dialog confirmDialog = new Dialog("Confirm Delete");
    confirmDialog.setWidth("400px");

    FlexLayout confirmContent = new FlexLayout();
    confirmContent.setDirection(FlexDirection.COLUMN);
    confirmContent.setSpacing("10px");

    Div warningIcon = new Div();
    warningIcon.add(TablerIcon.create("alert-triangle"));
    warningIcon.setStyle("color", "#ef4444");

    Paragraph confirmText = new Paragraph(
      "Are you sure you want to delete this item? This action cannot be undone."
    );

    confirmContent.add(warningIcon, confirmText);
    confirmDialog.add(confirmContent);

    Div confirmFooter = new Div();
    confirmFooter.setAttribute("slot", "footer");

    FlexLayout confirmButtons = new FlexLayout();
    confirmButtons.setSpacing("10px");
    confirmButtons.setAlignment(FlexAlignment.END);

    ShoelaceButton keepBtn = new ShoelaceButton("Keep Item");
    keepBtn.setVariant(ShoelaceButton.Variant.DEFAULT);
    keepBtn.onClick(e -> confirmDialog.hide());

    ShoelaceButton deleteBtn = new ShoelaceButton("Delete");
    deleteBtn.setVariant(ShoelaceButton.Variant.DANGER);
    deleteBtn.onClick(e -> {
      // In a real app, perform the delete action
      confirmDialog.hide();
    });

    confirmButtons.add(keepBtn, deleteBtn);
    confirmFooter.add(confirmButtons);
    confirmDialog.add(confirmFooter);

    ShoelaceButton openConfirmBtn = new ShoelaceButton("Delete Item");
    openConfirmBtn.setVariant(ShoelaceButton.Variant.DANGER);
    openConfirmBtn.onClick(e -> confirmDialog.show());

    Div confirmCode = new Div();
    confirmCode.setText(
      "// Create confirmation dialog\n" +
      "Dialog dialog = new Dialog(\"Confirm Action\");\n\n" +
      "// Add warning content\n" +
      "dialog.add(warningIcon, warningMessage);\n\n" +
      "// Add action buttons\n" +
      "ShoelaceButton cancel = new ShoelaceButton(\"Cancel\");\n" +
      "ShoelaceButton confirm = new ShoelaceButton(\"Confirm\");\n" +
      "confirm.setVariant(Variant.DANGER);\n" +
      "confirm.onClick(e -> performAction());"
    );
    styleCodeBlock(confirmCode);

    confirmDemo.add(openConfirmBtn, confirmCode);
    confirmExample.add(confirmDemo);
    
    // Add dialog to self so it's properly positioned
    self.add(confirmDialog);

    // Event handling section
    FlexLayout eventsSection = createEventsSection();

    // Properties table
    FlexLayout propertiesSection = createSection(
      "Properties & Methods",
      "The Dialog component supports the following properties and methods:"
    );

    FlexLayout propertiesTable = createPropertiesTable();
    propertiesSection.add(propertiesTable);

    // Add all sections to main layout
    self.add(header, basicExample, widthExample, noHeaderExample,
             formExample, confirmExample, eventsSection, propertiesSection);
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

  private FlexLayout createPropertiesTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden");

    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
      createTableCell("Property/Method", true),
      createTableCell("Description", true),
      createTableCell("Type", true),
      createTableCell("Default", true)
    );
    table.add(headerRow);

    // Properties and methods
    String[][] items = {
      {"open", "Controls dialog visibility", "boolean", "false"},
      {"label", "Dialog title", "String", "\"\""},
      {"no-header", "Hides the header", "boolean", "false"},
      {"show()", "Opens the dialog", "method", "-"},
      {"hide()", "Closes the dialog", "method", "-"},
      {"setWidth()", "Sets custom width", "method", "-"},
      {"setHeaderSpacing()", "Sets header padding", "method", "-"},
      {"setBodySpacing()", "Sets body padding", "method", "-"},
      {"setFooterSpacing()", "Sets footer padding", "method", "-"}
    };

    for (String[] item : items) {
      FlexLayout row = createTableRow(false);
      row.add(
        createTableCell(item[0], false),
        createTableCell(item[1], false),
        createTableCell(item[2], false),
        createTableCell(item[3], false)
      );
      table.add(row);
    }

    return table;
  }

  private FlexLayout createTableRow(boolean isHeader) {
    FlexLayout row = new FlexLayout();
    row.setStyle("border-bottom", "1px solid #dee2e6");
    if (isHeader) {
      row.setStyle("background", "#f8f9fa")
         .setStyle("font-weight", "bold");
    }
    return row;
  }

  private Div createTableCell(String content, boolean isHeader) {
    Div cell = new Div();
    cell.setText(content);
    cell.setStyle("padding", "12px 16px")
        .setStyle("flex", "1");
    if (isHeader) {
      cell.setStyle("font-weight", "600");
    }
    return cell;
  }

  private FlexLayout createEventsSection() {
    FlexLayout section = createSection(
      "Event Handling",
      "Dialogs emit events during their lifecycle, allowing you to hook into show/hide animations and handle close requests."
    );

    FlexLayout eventsDemo = new FlexLayout();
    eventsDemo.setDirection(FlexDirection.COLUMN);
    eventsDemo.setSpacing("20px");

    // Event dialog
    Dialog eventDialog = new Dialog("Event Demo Dialog");
    eventDialog.add(new Paragraph("Watch the event log below as you interact with this dialog."));
    
    ShoelaceButton closeBtn = new ShoelaceButton("Close");
    closeBtn.setVariant(ShoelaceButton.Variant.PRIMARY);
    closeBtn.onClick(e -> eventDialog.hide());
    eventDialog.addToFooter(closeBtn);

    // Event status display
    Label eventStatus = new Label("Event log will appear here...");
    eventStatus.setStyle("padding", "16px")
               .setStyle("background", "#f8f9fa")
               .setStyle("border-radius", "8px")
               .setStyle("font-size", "14px")
               .setStyle("min-height", "150px")
               .setStyle("white-space", "pre-wrap")
               .setStyle("border", "1px solid #e9ecef")
               .setStyle("display", "block");

    // Register event handlers
    eventDialog.onShow(event -> {
      eventStatus.setText("Event: sl-show\nDialog is starting to show...");
    });

    eventDialog.onAfterShow(event -> {
      String current = eventStatus.getText();
      eventStatus.setText(current + "\n\nEvent: sl-after-show\nDialog is fully visible!");
    });

    eventDialog.onHide(event -> {
      String current = eventStatus.getText();
      eventStatus.setText(current + "\n\nEvent: sl-hide\nDialog is starting to hide...");
    });

    eventDialog.onAfterHide(event -> {
      String current = eventStatus.getText();
      eventStatus.setText(current + "\n\nEvent: sl-after-hide\nDialog is completely hidden!");
    });

    eventDialog.onInitialFocus(event -> {
      String current = eventStatus.getText();
      eventStatus.setText(current + "\n\nEvent: sl-initial-focus\nDialog received initial focus!");
    });

    eventDialog.onRequestClose(event -> {
      String current = eventStatus.getText();
      String source = event.getSource();
      eventStatus.setText(current + "\n\nEvent: sl-request-close\nClose requested from: " + source);
      
      // Example: prevent closing from overlay clicks
      if ("overlay".equals(source)) {
        eventStatus.setText(eventStatus.getText() + "\n-> Prevented closing from overlay!");
        // Note: preventDefault() would normally be called here to prevent closing
        // event.preventDefault();
      }
    });

    // Control button
    ShoelaceButton showEventDialog = new ShoelaceButton("Show Event Dialog");
    showEventDialog.setVariant(ShoelaceButton.Variant.PRIMARY);
    showEventDialog.onClick(e -> eventDialog.show());

    // Code example
    Div eventCode = new Div();
    eventCode.setText(
      "// Show event - fired when dialog starts to show\n" +
      "dialog.onShow(event -> {\n" +
      "    System.out.println(\"Dialog is opening...\");\n" +
      "});\n\n" +
      "// After show event - fired when show animation completes\n" +
      "dialog.onAfterShow(event -> {\n" +
      "    System.out.println(\"Dialog is fully visible\");\n" +
      "});\n\n" +
      "// Hide event - fired when dialog starts to hide\n" +
      "dialog.onHide(event -> {\n" +
      "    System.out.println(\"Dialog is closing...\");\n" +
      "});\n\n" +
      "// After hide event - fired when hide animation completes\n" +
      "dialog.onAfterHide(event -> {\n" +
      "    System.out.println(\"Dialog is completely hidden\");\n" +
      "});\n\n" +
      "// Initial focus event - fired when dialog gains focus\n" +
      "dialog.onInitialFocus(event -> {\n" +
      "    System.out.println(\"Dialog received focus\");\n" +
      "});\n\n" +
      "// Request close event - fired when user attempts to close\n" +
      "dialog.onRequestClose(event -> {\n" +
      "    String source = event.getSource(); // \"close-button\", \"keyboard\", or \"overlay\"\n" +
      "    if (shouldPreventClose(source)) {\n" +
      "        event.preventDefault(); // Prevent the dialog from closing\n" +
      "    }\n" +
      "});"
    );
    styleCodeBlock(eventCode);

    self.add(eventDialog);
    eventsDemo.add(showEventDialog, eventStatus, eventCode);
    section.add(eventsDemo);
    
    // Events table
    FlexLayout eventsTable = createEventsTable();
    section.add(eventsTable);
    
    return section;
  }

  private FlexLayout createEventsTable() {
    FlexLayout table = new FlexLayout();
    table.setDirection(FlexDirection.COLUMN);
    table.setStyle("border", "1px solid #dee2e6")
         .setStyle("border-radius", "8px")
         .setStyle("overflow", "hidden")
         .setStyle("margin-top", "20px");

    // Header row
    FlexLayout headerRow = createTableRow(true);
    headerRow.add(
      createTableCell("Event", true),
      createTableCell("Description", true),
      createTableCell("Event Data", true)
    );
    table.add(headerRow);

    // Event rows
    String[][] events = {
      {"sl-show", "Emitted when the dialog begins to show", "None"},
      {"sl-after-show", "Emitted after the dialog opens and animations complete", "None"},
      {"sl-hide", "Emitted when the dialog begins to hide", "None"},
      {"sl-after-hide", "Emitted after the dialog closes and animations complete", "None"},
      {"sl-initial-focus", "Emitted when the dialog should set initial focus", "None"},
      {"sl-request-close", "Emitted when the dialog wants to close", "source: string - 'close-button', 'keyboard', or 'overlay'"}
    };

    for (String[] event : events) {
      FlexLayout row = createTableRow(false);
      row.add(
        createTableCell(event[0], false),
        createTableCell(event[1], false),
        createTableCell(event[2], false)
      );
      table.add(row);
    }

    return table;
  }
}
