package com.example.demo.mail;

import com.example.demo.category.CourseFacade;

import java.util.List;
import java.util.stream.Collectors;

public class MailService {
    private final CourseFacade courseFacade;

    private final MailSender mailSender;

    public MailService(CourseFacade courseFacade, MailSender mailSender) {
        this.courseFacade = courseFacade;
        this.mailSender = mailSender;
    }

    public void send(String address, List<Long> ids) {
        String mailContent = ids.stream()
                .map(id -> courseFacade.getCoursesRepository(id))
                .filter(item -> item.isPresent())
                .map(item -> item.get())
                .map(item -> item.getName() + " " + item.getDescription())
                .collect(Collectors.joining("\n"));
        mailSender.send(address, "INQOO - courses offer", mailContent);
    }
}