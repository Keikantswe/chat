package com.keikantswe.chat.service;

import com.keikantswe.chat.entity.ContactEntity;
import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.repository.ContactRepository;
import com.keikantswe.chat.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public ContactEntity searchFriend(String userName) {
        List<UserEntity> user = userRepository.findByUserNameContainingIgnoreCase(userName);

        if (!user.isEmpty()){
            log.info( user + "Found ");
        }else{
            log.info(userName + " Not Found");
        }

        //Come back and fix search friend method
        return (ContactEntity) user;
    }
}
