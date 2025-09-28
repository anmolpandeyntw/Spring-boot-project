package com.Firstspring.product.controller;

import com.Firstspring.product.dto.ProductDTO;
import com.Firstspring.product.entity.Product;
import com.Firstspring.product.repository.ProductRepository;
import com.Firstspring.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.hibernate.event.spi.PreDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    //get all product
    @GetMapping
    public List<ProductDTO>getAllProduct(){
        return  productService.getAllProduct();
    }


// get productby id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // create product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){

   ProductDTO createProduct = productService.createProduct(productDTO);
    return new ResponseEntity<>(createProduct, HttpStatus.CREATED);


    }
//update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct (@PathVariable Long id, @RequestBody ProductDTO productDTO){
return  productService.updateProduct(id,productDTO);

    }
//delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id ){
        return productService.deleteProduct(id);
    }


}
