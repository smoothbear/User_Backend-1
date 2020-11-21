package com.example.agora.Exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(){
        super("PostNotFound!");
    }
}
