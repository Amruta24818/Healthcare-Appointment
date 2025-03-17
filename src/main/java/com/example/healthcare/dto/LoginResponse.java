package com.example.healthcare.dto;

import com.example.healthcare.model.User;
import lombok.Data;

import java.util.Objects;

@Data
public class LoginResponse {
    private String status;
//    private User data;
    private String token;

    public LoginResponse(String status, String token) {
        System.out.println("-----loginresponse ctor----------");
        this.status = status;
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponse [status=" + status + ", token=" + token + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponse that = (LoginResponse) o;
        return Objects.equals(status, that.status) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, token);
    }
}
