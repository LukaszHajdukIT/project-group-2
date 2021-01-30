package com.example.demo.coursers;

import com.example.demo.mail.MailSender;

import java.util.List;
import java.util.stream.Collectors;

class MailService {
    private final CoursesRepository coursesRepository;

    private final MailSender mailSender;

    MailService(CoursesRepository coursesRepository, MailSender mailSender) {
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
