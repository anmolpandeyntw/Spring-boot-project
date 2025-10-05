package com.Firstspring.product.controller;

import com.Firstspring.product.dto.ProductDTO;
import com.Firstspring.product.entity.Product;
import com.Firstspring.product.repository.ProductRepository;
import com.Firstspring.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.hibernate.event.spi.PreDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name="Product REST API CRUD operation",
        description="CREATE READ UPDATE DELETE operation for the Product "
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    //get all product
    @Operation(
            summary="Fetch all Product",
            description = "REST API to fetch all products."
    )
    @GetMapping
    public List<ProductDTO>getAllProduct(){
        return  productService.getAllProduct();
    }@Operation(
            summary="Fetch all Product",
            description = "REST API to fetch all Product."
    )


// get productby id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @ApiResponse(
            responseCode = "201",
            description = "created"
    )
    // create product
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){

   ProductDTO createProduct = productService.createProduct(productDTO);
    return new ResponseEntity<>(createProduct, HttpStatus.CREATED);


    }
//update product
@PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct (@PathVariable Long id, @RequestBody ProductDTO productDTO){
return  productService.updateProduct(id,productDTO);

    }
//delete product
@PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id ){
        return productService.deleteProduct(id);
    }
}