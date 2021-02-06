package com.example.demo.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

 interface CategoryRepository extends JpaRepository<Category, Long> {
 Optional<Category> findCategoryByName(String name);
}