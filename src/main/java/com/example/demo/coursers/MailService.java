package com.example.demo.coursers;

import com.example.demo.coursers.CoursesRepository;

class MailService {
    private final CoursesRepository coursesRepository;

    MailService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }
}
