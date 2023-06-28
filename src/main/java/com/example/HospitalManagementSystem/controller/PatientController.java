package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.SignInInput;
import com.example.HospitalManagementSystem.dto.SignInOutput;
import com.example.HospitalManagementSystem.dto.SignUpInput;
import com.example.HospitalManagementSystem.dto.SignUpOutput;
import com.example.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    //sign up output
    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpDto)
    {
        return patientService.signUp(signUpDto);
    }

    //sign in

    @PostMapping("/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto)
    {
        return patientService.signIn(signInDto);
    }
}
