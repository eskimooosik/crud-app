package com.example.demo.exceptions;

public class UserExistsException extends RuntimeException {
    String message = "Пьзователь с таким email уже зарегистрирован";

    @Override
    public String getMessage() {
        return message;
    }
}
