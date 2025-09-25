package com.Firstspring.product.controller;


import com.Firstspring.product.dto.CategoryDTO;

import com.Firstspring.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

private CategoryService categoryService;
    //get all categories
    //create product
    @PostMapping

    public ResponseEntity <CategoryDTO> createCategory (@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>( categoryService.createCategory(categoryDTO ) , HttpStatus.CREATED);
    }
    //update product
    //get product by id
            // delete product
}
