package com.example.demo.mail;

import com.example.demo.category.CoursesRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MailService {
    private final CoursesRepository coursesRepository;

    private final MailSender mailSender;

   public MailService(CoursesRepository coursesRepository, MailSender mailSender) {
        this.coursesRepository = coursesRepository;
        this.mailSender = mailSender;
    }

    public void send(String address, List<Long> ids) {
        String mailContent = ids.stream()
                .map(id -> coursesRepository.findById(id))
                .filter(item -> item.isPresent())
                .map(item -> item.get())
                .map(item -> item.getName() + " " + item.getDescription())
                .collect(Collectors.joining("\n"));
        mailSender.send(address, "subject", mailContent);
    }
}
