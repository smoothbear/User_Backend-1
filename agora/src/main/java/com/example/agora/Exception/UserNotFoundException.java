package com.example.agora.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "UserNotFound")
@Slf4j
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("UserNotFound!");
        log.error("\n존재하지 않는 유저입니다.\nUserNotFound.");
    }
}
