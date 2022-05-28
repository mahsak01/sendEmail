package com.example.sendemail.DTO;



import javax.validation.constraints.NotEmpty;


public class EmailDTO {

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

    public EmailDTO() {
    }

    public EmailDTO(String serverAddress, String serverPort, String username, String password, String protocol) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.username = username;
        this.password = password;
        this.protocol = protocol;
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
