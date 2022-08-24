package com.example.finalproject.service;

import com.example.finalproject.exception.ApiException;
import com.example.finalproject.model.Student;
import com.example.finalproject.model.University;
import com.example.finalproject.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityRepository universityRepository;

    public List<University> getUniversity(Student student) {
        return universityRepository.findByStudentId(student.getId());
    }


    public void addUniversity(University university, Student student) {
        university.setStudentId(student.getId());
        universityRepository.save(university);
    }
    public List<University> findUniversitiesByCity(String city){
        List<University> university=universityRepository.findUniversitiesByCity(city);
        if (university==null){
            throw new ApiException("wrong city");

        }
        return university;
    }
    public List<University> findUniversitiesByType(String type) {
        List<University> university = universityRepository.findUniversitiesByType(type);
        if (university == null) {
            throw new ApiException("wrong type");
        }
        return university;
    }
    public List<University> findUniversitiesByRating(Integer rating) {
        List<University> university = universityRepository.findUniversitiesByRating(rating);
        if (university == null) {
            throw new ApiException("wrong rate");
        }
        return university;
    }
}



