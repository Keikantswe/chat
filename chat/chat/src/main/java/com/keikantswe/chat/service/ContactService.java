package com.keikantswe.chat.service;

import com.keikantswe.chat.entity.ContactEntity;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {
    ContactEntity searchFriend(String userName);
}
