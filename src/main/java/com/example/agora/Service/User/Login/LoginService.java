package com.example.agora.Service.User.Login;

import com.example.agora.Payload.Request.User.LoginRequest;
import com.example.agora.Payload.Response.User.LoginResponse;

public interface LoginService {
    public LoginResponse userLogin(LoginRequest request);
}
