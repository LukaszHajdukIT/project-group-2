package com.example.demo.categories;

import org.springframework.data.jpa.repository.JpaRepository;

 interface CategoryRepository extends JpaRepository<Category, Long> {
}
