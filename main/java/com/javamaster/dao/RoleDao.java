package com.javamaster.dao;

import com.javamaster.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRoles();
    Role getRoleByName(String name);
}
