package com.example.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String feedback;
    @NotEmpty(message = "major can not be empty")
    private String major;
    @NotNull(message = "rateTeacher cant be null")
    @Min(value = 1,message = "rateTeacher most be from 1 to 5")
    @Max(value = 5,message = "rateTeacher most be from 1 to 5")
    private Integer rateTeacher;
    @NotNull(message = "rateStudy cant be null")
    @Min(value = 1,message = "rateStudy most be from 1 to 5")
    @Max(value = 5,message = "rateStudy most be from 1 to 5")
    private Integer rateStudy;
    private Integer graduateYear;
    private Integer studentId;

}
