package com.example.healthcare.dao;

import com.example.healthcare.model.MedicalLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalLicenseRepository extends JpaRepository<MedicalLicense, String> {
}
