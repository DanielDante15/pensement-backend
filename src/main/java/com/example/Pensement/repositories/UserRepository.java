package com.example.Pensement.repositories;

import com.example.Pensement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,String> {
    UserDetails findByEmail(String email);
}
