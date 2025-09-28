package com.Firstspring.product.service;

import com.Firstspring.product.dto.ProductDTO;
import com.Firstspring.product.entity.Category;
import com.Firstspring.product.entity.Product;
import com.Firstspring.product.mapper.ProductMapper;
import com.Firstspring.product.repository.CategoryRepository;
import com.Firstspring.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {




    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

public ProductDTO createProduct (ProductDTO productDTO){

    /**
     *name , descrpiton,price ,categoryId
     *
     * **/
    Category category=categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found!"));
    // DTO => entity
     Product product=ProductMapper.toProductEntity(productDTO,category);
     product=productRepository.save(product);
     // Entity to DTO
    return ProductMapper.toProductDTO(product);



}
//get all produxt
public List<ProductDTO>getAllProduct(){
    return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
}
//get product by id
public ProductDTO getProductById(Long id){
    Product product= productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found Anmol!"));
    return ProductMapper.toProductDTO(product);
}

//update product
    public ProductDTO updateProduct(Long id,ProductDTO productDTO){
        Product product= productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found Anmol!"));


        Category category= categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()->new RuntimeException("Product not found Anmol!"));

   product.setName(productDTO.getName());
   product.setDescription(productDTO.getDescription());
   product.setPrice(productDTO.getPrice());
   product.setCategory(category);

   productRepository.save(product);
return ProductMapper.toProductDTO(product);

    }

    public String deleteProduct(Long id){
    productRepository.deleteById(id);
    return "Product"+id+"has been deleted Anmol!";
    }



}




















