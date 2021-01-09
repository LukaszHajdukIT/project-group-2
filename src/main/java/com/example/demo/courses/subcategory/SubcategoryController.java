package com.example.demo.courses.subcategory;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/subcategory")
class SubcategoryController {

    private final SubcategoryService subcategoryService;

    private SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    void addSubcategory(@RequestBody SubcategoryDTO subcategoryDTO) {
        subcategoryService.addSubcourseCategory(subcategoryDTO);
    }

    @GetMapping
    private List<SubcategoryDTO> getSubcategory(){
        return subcategoryService.getSubcategory();
    }
}
