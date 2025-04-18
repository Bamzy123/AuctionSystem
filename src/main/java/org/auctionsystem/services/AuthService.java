package org.auctionsystem.services;

import org.auctionsystem.models.User;
import org.auctionsystem.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    public User register(User user) {
        return userRepo.save(user);
    }

    public boolean authenticate(String username, String password) {
        Optional<User> userOpt = userRepo.findByUsername(username);
        return userOpt.map(u -> u.getPassword().equals(password)).orElse(false);
    }
}