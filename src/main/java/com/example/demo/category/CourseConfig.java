package com.example.demo.category;

import com.example.demo.mail.MailSender;
import com.example.demo.mail.MailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 public class CourseConfig {
    @Bean
    CourseService courseService(CoursesRepository coursesRepository, SubcategoryRepository subcategoryRepository){
        return new CourseService(coursesRepository, subcategoryRepository);
    }

    @Bean
    MailService mailService (CoursesRepository coursesRepository, MailSender mailSender) {
        return new MailService(coursesRepository, mailSender);
    }
}
