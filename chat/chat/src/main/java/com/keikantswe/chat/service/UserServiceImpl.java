package com.keikantswe.chat.service;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.Login;
import com.keikantswe.chat.model.User;
import com.keikantswe.chat.repository.UserRepository;
import com.keikantswe.chat.response.LoginResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserName(user.getUserName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(this.passwordEncoder.encode(user.getPassword()));

        //BeanUtils.copyProperties(user, userEntity);

        userRepository.save(userEntity);

        return user;
    }

    //Logging in
    @Override
    public LoginResponse fetchUser(Login login) {

        UserEntity userEntity = userRepository.findByEmail(login.getEmail());

        String enterPassword = login.getPassword();
        String userPassword = userEntity.getPassword();

        boolean matchPassword = passwordEncoder.matches(enterPassword , userPassword);

        if(matchPassword){

            Optional<UserEntity> userEntityOptional =
                    userRepository.findByEmailAndPassword(login.getEmail(), enterPassword);

            if(userEntityOptional.isPresent()){
                return new LoginResponse("Login Successfully","200, Welcome");
            }else {
                return new LoginResponse("Check your Email or Password", "Try again");
            }

        }else {
            return new LoginResponse("Invalid password", ".");
        }

    }

    @Override
    public UserEntity searchUsers(String userName) {
        return userRepository.findByUserNameContainingIgnoreCase(userName);
    }

}
