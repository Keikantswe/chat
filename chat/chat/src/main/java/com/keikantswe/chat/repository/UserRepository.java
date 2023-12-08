package com.keikantswe.chat.repository;

import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    public User findByEmailAndPassword(String email, String Password);
}
