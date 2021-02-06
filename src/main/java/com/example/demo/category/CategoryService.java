package com.example.demo.category;

import com.example.demo.models.Category;

import java.util.ArrayList;
import java.util.List;

 class CategoryService {
    private final CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    boolean addCourseCategory(CategoryDTO categoryDTO) {
        if (nameAlreadyExists(categoryDTO.getName())) {
            return false;
        } else {
            categoryRepository.save(category(categoryDTO));
            return true;
        }
    }

    private boolean nameAlreadyExists(String categoryName) {
        return !categoryRepository.findCategoryByName(categoryName).isEmpty();
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

    private Category category(CategoryDTO categoryDTO) {
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