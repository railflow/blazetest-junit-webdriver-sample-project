package io.railflow.blazetest.samples.junit.webdriver.shoppingcart.problem;

import org.junit.jupiter.api.BeforeEach;

import io.railflow.blazetest.samples.junit.webdriver.shoppingcart.TestShoppingCartBikeLight;

public class TestShoppingCartProblemUserBikeLight extends TestShoppingCartBikeLight {
    
    @BeforeEach
    void login() {
        loginSuccess("problem_user", "secret_sauce");
    }
}
