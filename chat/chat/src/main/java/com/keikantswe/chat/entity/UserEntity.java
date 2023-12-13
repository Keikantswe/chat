package com.keikantswe.chat.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.Constraint;
import org.springframework.lang.NonNull;

@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String userName;

    @Column(unique = true)
    private String email;
    private String password;
}
