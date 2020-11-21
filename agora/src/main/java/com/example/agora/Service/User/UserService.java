package com.example.agora.Service.User;

import com.example.agora.Payload.Request.User.LoginRequest;
import com.example.agora.Payload.Request.User.UserRequest;
import com.example.agora.Payload.Response.User.LoginResponse;
import com.example.agora.Payload.Response.User.MypageResponse;

public interface UserService {
    public String register(UserRequest request);
    public LoginResponse userLogin(LoginRequest request);
    public MypageResponse myPage();
}
