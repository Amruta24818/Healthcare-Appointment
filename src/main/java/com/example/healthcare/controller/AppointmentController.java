package com.example.healthcare.controller;

import com.example.healthcare.model.Appointment;
import com.example.healthcare.model.AppointmentSlot;
import com.example.healthcare.service.IAppointmentService;
import com.example.healthcare.service.IAppointmentSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appoint")
public class AppointmentController {

    @Autowired
    private IAppointmentSlotService appointmentSlotService;

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping("/addAppointmentSlot")
    public ResponseEntity<AppointmentSlot> addAppointmentSlot(@RequestBody AppointmentSlot appointmentSlot){
        return new ResponseEntity<>(appointmentSlotService.addAppointmentSlot(appointmentSlot), HttpStatus.OK);
    }

    @PostMapping("/addAppointment")
    public ResponseEntity<Appointment> addAppoinment(@RequestBody Appointment appointment){

        return new ResponseEntity<>(appointmentService.addAppointment(appointment),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllAppointment")
    public ResponseEntity<List<AppointmentSlot>> getAllAvailableAppointments(){
        List<AppointmentSlot> list = appointmentSlotService.getAllAvailableSlot();
        return new ResponseEntity<>(list, HttpStatus.OK );
    }

    @GetMapping("/appointments/available/{doctorId}")
    public ResponseEntity<List<AppointmentSlot>> getAvailableSlots(@PathVariable String doctorId) {
        try {

            List<AppointmentSlot> availableSlots = appointmentSlotService.findAllAvailableSlot(doctorId);

            if (availableSlots.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(availableSlots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
