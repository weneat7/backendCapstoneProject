package com.example.backendcapstoneproject.controllers;

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
        return  new ArrayList<>();
        //        return fakeStoreProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){

        return fakeStoreProductService.getSingleProduct(id);
    }

    @PostMapping("")
    public Product addNewProduct(@RequestBody Product product){
        Product p = new Product();
        p.setTitle("Ben10Tshirt");
        p.setId(1L);
        return p;
    }


}
