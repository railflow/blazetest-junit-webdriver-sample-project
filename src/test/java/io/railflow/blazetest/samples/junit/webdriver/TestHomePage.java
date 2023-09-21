package io.railflow.blazetest.samples.junit.webdriver;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TestHomePage extends TestBase {

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
    void robots() {
        assertEquals("noindex",
                driver.findElement(By.xpath("//meta[@name='robots']"))
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
    public class UsernameInput {

        private WebElement element;

        @BeforeEach
        public void beforeEach() {
            element = driver.findElement(By.id("user-name"));
            assertNotNull(element);
        }

        @Test
        void autoCorrect() {
            assertEquals("off", element.getAttribute("autocorrect"));
        }

        @Test
        void autoCapitalize() {
            assertEquals("none", element.getAttribute("autocapitalize"));
        }

        @Test
        void name() {
            assertEquals("user-name", element.getAttribute("name"));
        }

        @Test
        void placeholder() {
            assertEquals("Username", element.getAttribute("placeholder"));
        }

        @Test
        void type() {
            assertEquals("text", element.getAttribute("type"));
        }

        @Test
        void text() {
            assertEquals("", element.getText());
        }
    }

    @Nested
    public class PasswordInput {

        private WebElement element;

        @BeforeEach
        public void beforeEach() {
            element = driver.findElement(By.id("password"));
            assertNotNull(element);
        }

        private static Stream<Arguments> attributesArguments() {
            return Stream.of(
                    Arguments.of("autocorrect", "off"),
                    Arguments.of("autocapitalize", "none"),
                    Arguments.of("name", "password"),
                    Arguments.of("placeholder", "Password"),
                    Arguments.of("type", "password"));
        }

        @ParameterizedTest
        @MethodSource("attributesArguments")
        void attribute(final String name, final String value) {
            assertEquals(value, element.getAttribute(name));
        }

        @Test
        void text() {
            assertEquals("", element.getText());
        }
    }

    @Nested
    public class LoginButton {

        private WebElement element;

        @BeforeEach
        public void beforeEach() {
            element = driver.findElement(By.id("login-button"));
            assertNotNull(element);
        }

        @Test
        void name() {
            assertEquals("login-button", element.getAttribute("name"));
        }

        @Test
        void type() {
            assertEquals("submit", element.getAttribute("type"));
        }

        @Test
        void value() {
            assertEquals("Login", element.getAttribute("value"));
        }
    }

    @Test
    void errorElementAtStart() {
        assertDoesNotThrow(() -> driver.findElement(By.xpath("//h3[@data-test='error']")));
    }

    @Test
    void noErrorElementAtStart() {
        assertThrows(NoSuchElementException.class,
                () -> driver.findElement(By.xpath("//h3[@data-test='error']")));
    }
}
