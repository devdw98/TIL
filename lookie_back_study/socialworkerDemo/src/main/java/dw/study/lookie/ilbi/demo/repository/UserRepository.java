package dw.study.lookie.ilbi.demo.repository;


import dw.study.lookie.ilbi.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String username);
    public Optional<User> findByNickname(String nickname);
    public Optional<User> findByNameAndEmail(String name, String email);
    public Optional<User> findByNameAndUsername(String name, String username);

    @Query("UPDATE User u set u.password = :newPassword where u.id = :id")
    public Optional<User> updateUserPassword(Long id, String newPassword);
}