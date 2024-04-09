package com.example.auth.controllers;


import com.example.auth.domain.product.ProductResponseDTO;
import com.example.auth.domain.user.UserResponseDTO;
import com.example.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getAllUsers(){
        List<UserResponseDTO> userList = this.userRepository.findAll().stream().map(UserResponseDTO::new).toList();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable String id){
        var user = this.userRepository.getReferenceById(id);
        return ResponseEntity.ok((new UserResponseDTO(user)));
    }

}
