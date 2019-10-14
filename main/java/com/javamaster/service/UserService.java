package com.javamaster.service;

import com.javamaster.model.Role;
import com.javamaster.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(long id);

    User getUserById(long id);

    List<User> listUsers();

    List<Role> getRoles();

    Role getRoleByName(String name);

    User getUserByLogin(String login);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
