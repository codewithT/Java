package com.ims.InventoryManagementSystem.Exception;

public class NoOrdersExceptioin extends RuntimeException {
    private  String errorCode;
    public NoOrdersExceptioin(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }

}
