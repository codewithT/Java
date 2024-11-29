package com.ims.InventoryManagementSystem.Exception;


public class ProductNotAvailableException extends RuntimeException {
    private  String errorCode;
    public ProductNotAvailableException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}
