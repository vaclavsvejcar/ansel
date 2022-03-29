package cloud.ansel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import cloud.ansel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
