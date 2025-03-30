package com.ho.edcustom.controller;


import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuthException;
import com.ho.edcustom.service.FireBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FireBaseController {
    private final FireBaseService fireBaseService;
    @PostMapping("/upload")
    public String uploadFile (@RequestParam("file")MultipartFile file,String nameFile)
    throws IOException, FirebaseAuthException{
        if (file.isEmpty()){
            return "is empty";
        }
        return fireBaseService.uploadFiles(file,nameFile);
    }
}
