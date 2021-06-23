package org.example.dao;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(findUserById(id));
        entityManager.flush();
        entityManager.clear();

    }
    @Transactional
    @Override
    public User updateUser(User updatedUser) {
        entityManager.merge(updatedUser);
        return updatedUser;
    }

    @Override
    public List<User> usersList() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
