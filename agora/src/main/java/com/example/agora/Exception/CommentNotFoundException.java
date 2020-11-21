package com.example.agora.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "CommentNotFound!!")
public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(){
        super("CommentNotFound!!");
    }
}
