package com.example.backendcapstoneproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundDto {
    private String message;

    public ProductNotFoundDto(String productDoesNotExist) {
        this.message = productDoesNotExist;
    }
}
