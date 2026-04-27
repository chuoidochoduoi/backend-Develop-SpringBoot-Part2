package org.example.springboottest2.SS15.Controller;

import org.example.springboottest2.SS15.DTO.AuthResponse;
import org.example.springboottest2.SS15.DTO.LoginRequest;
import org.example.springboottest2.SS15.DTO.RegisterRequest;
import org.example.springboottest2.SS15.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        System.out.println("LOGIN CALLED");

        service.register(request);

        System.out.println("LOGIN CALLED");
        return "Register success";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

}
