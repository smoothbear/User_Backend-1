package com.example.agora.Payload.Response.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private final String AccessToken;
    private final String RefreshToken;
    private final Long RefreshToken_exp;



}