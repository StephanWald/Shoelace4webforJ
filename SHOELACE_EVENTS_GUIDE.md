# Shoelace Components Event Implementation Guide

This guide outlines which events should be implemented for each Shoelace component based on the official documentation.

## Components with Events

### Alert
- `sl-show` - When alert starts to show
- `sl-after-show` - After show animation completes
- `sl-hide` - When alert starts to hide  
- `sl-after-hide` - After hide animation completes
- Standard: `click`, `mouseenter`, `mouseleave`

### Button (ShoelaceButton)
- `sl-blur` - When button loses focus
- `sl-focus` - When button gains focus
- `sl-invalid` - When form validation fails
- Standard: `click`, `dblclick`, `mouseenter`, `mouseleave`, `mousedown`, `mouseup`

### Dialog
- `sl-show` - When dialog starts to show
- `sl-after-show` - After show animation completes
- `sl-hide` - When dialog starts to hide
- `sl-after-hide` - After hide animation completes
- `sl-initial-focus` - When initial focus is set
- `sl-request-close` - When user attempts to close

### Drawer
- `sl-show` - When drawer starts to show
- `sl-after-show` - After show animation completes
- `sl-hide` - When drawer starts to hide
- `sl-after-hide` - After hide animation completes
- `sl-initial-focus` - When initial focus is set
- `sl-request-close` - When user attempts to close

### Dropdown
- `sl-show` - When dropdown starts to show
- `sl-after-show` - After show animation completes
- `sl-hide` - When dropdown starts to hide
- `sl-after-hide` - After hide animation completes

### Details
- `sl-show` - When details expands
- `sl-after-show` - After expand animation completes
- `sl-hide` - When details collapses
- `sl-after-hide` - After collapse animation completes

### Tab/TabGroup
- `sl-tab-show` - When tab is shown
- `sl-tab-hide` - When tab is hidden
- `sl-close` - When closable tab is closed

### Select
- `sl-change` - When selection changes
- `sl-clear` - When selection is cleared
- `sl-input` - When user types (if searchable)
- `sl-focus` - When select gains focus
- `sl-blur` - When select loses focus
- `sl-show` - When dropdown opens
- `sl-after-show` - After dropdown animation
- `sl-hide` - When dropdown closes
- `sl-after-hide` - After close animation
- `sl-invalid` - When validation fails

### Input
- `sl-blur` - When input loses focus
- `sl-change` - When value changes and input loses focus
- `sl-clear` - When clear button is clicked
- `sl-focus` - When input gains focus
- `sl-input` - When user types
- `sl-invalid` - When validation fails

### Textarea
- `sl-blur` - When textarea loses focus
- `sl-change` - When value changes and loses focus
- `sl-focus` - When textarea gains focus
- `sl-input` - When user types
- `sl-invalid` - When validation fails

### Checkbox
- `sl-blur` - When checkbox loses focus
- `sl-change` - When checked state changes
- `sl-focus` - When checkbox gains focus
- `sl-input` - When value changes (before blur)
- `sl-invalid` - When validation fails

### Radio/RadioGroup
- `sl-blur` - When radio loses focus
- `sl-change` - When selection changes
- `sl-focus` - When radio gains focus
- `sl-input` - When value changes

### Switch
- `sl-blur` - When switch loses focus
- `sl-change` - When checked state changes
- `sl-focus` - When switch gains focus
- `sl-input` - When value changes
- `sl-invalid` - When validation fails

### Range
- `sl-blur` - When range loses focus
- `sl-change` - When value changes and loses focus
- `sl-focus` - When range gains focus
- `sl-input` - When value changes during drag
- `sl-invalid` - When validation fails

### ColorPicker
- `sl-blur` - When picker loses focus
- `sl-change` - When color changes
- `sl-focus` - When picker gains focus
- `sl-input` - When color changes during interaction
- `sl-invalid` - When validation fails

### Rating
- `sl-change` - When rating changes
- `sl-hover` - When hovering over a value

### Animation
- `sl-cancel` - When animation is canceled
- `sl-finish` - When animation finishes
- `sl-start` - When animation starts

### Carousel
- `sl-slide-change` - When active slide changes

### CopyButton
- `sl-copy` - When content is copied

### Tree/TreeItem
- `sl-selection-change` - When selection changes
- `sl-expand` - When tree item expands
- `sl-collapse` - When tree item collapses

### Menu/MenuItem
- `sl-select` - When menu item is selected

## Implementation Pattern

For each component:
1. Add event listener methods following the pattern: `onEventName(EventListener<EventClass> listener)`
2. Create static inner event classes with `@EventName` annotation
3. Include relevant event data using `@EventOptions` where applicable
4. Add standard mouse/keyboard events where appropriate
5. Document each event method with JavaDoc

## Event Data Guidelines

- Focus events: No additional data needed
- Change events: Include old and new values where applicable
- Show/Hide events: No additional data needed
- Mouse events: Include clientX, clientY coordinates
- Validation events: Include validation message if available
- Selection events: Include selected item(s) data