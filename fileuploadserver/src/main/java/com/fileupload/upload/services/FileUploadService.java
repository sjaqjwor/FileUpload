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



    public void fileUpload(MultipartFile[] multipartFile,String uid,String webtoonId) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {

        String hash = new ImageHash().createHash(uid);

        File file = new File(getPath(uid, webtoonId));
        if(!file.exists()){
            file.mkdirs();
        }
        for(MultipartFile m : multipartFile){
            CheckExtention.check(m);
        }
        int number=0;
        for(MultipartFile m : multipartFile){
                byte[] bytes = m.getBytes();
                String extention = parseExtention(m.getOriginalFilename());
                String filePath = getPath(uid, webtoonId)+hash+"_"+number+extention;
                Path path = Paths.get(filePath);
                Files.write(path,bytes);
                number++;
        }
    }
    private String parseExtention(String file){
        return file.substring(file.lastIndexOf("."));
    }
    private String getPath(String uid, String webtoonId){
        return dir+uid+"/"+webtoonId+"/";
    }
}
