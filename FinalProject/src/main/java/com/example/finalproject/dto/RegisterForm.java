package com.example.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class RegisterForm {
    @NotEmpty(message = "username cant be empty")
    private String username;
    @NotEmpty(message = "password cant be empty")
    private String password;
    @Pattern(regexp = "(graduate|study)",message = "most be graduate or study")
    private String role;
    @NotEmpty(message = "major cant be empty")
    private String graduateYear;
    private String university;
    private String major;
    private String name;
    private String city;
    private String type;
    private String feedback;
}
