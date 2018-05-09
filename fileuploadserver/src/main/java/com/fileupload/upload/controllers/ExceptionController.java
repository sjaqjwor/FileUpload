package com.fileupload.upload.controllers;

import com.fileupload.upload.exceptions.FileExtenstionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(FileExtenstionException.class)
    public ResponseEntity<?> fileExtentionException(FileExtenstionException fee){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
