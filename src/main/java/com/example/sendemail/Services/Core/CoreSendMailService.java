package com.example.sendemail.Services.Core;

import com.example.sendemail.Configuration.EmailConfiguration;
import com.example.sendemail.DTO.SendMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class CoreSendMailService {

    @Autowired
    private EmailConfiguration emailConfiguration;

    private Session session;



    public SendMailDTO SendMail(SendMailDTO sendMailDTO) throws Exception {

        session=emailConfiguration.getSession();

        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(emailConfiguration.email.getUsername(),"mahsa"));

        // Set To: header field of the header.
        message.addRecipients(Message.RecipientType.TO, sendMailDTO.getRecipient());

        // Set Subject: header field
        message.setSubject(sendMailDTO.getSubject());

        // Now set the actual message
        message.setText(sendMailDTO.getMessage());

        // Send message
        sendMessage(message);

        return sendMailDTO;
    }

    public void sendMessage(MimeMessage message) throws Exception {
        try {
            Transport transport = session.getTransport("smtp");
            transport.connect(emailConfiguration.email.getServerAddress(), emailConfiguration.email.getUsername()
                    , emailConfiguration.email.getPassword());
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            System.out.println(e);
            throw new Exception("mail service settings are invalid");
        }

    }
}
