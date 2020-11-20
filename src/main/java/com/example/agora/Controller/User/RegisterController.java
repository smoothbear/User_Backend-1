package com.example.agora.Controller.User;


import com.example.agora.Payload.Request.User.UserRequest;
import com.example.agora.Service.User.Register.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterController{
    private final RegisterService registerService;

    @PostMapping("/register")
    public String Register(@RequestBody UserRequest request){
        return registerService.register(request);
    }
}
