package com.example.agora.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "PostNotFound!")
@Slf4j
public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(){
        super("PostNotFound!");
        log.error("\n존재하지 않는 글입니다.\nPostNotFound.");
    }
}
