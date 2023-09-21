package io.railflow.blazetest.samples.junit.webdriver.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import io.railflow.blazetest.samples.junit.webdriver.TestLoginBase;

public abstract class TestShoppingCartInventory extends TestLoginBase {

    @Test
    void inventoryItemCount() {
        assertEquals(6, driver.findElements(
                By.xpath("//div[@class='inventory_item']")).size());
    }

    @Test
    void inventoryItemNameCount() {
        assertEquals(6, driver.findElements(
                By.xpath("//div[@class='inventory_item_name']")).size());
    }

    @Test
    void inventoryItemPriceCount() {
        assertEquals(6, driver.findElements(
                By.xpath("//div[@class='inventory_item_price']")).size());
    }

    @Test
    void inventoryItemDescriptionCount() {
        assertEquals(6, driver.findElements(
                By.xpath("//div[@class='inventory_item_description']")).size());
    }

    @Test
    void inventoryItemLabelCount() {
        assertEquals(6, driver.findElements(
                By.xpath("//div[@class='inventory_item_label']")).size());
    }

    @Test
    void inventoryItemDescCount() {
        assertEquals(6, driver.findElements(
                By.xpath("//div[@class='inventory_item_desc']")).size());
    }

    @Test
    void inventoryItemImgCount() {
        assertEquals(6, driver.findElements(
                By.xpath("//img[@class='inventory_item_img']")).size());
    }

    @Test
    void pricebar() {
        assertEquals(6, driver.findElements(
                By.xpath("//div[@class='pricebar']")).size());
    }
}
