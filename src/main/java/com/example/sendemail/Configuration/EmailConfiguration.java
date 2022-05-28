package com.example.sendemail.Configuration;

import com.example.sendemail.Models.Email;
import com.example.sendemail.Services.Crud.CrudEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Configuration
public class EmailConfiguration {


    @Autowired
    private CrudEmailService crudEmailService;

    private  Properties properties;

    private  Session session;

    public  Email email;

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Properties getProperties(){
        if (properties==null){
            if (email==null)
                email=crudEmailService.getFirstEmail();
            setProperties();
        }


        return properties;
    }


    public  Session getSession(){
        if (session==null){
            getProperties();
            setSession();
        }

        return session;
    }

    public  void setSession() {
        session= Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getUsername(), email.getPassword());
            }
        });
    }
    public  void setProperties(){

        properties = new Properties();
        properties.setProperty("mail.smtp.host", email.getServerAddress());
        properties.setProperty("mail.smtp.port", email.getServerPort());
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        if (email.getProtocol().equals("SSL"))
            properties.setProperty("mail.smtp.ssl.enable", "true");
        else
            properties.setProperty("mail.smtp.ssl.enable", "false");

    }

}
