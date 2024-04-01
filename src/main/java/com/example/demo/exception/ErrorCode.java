package com.example.demo.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User existed"),
    USERNAME_INVALID(1001, "Username must be at least 3"),
    INVALID_KEY(1003,"Invalid message key"),
    PASSWORD_INVALID(1002, "Password must be at least 3"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1006, "Un authenticated")
    ;
    private int code;
    private String message;

     ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
