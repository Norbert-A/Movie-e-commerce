package pl.coderslab.app.service;

import pl.coderslab.app.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
