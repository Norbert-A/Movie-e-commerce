package pl.coderslab.app.service;

import pl.coderslab.app.model.User;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);
}
