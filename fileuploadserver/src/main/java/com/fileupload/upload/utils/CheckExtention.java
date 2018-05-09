package com.fileupload.upload.utils;

import com.fileupload.upload.exceptions.FileExtenstionException;
import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class CheckExtention {
    public static boolean check(MultipartFile multipartFile) throws IOException{
        Tika t = new Tika();
        String mimeType= t.detect(multipartFile.getInputStream());
        if(mimeType.split("/")[1].equals("jpeg")){
            return true;
        }else{
            throw new FileExtenstionException();
        }
    }
}
