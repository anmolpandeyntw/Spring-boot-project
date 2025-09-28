package com.Firstspring.product.service;

import com.Firstspring.product.dto.CategoryDTO;
import com.Firstspring.product.entity.Category;
import com.Firstspring.product.mapper.CategoryMapper;
import com.Firstspring.product.repository.CategoryRepository;
import lombok.AllArgsConstructor; // <--- Add this import for Lombok
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    // get category by id
    public CategoryDTO getCategoryById(Long id){
        Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found Anmol!"));
return CategoryMapper.toCategoryDTO(category);
    }
    // delete category
public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category" + id + " has been deleted Anmol!";

}


}