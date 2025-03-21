package com.example.healthcare.service;

import com.example.healthcare.dao.AppointmentRepository;
import com.example.healthcare.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        appointment.setCreatedAt(Timestamp.from(Instant.now()));
        appointment.setUpdatedAt(Timestamp.from(Instant.now()));
        return appointmentRepository.save(appointment);
    }
}
