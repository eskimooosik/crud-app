package com.example.demo.exceptions;

public class UserNotFoundException extends RuntimeException {
    String message = "Пьзователь не найден";

    @Override
    public String getMessage() {
        return message;
    }
}
