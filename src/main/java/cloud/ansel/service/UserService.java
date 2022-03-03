package cloud.ansel.service;

import cloud.ansel.model.User;

public interface UserService {

    void save(User user);

    User findByEmail(String email);
}
