package io.railflow.blazetest.samples.junit.webdriver;

import org.junit.jupiter.api.Test;

public class TestLoginUserLockout extends TestLoginBase {

    private void loginFailure(final String username, final String password) {
        loginFailure(username, password, LOGIN_ERROR_LOCKED_OUT);
    }

    @Test
    void missingPassword() {
        loginFailure("locked_out_user", null);
    }

    @Test
    void emptyPassword() {
        loginFailure("locked_out_user", "");
    }

    @Test
    void userLockedOut() {
        loginFailure("locked_out_user", "secret_sauce");
    }
}
