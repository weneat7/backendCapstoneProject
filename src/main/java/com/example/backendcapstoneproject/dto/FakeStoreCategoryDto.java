package com.example.backendcapstoneproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCategoryDto{
   private String name;

   FakeStoreCategoryDto(String name){
      this.name = name;
   }
}
