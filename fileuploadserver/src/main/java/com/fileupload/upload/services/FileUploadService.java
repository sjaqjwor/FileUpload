package com.fileupload.upload.services;

import com.fileupload.upload.utils.CheckExtention;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    @Value("${dir}")
    private String dir;

    public void fileUpload(MultipartFile[] multipartFile) throws IOException{


        for(MultipartFile m : multipartFile){
            CheckExtention.check(m);
        }
        for(MultipartFile m : multipartFile){
                byte[] bytes = m.getBytes();
                String filePath = System.getProperty("user.home")+dir+"/"+m.getOriginalFilename();
                Path path = Paths.get(filePath);
                Files.write(path,bytes);

        }

    }
}
