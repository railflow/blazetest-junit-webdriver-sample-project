package io.railflow.blazetest.samples.junit.webdriver;

import org.junit.jupiter.api.Test;

public class TestLoginInvalidCredentials extends TestLoginBase {

    private void loginFailure(final String username, final String password) {
        loginFailure(username, password, LOGIN_ERROR_INVALID_CREDENTIALS);
    }

    @Test
    void invalidUsernameInvalidPassword() {
        loginFailure("invalid", "invalid");
    }

    @Test
    void longUsername() {
        loginFailure("looooooooooooooooooooooooooooooooooooooooooooooooong",
                "invalid");
    }

    @Test
    void usernameWithSpaces() {
        loginFailure("user name", "invalid");
    }

    @Test
    void usernameWithNumbers() {
        loginFailure("user42", "invalid");
    }

    @Test
    void usernameWithSpecialCharacters() {
        loginFailure("user$&@abc", "invalid");
    }

    @Test
    void longPassword() {
        loginFailure("invalid",
                "looooooooooooooooooooooooooooooooooooooooooooooooong");
    }

    @Test
    void passwordWithSpaces() {
        loginFailure("invalid", "pass word");
    }

    @Test
    void passwordWithNumbers() {
        loginFailure("invalid", "secret123");
    }

    @Test
    void passwordWithSpecialCharacters() {
        loginFailure("invalid", "secret!@#");
    }

    @Test
    void validUserInvliadPassword() {
        loginFailure("standard_user", "invalid");
    }

    @Test
    void lockedOutUserInvliadPassword() {
        loginFailure("locked_out_user", "invalid");
    }

    @Test
    void problemUserInvliadPassword() {
        loginFailure("problem_user", "invalid");
    }

    @Test
    void performanceGlitchUserInvliadPassword() {
        loginFailure("performance_glitch_user", "invalid");
    }
}
