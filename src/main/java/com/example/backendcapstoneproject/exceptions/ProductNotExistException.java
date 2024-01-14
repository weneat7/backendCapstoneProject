package com.example.backendcapstoneproject.exceptions;

import lombok.experimental.StandardException;


public class ProductNotExistException extends NullPointerException{

    public ProductNotExistException(String message){
        super(message);
    }
}
