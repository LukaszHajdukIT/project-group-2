package com.example.demo.coursers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

 interface CoursesRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByName(String name);
}
