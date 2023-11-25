package com.qpassessment.demo.Exception;

public class ItemNotInStockException extends RuntimeException{

    public ItemNotInStockException(String msg) {
        super(msg);
    }
}
