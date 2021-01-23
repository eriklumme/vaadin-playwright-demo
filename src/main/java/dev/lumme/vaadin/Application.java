package dev.lumme.vaadin;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the * and some desktop browsers.
 *
 */
@SpringBootApplication
@PWA(name = "Vaadin Playwright Demo", shortName = "Vaadin Playwright Demo")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator, VaadinServiceInitListener {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

    @Override
    public void serviceInit(ServiceInitEvent event) {
        // Disallow navigating to Flow views if the user is not logged in
        event.getSource().addUIInitListener(uiEvent -> uiEvent.getUI().addBeforeEnterListener(beforeEnter -> {
            if (VaadinSession.getCurrent().getSession().getAttribute("user") == null) {
                beforeEnter.forwardTo("/login");
            }
        }));
    }
}
