package com.keikantswe.chat.repository;

import com.keikantswe.chat.entity.ContactEntity;
import com.keikantswe.chat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    Optional<ContactEntity> findByUserAndContactUser(UserEntity user, UserEntity contact_user);
}
