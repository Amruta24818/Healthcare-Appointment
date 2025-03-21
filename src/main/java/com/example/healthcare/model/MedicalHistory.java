package com.example.healthcare.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "medical_history")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String diagnosis;
    private String summary;
    private Boolean isDeleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public MedicalHistory(String diagnosis, String summary) {
        this.diagnosis = diagnosis;
        this.summary = summary;
    }
}