package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public User updateUser(User user) {

        return userDao.updateUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> usersList() {
        return userDao.usersList();
    }

    @Transactional
    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }
}
