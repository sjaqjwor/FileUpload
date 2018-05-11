//package com.fileupload.upload.configs;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//
//@Component
//public class CustomContainer implements EmbeddedServletContainerCustomizer {
//
//    @Value("${dir}")
//    private String dir;
//
//    @Override
//    public void customize(ConfigurableEmbeddedServletContainer container) {
//        File file = new File(System.getProperty("user.home")+dir);
//        if(!file.exists()){
//            file.mkdirs();
//        }
//        container.setDocumentRoot(new File(System.getProperty("user.home")+dir));
//    }
//}
