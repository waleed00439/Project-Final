package com.example.gamesonlinedatabase1.advise;

import com.example.gamesonlinedatabase1.dto.ApiResponse;
import com.example.gamesonlinedatabase1.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> apiException(ApiException apiException) {
        String msg = apiException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg, 400));
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiResponse> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg, 400));
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> EntityNotFoundException(EntityNotFoundException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg, 400));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg, 400));
    }
}
