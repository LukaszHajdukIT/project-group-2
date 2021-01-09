package com.example.demo.courses.subcategories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Bean
    public void addSubcourseCategory(SubcategoryDTO subcategoryDTO) {
        subcategoryRepository.save(courseSubcategories(subcategoryDTO));
    }

    private Subcategory courseSubcategories(SubcategoryDTO subcategoryDTO) {
        Subcategory courseSubcategories = new Subcategory();
        courseSubcategories.setId(subcategoryDTO.getId());
        courseSubcategories.setName(subcategoryDTO.getName());
        courseSubcategories.setDescription(subcategoryDTO.getDescription());
        return courseSubcategories;
    }
}
