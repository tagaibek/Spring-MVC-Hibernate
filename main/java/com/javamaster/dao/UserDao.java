package com.javamaster.dao;


import com.javamaster.model.User;

import java.util.List;

public interface UserDao  {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(long id);

    User getUserById(long id);

    List<User> listUsers();

    User getUserByLogin(String login);
}
