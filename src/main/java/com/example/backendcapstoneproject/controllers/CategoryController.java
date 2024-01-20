package com.example.backendcapstoneproject.controllers;

import com.example.backendcapstoneproject.models.Category;
import com.example.backendcapstoneproject.services.FakeStoreCategoryService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    FakeStoreCategoryService categoryService;
    @Autowired
    CategoryController(FakeStoreCategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> getCategories(){
        return categoryService.getAllCategory();
    }
}
