package com.Firstspring.product.mapper;

import com.Firstspring.product.dto.CategoryDTO;
import com.Firstspring.product.dto.ProductDTO;
import com.Firstspring.product.entity.Category;
import com.Firstspring.product.entity.Product;

public class ProductMapper {


    //entity to dto
    public static ProductDTO toproductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()

        );
    }

// DTO TO ENTITY
    public static  Product toProductEntity(ProductDTO productDTO, Category category){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(product.getPrice());
        product.setDescription(product.getDescription());
        product.setCategory(category);


        return product;

    }



}
