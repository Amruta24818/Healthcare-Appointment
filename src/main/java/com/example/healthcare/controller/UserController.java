package com.example.healthcare.controller;

import com.example.healthcare.dto.LoginRequest;
import com.example.healthcare.dto.LoginResponse;
import com.example.healthcare.model.User;
import com.example.healthcare.service.IUserService;
import com.example.healthcare.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerOrEditUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) {
        System.out.println("in authenticate user: " + request);

        User user = userService.findByEmail(request.getEmail());
        Authentication authenticate = null;

        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    request.getEmail(), Base64.getEncoder().encodeToString(request.getPassword().getBytes()));

            authenticate = authenticationManager.authenticate(authenticationToken);

        } catch (Exception e) {
            throw new UsernameNotFoundException("Invalid email or password");
        }

        return new ResponseEntity<>(new LoginResponse("success", user, jwtUtil.generateToken(user.getUserName())),
                HttpStatus.OK);

    }
}
