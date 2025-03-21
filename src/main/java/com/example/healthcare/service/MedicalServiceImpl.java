package com.example.healthcare.service;

import com.example.healthcare.dao.MedicalHistoryRepository;
import com.example.healthcare.dao.MedicalLicenseRepository;
import com.example.healthcare.dto.MedicalHistoryDto;
import com.example.healthcare.model.MedicalHistory;
import com.example.healthcare.model.MedicalLicense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class MedicalServiceImpl implements IMedicalService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private MedicalLicenseRepository medicalLicenseRepository;

    @Override
    public MedicalHistory getMedicalHistoryByUserId(String userId) {
        return medicalHistoryRepository.findById(userId).get();
    }

    @Override
    public MedicalHistory addMedicalHistory(MedicalHistoryDto medicalHistoryDto) {
        MedicalHistory medicalHistory = new MedicalHistory(medicalHistoryDto.getDiagnosis(),medicalHistoryDto.getSummary());
        medicalHistory.setIsDeleted(false);
        medicalHistory.setCreatedAt(Timestamp.from(Instant.now()));
        medicalHistory.setUpdatedAt(Timestamp.from(Instant.now()));
        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public MedicalLicense addMedicalLicense(MedicalLicense medicalLicense) {
        medicalLicense.setCreatedAt(Timestamp.from(Instant.now()));
        medicalLicense.setUpdatedAt(Timestamp.from(Instant.now()));
        return medicalLicenseRepository.save(medicalLicense);
    }
}
