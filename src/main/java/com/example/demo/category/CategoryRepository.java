package com.example.demo.category;

import com.example.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

 interface CategoryRepository extends JpaRepository<Category, Long> {
 Optional<Category> findCategoryByName(String name);
}