package org.example.springboottest2.SS15.Service;

import org.example.springboottest2.SS15.DTO.AuthResponse;
import org.example.springboottest2.SS15.DTO.LoginRequest;
import org.example.springboottest2.SS15.DTO.RegisterRequest;
import org.example.springboottest2.SS15.Helper.JwtUtil;
import org.example.springboottest2.SS15.Repository.UserRepository;
import org.example.springboottest2.SS15.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {
        System.out.println("LOGIN CALLED");
        if (repo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email tồn tại");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");

        repo.save(user);

        System.out.println("LOGIN CALLED");
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = repo.findByEmail(request.getEmail()).orElseThrow();

        String accessToken = jwtUtil.generateToken(user);
        String refreshToken = jwtUtil.generateToken(user);

        return new AuthResponse(accessToken, refreshToken);
    }
}
