package com.example.demo.courses.subcategory;

import com.example.demo.category.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SubcategoryConfig {

    @Bean()
    SubcategoryService subcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        return new SubcategoryService(subcategoryRepository, categoryRepository);
    }
}
