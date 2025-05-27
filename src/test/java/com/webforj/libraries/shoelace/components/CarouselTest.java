package com.webforj.libraries.shoelace.components;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Carousel and CarouselItem components.
 */
public class CarouselTest {

    @Test
    public void testCarouselCreation() {
        Carousel carousel = new Carousel();
        assertNotNull(carousel);
        assertFalse(carousel.isLoop());
        assertFalse(carousel.isNavigation());
        assertFalse(carousel.isPagination());
        assertEquals(1, carousel.getSlidesPerPage());
        assertEquals(1, carousel.getSlidesPerMove());
        assertEquals("horizontal", carousel.getOrientation());
        assertFalse(carousel.isMouseDragging());
        assertFalse(carousel.isAutoplay());
        assertEquals(3000, carousel.getAutoplayInterval());
    }

    @Test
    public void testCarouselWithItems() {
        CarouselItem item1 = new CarouselItem("<img src='slide1.jpg'>");
        CarouselItem item2 = new CarouselItem("<img src='slide2.jpg'>");
        
        Carousel carousel = new Carousel(item1, item2);
        assertNotNull(carousel);
    }

    @Test
    public void testCarouselProperties() {
        Carousel carousel = new Carousel()
            .setLoop(true)
            .setNavigation(true)
            .setPagination(true)
            .setSlidesPerPage(3)
            .setSlidesPerMove(1)
            .setOrientation(Carousel.Orientation.VERTICAL)
            .setMouseDragging(true)
            .setAutoplay(true)
            .setAutoplayInterval(5000);

        assertTrue(carousel.isLoop());
        assertTrue(carousel.isNavigation());
        assertTrue(carousel.isPagination());
        assertEquals(3, carousel.getSlidesPerPage());
        assertEquals(1, carousel.getSlidesPerMove());
        assertEquals("vertical", carousel.getOrientation());
        assertTrue(carousel.isMouseDragging());
        assertTrue(carousel.isAutoplay());
        assertEquals(5000, carousel.getAutoplayInterval());
    }

    @Test
    public void testCarouselItemCreation() {
        // Test empty item
        CarouselItem item1 = new CarouselItem();
        assertNotNull(item1);

        // Test item with HTML content
        CarouselItem item2 = new CarouselItem("<img src='test.jpg'>");
        assertNotNull(item2);
    }

    @Test
    public void testCarouselItemAspectRatio() {
        CarouselItem item = new CarouselItem()
            .setAspectRatio("16/9");
        assertNotNull(item);

        // Test with numeric aspect ratio
        CarouselItem item2 = new CarouselItem()
            .setAspectRatio(4, 3);
        assertNotNull(item2);
    }

    @Test
    public void testCarouselItemPresetAspectRatios() {
        assertEquals("16/9", CarouselItem.AspectRatio.WIDESCREEN);
        assertEquals("4/3", CarouselItem.AspectRatio.STANDARD);
        assertEquals("1/1", CarouselItem.AspectRatio.SQUARE);
        assertEquals("21/9", CarouselItem.AspectRatio.ULTRAWIDE);
        assertEquals("9/16", CarouselItem.AspectRatio.PORTRAIT);
    }

    @Test
    public void testCarouselMethods() {
        Carousel carousel = new Carousel();
        CarouselItem item = new CarouselItem("Test content");
        
        // Test adding single item
        carousel.addItem(item);
        
        // Test adding multiple items
        carousel.addItems(
            new CarouselItem("Slide 1"),
            new CarouselItem("Slide 2"),
            new CarouselItem("Slide 3")
        );
        
        // Test dimension setters
        carousel.setWidth("800px")
                .setHeight("400px")
                .setGap("1rem");
        
        assertNotNull(carousel);
    }
}