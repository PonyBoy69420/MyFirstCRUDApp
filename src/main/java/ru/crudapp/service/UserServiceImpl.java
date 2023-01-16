package ru.crudapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.crudapp.dao.UserDAO;
import ru.crudapp.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        this.userDAO.createUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        this.userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return this.userDAO.listUsers();
    }
}
