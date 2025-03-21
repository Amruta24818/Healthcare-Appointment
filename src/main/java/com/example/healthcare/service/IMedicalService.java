package com.example.healthcare.service;

import com.example.healthcare.dto.MedicalHistoryDto;
import com.example.healthcare.model.MedicalHistory;
import com.example.healthcare.model.MedicalLicense;

public interface IMedicalService {

    public MedicalHistory getMedicalHistoryByUserId(String userId);

    MedicalHistory addMedicalHistory(MedicalHistoryDto medicalHistoryDto);

    MedicalLicense addMedicalLicense(MedicalLicense medicalLicense);
}
