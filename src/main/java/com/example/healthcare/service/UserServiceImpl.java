package com.example.healthcare.service;

import com.example.healthcare.dao.UserRepository;
import com.example.healthcare.model.User;
import com.example.healthcare.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordManager saltAndHash;

    @Override
    public User registerOrEditUser(User user) {
        user.setSalt(PasswordManager.generateSalt());
        user.setPasswordHash( PasswordManager.hashPassword(user.getPasswordHash(), PasswordManager.generateSalt()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
