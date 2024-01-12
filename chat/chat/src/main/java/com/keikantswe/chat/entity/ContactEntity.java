package com.keikantswe.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "contact")
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contact_id;

    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private UserEntity user;

    @ManyToOne
    @JoinColumn(
            name = "Contact_user_id"
    )
    private UserEntity contactUser;


//    @OneToMany(mappedBy = "receiver")  // Correct the mappedBy property
//    private List<MessageEntity> conversations;




}
