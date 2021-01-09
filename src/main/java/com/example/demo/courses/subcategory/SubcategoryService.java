package com.example.demo.courses.subcategory;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    boolean addCourseSubcategory(SubcategoryDTO subcategoryDTO) {
        if (isNameAlreadyExists(subcategoryDTO.getName())) {
            return false;
        } else {
            subcategoryRepository.save(subcategory(subcategoryDTO));
            return true;
        }
    }

    private boolean isNameAlreadyExists(String subcategoryName) {
        return !subcategoryRepository.findSubcategoryByName(subcategoryName).isEmpty();
    }


    private Subcategory subcategory(SubcategoryDTO subcategoryDTO) {
        Subcategory subcategory = new Subcategory();
        subcategory.setId(subcategoryDTO.getId());
        subcategory.setName(subcategoryDTO.getName());
        subcategory.setDescription(subcategoryDTO.getDescription());
        return subcategory;
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
