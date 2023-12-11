package com.keikantswe.chat.service;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    UserEntity fetchUser(String email, String password);

    List<UserEntity> fetchAll();
}
