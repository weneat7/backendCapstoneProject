package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.dto.FakeStoreProductDto;
import com.example.backendcapstoneproject.models.Category;
import com.example.backendcapstoneproject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


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
        int a = 10;
       return convertFakeStoreProduct(productDto);
    }

    public Product convertFakeStoreProduct(FakeStoreProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setId(productDto.getId());
        product.setCategory(new Category( ));
        product.getCategory().setName(productDto.getCategory());
        product.getCategory().setId(productDto.getId());
        product.setImageUrl(productDto.getImage());
        product.setPrice(productDto.getPrice());
        return  product;
    }
}
