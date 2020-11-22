package com.example.agora.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "NoAuthority!!")
@Slf4j
public class NoAuthorityException extends RuntimeException{
    public NoAuthorityException(){
        super("NoAuthority!!");
        log.error("\n권한이 없습니다.\nNoAuthority.");
    }
}
