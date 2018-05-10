package com.fileupload.upload.utils;

import com.fileupload.upload.exceptions.FileExtentionException;
import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public class CheckExtention {

    public static void check(MultipartFile multipartFile) throws IOException{

        Optional.ofNullable(multipartFile).
                orElseThrow(FileExtentionException::new);

        Tika t = new Tika();

        String mimeType= t.detect(multipartFile.getInputStream());
        
        if(!mimeType.split("/")[1].equals("jpeg")) throw new FileExtentionException();
    }
}
