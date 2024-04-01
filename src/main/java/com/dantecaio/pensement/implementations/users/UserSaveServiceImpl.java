package com.dantecaio.pensement.implementations.users;

import com.dantecaio.pensement.models.User;
import com.dantecaio.pensement.models.records.UserData;
import com.dantecaio.pensement.models.records.UserDataResponse;
import com.dantecaio.pensement.repositories.UserRepository;
import com.dantecaio.pensement.services.user.UserSaveService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserSaveServiceImpl implements UserSaveService {
    private final UserRepository userRepository;

    public UserSaveServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDataResponse save(UserData userData) {
        User user = new User();

        BeanUtils.copyProperties(userData,user);
        userRepository.save(user);
        return (new UserDataResponse(user));
    }
}