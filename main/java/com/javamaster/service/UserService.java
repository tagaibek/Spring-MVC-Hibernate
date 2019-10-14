package com.javamaster.service;

import com.javamaster.model.Role;
import com.javamaster.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(long id);

    User getUserById(long id);

    List<User> listUsers();

    List<Role> getRoles();

    Role getRoleByName(String name);

    User loadUserByUsername(String name);

}
