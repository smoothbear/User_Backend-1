package com.example.agora.Controller.User;

import com.example.agora.Payload.Request.User.LoginRequest;
import com.example.agora.Payload.Response.User.LoginResponse;
import com.example.agora.Service.User.Login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/auth")
    public LoginResponse user_login(@RequestBody LoginRequest request){
        return loginService.userLogin(request);
    }
}
