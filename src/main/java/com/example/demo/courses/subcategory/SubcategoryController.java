package com.example.demo.courses.subcategory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<Void> addSubcategory(@RequestBody SubcategoryDTO subcategoryDTO) {
      return subcategoryService.addCourseSubcategory(subcategoryDTO) ? new ResponseEntity<Void>(HttpStatus.OK) : new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @GetMapping("/{paramCategoryId}")
    private List<SubcategoryDTO> getSubcategory(@PathVariable("paramCategoryId") Long categoryId){
        return subcategoryService.getSubcategory(categoryId);
    }
}
