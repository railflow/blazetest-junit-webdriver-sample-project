package io.railflow.blazetest.samples.junit.webdriver.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.railflow.blazetest.samples.junit.webdriver.TestLoginBase;

public abstract class TestShoppingCartBase extends TestLoginBase {

    private final int index;
    private final String tag;
    private final String name;
    private final String price;
    private final String image;

    protected TestShoppingCartBase(final int index, final String tag,
            final String name, final String price, final String image) {
        this.index = index;
        this.tag = tag;
        this.name = name;
        this.price = price;
        this.image = URL + image;
    }

    private String getItemName() {
        final Object[] items = driver
                .findElements(By.xpath("//div[@class='inventory_item_name']"))
                .toArray();
        assertNotNull(items);
        assertTrue(index < items.length);

        return ((WebElement) items[index]).getText();
    }

    private String getItemPrice() {
        final Object[] items = driver
                .findElements(By.xpath("//div[@class='inventory_item_price']"))
                .toArray();
        assertNotNull(items);
        assertTrue(index < items.length);

        return ((WebElement) items[index]).getText();
    }

    private String getItemImage() {
        final Object[] items = driver
                .findElements(By.xpath("//img[@class='inventory_item_img']"))
                .toArray();
        assertNotNull(items);
        assertTrue(index < items.length);

        return ((WebElement) items[index]).getAttribute("src");
    }

    private void addToCart() {
        final WebElement button = assertDoesNotThrow(() -> driver.findElement(
                By.xpath("//button[@id='add-to-cart-" + tag + "']")));
        assertNotNull(button);
        assertEquals("Add to cart", button.getText());

        button.click();
    }

    private void removeFromCart() {
        final WebElement button = assertDoesNotThrow(() -> driver.findElement(
                By.xpath("//button[@id='remove-" + tag + "']")));
        assertNotNull(button);
        assertEquals("Remove", button.getText());

        button.click();
    }

    @Test
    void name() {
        assertEquals(name, getItemName());
    }

    @Test
    void price() {
        assertEquals(price, getItemPrice());
    }

    @Test
    void image() {
        assertEquals(image, getItemImage());
    }

    @Test
    void add() {
        addToCart();
    }

    @Test
    void addAndRemove() {
        addToCart();
        removeFromCart();
    }

    @Test
    void addRemoveAndAddAgain() {
        addToCart();
        removeFromCart();
        addToCart();
    }
}
