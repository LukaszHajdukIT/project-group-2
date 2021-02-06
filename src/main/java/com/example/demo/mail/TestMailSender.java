package com.example.demo.mail;

import com.example.demo.mail.MailSender;

public class TestMailSender implements MailSender {
    private String address;
    private String subject;
    private String content;

    @Override
    public void send(String address, String subject, String content) {
        this.address = address;
        this.subject = subject;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

