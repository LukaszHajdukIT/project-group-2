package com.example.demo.courses.subcategory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SubcategoryConfig {

    @Bean()
    SubcategoryService subcategoryService(SubcategoryRepository subcategoryRepository) {
        return new SubcategoryService(subcategoryRepository);
    }
}
