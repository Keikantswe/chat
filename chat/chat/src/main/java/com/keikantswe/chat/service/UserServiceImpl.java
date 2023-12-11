package com.keikantswe.chat.service;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.User;
import com.keikantswe.chat.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user, userEntity);

        userRepository.save(userEntity);

        return user;
    }

    //Logging in
    @Override
    public UserEntity fetchUser(String email, String password) {

        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<UserEntity> fetchAll() {

        return userRepository.findAll();
    }


}
