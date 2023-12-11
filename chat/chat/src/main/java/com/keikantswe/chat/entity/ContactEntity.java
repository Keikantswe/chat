package com.keikantswe.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "contact")
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contact_id;

    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private UserEntity other_user;

    @ManyToOne
    @JoinColumn(
            name = "Contact_user_id"
    )
    private UserEntity contact_user;

}
