package com.example.demo.courses.subcategory;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Bean
    void addSubcourseCategory(SubcategoryDTO subcategoryDTO) {
        subcategoryRepository.save(courseSubcategories(subcategoryDTO));
    }

    private Subcategory courseSubcategories(SubcategoryDTO subcategoryDTO) {
        Subcategory courseSubcategories = new Subcategory();
        courseSubcategories.setId(subcategoryDTO.getId());
        courseSubcategories.setName(subcategoryDTO.getName());
        courseSubcategories.setDescription(subcategoryDTO.getDescription());
        return courseSubcategories;
    }

    private SubcategoryDTO subcategoryDTO(Subcategory subcategory) {
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        subcategoryDTO.setId(subcategory.getId());
        subcategoryDTO.setName(subcategory.getName());
        subcategoryDTO.setDescription(subcategory.getDescription());
        return subcategoryDTO;
    }

    public List<SubcategoryDTO> getSubcategory() {
        List<Subcategory> allSubcategories = subcategoryRepository.findAll();
        List<SubcategoryDTO> allSubcategoriesDTO = new ArrayList<>();

        for (Subcategory subcategory : allSubcategories) {
            SubcategoryDTO subcategoryDTO = subcategoryDTO(subcategory);
            allSubcategoriesDTO.add(subcategoryDTO);
        }
        return allSubcategoriesDTO;
    }
}
