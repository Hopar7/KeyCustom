package com.ho.edcustom.controller;


import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuthException;
import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.enumSet.ErrorCode;
import com.ho.edcustom.service.FireBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequiredArgsConstructor
public class FireBaseController {
    private final FireBaseService fireBaseService;
    @PostMapping(value ="/uploadprofile" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HttpResponse> uploadProfile (@RequestParam("file")MultipartFile file, String nameFile)
    throws IOException, FirebaseAuthException{
        if (file.isEmpty()){
            HttpResponse Response =new HttpResponse(HttpStatus.NOT_FOUND, ErrorCode.NOT_FOUND, null);
            new ResponseEntity<>(Response,Response.getStatus());
        }
//        InputStream is =file.getInputStream();
//        byte[] buf = new byte[is.available()];
//        int read = is.read(buf);
//        String sss = new String(buf,0,read);
        ////
//        System.out.println("-------------");
//        System.out.println(sss);
//        System.out.println("-------------");
        ////
        HttpResponse Response = fireBaseService.uploadProfile(file,nameFile);

        return new ResponseEntity<>(Response,Response.getStatus());
    }
    @PostMapping(value ="/uploaditem" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HttpResponse> uploadItem (@RequestParam("file")MultipartFile file,String nameFile)
            throws IOException, FirebaseAuthException{
        if (file.isEmpty()){
            HttpResponse Response =new HttpResponse(HttpStatus.NOT_FOUND, ErrorCode.NOT_FOUND, null);
            new ResponseEntity<>(Response,Response.getStatus());
        }
        HttpResponse Response =fireBaseService.uploadItem(file,nameFile);
        return new ResponseEntity<>(Response,Response.getStatus());
    }
}
