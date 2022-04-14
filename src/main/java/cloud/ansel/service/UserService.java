package cloud.ansel.service;

import java.util.Optional;

import cloud.ansel.model.User;
import cloud.ansel.model.enums.Language;

public interface UserService {

    void save(User user);

    Optional<User> findByEmail(String email);

    void updateLanguage(long userId, Language language);
}
