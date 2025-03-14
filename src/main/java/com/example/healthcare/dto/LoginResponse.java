package com.example.healthcare.dto;

import com.example.healthcare.model.User;
import lombok.Data;

@Data
public class LoginResponse {
    private String status;
    private User data;
    private String token;

    public LoginResponse(String status, User data, String token) {
        this.status = status;
        this.data = data;
        this.token = token;
    }
}
