package com.example.finalproject.repository;

import com.example.finalproject.model.FeedBack;
import com.example.finalproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack,Integer> {
    List<FeedBack> findByStudentId(Integer id);
    List<FeedBack> findFeedBackByRateStudyGreaterThan(Integer rateStudy);
    List<FeedBack> findFeedBackByRateTeacherGreaterThan(Integer rateTeacher);
    List<FeedBack> findFeedBackByGraduateYearGreaterThanEqual(Integer graduateYear);

}