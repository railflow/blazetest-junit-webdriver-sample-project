package io.railflow.blazetest.samples.junit.webdriver;

import org.junit.jupiter.api.Test;

public class TestLoginEmptyCredentials extends TestLoginBase {
    
    @Test
    void missingUsernameMissingPassword() {
        loginFailure(null, null, LOGIN_ERROR_USERNAME_REQUIRED);
    }

    @Test
    void missingUsernameEmptyPassword() {
        loginFailure(null, "", LOGIN_ERROR_USERNAME_REQUIRED);
    }

    @Test
    void invalidUsernameMissingPassword() {
        loginFailure("invalid", null, LOGIN_ERROR_PASSWORD_REQUIRED);
    }

    @Test
    void missingUsernameInvalidPassword() {
        loginFailure(null, "invalid", LOGIN_ERROR_USERNAME_REQUIRED);
    }

    @Test
    void emptyUsernameEmptyPassword() {
        loginFailure("", "", LOGIN_ERROR_USERNAME_REQUIRED);
    }

    @Test
    void emptyUsernameMissingPassword() {
        loginFailure("", null, LOGIN_ERROR_USERNAME_REQUIRED);
    }

    @Test
    void invalidUsernameEmptyPassword() {
        loginFailure("invalid", "", LOGIN_ERROR_PASSWORD_REQUIRED);
    }

    @Test
    void emptyUsernameInvalidPassword() {
        loginFailure("", "invalid", LOGIN_ERROR_USERNAME_REQUIRED);
    }

}
