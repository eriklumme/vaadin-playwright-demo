package dev.lumme.vaadin.it.po;

import com.microsoft.playwright.Page;

public class LoginPO {

    private final Page page;

    public LoginPO(Page page) {
        this.page = page;
    }

    public void logIn(String username, String password) {
        page.type("vaadin-text-field[name='username']", username);
        page.type("vaadin-password-field", password);
        page.click("vaadin-button");
    }
}
