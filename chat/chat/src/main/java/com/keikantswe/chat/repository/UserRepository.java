package com.keikantswe.chat.repository;

import com.keikantswe.chat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    //@Query("SELECT u FROM UserEntity u WHERE u.email=:email AND u.password=:password")
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
    UserEntity findByEmail(String email);

    Optional<UserEntity> findByUserNameContainingIgnoreCase(String userName);
    UserEntity findByUserName(String UserName);
}
