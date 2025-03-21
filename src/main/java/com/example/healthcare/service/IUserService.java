package com.example.healthcare.service;

import com.example.healthcare.dto.UserDto;
import com.example.healthcare.model.User;

import java.sql.Timestamp;
import java.util.List;

public interface IUserService {
    User registerOrEditUser(UserDto userDto);

    User findByEmail(String email);

    List<User> getAllUsers();

    User editUser(User user);

    User findByUserName(String userName);

    User getUserById(String userId);

    Timestamp passwordResetExpires();
}
