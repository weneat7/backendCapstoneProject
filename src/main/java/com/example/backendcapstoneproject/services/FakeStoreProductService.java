package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.dto.FakeStoreCategoryDto;
import com.example.backendcapstoneproject.dto.FakeStoreProductDto;
import com.example.backendcapstoneproject.models.Category;
import com.example.backendcapstoneproject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class FakeStoreProductService implements ProductService{

     private final RestTemplate restTemplate;

     @Autowired
     public FakeStoreProductService(RestTemplate restTemplate){
         this.restTemplate = restTemplate;
     }
    @Override
    public Product getSingleProduct(Long id) {

       FakeStoreProductDto productDto =  restTemplate.getForObject(
                                    "https://fakestoreapi.com/products/"+id,
                                            FakeStoreProductDto.class);
       return convertFakeStoreProduct(productDto);
    }

    public List<Product> getAllProducts(){
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        FakeStoreProductDto[] productDtoArray = responseEntity.getBody();

         List<Product> products = new ArrayList<>();


        for(FakeStoreProductDto productDto : productDtoArray){
             products.add(convertFakeStoreProduct(productDto));
         }
         return products;
    }

    public List<Product> getByCategory(String categoryName){
         ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/category/"+categoryName,FakeStoreProductDto[].class);
         FakeStoreProductDto[] productDtoArray = responseEntity.getBody();

        List<Product> products = new ArrayList<>();

        assert productDtoArray != null;
        for(FakeStoreProductDto productDto : productDtoArray){
            products.add(convertFakeStoreProduct(productDto));
        }
        return products;
    }

    public Product addNewProduct(FakeStoreProductDto productDto) {
        HttpEntity<FakeStoreProductDto> request = new HttpEntity<>(productDto);
        FakeStoreProductDto addedProductDto = restTemplate.postForObject("https://fakestoreapi.com/products", request, FakeStoreProductDto.class);

        assert addedProductDto !=null;
        return convertFakeStoreProduct(addedProductDto);
     }


    public Product convertFakeStoreProduct(FakeStoreProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setId(productDto.getId());
        product.setCategory(new Category( ));
        product.getCategory().setName(productDto.getCategory());
        product.setImageUrl(productDto.getImage());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return  product;
    }

    public Product updateProduct(FakeStoreProductDto productDto){
         return null;
    }
}
