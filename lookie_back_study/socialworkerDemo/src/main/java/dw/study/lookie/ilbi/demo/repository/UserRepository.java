package dw.study.lookie.ilbi.demo.repository;


import dw.study.lookie.ilbi.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}