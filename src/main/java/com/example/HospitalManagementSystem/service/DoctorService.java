package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.Doctor;
import com.example.HospitalManagementSystem.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;
    public String addDoctor(Doctor doctor) {
        Doctor savedDoctor = doctorRepo.save(doctor);
        return "Doctor saved with Id "+savedDoctor.getDoctorId();
    }

    public String removeDoctor(Integer id) {
        doctorRepo.deleteById(id);
        return "Doctor removed successfully !!!";
    }
}
