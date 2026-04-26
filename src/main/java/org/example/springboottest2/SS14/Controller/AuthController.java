package org.example.springboottest2.SS14.Controller;

import org.example.springboottest2.SS14.DTO.LoginRequest;
import org.example.springboottest2.SS14.Service.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        String token = jwtProvider.generateToken(userDetails.getUsername(), role);

        Map<String, Object> response = new HashMap<>();
        response.put("accessToken", token);
        response.put("type", "Bearer");
        response.put("username", userDetails.getUsername());

        return ResponseEntity.ok(response);
    }
    @GetMapping("/employees")
    public List<String> getEmployees() {
        return List.of("Nguyen Van A", "Tran Van B", "Le Van C");
    }


}