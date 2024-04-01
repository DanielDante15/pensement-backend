package com.dantecaio.pensement.services.user;

import com.dantecaio.pensement.models.records.UserData;
import com.dantecaio.pensement.models.records.UserDataResponse;

public interface UserSaveService {
    UserDataResponse save(UserData userData);
}
