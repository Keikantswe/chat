package com.keikantswe.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String messageId;

    private String message;
    private String file;
    private Date timeStamp;

}
