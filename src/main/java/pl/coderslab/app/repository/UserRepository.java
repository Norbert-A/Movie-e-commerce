package pl.coderslab.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE email = ?", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "select * from user where user_id = ?", nativeQuery = true)
    User findUserById(int userId);
}