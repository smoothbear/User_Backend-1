package com.example.agora.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "CommentNotFound!!")
@Slf4j
public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(){
        super("CommentNotFound!!");
        log.error("\n존재하지 않는 댓글입니다.\nCommentNotFound");
    }
}
