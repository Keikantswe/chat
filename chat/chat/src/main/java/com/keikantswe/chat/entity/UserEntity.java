package com.keikantswe.chat.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.Constraint;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Data
//@Table(name = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MessageEntity> sentMessage;


    @JsonIgnore

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<MessageEntity> receivedConversations;
}
