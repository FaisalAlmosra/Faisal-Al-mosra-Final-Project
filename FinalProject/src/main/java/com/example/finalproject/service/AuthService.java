package com.example.finalproject.service;
import com.example.finalproject.model.Student;
import com.example.finalproject.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public void register( Student student){
        String hashedPassword= new BCryptPasswordEncoder().encode(student.getPassword());
        student.setPassword(hashedPassword);
        authRepository.save(student);
    }
}