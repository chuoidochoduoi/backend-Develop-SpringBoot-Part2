package org.example.springboottest2.SS9.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@Data

public class ApiResponse<T> {
    String status;
    String message;
    T data;

    public static <T>ApiResponse<T> success(T data){

        return new ApiResponse<>("success", "OK", data);
    }
    public static <T>ApiResponse<T> failValidate(String message ,T data){

        return new ApiResponse<>("FAIL", message, data);
    }
}
