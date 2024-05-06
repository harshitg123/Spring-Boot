package com.emailapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emailapi.Model.Email;
import com.emailapi.service.EmailService;
import com.emailapi.service.EmailServiceStarter;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    // New way of email
    @Autowired
    private EmailServiceStarter emailServiceStarter;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> getMethodName(@RequestBody Email email) {
        boolean status = emailService.sendEmail(email.getTo(), email.getSubject(), email.getMessage());

        if (status) {
            return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully!");
        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    // Create new API uding the latest method uring spring boot starter dependency

    @PostMapping("/send-email-new")
    public ResponseEntity<String> postMethodName(@RequestBody Email email) {

        System.out.println(email);

        boolean status = emailServiceStarter.sendEmail(email.getTo(), email.getSubject(), email.getMessage());
        if (status) {
            return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully!");
        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

}
