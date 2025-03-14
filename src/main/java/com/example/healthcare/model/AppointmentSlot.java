package com.example.healthcare.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "appointment_slot")
public class AppointmentSlot {
    @Id
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