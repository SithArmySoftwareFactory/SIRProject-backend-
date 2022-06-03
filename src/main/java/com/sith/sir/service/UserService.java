package com.sith.sir.service;

import com.sith.sir.domain.AppUser;
import com.sith.sir.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToAppUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser>getUsers();
}
