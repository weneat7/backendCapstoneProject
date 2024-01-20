package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.exceptions.ProductNotExistException;
import com.example.backendcapstoneproject.models.Category;
import com.example.backendcapstoneproject.models.Product;
import com.example.backendcapstoneproject.repositories.CategoryRepository;
import com.example.backendcapstoneproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{


    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistException {
//        Optional<Product> optionalProduct = productRepository.findById(id);
//        if(optionalProduct.isEmpty()) {
//            throw new ProductNotExistException("Product with id: "+id+ ", does not exist");
//        }
//        return optionalProduct.get();
        return  productRepository.findProductById(id);
    }

    @Override
    public Product deleteproduct(Long id) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();

        if(category.getId() == null)
        {
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        return productRepository.save(product);
    }

        @Override
        public List<Product> getByCategory (String categoryName){
            return productRepository.findByCategory_Name(categoryName);
        }

        @Override
        public List<Product> getAllProducts () {
            return productRepository.findAll();
        }
    }
