package com.keikantswe.chat.service;

import com.keikantswe.chat.model.User;

public interface UserService {
    User addUser(User user);

    User fetchUser(String email, String password);
}
