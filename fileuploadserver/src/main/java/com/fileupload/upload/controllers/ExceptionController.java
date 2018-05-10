package com.fileupload.upload.controllers;

import com.fileupload.upload.exceptions.FileEmptyException;
import com.fileupload.upload.exceptions.FileExtentionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(FileExtentionException.class)
    public ResponseEntity<?> fileExtentionException(FileExtentionException fee){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileEmptyException.class)
    public ResponseEntity<?> fileEmptyException(FileExtentionException fee){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
