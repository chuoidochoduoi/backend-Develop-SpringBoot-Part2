package org.example.springboottest2.SS15.DTO;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
}