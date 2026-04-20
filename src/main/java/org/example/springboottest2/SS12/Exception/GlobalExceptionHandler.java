package org.example.springboottest2.SS12.Exception;


import org.example.springboottest2.SS12.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handle(Exception e) {
        return ResponseEntity.status(500)



                .body(new ApiResponse<>(500, "Internal Error", null));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<?>> bad(BadRequestException e) {
        return ResponseEntity.status(400)


                .body(new ApiResponse<>(400, e.getMessage(), null));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<?>> notFound(NotFoundException e) {


        return ResponseEntity.status(404)


                .body(new ApiResponse<>(404, e.getMessage(), null));
    }
}