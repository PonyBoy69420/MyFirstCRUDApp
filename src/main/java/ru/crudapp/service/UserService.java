package ru.crudapp.service;

import ru.crudapp.models.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);

    public void deleteUser(Long id);

    public void updateUser(User user);

    public User getUserById(Long id);

    public List<User> listUsers();
}
