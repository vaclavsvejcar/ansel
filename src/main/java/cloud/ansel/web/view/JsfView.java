package cloud.ansel.web.view;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;

import cloud.ansel.model.User;
import cloud.ansel.service.SecurityService;

public abstract class JsfView {

    @Autowired
    private SecurityService securityService;

    protected void withLoggedInUser(Consumer<User> consumer) {
        securityService.loggedInUser().ifPresent(consumer);
    }

}
