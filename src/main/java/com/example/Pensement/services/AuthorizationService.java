package com.example.Pensement.services;

import com.example.Pensement.domain.dtos.user.RegisterDTO;
import com.example.Pensement.entities.User;
import com.example.Pensement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void register(RegisterDTO registerDTO) {
        if (userRepository.findByEmail(registerDTO.email()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        String encryptedPassword = passwordEncoder.encode(registerDTO.password());
        User newUser = new User(registerDTO.name(), registerDTO.email(), encryptedPassword);

        userRepository.save(newUser);
    }
}
