package com.example.finalproject.repository;

import com.example.finalproject.model.FeedBack;
import com.example.finalproject.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UniversityRepository extends JpaRepository<University,Integer> {
    List<University>findByStudentId(Integer id);
    List<University> findUniversitiesByCity(String city);
    List<University>findUniversitiesByType(String type);
    List<University>findUniversitiesByRating(Integer rating);

}