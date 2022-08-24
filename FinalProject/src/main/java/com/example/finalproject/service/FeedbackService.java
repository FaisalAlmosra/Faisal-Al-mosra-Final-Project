package com.example.finalproject.service;

import com.example.finalproject.exception.ApiException;
import com.example.finalproject.model.FeedBack;
import com.example.finalproject.model.Student;

import com.example.finalproject.model.University;
import com.example.finalproject.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public List<FeedBack> getFeedbacks(Student student) {
        return feedbackRepository.findByStudentId(student.getId());
    }
    public void addFeedback(FeedBack feedBack, Student student) {
        feedBack.setStudentId(student.getId());
        feedbackRepository.save(feedBack);
    }
    public List<FeedBack> findFeedBackByFeedbackGreaterThan(Integer rateStudy) {
        List<FeedBack> feedBacks = feedbackRepository.findFeedBackByRateStudyGreaterThan(rateStudy);
        if (feedBacks == null) {
            throw new ApiException("wrong rate");
        }
        return feedBacks;
    }
    public List<FeedBack> findFeedBackByRateTeacherGreaterThan(Integer rateTeacher) {
        List<FeedBack> feedBacks = feedbackRepository.findFeedBackByRateTeacherGreaterThan(rateTeacher);
        if (feedBacks == null) {
            throw new ApiException("wrong rate");
        }
        return feedBacks;
    }
    public List<FeedBack> findFeedBackByGraduateYearGreaterThanEqual(Integer graduateYear) {
        List<FeedBack> feedBacks = feedbackRepository.findFeedBackByGraduateYearGreaterThanEqual(graduateYear);
        if (feedBacks == null) {
            throw new ApiException("wrong year");
        }
        return feedBacks;
    }
}