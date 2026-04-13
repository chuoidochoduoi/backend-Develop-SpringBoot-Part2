package org.example.springboottest2.SS9.Exception;


import org.example.springboottest2.SS9.DTO.ApiResponse;
import org.example.springboottest2.SS9.DTO.DepartmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleValidation(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        // lấy từng lỗi ra
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(404).body(ApiResponse.failValidate("du lieu ko hop le",errors));
    }

        @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException e) {


        return ResponseEntity.status(404).body(ApiResponse.failValidate("ko tìm thấy",e.getMessage()));
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<String>> handleDuplicateResourceException (DuplicateResourceException e) {


        return ResponseEntity.status(409).body(ApiResponse.failValidate("da ton tai",e.getMessage()));
    }

}
