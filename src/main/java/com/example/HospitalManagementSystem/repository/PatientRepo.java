package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {
    Patient findFirstByPatientEmail(String userEmail);
}
