package com.example.healthcare.model;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String body;
    private String title;
    private String type;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
