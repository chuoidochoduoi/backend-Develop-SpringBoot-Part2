package org.example.springboottest2.SS8.DTO.Reponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse2<T> {

    private String status;
    private String message;
    private T data;




    // static helper
    public static <T> ApiResponse2<T> ok(T data) {
        return new ApiResponse2<>("success", "OK", data);
    }

    public static <T> ApiResponse2<T> error(String message, T data) {
        return new ApiResponse2<>("error", message, data);
    }
    public static <T> ApiResponse2<T> errorNotFound(String message, T data) {
        return new ApiResponse2<>("404", message, data);
    }
    // getter/setter
}
