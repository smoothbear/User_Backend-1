package com.example.agora.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("UserNotFound!");
    }
}
