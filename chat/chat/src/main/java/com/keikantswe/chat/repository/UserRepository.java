package com.keikantswe.chat.repository;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    //@Query("SELECT u FROM UserEntity u WHERE u.email=:email AND u.password=:password")
    public UserEntity findByEmailAndPassword(String email, String password);
}
