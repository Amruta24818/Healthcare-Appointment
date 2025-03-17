package com.example.healthcare.service;

import com.example.healthcare.dao.UserRepository;
import com.example.healthcare.model.User;
import com.example.healthcare.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordManager saltAndHash;

    @Override
    public User registerOrEditUser(User user) {
        String salt = PasswordManager.generateSalt();
        user.setSalt(salt);
        user.setPasswordHash( PasswordManager.hashPassword(user.getPasswordHash(), salt));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
