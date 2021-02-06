package com.example.demo.category;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class CategoryConfig {
    @Bean
    CategoryService categoryService(CategoryRepository categoryRepository){
        return new CategoryService(categoryRepository);
    }
}