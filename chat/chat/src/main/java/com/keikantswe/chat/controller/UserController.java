package com.keikantswe.chat.controller;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.Login;
import com.keikantswe.chat.model.User;
import com.keikantswe.chat.response.LoginResponse;
import com.keikantswe.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    //Register the user
    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    //Logging in
    @GetMapping("/login")
    public ResponseEntity<?> fetchUser(@RequestBody Login login){

         LoginResponse loginResponse = userService.fetchUser(login);

        return ResponseEntity.ok(loginResponse);
    }

    //Searching users
    @GetMapping("/users")
    public UserEntity searchUsers( String userName){

        return  userService.searchUsers(userName);
    }
}
