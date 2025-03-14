package com.example.healthcare.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "medical_license")
public class MedicalLicense {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String registrationNumber;
    private String specialization;
    private Timestamp registrationDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
