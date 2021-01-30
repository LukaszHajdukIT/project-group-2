package com.example.demo.coursers;

import com.example.demo.category.Category;
import com.example.demo.courses.subcategory.Subcategory;
import com.example.demo.mail.MailSender;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MailServiceTest {
    private TestMailSender mailSender = new TestMailSender();

    private CoursesRepositoryInMemory coursesRepositoryInMemory = new CoursesRepositoryInMemory();

    MailService mailService = new MailService(coursesRepositoryInMemory, mailSender);


    @Test
    public void shouldPrepareMailWithCorrectData() {
        //given
        String address = "mail@mail.com";
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);

        // TODO dodać 3 kursy
        Category it = new Category("nameIT", "descriptionIT");
        Subcategory java = new Subcategory("Java", "description", it);
        Course java2 = new Course("Java2", "Java2 description", 8, java);
        Course java3 = new Course("Java3", "Java3 description", 8, java);
        Course java4 = new Course("Java4", "Java4 description", 8, java);
        coursesRepositoryInMemory.save(java2);
        coursesRepositoryInMemory.save(java3);
        coursesRepositoryInMemory.save(java4);

        //when
        mailService.send(address, ids);
        //then
        assertThat(mailSender.getAddress()).isEqualTo(address);
        assertThat(mailSender.getSubject()).isEqualTo("subject");
        assertThat(mailSender.getContent()).contains(java3.getName());
        assertThat(mailSender.getContent()).contains(java3.getDescription());
        assertThat(mailSender.getContent()).contains(java4.getName());
        assertThat(mailSender.getContent()).contains(java4.getDescription());
    }
}