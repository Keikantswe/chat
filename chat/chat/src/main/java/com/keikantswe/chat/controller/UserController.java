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


    //Reqistering the user
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    //Logging in
    @GetMapping("/login")
    public UserEntity fetchUser(@RequestBody  String email,  String password){
        return userService.fetchUser(email, password);
    }

    @GetMapping("/login/")
    public List<UserEntity> fetchAll(){
        return  userService.fetchAll();
    }
}
