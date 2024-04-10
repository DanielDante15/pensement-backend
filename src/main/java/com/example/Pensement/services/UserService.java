package com.example.Pensement.services;

import com.example.Pensement.domain.dtos.user.UserResponseDTO;
import com.example.Pensement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> getAllUsers(){
        return this.repository.findAll().stream().map(UserResponseDTO::new).toList();
    }

    public UserResponseDTO getUserById(String id){
        return new UserResponseDTO(this.repository.getReferenceById(id));
    }
}
