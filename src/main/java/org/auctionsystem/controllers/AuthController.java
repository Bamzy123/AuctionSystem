package org.auctionsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.auctionsystem.models.User;
import org.auctionsystem.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean ok = authService.authenticate(user.getUsername(), user.getPassword());
        return ok ? ResponseEntity.ok("Login successful") : ResponseEntity.badRequest().build();
    }
}
