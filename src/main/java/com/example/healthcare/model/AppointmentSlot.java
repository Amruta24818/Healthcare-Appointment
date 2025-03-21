package com.example.healthcare.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "appointment_slot")
public class AppointmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    private Boolean available;
    private Timestamp appointmentTime;
    private Integer durationInMins;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}