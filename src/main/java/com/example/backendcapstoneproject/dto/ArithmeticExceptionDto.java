package com.example.backendcapstoneproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArithmeticExceptionDto {
    private String message;
    public ArithmeticExceptionDto(String message){
        this.message = message;
    }
}
