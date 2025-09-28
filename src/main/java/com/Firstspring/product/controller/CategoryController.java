package com.Firstspring.product.controller;


import com.Firstspring.product.dto.CategoryDTO;

import com.Firstspring.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

private CategoryService categoryService;
    //get all categories
    @GetMapping
    public List<CategoryDTO > getAllCategoriea(){
        return categoryService.getAllCategories();
    }

    //create product
    @PostMapping

    public ResponseEntity <CategoryDTO> createCategory (@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>( categoryService.createCategory(categoryDTO ) , HttpStatus.CREATED);
    }

    //get category by id

    @GetMapping("/{id}")

public CategoryDTO getCategoryById(@PathVariable Long id){
       return categoryService.getCategoryById(id);
    }



            // delete product
    @DeleteMapping("/{id}")
    public  String  deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }



}
