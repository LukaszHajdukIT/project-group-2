package com.example.demo.category;

import com.example.demo.mail.MailSender;
import com.example.demo.mail.MailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
  class CourseConfig {
    @Bean
    CourseService courseService(CoursesRepository coursesRepository, SubcategoryRepository subcategoryRepository){
        return new CourseService(coursesRepository, subcategoryRepository);
    }

    @Bean
    MailService mailService (DefaultCourseFacade courseFacade, MailSender mailSender) {
        return new MailService(courseFacade, mailSender);
    }
}