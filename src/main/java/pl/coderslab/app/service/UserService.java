package pl.coderslab.app.service;

import pl.coderslab.app.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    List<User> getAllUsers();

    User findUserByEmail(String email);
}
