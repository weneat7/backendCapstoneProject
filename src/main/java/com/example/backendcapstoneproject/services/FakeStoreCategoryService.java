package com.example.backendcapstoneproject.services;

import com.example.backendcapstoneproject.dto.FakeStoreCategoryDto;
import com.example.backendcapstoneproject.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService {
    RestTemplate restTemplate;

    FakeStoreCategoryService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Category> getAllCategory() {
        ResponseEntity<FakeStoreCategoryDto[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", FakeStoreCategoryDto[].class);
        FakeStoreCategoryDto[] categoryDtoArray = responseEntity.getBody();

        if (categoryDtoArray != null) {
            return convertCategoryDtoArray(categoryDtoArray);
        } else {
            return Collections.emptyList(); // or throw an exception, depending on your error handling strategy
        }
    }

    public List<Category> convertCategoryDtoArray(FakeStoreCategoryDto[] categoryDtos) {
        List<Category> ans = new ArrayList<>();
        for (FakeStoreCategoryDto categoryDto : categoryDtos) {
            ans.add(convertCategoryDto(categoryDto));
        }
        return ans;
    }

    public Category convertCategoryDto(FakeStoreCategoryDto fakeStoreCategoryDto) {
        Category category = new Category();
        category.setName(fakeStoreCategoryDto.getName());
        return category;
    }
}