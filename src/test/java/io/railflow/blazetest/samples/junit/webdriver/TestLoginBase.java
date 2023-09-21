package io.railflow.blazetest.samples.junit.webdriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class TestLoginBase extends TestBase {

    protected static final String LOGIN_ERROR_USERNAME_REQUIRED = "Epic sadface: Username is required";
    protected static final String LOGIN_ERROR_PASSWORD_REQUIRED = "Epic sadface: Password is required";
    protected static final String LOGIN_ERROR_INVALID_CREDENTIALS
            = "Epic sadface: Username and password do not match any user in this service";
    protected static final String LOGIN_ERROR_LOCKED_OUT
            = "Epic sadface: Sorry, this user has been locked out.";
    
    private WebElement username;
    private WebElement password;
    private WebElement login;

    @BeforeEach
    public void beforeEach() {
        username = driver.findElement(By.id("user-name"));
        assertNotNull(username);

        password = driver.findElement(By.id("password"));
        assertNotNull(password);

        login = driver.findElement(By.id("login-button"));
        assertNotNull(login);
    }

    protected void loginFailure(final String username, final String password, final String message) {
        if (username != null) {
            this.username.sendKeys(username);
        }

        if (password != null) {
            this.password.sendKeys(password);
        }

        login.click();

        final WebElement error = driver.findElement(
                By.xpath("//h3[@data-test='error']"));
        assertNotNull(error);
        assertEquals(message, error.getText());
    }

    protected void loginSuccess(final String username, final String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }
}
