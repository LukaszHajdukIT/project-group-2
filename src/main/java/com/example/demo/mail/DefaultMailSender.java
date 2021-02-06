package com.example.demo.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

 class DefaultMailSender implements MailSender{
    private final JavaMailSender emailSender;

     DefaultMailSender(JavaMailSender mailSender) {
        this.emailSender = mailSender;
    }

    @Override
    public void send(String address, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(address);
        message.setSubject(subject);
        message.setText(content);
        emailSender.send(message);
    }
}