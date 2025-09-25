package com.Firstspring.product.service;

import com.Firstspring.product.dto.CategoryDTO;
import com.Firstspring.product.entity.Category;
import com.Firstspring.product.mapper.CategoryMapper;
import com.Firstspring.product.repository.CategoryRepository;
import lombok.AllArgsConstructor; // <--- Add this import for Lombok
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // <--- Add this annotation here
public class CategoryService {

    // Make this field final. Lombok's @AllArgsConstructor will use it
    private  CategoryRepository categoryRepository; // <--- Make it final

    // No need for @Autowired on the field if using @AllArgsConstructor or constructor injection

    // create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    // get all category
    // get category by id
    // delete category
}