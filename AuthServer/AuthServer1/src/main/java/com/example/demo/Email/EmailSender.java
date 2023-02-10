package com.example.demo.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
public class EmailSender {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String text, String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("petdocmailsender@gmail.com");
        message.setTo(email);
        message.setSubject("Thank you for Register with PETDOC");
        message.setText(text);
        mailSender.send(message);
    }
}
