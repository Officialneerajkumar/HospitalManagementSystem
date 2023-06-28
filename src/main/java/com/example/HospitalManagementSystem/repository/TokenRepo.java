package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.model.AuthenticationToken;
import com.example.HospitalManagementSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByPatient(Patient patient);

    AuthenticationToken findFirstByToken(String token);
}
