package com.example.agora.Payload.Request.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String userId;
    private String userPw;

    public UsernamePasswordAuthenticationToken getAuthToken(int userCode){
        return new UsernamePasswordAuthenticationToken(userCode, userPw);
    }
}
