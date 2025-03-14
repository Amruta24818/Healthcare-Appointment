package com.example.healthcare.service;

import com.example.healthcare.model.User;

public interface IUserService {
    User registerOrEditUser(User user);

    User findByEmail(String email);
}
