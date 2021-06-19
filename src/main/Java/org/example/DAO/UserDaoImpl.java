package org.example.DAO;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Override
    public User updateUser(Long id, User updatedUser) {
        User userToBeUpdated = findUserById(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setWorkplace(updatedUser.getWorkplace());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setSalary(updatedUser.getSalary());
        entityManager.merge(userToBeUpdated);
        return userToBeUpdated;
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
