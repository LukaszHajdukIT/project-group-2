package com.example.demo.category;

import com.example.demo.models.Course;
import com.example.demo.models.Subcategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

 interface CoursesRepository extends Repository<Course, Long> {
    List<Course> findCourseByName(String name);

    @Query("select c from Course c where c.subcategory = :subcategory")
     List<Course> findAllBySubcategory(@Param("subcategory") Subcategory subcategory);

    Course save(Course course);

    List <Course> findAll();

    Optional<Course> findById(Long id);
}