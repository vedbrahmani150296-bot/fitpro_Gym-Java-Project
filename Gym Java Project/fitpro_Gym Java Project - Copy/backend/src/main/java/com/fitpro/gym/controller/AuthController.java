package com.fitpro.gym.controller;

import com.fitpro.gym.dto.LoginRequest;
import com.fitpro.gym.dto.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Hardcoded admin credentials (can be moved to DB later)
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "admin123";

    /**
     * POST /api/auth/login
     * Body: { "username": "admin", "password": "admin123" }
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (ADMIN_USER.equals(request.getUsername()) &&
            ADMIN_PASS.equals(request.getPassword())) {
            return ResponseEntity.ok(new LoginResponse(true, "Login successful", "ADMIN"));
        }
        return ResponseEntity.status(401)
               .body(new LoginResponse(false, "Invalid username or password", null));
    }

    /** GET /api/auth/check — quick health check */
    @GetMapping("/check")
    public ResponseEntity<?> check() {
        return ResponseEntity.ok(Map.of("status", "running", "app", "FitPro Gym API"));
    }
}
