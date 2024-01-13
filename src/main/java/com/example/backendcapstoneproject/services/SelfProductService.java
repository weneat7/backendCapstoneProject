package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.controllers.CategoryController;
import com.example.backendcapstoneproject.dto.FakeStoreProductDto;
import com.example.backendcapstoneproject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    RestTemplate restTemplate;
    CategoryService categoryService;

    @Autowired
    SelfProductService(RestTemplate restTemplate, CategoryService categoryService){
        this.categoryService = categoryService;
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product deleteproduct(Long id) {
        return null;
    }

    @Override
    public Product addNewProduct(FakeStoreProductDto productDto) {
        return null;
    }

    @Override
    public List<Product> getByCategory(String categoryName) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
