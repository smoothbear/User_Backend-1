package com.example.agora.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "AlreadyExistException!!")
@Slf4j
public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(){
        super("AlreadyExistException!!");
        log.error("\n이미 회원가입되어있습니다.\nAlreadyExist.");
    }
}
