package com.example.demo.categories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class CategoryConfig {
    @Bean
    CategoryService categoryService(CategoryRepository categoryRepository){
        return new CategoryService(categoryRepository);
    }
}
