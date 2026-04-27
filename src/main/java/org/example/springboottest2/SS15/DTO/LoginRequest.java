package org.example.springboottest2.SS15.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}