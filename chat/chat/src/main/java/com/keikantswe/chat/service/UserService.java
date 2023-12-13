package com.keikantswe.chat.service;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.Login;
import com.keikantswe.chat.model.User;
import com.keikantswe.chat.response.LoginResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User addUser(User user);


    UserEntity searchUsers(String name);

    LoginResponse fetchUser(Login login);
}
