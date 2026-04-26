package org.example.springboottest2.SS13.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/v1/auth")
//public class AuthController {
//    @GetMapping("/test")
//    public String test() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encoded = encoder.encode("123456");
//        System.out.println(encoded);
//        return "Public API: Access Granted!";
//    }
//}