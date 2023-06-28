package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.SignInInput;
import com.example.HospitalManagementSystem.dto.SignInOutput;
import com.example.HospitalManagementSystem.dto.SignUpInput;
import com.example.HospitalManagementSystem.dto.SignUpOutput;
import com.example.HospitalManagementSystem.model.AuthenticationToken;
import com.example.HospitalManagementSystem.model.Patient;
import com.example.HospitalManagementSystem.repository.PatientRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PatientService {


    @Autowired
    private TokenService tokenService;
    @Autowired
    private PatientRepo patientRepo;
    public SignUpOutput signUp(SignUpInput signUpDto) { // get the user details for sign up : signUpDto

        //check if user exists or not based on email
        Patient patient = patientRepo.findFirstByPatientEmail(signUpDto.getUserEmail());//alternative : exist by true/false

        if(patient != null)
        {
            throw new IllegalStateException("Patient already exists!!!!...sign in instead");
        }


        //encryption
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpDto.getUserPassword());//takes  a string and encrypts it...
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        this.patientName = patientName;
        this.patientCity = patientCity;
        this.patientEmail = patientEmail;
        this.patientContact = patientContact;
        this.symptoms = symptoms;
        //save the user

        patient = new Patient(signUpDto.getUserFirstName(),
                signUpDto.getUserLastName(),signUpDto.getUserEmail(),
                encryptedPassword, signUpDto.getUserContact());

        patientRepo.save(patient);

        //token creation and saving

        AuthenticationToken token = new AuthenticationToken(patient);

        tokenService.saveToken(token);

        return new SignUpOutput("Patient registered","Patient created successfully");


    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }


    public SignInOutput signIn(SignInInput signInDto) {

        //get email

        Patient patient = patientRepo.findFirstByPatientEmail(signInDto.getPatientEmail());

        if(patient == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //encrypt the password

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPatientPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }



        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(patient.getPatientPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //figure out the token

        AuthenticationToken authToken = tokenService.getToken(patient);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!",authToken.getToken());


    }
}
