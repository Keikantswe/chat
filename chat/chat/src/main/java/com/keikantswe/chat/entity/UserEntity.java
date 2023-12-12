package com.keikantswe.chat.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
}
