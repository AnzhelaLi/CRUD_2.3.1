package org.example.Service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    void deleteUser(Long id);

    User updateUser(Long id, User user);

    List<User> usersList();

    User findUserById(Long id);

}
