package org.example.springboottest2.SS15.Controller;

import org.example.springboottest2.SS15.DTO.AuthResponse;
import org.example.springboottest2.SS15.DTO.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/test")
    public String login() {
        return "service.login(request)";
    }
}
