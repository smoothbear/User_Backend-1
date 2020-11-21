package com.example.agora.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "AlreadyExistException!!")
public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(){
        super("AlreadyExistException!!");
    }
}
