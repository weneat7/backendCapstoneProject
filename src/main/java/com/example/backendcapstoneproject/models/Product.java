package com.example.backendcapstoneproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.nio.DoubleBuffer;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    @ManyToOne
    private Category category;
    private Double price;
    private String description;
    private String imageUrl;
}
