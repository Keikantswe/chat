package com.keikantswe.chat.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String messageId;

    @Lob
    private String message;
    private String file;
    private Date timeStamp;


     @ManyToOne(
     cascade = CascadeType.ALL
     )
     @JoinColumn(
     name  = "User_Id",
     referencedColumnName = "id"
     )
     private UserEntity userEntity;

}
