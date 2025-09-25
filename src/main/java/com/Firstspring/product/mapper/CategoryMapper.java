package com.Firstspring.product.mapper;

import com.Firstspring.product.dto.CategoryDTO;
import com.Firstspring.product.entity.Category;

import javax.smartcardio.CardTerminal;

public class CategoryMapper  {


    public static CategoryDTO toCategoryDTO(Category category){
        if(category==null ){
            return null;
        }
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream()
                .map(ProductMapper::toproductDTO).toList());// yeha toProductDTO hona chiya per error a rha hai

return categoryDTO;
    }
    public static Category toCategoryEntity (CategoryDTO categoryDTO){


        Category category=new Category();
        category.setName(categoryDTO.getName());
        return category;
    }


}
