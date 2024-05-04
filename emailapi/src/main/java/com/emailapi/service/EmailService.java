package com.emailapi.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    public boolean sendEmail() {

        Dotenv dotenv = Dotenv.load();

        String from = dotenv.get("EMAIL_FROM");
        String to = dotenv.get("EMAIL_TO");
        String subject = "Testing email - Email API";
        String message = "This is the testing email from email api";
        String emailPwd = dotenv.get("EMAIL_PWD");

        // Step 1: gmail host
        String gmailHost = "smtp.gmail.com";

        // Step 2: Get system properties
        Properties systemProps = System.getProperties();

        System.out.println(systemProps);

        // Set important infro to properties obj
        systemProps.put("mail.smtp.host", gmailHost);
        systemProps.put("mail.smtp.port", 465);
        systemProps.put("mail.smtp.ssl.enable", "true");
        systemProps.put("mail.smtp.auth", "true");

        // Step 3: get the session

        Session session = Session.getInstance(systemProps, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, emailPwd);
            }

        });

        session.setDebug(true);

        // Step 4: Compose email (text, multimedia)

        MimeMessage m = new MimeMessage(session);

        try {
            m.setFrom(from);

            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            m.setSubject(subject);

            m.setText(message);

            // Step 5: Send message using Transport.send()
            Transport.send(m);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

    }
}
