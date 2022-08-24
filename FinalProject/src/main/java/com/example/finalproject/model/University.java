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
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name can not be empty")
    private String name;
    @NotEmpty(message = "name can not be empty")
    private String city;
    @Pattern(regexp ="(public|private)")
    private String type;
    @NotNull(message = "rating cant be null")
    @Min(value = 1,message = "rating most be from 1 to 5")
    @Max(value = 5,message = "rating most be from 1 to 5")
    private Integer rating;
    private Integer studentId;

}
