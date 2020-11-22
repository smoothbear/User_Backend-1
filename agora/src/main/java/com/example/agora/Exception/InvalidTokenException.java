package com.example.agora.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "InvalidToken!!")
@Slf4j
public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(){
        super("InvalidToken!!");
        log.error("\n유효하지 않은 토큰입니다.\nInvalidToken.");
    }
}
