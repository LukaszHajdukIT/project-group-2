package com.example.demo.coursers;

import com.example.demo.courses.subcategory.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByName(String name);

    @Query("select c from Course c where c.subcategory = :subcategory")
     List<Course> findAllBySubcategory(@Param("subcategory") Subcategory subcategory);
 }
