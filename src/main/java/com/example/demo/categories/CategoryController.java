package com.example.demo.categories;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/category")
 class CategoryController {

    private final CategoryService categoryService;

    private CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    void addCourseCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.addCourseCategory(categoryDTO);
    }
}
