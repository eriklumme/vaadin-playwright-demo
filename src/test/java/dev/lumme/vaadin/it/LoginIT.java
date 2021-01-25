package dev.lumme.vaadin.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginIT extends AbstractPlaywrightIT {

    @Test
    void testLogIn() {
        getLoginPage().logIn("user", "password");
        Assertions.assertTrue(getPage().isVisible("id=books-view"));
    }
}
