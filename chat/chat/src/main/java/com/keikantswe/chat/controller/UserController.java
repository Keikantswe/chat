package com.keikantswe.chat.controller;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.exception.UserNameNotFoundException;
import com.keikantswe.chat.model.Login;
import com.keikantswe.chat.model.User;
import com.keikantswe.chat.response.ForgotPasswordRequest;
import com.keikantswe.chat.response.LoginResponse;
import com.keikantswe.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


    //Search Users.
    @GetMapping("/users/{username}")
    public ResponseEntity<List<UserEntity>> searchUsers(@PathVariable("username") String userName) throws UserNameNotFoundException {
        List<UserEntity> foundUsers = userService.searchUsers(userName);

        if (!foundUsers.isEmpty()) {
            return ResponseEntity.ok(foundUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //reset password
    @PostMapping("/user/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ForgotPasswordRequest request){

        //Attempt to reset password
        try{
            userService.resetPassword(request.getEmail(), request.getNewPassword());

            return ResponseEntity.ok(request.getEmail() + " password  successfully");

        } catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to reset password");
        }
    }
}
