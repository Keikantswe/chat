package com.keikantswe.chat.service;

import com.keikantswe.chat.entity.UserEntity;
//import com.keikantswe.chat.exception.User;
import com.keikantswe.chat.exception.UserNameNotFoundException;
import com.keikantswe.chat.model.Login;
import com.keikantswe.chat.model.User;
import com.keikantswe.chat.repository.UserRepository;
import com.keikantswe.chat.response.ForgotPasswordRequest;
import com.keikantswe.chat.response.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
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
    //Come back and add authentication for changing password
    public void resetPassword(String email, String newPassword) {

        UserEntity user = userRepository.findByEmail(email);

        if( user != null){
            user.setPassword(this.passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }

    }

    //Search for users
    @Override
    public List<UserEntity> searchUsers(String userName) throws UserNameNotFoundException {
        List<UserEntity> users = userRepository.findByUserNameContainingIgnoreCase(userName);

        if (!users.isEmpty()) {
            log.info("Found" + users);
        } else {
            //throw new UserNameNotFoundException("Did not find"+ userName);
        }
        return users;
    }

}
