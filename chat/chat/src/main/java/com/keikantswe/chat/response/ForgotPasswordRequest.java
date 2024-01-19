package com.keikantswe.chat.response;

import lombok.Data;

@Data
public class ForgotPasswordRequest {

    private String email;
    private String newPassword;
}
