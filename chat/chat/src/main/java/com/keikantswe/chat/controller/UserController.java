package com.keikantswe.chat.controller;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.User;
import com.keikantswe.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/user/{email}/{password}")
    public User fetchUser(@RequestParam String email, @RequestParam String password){
        return userService.fetchUser(email, password);
    }
}
