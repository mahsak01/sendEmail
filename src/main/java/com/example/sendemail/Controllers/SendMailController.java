package com.example.sendemail.Controllers;

import com.example.sendemail.Controllers.Models.ResponseModels;
import com.example.sendemail.Controllers.Models.Status;
import com.example.sendemail.DTO.SendMailDTO;
import com.example.sendemail.Services.Crud.CrudSendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/sendEmail")
public class SendMailController {


    @Autowired
    private CrudSendMailService crudSendMailService;



    @PostMapping
    public ResponseEntity<Object> addEmail(@Valid @RequestBody SendMailDTO SendMailDTO) throws Exception {
        ResponseModels responseModels = new ResponseModels();
        responseModels.setData(crudSendMailService.sendMail(SendMailDTO));
        responseModels.setStatus(Status.SUCCESS);
        responseModels.setMessage("send email successfully");
        return ResponseEntity.status(HttpStatus.FOUND).body(responseModels);
    }

}
