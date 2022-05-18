package com.heydie.userapi.controller;


import com.heydie.userapi.dto.ResponseDto;
import com.heydie.userapi.entity.OfficeKandidat;
import com.heydie.userapi.entity.UserKandidat;
import com.heydie.userapi.service.OfficeKandidatService;
import com.heydie.userapi.service.UserKandidatService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/user")
public class UserOfficeKandidatController {

    private static Logger log = LoggerFactory.getLogger(UserOfficeKandidatController.class);

    @Autowired
    private UserKandidatService userKandidatService;

    @Autowired
    private OfficeKandidatService officeKandidatService;


    @PostMapping(value = "/userkandidat", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto<UserKandidat>> create(@Valid @RequestBody UserKandidat userKandidat, Errors errors) throws IOException {
        URL url = new URL("https://hookb.in/zrLlXM6NwYfgm6kn8PJP");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST");
        http.setDoOutput(true);

        ResponseDto<UserKandidat> responseDto = new ResponseDto<>();
        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseDto.getMessage().add(error.getDefaultMessage());
            }
            responseDto.setSuccess(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
        userKandidatService.create(userKandidat);
        String asString = "{\"name\":\""+userKandidat.getName()
                +"\",\"address\":\""+userKandidat.getAddress()
                +"\",\"email\":\""+userKandidat.getEmail()+"\"}";
        byte[] out = asString.getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        responseDto.setSuccess(true);
        responseDto.getMessage().add("Success");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

    }


    @PostMapping(value = "/officekandidat", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto<OfficeKandidat>> create(@Valid @RequestBody OfficeKandidat officeKandidat, Errors errors)throws IOException {
        URL url = new URL("https://hookb.in/zrLlXM6NwYfgm6kn8PJP");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        ResponseDto<OfficeKandidat> responseDto = new ResponseDto<>();
        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseDto.getMessage().add(error.getDefaultMessage());
            }
            responseDto.setSuccess(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
        officeKandidatService.create(officeKandidat);
        String asString = "{\"nid\":\""+officeKandidat.getNid()
                +"\",\"officeId\":\""+officeKandidat.getOfficeId()+"\"}";

        byte[] out = asString.getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
        responseDto.setSuccess(true);
        responseDto.getMessage().add("Success");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

    }


}
