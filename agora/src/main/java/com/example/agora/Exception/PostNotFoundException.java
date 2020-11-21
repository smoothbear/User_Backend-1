package com.example.agora.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "PostNotFound!")
public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(){
        super("PostNotFound!");
    }
}
