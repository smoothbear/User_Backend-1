package com.example.agora.Exception;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(){
        super("InvalidToken!!");
    }
}
