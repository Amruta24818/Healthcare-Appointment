package com.example.healthcare.service;

import com.example.healthcare.dao.UserRepository;
import com.example.healthcare.dto.UserDto;
import com.example.healthcare.model.User;
import com.example.healthcare.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordManager saltAndHash;

    @Override
    public User registerOrEditUser(UserDto userDto) {
        User user = new User(userDto.getUserName(),userDto.getEmail(),userDto.getPhone(),userDto.getGender(),userDto.getWeight(),userDto.getHeight(),userDto.getBloodGroup());
        String salt = PasswordManager.generateSalt();
        user.setSalt(salt);
        user.setPasswordHash( PasswordManager.hashPassword(userDto.getPassword(), salt));
        user.setRole("USER");
        user.setIsVerified(false);
        user.setPasswordResetExpires(passwordResetExpires());
        user.setIsDeleted(false);
        user.setCreatedAt(Timestamp.from(Instant.now()));
        user.setUpdatedAt(Timestamp.from(Instant.now()));
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

    @Override
    public User editUser(User user) {
        user.setUpdatedAt(Timestamp.from(Instant.now()));
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public Timestamp passwordResetExpires() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 3);  // Add 3 months to the current date
        return new Timestamp(calendar.getTimeInMillis());
    }


}
