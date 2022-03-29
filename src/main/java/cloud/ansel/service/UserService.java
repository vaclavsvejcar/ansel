package cloud.ansel.service;

import java.util.Optional;

import cloud.ansel.model.User;

public interface UserService {

    void save(User user);

    Optional<User> findByEmail(String email);
}
