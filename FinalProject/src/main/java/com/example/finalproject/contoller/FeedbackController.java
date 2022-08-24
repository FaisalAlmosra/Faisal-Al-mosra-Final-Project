package com.example.finalproject.contoller;

import com.example.finalproject.dto.ApiResponse;
import com.example.finalproject.model.FeedBack;
import com.example.finalproject.model.Student;
import com.example.finalproject.model.University;
import com.example.finalproject.repository.FeedbackRepository;
//import com.example.finalproject.service.FeedbackService;
import com.example.finalproject.repository.StudentRepository;
import com.example.finalproject.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/feed")
@RequiredArgsConstructor
public class FeedbackController {
private final FeedbackService feedbackService;
private final StudentRepository studentRepository;
    private final FeedbackRepository feedbackRepository;
    @GetMapping
    public ResponseEntity getFeedbacks () {
        return ResponseEntity.status(200).body(feedbackRepository.findAll());
    }
    @PostMapping
    public ResponseEntity addFeedback(@RequestBody @Valid FeedBack feedback, @AuthenticationPrincipal Student student){
        feedbackService.addFeedback(feedback,student);
        return ResponseEntity.status(201).body(new ApiResponse("New feedback added !",201));
    }
    @GetMapping("/rates")
    public ResponseEntity<List<FeedBack>> findFeedBackByFeedbackGreaterThan(@RequestParam Integer rateStudy){
        List<FeedBack> feedBacks=feedbackService.findFeedBackByFeedbackGreaterThan(rateStudy);
        return ResponseEntity.status(201).body(feedBacks);
    }
    @GetMapping("/ratet")
    public ResponseEntity<List<FeedBack>> findFeedBackByRateTeacherGreaterThan(@RequestParam Integer rateTeacher){
        List<FeedBack> feedBacks=feedbackService.findFeedBackByRateTeacherGreaterThan(rateTeacher);
        return ResponseEntity.status(201).body(feedBacks);
    }
    @GetMapping("/grad")
    public ResponseEntity<List<FeedBack>> findFeedBackByGraduateYearGreaterThanEqual(@RequestParam Integer graduateYear){
        List<FeedBack> feedBacks=feedbackService.findFeedBackByGraduateYearGreaterThanEqual(graduateYear);
        return ResponseEntity.status(201).body(feedBacks);
    }

}

