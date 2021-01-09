package com.example.demo.courses.subcategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    List<Subcategory> findSubcategoryByName(String name);
}
