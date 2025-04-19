package org.auctionsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.auctionsystem.Dtos.DtoMapper;
import org.auctionsystem.Dtos.UserDto;
import org.auctionsystem.Dtos.request.AuthRequest;
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
    public ResponseEntity<UserDto> register(@RequestBody AuthRequest request) {
        User userEntity = DtoMapper.toUserEntity(new UserDto(null, request.getUsername()));
        userEntity.setPassword(request.getPassword());
        User saved = authService.register(userEntity);
        return ResponseEntity.ok(DtoMapper.toUserDto(saved));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        boolean ok = authService.authenticate(request.getUsername(), request.getPassword());
        return ok ? ResponseEntity.ok("Login successful") : ResponseEntity.badRequest().build();
    }
}
