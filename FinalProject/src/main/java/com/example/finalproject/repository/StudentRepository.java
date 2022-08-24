package com.example.finalproject.repository;

import com.example.finalproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student>findStudentByUsername(String username);
}
