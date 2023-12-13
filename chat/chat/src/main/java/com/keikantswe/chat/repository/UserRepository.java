package com.keikantswe.chat.repository;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.Login;
import com.keikantswe.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    //@Query("SELECT u FROM UserEntity u WHERE u.email=:email AND u.password=:password")
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
    UserEntity findByEmail(String email);

    UserEntity findByUserNameContainingIgnoreCase(String userName);
}
