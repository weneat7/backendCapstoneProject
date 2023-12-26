package com.example.backendcapstoneproject.models;

import lombok.Getter;
import lombok.Setter;

import java.nio.DoubleBuffer;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private Category category;
    private Double price;
    private String description;
    private String imageUrl;
}
