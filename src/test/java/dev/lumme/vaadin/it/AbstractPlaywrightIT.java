package dev.lumme.vaadin.it;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractPlaywrightIT {

    private static Playwright playwright;
    private static Browser browser;

    private Page page;

    @BeforeAll
    static void setUpClass() {
        playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().withHeadless(false));
    }

    @BeforeEach
    void setUp() {
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().withViewport(800, 600));
        page = context.newPage();
        page.navigate("http://localhost:8080/");
    }

    @AfterAll
    static void tearDownClass() throws Exception {
        playwright.close();
    }

    protected Page getPage() {
        return page;
    }
}
