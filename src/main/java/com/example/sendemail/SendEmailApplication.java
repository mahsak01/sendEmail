package com.example.sendemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class SendEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendEmailApplication.class, args);
    }

}
