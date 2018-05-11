package com.fileupload.upload.controllers;

import com.fileupload.upload.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@CrossOrigin
@RestController
@RequestMapping("file")
public class FIleUploadController {

    @Autowired
    private FileUploadService fileUploadService;


    @PostMapping("/upload")
    public ResponseEntity<?> fileUpload(
            @RequestParam(name = "files") MultipartFile[] multipartFile,@RequestParam(name = "userId") String uid,
            @RequestParam(name = "webtoonId") String webtoonId) throws IOException,NoSuchAlgorithmException,InvalidKeySpecException {

        fileUploadService.fileUpload(multipartFile,uid,webtoonId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
