package com.example.healthcare.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class UserDto {

    private String userName;
    private String email;
    private String phone;
    private String password;
    private String gender;
    private BigDecimal weight;
    private BigDecimal height;
    private String bloodGroup;
}
