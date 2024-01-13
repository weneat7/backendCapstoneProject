package com.example.backendcapstoneproject.models;

import com.example.backendcapstoneproject.controllers.CategoryController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    private String name;

    public Category(){}
    public Category(String name){
        this.name = name;
    }
}
