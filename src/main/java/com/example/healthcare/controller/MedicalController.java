package com.example.healthcare.controller;

import com.example.healthcare.model.AppointmentSlot;
import com.example.healthcare.model.MedicalLicense;
import com.example.healthcare.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical")
public class MedicalController {

    @Autowired
    private IMedicalService medicalService;

    @PostMapping("/addLicense")
    public ResponseEntity<MedicalLicense> addMedicalLicense(@RequestBody MedicalLicense medicalLicense){
        return new ResponseEntity<>(medicalService.addMedicalLicense(medicalLicense), HttpStatus.OK);
    }
}
