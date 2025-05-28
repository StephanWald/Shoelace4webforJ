package com.webforj.libraries.shoelace.sample.views;

import java.util.Set;

import com.webforj.libraries.shoelace.components.DrawerHeader;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.appnav.AppNav;
import com.webforj.component.layout.appnav.AppNavItem;
import com.webforj.component.layout.toolbar.Toolbar;
import com.webforj.router.Router;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.router.event.NavigateEvent;

@Route
public class MainLayout extends Composite<AppLayout> {
  private AppLayout self = getBoundComponent();
  private H1 title = new H1();

  public MainLayout() {
    setHeader();
    setDrawer();
    Router.getCurrent().onNavigate(this::onNavigate);
  }

  private void setHeader() {
    self.setDrawerHeaderVisible(true);

    self.addToDrawerTitle(new DrawerHeader());

    Toolbar toolbar = new Toolbar();
    toolbar.addToStart(new AppDrawerToggle());
    toolbar.addToTitle(title);

    self.addToHeader(toolbar);
  }

  private void setDrawer() {

    AppNav appNav = new AppNav();
    // Components in alphabetical order matching Shoelace
    appNav.addItem(new AppNavItem("Alert", AlertView.class, TablerIcon.create("alert-circle")));
    appNav.addItem(new AppNavItem("Animated Image", AnimatedImageView.class, TablerIcon.create("photo")));
    appNav.addItem(new AppNavItem("Animation", AnimationView.class, TablerIcon.create("rotate-clockwise-2")));
    appNav.addItem(new AppNavItem("Avatar", AvatarView.class, TablerIcon.create("user-circle")));
    appNav.addItem(new AppNavItem("Badge", BadgeView.class, TablerIcon.create("tag")));
    appNav.addItem(new AppNavItem("Breadcrumb", BreadcrumbView.class, TablerIcon.create("chevrons-right")));
    appNav.addItem(new AppNavItem("Button", ButtonView.class, TablerIcon.create("square")));
    appNav.addItem(new AppNavItem("Card", CardView.class, TablerIcon.create("credit-card")));
    appNav.addItem(new AppNavItem("Carousel", CarouselView.class, TablerIcon.create("carousel-horizontal")));
    appNav.addItem(new AppNavItem("Checkbox", CheckboxView.class, TablerIcon.create("checkbox")));
    appNav.addItem(new AppNavItem("Color Picker", ColorPickerView.class, TablerIcon.create("palette")));
    appNav.addItem(new AppNavItem("Copy Button", CopyButtonView.class, TablerIcon.create("copy")));
    appNav.addItem(new AppNavItem("Details", DetailsView.class, TablerIcon.create("list-details")));
    appNav.addItem(new AppNavItem("Dialog", DialogView.class, TablerIcon.create("message-circle")));
    appNav.addItem(new AppNavItem("Divider", DividerView.class, TablerIcon.create("separator")));
    appNav.addItem(new AppNavItem("Drawer", DrawerView.class, TablerIcon.create("layout-sidebar")));
    appNav.addItem(new AppNavItem("Dropdown", DropdownView.class, TablerIcon.create("chevron-down")));
    appNav.addItem(new AppNavItem("Icon", IconView.class, TablerIcon.create("icons")));
    appNav.addItem(new AppNavItem("Image Comparer", ImageComparerView.class, TablerIcon.create("photo-scan")));
    appNav.addItem(new AppNavItem("Input", InputView.class, TablerIcon.create("forms")));
    appNav.addItem(new AppNavItem("Menu", MenuView.class, TablerIcon.create("menu-2")));
    appNav.addItem(new AppNavItem("Option", OptionView.class, TablerIcon.create("list")));
    appNav.addItem(new AppNavItem("Progress Bar", ProgressBarView.class, TablerIcon.create("progress")));
    appNav.addItem(new AppNavItem("Progress Ring", ProgressRingView.class, TablerIcon.create("loader")));
    appNav.addItem(new AppNavItem("QR Code", QRCodeView.class, TablerIcon.create("qrcode")));
    appNav.addItem(new AppNavItem("Radio Group", RadioGroupView.class, TablerIcon.create("circle-dot")));
    appNav.addItem(new AppNavItem("Range", RangeView.class, TablerIcon.create("adjustments-horizontal")));
    appNav.addItem(new AppNavItem("Rating", RatingView.class, TablerIcon.create("star")));
    appNav.addItem(new AppNavItem("Select", SelectView.class, TablerIcon.create("select")));
    appNav.addItem(new AppNavItem("Skeleton", SkeletonView.class, TablerIcon.create("box")));
    appNav.addItem(new AppNavItem("Spinner", SpinnerView.class, TablerIcon.create("loader-2")));
    appNav.addItem(new AppNavItem("Split Panel", SplitPanelView.class, TablerIcon.create("layout-columns")));
    appNav.addItem(new AppNavItem("Switch", SwitchView.class, TablerIcon.create("toggle-left")));
    appNav.addItem(new AppNavItem("Tab Group", TabGroupView.class, TablerIcon.create("folder")));
    appNav.addItem(new AppNavItem("Tag", TagView.class, TablerIcon.create("tag")));
    appNav.addItem(new AppNavItem("Textarea", TextareaView.class, TablerIcon.create("text-wrap")));
    appNav.addItem(new AppNavItem("Tooltip", TooltipView.class, TablerIcon.create("info-circle")));
    appNav.addItem(new AppNavItem("Tree", TreeView.class, TablerIcon.create("binary-tree-2")));

    self.addToDrawer(appNav);
  }

  private void onNavigate(NavigateEvent ev) {
    Set<Component> components = ev.getContext().getAllComponents();
    Component view = components.stream().filter(c -> c.getClass().getSimpleName().endsWith("View")).findFirst()
        .orElse(null);

    if (view != null && title != null) {
      try {
        FrameTitle frameTitle = view.getClass().getAnnotation(FrameTitle.class);
        title.setText(frameTitle != null ? frameTitle.value() : "");
      } catch (Exception e) {
        // Component might be destroyed during navigation
      }
    }
  }
}
