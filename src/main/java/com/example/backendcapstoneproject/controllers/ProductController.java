package com.example.backendcapstoneproject.controllers;

import com.example.backendcapstoneproject.dto.FakeStoreProductDto;
import com.example.backendcapstoneproject.models.Product;
import com.example.backendcapstoneproject.services.FakeStoreProductService;
import com.example.backendcapstoneproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;

    @Autowired
    ProductController(@Qualifier("SelfProductService")ProductService productService,RestTemplate restTemplate){

        this.restTemplate = restTemplate;
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
           return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id){
            return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
        }

    @GetMapping("/category/{id}")
    public List<Product> getProductByCategory(@PathVariable("id") String categoryName){
        return productService.getByCategory(categoryName);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") int id){
        return  null;
    }

    @PostMapping("/create")
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
       return productService.deleteproduct(id);

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





