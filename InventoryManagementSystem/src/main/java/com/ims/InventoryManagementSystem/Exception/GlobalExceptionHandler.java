package com.ims.InventoryManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotAvailableException(ProductNotAvailableException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
        response.put("errorCode", ex.getErrorCode());
        response.put("status", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleOrderNotFoundExceptioin(OrderNotFoundException orderNotFoundException){
        Map<String, Object> response = new HashMap<>();
        response.put("timeStamp", LocalDateTime.now());
        response.put("Message" , orderNotFoundException.getMessage());
        response.put("errorCode" , orderNotFoundException.getErrorCode());
        response.put("status " , HttpStatus.BAD_REQUEST.value());
        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoOrdersExceptioin.class)
    public ResponseEntity<Map<String,Object>> handleNoOrdersException(NoOrdersExceptioin noOrdersExceptioin){
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp" , LocalDateTime.now());
        response.put("Message", noOrdersExceptioin.getMessage());
        response.put("Error Code " , noOrdersExceptioin.getErrorCode());
        response.put("Status " , HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UniqueSkuException.class)
    public ResponseEntity<Map<String,Object>> UniqueSkuException(UniqueSkuException uniqueSkuException){
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp" , LocalDateTime.now());
        response.put("Message", uniqueSkuException.getMessage());
        response.put("Error Code " , uniqueSkuException.getErrorCode());
        response.put("Status " , HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
