package com.example.Pensement.domain.dtos.user;


import com.example.Pensement.entities.User;

public record UserResponseDTO(String id, String name, String email) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }


}
