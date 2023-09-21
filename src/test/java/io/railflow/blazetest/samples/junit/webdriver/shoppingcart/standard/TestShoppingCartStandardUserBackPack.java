package io.railflow.blazetest.samples.junit.webdriver.shoppingcart.standard;

import org.junit.jupiter.api.BeforeEach;

import io.railflow.blazetest.samples.junit.webdriver.shoppingcart.TestShoppingCartBackPack;

public class TestShoppingCartStandardUserBackPack extends TestShoppingCartBackPack {
    
    @BeforeEach
    void login() {
        loginSuccess("standard_user", "secret_sauce");
    }
}
