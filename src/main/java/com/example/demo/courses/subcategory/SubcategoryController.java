package com.example.demo.courses.subcategory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

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
}
