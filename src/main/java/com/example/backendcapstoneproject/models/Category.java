package com.example.backendcapstoneproject.models;

import com.example.backendcapstoneproject.controllers.CategoryController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private String name;

    public Category(){}
    public Category(String name){
        this.name = name;
    }
}
