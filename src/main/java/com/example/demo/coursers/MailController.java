package com.example.demo.coursers;

import com.example.demo.coursers.MailService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController()
class MailController {
    private final MailService mailService;

    private MailController(MailService mailService) {
        this.mailService = mailService;
    }
}
