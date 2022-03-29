package cloud.ansel.service;

import java.util.Optional;

import cloud.ansel.model.User;

public interface SecurityService {

    void login(String username, String password);

    Optional<User> loggedInUser();
}
