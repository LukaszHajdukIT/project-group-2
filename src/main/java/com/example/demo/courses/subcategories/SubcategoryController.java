package com.example.demo.courses.subcategories;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    public void addSubcategory(@RequestBody SubcategoryDTO subcategoryDTO) {
        subcategoryService.addSubcourseCategory(subcategoryDTO);
    }
}
