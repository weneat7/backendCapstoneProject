package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.dto.FakeStoreProductDto;
import com.example.backendcapstoneproject.models.Product;

import java.util.List;

public interface ProductService{

    public Product getSingleProduct(Long id);

    Product deleteproduct(Long id);

    Product addNewProduct(Product product);

    List<Product> getByCategory(String categoryName);

    List<Product> getAllProducts();
}
