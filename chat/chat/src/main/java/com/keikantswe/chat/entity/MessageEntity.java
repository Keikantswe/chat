package com.keikantswe.chat.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId")
    private Long messageId;

    @Lob
    private String file;
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;

    @Column(name = "message")
    private String message;

    public MessageEntity(UserEntity sender, UserEntity receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public MessageEntity(String sender, String receiver, String message) {
    }
}
