package com.example.healthcare.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "medical_history")
public class MedicalHistory {
    @Id
    private String id;
    private String diagnosis;
    private String summary;
    private Boolean isDeleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}