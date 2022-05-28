package com.example.sendemail.Services.Core;

import com.example.sendemail.Models.Email;
import com.example.sendemail.Repositorys.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoreEmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Email addEmail(Email sendEmail) throws Exception {
        if (searchEmail(sendEmail.getUsername())!=null)
            throw new Exception("The email With This username Exist");

        emailRepository.save(sendEmail);
        return sendEmail;
    }

    public Email deleteEmail(Long id) throws Exception {
        Email sendEmail= getEmail(id);

        emailRepository.delete(sendEmail);

        return sendEmail;

    }

    public Email updateEmail(Email sendEmail , Long id) throws Exception {

        getEmail(id);

        if (searchEmail(sendEmail.getUsername())!=null)
            if (!searchEmail(sendEmail.getUsername()).getId().equals(id))
                throw new Exception("The email With This username Exist");

        sendEmail.setId(id);

        emailRepository.save(sendEmail);

        return sendEmail;

    }

    public Email searchEmail(String username){
      return emailRepository.findByUsername(username);
    }

    public Email getEmail(Long id) throws Exception {
        Optional<Email> sendEmail = emailRepository.findById(id);
        if (sendEmail.isEmpty())
            throw new Exception("The email With This id not Exist");
        return sendEmail.get();
    }

    public List<Email> getAllEmail(){
        return emailRepository.findAll();
    }
}
