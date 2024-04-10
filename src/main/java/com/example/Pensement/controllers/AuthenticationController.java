package com.example.Pensement.controllers;

import com.example.Pensement.domain.dtos.user.AuthenticationDTO;
import com.example.Pensement.domain.dtos.user.LoginResponseDTO;
import com.example.Pensement.domain.dtos.user.RegisterDTO;
import com.example.Pensement.services.AuthenticationService;
import com.example.Pensement.services.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        String token = authenticationService.login(authenticationDTO);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO registerDTO) {
        authorizationService.register(registerDTO);
        return ResponseEntity.ok().build();
    }
}

