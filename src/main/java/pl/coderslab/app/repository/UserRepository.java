package pl.coderslab.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT name FROM user WHERE email = ?1", nativeQuery = true)
    User findByEmail(String email);
}