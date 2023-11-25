package com.qpassessment.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ItemNotFoundException.class)
    public ResponseEntity<ApiError> handleItemNotFoundException() {

        ApiError apiError = new ApiError(404, "Item not Found");
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ItemNotInStockException.class)
    public ResponseEntity<ApiError> handleItemNotInStockException() {

        ApiError apiError = new ApiError(404, "Item not in stock");
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }
}
