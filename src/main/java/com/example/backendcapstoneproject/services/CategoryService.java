package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.models.Category;

import java.util.List;

public interface CategoryService {
    public Category getSingleCategory(String categoryValue);
    public List<Category> getAllCategory();
}
