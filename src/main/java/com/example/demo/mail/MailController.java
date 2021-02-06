package com.example.demo.mail;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
class MailController {
    private final MailService mailService;

    private MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/mail")
     void send(@RequestBody MailDTO mailDTO){
         mailService.send(mailDTO.getAddress(), mailDTO.getIds());
    }
}