package dw.study.springbootapi.repository;

import dw.study.springbootapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
