package com.example.healthcare.service;

import com.example.healthcare.model.User;

import java.util.List;

public interface IUserService {
    User registerOrEditUser(User user);

    User findByEmail(String email);

    List<User> getAllUsers();

    User editUser(User user);

    User findByUserName(String userName);
}
