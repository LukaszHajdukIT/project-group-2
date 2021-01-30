package com.example.demo.coursers;

import com.example.demo.courses.subcategory.Subcategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CoursesRepositoryInMemory implements CoursesRepository {

    private final Map <Long, Course> courses = new ConcurrentHashMap<>();
    @Override
    public List<Course> findCourseByName(String name) {
        return courses.values().stream()
                .filter(course -> course.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> findAllBySubcategory(Subcategory subcategory) {
        return courses.values().stream()
                .filter(course -> subcategory.getName().equals(course.getSubcategory().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Course save(Course course) {
        long elementsCount = courses.size();
                courses.put(elementsCount,course);
        return course;
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }
}
