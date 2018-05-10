package com.fileupload.upload.controllers;

import com.fileupload.upload.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;

@RestController
@RequestMapping("file")
public class FIleUploadController {

    @Autowired
    private FileUploadService fileUploadService;


    @PostMapping("/upload")
    public ResponseEntity<?> fileUpload(MultipartFile multipartFile,MultipartFile m) throws IOException{
        fileUploadService.fileUpload(new MultipartFile[]{multipartFile,m});
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
