package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfCategoryService")
public class SelfCategoryService implements CategoryService{
    @Override
    public List<Category> getAllCategory() {
        return null;
    }
}
