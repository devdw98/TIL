package dw.study.springbootapi.repository;

import dw.study.springbootapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUid(String uid);
    Optional<User> findByUidAndProvider(String uid, String provider);
}
