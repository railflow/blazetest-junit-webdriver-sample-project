package io.railflow.blazetest.samples.junit.webdriver.shoppingcart.standard;

import org.junit.jupiter.api.BeforeEach;

import io.railflow.blazetest.samples.junit.webdriver.shoppingcart.TestShoppingCartInventory;

public class TestShoppingCartStandardUserInventory extends TestShoppingCartInventory {
    
    @BeforeEach
    void login() {
        loginSuccess("standard_user", "secret_sauce");
    }
}
