package com.example.sendemail.Services.Crud;

import com.example.sendemail.DTO.EmailDTO;
import com.example.sendemail.Models.Email;
import com.example.sendemail.Services.Core.CoreEmailService;
import com.example.sendemail.Services.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudEmailService {

    @Autowired
    private CoreEmailService coreEmailService;

    @Autowired
    private Mapper mapper;

    public EmailDTO addEmail(EmailDTO sendEmailDTO) throws Exception {
        Email sendEmail =fromDto(sendEmailDTO);
        return toDto(coreEmailService.addEmail(sendEmail));
    }

    public EmailDTO deleteEmail(Long id) throws Exception {

       return toDto(coreEmailService.deleteEmail(id));

    }

    public EmailDTO updateEmail(EmailDTO sendEmailDTO , Long id) throws Exception {
        Email sendEmail =fromDto(sendEmailDTO);
        return toDto(coreEmailService.updateEmail(sendEmail,id));
    }

    public EmailDTO getEmail(Long id) throws Exception {
        return toDto(coreEmailService.getEmail(id));
    }

    public Email getFirstEmail(){
       return coreEmailService.getAllEmail().get(0);
    }

    public EmailDTO toDto(Email sendEmail){
        return mapper.map(sendEmail, EmailDTO.class);
    }

    public Email fromDto(EmailDTO sendEmailDTO){
        return mapper.map(sendEmailDTO, Email.class);
    }
}
