package org.example.springboottest2.SS8.DTO.Reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {


    private  int status;
    private String message;
    private Instant timestamp;




    public static ErrorResponse errorNotFound(String message,Instant timestamp ) {
        return new ErrorResponse(404,message, timestamp);
    }

    public static ErrorResponse errorNotValid(String message,Instant timestamp ) {
        return new ErrorResponse(400,message, timestamp);
    }

}
