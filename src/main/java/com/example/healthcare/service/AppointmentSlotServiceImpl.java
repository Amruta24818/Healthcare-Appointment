package com.example.healthcare.service;

import com.example.healthcare.dao.AppointmentSlotRepository;
import com.example.healthcare.model.AppointmentSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class AppointmentSlotServiceImpl implements IAppointmentSlotService{

    @Autowired
    private AppointmentSlotRepository appointmentSlotRepository;

    @Override
    public AppointmentSlot addAppointmentSlot(AppointmentSlot appointmentSlot) {
        appointmentSlot.setCreatedAt(Timestamp.from(Instant.now()));
        appointmentSlot.setUpdatedAt(Timestamp.from(Instant.now()));
        return appointmentSlotRepository.save(appointmentSlot);
    }

    @Override
    public List<AppointmentSlot> getAllAvailableSlot() {
        List<AppointmentSlot> list = appointmentSlotRepository.findByAvailable();
        return list;
    }

    @Override
    public List<AppointmentSlot> findAllAvailableSlot(String doctorId) {
        List<AppointmentSlot> list = appointmentSlotRepository.findAvailableSlotsByDoctor(doctorId);
        return list;
    }


}
