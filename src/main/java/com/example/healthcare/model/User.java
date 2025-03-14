package com.example.healthcare.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    private String id;
    @Column(name = "user_name")
    private String userName;
    private String email;
    private String role;
    private String phone;
    private Boolean isVerified;
    private String passwordHash;
    private String salt;
    private String gender;
    private BigDecimal weight;
    private BigDecimal height;
    private String bloodGroup;
    private Timestamp passwordResetExpires;
    private Boolean isDeleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
