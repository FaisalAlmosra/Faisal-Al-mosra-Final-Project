package com.example.finalproject.contoller;

import com.example.finalproject.dto.ApiResponse;
import com.example.finalproject.model.Student;
import com.example.finalproject.model.University;
import com.example.finalproject.repository.UniversityRepository;
import com.example.finalproject.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/uni")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;
    private final UniversityRepository universityRepository;
    @GetMapping
    public ResponseEntity getUniversity () {
        return ResponseEntity.status(200).body(universityRepository.findAll());
    }
    @PostMapping
    public ResponseEntity addUniversity(@RequestBody @Valid University university, @AuthenticationPrincipal Student student){
        universityService.addUniversity(university,student);
        return ResponseEntity.status(201).body(new ApiResponse("New University added !",201));
    }
    @GetMapping("/city")
    public ResponseEntity<List<University>> findUniversitiesByCity(@RequestParam String city){
        List<University> university=universityService.findUniversitiesByCity(city);
        return ResponseEntity.status(201).body(university);
    }
    @GetMapping("/type")
    public ResponseEntity<List<University>> findUniversitiesByType(@RequestParam String type){
        List<University> university=universityService.findUniversitiesByType(type);
        return ResponseEntity.status(201).body(university);
    }
    @GetMapping("/rate")
    public ResponseEntity<List<University>> findUniversitiesByRating(@RequestParam Integer rating){
        List<University> university=universityService.findUniversitiesByRating(rating);
        return ResponseEntity.status(201).body(university);
    }
}
