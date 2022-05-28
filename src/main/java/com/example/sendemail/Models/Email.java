package com.example.sendemail.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Email")
@Table(name = "Email")
public class Email {

    @Id
    @SequenceGenerator(
            name = "email_sequence",
            sequenceName = "email_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "email_sequence"
    )
    private Long id;

    @NotEmpty(message = "Please fill server Address")
    private String serverAddress;

    @NotEmpty(message = "Please fill server Port")
    private String serverPort;

    @NotEmpty(message = "Please fill username")
    private String username;

    @NotEmpty(message = "Please fill password")
    private String password;


    @NotEmpty(message = "Please fill protocol")
    private String protocol;

    public Email() {
    }

    public Email(String serverAddress, String serverPort, String username, String password, String protocol) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.username = username;
        this.password = password;
        this.protocol = protocol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}