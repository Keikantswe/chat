package com.keikantswe.chat.service;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.exception.UserNameNotFoundException;
import com.keikantswe.chat.model.Login;
import com.keikantswe.chat.model.User;
import com.keikantswe.chat.response.LoginResponse;

import java.util.List;

public interface UserService {
    User addUser(User user);

    LoginResponse fetchUser(Login login);

    void resetPassword(String email, String newPassword);

    List<UserEntity> searchUsers(String userName) throws UserNameNotFoundException;

    // List<UserEntity> searchUsers(String userName);
}
