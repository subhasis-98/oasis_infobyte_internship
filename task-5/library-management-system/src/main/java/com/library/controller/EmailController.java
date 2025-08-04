// EmailController.java placeholder
package com.library.controller;

import com.library.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/query")
    public void sendQuery(@RequestParam String userEmail, @RequestParam String query) {
        emailService.sendQueryEmail(userEmail, query);
    }
}