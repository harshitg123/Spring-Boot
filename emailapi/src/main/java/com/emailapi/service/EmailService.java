package com.emailapi.service;

import java.io.File;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Service
public class EmailService {

    public boolean sendEmail(String to, String subject, String message) {

        // Dotenv dotenv = Dotenv.load();

        // String from = dotenv.get("EMAIL_FROM");
        // String emailPwd = dotenv.get("EMAIL_PWD");

        String from = System.getProperty("EMAIL_FROM");
        String emailPwd = System.getProperty("EMAIL_PWD");

        System.out.println();

        // return sendEmailText(from, to, subject, message, emailPwd);
        return sendEmailAttachment(from, to, subject, message, emailPwd);

    }

    private boolean sendEmailText(String from, String to, String subject, String message, String emailPwd) {
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

    private boolean sendEmailAttachment(String from, String to, String subject, String message, String emailPwd) {
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

            // sending file
            try {
                File file = new ClassPathResource("/static/img/default.png").getFile();

                MimeMultipart mimeMultipart = new MimeMultipart();

                MimeBodyPart textMime = new MimeBodyPart();
                MimeBodyPart fileMime = new MimeBodyPart();

                textMime.setText(message);
                fileMime.attachFile(file);

                mimeMultipart.addBodyPart(fileMime);
                mimeMultipart.addBodyPart(textMime);

                m.setContent(mimeMultipart);

                // Step 5: Send message using Transport.send()
                Transport.send(m);

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
