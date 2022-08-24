package com.example.finalproject.contoller;

import com.example.finalproject.dto.ApiResponse;

import com.example.finalproject.dto.RegisterForm;
import com.example.finalproject.model.Student;
import com.example.finalproject.repository.FeedbackRepository;
import com.example.finalproject.repository.StudentRepository;
import com.example.finalproject.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stud")
public class AuthController {
    private final StudentRepository studentRepository;
    private final FeedbackRepository feedbackRepository;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm) {
        String hashedPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);
        Student student = new Student(null, registerForm.getUsername(), registerForm.getPassword(), registerForm.getRole(),  registerForm.getMajor());
        Student newStudent = studentRepository.save(student);

        return ResponseEntity.status(201).body("New Student registered !");
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new ApiResponse("Welcome back !",200));
    }
}