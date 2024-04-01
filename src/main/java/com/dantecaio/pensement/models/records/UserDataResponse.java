package com.dantecaio.pensement.models.records;

import com.dantecaio.pensement.models.User;

public record UserDataResponse(String id, String name, String email, String password, String role ) {

    public UserDataResponse(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole());
    }
}
