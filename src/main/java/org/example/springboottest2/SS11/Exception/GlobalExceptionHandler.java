package org.example.springboottest2.SS11.Exception;


import lombok.extern.slf4j.Slf4j;
import org.example.springboottest2.SS9.DTO.ApiResponse;
import org.example.springboottest2.SS9.Exception.DuplicateResourceException;
import org.example.springboottest2.SS9.Exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
//
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiResponse<String>> handleException(Exception e) {
//
//        log.error("Lỗi hệ thống xảy ra: ", e);
//
//        return ResponseEntity
//                .status(500)
//                .body(ApiResponse.failValidate("Lỗi hệ thống, vui lòng thử lại sau", null));
//    }
//
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponse<Map<String,String>>> handleValidation(MethodArgumentNotValidException e) {
//        Map<String, String> errors = new HashMap<>();
//        log.warn("Lỗi validate dữ liệu: {}", e.getMessage());
//
//        // lấy từng lỗi ra
//        e.getBindingResult().getFieldErrors().forEach(error -> {
//            errors.put(error.getField(), error.getDefaultMessage());
//        });
//
//        return ResponseEntity.status(404).body(ApiResponse.failValidate("du lieu ko hop le",errors));
//    }
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException e) {
//
//        log.warn("Không tìm thấy resource: {}", e.getMessage());
//
//        return ResponseEntity.status(404).body(ApiResponse.failValidate("ko tìm thấy",e.getMessage()));
//    }
//    @ExceptionHandler(DuplicateResourceException.class)
//    public ResponseEntity<ApiResponse<String>> handleDuplicateResourceException (DuplicateResourceException e) {
//
//        log.warn("Resource đã tồn tại: {}", e.getMessage());
//
//        return ResponseEntity.status(409).body(ApiResponse.failValidate("da ton tai",e.getMessage()));
//    }
//
//}
