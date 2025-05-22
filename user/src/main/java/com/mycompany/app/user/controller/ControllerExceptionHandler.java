package com.mycompany.app.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mycompany.app.user.exceptions.AuthException;
import com.mycompany.app.user.http.response.ErrorResponse;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
                .type("MethodArgumentNotValidException")
                .message(ex.getFieldError().getDefaultMessage())
                .build()
        );
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorResponse> handleAuthExceptions(AuthException ex) {
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
                .type(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralExceptions(Exception ex) {
        return ResponseEntity.internalServerError().body(
            ErrorResponse.builder()
                .type("Internal Error")
                .message(ex.getMessage())
                .build()
        );
    }
}
