package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public List<Category> getAllCategory();
}
