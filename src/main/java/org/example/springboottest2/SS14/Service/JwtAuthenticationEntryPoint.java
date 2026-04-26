package org.example.springboottest2.SS14.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        Map<String, Object> body = new HashMap<>();

        String message = (String) request.getAttribute("error");

        if (message == null) {
            message = "Token không hợp lệ hoặc đã hết hạn";
        }

        body.put("message", message);
        body.put("status", 401);
        body.put("error", "Unauthorized");
        body.put("path", request.getRequestURI());

        new ObjectMapper().writeValue(response.getOutputStream(), body);
    }
}