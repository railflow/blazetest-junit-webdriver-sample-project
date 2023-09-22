package io.railflow.blazetest.samples.junit.webdriver;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class TestBase {

    protected static final String URL = "https://www.saucedemo.com/";

    protected int delay;
    protected WebDriver driver;

    protected TestBase() {
        try {
            delay = Integer.parseInt(System.getProperty("delay", "0"));
        } catch (final Exception e) {
            delay = 0;
        }
    }

    @BeforeEach
    public void setUp() {
        switch (System.getProperty("driver", "chrome").toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

        assertNotNull(driver, "Failed to initialize driver");
        assertDoesNotThrow(() -> driver.get(URL));
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        if (delay != 0) {
            final Random random = new Random();
            Thread.sleep(random.nextInt(500, delay * 1000));
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
