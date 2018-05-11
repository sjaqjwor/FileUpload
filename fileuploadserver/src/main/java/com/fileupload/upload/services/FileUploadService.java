package com.fileupload.upload.services;

import com.fileupload.upload.utils.CheckExtention;
import com.fileupload.upload.utils.ImageHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Service
public class FileUploadService {

    @Value("${image.dir}")
    private String dir;



    public void fileUpload(MultipartFile[] multipartFile,String id,String k) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {

        String hash = new ImageHash().createHash(id);

        File file = new File(dir+"/"+id+"/"+k);
        if(!file.exists()){
            file.mkdirs();
        }
        for(MultipartFile m : multipartFile){
            CheckExtention.check(m);
        }
        for(MultipartFile m : multipartFile){
                byte[] bytes = m.getBytes();
                String extention = parseExtention(m.getOriginalFilename());
                String filePath = dir+"/"+id+"/"+k+"/"+hash+extention;
                Path path = Paths.get(filePath);
                Files.write(path,bytes);

        }
    }
    private String parseExtention(String file){
        return file.substring(file.lastIndexOf("."));
    }
}
