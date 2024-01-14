package com.example.backendcapstoneproject.controlerAdvice;

import com.example.backendcapstoneproject.dto.ArithmeticExceptionDto;
import com.example.backendcapstoneproject.dto.ProductNotFoundDto;
import com.example.backendcapstoneproject.exceptions.ProductNotExistException;
import com.example.backendcapstoneproject.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
        ResponseEntity<ArithmeticExceptionDto> arithmeticExceptionHandle(){
        return new ResponseEntity<>(new ArithmeticExceptionDto("Arithmetic Exception has happened"),HttpStatus.OK);
        }


    @ExceptionHandler(ProductNotExistException.class)
        ResponseEntity<ProductNotFoundDto> productNotFoundExceptoinHandle(){
        return new ResponseEntity<>(new ProductNotFoundDto("Product Does not Exist"),HttpStatus.OK);
    }
}
