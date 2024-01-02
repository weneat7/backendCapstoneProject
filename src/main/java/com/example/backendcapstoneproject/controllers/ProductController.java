package com.example.backendcapstoneproject.controllers;

import com.example.backendcapstoneproject.dto.FakeStoreProductDto;
import com.example.backendcapstoneproject.models.Product;
import com.example.backendcapstoneproject.services.FakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    FakeStoreProductService fakeStoreProductService;

    @Autowired
    ProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
           return fakeStoreProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){

        return fakeStoreProductService.getSingleProduct(id);
    }

    @GetMapping("/category/{id}")
    public List<Product> getProductByCategory(@PathVariable("id") String categoryName){
        return fakeStoreProductService.getByCategory(categoryName);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") int id){
        return  null;
    }

    @PostMapping("/create")
    public Product addNewProduct(@RequestBody Product product){
        return fakeStoreProductService.addNewProduct(convertProductIntoProductDto(product));
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
       return fakeStoreProductService.deleteproduct(id);

    }

    public FakeStoreProductDto convertProductIntoProductDto(Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setDescription(product.getDescription());
        return fakeStoreProductDto;
    }
}





