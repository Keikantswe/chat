package com.keikantswe.chat.controller;

import com.keikantswe.chat.entity.ContactEntity;
import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.service.ContactService;
import com.keikantswe.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;


    private List<UserEntity> userId;

    @GetMapping("/friend/{userName}")
    public ResponseEntity<List<ContactEntity>> searchFriend(@PathVariable("userName") String userName){

        //fix this code
        //Github in Intellij
        //List<ContactEntity> searchedFriend = contactService.searchFriend(userName);

        userId = userService.searchFriend(userName);

        if (searchedFriend != null){
            return ResponseEntity.ok(searchedFriend);
        }else{
            return ResponseEntity.notFound().build();
        }
    }



}
