package com.example.demo;

import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(
            MethodArgumentNotValidException ex) {

        String message = ex.getFieldErrors()
                .stream()
                .filter(error -> error.getField().equals("title"))
                .map(error -> error.getDefaultMessage())
                .findFirst()
                .orElseGet(() -> ex.getFieldErrors()
                        .stream()
                        .filter(error -> error.getField().equals("company"))
                        .map(error -> error.getDefaultMessage())
                        .findFirst()
                        .orElseGet(() -> ex.getFieldErrors()
                                .stream()
                                .filter(error -> error.getField().equals("location"))
                                .map(error -> error.getDefaultMessage())
                                .findFirst()
                                .orElseGet(() -> ex.getFieldErrors()
                                        .stream()
                                        .filter(error -> error.getField().equals("salary"))
                                        .map(error -> error.getDefaultMessage())
                                        .findFirst()
                                        .orElse("Validation failed"))));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(
            ConstraintViolationException ex) {

        String message = ex.getConstraintViolations()
                .stream()
                .map(error -> error.getMessage())
                .findFirst()
                .orElse("Validation failed");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(message);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}