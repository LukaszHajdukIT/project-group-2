package com.example.demo.mail;

public interface MailSender {
    void send(String address, String subject, String content);
}