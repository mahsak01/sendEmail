package com.example.sendemail.Controllers;

import com.example.sendemail.Controllers.Models.ResponseModels;
import com.example.sendemail.Controllers.Models.Status;
import com.example.sendemail.DTO.EmailDTO;
import com.example.sendemail.Services.Crud.CrudEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/email")
public class EmailController {

    @Autowired
    private CrudEmailService crudEmailService;



    @PostMapping
    public ResponseEntity<Object> addEmail(@Valid @RequestBody EmailDTO sendEmailDTO) throws Exception {
        ResponseModels responseModels = new ResponseModels();
        responseModels.setData(crudEmailService.addEmail(sendEmailDTO));
        responseModels.setStatus(Status.SUCCESS);
        responseModels.setMessage("email successfully create");
        return ResponseEntity.status(HttpStatus.FOUND).body(responseModels);
    }

    @PutMapping("/{sendEmailId}")
    public ResponseEntity<Object> updateEmail(@PathVariable("sendEmailId") Long sendEmailId,
                                                @Valid @RequestBody EmailDTO sendEmailDTO) throws Exception {
        ResponseModels responseModels = new ResponseModels();
        responseModels.setData(crudEmailService.updateEmail(sendEmailDTO, sendEmailId));
        responseModels.setStatus(Status.SUCCESS);
        responseModels.setMessage("email successfully update");
        return ResponseEntity.status(HttpStatus.FOUND).body(responseModels);
    }

    @DeleteMapping("/{sendEmailId}")
    public ResponseEntity<Object> deleteEmail(@PathVariable("sendEmailId") Long sendEmailId) throws Exception {
        ResponseModels responseModels = new ResponseModels();
        crudEmailService.deleteEmail(sendEmailId);
        responseModels.setStatus(Status.SUCCESS);
        responseModels.setMessage("email successfully delete");
        return ResponseEntity.status(HttpStatus.FOUND).body(responseModels);
    }

    @GetMapping("/{sendEmailId}")
    public ResponseEntity<Object> getEmail(@PathVariable("sendEmailId") Long sendEmailId) throws Exception {

        ResponseModels responseModels = new ResponseModels();
        responseModels.setData(crudEmailService.getEmail(sendEmailId));
        responseModels.setStatus(Status.SUCCESS);
        responseModels.setMessage("get email successfully");
        return ResponseEntity.status(HttpStatus.FOUND).body(responseModels);
    }



}
