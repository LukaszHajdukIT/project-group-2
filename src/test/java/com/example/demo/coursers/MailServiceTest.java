package com.example.demo.coursers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailServiceTest {
    MailService mailService = new MailService((new CoursesRepositoryInMemory()));
}