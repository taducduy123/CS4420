package com.example.trainingcentermanagement.Services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailService {

    private final String username = "trainingcentermanagementsystem@gmail.com";       // pw: project123456789
    private final String password = "xsvj vbnu kuwe kzwx";
    private final Properties prop;
    private final ExecutorService executor;

    public MailService(String host) {
        prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.ssl.trust", host);

        this.executor = Executors.newSingleThreadExecutor();
    }

    public void sendMail(Map<String, String> emailMessages, String subject) {
        String from = username;
        executor.submit(() -> {
            try {
                Session session = Session.getInstance(prop, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                for (Map.Entry<String, String> entry : emailMessages.entrySet()) {
                    String email = entry.getKey();
                    String msg = entry.getValue();

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

                    message.setSubject(subject);

                    MimeBodyPart mimeBodyPart = new MimeBodyPart();
                    mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(mimeBodyPart);

                    message.setContent(multipart);

                    Transport.send(message);
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) {
        MailService mailService = new MailService("smtp.gmail.com");
        mailService.sendMail(Map.of("taducduy2003@gmail.com", String.format("Hello <b>%s</b>," +
                " your new password is <b>%s</b> and username is <b>%s</b>," +
                " please change after login", "1", "2", "3")), "êsst");

    }


}