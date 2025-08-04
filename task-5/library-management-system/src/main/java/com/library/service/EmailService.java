// EmailService.java placeholder
package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendQueryEmail(String userEmail, String query) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@gmail.com");
        message.setTo("library-admin@gmail.com");
        message.setSubject("User Query from " + userEmail);
        message.setText(query);
        mailSender.send(message);
    }
}