package com.example.demo.category;

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

    @GetMapping
    private List<SubcategoryDTO> getSubcategory(){
        return subcategoryService.getSubcategory();
    }

    @GetMapping("/{paramCategoryId}")
    private List<SubcategoryDTO> getSubcategoryByCategory(@PathVariable("paramCategoryId") Long categoryId){
        return subcategoryService.getSubcategory(categoryId);
    }
}
