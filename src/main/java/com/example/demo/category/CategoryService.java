package com.example.demo.category;

import java.util.ArrayList;
import java.util.List;

class CategoryService {
    private final CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    void addCourseCategory(CategoryDTO categoryDTO) {
        categoryRepository.save(coursesCategories(categoryDTO));
    }

     List<CategoryDTO> getCategory() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryDTO> allCategoriesDTO = new ArrayList<>();

        for (Category category : allCategories) {
            CategoryDTO categoryDTO = categoryDTO(category);
            allCategoriesDTO.add(categoryDTO);
        }
        return allCategoriesDTO;
    }

    private Category coursesCategories(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }

    private CategoryDTO categoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }
 }
