package io.railflow.blazetest.samples.junit.webdriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestLoginSuccess extends TestLoginBase {
    
    @BeforeEach
    void standardUser() {
        loginSuccess("standard_user", "secret_sauce");
    }

    @Test
    void title() {
        assertEquals("Swag Labs", driver.getTitle());
    }

    @Test
    void description() {
        assertEquals("Sauce Labs Swag Labs app",
                driver.findElement(By.xpath("//meta[@name='description']"))
                    .getAttribute("content"));
    }

    @Test
    void manifestLink() {
        assertEquals(URL + "manifest.json",
                driver.findElement(By.xpath("//link[@rel='manifest']"))
                    .getAttribute("href"));
    }

    @Test
    void stylesheetLink() {
        assertEquals("https://fonts.googleapis.com/css2?family=DM+Mono:wght@400;500&family=DM+Sans:wght@400;500",
                driver.findElement(By.xpath("//link[@rel='stylesheet']"))
                    .getAttribute("href"));
    }

    @Nested
    public class FooterLinks {

        @Test
        void twitterLink() {
            final WebElement li = driver.findElement(By.xpath("//li[@class='social_twitter']"));
            assertNotNull(li);

            final WebElement a = li.findElement(By.xpath("a"));
            assertNotNull(a);
            assertEquals("https://twitter.com/saucelabs", a.getAttribute("href"));
        }

        @Test
        void twitterText() {
            final WebElement li = driver.findElement(By.xpath("//li[@class='social_twitter']"));
            assertNotNull(li);

            final WebElement a = li.findElement(By.xpath("a"));
            assertNotNull(a);
            assertEquals("Twitter", a.getText());
        }

        @Test
        void facebookLink() {
            final WebElement li = driver.findElement(By.xpath("//li[@class='social_facebook']"));
            assertNotNull(li);

            final WebElement a = li.findElement(By.xpath("a"));
            assertNotNull(a);
            assertEquals("https://www.facebook.com/saucelabs", a.getAttribute("href"));
        }

        @Test
        void facebookText() {
            final WebElement li = driver.findElement(By.xpath("//li[@class='social_facebook']"));
            assertNotNull(li);

            final WebElement a = li.findElement(By.xpath("a"));
            assertNotNull(a);
            assertEquals("Facebook", a.getText());
        }

        @Test
        void linkedinLink() {
            final WebElement li = driver.findElement(By.xpath("//li[@class='social_linkedin']"));
            assertNotNull(li);

            final WebElement a = li.findElement(By.xpath("a"));
            assertNotNull(a);
            assertEquals("https://www.linkedin.com/company/sauce-labs/", a.getAttribute("href"));
        }

        @Test
        void linkedinText() {
            final WebElement li = driver.findElement(By.xpath("//li[@class='social_linkedin']"));
            assertNotNull(li);

            final WebElement a = li.findElement(By.xpath("a"));
            assertNotNull(a);
            assertEquals("LinkedIn", a.getText());
        }
    }
}
