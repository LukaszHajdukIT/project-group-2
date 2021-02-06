package com.example.demo.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    Optional<Subcategory> findSubcategoryByName(String name);

    @Query("select s from Subcategory s where s.category = :category")
    List<Subcategory> findAllByCategory (@Param("category")Category category);
}
