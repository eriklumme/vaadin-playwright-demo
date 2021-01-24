package dev.lumme.vaadin.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginIT extends AbstractPlaywrightIT {

    @Test
    void testLogIn() {
        getPage().type("vaadin-text-field[name=username]", "user");
        getPage().type("vaadin-password-field", "password");
        getPage().click("vaadin-button");
        Assertions.assertTrue(getPage().isVisible("#books-view"));
    }
}
