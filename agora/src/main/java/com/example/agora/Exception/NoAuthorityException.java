package com.example.agora.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "NoAuthority!!")
public class NoAuthorityException extends RuntimeException{
    public NoAuthorityException(){
        super("NoAuthority!!");
    }
}
