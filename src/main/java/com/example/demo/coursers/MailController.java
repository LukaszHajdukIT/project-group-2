package com.example.demo.coursers;

import com.example.demo.coursers.MailService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController("/mail")
class MailController {
    private final MailService mailService;

    private MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
     void send(@RequestBody MailDTO mailDTO){
         mailService.send(mailDTO.getAddress(), mailDTO.getIds());
    }
}
