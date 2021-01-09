package com.example.demo.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface CategoryRepository extends JpaRepository<Category, Long> {
 List<Category> findCategoryByName(String name);
}
