package com.dantecaio.pensement.controllers;

import com.dantecaio.pensement.models.records.UserData;
import com.dantecaio.pensement.models.records.UserDataResponse;
import com.dantecaio.pensement.services.user.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserSaveService userSaveService;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDataResponse> register(@RequestBody UserData data, UriComponentsBuilder uriComponentsBuilder) {
        UserDataResponse userDataResponse = userSaveService.save(data);
        UriComponents uriComponents = uriComponentsBuilder.path("/user/{id}").buildAndExpand(userDataResponse.id());
        return ResponseEntity.created(uriComponents.toUri()).body(userDataResponse);
    }

}
