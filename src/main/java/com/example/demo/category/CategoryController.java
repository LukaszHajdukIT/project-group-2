package com.example.demo.category;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/category")
 class CategoryController {

    private final CategoryService categoryService;

    private CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    void addCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.addCourseCategory(categoryDTO);
    }

    @GetMapping
    private List<CategoryDTO> getCategory(){
        return categoryService.getCategory();
    }
}

