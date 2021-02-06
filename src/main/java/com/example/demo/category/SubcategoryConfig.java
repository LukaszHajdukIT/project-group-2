package com.example.demo.category;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubcategoryConfig {

    @Bean()
    SubcategoryService subcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        return new SubcategoryService(subcategoryRepository, categoryRepository);
    }
}
