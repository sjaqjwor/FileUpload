package com.fileupload.upload.services;

import com.fileupload.upload.exceptions.FileExtenstionException;
import com.fileupload.upload.utils.CheckExtention;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class FileUploadService {

    @Value("${dir}")
    private String dir;

    public void fileUpload(MultipartFile[] multipartFile) throws IOException{

        File file = new File(dir);
        if(!file.exists()){
            //상위 폴더 없으면 안만들어짐
            //file.mkdir();
            file.mkdirs();
        }

        for(MultipartFile m : multipartFile){
            if(!CheckExtention.check(m)){
                throw new FileExtenstionException();
            }
        }
        for(MultipartFile m : multipartFile){
                byte[] bytes = m.getBytes();
                String filePath = dir+"/"+m.getOriginalFilename();
                Path path = Paths.get(filePath);
                Files.write(path,bytes);

        }

    }
}
