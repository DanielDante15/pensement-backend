package com.example.auth.domain.user;


public record UserResponseDTO(String id, String name, String email) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }


}
