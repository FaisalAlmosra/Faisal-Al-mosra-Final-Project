package com.example.finalproject.advise;

import com.example.finalproject.dto.ApiResponse;
import com.example.finalproject.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity apiException(ApiException apiException){
        return ResponseEntity.status(400).body(new ApiResponse(apiException.getMessage(),400));
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse> exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(500).body(new ApiResponse("SERVER ERROR !",500));
    }
}