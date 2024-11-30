package com.ims.InventoryManagementSystem.Exception;

public class UniqueSkuException extends  RuntimeException{
    private  String errorCode;
    public UniqueSkuException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}
