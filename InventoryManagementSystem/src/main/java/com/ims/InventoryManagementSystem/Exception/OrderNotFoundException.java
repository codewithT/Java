package com.ims.InventoryManagementSystem.Exception;

public class OrderNotFoundException extends RuntimeException{
    private  String errorCode;
    public OrderNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}
