package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.model.Doctor;
import com.example.HospitalManagementSystem.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody Doctor doctor){
        String message = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }
    @DeleteMapping("/remove-doctor")
    public ResponseEntity<String> removeDoctor(@RequestParam Integer Id){
        String message = doctorService.removeDoctor(Id);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }
}
