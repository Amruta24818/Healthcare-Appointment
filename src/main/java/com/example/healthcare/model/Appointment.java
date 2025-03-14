package com.example.healthcare.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    private String id;
    private Timestamp appointmentTime;
    private Integer durationInMins;
    private Boolean isDeleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "appointment_slot")
    private AppointmentSlot appointmentSlot;
}

