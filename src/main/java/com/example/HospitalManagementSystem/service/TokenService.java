package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.model.AuthenticationToken;
import com.example.HospitalManagementSystem.model.Patient;
import com.example.HospitalManagementSystem.repository.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private TokenRepo tokenRepo;
    public void saveToken(AuthenticationToken token)
    {
        tokenRepo.save(token);
    }

    public AuthenticationToken getToken(Patient patient) {
        return  tokenRepo.findByPatient(patient);

    }

    public boolean authenticate(String userEmail, String token) {

        AuthenticationToken authToken = tokenRepo.findFirstByToken(token);//find token object via token string
        if(authToken == null)
        {
            return false;
        }
        String expectedEmail = authToken.getPatient().getPatientEmail();
        if(expectedEmail == null)
            return false;

        return expectedEmail.equals(userEmail);

    }
}
