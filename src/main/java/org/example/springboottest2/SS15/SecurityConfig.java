package org.example.springboottest2.SS15;


import org.example.springboottest2.SS15.Helper.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()

                // bai 2
                .requestMatchers(HttpMethod.POST, "/api/products/**")
                .hasAnyRole("ADMIN", "STAFF")

                .requestMatchers(HttpMethod.PUT, "/api/products/**")
                .hasAnyRole("ADMIN", "STAFF")

                .requestMatchers(HttpMethod.DELETE, "/api/products/**")
                .hasAnyRole("ADMIN", "STAFF")

                // bai 3
                .requestMatchers(HttpMethod.POST, "/api/orders")
                .hasRole("USER")

                .requestMatchers(HttpMethod.GET, "/api/orders/my")
                .hasRole("USER")

                .requestMatchers(HttpMethod.GET, "/api/orders")
                .hasAnyRole("STAFF", "ADMIN")

                .requestMatchers(HttpMethod.PUT, "/api/orders/*/status")
                .hasRole("STAFF")


                // bai 4
                .requestMatchers(HttpMethod.GET, "/api/users/profile")
                .authenticated()

                .requestMatchers(HttpMethod.PUT, "/api/users/*/role")
                .hasRole("ADMIN")


                .anyRequest().authenticated()
        );

        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}