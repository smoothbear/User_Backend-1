package com.example.agora.Exception;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(){
        super("CommentNotFound!!");
    }
}
