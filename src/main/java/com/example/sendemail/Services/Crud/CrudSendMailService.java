package com.example.sendemail.Services.Crud;

import com.example.sendemail.DTO.SendMailDTO;
import com.example.sendemail.Services.Core.CoreSendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudSendMailService {

    @Autowired
    private CoreSendMailService coreSendMailService;


    public SendMailDTO sendMail(SendMailDTO sendMailDTO) throws Exception {
        return coreSendMailService.SendMail(sendMailDTO);
    }
}
