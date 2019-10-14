package com.javamaster.service;

import com.javamaster.dao.RoleDao;
import com.javamaster.dao.UserDao;
import com.javamaster.model.Role;
import com.javamaster.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }


    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    public void removeUser(long id) {
        this.userDao.removeUser(id);
    }

    @Override
    public User getUserById(long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByLogin(username);
        List<Role> grantedAuthorities = user.getRoles();
        return new User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }
}
