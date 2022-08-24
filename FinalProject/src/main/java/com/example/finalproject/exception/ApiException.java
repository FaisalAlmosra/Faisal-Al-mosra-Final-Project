package com.example.finalproject.exception;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}