package com.example.healthcare.controller;

import com.example.healthcare.dto.LoginRequest;
import com.example.healthcare.dto.LoginResponse;
import com.example.healthcare.model.User;
import com.example.healthcare.service.IUserService;
import com.example.healthcare.service.UserDetailsServiceImpl;
import com.example.healthcare.utils.JwtUtills;
import com.example.healthcare.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtills jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String host;

    public UserController(JwtUtills jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerOrEditUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        String hashedInputPassword = PasswordManager.hashPassword(request.getPassword(), user.getSalt());

        if (!hashedInputPassword.equals(user.getPasswordHash())) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user);
        System.out.println(user);

//        return ResponseEntity.ok(new LoginResponse("success", user, token));
//        return ResponseEntity.ok("ok");
        return new ResponseEntity<>(new LoginResponse("success", token),
                HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getotp/{email}")
    public ResponseEntity<String> sendOTP(@PathVariable String email) {

        return new ResponseEntity<String>(OTPEmail(email), HttpStatus.OK);
    }

    public String OTPEmail(String email) {
        System.out.println("Sending Email.....");
        String otp = "" + ((int) (Math.random() * 9000) * 100);
        System.out.println("OTP: " + otp);
        SimpleMailMessage mesg = new SimpleMailMessage();
        mesg.setFrom(host);
        mesg.setTo(email);
        mesg.setSubject("Welcome to Healthcare");
        mesg.setText("Hello,\nYour OTP for Login is  " + otp + "\n\n\nThanks and Regards,\nAdmin\nHealthcare");
        emailSender.send(mesg);

        System.out.println("success");
        return otp;
    }

    @PutMapping("/editUser")
    public ResponseEntity<User> editUser(@RequestBody User user) {
//        String token = request.getHeader("Authorization");

//        if (token != null && token.startsWith("Bearer ")) {
//            token = token.substring(7);
//            String userName = this.jwtUtil.extractUsername(token);
//
//            System.out.println(userName);
//            User u = userService.findByUserName(userName);
        User users = userService.editUser(user);
//        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
