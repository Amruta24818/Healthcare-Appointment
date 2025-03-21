package com.example.healthcare.service;


import com.example.healthcare.model.AppointmentSlot;

import java.util.List;

public interface IAppointmentSlotService {

    AppointmentSlot addAppointmentSlot(AppointmentSlot appointmentSlot);

    List<AppointmentSlot> getAllAvailableSlot();

    List<AppointmentSlot> findAllAvailableSlot(String doctorId);
}
