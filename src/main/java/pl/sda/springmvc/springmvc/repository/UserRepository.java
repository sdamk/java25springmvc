package pl.sda.springmvc.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springmvc.springmvc.entity.User;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
    boolean existsByLogin(String login);
}
