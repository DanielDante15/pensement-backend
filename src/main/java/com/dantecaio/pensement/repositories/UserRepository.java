package com.dantecaio.pensement.repositories;

import com.dantecaio.pensement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
