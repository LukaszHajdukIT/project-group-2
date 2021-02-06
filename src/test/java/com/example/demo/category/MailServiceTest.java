package com.example.demo.category;

import com.example.demo.models.Category;
import com.example.demo.models.Course;
import com.example.demo.mail.MailService;
import com.example.demo.mail.TestMailSender;
import com.example.demo.models.Subcategory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MailServiceTest {
    private TestMailSender mailSender = new TestMailSender();

    private CoursesRepositoryInMemory coursesRepositoryInMemory = new CoursesRepositoryInMemory();

    private CourseFacade courseFacade = new InMemoryCourseFacade(coursesRepositoryInMemory);

    MailService mailService = new MailService(courseFacade, mailSender);

    @Test
    public void shouldPrepareMailWithCorrectData() {
        //given
        String address = "mail@mail.com";
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);

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