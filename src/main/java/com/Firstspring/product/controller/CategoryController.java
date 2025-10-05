package com.Firstspring.product.controller;


import com.Firstspring.product.Exception.CategoryAlreadyExistsException;
import com.Firstspring.product.dto.CategoryDTO;

import com.Firstspring.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Tag(
        name="Category REST API CRUD operation",
        description="CREATE READ UPDATE DELETE operation for the Category "
)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor


public class CategoryController {

private CategoryService categoryService;
    @Operation(
            summary="Fetch all Category",
            description = "REST API to fetch all Category."
    )
    //get all categories
    @GetMapping
    public List<CategoryDTO > getAllCategoriea(){
        return categoryService.getAllCategories();
    }
    @ApiResponse(
            responseCode = "201",
            description = "created"
    )
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    //create product
    @PostMapping

    public ResponseEntity <?> createCategory (@RequestBody CategoryDTO categoryDTO){

//        try{
                CategoryDTO savedCategory= categoryService.createCategory(categoryDTO );
       return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//
//        }catch (CategoryAlreadyExistsException ex){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//        }

    }

    //get category by id

    @GetMapping("/{id}")

public CategoryDTO getCategoryById(@PathVariable Long id){
       return categoryService.getCategoryById(id);
    }



            // delete product
            @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public  String  deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }



}
