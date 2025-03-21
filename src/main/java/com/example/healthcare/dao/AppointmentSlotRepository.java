package com.example.healthcare.dao;

import com.example.healthcare.model.AppointmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentSlotRepository extends JpaRepository<AppointmentSlot, String> {

    @Query("SELECT a FROM AppointmentSlot a WHERE a.available = true")
    List<AppointmentSlot> findByAvailable();

    @Query("SELECT a FROM AppointmentSlot a WHERE a.available = true AND a.doctor.id = :doctorId")
    List<AppointmentSlot> findAvailableSlotsByDoctor(@Param("doctorId") String doctorId);
}
