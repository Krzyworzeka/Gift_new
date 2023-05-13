package com.example.exception;

public class taskHasAssignedUser extends RuntimeException{

    private String errorCode = "CODE003";

    public taskHasAssignedUser(String s) {
        super(s);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
