package com.example.backend_final_project.Utils;

import com.example.backend_final_project.config.MailConfig;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Service
public class MailSender {
    List<MimeMessage> queue = new ArrayList<>();

    public void sendMail(MimeMessage message) throws AddressException, MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;

        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);


        // Step3: Send mail
        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public void sendText(String receiver, String subject, String text) throws AddressException, MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;

        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
         mailMessage = new MimeMessage(getMailSession);

        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        queue.add(mailMessage);
    }
    @Scheduled(fixedDelay = 1000)
    public void run(){
        int success = 0, error = 0;
        while (!queue.isEmpty()){
            MimeMessage message = queue.remove(0);
            try {
                sendMail(message);
                success++;
            } catch (Exception e){
                error++;
            }
        }
//        System.out.printf(">>Sent: %d, Error: %d\r\n", success,error);
    }
}