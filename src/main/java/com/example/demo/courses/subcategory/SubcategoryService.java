package com.example.demo.courses.subcategory;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;
import com.example.demo.coursers.Course;
import com.example.demo.coursers.CourseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private CategoryRepository categoryRepository;

    SubcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public boolean addCourseSubcategory(SubcategoryDTO subcategoryDTO) {
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
        List<Subcategory> all = subcategoryRepository.findAll();
        return all.stream()
                .map(this::subcategoryDTO)
                .collect(Collectors.toList());
    }


    List<SubcategoryDTO> getSubcategory(Long categoryId) {
        Optional<Category> id = categoryRepository.findById(categoryId);
        List<Subcategory> allSubcategories = subcategoryRepository.findAllByCategory(id.get());
        List<SubcategoryDTO> allSubcategoriesDTO = new ArrayList<>();

        for (Subcategory subcategory : allSubcategories) {
            SubcategoryDTO subcategoryDTO = subcategoryDTO(subcategory);
            allSubcategoriesDTO.add(subcategoryDTO);
        }
        return allSubcategoriesDTO;
    }
}
