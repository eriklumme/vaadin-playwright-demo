package dev.lumme.vaadin.data.endpoint;

import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

@Endpoint
@AnonymousAllowed
public class LoginEndpoint {

    @Autowired
    private HttpSession httpSession;

    /**
     * A crude mock of a login endpoint, for demonstrative purposes.
     */
    public boolean logIn(String username, String password) {
        if ("user".equals(username) && "password".equals(password)) {
            httpSession.setAttribute("user", "user");
            return true;
        }
        return false;
    }
}
